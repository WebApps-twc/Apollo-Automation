package ProdVersionFeaturesFile.MobilityPackage.AdminMode;

import java.io.File;
import java.io.PrintStream;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

import ProdVersionFeaturesFile.CommonFunctions;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class GPSSimultaneousRing extends CommonFunctions
{
                String table, tns[];
                String tlimit,username,pwd;
                String Acccode,phoneline,phoneline1;
                int rowCount,TN1,bval=1;
                String[] tnSuspendedStatus;
                
                
                String xpath_GPSexecute_xpath1;
                String SiRxpath_GPSexecute_newfeature;
                String SiRxpath_GPSexecute_turnOnOff;
                String SiRxpath_GPSexecute_save;
                String SiRxpath_GPSexecute_cancel;
                String SiRxpath_GPSexecute_lable;
                String SiRxpath_GPSexecute_TNinput;
                String SiRxpath_GPSexecute_save1;
                String SiRxpath_GPSexecute_acccode;
                String SiRxpath_GPSexecute_acccode1;
                
  public GPSSimultaneousRing()
  {
  }
  
  public GPSSimultaneousRing(String path) {
                                this.path = path;
                }
  
  public void turnOnOff(String feature, WebDriver driver, String br,int tab,int divval)
  {	  
	  int tab1=tab;
	  		String onoff=driver.findElement(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/thead/tr/th["+tab+"]/div/input")).getAttribute("class");
	  		System.out.println(onoff);
	  		String on="ON";
	  		String not="OFF";
	  		if(onoff.contains("not"))
	  		{
	  			String Selected=driver.findElement(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/thead/tr/th["+tab+"]/div")).getAttribute("class"); 
	  			if(Selected.contains("dash"))
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
		
		driver.findElement(By.xpath(SiRxpath_GPSexecute_turnOnOff)).click();
		focusClick(driver,driver.findElement(By.xpath(SiRxpath_GPSexecute_save)),br);

		 int chk=0;
		 do{
			System.out.println("Processing!" +chk);
			chk++;
		  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
		  
		  if(driver.findElements(By.id("dataSaveSucess2")).size()>0)
		  {
			 System.out.println("Success");
			 statusTracker(br,"Pass","Verify switching feature from "+ on+" to "+ not,"Successfully switched feature","Successfully able to switch feature");
		  }
		  else
		  {
			 System.out.println("Fail");
			 statusTracker(br,"Fail","Verify switching feature from "+ on+" to "+ not,"Unsuccessfully switched feature","Successfully able to switch feature");
			
		  }	  	  		  
  }
  
public void turnOnOffSelected(String feature,WebDriver driver, String br, int numSuspended,int tab,int divval)
  {
	int tab1=tab;
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
		  focusClick(driver,driver.findElement(By.xpath(SiRxpath_GPSexecute_save)),br);
		 
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
			 statusTracker(br,"Pass","Verify order process when some lines are selected","Unsuccessfully processed order","Successfully be able to process order");

		  }
	}
  
  public String[] suspendedStatus(int numberOfTns,String feature, WebDriver driver,int divval)
  {
	  String []a=new String[numberOfTns];
	  
	  for(int i=1;i<=numberOfTns;i++)
	  {
		  
			  if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/table/tbody["+i+"]/tr[1]/td[1]/i")).isDisplayed())
				  
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
  
  public void Unsavedpopup(String br, WebDriver driver, int divval,int tab,String feature) throws InterruptedException
  {
	  int tab1=tab;
	  logger.info("Unsavedpopup");
	  driver.findElement(By.xpath(SiRxpath_GPSexecute_turnOnOff)).click();
      
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

	  driver.findElement(By.linkText("Mobility Package")).click();
	  
	  do{

		  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
	  Thread.sleep(3000);
	  driver.findElement(By.cssSelector("#accordion_SimultaneousRing > div.header-right > div.align-right")).click();
  }
  
  public void Cancel(String br,WebDriver driver, String feature,int tab,int divval) throws InterruptedException
  { 	  
      focusClick(driver,driver.findElement(By.xpath(SiRxpath_GPSexecute_turnOnOff)),br);
    	
      driver.findElement(By.xpath(SiRxpath_GPSexecute_cancel)).click();
      		  
	  Thread.sleep(2000);
      if(!(driver.findElement(By.xpath(SiRxpath_GPSexecute_cancel)).isEnabled()))
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
     
  public int Select_TN(WebDriver driver,String featureName,int rowCount,String br,int tab,int divval)
	{
		int TN = 0, tab1=tab;;
		for(int j=1;j<rowCount;j++)
			{
				try
				{
					
					if(focusSearch(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+divval+"]/table/tbody["+j+"]/tr[1]/td[1]/i")),br))
					{
						System .out.println("TN is suspended");
						continue;
					}                                    
					else if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+divval+"]/table/tbody["+j+"]/tr[1]/td[2]/div/input")).getAttribute("class").contains("not"))
					{ 
						System.out.println("tn2");
						TN=j;
						break;
					}
					else
					{
						focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+divval+"]/table/tbody["+j+"]/tr[1]/td["+tab+"]/div/label")),br);
						focusClick(driver,driver.findElement(By.xpath(SiRxpath_GPSexecute_save)),br);

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
  
  public void turnoff(WebDriver driver, String br, String acc,int divval, String feature,int val)
  	{
                  String initialstate="On", chngetostate="Off", accst=acc;int val1=val;

                  focusClick(driver,driver.findElement(By.xpath(SiRxpath_GPSexecute_lable+"/tbody["+TN1+"]/tr[2]/td/div/div/div/div[1]/span[1]/label")),br);
                  
                  for(int i=1;i<100;i++){}

                  focusClick(driver,driver.findElement(By.xpath(SiRxpath_GPSexecute_save1+"/tbody["+TN1+"]/tr[2]/td/div/div/div/div[2]/button[2]")),br);
                  int chk=0;
                  do{
                	  chk++;
                  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                  if(driver.findElement(By.id("dataSaveSucess2")).isDisplayed())
                  {
                	  logger.info("Success");
                	  statusTracker(br,"Pass","Verify the order process for changing the status from: "+initialstate +" to: "+chngetostate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
                  }
                  else
                  {
                	  logger.info("Fail");
                	  statusTracker(br,"Fail","Verify the order process for changing the status from: "+initialstate +" to: "+chngetostate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/div[2]/div/div/ul/li")).getText(),"Unable to process successfully");
                  }
                  for(int i=1;i<100;i++){}

                  focusClick(driver,driver.findElement(By.xpath(SiRxpath_GPSexecute_lable+"/tbody["+TN1+"]/tr[2]/td/div/div/div/div[1]/span[1]/label")),br);
                  String num=randomNO(3333,6666);
                  driver.findElement(By.xpath(SiRxpath_GPSexecute_TNinput+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[1]/input")).clear();
                  driver.findElement(By.xpath(SiRxpath_GPSexecute_TNinput+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[1]/input")).sendKeys(phoneline+num);
                  for(int i1=1;i1<100;i1++){}

                  focusClick(driver,driver.findElement(By.xpath(SiRxpath_GPSexecute_save1+"/tbody["+TN1+"]/tr[2]/td/div/div/div/div[2]/button[2]")),br);
      
                  do{
                	  chk++;
                  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                  if(driver.findElement(By.id("dataSaveSucess2")).isDisplayed())
                  {
                	  logger.info("Success");
                	  statusTracker(br,"Pass","Verify the order process for changing the status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
                  }
                  else
                  {
                	  logger.info("Fail");
                	  statusTracker(br,"Fail","Verify the order process for changing the status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/div[2]/div/div/ul/li")).getText(),"Unable to process successfully");
                  }
  		}
  
  public void turnOn(WebDriver driver, String br, String acc, int divval,String feature,int val)
  	{
      			  String initialstate="Off", chngetostate="On",accst=acc; int val1=val;
      			  
      			  focusClick(driver,driver.findElement(By.xpath(SiRxpath_GPSexecute_lable+"/tbody["+TN1+"]/tr[2]/td/div/div/div/div[1]/span[1]/label")),br);
                  String num=randomNO(3333,6666);
                  driver.findElement(By.xpath(SiRxpath_GPSexecute_TNinput+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[1]/input")).clear();
                  driver.findElement(By.xpath(SiRxpath_GPSexecute_TNinput+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[1]/input")).sendKeys(phoneline+num);
                  for(int i=1;i<100;i++){}

                  focusClick(driver,driver.findElement(By.xpath(SiRxpath_GPSexecute_save1+"/tbody["+TN1+"]/tr[2]/td/div/div/div/div[2]/button[2]")),br);
                  int chk=0;
                  do{
                	  chk++;
                  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                  if(driver.findElement(By.id("dataSaveSucess2")).isDisplayed())
                  {
                	  logger.info("Success");
                	  statusTracker(br,"Pass","Verify the order process for changing the status from: "+ initialstate +" to: "+chngetostate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
                  }
                  else
                  {
                	  logger.info("Fail");
                	  statusTracker(br,"Fail","Verify the order process for changing the status from: "+ initialstate +" to: "+chngetostate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/div[2]/div/div/ul/li")).getText(),"Unable to process successfully");
                  }
        
                  for(int i1=1;i1<100;i1++){}
                  focusClick(driver,driver.findElement(By.xpath(SiRxpath_GPSexecute_lable+"/tbody["+TN1+"]/tr[2]/td/div/div/div/div[1]/span[1]/label")),br);
      
                  focusClick(driver,driver.findElement(By.xpath(SiRxpath_GPSexecute_save1+"/tbody["+TN1+"]/tr[2]/td/div/div/div/div[2]/button[2]")),br);
      
                  do{             
                	  chk++;
                  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                  if(driver.findElement(By.id("dataSaveSucess2")).isDisplayed())
                  {
                	  logger.info("Success");
                	  statusTracker(br,"Pass","Verify the order process for changing the status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
                  }
                  else
                  {
                	  logger.info("Fail");
                	  statusTracker(br,"Fail","Verify the order process for changing the status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/div[2]/div/div/ul/li")).getText(),"Unable to process successfully");
                  }                 
  	}
  
  public void EditTn(WebDriver driver, String br,int divval,String feature,int val)
  	{  
                  for(int a1=1;a1<6;a1++){
                  String num=randomNO(3333,6666);
                  driver.findElement(By.xpath(SiRxpath_GPSexecute_TNinput+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr["+a1+"]/td[1]/input")).clear();
                  driver.findElement(By.xpath(SiRxpath_GPSexecute_TNinput+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr["+a1+"]/td[1]/input")).sendKeys(phoneline+num);
                  if(val==2){
                      driver.findElement(By.xpath(SiRxpath_GPSexecute_acccode+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr["+a1+"]/td[2]/input")).clear();
         			   driver.findElement(By.xpath(SiRxpath_GPSexecute_acccode+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr["+a1+"]/td[2]/input")).sendKeys("8956325485");}
                  for(int i=1;i<10;i++){}
                  }
                  focusClick(driver,driver.findElement(By.xpath(SiRxpath_GPSexecute_save1+"/tbody["+TN1+"]/tr[2]/td/div/div/div/div[2]/button[2]")),br);
                  int chk=0;
                  do{
                	  chk++;
                  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                  if(driver.findElement(By.id("dataSaveSucess2")).isDisplayed())
                  {
                	  logger.info("Success");
                	  statusTracker(br,"Pass","Verify order process for editing TN","Successfully be able to process order","Successfully processed order");
                  }
                  else
                  {
                	  logger.info("Fail");
                	  statusTracker(br,"Fail","Verify order process for editing TN","Unable to process order","Unable to process successfully");
                  }
  	}
  
  public String TNcheck(String ac, String acode,WebDriver driver, int check,String br,int divval,String feature,int val) throws Exception
  {
         	String schk="Fail";int val1=val;
         	int check1=check;
         	driver.findElement(By.xpath(SiRxpath_GPSexecute_TNinput+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[1]/input")).clear();
            driver.findElement(By.xpath(SiRxpath_GPSexecute_TNinput+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[1]/input")).sendKeys(ac);      
          
         	if(check1==2)
         	{                      
                 driver.findElement(By.xpath(SiRxpath_GPSexecute_acccode+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[2]/input")).clear();
                 driver.findElement(By.xpath(SiRxpath_GPSexecute_acccode+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[2]/input")).sendKeys(acode);
         	}
         	if(check1==3)
         	{
                 ac=2+Acccode;
                 logger.info("ac"+ac);
                 driver.findElement(By.xpath(SiRxpath_GPSexecute_acccode1+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[2]/input")).clear();
                 driver.findElement(By.xpath(SiRxpath_GPSexecute_acccode1+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[2]/input")).sendKeys(acode);
         	}

         	focusClick(driver,driver.findElement(By.xpath(SiRxpath_GPSexecute_save1+"/tbody["+TN1+"]/tr[2]/td/div/div/div/div[2]/button[2]")),br);
                 
         	Thread.sleep(6000);
         	                                
         	if(driver.findElement(By.cssSelector("div.message-content > div > ul > li.ng-binding.ng-scope")).isDisplayed())
         	{
         		statusTracker(br,"Pass","Verify if error message is displayed when adding "+ac+" TN/Acc code","Error message is displayed: "+ driver.findElement(By.cssSelector("div.message-content > div > ul > li.ng-binding.ng-scope")).getText(),"Error message should be displayed");
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
  public String TNValidation(WebDriver driver, String br, int a, int divval,String feature,int val) throws Exception
  {int val1=val;
         statusTracker(br,"","","Error Validation","");
         String schk ="Pass";
         schk=TNcheck("0223004000","",driver,1,br,divval,feature,val);
         schk=TNcheck("1223004000","",driver,1,br,divval,feature,val);
         schk=TNcheck("9000004000","",driver,1,br,divval,feature,val);
         schk=TNcheck("9760004000","",driver,1,br,divval,feature,val);         
         schk=TNcheck(phoneline1,"",driver,1,br,divval,feature,val);
                  
         if(a==1)
         {
        	 schk=TNcheck("9193220101","",driver,2,br,divval,feature,val); 
        	 schk=TNcheck("9193220101","2",driver,2,br,divval,feature,val);
        	 schk=TNcheck("919322","2",driver,2,br,divval,feature,val);
        	 String ac=2+Acccode;
        	 TNcheck("9193220101",ac,driver,2,br,divval,feature,val);
         }
         else if(a==2)
         {
        	 schk=TNcheck("9193220101","",driver,3,br,divval,feature,val); 
        	 schk=TNcheck("9193220101","2",driver,3,br,divval,feature,val);
        	 schk=TNcheck("919322","2",driver,3,br,divval,feature,val);
         }
         
         return schk;
  }
  
  public void execute(String br, WebDriver driver,String url, int loc, String name1) throws Exception {

                  xpath_GPSexecute_xpath1 = GPS.getProperty("xpath_GPSexecute_xpath1");
                  SiRxpath_GPSexecute_newfeature = GPS.getProperty("SiRxpath_GPSexecute_newfeature");
                  SiRxpath_GPSexecute_turnOnOff = GPS.getProperty("SiRxpath_GPSexecute_turnOnOff");
                  SiRxpath_GPSexecute_save = GPS.getProperty("SiRxpath_GPSexecute_save");
                  SiRxpath_GPSexecute_cancel = GPS.getProperty("SiRxpath_GPSexecute_cancel");
                  SiRxpath_GPSexecute_lable = GPS.getProperty("SiRxpath_GPSexecute_lable");
                  SiRxpath_GPSexecute_TNinput = GPS.getProperty("SiRxpath_GPSexecute_TNinput");
                  SiRxpath_GPSexecute_save1 = GPS.getProperty("SiRxpath_GPSexecute_save1");
                  SiRxpath_GPSexecute_acccode = GPS.getProperty("SiRxpath_GPSexecute_acccode");
                  SiRxpath_GPSexecute_acccode1 = GPS.getProperty("SiRxpath_GPSexecute_acccode1");  
                  
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
                                    }while(driver.findElements(By.xpath(xpath_GPSexecute_xpath1)).size()<0);
                  
                                    Acccode=driver.findElement(By.xpath("//html/body/section/section/div[1]/aside[1]/ul/li[1]/strong")).getText();
                                    logger.info("Acccode home"+Acccode);
                                    System.out.println("a1"+Acccode);
                                    focusClick(driver,  driver.findElement(By.xpath("//section[@id='admin-homepage-shortcuts']/div/a[6]/span/div")),br);            
                                    System.out.println("b");
                                 
                                    driver.manage().timeouts().implicitlyWait(tlim,TimeUnit.SECONDS);
                  
                                    System.out.println("checkpoint1");

                                    	String feature="SimultaneousRing";
                                    	Actions actions = new Actions(driver);
                						WebElement mainMenu = driver.findElement(By.xpath(".//*[@id='accordion_"+feature+"']/div"));
                						actions.moveToElement(mainMenu);
                						                                                  
                						WebElement subMenu = driver.findElement(By.cssSelector("#collapseFeature_SimultaneousRing > #newFeature_SR > div.popover-content"));
                						actions.moveToElement(subMenu);
                						actions.click().build().perform();
                						
                						if(driver.findElement(By.cssSelector("#collapseFeature_SimultaneousRing > #newFeature_SR > div.popover-content")).isDisplayed())
                						{
                						    System.out.println("Tooltip is coming up fine");
                						    statusTracker(br,"","SimultaneousRing Ring Modal pop up is displayed",driver.findElement(By.cssSelector("#collapseFeature_SimultaneousRing > #newFeature_SR > div.popover-content")).getText(),"");						    
                						 }
                						else
                						{
                							statusTracker(br,"","SimultaneousRing Ring Modal pop up is not displayed","","");
                						}
                                    	
                                    	focusClick(driver,driver.findElement(By.xpath("//*[@id='accordion_"+feature+"']/h3")),br);       
                                    	System.out.println("c");
                                    	int divval=3;
                                    	try
                                    	{
                                    		if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/div/h2")).isDisplayed())
                                    		{
                                                  statusTracker(br,"","SimultaneousRing Ring Modal slides shows are displayed","","");
                                                  int pg0=0,pg1=0,pg2=0;
                                                  driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/div/div/div[2]/a[2]")).click();
                                                  if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/div/div/div[2]/a[2]")).getAttribute("class").equals("active"))
                                                	  pg1=1;
                                                  
                                                 
                                                  driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/div/div/div[2]/a[1]")).click();
                                                  if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/div/div/div[2]/a[1]")).getAttribute("class").equals("active"))
                                                	  pg0=1;
                                                  
                                                  if(pg0 == 1 && pg1 == 1)
                                                  {
                                                	  statusTracker(br,"","SimultaneousRing Ring Modal slides Pages displayed on page navigation","","");
                                    		      }
                                                  else
                                                  {
                                            		statusTracker(br,"","SimultaneousRing Ring Modal slides Pages not displayed on page navigation","","");
                                                  }
                                                  
                                                  driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/div/button")).click();
                                                  Thread.sleep(1000);
                                                  if(driver.findElements(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/div/h2")).size()>0)
                                          		  {
                                                	  statusTracker(br,"","SimultaneousRing Ring Modal slides are displayed on clicking the Close","","");
                                          		  }
                                                  else
                                                  {
                                                	  statusTracker(br,"","SimultaneousRing Ring Modal slides are not displayed on clicking the Close","","");
                                                  }
                                                  divval=3;
                                    		}
                                    	}
                                    	catch(Exception e)
                                    	{
                                                  statusTracker(br,"","SimultaneousRing Ring Modal slides shows are not displayed from second time","","");
                                                  first=1;
                                    	}                                    	
                                    	
                                    	int numberOfTns=driver.findElements(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody")).size();                                  
                                    	System.out.println("Number of TNs present are"+numberOfTns);
                                    	
                                    	tnSuspendedStatus=new String[numberOfTns];
                                    	tnSuspendedStatus=suspendedStatus(numberOfTns,feature,driver,divval);
                                  
                                    	System.out.println("e: "+tnSuspendedStatus.length);
                                   
                                    	Boolean suspended=suspended(tnSuspendedStatus,driver);
                                    	System.out.println("f"+suspended);
                                    	int numberSuspended=getNumSuspended(tnSuspendedStatus,driver);
                                    	System.out.println("g"+numberSuspended);
                                  
                                    	statusTracker(br,"","Lines which are suspended: "+numberSuspended,"","");
                                    	
                                    	turnOnOff(feature,driver,br,2,divval);
                                    	
                                    	turnOnOff(feature,driver,br,2,divval);
                                    	
                                    	turnOnOffSelected(feature,driver,br,numberSuspended,2,divval);
                                    	
                                    	Unsavedpopup(br,driver, divval,2,feature);
                                    	Cancel(br,driver,feature,2,divval);
                                  
                                    	TN1=Select_TN(driver,feature,numberOfTns,br,2,divval);
                                    	System.out.println("TN1"+TN1);
                                    	phoneline1=driver.findElement(org.openqa.selenium.By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[1]/td[1]")).getText();
                                    	phoneline=phoneline1.substring(0, 8);
                                    	System.out.println("phoneline"+phoneline);
                                    	
                                    	if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[1]/td[2]/div/label")).getText().contains("OFF"))
                                    	{                                                  
                                    		focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[1]/td[2]/i")),br);
                                    		statusTracker(br,"","The SimultaneousRing Ring tool tip containt is",driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[1]/td[2]/div[2]/div[2]")).getText(),"");	                                    		
                                    	}
                                  
                                    	focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[1]/td[4]/button")),br);
                                                                        
                                    	int cnt=driver.findElements(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/table/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td")).size();
                                    	System.out.println("cnt"+cnt);
                                    	if(cnt<=3)
                                    	{                                   
                                    		if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/table/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[2]")).getText().contains("Local Calls Only"))
                                    		{
                                    			int a1=1,val=4;                                      
                                    			focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[1]/div/div/i")),br);
                                        		statusTracker(br,"","The Verified accountcode tool tip containt is",driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[2]/td[2]/div/div/div/div[2]")).getText(),"");
                                    			
                                    			String acntcd= driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[1]/div/div/input")).getAttribute("class");
                                    			logger.info("acntcd is"+acntcd);
                                    			if(acntcd.contains("not"))
                                    			{
                                    				logger.info("check is");
                                    				statusTracker(br,"","The Account code is"+Acccode,"","");    
                                    				focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[1]/div/div/label")),br);           
                                    				driver.findElement(By.xpath(SiRxpath_GPSexecute_acccode+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[2]/input")).sendKeys(Acccode);
                                    			}
                                    			else
                                    			{
                                    				driver.findElement(By.xpath(SiRxpath_GPSexecute_acccode+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[2]/input")).clear();
                                    				driver.findElement(By.xpath(SiRxpath_GPSexecute_acccode+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[2]/input")).sendKeys(Acccode);
                                    			}
                                    			logger.info("check is");
                                    			String acc="Verified Account code";
                                    			boolean status= driver.findElement(By.xpath(SiRxpath_GPSexecute_lable+"/tbody["+TN1+"]/tr[2]/td/div/div/div/div[1]/span[1]/label/span")).isSelected();                                          
                                    			if(status==true)
                                    			{
                                    				turnoff(driver, br, acc, divval,feature,val);
                                    			}
                                    			else
                                    			{
                                    				turnOn(driver, br,acc, divval,feature,val);
                                    			}
                                    			logger.info("orderprocess is done");                       
                                    			EditTn(driver,br,divval,feature,1);
                                          
                                    			TNValidation(driver,br,a1,divval,feature,val);     
                                    		}
                                    	   else
                                    		{                                    			
                                    		   boolean status= driver.findElement(By.xpath(SiRxpath_GPSexecute_lable+"/tbody["+TN1+"]/tr[2]/td/div/div/div/div[1]/span[1]/label/span")).isSelected();
                                       			int a3=3, val=2;
                                       			String acc="No Account code";
                                       			if(status==true)
                                       			{                                       
                                       				turnoff(driver, br, acc, divval,feature,val);
                                       			}
                                       			else
                                       			{
                                       				turnOn(driver, br,acc, divval,feature,val);
                                       			}
                                       			logger.info("orderprocess is done");
                                         
                                       			EditTn(driver,br,divval,feature,1);
                                           
                                       			TNValidation(driver,br,a3,divval,feature,val);
                                    	    }
                                     }                                    	
                                    else
                                    {
                                    	int a2=2,val=3;       
                            			focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div/div/table/thead/tr/th[2]/i")),br);
                                		statusTracker(br,"","The Non-verified accountcode tool tip containt is",driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div/div/table/thead/tr/th[2]/div/div[2]")).getText(),"");
                            			
                            			driver.findElement(By.xpath(SiRxpath_GPSexecute_acccode1+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[2]/input")).clear();
                            			driver.findElement(By.xpath(SiRxpath_GPSexecute_acccode1+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[2]/input")).sendKeys("8956325485");
                            			String acc="Non-Verified Account code";
                            			boolean status= driver.findElement(By.xpath(SiRxpath_GPSexecute_lable+"/tbody["+TN1+"]/tr[2]/td/div/div/div/div[1]/span[1]/label/span")).isSelected();                                                                                    
                            			if(status==true)
                            			{
                            				turnoff(driver, br, acc, divval,feature,val);
                            			}
                            			else
                            			{
                            				turnOn(driver, br,acc, divval,feature,val);
                            			}                     
                            			logger.info("orderprocess is done");                       
                            			EditTn(driver,br,divval,feature,2);
                                  
                            			TNValidation(driver,br,a2,divval,feature,val); 
                            			
                            			driver.findElement(By.xpath(SiRxpath_GPSexecute_TNinput+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[1]/input")).clear();
                                        driver.findElement(By.xpath(SiRxpath_GPSexecute_TNinput+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[1]/input")).sendKeys("9193220001");
                            			
                                        driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div/div/div[2]/button[1]")).click();
                                		  
                                  	  	Thread.sleep(2000);                                           
                                        if(!(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div/div/div[2]/button[1]")).isEnabled()))
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
                                        
                                        driver.findElement(By.xpath(SiRxpath_GPSexecute_TNinput+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[1]/input")).clear();
                                        driver.findElement(By.xpath(SiRxpath_GPSexecute_TNinput+"/tbody["+TN1+"]/tr[2]/td/div/div/div/table/tbody/tr[1]/td[1]/input")).sendKeys("9193220001");
                                        
                                        focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[1]/td[4]/button")),br);
                                        
                                        Boolean CH= driver.findElement(By.cssSelector("h2.modal-title")).isDisplayed();
                              		  	logger.info("pop up display");
                              		  	if(CH==true)
                              		  	{
                              			  System.out.println("In here 1");
                              			  driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/span")).click();
                              			  Thread.sleep(2000);
                              			  CH= driver.findElement(By.cssSelector("h2.modal-title")).isDisplayed();
                              			  logger.info("pop up display1");
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
                              		  	
                              		  focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+divval+"]/table/tbody["+TN1+"]/tr[1]/td[4]/button")),br);
                              		  
                              		  driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/a/span")).click();
                              		  logger.info("OK");

                              		  if(driver.findElements(By.xpath("//html/body/section/div[4]/div[1]/div")).size()>0)
                              		  {
                              			  statusTracker(br,"Pass","Verify if clicking on OK navigating to Feature Page by closing the configure close","Successfully navigated to Outgoing calls Page on clicking OK","Success");
                          			  //  state="Pass";
                              		  }
                              		  else
                              		  {
                              			  logger.info("Fail");
                              			  statusTracker(br,"Fail","OK dint work in Unsaved Pop Up","Unsuccessful","Unable to process successfully");
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
