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

public class CustomCallerId extends CommonFunctions {
	
	String table, tns[];
    String tlimit,username,pwd;
    int tncount,ck;			
    
    String xpath_GPSexecute_xpath;
	
    String butnxpath;//=".//*[@id='collapseFeature3']/div[2]/form/section/div[2]/div["+ck+"]/div[1]/div/label";
    String svexpath="(//button[@type='submit'])[9]";
    String butnxpath1=".//*[@id='collapseFeature3']/div[2]/form/div[1]/label";
    				  
    String phoneline,phoneline_ac,Acccode;
	int rank[]= new int[50];
	

	int c_sequence;
	String name_for_rank[]= new String[40];
	String price, rank_channels;

	public CustomCallerId(String path) {
		this.path = path;
	}
 		
  public int countNumberTns(int featureOrder, String featureName, WebDriver driver)
  {
	  int numberOfTns=0;
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  for(int i=0;i<50;i++)
	  {    
			  //if(driver.findElements(By.id("check"+featureName+i)).size()>0)
		  try{
			  Thread.sleep(4000);
			 if(driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/section/div[2]/div["+(1+i)+"]/div[1]/div/label")).isDisplayed())
			 {
				 System.out.println("in11");
				  numberOfTns++;
			 }
			 else
			 {
				 System.out.println("in22");
				  i=101;
			 }
			}
		  catch(Exception e)
		  {
			i=51;  
		  }
	  }
	 	  	  
	  return numberOfTns;
  }
  
  public int suspendedStatus(int numberOfTns, int featureOrder,String featureName, WebDriver driver)
  {
	  String []a=new String[numberOfTns];
	  int j = 0;
	  
	  for(int i=1;i<numberOfTns;i++)
	  {
		  
			  if(isAttributePresent(driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/section/div[2]/div["+i+"]/div[1]/div/input")),"disabled"))
			  {
				  a[i]="yes";
				  System.out.println("yes");
			  }
			  else
			  {
				  a[i]="no";
				  System.out.println("no");	 
				  j=i;
				  break;
			  }
  
	  }
	  return j;
   }
  
	public String turnoff(WebDriver driver, String status1,String br)
	  {
		  String initialstate=status1, chngetostate="Off",state="";
		  focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
		  
		  for(int i=1;i<100;i++){}
	      
		  focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[9]")),br);

	      int chk=0;
	      
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          statusTracker(br,"Pass","Verify order process for changing status from: "+initialstate +" to: "+chngetostate,"Successfully be able to process order","Successfully processed order");
	        }
	      else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for changing status from: "+initialstate +" to: "+chngetostate,"The order is failed to process","Unable to process successfully");
	        }
	      
	      for(int i=1;i<100;i++){}
	      
	      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
      	        
	      focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[9]")),br);
  
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          state="Pass";
	          statusTracker(br,"Pass","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with Editing the TN","Successfully be able to process order","Successfully processed order");
	        }
	         else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with Editing the TN","The order is failed to process","Unable to process successfully");
	        }
	            
