package ApolloNew;

import com.thoughtworks.selenium.Selenium;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

public class GPSOfficeAnywhere extends CommonFunctions
{  String table, tns[];
String tlimit,username,pwd,pin,confirmnewpin,check;
String Acccode,phoneline,phoneline1;
int rowCount,tab,TN1=1;
String[] tnSuspendedStatus;
String schk1,phoneline_ac;

          	  String xpath_GPSexecute_xpath;
          	  String OAWxpath_GPSexecute_newfeature;
          	  String css_GPSexecute_css3;
          	  String xpath_GPSexecute_xpath5;
          	  String xpath_GPSexecute_xpath1;
          	  String OAWxpath_GPSexecute_save;
          	  String OAWxpath_GPSexecute_cancel;
              String OAWxpath_GPSexecute_turnOnOff;
              String OAWxpath_GPSexecute_TNinput;
             
  public GPSOfficeAnywhere()
  {
  }
  
  public GPSOfficeAnywhere(String path) {
		this.path = path;
	}
  public void switchTo(WebDriver driver, String text,int tlim, String br)  
	{
		//driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(tlim,TimeUnit.SECONDS);
		System.out.println("yup0");
		System.out.println("text value "+text);
		
		if(text.equals("Admin") || text.equals("admin"))
		{
			try{
				
			if(driver.findElement(By.linkText("Switch to Admin mode")).isDisplayed())
	  	  	{
				System.out.println("yup1");
	  		  	focusClick(driver,driver.findElement(By.linkText("Switch to Admin mode")),br);
	  		  	System.out.println("yup2");
	  			if(focusSearch(driver,driver.findElement(By.cssSelector("#modal-save > div.modal-container > div.modal-footer")),br))
	  			{
	  				driver.navigate().refresh();
	  				focusClick(driver,driver.findElement(By.linkText("Switch to Admin mode")),br);
	  			}
	  	  	}
			}
			catch(Exception e)
			{
				System.out.println("Exception caught");
			}
		}
		System.out.println("yup-");
		if(text.equals("User") || text.equals("user"))
		{
			try{
			if(driver.findElement(By.linkText("Switch to User mode")).isDisplayed())
	  	  	{
				System.out.println("yup3");
				focusClick(driver,driver.findElement(By.linkText("Switch to User mode")),br);
		  		System.out.println("yup4");
		  		if(focusSearch(driver,driver.findElement(By.cssSelector("#modal-save > div.modal-container > div.modal-footer")),br))
	  			{
	  				driver.navigate().refresh();
	  				focusClick(driver,driver.findElement(By.linkText("Switch to User mode")),br);
	  			}
	  	  	}
			}
			catch(Exception e)
			{
				System.out.println("Exception caught");
			}
		}
		driver.manage().timeouts().implicitlyWait(tlim,TimeUnit.SECONDS);
		
	}
  public int FeatureListIncoming(WebDriver driver,int count1, String feature)
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
    				if(list.equals(feature))
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

