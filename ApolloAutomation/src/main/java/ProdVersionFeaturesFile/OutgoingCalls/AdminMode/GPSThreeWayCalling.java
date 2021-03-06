package ProdVersionFeaturesFile.OutgoingCalls.AdminMode;

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

public class GPSThreeWayCalling extends CommonFunctions
{
                String table, tns[];
                String tlimit,username,pwd;
                int tncount;
                String[] tnSuspendedStatus;
                
                
              String xpath_GPSexecute_xpath1;
              String xpath_GPSexecute_xpath2;
          	  String xpath_GPSexecute_xpath;
          	  String css_GPSexecute_css3;
          	  String xpath_GPSexecute_xpath4;
                
  public GPSThreeWayCalling()
  {
  }
  
  public GPSThreeWayCalling(String path) {
		this.path = path;
	}
    
  public void execute(String br, WebDriver driver,String url, int loc, String name1) throws Exception {

	  xpath_GPSexecute_xpath1 = GPS.getProperty("xpath_GPSexecute_xpath1");
	  xpath_GPSexecute_xpath2 = GPS.getProperty("xpath_GPSexecute_xpath2");
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
    	  }while(driver.findElements(By.xpath(xpath_GPSexecute_xpath2)).size()<0);
    	  
    	  System.out.println("a1");
    	  focusClick(driver,driver.findElement(By.xpath(xpath_GPSexecute_xpath2)),br);
    	  System.out.println("b");
 	  
   	  
    	  driver.manage().timeouts().implicitlyWait(tlim,TimeUnit.SECONDS);
    	  
    	  System.out.println("checkpoint1");
    	  if(!(InternalException(driver,br)))
          {
    	  //size of list
    	  int count1=driver.findElements(By.xpath(xpath_GPSexecute_xpath)).size();
    	  System.out.println("count here: " + count1);   //a.findElements(By.tagName("id")).size());
    	  driver.manage().timeouts().implicitlyWait(0,TimeUnit.MILLISECONDS);
    	  	
    	  String featureName="Three Way Calling";
    	  int featureOrder=FeatureListIncoming(driver,count1,featureName);

    	  System.out.println("outttttttt");
    	  focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature"+featureOrder+" > div.accordian-header > div.header-right")),br);
		  System.out.println("c");
    	  
    	  int numberOfTns=countNumberTns(featureOrder, featureName,driver,2);
    	  System.out.println("d: "+numberOfTns);
    	  tnSuspendedStatus=new String[numberOfTns];
    	  tnSuspendedStatus=suspendedStatus(numberOfTns,featureOrder, featureName,driver,2);
    	  
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
        	  
        	  turnOnOff(featureOrder,driver,br,2);
        	 
        	  
        	  onoff=driver.findElement(By.id("lines"+featureOrder)).isSelected();
        	  if(onoff)
        		  System.out.println("Feature was ON");
        	  else
        		  System.out.println("Feature was OFF");
        	  
        	  turnOnOff(featureOrder,driver,br,2);
        	  
        	  turnOnOffSelected(featureOrder,featureName,driver,br, numberSuspended,2,tnSuspendedStatus);
        	  
        	  Unsavedpopup(br,driver, featureOrder,2);
              Cancel(br,driver, featureOrder,2);
        	      	  
			//first=1;
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
     
    }
  }
}







