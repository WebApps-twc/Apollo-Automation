package ProdVersionFeaturesFile.BusinessGroup;

import com.thoughtworks.selenium.Selenium;

import ProdVersionFeaturesFile.CommonFunctions;

import java.io.File;
import java.io.PrintStream;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

public class GPSCallHold extends CommonFunctions
{
                String table, tns[];
                String tlimit,username,pwd;
                int tncount;
                String[] tnSuspendedStatus;
                //int envvalue=0;
                
              String xpath_GPSexecute_xpath1;
          	  String xpath_GPSexecute_xpath;
          	  String css_GPSexecute_css3;
          	  String xpath_GPSexecute_xpath4;
                
  public GPSCallHold()
  {
  }
  
  public GPSCallHold(String path) {
		this.path = path;
	}

  public int FeatureListIncoming(WebDriver driver,int count1, String featureName)
  {
	  String list="";
	  int j=0,featureOrder=-1;
	  for(int i=0;i<=count1;i++)
	  {
		  System.out.println("in1");		  
		  if(driver.findElements(By.id("collapseFeature"+i)).size()>0)
		  {
    			  System.out.println("in3");

    			  if(driver.findElement(By.id("collapseFeature"+i)).getAttribute("ng-repeat").contains("outgoingCall") || !(driver.findElement(By.id("collapseFeature"+i)).getAttribute("ng-if").contains("==")))
    			  {
    				
    				list=driver.findElement(By.cssSelector("#collapseFeature"+i+" > div.accordian-header > h3.ng-binding")).getText();
    				System.out.println("Features searched: "+list);
    				if(list.equals(featureName))
    				{
    					featureOrder=j;
    					i=100;
    				}
    					    				
    				j++;
    				    				
    			  }
    			  else
    			  {
    				  System.out.println("Features present: "+driver.findElement(By.cssSelector("#collapseFeature"+i+" > div.accordian-header > h3.ng-binding")).getText() + " Not available for purchase : "+i);
      				    				
    			  }
			  
		  }
	  }
	  return (featureOrder);
  }

