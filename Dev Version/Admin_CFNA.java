package ApolloNew;

import java.io.File;
import java.io.PrintStream;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class AdminCFNA extends CommonFunctions
{
                String table, tns[];
                String tlimit,username,pwd;
                String Acccode,phoneline,phoneline1;
                int rowCount,TN1, drpval;
                String[] tnSuspendedStatus;
                
                
              String xpath_GPSexecute_xpath1;
                 String xpath_GPSexecute_xpath;
                  String css_GPSexecute_css3;
                  String xpath_GPSexecute_xpath4;
                
  public AdminCFNA()
  {
  }
  
  public AdminCFNA(String path) {
                                this.path = path;
                }
  
  public void turnOnOff(String feature, WebDriver driver, String br,int tab,int val)
                {
                    String onoff=driver.findElement(By.xpath("//*[@id='collapseFeature_CF']/div["+val+"]/table/thead/tr/th[3]/div/input")).getAttribute("class");
                    System.out.println(onoff);
                    String on="ON";
                    String not="OFF";
                    if(onoff.contains("not"))
                    {
                                    String Selected=driver.findElement(By.xpath("//*[@id='collapseFeature_CF']/div["+val+"]/table/thead/tr/th[3]/div")).getAttribute("class"); 
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
                        
                        driver.findElement(By.xpath("//div[@id='collapseFeature_"+feature+"']/div["+val+"]/table/thead/tr/th["+tab+"]/div/label")).click();
                        
                        focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/table/tfoot/tr/td/button[2]")),br);
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
  
public void turnOnOffSelected(String feature,WebDriver driver, String br, int numSuspended,int tab,int val)
                             {
                                 int rowCount=driver.findElements(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/tbody")).size();
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
                                                                 
                                   if(driver.findElements(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/tbody["+rand+"]/tr[1]/td["+tab+"]/div/label")).size() >0)                                         
                                   {                                               
                                                driver.findElement(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/tbody["+rand+"]/tr[1]/td["+tab+"]/div/label")).click();                                                
                                   }
                                                                  
                                   System.out.println("ok2");
                                  
                                   if(validTns > 2)
                                   {
                                    if(driver.findElements(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/tbody["+newcount1+"]/tr[1]/td["+tab+"]/div/label")).size() >0)                                         
                                     {                                           
                                                  driver.findElement(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/tbody["+newcount1+"]/tr[1]/td["+tab+"]/div/label")).click();                                   
                                     }                           
                                   }
                                  
                                 
                                  System.out.println("ok4");
                                  focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div[3]/table/tfoot/tr/td/button[2]")),br);

                                  if(driver.findElements(By.xpath("//html/body/div[1]/div/div/div/div")).size()>0)
                                  {
                                                  if(driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div")).isDisplayed())
                                                  {
                                                  if(driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div[1]/h2")).getText().contains("Warning"))
                                                   {
                                                                  System.out.println("Warning message is displayed hence proceeding. Warning message: " + driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div[2]/div")).getText());
                                                                  driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/span[2]")).click();
                                                   }
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
                                                driver.navigate().refresh();
                                                driver.findElement(By.cssSelector("#accordion_"+feature+" > div.header-right > div.align-right")).click();
                                  }
                }
  
  public String[] suspendedStatus(int numberOfTns,String feature, WebDriver driver,int val)
  {
                  String []a=new String[numberOfTns];
                  
                  for(int i=1;i<=numberOfTns;i++)
                  {
                                  
                                                  if(driver.findElement(By.xpath("//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/tbody["+i+"]/tr[1]/td[1]/i")).isDisplayed())
                                                                  
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
  
  public void Unsavedpopup(String br, WebDriver driver, int val,int tab) throws InterruptedException
  {
	  logger.info("Unsavedpopup");
	  driver.findElement(By.xpath("//*[@id='collapseFeature_CF']/div["+val+"]/table/thead/tr/th["+tab+"]/div/label")).click();
      
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
	  driver.findElement(By.linkText("Incoming Calls")).click();
	  
	  do{

		  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
	  Thread.sleep(2000);
	  
	  driver.findElement(By.cssSelector("#accordion_CF > div.header-right > div.align-right")).click();
  }
  
  public void Cancel(String br,WebDriver driver, String feature,int tab,int val) throws InterruptedException
  {                                                  
	  

	  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature_"+feature+"']/div["+val+"]/table/thead/tr/th["+tab+"]/div/label")),br);
    	
      driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/tfoot/tr/td/button[1]")).click();
      		  
	  Thread.sleep(3000);
      if(!(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+feature+"']/div["+val+"]/table/tfoot/tr/td/button[1]")).isEnabled()))
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
  public int Select_TN(WebDriver driver,String featureName,int rowCount,String br,int tab,int val)
                {
					int TN = 0;
					for(int j=1;j<rowCount;j++)
					                {
			                                try
			                                {
            
                                                if(focusSearch(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+j+"]/tr[1]/td[1]/i")),br))
                                                {
                                                                System .out.println("TN is suspended");
                                                                continue;
                                                }                                    
                                                else if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+j+"]/tr[1]/td[3]/div/input")).getAttribute("class").contains("not"))
                                                { 
                                                                System.out.println("tn2");
                                                                TN=j;
                                                                break;
                                                }
                                                      else
                                                         {
                                                                focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+j+"]/tr[1]/td[3]/div/label")),br);
                                                                focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/table/tfoot/tr/td/button[2]")),br);
                                                                  
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
  
  public void numrngs(WebDriver driver,String br,int TN1,int drpval,int bval) throws Exception
  {
	  String n=randomNO(1,4);
	  driver.findElement(By.cssSelector("li.custom-dd-selected")).click();
	  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature_CF']/div[3]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div["+drpval+"]/span[1]/ul/ul/li["+n+"]")),br);
      
      Thread.sleep(3000);           
      focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature_CF']/div[3]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div["+bval+"]/button[2]")),br);

      int chk=0;
      do{
          chk++;
        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

        if(driver.findElement(By.id("dataSaveSucess2")).isDisplayed())
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
  	    
  public void turnoff(WebDriver driver, String br, String acc,int val,int bval)
                {
                  String initialstate="On", chngetostate="Off", accst=acc;
                                                   
                  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[1]/span[2]/label")),br);
                  
                  for(int i=1;i<100;i++){}

                  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature_CF']/div[3]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div["+bval+"]/button[2]")),br);
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
                                  statusTracker(br,"Fail","Verify the order process for changing the status from: "+initialstate +" to: "+chngetostate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/div[2]/div/div/ul/li")).getText(),"Unable to process successfully");
                  }
                  for(int i=1;i<100;i++){}

                  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[1]/span[2]/label")),br);
                  String num=randomNO(3333,6666);
                  driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[2]/div/input")).clear();
                  driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[2]/div/input")).sendKeys(phoneline+num);
                  for(int i1=1;i1<100;i1++){}

                 focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature_CF']/div[3]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div["+bval+"]/button[2]")),br);
      
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
                                  statusTracker(br,"Fail","Verify the order process for changing the status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/div[2]/div/div/ul/li")).getText(),"Unable to process successfully");
                  }
                }
  
  public void turnOn(WebDriver driver, String br, String acc, int val,int bval) throws Exception
                {
	              String initialstate="Off", chngetostate="On",accst=acc; 
	              
	              focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[1]/span[2]/label")),br);
                  String num=randomNO(3333,6666);
                  driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/input")).clear();
                  driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/input")).sendKeys(phoneline+num);
                 Thread.sleep(2000);

                 focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature_CF']/div[3]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div["+bval+"]/button[2]")),br);
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
                                  statusTracker(br,"Fail","Verify the order process for changing the status from: "+ initialstate +" to: "+chngetostate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/div[2]/div/div/ul/li")).getText(),"Unable to process successfully");
                  }
        
                  for(int i1=1;i1<100;i1++){}
                  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[1]/span[2]/label")),br);
      
                  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature_CF']/div[3]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div["+bval+"]/button[2]")),br);
      
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
                                  statusTracker(br,"Fail","Verify the order process for changing the status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/div[2]/div/div/ul/li")).getText(),"Unable to process successfully");
                  }                 
                }
  
  public void EditTn(WebDriver driver, String br,int val,int bval)
                {
                  String num=randomNO(3333,6666);
                  driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/input")).clear();
                  driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/input")).sendKeys(phoneline+num);
                  for(int i=1;i<10;i++){}

                 focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature_CF']/div[3]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div["+bval+"]/button[2]")),br);
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
  
  public String TNcheck(String ac, String acode,WebDriver driver, int check,String br,int val,int bval) throws Exception
  {
                String schk="Fail";
                int check1=check;
                         driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/input")).clear();
            driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/input")).sendKeys(ac);      
          
                if(check1==2)
                {                      
                 driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[3]/input")).clear();
                 driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[3]/input")).sendKeys(acode);
                }
                if(check1==3)
                {
                 ac=2+Acccode;
                 logger.info("ac"+ac);
                 driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[2]/input")).clear();
                 driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[2]/input")).sendKeys(acode);
                }

               focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature_CF']/div[3]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div["+bval+"]/button[2]")),br);
                 
                Thread.sleep(6000);
                if(driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/div/div/div/ul/li")).isDisplayed())
                {
                 statusTracker(br,"Pass","Verify if error message is displayed when adding "+ac+" TN/Acc code","Error message is displayed: "+ driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+val+"]/div/div/div/ul/li")).getText(),"Error message should be displayed");
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
  public String TNValidation(WebDriver driver, String br, int a, int val,int bval) throws Exception
  {
         statusTracker(br,"","","Error Validation","");
         String schk ="Pass";
         schk=TNcheck("0223004000","",driver,1,br,val,bval);
         schk=TNcheck("1223004000","",driver,1,br,val,bval);
         schk=TNcheck("9000004000","",driver,1,br,val,bval);
         schk=TNcheck("9760004000","",driver,1,br,val,bval);         
         schk=TNcheck(phoneline1,"",driver,1,br,val,bval);
                  
         if(a==1)
         {
                 schk=TNcheck("9193220101","",driver,2,br,val,bval); 
                 schk=TNcheck("9193220101","2",driver,2,br,val,bval);
                 schk=TNcheck("919322","2",driver,2,br,val,bval);
                 String ac=2+Acccode;
                 TNcheck("9193220101",ac,driver,2,br,val,bval);
         }
         else if(a==2)
         {
                 schk=TNcheck("9193220101","",driver,3,br,val,bval); 
                 schk=TNcheck("9193220101","2",driver,3,br,val,bval);
                 schk=TNcheck("919322","2",driver,3,br,val,bval);
         }
         
         return schk;
  }
  
  public void execute(String br, WebDriver driver,String url, int loc, String name1) throws Exception {

                  xpath_GPSexecute_xpath1 = GPS.getProperty("xpath_GPSexecute_xpath1");
                  xpath_GPSexecute_xpath = GPS.getProperty("xpath_GPSexecute_xpath");
                  css_GPSexecute_css3 = GPS.getProperty("css_GPSexecute_css3");
                  xpath_GPSexecute_xpath4 = GPS.getProperty("xpath_GPSexecute_xpath4");
                    
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
                  
                                    Acccode=driver.findElement(By.xpath("//html/body/section/section/div[1]/aside[1]/ul/li/strong")).getText();
                                    logger.info("Acccode home"+Acccode);
                                    System.out.println("a1"+Acccode);
                                    focusClick(driver,driver.findElement(By.xpath(xpath_GPSexecute_xpath1)),br);             
                                    System.out.println("b");
                                 
                                    driver.manage().timeouts().implicitlyWait(tlim,TimeUnit.SECONDS);
                  
                                    System.out.println("checkpoint1");
                                    if(!(InternalException(driver,br)))
                                    {
                 
	                                    Actions actions = new Actions(driver);
	                                    WebElement mainMenu = driver.findElement(By.xpath(".//*[@id='accordion_CF']/div"));
	                                    actions.moveToElement(mainMenu);
	                                                                                      
	                                    WebElement subMenu = driver.findElement(By.xpath(".//*[@id='newFeature_CF']/div[2]"));
	                                    actions.moveToElement(subMenu);
	                                    actions.click().build().perform();
	                                    
	                                    if(driver.findElement(By.xpath(".//*[@id='newFeature_CF']/div[2]")).isDisplayed())
	                                    {
	                                        System.out.println("Tooltip is coming up fine");
	                                        statusTracker(br,"","CF Modal pop up is displayed",driver.findElement(By.xpath(".//*[@id='newFeature_CF']/div[2]")).getText(),"");                                                                                       
	                                     }
	                                    else
	                                    {
	                                                    statusTracker(br,"","CF Modal pop up is not displayed","","");
	                                    }
	                        
                                        focusClick(driver,driver.findElement(By.xpath("//*[@id='accordion_CF']/h3")),br);       
                                        System.out.println("c");
                                       int divval=3;
                                        try
                                        {
                                            if(driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div[3]/div/h2")).isDisplayed())
                                            {
                                          statusTracker(br,"","CF Modal slides shows are displayed","","");
                                          int pg0=0,pg1=0,pg2=0;
                                          driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div[3]/div/div/div[2]/a[2]")).click();
                                          if(driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div[3]/div/div/div[2]/a[2]")).getAttribute("class").equals("active"))
                                                          pg1=1;
                                          
                                          driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div[3]/div/div/div[2]/a[3]")).click();
                                          if(driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div[3]/div/div/div[2]/a[3]")).getAttribute("class").equals("active"))
                                                          pg2=1;
                                          
                                          driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div[3]/div/div/div[2]/a[1]")).click();
                                          if(driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div[3]/div/div/div[2]/a[1]")).getAttribute("class").equals("active"))
                                                      pg0=1;
                                          
                                          if(pg0 == 1 && pg1 == 1 && pg2 == 1)
                                          {
                                           statusTracker(br,"","CF Modal slides Pages displayed on page navigation","","");
                                          }
                                          else
                                          {
                                          statusTracker(br,"","CF Modal slides Pages not displayed on page navigation","","");
                                          }
                                          
                                          driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div[3]/div/button")).click();
                                          Thread.sleep(1000);
                                          if(driver.findElements(By.xpath(".//*[@id='collapseFeature_CF']/div[3]/div/h2")).size()>0)
		                                      {
		                                      statusTracker(br,"","CF Modal slides are displayed on clicking the Close","","");
		                                      }
                                          else
                                          {
                                                          statusTracker(br,"","CF Modal slides are not displayed on clicking the Close","","");
                                          }
                                          divval=3;
                                                        }
                                        }
                                        catch(Exception e)
                                        {
                                          statusTracker(br,"","CF Modal slides shows are not displayed from second time","","");
                                          first=1;
                                        }
                                        
                                        int feturecount=driver.findElements(By.xpath(".//*[@id='collapseFeature_CF']/div[3]/table/thead/tr/th")).size();
                                        System.out.println("Number of features"+feturecount);
                                        int fcnt=0;
                                        for(int i=1;i<=feturecount;i++)
                                        {
                                            if(driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div[3]/table/thead/tr/th["+i+"]")).getText().contains("Forward"))
                                            {
                                              fcnt++;
                                            }
                                        }
                                        if(fcnt==3)
                                        {
                                                        statusTracker(br,"","CF Three Features Present","","");
                                        }
                                        else
                                        {
                                                        statusTracker(br,"","CF Three Features not Present","","");
                                        }
                                        
                                        int numberOfTns=driver.findElements(By.xpath("//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody")).size();                                  
                                        System.out.println("Number of TNs present are"+numberOfTns);
                                        
                                        tnSuspendedStatus=new String[numberOfTns];
                                        tnSuspendedStatus=suspendedStatus(numberOfTns,"CF",driver,divval);
                          
                                        System.out.println("e: "+tnSuspendedStatus.length);
                           
                                        Boolean suspended=suspended(tnSuspendedStatus,driver);
                                        System.out.println("f"+suspended);
                                        int numberSuspended=getNumSuspended(tnSuspendedStatus,driver);
                                        System.out.println("g"+numberSuspended);
                          
                                        statusTracker(br,"","Lines which are suspended: "+numberSuspended,"","");
                                      
                                       turnOnOff("CF",driver,br,4,divval);
                                       turnOnOff("CF",driver,br,4,divval);
                                       
                                       turnOnOffSelected("CF",driver,br,numberSuspended,4,divval);
                                        
                                       Unsavedpopup(br,driver, divval,4);
                                        Cancel(br,driver,"CF",4,divval);
                          
                                        TN1=1;Select_TN(driver,"CF",numberOfTns,br,4,divval);
                                        System.out.println("TN1"+TN1);
                                       phoneline1=driver.findElement(org.openqa.selenium.By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[1]/td[1]")).getText();
                                        phoneline=phoneline1.substring(0, 8);
                                        System.out.println("phoneline"+phoneline);
                                                
                                              if(driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[1]/td[4]/div/label")).getText().contains("OFF"))
                                                {                                                  
                                                    focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[1]/td[4]/i")),br);
                                                    statusTracker(br,"","The CFNA tool tip containt is",driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[1]/td[4]/div[2]/div[2]")).getText(),"");                                                                                
                                                }
                                  
                                                    focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[1]/td[5]/button")),br);
                                                                        
                                                int cnt=driver.findElements(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div")).size();
                                                System.out.println("cnt"+cnt);
                                                if(cnt==3)
                                                {     drpval=2;
                                                  
                                                                boolean status= driver.findElement(By.xpath("//div[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[1]/span[2]/label")).isSelected();
                                                                int a3=3;
                                                                String acc="No Account code";
                                                                if(status==true)
                                                                {                                       
                                                                turnoff(driver, br, acc, divval,3);
                                                                }
                                                                else
                                                                {
                                                                turnOn(driver, br,acc, divval,3);
                                                                }
                                                                logger.info("orderprocess is done");
                                      
                                                                EditTn(driver,br,divval,3);
                                                                numrngs(driver, br,TN1, drpval,3);
                                                                TNValidation(driver,br,a3,divval,3);
                                                }
                                                else if(cnt>=4)
                                                {                                   
                                                                if(driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[2]")).getText().contains("Local Calls Only"))
                                                                {
                                                                                int a1=1;                                      
                                                                                focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[2]/div/i")),br);
                                                                                statusTracker(br,"","The Verified accountcode tool tip containt is",driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[2]/div/div/div[2]")).getText(),"");
                                                                                
                                                                                String acntcd= driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[2]/div/input")).getAttribute("class");
                                                                                logger.info("acntcd is"+acntcd);
                                                                                if(acntcd.contains("not"))
                                                                                {
                                                                                    logger.info("check is");
                                                                                    drpval=4;
                                                                                    statusTracker(br,"","The Account code is"+Acccode,"","");    
                                                                                    focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[2]/div/label")),br);           
                                                                                    driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[3]/input")).sendKeys(Acccode);
                                                                                }
                                                                                else
                                                                                 {               
                                                                        	        drpval=3;
                                                                                    driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[3]/input")).clear();
                                                                                    driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[3]/input")).sendKeys(Acccode);
                                                                                }
                                                                                logger.info("check is");
                                                                                String acc="Verified Account code";
                                                                                boolean status= driver.findElement(By.xpath("//div[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[1]/span[2]/label")).isSelected();                                          
                                                                                if(status==true)
                                                                                {
                                                                                turnoff(driver, br, acc, divval,5);
                                                                                }
                                                                                else
                                                                                {
                                                                                 turnOn(driver, br,acc, divval,5);
                                                                                }
                                                                                logger.info("orderprocess is done");                       
                                                                                EditTn(driver,br,divval,5);
                                                                                numrngs(driver, br,TN1, drpval,5);
                                                                               TNValidation(driver,br,a1,divval,5);     
                                                                               }
                                                                           else
                                                                              {
                                                                                int a2=2;  
                                                                                drpval=3;
                                                                                focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[2]/label/i")),br);
                                                                                statusTracker(br,"","The Non-verified accountcode tool tip containt is",driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[2]/label/div/div[2]")).getText(),"");
                                                                                
                                                                                driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[2]/input")).clear();
                                                                                driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[2]/input")).sendKeys("8956325485");
                                                                                String acc="Non-Verified Account code";
                                                                                boolean status= driver.findElement(By.xpath("//div[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/div[1]/span[2]/label")).isSelected();                                                                                    
                                                                                if(status==true)
                                                                                {
                                                                                turnoff(driver, br, acc, divval,4);
                                                                                }
                                                                                else
                                                                                {
                                                                                 turnOn(driver, br,acc, divval,4);
                                                                                }                     
                                                                                logger.info("orderprocess is done");                       
                                                                                EditTn(driver,br,divval,4);
                                                                                numrngs(driver, br,TN1, drpval,4);
                                                                               TNValidation(driver,br,a2,divval,4); 
                                                                                
                                                                                driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/input")).clear();
								                                                driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/input")).sendKeys("9193220001");
								                                                                                
								                                                driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody[1]/tr[2]/td/div/div[3]/div/div[3]/button[1]")).click();
								                                                                  
								                                                Thread.sleep(2000);                                           
								                                                if(!(driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody[1]/tr[2]/td/div/div[3]/div/div[3]/button[1]")).isEnabled()))
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
								                                                
								                                                driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/input")).clear();
								                                                driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[2]/td/div/div[3]/div/input")).sendKeys("9193220001");
								                                                focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[1]/td[5]/button")),br);
								                                                
								                                                Boolean CH= driver.findElement(By.cssSelector("#modal-save > div.modal-container > div.modal-container-inner.modal-message > div.modal-body > div.modal-body-inner")).isDisplayed();
                                                                                logger.info("pop up display");
                                                                                if(CH==true)
                                                                                {
                                                                                  System.out.println("In here 1");
                                                                                  driver.findElement(By.id("cancelSaveFeature")).click();
                                                                                  System.out.println("In here 2");
                                                                                  logger.info("pop up display1");
                                                                                  if(driver.findElements(By.xpath("//html/body/section/div[4]/div[2]")).size()>0)
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
                                                                                
			                                                                  focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div["+divval+"]/table/tbody["+TN1+"]/tr[1]/td[5]/button")),br);
			                                                                  
			                                                                driver.findElement(By.xpath("//a[@id='unsavedFeature']/span")).click();
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