	      return state;
	  }
	  
	  public String turnOn(WebDriver driver, String status1,String br)
	  {
	      String initialstate=status1, chngetostate="On",state = "";
	      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);

		  focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[9]")),br);

	      int chk=0;
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          statusTracker(br,"Pass","Verify order process for changing status from: "+ initialstate +" to: "+chngetostate,"Successfully be able to process order","Successfully processed order");
	        }
	        else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for changing status from: "+ initialstate +" to: "+chngetostate,"The order is failed to process","Unable to process successfully");
	        }                
	        
	      for(int i1=1;i1<100;i1++){}
	      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);

	      focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[9]")),br);
	      
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          statusTracker(br,"Pass","Verify order process for changing status from: "+chngetostate +" to: "+initialstate,"Successfully be able to process order","Successfully processed order");
	          state="Pass";
	        }
	         else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate,"The order is failed to process","Unable to process successfully");
	        }
		return state;
		  
	  }
	  
	  public String turnoff1(WebDriver driver, String status2,String br)
	  {
		  String initialstate=status2, chngetostate="Disabled",state="";
		  focusClick(driver,driver.findElement(By.xpath(butnxpath1)),br);
		  
		  for(int i=1;i<100;i++){}
		  focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[9]")),br);

	      int chk=0;
	      
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          statusTracker(br,"Pass","Verify order process for changing status from: "+initialstate +" to: "+chngetostate,"Successfully be able to process order","Successfully processed order");
	        }
	      else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for changing status from: "+initialstate +" to: "+chngetostate,"The order is failed to process","Unable to process successfully");
	        }
	      
	      for(int i=1;i<100;i++){}
	      focusClick(driver,driver.findElement(By.xpath(butnxpath1)),br);
          	        
	      focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[9]")),br);
   
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          state="Pass";
	          statusTracker(br,"Pass","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with Editing the TN","Successfully be able to process order","Successfully processed order");
	        }
	         else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with Editing the TN","The order is failed to process","Unable to process successfully");
	        }
	            
	      return state;
	  }
	  
	  public String turnOn1(WebDriver driver, String status2,String br)
	  {
	      String initialstate=status2, chngetostate="Enabled",state = "";
	      focusClick(driver,driver.findElement(By.xpath(butnxpath1)),br);

		  focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[9]")),br);

	      int chk=0;
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          statusTracker(br,"Pass","Verify order process for changing status from: "+ initialstate +" to: "+chngetostate,"Successfully be able to process order","Successfully processed order");
	        }
	        else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for changing status from: "+ initialstate +" to: "+chngetostate,"The order is failed to process","Unable to process successfully");
	        }                
	        
	      for(int i1=1;i1<100;i1++){}
	      focusClick(driver,driver.findElement(By.xpath(butnxpath1)),br);

	      focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[9]")),br);
	      
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          statusTracker(br,"Pass","Verify order process for changing status from: "+chngetostate +" to: "+initialstate,"Successfully be able to process order","Successfully processed order");
	          state="Pass";
	        }
	         else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate,"The order is failed to process","Unable to process successfully");
	        }
		return state;
		  
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
	              focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]/a")),br);
	              
	              xpath_GPSexecute_xpath = GPS.getProperty("xpath_GPSexecute_xpath");
   
	              logger.info("checkpoint1");
                  for(int i=1;i<20;i++){}
                  Acccode=driver.findElement(org.openqa.selenium.By.xpath("//html/body/section/section/div[1]/aside[1]/ul/li[1]/strong")).getText();
                  logger.info("Acccode"+Acccode);
                  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[4]")),br);
                 for(int i=1;i<30;i++){}

                 if(!(InternalException(driver,br)))
	              {
                	 
		              focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature3 > div.accordian-header > div.header-right > span.accordian-info.ng-binding")),br);
		              		int count1=driver.findElements(By.xpath(xpath_GPSexecute_xpath)).size();
			                 String status2="";
			                 String featureName="Custom Caller ID";
			           	  	 int featureOrder=FeatureListIncoming(driver,count1,featureName);
			                 int numberOfTns=countNumberTns(featureOrder, featureName,driver);
			                 ck=suspendedStatus(numberOfTns, featureOrder,featureName, driver);
			                 logger.info("ck"+ck);
			                 butnxpath=".//*[@id='collapseFeature3']/div[2]/form/section/div[2]/div["+ck+"]/div[1]/div/label";
			                 boolean status= driver.findElement(By.id("toggleButton3")).isSelected();
			                 boolean statusCh= driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/section/div[2]/div["+ck+"]/div[1]/div/label")).isSelected();
			                 
			                 if(statusCh==true)
			                 {            	  
			             	   status1="On";
			             	   state=turnoff(driver, status1,br);             	  
			                 }
			                 else
			                 {
			            	   status1="Off";
			            	   state=turnOn(driver, status1,br);            	  
			                 }
			                 
			                 if(status==true)
			                 {            	  
			             	   status2="Enabled";
			             	   state=turnoff1(driver, status2,br);             	  
			                 }
			                 else
			                 {
			            	   status2="Disabled";
			            	   state=turnOn1(driver, status2,br);            	  
			                 }
			                 logger.info("Done");
			                 if(driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/section/div[2]/div["+ck+"]/div[1]/div/label")).isSelected()==true)
			                  {
			                	 logger.info("Done1");
			                	 	if(driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/section/div[2]/div["+ck+"]/div[3]/span")).getAttribute("Class").equals("dropdown"))
			                	 	{logger.info("Done2");
			                	 	focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
			                		 if(driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/section/div[2]/div["+ck+"]/div[3]/span")).getAttribute("Class").equals("dropdown disabled"))
			                		 {
			                			 statusTracker(br,"Pass","Target TN drop down behavior for Enable or Disable","Able to see the drop down is disabled on unselecting the check box","should be disabled on unchecking the checkbox");
			                		 }
			                		 else
			                		 {
			                			 statusTracker(br,"Fail","Target TN drop down behavior for Enable or Disable","Unable to see the drop down is disabled on unselecting the check box","should be disabled on unchecking the checkbox");
			                		 }
			                	 }
			                 }
			                 else
			                 {logger.info("Done11");
			                	 if(driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/section/div[2]/div["+ck+"]/div[3]/span")).getAttribute("Class").equals("dropdown disabled"))
			                	 {logger.info("Done22");
			                	 focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
			                		 if(driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/section/div[2]/div["+ck+"]/div[3]/span")).getAttribute("Class").equals("dropdown"))
			                		 {
			                			 statusTracker(br,"Pass","Target TN drop down behavior for Enable or Disable","Able to see the drop down is Enabled on selecting the check box","should be Enabled on checking the checkbox");
			                		 }
			                		 else
			                		 {
			                			 statusTracker(br,"Fail","Target TN drop down behavior for Enable or Disable","Unable to see the drop down is Enabled on selecting the check box","should be Enabled on checking the checkbox");
			                		 }
			                	 }
			                 }
			                 
			                 String canbut=".//*[@id='cancelSaveFeature']";
			             	 String Savbut=".//*[@id='unsavedFeature']/span";
			             	focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
			             	focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]/a")),br);
			            	
			         	   if(driver.findElements(By.xpath("//html/body/div[11]/div")).size()>0)
			         	   {
			         		   statusTracker(br,"","","The Unsaved pop up is displayed","");
			         	   }
			         	   
			         	  focusClick(driver,driver.findElement(By.xpath(canbut)),br);
			         	    if(driver.findElement(By.xpath("//html/body/header/div[4]/div[3]/div/nav/ul/li[2]/span")).isDisplayed())
			         	    {
			         		   statusTracker(br,"Pass","Verifiy id the cancel in unsaved pop up is closes","The cancel closes the unsaved pop up","the cancel should close the pop up");
			         	    }
			         	    else
			         	    {
			         		   statusTracker(br,"Fail","Verifiy id the cancel in unsaved pop up is closes","The cancel is not closes the unsaved pop up","the cancel should close the pop up");
			         	    }
			         	   focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]/a")),br);

			         	  focusClick(driver,driver.findElement(By.xpath(Savbut)),br);

			         	    do{
			         	      }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
			         	     if(driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[2]/a")).isDisplayed())
			         	     {
			         		   statusTracker(br,"Pass","Verifiy id the save in unsaved pop up is closes","The save navigated properly","the save should navigated properly");
			         	     }
			         	     else
			         	     {
			         		   statusTracker(br,"Fail","Verifiy id the save in unsaved pop up is closes","The save navigated properly","the save should navigated properly");
			         	     }                  
			                  
				              Thread.sleep(2000);
			                  first=1; 
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