  public void turnOnOff(int featureOrder, WebDriver driver, String br)
  {
	  	  Boolean onoff=driver.findElement(By.id("lines"+featureOrder)).isSelected();
	  	  String on="OFF";
	  	  String not="ON";
	  	  if (onoff)
	  	  {
	  		  on="ON";
	  		  not="OFF";
	  	  }
			  
	  	  int val=7;
	  	  if(envvalue==0)
	  		  val=17;
	  	  
		  Boolean r=driver.findElement(By.id("lines"+featureOrder)).isSelected();
		  System.out.println("bool : "+r);

		  focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature"+featureOrder+"']/div[2]/form/div[4]/label")),br);
			  			  
		  for(int i=1;i<100;i++){}
			  	  
		  focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature"+featureOrder+"']/div[2]/form/div["+val+"]/button[2]")),br);
		  
		  if(driver.findElements(By.cssSelector("div.modal-body-inner.ng-scope > div.ng-scope")).size()>0)
		  {
			  if(driver.findElement(By.cssSelector("div.modal-body-inner.ng-scope > div.ng-scope")).getText().contains("warning"))
			  {
				  System.out.println("Warning message is displayed hence proceeding. Warning message: " + driver.findElement(By.cssSelector("div.modal-body-inner.ng-scope > div.ng-scope")).getText());
				  focusClick(driver,driver.findElement(By.xpath("//div[@id='modal-warning']/div/div[2]/span[2]")),br);
			  }
		  }
		  		
		  int chk=0;
		  do{
			 System.out.println("Processing!" +chk);
			 chk++;
		  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
		  
		  if(driver.findElements(By.id("dataSaveSucess")).size()>0 && driver.findElement(By.id("dataSaveSucess")).isDisplayed())
		  {
			 System.out.println("Success");
			 statusTracker(br,"Pass","Verify switching feature from "+ on+" to "+ not,"Successfully switched feature","Successfully able to switch feature");
		  }
		  else
		  {
			 System.out.println("Fail");
			 statusTracker(br,"Fail","Verify switching feature from "+ on+" to "+ not,"Unsuccessfully switched feature","Successfully able to switch feature");
			 
			 driver.navigate().refresh();
			 focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature"+featureOrder+" > div.accordian-header > div.header-right")),br);
		  }	  	  		  
  }
  
  public void turnOnOffSelected(int featureOrder, String featureName,WebDriver driver, String br, int numSuspended,String[] tnSuspendedStatus)
  {
  	  Boolean onoff=driver.findElement(By.id("lines"+featureOrder)).isSelected();
  	  String on="OFF";
  	  String not="ON";
  	  if (onoff)
  	  {
  		  on="ON";
  		  not="OFF";
  	  }
		  
	  Boolean r=driver.findElement(By.id("lines"+featureOrder)).isSelected();
	  System.out.println("bool : "+r);
	  		  		  
	  int tncount=countNumberTns(featureOrder,featureName,driver);
	  System.out.println("tncount : "+tncount);
	  int rand=Integer.parseInt(randomNO(0,tncount-1));
	  int validTns = tncount-numSuspended;
	  int rand1=0;
	  if(validTns > 2)
			  rand1=Integer.parseInt(randomNO(0,tncount-1));
  
	  for(int i=1;i<1000;i++){}
	  System.out.println("ok1");

	  int newcount=rand+5;
	  int newcount1=rand1+5;
	  System.out.println("Ha in 0");
	  
	  while(tnSuspendedStatus[rand].equals("yes")){

			  rand=Integer.parseInt(randomNO(0,tncount-1));
			  newcount=rand+5;
			  System.out.println("Ha in 1");
	  }
	  if(validTns > 2)
		  while(tnSuspendedStatus[rand1].equals("yes") || rand==rand1){
			  System.out.println("Ha in 2: "+rand1);
			  rand1=Integer.parseInt(randomNO(0,tncount-1));
			  newcount1=rand1+5;
			  System.out.println("Ha in 2");
		  }  
	  
	  	System.out.println("data "+newcount+" "+newcount1);
	  	String Featurename="{\"name\":\"CallHold_FeatureName\",\"value\":\"Call Hold\",\"parameters\":[],\"text\":\"Call Hold\",\"exampleText\":\"Call Hold\"}";
 if(driver.findElements(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/div["+newcount+"]/label")).size() >0)
	   {
		  System.out.println("Here now1 check"+featureName+rand);
		  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/div["+newcount+"]/label")),br);
	   }
	   else
	   {
		  System.out.println("Here now2");
		  focusClick(driver,driver.findElement(By.id("check"+Featurename+rand1)),br);
	   }
	  
	   System.out.println("ok2");
	  
	   if(validTns > 2){
	   if(driver.findElements(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/div["+newcount1+"]/label")).size() >0)
	   {
		  System.out.println("Here now1 check"+featureName+rand1);
		  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/div["+newcount1+"]/label")),br);
	   }
	   else
	   {
		  System.out.println("Here now2");
		  focusClick(driver,driver.findElement(By.id("check"+Featurename+rand1)),br);
	   }
	   }
	  
	  System.out.println("ok4");
	  
	  for(int i=1;i<100;i++){}
	  int val=7;
  	  if(envvalue==0)
  		  val=17;
  	focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature"+featureOrder+"']/div[2]/form/div["+val+"]/button[2]")),br);
  			  
	  if(driver.findElements(By.cssSelector("div.modal-body-inner.ng-scope > div.ng-scope")).size()>0)
	  {
		  if(driver.findElement(By.cssSelector("div.modal-body-inner.ng-scope > div.ng-scope")).getText().contains("warning"))
		  {
			  System.out.println("Warning message is displayed hence proceeding. Warning message: " + driver.findElement(By.cssSelector("div.modal-body-inner.ng-scope > div.ng-scope")).getText());
			  focusClick(driver,driver.findElement(By.xpath("//div[@id='modal-warning']/div/div[2]/span[2]")),br);
		  }
	  }
	  
	  int chk=0;
	  do{
		 System.out.println("Processing!" +chk);
		 chk++;
	  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
	  
	  if(driver.findElements(By.id("dataSaveSucess")).size()>0)
	  {
		 System.out.println("Success");
		 statusTracker(br,"Pass","Verify order process when some lines are selected","Successfully processed order","Successfully be able to process order");
	  }
	  else
	  {
		 System.out.println("Fail");
		 statusTracker(br,"Pass","Verify order process when some lines are selected","Unsuccessfully processed order","Successfully be able to process order");
	  }
}
  
  public int countNumberTns(int featureOrder, String featureName, WebDriver driver)
  {
	  int numberOfTns=0;
	  for(int i=0;i<100;i++)
	  {
			  //if(driver.findElements(By.id("check"+featureName+i)).size()>0)

		  try{
			 if(driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/div["+(5+i)+"]/label")).isDisplayed())
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
			  i=101;
		  }
		  }		  
  
	  return numberOfTns;
  }

  public String[] suspendedStatus(int numberOfTns, int featureOrder,String featureName, WebDriver driver)
  {
	  String []a=new String[numberOfTns];
	  
	  for(int i=0;i<numberOfTns;i++)
	  {

		  if(isAttributePresent(driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/div["+(5+i)+"]/input")),"disabled"))
		  {
			  a[i]="yes";
			  System.out.println("yes");
		  }
		  else
		  {
			  a[i]="no";
			  System.out.println("no");	  
		  }		  
	  
	  }
	  return a;
  }
  
  public boolean suspended(String a[], WebDriver driver)
  {
	  Boolean result=false;
	  System.out.println("inside loop1");
	  for(int i=0;i<a.length;i++)
	  {
		  System.out.println("inside loop2");
		  if(a[i].equals("yes"))
		  {
			  System.out.println("inside loop3");
			  result=true;
		  }
	  }
	  return result;
  }
  
  public int getNumSuspended(String a[], WebDriver driver)
  {
	  int result=0;
	  for(int i=0;i<a.length;i++)
	  {
		  if(a[i].equals("yes"))
			  result++;
	  }
	  return result;
  }
  
  public void Unsavedpopup(String br, WebDriver driver, int featureOrder)
  {
	  logger.info("Unsavedpopup");
	
	  //driver.findElement(By.xpath(xpath_ACRunsavedpopup_xpath1)).click();
	  
	  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/div[4]/label")),br);

	  logger.info("TurnOFF/ON");
	  focusClick(driver,driver.findElement(By.linkText("Home")),br);
	  Boolean CH= driver.findElement(By.cssSelector("#modal-save > div.modal-container > div.modal-container-inner.modal-message > div.modal-body > div.modal-body-inner")).isDisplayed();
	  logger.info("pop up display");
	  if(CH==true)
	  {
		  System.out.println("In here 1");
		  focusClick(driver,driver.findElement(By.id("cancelSaveFeature")),br);
		  System.out.println("In here 2");
		  logger.info("pop up display1");
		  if(driver.findElements(By.xpath("//html/body/section/div[4]/div[2]")).size()>0)
		  {
			  logger.info("Success");
			  statusTracker(br,"Pass","Verify if clicking on cancel navigating to Feature Page","Successfully navigate back to ACR Page on clicking cancel","Success");
		  }
		  else
		  {
			  logger.info("Fail");
			  statusTracker(br,"Fail","Cancel did not work","Unsuccessful","Unable to process successfully");
		  }
	  }     
	  
	  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/div[4]/label")),br);
		  
	  logger.info("TurnON");
	  focusClick(driver,driver.findElement(By.linkText("Outgoing Calls")),br);

	  focusClick(driver,driver.findElement(By.xpath("//a[@id='unsavedFeature']/span")),br);
	  logger.info("OK");

	  if(driver.findElements(By.xpath("//html/body/section/div[4]/div[1]/div")).size()>0)
	  {
		  statusTracker(br,"Pass","Verify if clicking on OK navigating to Outgoing Calls Page","Successfully navigated to Outgoing calls Page on clicking OK","Success");
		//  state="Pass";
	  }
	  else
	  {
		  logger.info("Fail");
		  statusTracker(br,"Fail","OK dint work in Unsaved Pop Up","Unsuccessful","Unable to process successfully");
	  }
	 // return state;
  }
  
  public void Cancel(String br,WebDriver driver, int featureOrder) throws InterruptedException
  {
      logger.info("Cancel");
     Thread.sleep(2000);
     focusClick(driver,driver.findElement(By.linkText("Business Group")),br);

      focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature"+featureOrder+" > div.accordian-header > div.header-right")),br);
      boolean b= driver.findElement(By.id("lines"+featureOrder)).isSelected();
      
      focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/div[4]/label")),br);

    	  int val=7;
      	  if(envvalue==0)
      		  val=17;	
      	focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature"+featureOrder+"']/div[2]/form/div["+val+"]/button[1]")),br);
      
      int chk=0;
	  do{
		 System.out.println("Processing!" +chk);
		 chk++;
	  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
      
	  focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature"+featureOrder+" > div.accordian-header > div.header-right")),br);
	  
      if(b==driver.findElement(By.id("lines"+featureOrder)).isSelected())
      {
    	  logger.info("Success");
    	 // state="Pass";
    	  statusTracker(br,"Pass","Verify if the user is able to cancel the changes made","Successfully be able to cancel order","Should be able to successfully cancel the order");
      }
      else
      {
    	  logger.info("Fail");
    	  statusTracker(br,"Fail","Verify if the user is able to cancel the changes made","Cancelling the order did not revert the changes made","Should be able to successfully cancel the order");
      }
      //return state;
  }   
    
  public void execute(String br, WebDriver driver,String url, int loc, String name1) throws Exception {

	  xpath_GPSexecute_xpath1 = GPS.getProperty("xpath_GPSexecute_xpath1");
	  xpath_GPSexecute_xpath = GPS.getProperty("xpath_GPSexecute_xpath");
	  css_GPSexecute_css3 = GPS.getProperty("css_GPSexecute_css3");
	  xpath_GPSexecute_xpath4 = GPS.getProperty("xpath_GPSexecute_xpath4");

	  System.out.println("enne inge");
	  
	 // arrcount=0;
    int tlim=3;
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
    		  //TimeUnit.SECONDS);
      System.out.println("qtest1");
	  
      try {
  
    	  if(first==0)
          {
    		  login(driver,username,pwd);
          }
    	  System.out.println("a");
    	  if(!(InternalException(driver,br)))
          {
    	  switchTo(driver, "Admin",tlim,br);
    	  focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]/a")),br);
    	  //driver.get("https://voicemanager-staging.timewarnercable.com");
    	  do{
    	  }while(driver.findElements(By.xpath(xpath_GPSexecute_xpath1)).size()<0);
    	  
    	  System.out.println("a1");
    	  focusClick(driver,driver.findElement(By.xpath(xpath_GPSexecute_xpath1)),br);
    	  System.out.println("b");
    	  if(!(InternalException(driver,br)))
          {
    	  driver.manage().timeouts().implicitlyWait(tlim,TimeUnit.SECONDS);
    	  Thread.sleep(3000);
    	  System.out.println("checkpoint1");
    	  focusClick(driver,driver.findElement(By.linkText("Business Group")),br);
    	  //driver.findElement(By.xpath(xpath_GPSexecute_xpath4)).click();
    	  driver.manage().timeouts().implicitlyWait(tlim,TimeUnit.SECONDS);
    	  if(!(InternalException(driver,br)))
          {
    	  //size of list
    	  int count1=driver.findElements(By.xpath(xpath_GPSexecute_xpath)).size();
    	  System.out.println("count here: " + count1);   //a.findElements(By.tagName("id")).size());
    	  driver.manage().timeouts().implicitlyWait(0,TimeUnit.MILLISECONDS);
    	  	
    	  String featureName="Call Hold";
    	  int featureOrder=FeatureListIncoming(driver,count1,featureName);

    	  System.out.println("outttttttt");
    	  focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature"+featureOrder+" > div.accordian-header > div.header-right")),br);
    	  System.out.println("c");
    	  
    	  int numberOfTns=countNumberTns(featureOrder, featureName,driver);
    	  System.out.println("d: "+numberOfTns);
    	  tnSuspendedStatus=new String[numberOfTns];
    	  tnSuspendedStatus=suspendedStatus(numberOfTns,featureOrder, featureName,driver);
    	  
    	  System.out.println("e: "+tnSuspendedStatus.length);
    	  Boolean suspended=suspended(tnSuspendedStatus,driver);
    	  System.out.println("f");
    	  int numberSuspended=getNumSuspended(tnSuspendedStatus,driver);
    	  System.out.println("g");
    	  
    	  //String lineStatus=driver.findElement(By.xpath("//div[@id='collapseFeature4']/div/div/div/h4")).getText();

    	  String featureStatus="";
    	  if(suspended)
    		  statusTracker(br,"","Lines which are suspended: "+numberSuspended,"","");
    		  
    		  Boolean onoff=driver.findElement(By.id("lines"+featureOrder)).isSelected();
        	  if(onoff)
        		  System.out.println("Feature was ON");
        	  else
        		  System.out.println("Feature was OFF");
        	  
        	  turnOnOff(featureOrder,driver,br);
        	 
        	  
        	  onoff=driver.findElement(By.id("lines"+featureOrder)).isSelected();
        	  if(onoff)
        		  System.out.println("Feature was ON");
        	  else
        		  System.out.println("Feature was OFF");
        	  
        	  turnOnOff(featureOrder,driver,br);
        	  
        	  turnOnOffSelected(featureOrder,featureName,driver,br,numberSuspended,tnSuspendedStatus);
        	  
        	  Unsavedpopup(br,driver, featureOrder);
              Cancel(br,driver, featureOrder);
        	      	  
			//first=1;
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
     
    }
  }
}