  public int Select_TN(WebDriver driver,String feature,int rowCount,String br,int tab,int divval)
	{
		int TN = 0;
		for(int j=1;j<rowCount;j++)
			{
				try
				{
			
					if(focusSearch(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+j+"]/tr[1]/td[1]/i")),br))
					{
						System .out.println("TN is suspended");
						continue;
					}                                    
					else if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+j+"]/tr[1]/td[2]/div/input")).getAttribute("class").contains("not"))
					{ 
						System.out.println("tn2");
						TN=j;
						break;
					}
					else
					{
						focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+j+"]/tr[1]/td[2]/div/label")),br);
						
						focusClick(driver,driver.findElement(By.xpath(OAWxpath_GPSexecute_save)),br);
			  			  						  
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
  public void turnOnOff(String feature, WebDriver driver, String br,int tab,int divval)
  {
	  		String onoff=driver.findElement(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/thead/tr/th[2]/div/input")).getAttribute("class");
	  		System.out.println(onoff);
	  		String on="ON";
	  		String not="OFF";
	  		if(onoff.contains("not"))
	  		{
	  			String Selected=driver.findElement(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/thead/tr/th[2]/div")).getAttribute("class"); 
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
		
		driver.findElement(By.xpath(OAWxpath_GPSexecute_turnOnOff)).click();
		
		focusClick(driver,driver.findElement(By.xpath(OAWxpath_GPSexecute_save)),br);
				  
		 int chk=0;
		 do{
			System.out.println("Processing!" +chk);
			chk++;
		  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
		  
		  if(driver.findElements(By.id("dataSaveSucess")).size()>0)
		  {
			 System.out.println("Success");
			 statusTracker(br,"Pass","Verify switching feature from "+ on+" to "+ not,"Successfully switched feature","Successfully able to switch feature");
		  }
		  else
		  {
			 System.out.println("Fail");
			 statusTracker(br,"Fail","Verify switching feature from "+ on+" to "+ not,"Unsuccessfully switched feature","Successfully able to switch feature");
			 
			 driver.navigate().refresh();
			 driver.findElement(By.cssSelector("#accordion_"+feature+" > div.header-right > div.align-right")).click();
		  }	  	  		  
  }
  
public void turnOnOffSelected(String feature,WebDriver driver, String br, int numSuspended,int tab,int divval)
  {
	  	 int rowCount=driver.findElements(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody")).size();
		 System.out.println("Number of TNs present are"+rowCount);
		 int rand=Integer.parseInt(randomNO(1,rowCount-1));
		 int validTns = rowCount-numSuspended;
		 int rand1=0;
		 if(validTns > 2)
		 rand1=Integer.parseInt(randomNO(1,rowCount-1));
	  
		  for(int i=1;i<1000;i++){}
		  System.out.println("ok1");
	      String Status="";		
		  int newcount1=rand1;
		  System.out.println("Ha in 0");
		  
		  while(tnSuspendedStatus[rand-1].equals("yes")){
				  rand=Integer.parseInt(randomNO(1,rowCount-1));				  
				  System.out.println("Ha in 1");
		  }
		  if(validTns > 2)
			  while(tnSuspendedStatus[rand1-1].equals("yes") || rand==rand1){
				  System.out.println("Ha in 2: "+rand1);
				  rand1=Integer.parseInt(randomNO(1,rowCount-1));
				  newcount1=rand1;
				  System.out.println("Ha in 2");
			  } 
		 		 
		   if(driver.findElements(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+rand+"]/tr[1]/td["+tab+"]/div/label")).size() >0)			
		   {			    
			driver.findElement(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+rand+"]/tr[1]/td["+tab+"]/div/label")).click();			
		   }
		   		  
		   System.out.println("ok2");
		  
		   if(validTns > 2)
		   {
		    if(driver.findElements(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+newcount1+"]/tr[1]/td["+tab+"]/div/label")).size() >0)			 
		     {			  
			  driver.findElement(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+newcount1+"]/tr[1]/td["+tab+"]/div/label")).click();		   
		     }		  
		   }
		  
		 
		  System.out.println("ok4");
		  focusClick(driver,driver.findElement(By.xpath(OAWxpath_GPSexecute_save)),br);
		  
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
			 driver.navigate().refresh();
			 driver.findElement(By.cssSelector("#accordion_"+feature+" > div.header-right > div.align-right")).click();
		  }
	}
  
 

  public String[] suspendedStatus(int numberOfTns,String feature, WebDriver driver,int divval)
  {
	  String []a=new String[numberOfTns];
	  
	  for(int i=1;i<=numberOfTns;i++)
	  {
		  
			  if(driver.findElement(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+i+"]/tr[1]/td[1]/i")).isDisplayed())
				  
			  {
				  a[i-1]="yes";
				  System.out.println("line suspended");
				 
			  }
			  else
			  {
				  a[i-1]="no";
				  
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
  
  
  public void Unsavedpopup(String br, WebDriver driver, int divval,int tab) throws InterruptedException
  {
	  logger.info("Unsavedpopup");
	  driver.findElement(By.xpath(OAWxpath_GPSexecute_turnOnOff)).click();
      
	  logger.info("TurnOFF/ON");
	  driver.findElement(By.linkText("Home")).click();
	  Boolean CH= driver.findElement(By.cssSelector("#modal-save > div.modal-container > div.modal-container-inner.modal-message > div.modal-body > div.modal-body-inner")).isDisplayed();
	  logger.info("pop up display");
	  if(CH==true)
	  {
		  System.out.println("In here 1");
		  driver.findElement(By.id("cancelSaveFeature")).click();
		  System.out.println("In here 2");
		  logger.info("pop up display1");
		  CH= driver.findElement(By.cssSelector("#modal-save > div.modal-container > div.modal-container-inner.modal-message > div.modal-body > div.modal-body-inner")).isDisplayed();
		  logger.info("pop up display");
		  if(CH==true)
		  {
			  logger.info("Fail");
			  statusTracker(br,"Fail","Cancel did not work","Unsuccessful","Unable to process successfully");
		 }
		  else
		  {
			  logger.info("Success");
			  statusTracker(br,"Pass","Verify if clicking on cancel navigating to Feature Page","Successfully navigate back to Feature Page on clicking cancel","Success");			 
		  }
	  }     	 
	  
	  logger.info("TurnON");
	 
	  driver.findElement(By.linkText("Outgoing Calls")).click();
		  
	  driver.findElement(By.xpath("//a[@id='unsavedFeature']/span")).click();
	  do{

	  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
	  Thread.sleep(2000);
	  CH= driver.findElement(By.cssSelector("#modal-save > div.modal-container > div.modal-container-inner.modal-message > div.modal-body > div.modal-body-inner")).isDisplayed();
	  logger.info("OK");

	  if(CH==false)
	  {
		  statusTracker(br,"Pass","Verify if clicking on OK navigating to Feature Page","Successfully navigated to Outgoing calls Page on clicking OK","Success");
		//  state="Pass";
	  }
	  else
	  {
		  logger.info("Fail");
		  statusTracker(br,"Fail","OK dint work in Unsaved Pop Up","Unsuccessful","Unable to process successfully");
	  }
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Mobility Package")).click();
	  
	  do{

		  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
	  Thread.sleep(2000);
	  
	  driver.findElement(By.cssSelector("#accordion_OAW > div.header-right > div.align-right")).click();
	  
	 
  }
  
  public void Cancel(String br,WebDriver driver, String feature,int tab,int divval) throws InterruptedException
  {                                                  
      focusClick(driver,driver.findElement(By.xpath(OAWxpath_GPSexecute_turnOnOff)),br);
    	
      driver.findElement(By.xpath(OAWxpath_GPSexecute_cancel)).click();
      		  
	  Thread.sleep(2000);
      if(!(driver.findElement(By.xpath(OAWxpath_GPSexecute_cancel)).isEnabled()))
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
  }
     
  public String OfficePin(String feature, String br,String pin, String confirmnewpin,String check,WebDriver driver,int value) throws Exception
  {
          
	 
      String schk="Fail";
      focusClick1(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/table/tbody["+TN1+"]/tr/td[2]/div/label")));       
                
      driver.findElement(By.xpath("(//input[@id='l1p2'])["+TN1+"]")).clear();  
      driver.findElement(By.xpath("(//input[@id='l1p2'])["+TN1+"]")).sendKeys(pin);
     
      driver.findElement(By.xpath("(//input[@id='l1cp2'])["+TN1+"]")).clear();
      driver.findElement(By.xpath("(//input[@id='l1cp2'])["+TN1+"]")).sendKeys(confirmnewpin);
    
      focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_OAW']/div[3]/table/tfoot/tr/td/button[2]")),br);
      
      logger.info("after submitting");
      
      Thread.sleep(3000);
    //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      
      
      if(value==1){
    	  Thread.sleep(2000);
      if((focusSearch(driver,driver.findElement(By.cssSelector("#dataSaveSucess2")),br)))
     {                                  
                  logger.info("printing");
       statusTracker(br,"Pass","Verify if success message is displayed when adding "+check+" PIN","Error message is displayed:"+driver.findElement(By.cssSelector("#dataSaveSucess2")).getText(),"Success message should be displayed");
     }
      
     
      else
      {
                  
                  statusTracker(br,"Fail","Verify if success not displayed message is displayed when adding "+check+" PIN","Error message is not displayed","Error message should be displayed");
      }
      }
      else if(value==2)
      {if((focusSearch(driver,driver.findElement(By.cssSelector(".message-box.ng-scope")),br)))
      {                                  
          logger.info("printing");
statusTracker(br,"Pass","Verify if error message is displayed when adding "+check+" PIN","Error message is displayed:"+driver.findElement(By.cssSelector(".message-box.ng-scope")).getText(),"Error message should be displayed");
}


else
{
          
          statusTracker(br,"Fail","Verify if error message is displayed when adding "+check+" PIN","Error message is not displayed","Error message should be displayed");
}
      }
      schk ="Pass";
      
      return schk;

  }
  public String PinValidation(String feature,String br,WebDriver driver) throws Exception
  {
                
                  //String pin1 = randomNO(9999,1000);
                  String schk ="Fail";
                  String pin,pin2;
                  statusTracker(br,"","The officeanywhere Defect Validation","",""); 
                  schk=OfficePin(feature,br,"","1234","Blank New ",driver,2);
                  
                 schk=OfficePin(feature,br,"1234","","Blank Confirm Field",drive,2);
     Thread.sleep(2000);
     System.out.println("phoneline"+phoneline);
     
                schk=OfficePin(feature,br,phoneline_ac,phoneline_ac,"Self",driver,2);
                  
                  schk=OfficePin(feature,br,"3456","3456","Consecutive",driver,2);
                  logger.info("order done");
                  
                  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            
                  pin=randomNO(999,100);
                  schk=OfficePin(feature,br,pin,pin,"less than 4 digit",driver,2);
                  logger.info("4 digits");
                // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                  
                  pin=randomNO(9999,1000);
                  pin2=randomNO(9999,1000);
                  schk=OfficePin(feature,br,pin,pin2,"different confirm",drive,2);
      logger.info("different");
      
                   
     // schk = OfficePin(feature,br,"9573","9573","same PINs",driver,1);
    //  logger.info("correct pin");
      //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       schk="Pass";
                  return schk;
  }
    
  
	  private void focusClick1(WebDriver driver, Object click) {
	// TODO Auto-generated method stub
	
}

	private void focusClick(WebDriver driver, Object click) {
	// TODO Auto-generated method stub
	
}

	public void execute(String br, WebDriver driver,String url, int loc, String name1) throws Exception {

          xpath_GPSexecute_xpath1 = GPS.getProperty("xpath_GPSexecute_xpath1");
          OAWxpath_GPSexecute_newfeature = GPS.getProperty("OAWxpath_GPSexecute_newfeature");
          xpath_GPSexecute_xpath5 = GPS.getProperty("xpath_GPSexecute_xpath5");
          OAWxpath_GPSexecute_save = GPS.getProperty("OAWxpath_GPSexecute_save");
          OAWxpath_GPSexecute_cancel = GPS.getProperty("OAWxpath_GPSexecute_cancel");
         // OAWxpath_GPSexecute_lable = GPS.getProperty("OAWxpath_GPSexecute_lable");
        
          OAWxpath_GPSexecute_turnOnOff = GPS.getProperty("OAWxpath_GPSexecute_turnOnOff");
            
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

                            switchTo(driver, "Admin",tlim,br);
          
                            focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]/a")),br);                      
                            //driver.get("https://voicemanager-staging.timewarnercable.com");
                            do{
                            }while(driver.findElements(By.xpath(xpath_GPSexecute_xpath5)).size()<0);
          
                        
                            focusClick(driver,driver.findElement(By.xpath(xpath_GPSexecute_xpath5)),br);             
                            System.out.println("b");
                         
                            driver.manage().timeouts().implicitlyWait(tlim,TimeUnit.SECONDS);
          
                            System.out.println("checkpoint1");
  
                            	String feature="OAW";                                     	                                  	
                            	Actions actions = new Actions(driver);
        						WebElement mainMenu = driver.findElement(By.xpath(".//*[@id='accordion_"+feature+"']/div"));
        						actions.moveToElement(mainMenu);
        						                                                  
        						WebElement subMenu = driver.findElement(By.xpath(OAWxpath_GPSexecute_newfeature));
        						actions.moveToElement(subMenu);
        						actions.click().build().perform();
        						
        						if(driver.findElement(By.xpath(OAWxpath_GPSexecute_newfeature)).isDisplayed())
        						{
        						    System.out.println("Tooltip is coming up fine");
        						    statusTracker(br,"","OAW Modal pop up is displayed",driver.findElement(By.xpath(OAWxpath_GPSexecute_newfeature)).getText(),"");						    
        						 }
        						else
        						{
        							statusTracker(br,"","OAW Modal pop up is not displayed","","");
        						}
                            	
                            	focusClick(driver,driver.findElement(By.xpath("//*[@id='accordion_"+feature+"']/h3")),br);       
                            	System.out.println("c");
                            	int divval=3;
                            	try
                            	{
                            		if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/div/h2")).isDisplayed())
                            		{
                                        
                                          
                                          driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/div/button")).click();
                                          Thread.sleep(1000);
                                          if(driver.findElements(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/div/h2")).size()>0)
                                  		  {
                                        	  statusTracker(br,"","OAW Modal slides are displayed on clicking the Close","","");
                                  		  }
                                          else
                                          {
                                        	  statusTracker(br,"","OAW Modal slides are not displayed on clicking the Close","","");
                                          }
                                          divval=3;
                            		}
                            	}
                            	catch(Exception e)
                            	{
                                          statusTracker(br,"","OAW Modal slides shows are not displayed from second time","","");
                                          first=1;
                            	}                                    	
                            	
                            	int numberOfTns=driver.findElements(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody")).size();                                  
                            	System.out.println("Number of TNs present are"+numberOfTns);
                            	
                            	tnSuspendedStatus=new String[numberOfTns];
                            	tnSuspendedStatus=suspendedStatus(numberOfTns,"OAW",driver,divval);
                          
                            	System.out.println("e: "+tnSuspendedStatus.length);
                           
                            	Boolean suspended=suspended(tnSuspendedStatus,driver);
                            	System.out.println("f"+suspended);
                            	int numberSuspended=getNumSuspended(tnSuspendedStatus,driver);
                            	System.out.println("g"+numberSuspended);
                          
                            	statusTracker(br,"","Lines which are suspended: "+numberSuspended,"","");
                            	
                            	turnOnOff(feature,driver,br,2,divval);
                            	
                            	turnOnOffSelected(feature,driver,br,numberSuspended,2,divval);
                            	
                            	Unsavedpopup(br,driver, divval,tab);
                            	
                            	Cancel(br,driver,feature,2,divval);
                          
                            	TN1=Select_TN(driver,"OAW",numberOfTns,br,2,divval);
                            	System.out.println("TN1"+TN1);
 
                            	phoneline1=driver.findElement(org.openqa.selenium.By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[1]/td[1]")).getText();
                            	phoneline=phoneline1.substring(0, 8);
                            	System.out.println("phoneline"+phoneline);       
                            	PinValidation(feature,br,driver);

                          
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

                            
                  
                        