package ApolloNew;

import com.thoughtworks.selenium.Selenium;
import java.io.File;
import java.util.Locale;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class GPSACR extends CommonFunctions
{
                String table, tns[];
				int TN1;
                String tlimit,username,pwd;
                int tncount;
                String[] tnSuspendedStatus;
                                
              String xpath_GPSexecute_xpath1;
          	  String xpath_GPSexecute_xpath;
          	  String css_GPSexecute_css3;
          	  String xpath_GPSexecute_xpath4;
                
  public GPSACR()
  {
  }
  
  public GPSACR(String path) {
		this.path = path;
	}    
  
  public void turnOnOff(String feature, WebDriver driver, String br,int tab,int val)      
  {
	  	String onoff=driver.findElement(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/thead/tr/th[2]/div/input")).getAttribute("class");
  		System.out.println(onoff);
  		String on="ON";
  		String not="OFF";
  		if(onoff.contains("not"))
  		{
  			String Selected=driver.findElement(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/thead/tr/th[2]/div")).getAttribute("class"); 
  			if(Selected.contains("-"))
  			{	 
  				System.out.println("Some lines are Enabled");
  				on="Selected";
  			}
  			else	 			 
  				System.out.println("All lines are Enabled");  
  		}
  		else
  		{
  			System.out.println("All Lines are not enabled");
  			on="OFF";
  			not="ON";
  		}
	  	  
	  	  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature_"+feature+"']/div["+val+"]/table/thead/tr/th["+tab+"]/div/label")),br);
		  
	  	  focusClick(driver,driver.findElement(By.cssSelector("td > button.btn.btn-primary")),br);
	  	  		  
		  if(driver.findElements(By.cssSelector("#modal-warning > div.modal-container > div.modal-container-inner.modal-message > div.modal-header > h2")).size()>0)
		  {
			  if(driver.findElement(By.cssSelector("#modal-warning > div.modal-container > div.modal-container-inner.modal-message > div.modal-header > h2")).getText().contains("Warning"))
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
		  
		  if(driver.findElements(By.id("dataSaveSucess2")).size()>0 && driver.findElement(By.id("dataSaveSucess2")).isDisplayed())
		  {
			 System.out.println("Success");
			 statusTracker(br,"Pass","Verify switching feature from "+ on+" to "+ not,"Successfully switched feature","Successfully able to switch feature");
		  }
		  else
		  {
			 System.out.println("Fail");
			 statusTracker(br,"Fail","Verify switching feature from "+ on+" to "+ not,"Unsuccessfully switched feature","Successfully able to switch feature");
			 
			 driver.navigate().refresh();
			 focusClick(driver,driver.findElement(By.cssSelector("#accordion_"+feature+" > div.header-right > div.align-right")),br);			 
		  }	  	  		  
  }
  
  public void turnOnOffSelected(String featureName,WebDriver driver, String br, int rowCount,int numSuspended,int tab,String[] tnSuspendedStatus,int val)
  {
	  int rand=Integer.parseInt(randomNO(1,rowCount-1));
	  int validTns = rowCount-numSuspended;
	  int rand1=0;
	  if(validTns > 2)
			  rand1=Integer.parseInt(randomNO(1,rowCount-1));
  
	  for(int i=1;i<1000;i++){}
	  System.out.println("ok1");

	  int newcount=rand;
	  System.out.println("Ha in 0");
	  
	  while(tnSuspendedStatus[rand].equals("yes")){
			  rand=Integer.parseInt(randomNO(1,tncount-1));
			  newcount=rand;
			  System.out.println("Ha in 1");
	  }
	  
	  if(validTns > 2)
		  while(tnSuspendedStatus[rand1].equals("yes") || rand==rand1){
			  System.out.println("Ha in 2: "+rand1);
			  rand1=Integer.parseInt(randomNO(1,tncount-1));
			  System.out.println("Ha in 2");
		  }  
	  
	  	int num=Integer.parseInt(randomNO(1,10));
	  	System.out.println("data "+newcount);

	  		if(driver.findElements(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+newcount+"]/tr/td[2]/div/label")).size()>0)
	  		{
	  			focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+newcount+"]/tr/td[2]/div/label")),br);
	  		}
	  		else
	  		{
	  			System.out.println("Here now2");
	  			focusClick(driver,driver.findElement(By.id("l1f0_16"+num)),br);
	  		}
	  
	  		System.out.println("ok2");
	  
	  		if(validTns > 2){
	  			if(driver.findElements(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+newcount+"]/tr/td[2]/div/label")).size() >0)
	  			{
	  				focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+newcount+"]/tr/td[2]/div/label")),br);
	  			}
	  			else
	  			{
	  				System.out.println("Here now2");
	  				focusClick(driver,driver.findElement(By.id("l1f0_16"+num)),br);
	  			}
	  		}
	  		  	
	  System.out.println("ok4");
	  
	  for(int i=1;i<100;i++){}

  	  focusClick(driver,driver.findElement(By.cssSelector("td > button.btn.btn-primary")),br);
		  			  
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
	  
	  if(driver.findElements(By.id("dataSaveSucess2")).size()>0)
	  {
		 System.out.println("Success");
		 statusTracker(br,"Pass","Verify order process when some lines are selected","Successfully processed order","Successfully be able to process order");
	  }
	  else
	  {
		 System.out.println("Fail");
		 statusTracker(br,"Fail","Verify order process when some lines are selected","Unsuccessfully processed order","Successfully be able to process order");
		 driver.navigate().refresh();
		 focusClick(driver,driver.findElement(By.cssSelector("#accordion_"+featureName+" > div.header-right > div.align-right")),br);
	  }
  }
  public String[] suspendedStatus(int numberOfTns,String featureName, WebDriver driver,int tab)
	  {
		  String []a=new String[numberOfTns];
		  
		  for(int i=0;i<numberOfTns;i++)
		  {
			  if(tab==1)
			  {
			  if(isAttributePresent(driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/div["+(5+i)+"]/div/input")),"disabled"))
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
			  else{
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
		
		  
		  }
		  return a;
	  }
	public int Select_TN(WebDriver driver,String featureName,int rowCount,String br,int val)
	{
		int TN = 0;
		for(int j=1;j<rowCount;j++)
			{
				try
				{
			
					if(focusSearch(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+j+"]/tr/td[1]/i")),br))
					{
						System .out.println("TN is suspended");
						continue;
					}
					else if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+j+"]/tr/td[2]/div/input")).getAttribute("class").contains("not"))
					{ 
						System.out.println("tn2");
						TN=j;
						break;
					}
					else
					{
						focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+j+"]/tr/td[2]/div/label")),br);
						focusClick(driver,driver.findElement(By.cssSelector("td > button.btn.btn-primary")),br);
			  			  
						  if(driver.findElements(By.cssSelector("div.modal-body-inner.ng-scope > div.ng-scope")).size()>0)
						  {
							  if(driver.findElement(By.cssSelector("div.modal-body-inner.ng-scope > div.ng-scope")).getText().contains("warning"))
							  {
								  System.out.println("Warning message is displayed hence proceeding. Warning message: " + driver.findElement(By.cssSelector("div.modal-body-inner.ng-scope > div.ng-scope")).getText());
								  driver.findElement(By.xpath("//div[@id='modal-warning']/div/div[2]/span[2]")).click();
							  }
						  }
						int chk=0;
						do{	
							chk++;
						}while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
						if(driver.findElement(By.id("dataSaveSucess2")).isDisplayed())
						{
							TN=j;    
							break;
						}
						else
						{
							System.out.println("This feature cannot be  Enabled because "+driver.findElement(By.cssSelector("div.ng-scope > ul > li.ng-scope.ng-binding")).getText());   
							statusTracker(br,"Fail","","This feature cannot be  Enabled because "+driver.findElement(By.cssSelector("div.ng-scope > ul > li.ng-scope.ng-binding")).getText(),"");  
							TN=0;
						}
				
					}
				}
				catch(Exception e)
				{
					rowCount++;
				}			
			}
			return TN;	
		}
	
	public void turnoffon(String br,WebDriver driver, String status1,int TN1,int val,String feature)
	{
		String PhNum=driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/tbody["+TN1+"]/tr/td[1]")).getText();
		String Initialstate=driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/tbody["+TN1+"]/tr/td[3]")).getText();
		String Newstate="";
		
		driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/tbody["+TN1+"]/tr/td[4]/div/label")).click();
		driver.findElement(By.cssSelector("td > button.btn.btn-primary")).click();
			  
		  if(driver.findElements(By.cssSelector("div.modal-body-inner.ng-scope > div.ng-scope")).size()>0)
		  {
			  if(driver.findElement(By.cssSelector("div.modal-body-inner.ng-scope > div.ng-scope")).getText().contains("warning"))
			  {
				  System.out.println("Warning message is displayed hence proceeding. Warning message: " + driver.findElement(By.cssSelector("div.modal-body-inner.ng-scope > div.ng-scope")).getText());
				  driver.findElement(By.xpath("//div[@id='modal-warning']/div/div[2]/span[2]")).click();
			  }
		  }
		int chk=0;
		do{	
			chk++;
		}while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
		
		Newstate=driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/tbody["+TN1+"]/tr/td[3]")).getText();
		
		if(driver.findElements(By.id("dataSaveSucess2")).size()>0)
		  {
			 System.out.println("Success");
			 
			 statusTracker(br,"Pass","Verify order process for Turning ACR from "+Initialstate +" to: "+Newstate+ " For TN "+PhNum,"Successfully processed order","Successfully be able to process order");
		  }
		  else
		  {
			 System.out.println("Fail");
			 statusTracker(br,"Fail","Verify order process turning ACR from "+Initialstate +" to: "+Newstate+ " For TN "+PhNum,"Unsuccessfully processed order","Successfully be able to process order");
			 driver.navigate().refresh();
			 focusClick(driver,driver.findElement(By.cssSelector("#accordion_"+feature+" > div.header-right > div.align-right")),br);
		  }

	}

	public void Unsavedpopup(String br, WebDriver driver, String feature,int tab,int val)
	  {
		  logger.info("Unsavedpopup");

		  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature_"+feature+"']/div["+val+"]/table/thead/tr/th["+tab+"]/div/label")),br);
		  
		  logger.info("TurnOFF/ON");
		  driver.findElement(By.linkText("Home")).click();
		  Boolean CH= driver.findElement(By.cssSelector("#modal-save > div.modal-container > div.modal-container-inner.modal-message > div.modal-body > div.modal-body-inner")).isDisplayed();
		  logger.info("pop up display");
		  if(CH==true)
		  {
			  System.out.println("In here 1");
			  driver.findElement(By.id("cancelSaveFeature")).click();
			  System.out.println("In here 2");
			  CH= driver.findElement(By.cssSelector("#modal-save > div.modal-container > div.modal-container-inner.modal-message > div.modal-body > div.modal-body-inner")).isDisplayed();			  
			  logger.info("pop up display1");
			  if(CH==false)
			  {
				  logger.info("Success");
				  statusTracker(br,"Pass","Verify if clicking on cancel navigating to Feature Page","Successfully navigate back to Feature Page on clicking cancel","Success");
			  }
			  else
			  {
				  logger.info("Fail");
				  statusTracker(br,"Fail","Cancel did not work","Unsuccessful","Unable to process successfully");
			  }
		  }     
			  
		  driver.findElement(By.linkText("Outgoing Calls")).click();
			  
		  driver.findElement(By.xpath("//a[@id='unsavedFeature']/span")).click();
		  logger.info("OK");

		  if(driver.findElements(By.xpath("//html/body/section/div[4]/div[1]/div")).size()>0)
		  {
			  statusTracker(br,"Pass","Verify if clicking on OK navigating to Feature Page","Successfully navigated to Outgoing calls Page on clicking OK","Success");
			//  state="Pass";
		  }
		  else
		  {
			  logger.info("Fail");
			  statusTracker(br,"Fail","OK dint work in Unsaved Pop Up","Unsuccessful","Unable to process successfully");
		  }
		 // return state;
	  }
	  
	public void Cancel(String br,WebDriver driver, String feature,int tab,int val) throws InterruptedException
	  {
	      driver.findElement(By.linkText("Incoming Calls")).click();
	      Thread.sleep(2000);
	      focusClick(driver,driver.findElement(By.cssSelector("#accordion_"+feature+" > div.header-right > div.align-right")),br);
	      
	      focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature_"+feature+"']/div["+val+"]/table/thead/tr/th["+tab+"]/div/label")),br);
	    	
	      driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/tfoot/tr/td/button[1]")).click();
	      		  
		  Thread.sleep(2000);
	      if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/tfoot/tr/td/button[1]")).getAttribute("disabled").equals("disabled"))
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
	 	  
	 // arrcount=0;
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
 	     	  
					driver.manage().timeouts().implicitlyWait(tlim,TimeUnit.SECONDS);
    	  
					System.out.println("checkpoint1");
    	  
					//size of list
					if(!(InternalException(driver,br)))
					{
						int featureOrder=0;String featureName="ACR";
						
						Actions actions = new Actions(driver);
						WebElement mainMenu = driver.findElement(By.xpath(".//*[@id='accordion_"+featureName+"']/div"));
						actions.moveToElement(mainMenu);

						WebElement subMenu = driver.findElement(By.xpath(".//*[@id='newFeature_"+featureName+"']/div[2]"));
						actions.moveToElement(subMenu);
						actions.click().build().perform();
						
						if(driver.findElement(By.xpath(".//*[@id='newFeature_"+featureName+"']/div[2]")).isDisplayed())
						{
						    System.out.println("Tooltip is coming up fine");
						    statusTracker(br,"","ACR Modal pop up is displayed",driver.findElement(By.xpath(".//*[@id='newFeature_"+featureName+"']/div[2]")).getText(),"");						    
						 }
						else
						{
							statusTracker(br,"","ACR Modal pop up is not displayed","","");
						}

						
						focusClick(driver,driver.findElement(By.xpath(".//*[@id='accordion_"+featureName+"']/h3")),br);    	  
						System.out.println("c");

						int divval=3;
						try
  	       				{
  	       					if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/div/h2")).isDisplayed())
  	       					{
                              statusTracker(br,"","CF Modal slides shows are displayed","","");
                              int pg1=0,pg2=0;
                              driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/div/div/div[2]/a[2]")).click();
                              if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/div/div/div[2]/a[2]")).getAttribute("class").equals("active"))
                            	  pg1=1;
                              
                              driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/div/div/div[2]/a[1]")).click();
                              if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/div/div/div[2]/a[1]")).getAttribute("class").equals("active"))
                            	  pg2=1;
                              
                              if(pg1 == 1 && pg2 == 1)
                              {
                            	  statusTracker(br,"","ACR Modal slides Pages displayed on page navigation","","");
                		      }
                              else
                              {
                        		statusTracker(br,"","ACR Modal slides Pages not displayed on page navigation","","");
                              }
                              
                              driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/div/button")).click();
                              Thread.sleep(1000);
                              if(driver.findElements(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/div/h2")).size()>0)
                      		  {
                            	  statusTracker(br,"","ACR Modal slides are displayed on clicking the Close","","");
                      		  }
                              else
                              {
                            	  statusTracker(br,"","ACR Modal slides are not displayed on clicking the Close","","");
                              }
                              divval=3;
  	       					}
  	       				}
  	       				catch(Exception e)
  	       				{
  	       					statusTracker(br,"","ACR Modal pop up is not displayed second time","","");
  	       					first=1;
  	       				}												
    	  
						int rowCount=driver.findElements(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/table/tbody")).size();
						System.out.println("d: "+rowCount);

				    	tnSuspendedStatus=new String[rowCount];
				    	tnSuspendedStatus=suspendedStatus(rowCount,featureName,driver,divval);					    	  
				    	System.out.println("e: "+tnSuspendedStatus.length);
				    	
				    	Boolean suspended=suspended(tnSuspendedStatus,driver);
				    	System.out.println("f");
				    	
				    	int numberSuspended=getNumSuspended(tnSuspendedStatus,driver);
				    	System.out.println("g");
						
						turnOnOff("ACR",driver,br,2,divval);
						
						turnOnOff("ACR",driver,br,2,divval);
						
						turnOnOffSelected(featureName,driver, br, rowCount, numberSuspended,1, tnSuspendedStatus,divval);
						
						TN1= Select_TN(driver,featureName,rowCount,br,divval);		
						System.out.println("TN is"+TN1);
						
						if(TN1!= 0)
                        {
                            logger.info("print");
                            status1="On";
                            turnoffon(br,driver, status1,TN1,divval,featureName); 
                            
                            turnoffon(br,driver, status1,TN1,divval,featureName);
                        }
						
						Unsavedpopup(br,driver,featureName,2,divval);
			           // Cancel(br,driver,featureName,2,divval);
        	         	
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
