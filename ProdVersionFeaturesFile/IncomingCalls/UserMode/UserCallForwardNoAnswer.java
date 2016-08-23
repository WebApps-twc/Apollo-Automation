package ApolloNew;

import com.thoughtworks.selenium.Selenium;

import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class UserCallForwardNoAnswer extends CommonFunctions {
	
	String table,TN1, tns[];
    String tlimit,username,pwd;
    int tncount;				
	
	String butnxpath="//html/body/section/div[5]/div[2]/div[4]/div[1]/div[4]/form/div/div[1]/div/div/div/label";
    String svexpath="form[name=callForwardNoAnswerForm] > div.col-16 > div.accordian-actions > button.btn.btn-primary";
    String Tnxpath="//div[@id='collapseFeature3']/div[2]/form/div[5]/div/label";
    String phoneline,phoneline_ac,Acccode;
	int rank[]= new int[50];
	

	int c_sequence;
	String name_for_rank[]= new String[40];
	String price, rank_channels;

	public UserCallForwardNoAnswer(String path) {
		this.path = path;
	}

	public UserCallForwardNoAnswer(String path, String file1, String file2) {
		this.path = path;
		this.path1 = file1;
		this.path2 = file2;
	}
		 
	
	public String turnoff(WebDriver driver, String status, String acc,String br)
	  {
		  String initialstate=status, chngetostate="Off",state="Fail", accst=acc;
		  focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
		  
		  for(int i=1;i<100;i++){}
		  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
	      int chk=0;
	      do{	          
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	       if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          statusTracker(br,"Pass","Verify the order process for changing the status from: "+initialstate +" to: "+chngetostate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
	        }
	       else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify the order process for changing the status from: "+initialstate +" to: "+chngetostate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div/div")).getText(),"Unable to process successfully");
	        }
		  
	      focusClick(driver,driver.findElement(By.cssSelector(butnxpath)),br);
	      String num=randomNO(3333,6666);
	      driver.findElement(By.name("callForwardNoAnswerTo")).clear();
	      driver.findElement(By.name("callForwardNoAnswerTo")).sendKeys(phoneline+num);
	     
	      for(int i1=1;i1<100;i1++){}
	      focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
	      
	      do{
	          
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          state="Pass";
	          statusTracker(br,"Pass","Verify the order process for changing the status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
	                 
	        }
	         else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify the order process for changing the status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div/div")).getText(),"Unable to process successfully");
	        }
	      return state;
	  }
	  
	  public String turnOn(WebDriver driver, String status, String acc,String br)
	  {
	      String initialstate=status, chngetostate="On",state = "Fail", accst=acc;
	      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
		  String num=randomNO(3333,6666);
		  driver.findElement(By.name("callForwardNoAnswerTo")).clear();
		  driver.findElement(By.name("callForwardNoAnswerTo")).sendKeys(phoneline+num);
		  
		  for(int i=1;i<100;i++){}
		  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
	      int chk=0;
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          statusTracker(br,"Pass","Verify the order process for changing the status from: "+ initialstate +" to: "+chngetostate+ " with "+accst,"Successfully be able to process order","Successfully processed order"); 
	        }
	        else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify the order process for changing the status from: "+ initialstate +" to: "+chngetostate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div/div")).getText(),"Unable to process successfully");
	        }
	        focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
	      
	      for(int i1=1;i1<100;i1++){}
	      focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
	      
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          statusTracker(br,"Pass","Verify the order process for changing the status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
	          state="Pass";
	        }
	         else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify the order process for changing the status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div/div")).getText(),"Unable to process successfully");
	        }
		return state;
		  
	  }
	  
	  public void EditTn(WebDriver driver,String br)
	  {
		  String num=randomNO(3333,6666);
		  driver.findElement(By.name("callForwardNoAnswerTo")).clear();
		  driver.findElement(By.name("callForwardNoAnswerTo")).sendKeys(phoneline+num);
		  for(int i=1;i<10;i++){}
		  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
	      int chk=0;
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          statusTracker(br,"Pass","Verify order process for editing TN","Successfully be able to process order","Successfully processed order");
	        }
	        else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for editing TN","Unable to process order" + driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div/div")).getText(),"Unable to process successfully");
	        }
	  }
	  
	  public String TNcheck(String ac, String acode,WebDriver driver, int check,String br) throws Exception
	  {
	         String schk="Fail";
	         int check1=check;
	         driver.findElement(By.name("callForwardNoAnswerTo")).clear();
	         driver.findElement(By.name("callForwardNoAnswerTo")).sendKeys(ac);       
	          
	         if(check1==2)
	         {
	        	 ac=acode;
	        	 driver.findElement(By.name("callForwardNoAnswerAccount")).clear();
	        	 driver.findElement(By.name("callForwardNoAnswerAccount")).sendKeys(acode);
	         }
	         if(check1==3)
	         {
	        	 ac=2+Acccode;
	        	 logger.info("ac"+ac);
	        	 driver.findElement(By.name("callForwardNoAnswerAccount")).clear();
	        	 driver.findElement(By.name("callForwardNoAnswerAccount")).sendKeys(acode);
	         }
	         focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
	                 
	         Thread.sleep(6000);
	     
	         if(driver.findElement(By.xpath(".//*[@id='collapseFeature1']/div[2]/div[1]/div/div/div")).isDisplayed())
	   	     {
	   		  statusTracker(br,"Pass","Verify if error message is displayed when adding "+ac+" TN/Acc code","Error message is displayed: "+ driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div")).getText(),"Error message should be displayed");
	   		  schk="Pass";
	   	     }
	   	  	 else
	   	  	 {
	   	  		 statusTracker(br,"Fail","Verify if error message is displayed when adding "+ac+" TN","Error message is not displayed","Error message should be displayed");
	   	  		 schk="Fail";
	   	  	 }
	         return schk;
	  }  
	  //TN Validation
	  public String TNValidation(WebDriver driver, int a,String br) throws Exception
	  {
		     statusTracker(br,"","","Error Validation","");
	         String schk ="Pass";
	         schk=TNcheck("0223004000","",driver,1,br);
	         schk=TNcheck("1223004000","",driver,1,br);
	         schk=TNcheck("9000004000","",driver,1,br);
	         schk=TNcheck("9760004000","",driver,1,br);
	         schk=TNcheck("9999","",driver,1,br);
	         schk=TNcheck(phoneline_ac,"",driver,1,br);
	         
	         if(a==1 || a==2)
	         {
	         schk=TNcheck("9193220101","",driver,2,br); 
	         schk=TNcheck("9193220101","2",driver,2,br);
	         schk=TNcheck("919322","2",driver,2,br);
	         
	         if(a==1)
	        	 schk=TNcheck("9193220101","",driver,3,br);
	         
	         schk="Pass";
	         }
	         return schk;
	  }
	  
	  public void numrngs(WebDriver driver,String br,String drpval) throws Exception
	  {
		  String n=randomNO(1,4);
		  focusClick(driver,driver.findElement(By.xpath(drpval+"/span[1]/select/option["+n+"]")),br);
	      //driver.findElement(By.xpath(drpval+"/span[1]/select/option["+n+"]")).click();
	      Thread.sleep(3000);           
	      focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);

	      int chk=0;
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          statusTracker(br,"Pass","Verify the order process for changing the num of rings to" + n,"Successfully be able to process order","Successfully processed order");
	        }
	        else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify the order process for changing the num of rings to" + n,"Unable to process order","Unable to process successfully");
	        }
	      
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
                  for(int i1=1;i1<20;i1++){}
                  Acccode=driver.findElement(org.openqa.selenium.By.xpath("//html/body/section/section/div[1]/aside[1]/ul/li[1]/strong")).getText();
                  logger.info("Acccode"+Acccode);
                  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[3]")),br);                
                  
                  if(!(InternalException(driver,br)))
                  {

                  int count1=driver.findElements(By.xpath("//html/body/section/div")).size();
                  String featureName="Call Forward No Answer";
	              int featureOrder=FeatureListIncoming(driver,count1,featureName);

	              System.out.println("Feature Order " + featureOrder);  
	              focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature3 > div.accordian-header > h3.ng-binding")),br);                
                 Thread.sleep(2000);
                  phoneline_ac= Select_TN(driver,featureName,featureOrder,br);
	              System.out.println(phoneline_ac);
	              logger.info("c");

	              if(phoneline_ac!=null)
	              {
            	  focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[1]/a")),br);

                  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[3]")),br);

	              //new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(phoneline_ac);
	              focusDropdown(driver,"//html/body/header/div[4]/div[3]/div/div/span",phoneline_ac,br);
	              do{
	            	  //logger.info("Processing!" +chk);
	            	 
	              }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                
                  phoneline=phoneline_ac.substring(0,8);
                  focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature1 > div.accordian-header > div.header-right")),br);
                                  
                  boolean status= driver.findElement(By.id("toggleButton2Forward No Answer")).isSelected();
                  
                  int cnt=driver.findElements(org.openqa.selenium.By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[4]/form/div/div")).size();
                  logger.info("cnt is"+cnt);
                  String drpval;
                  if(cnt==6)
                  {
                	  int a1=1;
                	  drpval="//html/body/section/div[5]/div[2]/div[4]/div[1]/div[4]/form/div/div[5]";
                	  boolean acntcd= driver.findElement(By.id("third")).isSelected();
                	  logger.info("acntcd is"+acntcd);
                	  if(acntcd==true)
                      {
                		  logger.info("check is");
                		  statusTracker(br,"","The Account code is"+Acccode,"","");      
                		  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[4]/form/div/div[4]/label")),br);
                		  driver.findElement(By.name("callForwardNoAnswerAccount")).sendKeys(Acccode);
                      }
                	  else
                	  {
                		  driver.findElement(By.name("callForwardNoAnswerAccount")).clear();
                		  driver.findElement(By.name("callForwardNoAnswerAccount")).sendKeys(Acccode);
                	  }
                	  logger.info("check is");
                	  String acc="Verified Account code";
                	  if(status==true)
                      {
                  	  status1="On";
                  	  state=turnoff(driver, status1, acc,br);
                      }
                      else
                      {
                  	  status1="Off";
                  	  state=turnOn(driver, status1, acc,br);
                      }

                  	  EditTn(driver,br);
                  	  numrngs(driver,br,drpval);
                      TNValidation(driver, a1,br);
                      
                  }
                  else if(cnt==5)
                  {
                	  int a2=2;
                	  drpval="//html/body/section/div[5]/div[2]/div[4]/div[1]/div[4]/form/div/div[4]";
                	  driver.findElement(By.name("callForwardNoAnswerAccount")).clear();
            		  driver.findElement(By.name("callForwardNoAnswerAccount")).sendKeys("8956325485");
            		  String acc="Non-Verified Account code";
            		  if(status==true)
                      {
                  	  status1="On";
                  	  state=turnoff(driver, status1, acc,br);
                      }
                      else
                      {
                  	  status1="Off";
                  	  state=turnOn(driver, status1, acc,br);
                      }

                  	  EditTn(driver,br);
                  	  numrngs(driver,br,drpval);
                      TNValidation(driver,a2,br);
                      
                  }
                  else
                  {
                	  int a3=3;
                	  drpval="//html/body/section/div[5]/div[2]/div[4]/div[1]/div[4]/form/div/div[3]";
                	String acc="No Account code";
                    if(status==true)
                    {
                	  status1="On";
                	  state=turnoff(driver, status1, acc,br);
                    }
                    else
                    {
                	  status1="Off";
                	  state=turnOn(driver, status1, acc,br);
                    }
                  
                	EditTn(driver,br);
                	numrngs(driver,br,drpval);
                  	TNValidation(driver,a3,br);
                    
                  }     
                  
                  String canbut="//html/body/div[2]/div/div[2]/span";
              	  String Savbut="//html/body/div[2]/div/div[2]/a/span";                  	 
              	  unsave(driver,br,canbut,Savbut);
                  
	              Thread.sleep(2000);
                  
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
	  
	  private boolean isElementPresent(WebDriver driver, By xpath) {
		// TODO Auto-generated method stub
		return false;
	}
	}
