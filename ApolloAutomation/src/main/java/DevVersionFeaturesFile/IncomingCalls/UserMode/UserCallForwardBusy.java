package DevVersionFeaturesFile.IncomingCalls.UserMode;


import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import DevVersionFeaturesFile.CommonFunctions;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class UserCallForwardBusy extends CommonFunctions {

	
	String table, tns[];
    String tlimit,username,pwd,TN,TN1,NonAccountcode,acccode;
    int tncount;
    
    String xpath_Accountcode;
	String xpath_GPS;
	String xpath_divCount;
	String id_CFBAdminTNStatus;
	String xpath_TNxpath;
	String css_submit;
	String css_loader;
	String xpath_home_shortcut;
	String id_CFBUserTNStatus;


	public UserCallForwardBusy(String path) {
		this.path = path;
	}

	/*public UserCallForwardBusy(String path, String file1, String file2) {
		this.path = path;
		this.path1 = file1;
		this.path2 = file2;
	}
		*/ 
	
	 
	  public void Turnoff(String br,WebDriver driver,String d,int featureOrder) throws Exception
	  {
		  String st="OFF";
		    
		     focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature1']/div[2]/div[4]/div/div[3]/form//div/label/span[2]")),br);
		     for(int i=1;i<100;i++){}
	      
	  
	  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]//div[4]/button[2]")),br);
	  int chk=0;
	   do{
           Thread.sleep(1000);
            chk++;
          }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
        
	   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	     {
	      
	       statusTracker(br,"Pass","Verify order process for changing from On to "+st," Successfully be able to process order","Successfully processed order");                                                                   
	     }
	      else
	     {
	       
	       statusTracker(br,"Fail","Verify order process for changing from On to "+st,"Not able to process order","Successfully processed order");
	     }
	   
	   
	  }
	  
	  public void EditTN(String br,WebDriver driver,String d,int featureOrder,String TN) throws Exception
	  {
		  //TN=TN.substring(0,8);
		  int divcount;String st = null;
		  divcount=driver.findElements(By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[2]/form/div/div")).size();
		  logger.info("divcount is........."+divcount);
		//Non Verified Account code  
		  if (divcount==5)
		  {
			  logger.info("Edit TN");
		
		  //   driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/div[4]/div/div[3]/form/div/div/div/div/div/label/span")).click();
		 // for(int i=1;i<100;i++){}
		  driver.findElement(By.name("forwardBusyCallTo")).clear();
		  TN1=TN+randomNO(3333,9999);
		   driver.findElement(By.name("forwardBusyCallTo")).sendKeys(TN1);
		  for(int i=1;i<100;i++){}
		  driver.findElement(By.name("forwardBusyCallAccount")).clear();
		  driver.findElement(By.name("forwardBusyCallAccount")).sendKeys(acccode);
		  for(int i=1;i<100;i++){}

		  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]//div[4]/button[2]")),br);
	
	   int chk=0;
	   do{
           Thread.sleep(1000);
            chk++;
          }while((driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed())&&(chk<=40));
                           
	   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	     {
	      
	       statusTracker(br,"Pass","Verify order process for  editing TN with non verified Account code "," Successfully be able to process order with non verified Account code","Successfully processed order with non verified Account code");                                                                   
	     }
	      else
	     {
	       
	       statusTracker(br,"Fail","Verify order process for editing TN with non verified Account code ","Not able to process order for non verified Account code"+ driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div")).getText(),"Successfully processed order with non verified Account code");
	     }
	  }
		  {
			  //   driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/div[4]/div/div[3]/form/div/div/div/div/div/label/span")).click();
			  //for(int i=1;i<100;i++){}
			  driver.findElement(By.name("forwardBusyCallTo")).clear();
			  TN1=TN+randomNO(3333,9999);
			   driver.findElement(By.name("forwardBusyCallTo")).sendKeys(TN1);
		
			  
			   focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]//div[4]/button[2]")),br);
			   int chk=0;
			   do{
	               Thread.sleep(1000);
	                chk++;
	              }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
                if(chk>40)
                {
              	  statusTracker(br,"","Order Processing is taking too much time  exiting from Feature","","");  
              	 driver.navigate().refresh();
                }
                                   
                else
			   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
			     {
			       
			       statusTracker(br,"Pass","Verify order process for editing TN"," Successfully be able to process order ","Successfully processed order ");                                                                   
			     }
			      else
			     {
			       
			       statusTracker(br,"Fail","Verify order process for editing TN","Not able to process order "+ driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div")).getText(),"Successfully processed order ");
			     }
		  }
	  }
	  
	 
	  public String TNcheck(String br,String TN,String acc, String check,WebDriver driver,int divcount) throws Exception
	  {
	         String schk="Fail";
	         driver.findElement(By.name("forwardBusyCallTo")).clear();
			 driver.findElement(By.name("forwardBusyCallTo")).sendKeys(TN);
			
			//Non Verified Account code Or Verified 
			  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]//div[4]/button[2]")),br);
			Thread.sleep(4000); 
		    
				  if(driver.findElement(By.cssSelector("div[class='error-box inverted spacing'] div[class='message-box']")).isDisplayed())
				  	  {
				  		  statusTracker(br,"Pass","Verify if error message is displayed when adding "+check+" TN","Error message is displayed: "+ driver.findElement(By.cssSelector("div[class='error-box inverted spacing'] div[class='message-box']")).getText(),"Error message should be displayed");
				  		  schk="Pass";
				  	  }
		  	  	 else
		  	  	 {
		  	  		 statusTracker(br,"Fail","Verify if error message is displayed when adding "+check+" TN","Error message is not displayed","Error message should be displayed");
		  	  		 schk="Fail";
		  	  	 }
		            	  
	  return schk;
	  }  
	  
	  

	public void ErrorValidation(String br,WebDriver driver,String TN1)throws Exception
	  {
		
		  int divcount=driver.findElements(By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[2]/form/div/div")).size();
	   	  logger.info("Count is"+divcount);
	   	  if(divcount==6)
	   	  {
	   		  if(driver.findElement(By.id("second")).isSelected())
	   		  {
	   			 driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]/form/div/div[4]/label")).click();
	   			  
	   		  }
	   		  
	   		  
	   	  }
		  String schk ="Pass";  
		  schk=TNcheck(br,"0227845619","3784","first digit 0",driver,divcount);
		  schk=TNcheck(br,"1227845619","3784","first digit 1",driver,divcount);
		  schk=TNcheck(br,"9007845619","3784","TN with starting 900",driver,divcount);
		  schk=TNcheck(br,"9767845619","3784","TN with starting 976",driver,divcount);
		  schk=TNcheck(br,"9945","3784","Invalid",driver,divcount);
		  schk=TNcheck(br,"","3784","Blank",driver,divcount);
		  schk=TNcheck(br,TN1,"","Blank Accountcode",driver,divcount);
		  schk=TNcheck(br,TN1,"3","Account code less than specified lenght",driver,divcount);
		  
	  }
	
	public void Turnon(String br,WebDriver driver,String d,int featureOrder,String TN) throws Exception
	  {
		String st="On";
		 
		  logger.info("Turn On");
			  
		     driver.findElement(By.xpath("//div[@id='collapseFeature1']/div[2]/div[4]/div/div[3]/form//div/label/span[2]")).click();

		     driver.findElement(By.name("forwardBusyCallTo")).clear();
		TN=TN+randomNO(3333,9999);
		   driver.findElement(By.name("forwardBusyCallTo")).sendKeys("9586585446");

		   focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]//div[4]/button[2]")),br);
	   int chk=0;
	   do{
         Thread.sleep(1000);
          chk++;
        }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
                         
	   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	     {
	     
	       statusTracker(br,"Pass","Verify order process for changing from Off to "+st+"with non verified Account code "," Successfully be able to process order ","Successfully processed order");                                                                   
	     }
	      else
	     {
	    
	       statusTracker(br,"Fail","Verify order process for changing from Off to "+st+"with non verified Account code ","Not able to process order","Successfully processed order");
	     }
	  }
	
	public void Turnon_old(String br,WebDriver driver,String d,int featureOrder,String TN) throws Exception
	  {
		//TN=TN.substring(0,8);
		String st="On";
		 
		  logger.info("Turn On");
		  int divcount;
		  divcount=driver.findElements(By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[2]/form/div/div")).size();
		  logger.info("divcount"+divcount);
		//Non Verified Account code  
		  if (divcount==5)
		  {
			  
		     driver.findElement(By.xpath("//div[@id='collapseFeature1']/div[2]/div[4]/div/div[3]/form//div/label/span[2]")).click();
		  for(int i=1;i<100;i++){}
		  driver.findElement(By.name("forwardBusyCallTo")).clear();
		TN=TN+randomNO(3333,9999);
		   driver.findElement(By.name("forwardBusyCallTo")).sendKeys(TN);
		  for(int i=1;i<100;i++){}
		  driver.findElement(By.name("forwardBusyCallAccount")).clear();
		  driver.findElement(By.name("forwardBusyCallAccount")).sendKeys(acccode);
		  for(int i=1;i<100;i++){}
	    focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]//div[4]/button[2]")),br);
	   int chk=0;
	   do{
           Thread.sleep(1000);
            chk++;
          }while((driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed())&&chk<=50);
        if(chk>=50)
        {
      	  statusTracker(br,"","Order Processing is taking too much time  exiting from Feature","","");  
      	 driver.navigate().refresh();
        }
                           
        else
	   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	     {
	     
	       statusTracker(br,"Pass","Verify order process for changing from Off to "+st+"with non verified Account code "," Successfully be able to process order with non verified Account code","Successfully processed orderwith non verified Account code");                                                                   
	     }
	      else
	     {
	    
	       statusTracker(br,"Fail","Verify order process for changing from Off to "+st+"with non verified Account code ","Not able to process order for non verified Account code"+ driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div")).getText(),"Successfully processed order with non verified Account code");
	     }
		  }
	   //Verified Account code
		  else if (divcount==6)
		  {
			    driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/div[4]/div/div[3]/form/div/div/div/div/div/label/span")).click();
			  for(int i=1;i<100;i++){}
			  driver.findElement(By.name("forwardBusyCallTo")).clear();
			  TN1=TN+randomNO(3333,9999);
			   driver.findElement(By.name("forwardBusyCallTo")).sendKeys(TN1);
			  for(int i=1;i<100;i++){}
			  if(driver.findElement(By.id("second")).isSelected())
			  {
			   
			   Thread.sleep(2000);
			  driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[3]/form/div/div[4]/label")).click();
			  driver.findElement(By.name("forwardBusyCallAccount")).clear();
			  driver.findElement(By.name("forwardBusyCallAccount")).sendKeys(acccode);
			  
			  for(int i=1;i<100;i++){}
			  }
			  driver.findElement(By.name("forwardBusyCallAccount")).clear();
			  driver.findElement(By.name("forwardBusyCallAccount")).sendKeys(acccode);
			  for(int i=1;i<100;i++){}
		    focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]//div[4]/button[2]")),br);
		   int chk=0;
		   do{
              Thread.sleep(1000);
              System.out.println(chk);
                chk++;
              }while((driver.findElement(By.cssSelector("div.modal-loading"))).isDisplayed()&&chk<=50);
           if(chk>=50)
            {
          	  statusTracker(br,"","Order Processing is taking too much time  exiting from Feature","","");  
          	driver.navigate().refresh();
            }
                               
            else
		   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
		     {
		      
		       statusTracker(br,"Pass","Verify order process for changing from Off to "+st+"with  verified Account code "," Successfully be able to process order with  verified Account code","Successfully processed orderwith  verified Account code");                                                                   
		     }
		      else
		     {
		       
		       statusTracker(br,"Fail","Verify order process for changing from Off to "+st+"with  verified Account code ","Not able to process order for  verified Account code"+ driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div")).getText(),"Successfully processed order with  verified Account code");
		     }  
			  
			  
		  }
		  //Normal TN
		  else
		  {
			  
			   driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/div[4]/div/div[3]/form/div/div/div/div/div/label/span")).click();
			  for(int i=1;i<100;i++){}
			  driver.findElement(By.name("forwardBusyCallTo")).clear();
			  TN1=TN+randomNO(3333,9999);
			   driver.findElement(By.name("forwardBusyCallTo")).sendKeys(TN1);
			 Thread.sleep(6000);
			  
			   focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]//div[4]/button[2]")),br);
			   int chk=0;
			   do{
	               Thread.sleep(1000);
	                chk++;
	              }while((driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed())||chk<=50);
                if(chk>50)
                {
              	  statusTracker(br,"","Order Processing is taking too much time  exiting from Feature","","");  
              	driver.navigate().refresh();
                }
                                   
                else
			   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
			     {
			      
			       statusTracker(br,"Pass","Verify order process for changing from Off to On"," Successfully be able to process order ","Successfully processed order ");                                                                   
			     }
			      else
			     {
			       
			       statusTracker(br,"Fail","Verify order process for changing from Off to On","Not able to process order "+ driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div")).getText(),"Successfully processed order ");
			     }
		  }
		  
	  }
	
	  public String randomNO(int max, int min)
	  {
	  	  	int Max=max;
	  	  	int Min=min;
	  	  	double random1=Min + (int)(Math.random() * ((Max - Min) + 1));
	  		logger.info("random"+random1);
	  		int random2=(int)random1;
	  		logger.info("random2"+random2);
	  		String s1 = new Integer(random2).toString();
	  		logger.info("TN"+s1);
	  		return(s1);
	  		
	  } 
	  public void cancel(WebDriver driver,String br) throws Exception
	  {
		  logger.info("Switching the feature");
		  driver.findElement(By.xpath("//div[@id='collapseFeature1']/div[2]/div[4]/div/div[3]/form//div/label/span[2]")).click();
		  driver.findElement(By.cssSelector("a[href='/UserOutgoingCalls/OutgoingCalls']")).click();
		  Thread.sleep(2000);
		  logger.info("Clicking on cancel in the pop-up");
		  driver.findElement(By.cssSelector("[class='modal-footer'] span[id='cancelSaveFeature']")).click();
		  boolean enable = driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]//div[4]/button[2]")).isEnabled();
		  if(enable)
		  {
              logger.info("Success");
             statusTracker(br,"Pass","Verify if clicking on cancel navigating to Callforward Page","Successfully navigate back to Callforward Page on clicking cancel","Success");
           }
           else
           {
              logger.info("Fail");
             statusTracker(br,"Fail","Cancel dint work","Unsuccessful","Unable to process successfully");
           }
		  Thread.sleep(2000);
		  driver.findElement(By.cssSelector("a[href='/UserOutgoingCalls/OutgoingCalls']")).click();
		  logger.info("Clicking on cancel in the pop-up");
		  driver.findElement(By.cssSelector("[class='modal-footer'] a[id='unsavedFeature'] span")).click();
		  Thread.sleep(2000);
		  if(driver.findElements(By.xpath("/html/body/section/div[4]/div[1]/div")).size()>0)
          {
			  logger.info("Success");
              statusTracker(br,"Pass","Verify if clicking on OK navigating to Outgoing Calls Page","Successfully navigated to Outgoing calls Page on clicking OK","Success");
         }
          else
         {
            logger.info("Fail");
            statusTracker(br,"Fail","OK dint work in Unsaved Pop Up","Unsuccessful","Unable to process successfully");
         }
	  }
	  
	  public void execute(String br, WebDriver driver, String url, int loc, String name1) throws Exception {
	
		             xpath_Accountcode="//aside/ul/li[1]/strong";
					 xpath_GPS="//html/body/section/div[2]/section/div/a[3]";
					 xpath_divCount="//html/body/section/div";
				     id_CFBAdminTNStatus="checkCall Forward Busy0";
					 xpath_TNxpath="//div[@id='collapseFeature2']/div[2]/form/div[5]/div/label";
					 css_submit="#collapseFeature2 > div.accordian-body.in > form[name=\"featureForm\"] > div.accordian-actions.ng-scope > button.btn.btn-primary";
					 css_loader="img[alt='icon-loading.gif']";
					 xpath_home_shortcut="//section[@id='homepage-shortcuts']/div/a[3]/span/div";
					id_CFBUserTNStatus="toggleButton2Forward Busy Calls";
		  //arrcount=0;
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
	          
	          
	          NonAccountcode=sheet2.getCell(8, loc).getContents();
	          tlim = Integer.parseInt(tlimit);
	          wb.close();
	          //int tlim = Integer.parseInt(tlimit);
	      
	          driver.manage().timeouts().implicitlyWait(tlim,TimeUnit.SECONDS);
	          logger.info("qtest1");
	        try {
	        	  if(first==0)
	              {
	        		
	            	  login(driver,username,pwd);
	              }
	        	  if(!(InternalException(driver,br)))
                  {

	        	  switchTo(driver, "Admin",tlim,br);

	        	  if(driver.findElement(By.cssSelector("a[href='/UserMain/UserCallSettings']")).isDisplayed())
        		  {
        			  statusTracker(br,"Pass","Verifying Whether the home page is displayed","Successfully Logged into VoiceManager application, home page is displayed","");
        		  }
        		  else
        		  {
        			  statusTracker(br,"Fail","Verifying Whether the home page is displayed","Could not Log into VoiceManager application, home page is not displayed","");
        		  }
                  
                  focusClick(driver,driver.findElement(By.cssSelector("a[href='/UserIncomingCalls/IncomingCalls']")),br);
                       
	              for(int i=1;i<40;i++){}
	              
	              driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);  
              		if(!(InternalException(driver,br)))
	                    {

			             int count1=driver.findElements(By.xpath(xpath_divCount)).size();
			              String featureName="Call Forward Busy";
			              int featureOrder=FeatureListIncoming(driver,count1,featureName);
		
			              System.out.println("Feature Order " + featureOrder);  
			              focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature1 > div.accordian-header > div.header-right")),br);
			             
			               Thread.sleep(3000);
			              
			             TN1= Select_TN(driver,featureName,featureOrder,br);
			              System.out.println(TN1);
			              logger.info("c");
		
			              if(TN1!=null)
			              {
		
			              featureName="Call Forward";
			              //featureOrder=FeatureListIncoming(driver,count1,featureName);
		
			              logger.info("Feature"+featureOrder);
			            
			        	boolean status=driver.findElement(By.id(id_CFBUserTNStatus)).isSelected();
			            logger.info("Status is"+status);
			            if (status)
			            	  {
			            		Turnoff(br,driver,acccode,featureOrder);
			            		EditTN(br,driver,acccode,featureOrder,TN1);
			            		Turnon(br,driver,acccode,featureOrder,TN1);
			                	ErrorValidation(br,driver,TN1);
			            	  }
			              else
			            	  {
			            	  	Turnon(br,driver,acccode,featureOrder,TN1);
			            	  	EditTN(br,driver,acccode,featureOrder,TN1);
			            	  	Turnoff(br,driver,acccode,featureOrder);
			            	  	ErrorValidation(br,driver,TN1);
			            	  	cancel(driver,br);
			            	  }
			            
			           
		              first=1;
		              }
	            }
                  }  
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
	}