package ApolloNew;

import com.thoughtworks.selenium.Selenium;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class UserCallLogs extends CommonFunctions {
	
	String table, tns[];
    String tlimit,username,pwd;
    int tncount;				
	
    String butnxpath="//html/body/section/div[5]/div[2]/div[4]/div[1]/div[2]/form/div/div[1]/div/div/div/label";
    String svexpath="div.col-16 > div.accordian-actions > button.btn.btn-primary";
    String TNxpath="//html/body/section/div[5]/div[2]/form/div[5]/label";
    String phoneline,phoneline_ac,Acccode;
	int rank[]= new int[50];
	

	int c_sequence;
	String name_for_rank[]= new String[40];
	String price, rank_channels;

	public UserCallLogs(String path) {
		this.path = path;
	}

	public UserCallLogs(String path, String file1, String file2) {
		this.path = path;
		this.path1 = file1;
		this.path2 = file2;
	}
	  	    
	  public void execute(String br, WebDriver driver, String url, int loc, String name1) throws Exception {
	
		  Feature_Name="CFNA";
		  int tlim=3;
		  String status1="",state = "Fail";
		  File data = new File(this.path);
		  WorkbookSettings ws = new WorkbookSettings();
		  ws.setLocale(new Locale("er", "ER"));
		  Workbook wb = Workbook.getWorkbook(data, ws);
		  try
		  {
			  Sheet sheet2 = wb.getSheet(0);
	          tlimit = sheet2.getCell(5, loc).getContents();
	          username = sheet2.getCell(6, loc).getContents();
	          pwd = sheet2.getCell(7, loc).getContents();
	          tlim = Integer.parseInt(tlimit);
	          wb.close();
	      
	          driver.manage().timeouts().implicitlyWait(tlim,TimeUnit.SECONDS);
	          logger.info("qtest1");
	          try {
	        	  if(first==0)
	              {
	            	  login(driver,username,pwd);
	              }
	              logger.info("a");
	              if(!(InternalException(driver,br)))
	              {
	              switchTo(driver, "Admin",tlim,br);    
	              focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]")),br);

	              logger.info("checkpoint1");
                  for(int i=1;i<20;i++){}
                  Acccode=driver.findElement(org.openqa.selenium.By.xpath("//html/body/section/section/div[1]/aside[1]/ul/li[1]/strong")).getText();
                  logger.info("Acccode"+Acccode);
                  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[4]")),br);

                 if(!(InternalException(driver,br)))
	              {
                	 focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature1 > div.accordian-header > h3.ng-binding")),br);
                  
                  boolean TnStatus= driver.findElement(By.id("check{\"name\":\"BasicCallLog_FeatureName\",\"value\":\"Call Logs\",\"parameters\":[],\"text\":\"Call Logs\",\"exampleText\":\"Call Logs\"}0")).isSelected();                                
                  logger.info("TnStatus"+TnStatus);
                  if(TnStatus==true)
                  {
                	  statusTracker(br,"","","The call logs feature is already Enabled in admin for "+driver.findElement(org.openqa.selenium.By.xpath(TNxpath)).getText(),""); 
                  }
                  else
                  {
                	  focusClick(driver,driver.findElement(By.xpath(TNxpath)),br);
                	  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/form/div[11]/button[2]")),br);
                                            
                      int chk=0;
                      do{
                          //logger.info("Processing!" +chk);
                          chk++;
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                      logger.info("Check123");
                      statusTracker(br,"","","The call logs feature is Enabled for "+driver.findElement(org.openqa.selenium.By.xpath(TNxpath)).getText(),"");                       
                  }
                  for(int j=1;j<10;j++){}
                  focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[1]/a")),br);

                  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[1]")),br);

                  if(driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/label/a")).isDisplayed())
                   {  
                	  logger.info("inside");
                	                  	  
                	  if(driver.findElement(By.xpath(".//*[@id='call-log-section']/div[2]")).getText().equals("There are no Call Logs to display at this time"))
                	   {
                		  logger.info("data"+driver.findElement(By.xpath("//html/body/section/section[3]/div[2]")).getText());                 	   
                   		  statusTracker(br,"","The All Call Type: ",driver.findElement(By.xpath("//html/body/section/section[3]/div[2]")).getText(),"");
                   	   }
                	  else
                	   {
                		  int size=driver.findElements(By.xpath("//html/body/section/section[3]/div[2]/div")).size();
                		  int jcnt=0;
                		  logger.info("size"+size);
                		  for(int i=1;i<=size;i++)
                		  {    ;              			                			  
                			  logger.info("data"+driver.findElement(By.xpath("//html/body/section/section[3]/div[2]/div["+i+"]")).getText().replaceAll("\n","").substring(5)); 
                			  statusTracker(br,"","The All Call Type: ",driver.findElement(By.xpath("//html/body/section/section[3]/div[2]/div["+i+"]")).getText().replaceAll("\n","").substring(5),"");
                			  if(i%10==0)
                			  {             
                				  logger.info("jcnt"+jcnt);
                				  //focusClick(driver,driver.findElement(By.xpath(".//*[@id='vmSection']/div[3]/div/ul/li["+(3+jcnt)+"]/span")),br);
                				  jcnt++;
                			  }
                		  }
                		  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[6]/div[2]/span/select/option[2]")),br);

                		  if(driver.findElement(By.xpath(".//*[@id='call-log-section']/div[2]")).getText().equals("There are no Call Logs to display at this time"))
                		  {                			  
                        		     statusTracker(br,"","The Received Call Type: ",driver.findElement(By.xpath("//html/body/section/section[3]/div[2]")).getText(),"");                        	       
                		  }
                		  else
                		  {                			                  		  
                		    int size1=driver.findElements(By.xpath("//html/body/section/section[3]/div[2]/div")).size();
                		    logger.info("size1"+size1);
                		    String Sta="";
                		    if(size1>1)
                   	       	  {
                		    	int jcnt1=0;
                   		        for(int j1=1;j1<=size1;j1++)
                   		         {                   		        	
                   		        	String a1=driver.findElement(By.xpath("//html/body/section/section[3]/div[2]/div["+j1+"]/div[1]")).getText();
                 		        	  a1=a1.replaceAll("\n", "");
                 		        	  logger.info("Text"+a1);
                   		    	    if(a1.equals("crossReceived"))
                   		    	     {
                   		    		 Sta="Pass";
                   		    	     }
                   		    	    else
                   		    	     {
                   		    		Sta="Fail";
                   		    		exit(0);
                   		    	     }
                   		    	 if(j1%10==0)
                   			     {               				  
                   		    		//focusClick(driver,driver.findElement(By.xpath("//html/body/section/section[3]/div[3]/div/ul/li["+(3+jcnt1)+"]/span")),br);
                   				  jcnt1++;
                   			     }
                   		         }
                   		    
                   		       if(Sta.equals("Pass"))
                   			      statusTracker(br,"Pass","Verify if the Received Call Type only displayed"+driver.findElement(By.xpath("//html/body/section/div[6]/div[2]/span/select/option[2]")).getText(),"Able to see only the Received Call Type","Should be able to see only the Received Call Type");   
                   		       else
                   		          statusTracker(br,"Fail","Verify if the Received Call Type only displayed"+driver.findElement(By.xpath("//html/body/section/div[6]/div[2]/span/select/option[2]")).getText(),"Not Able to see only the Received Call Type","Should be able to see only the Received Call Type");                      		    	
                	         }
                		  }
                   	      Thread.sleep(2000);            
                   	   focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[6]/div[2]/span/select/option[3]")),br);
                		  
                		  if(driver.findElement(By.xpath(".//*[@id='call-log-section']/div[2]")).getText().equals("There are no Call Logs to display at this time"))
                   	        {
                   		                   	   
                      		  statusTracker(br,"","The Missed Call Type: " ,driver.findElement(By.xpath("//html/body/section/section[3]/div[2]")).getText(),"");
                      	    }
                   	      else
                   	      {
                		     int size2=driver.findElements(By.xpath("//html/body/section/section[3]/div[2]/div")).size();
                		     logger.info("size2"+size2);
                		     String Sta1="";
                		     if(size2>1)
                   	          {
                		    	 int jcnt2=0;
                   		        for(int j2=1;j2<=size2;j2++)
                   		        {                           		        	
                   		        	  String a2=driver.findElement(By.xpath("//html/body/section/section[3]/div[2]/div["+j2+"]/div[1]")).getText();
                   		        	  a2=a2.replaceAll("\n", "");
                   		        	  logger.info("Text"+a2);
                   		        	
                   		    	    if(a2.equals("crossMissed"))
                   		    	    {
                   		    		 Sta1="Pass";
                   		    	    }
                   		    	    else
                   		    	    {
                   		    		Sta1="Fail";
                   		    		exit(0);
                   		    	    }
                   		    	    
                   		    	  if(j2%10==0)
                   			      {               				  
                   		    		//focusClick(driver,driver.findElement(By.xpath("//html/body/section/section[3]/div[3]/div/ul/li["+(3+jcnt2)+"]/span")),br);
                   				  jcnt2++;
                   			      }
                   		           
                   		          }
                   		    
                   		           if(Sta1.equals("Pass"))
                   			         statusTracker(br,"Pass","Verify if the Missed Call Type only displayed"+ driver.findElement(By.xpath("//html/body/section/div[6]/div[2]/span/select/option[3]")).getText(),"Able to see only the Missed Call Type","Should be able to see only the Missed Call Type");   
                   		           else
                   		             statusTracker(br,"Fail","Verify if the Missed Call Type only displayed"+ driver.findElement(By.xpath("//html/body/section/div[6]/div[2]/span/select/option[3]")).getText(),"Not Able to see only the Missed Call Type","Should be able to see only the Missed Call Type");                      		    	
                	           }
                   	      }
                		  Thread.sleep(2000);  
                		  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[6]/div[2]/span/select/option[4]")),br);
                		  if(driver.findElement(By.xpath(".//*[@id='call-log-section']/div[2]")).getText().equals("There are no Call Logs to display at this time"))
                 	        {
                 		                   	   
                    		  statusTracker(br,"","The Outgoing Call Type: ",driver.findElement(By.xpath("//html/body/section/section[3]/div[2]")).getText(),"");
                    	    }
                		  else
                		    {                			                 		  
                		     int size3=driver.findElements(By.xpath("//html/body/section/section[3]/div[2]/div")).size();
                		      String Sta2="";
                		      if(size3>1)
                   	            {
                		    	  int jcnt3=0;
                   		         for(int j3=3;j3<=size3;j3++)
                   		         {                       		        	
                   		        	String a3=driver.findElement(By.xpath("//html/body/section/section[3]/div[2]/div["+j3+"]/div[1]")).getText();
               		        	  a3=a3.replaceAll("\n", "");
               		        	  logger.info("Text"+a3);
                   		    	    if(a3.equals("crossOutgoing"))
                   		    	     {
                   		    		  Sta2="Pass";
                   		    	     }
                   		    	    else
                   		    	      {
                   		    		   Sta2="Fail";
                   		    		    exit(0);
                   		    	      }
                   		    	 if(j3%10==0)
                   			    {               				  
                   		    		//focusClick(driver,driver.findElement(By.xpath("//html/body/section/section[3]/div[3]/div/ul/li["+(3+jcnt3)+"]/span")),br);
                   				  jcnt3++;
                   			    }
                   		            
                   		           }
                   		    
                   		          if(Sta2.equals("Pass"))
                   			         statusTracker(br,"Pass","Verify if the Outgoing Call Type only displayed"+driver.findElement(By.xpath("//html/body/section/div[6]/div[2]/span/select/option[4]")).getText(),"Able to see only the Outgoing Call Type","Should be able to see only the Outgoing Call Type");   
                   		          else
                   		             statusTracker(br,"Fail","Verify if the Outgoing Call Type only displayed"+driver.findElement(By.xpath("//html/body/section/div[6]/div[2]/span/select/option[4]")).getText(),"Not Able to see only the Outgoing Call Type","Should be able to see only the Outgoing Call Type");                      		    	
                	            }
                             }              	  
                        }
                    }
                  
                  else
                   {
                	  if(driver.findElement(By.xpath(".//*[@id='call-log-section']/div[2]")).getText().equals("There are no Call Logs to display at this time"))
               	        {
               		       statusTracker(br,"","The All Call Type: " ,driver.findElement(By.xpath("//html/body/section/section[3]/div[2]")).getText(),"");
                  	    }
               	      else
               	      {
               		  int size=driver.findElements(By.xpath("//html/body/section/section[2]/div[2]/div")).size();
               		  int jcnt=0;
               		  for(int i=1;i<=size;i++)
               		  {
               			
               			  statusTracker(br,"","The All Call Type: " ,driver.findElement(By.xpath("//html/body/section/section[2]/div[2]/div["+i+"]")).getText(),"");
               			  
               			if(i%10==0)
           			   {               				  
               				//focusClick(driver,driver.findElement(By.xpath("//html/body/section/section[3]/div[3]/div/ul/li["+(3+jcnt)+"]/span")),br);
           				  jcnt++;
           			   }
               		  }
               		  
               		focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/span/select/option[2]")),br);
               		  if(driver.findElement(By.xpath(".//*[@id='call-log-section']/div[2]")).getText().equals("There are no Call Logs to display at this time"))
               		  {                			  
                       		     statusTracker(br,"","The Received Call Type: " ,driver.findElement(By.xpath("//html/body/section/section[2]/div[2]")).getText(),"");                        	       
               		  }
               		  else
               		  {                			                  		  
               		    int size1=driver.findElements(By.xpath("//html/body/section/section[2]/div[2]/div")).size();
               		    logger.info("size1"+size1);
               		    String Sta="";
               		    if(size1>1)
                  	       	  {
               		    	int jcnt1=0;
                  		        for(int j1=1;j1<=size1;j1++)
                  		         {                  		        	
                  		        	String a1=driver.findElement(By.xpath("//html/body/section/section[3]/div[2]/div["+j1+"]/div[1]")).getText();
               		        	  a1=a1.replaceAll("\n", "");
               		        	  logger.info("Text"+a1);
                 		    	    if(a1.equals("crossReceived"))
                  		    	     {
                  		    		 Sta="Pass";
                  		    	     }
                  		    	    else
                  		    	     {
                  		    		Sta="Fail";
                  		    		exit(0);
                  		    	     }
                 		    	   if(j1%10==0)
                       			   {               				
                 		    		  //focusClick(driver,driver.findElement(By.xpath("//html/body/section/section[3]/div[3]/div/ul/li["+(3+jcnt1)+"]/span")),br);
                       				  jcnt1++;
                       			   }
                  		           
                  		         }
                  		    
                  		       if(Sta.equals("Pass"))
                  			      statusTracker(br,"Pass","Verify if the Received Call Type sorted"+driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/span/select/option[2]")).getText(),"Able to see only the Received Call Type","Should be able to see only the Received Call Type");   
                  		       else
                  		          statusTracker(br,"Fail","Verify if the Received Call Type sorted"+driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/span/select/option[2]")).getText(),"Not Able to see only the Received Call Type","Should be able to see only the Received Call Type");                      		    	
               	         }
               		  }
                  	                       		 
               		focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/span/select/option[3]")),br);
               		  
               		  if(driver.findElement(By.xpath(".//*[@id='call-log-section']/div[2]")).getText().equals("There are no Call Logs to display at this time"))
                  	        {
                  		                   	   
                     		  statusTracker(br,"","The Missed Call Type: " ,driver.findElement(By.xpath("//html/body/section/section[2]/div[2]")).getText(),"");
                     	    }
                  	      else
                  	      {
               		     int size2=driver.findElements(By.xpath("//html/body/section/section[2]/div[2]/div")).size();
               		     String Sta1="";
               		     if(size2>1)
                  	          {
               		    	 int jcnt2=0;
                  		        for(int j2=3;j2<=size2;j2++)
                  		        {
                  		        	
                  		        	String a2=driver.findElement(By.xpath("//html/body/section/section[3]/div[2]/div["+j2+"]/div[1]")).getText();
                 		        	  a2=a2.replaceAll("\n", "");
                 		        	  logger.info("Text"+a2);
                 		        	
                 		    	    if(a2.equals("crossMissed"))
                  		    	    {
                  		    		 Sta1="Pass";
                  		    	    }
                  		    	    else
                  		    	    {
                  		    		Sta1="Fail";
                  		    		exit(0);
                  		    	    }
                 		    	   if(j2%10==0)
                    			   {               			
                 		    		  //focusClick(driver,driver.findElement(By.xpath("//html/body/section/section[3]/div[3]/div/ul/li["+(3+jcnt2)+"]/span")),br);
                    				  jcnt2++;
                    			   }
                  		           
                  		          }
                  		    
                  		           if(Sta1.equals("Pass"))
                  			         statusTracker(br,"Pass","Verify if the Missed Call Type sorted"+driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/span/select/option[3]")).getText(),"Able to see only the Missed Call Type","Should be able to see only the Missed Call Type");   
                  		           else
                  		             statusTracker(br,"Fail","Verify if the Missed Call Type sorted"+driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/span/select/option[3]")).getText(),"Not Able to see only the Missed Call Type","Should be able to see only the Missed Call Type");                      		    	
               	           }
                  	      }
               		focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/span/select/option[4]")),br);

               		  if(driver.findElement(By.xpath(".//*[@id='call-log-section']/div[2]")).getText().equals("There are no Call Logs to display at this time"))
                	      {
                		                   	   
                   		  statusTracker(br,"","The Outgoing Call Type: " ,driver.findElement(By.xpath("//html/body/section/section[2]/div[2]")).getText(),"");
                   	    }
               		  else
               		    {                			                 		  
               		     int size3=driver.findElements(By.xpath("//html/body/section/section[2]/div[2]/div")).size();
               		      String Sta2="";
               		      if(size3>1)
                  	            {
               		    	  int jcnt3=0;
                  		         for(int j3=3;j3<=size3;j3++)
                  		         {
                  		        	
                  		        	String a3=driver.findElement(By.xpath("//html/body/section/section[3]/div[2]/div["+j3+"]/div[1]")).getText();
                 		        	  a3=a3.replaceAll("\n", "");
                 		        	  logger.info("Text"+a3);
                     		    	    if(a3.equals("crossOutgoing"))
                  		    	     {
                  		    		  Sta2="Pass";
                  		    	     }
                  		    	    else
                  		    	      {
                  		    		   Sta2="Fail";
                  		    		    exit(0);
                  		    	      }
                     		    	   if(j3%10==0)
                         			   {             
                     		    		  //focusClick(driver,driver.findElement(By.xpath("//html/body/section/section[3]/div[3]/div/ul/li["+(3+jcnt3)+"]/span")),br);
                         				  jcnt3++;
                         			   }
                  		            
                  		           }
                  		    
                  		          if(Sta2.equals("Pass"))
                  			         statusTracker(br,"Pass","Verify if the Outgoing Call Type sorted"+driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/span/select/option[4]")).getText(),"Able to see only the Outgoing Call Type","Should be able to see only the Outgoing Call Type");   
                  		          else
                  		             statusTracker(br,"Fail","Verify if the Outgoing Call Type sorted"+driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/span/select/option[4]")).getText(),"Not Able to see only the Outgoing Call Type","Should be able to see only the Outgoing Call Type");                      		    	
               	                }
                         }              	  
                      }
                                                            
               	    }
              
                  
	              Thread.sleep(2000);
                  first=1;      
	              }      }
	      }
	      catch (Exception e)
	      {
	                  exceptionHandler(br,e,driver);
	      }
	    }
	    catch (Exception e)
	    {
	                exceptionHandler(br,e, driver);
	      
	    }
	    finally {
	                //statusTracker("end","","");
	      wb.close();
	      //driver.close();
	     
	    }
	  }
	  
	  private boolean isElementPresent(WebDriver driver, By xpath) {
		// TODO Auto-generated method stub
		return false;
	}
	  private void exit(int i) {
			// TODO Auto-generated method stub
			
		}
	}

