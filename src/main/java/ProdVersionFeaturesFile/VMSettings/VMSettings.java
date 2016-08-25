package ProdVersionFeaturesFile.VMSettings;

import com.thoughtworks.selenium.Selenium;

import ProdVersionFeaturesFile.CommonFunctions;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class VMSettings extends CommonFunctions 
{
                String table, tns[];
                String tlimit,username,pwd;
                int tncount;
                String phoneline,phoneline_ac,phoneline_midtn,phoneline_lastfour;
                String CurrentPin,NewPin,temp;
                int chk=0;
                String s=randomNO(99,05)+"@gmail.com";
                Boolean PinSkip;
                Boolean Notify,Attachment;
                
                
                public VMSettings(String path) {
                                this.path = path;
                }

                /*public VMSettings(String path, String file1, String file2) {
                                this.path = path;
                                this.path1 = file1;
                                this.path2 = file2;
                }*/
  
  public String EditAllSettings(String br,WebDriver driver, String status) throws InterruptedException, BiffException, IOException
  {
                  File data = new File(this.path);
      WorkbookSettings ws = new WorkbookSettings();
      ws.setLocale(new Locale("er", "ER"));
      Workbook wb = Workbook.getWorkbook(data, ws);
      Sheet sheet2 = wb.getSheet(0);
     String initialstate=status, chngetostate="Off",state="Fail";
                 String pin=randomNO(1,10);
                  System.out.println(pin);     
       //           statusTracker(br,"","Current Number of Ring is:",""+driver.findElement(By.xpath("/html/body/section/section[2]/form/div[4]/div[1]/span/select")).getText(),"");
                  focusDropdown(driver,"//html/body/section/section[2]/form/div[4]/div[1]/span",pin,br);
                  //new Select(driver.findElement(By.xpath("/html/body/section/section[2]/form/div[4]/div[1]/span/select"))).selectByVisibleText(pin);                
                  CurrentPin=sheet2.getCell(10, 18).getContents();     
                  System.out.println(CurrentPin);
                   NewPin=sheet2.getCell(12, 18).getContents();
                  System.out.println("Before"+CurrentPin);
                  System.out.println("After"+NewPin);
                  driver.findElement(By.xpath("//input[@type='password']")).clear();
                  driver.findElement(By.xpath("//input[@type='password']")).sendKeys(CurrentPin);
                  driver.findElement(By.xpath("(//input[@type='password'])[2]")).clear();
                  driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(NewPin);
                  driver.findElement(By.xpath("(//input[@type='password'])[3]")).clear();
                  driver.findElement(By.xpath("(//input[@type='password'])[3]")).sendKeys(NewPin);
                  
                 
                  driver.findElement(By.xpath("//html/body/section/section[2]/form/div[8]/div[1]/label")).click();
                  
                  Boolean Notify=driver.findElement(By.id("check-email-noti")).isSelected();
                  Boolean Attachment=driver.findElement(By.id("check-email-voicemail")).isSelected();
                 
                  
                  if(Notify.equals(false))
                  {
                                  driver.findElement(By.xpath("//html/body/section/section[2]/form/div[9]/div/label")).click();
                                  driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
                                  driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(s);
                                  if(Attachment.equals(false))
                                  {
                                                  driver.findElement(By.xpath("/html/body/section/section[2]/form/div[10]/div/label")).click();
                                  }
                  } 
                  else
                  {
                                  driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
                                  driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(s);
                                  if(Attachment.equals(false))
                                  {
                                                  driver.findElement(By.xpath("//html/body/section/section[2]/form/div[10]/div/label")).click();
                                  }
                  }
                  driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
                  do{
                      //System.out.println("Processing!" +chk);
                      chk++;
                    }while(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/div")).isDisplayed());

                  if(driver.findElements(By.xpath("//html/body/section/div[2]")).size()>0)
                    {
                      System.out.println("Success");
                      statusTracker(br,"Pass","Verify order process for Editing all settings","Able to save the changes successfully","Successfully processed order");
                     temp=CurrentPin;CurrentPin=NewPin;NewPin=temp;
                      
                      System.out.println("After Order Process1: "+CurrentPin);
                      System.out.println("After Order Process1: "+ NewPin);
                      
                    }
                     else
                    {
                      System.out.println("Fail");
                      statusTracker(br,"Fail","Verify order process for Editing all settings","Unable to save the changes due to order process error","Unable to process successfully");
                    }              
                  
    return state;
    
  } 
  public String OrderProcess(String br,WebDriver driver, String status) throws InterruptedException
  {
                  String initialstate=status, chngetostate="Off",state="Fail";
                  String pin=randomNO(1,10);
                  System.out.println(pin);
                  
                  statusTracker(br,"","Edit Number Of Rings","","");   
                  
       //           statusTracker(br,"","Current Number of Ring is:",""+driver.findElement(By.xpath("/html/body/section/section[2]/form/div[4]/div[1]/span/select")).getText(),"");
                  focusDropdown(driver,"//html/body/section/section[2]/form/div[4]/div[1]/span",pin,br);
                  //new Select(driver.findElement(By.xpath("/html/body/section/section[2]/form/div[4]/div[1]/span/select"))).selectByVisibleText(pin);                
                  driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
                  do{
                      //System.out.println("Processing!" +chk);
                      chk++;
                    }while(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/div")).isDisplayed());
                  
                  if(driver.findElements(By.xpath("/html/body/section/div[2]")).size()>0)
                    {
                     System.out.println("Success");
                      statusTracker(br,"Pass","Verify if user is able to change Number of Rings","Able to save the Number of Rings To: "+pin,"Successfully processed order");   
                    }
                     else
                    {
                      System.out.println("Fail");
                      statusTracker(br,"Fail","Verify if user is able to change Number of Rings","Unable to save the changes due to order process error","Unable to process successfully");
                    }

              statusTracker(br,"","Pin Change Operations","","");  
                  
                  
                  driver.findElement(By.xpath("//input[@type='password']")).clear();
                  driver.findElement(By.xpath("//input[@type='password']")).sendKeys(CurrentPin);
                  driver.findElement(By.xpath("(//input[@type='password'])[2]")).clear();
                  driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(NewPin);
                  driver.findElement(By.xpath("(//input[@type='password'])[3]")).clear();
                  driver.findElement(By.xpath("(//input[@type='password'])[3]")).sendKeys(NewPin);
                  
                  
                  driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
                  do{
                      //System.out.println("Processing!" +chk);
                      chk++;
                    }while(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/div")).isDisplayed());
                  
                  if(driver.findElements(By.xpath("//html/body/section/div[2]")).size()>0)
                  {
                    System.out.println("Success");
                    statusTracker(br,"Pass","Verify order process for Change PIN","Able to save the changes successfully with CurrentPIN:"+CurrentPin+"NewPin :"+NewPin,"Successfully processed order");        
                    temp=CurrentPin;CurrentPin=NewPin;NewPin=temp;
                    
                    System.out.println("After Order Process2: "+CurrentPin);
                    System.out.println("After Order Process2: "+ NewPin); 
                  }
                   else
                  {
                    System.out.println("Fail");
                    statusTracker(br,"Fail","Verify order process for Editing all settings","Unable to save the changes due to order process error","Unable to process successfully");
                  }
                 
               String PinSkip=driver.findElement(By.xpath("/html/body/section/section[2]/form/div[9]/div/label")).getAttribute("label");    
                  
               System.out.println(PinSkip);   
                  
                  
                  statusTracker(br,"","Change Notifications and Attachment","","");  
                  
                 Boolean Notify1=driver.findElement(By.id("check-email-noti")).isSelected();                
                 Boolean Attachment1=driver.findElement(By.id("check-email-voicemail")).isSelected();

                  System.out.println("no attachment,No Notify:"+Notify1);
                      System.out.println("with attachment,No Notify:"+Attachment1);
                   
                      if(Notify1.equals(true) && Attachment1.equals(true))
                      {
                       statusTracker(br,"Pass","Verify order process for Turning On VM Settings With Attachment","Able to Turn ON Notification with Attachment successfully","Successfully processed order");                           
                       driver.findElement(By.xpath("/html/body/section/section[2]/form/div[10]/div/label")).click();    
                      driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
                   do{
                   //System.out.println("Processing!" +chk);
                   chk++;
                  }while(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/div")).isDisplayed());
                       Boolean Attachment2=driver.findElement(By.id("check-email-voicemail")).isSelected();     
                   System.out.println("After true Attachyment"+Attachment2);
                       if(Attachment2.equals(false))
                       {
                                statusTracker(br,"Pass","Verify order process for Turning On VM Settings Without Attachment","Able to Turn ON Notification without Attachment successfully","Successfully processed order");  
                       }
                      }
                    driver.findElement(By.xpath("/html/body/section/section[2]/form/div[9]/div/label")).click();   
                driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
            
                 do{
                 //System.out.println("Processing!" +chk);
                 chk++;
               }while(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/div")).isDisplayed());
             
                    Boolean Notify3=driver.findElement(By.id("check-email-noti")).isSelected();                
                Boolean Attachment3=driver.findElement(By.id("check-email-voicemail")).isSelected();
                   
                 System.out.println("After true notify"+Notify3);
                 System.out.println("After true Attachyment"+Attachment3);
                
                 if(Notify3.equals(false) && Attachment3.equals(false))
                      {
                       statusTracker(br,"Pass","Verify order process for Turning OFF VM Settings Without Attachment","Able to Turn OFF Notification Without Attachment successfully","Successfully processed order");                             
                       driver.findElement(By.xpath("/html/body/section/section[2]/form/div[9]/div/label")).click();  
                       driver.findElement(By.xpath("/html/body/section/section[2]/form/div[10]/div/label")).click();  
                       driver.findElement(By.xpath("/html/body/section/section[2]/form/div[9]/div/label")).click();  
                       driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
                       do{
                     //System.out.println("Processing!" +chk);
                     chk++;
                   }while(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/div")).isDisplayed());
                      
                        Boolean Attachment4=driver.findElement(By.id("check-email-voicemail")).isSelected();     
                   System.out.println("After true Attachyment"+Attachment4);
                       if(Attachment4.equals(true))
                       {
                                statusTracker(br,"Pass","Verify order process for Turning OFF VM Settings With Attachment","Able to Turn OFF Notification with Attachment successfully","Successfully processed order");  
                       }
                      }
                 Boolean Attachment4=driver.findElement(By.id("check-email-voicemail")).isSelected();   
                 statusTracker(br,"","Current Status of Notification is:"+Notify3,"Attachment:"+Attachment4,"");
  return state;
  }
  
  
  
public String VMPIN(String br,String Newpin,String pin, String confirmnewpin, String check,WebDriver driver) throws Exception
  {
                  
                  System.out.println("Iam cumng too");
                  String schk="Fail";
                   
                   driver.findElement(By.xpath("//input[@type='password']")).clear();
       driver.findElement(By.xpath("//input[@type='password']")).sendKeys(CurrentPin);
       driver.findElement(By.xpath("(//input[@type='password'])[2]")).clear();
       driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(pin);
       driver.findElement(By.xpath("(//input[@type='password'])[3]")).clear();
       driver.findElement(By.xpath("(//input[@type='password'])[3]")).sendKeys(confirmnewpin);
       
       
       driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
      Thread.sleep(3000);
                do{
         //System.out.println("Processing!" +chk);
         chk++;
       }while(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/div")).isDisplayed());
     
      
      
      if((driver.findElement(By.xpath("/html/body/section/section[2]/form/div[1]/div")).isDisplayed()))
     {
                  System.out.println("printing");
       statusTracker(br,"Pass","Verify if error message is displayed when adding "+check+" PIN","Error message is displayed:"+driver.findElement(By.xpath("/html/body/section/section[2]/form/div[1]/div/div/div/ul/li/span")).getText(),"Error message should be displayed");
     } 
     
      else
      {
                  
                  statusTracker(br,"Fail","Verify if error message is displayed when adding "+check+" PIN","Error message is not displayed","Error message should be displayed");
      }
                  
       schk ="Pass";
     
  return schk;
  }
  private String getText() {
                // TODO Auto-generated method stub
                return null;
}


public String PinValidation(String br,WebDriver driver) throws Exception
  {
                
                System.out.println("test");
                  //String pin1 = randomNO(9999,1000);
                  String schk ="Fail";
                  String pin,pin2;
                  statusTracker(br,"","The VM Settings Defect Validation","",""); 
                System.out.println(CurrentPin);
   
                  schk=VMPIN(br,CurrentPin,"","1234","Blank New",driver);
                  
                  schk=VMPIN(br,CurrentPin,"1234","","Blank Confirm Field",driver);
                  
     Thread.sleep(2000);
     
    String Enabled=driver.findElement(By.xpath("/html/body/div[2]/div/div/span/select/option[1]")).getText(); 
    System.out.println(Enabled);
    Enabled=Enabled.substring(8);
    System.out.println(Enabled);
    schk=VMPIN(br,CurrentPin,Enabled,Enabled,"Self",driver);
                  
     schk=VMPIN(br,CurrentPin,"3456","3456","Consecutive",driver);
                  System.out.println("order done");
                  
                  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                  
                 pin=randomNO(9,1);
                  pin=pin+pin+pin+pin;
                  System.out.println("m not hapenning"+pin);
                  schk=VMPIN(br,CurrentPin,pin,pin,"same digits",driver);
                  
                 
                  pin=randomNO(999,100);
                  schk=VMPIN(br,CurrentPin,pin,pin,"less than 4 digit",driver);
                  System.out.println("4 digits");
                // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                  
                  pin=randomNO(9999,1000);
                  pin2=randomNO(9999,1000);
                  schk=VMPIN(br,CurrentPin,pin,pin2,"different confirm",driver);
      System.out.println("different");
      //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       schk="Pass";
                  return schk;
  }

public void execute(String br, WebDriver driver, String url, int loc, String name1) throws Exception 
                 
{ 
    int tlim=3;
    String status1="",state = "Fail";

    try
    {
               
              File data = new File(this.path);
              WorkbookSettings ws = new WorkbookSettings();
              ws.setLocale(new Locale("er", "ER"));
              Workbook wb = Workbook.getWorkbook(data, ws);
              Sheet sheet2 = wb.getSheet(0);

              tlimit = sheet2.getCell(5, loc).getContents();
              username = sheet2.getCell(6, loc).getContents();
              pwd = sheet2.getCell(7, loc).getContents();
              tlim = Integer.parseInt(tlimit);
              wb.close();
              //int tlim = Integer.parseInt(tlimit);
          
              driver.manage().timeouts().implicitlyWait(tlim,TimeUnit.SECONDS);
              logger.info("qtest1");
                
                //int tlim = Integer.parseInt(tlimit);
      
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
             
                  System.out.println("checkpoint1");
                  

                  if(!(InternalException(driver,br)))
                  {

                 
                  driver.findElement(By.linkText("Switch to User mode")).click();
                  driver.findElement(By.xpath("/html/body/header/div[4]/div[2]/nav/ul/li[2]/a")).click();
                  if(!(InternalException(driver,br)))
                  {
                  driver.findElement(By.linkText("Edit Voicemail Settings")).click();
                  if(!(InternalException(driver,br)))
                  {
                  
                  state= "Pass";
                if(state.equals("Pass"))
                   {
                                 statusTracker(br,"","GMB Primary Line","",""); 
              //String GMB=sheet2.getCell(14, 11).getContents();     
                 //System.out.println(GMB);
               // new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(GMB);
                                  state=EditAllSettings(br,driver, status1);
                                  state=OrderProcess(br,driver, status1);
                                  state= PinValidation(br,driver);
                                  driver.findElement(By.cssSelector("button.btn.btn-secondary")).click();
                                  System.out.println("started");  
                  }
                                  switchTo(driver, "Admin",tlim,br);                            
                        first=1;      
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
                //statusTracker(br,"end","","");
//      wb.close();
     
    }
  }

}