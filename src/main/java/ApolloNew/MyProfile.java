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







import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class MyProfile extends CommonFunctions {
                String table, tns[];
                String tlimit,username,pwd,Email,firstname;
                int tncount;
               String state;
               String Error;
public MyProfile(String path) {
                     this.path = path;
              }

               
               
  public String randomNO(int max, int min)
  {
              int Max=max;
              int Min=min;
              double random1=Min + (int)(Math.random() * ((Max - Min) + 1));
              //System.out.println(random1);
              int random2=(int)random1;
              //System.out.println(random2);
              String s1 = new Integer(random2).toString();
              System.out.println(s1);
              return(s1);
              
  }
  
  public String LoginandSecurity(String br,WebDriver driver)throws Exception
  {
         String state="Fail";
         statusTracker(br,"","Login and Security","","");
         focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-secondary")),br);
         focusClick(driver,driver.findElement(By.linkText("Edit Username")),br);
          driver.findElement(By.id("unfuserName")).clear();
         String s1="Apollo_37"+randomNO(99,05);
         driver.findElement(By.id("unfuserName")).sendKeys(s1);
         focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[4]")),br);
       //if( focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[6]/div/div/ul/li")),br))
              //  statusTracker(br,"Fail","Verify if User is able to edit Username","User is  not able to edit UserName due to server error"+ driver.findElement(By.xpath("//html/body/section/div[7]/div[1]/div[4]/div[2]/div[1]/div[2]/span")).getText(),"User should be able to edit UserName");   
              String Message=driver.findElement(By.xpath("/html/body/section/div[8]/div[1]/div[1]/div[2]/div[1]/div[1]/label")).getText();
       System.out.println(Message);
       if((driver.findElements(By.xpath("//html/body/section/p[1]/strong")).size()>0))
              {      
                       statusTracker(br,"Pass","Verify if User is able to edit Username","Username Updation Successful "+Message,"User should be able to edit UserName");       
              }else                                                                                                                                
                       
              { 
                     statusTracker(br,"Fail","Verify if User is able to edit Username","User is not  able to edit UserName ","User should be able to edit UserName");       
              }
              statusTracker(br,"","Error Validation of Username","","");
              focusClick(driver, driver.findElement(By.linkText("Edit Username")),br);
         driver.findElement(By.id("unfuserName")).clear();
       
         if(driver.findElements(By.xpath("/html/body/section/div[8]/div[1]/div[4]/div[2]/form[1]/div[1]/div[1]/div")).size()>0)
         {      
          statusTracker(br,"Pass","Verify if User is able to see error message for Blank Username","Error Message for Blank Username :"+driver.findElement(By.xpath("/html/body/section/div[8]/div[1]/div[4]/div[2]/form[1]/div[1]/div[1]/div")).getText(),"User should be able to see error message for blank Username");
         }
     else
     { 
         statusTracker(br,"Fail","Verify if User is able to see error message for blank Username","User is not able to see error message for blank Username ","User should be able to see error message for blank Username");    
       
     }
         driver.findElement(By.id("unfuserName")).clear();
         driver.findElement(By.id("unfuserName")).sendKeys("ap");
         
         if( focusSearch(driver,driver.findElement(By.cssSelector("form[name=\"userNameForm\"] > div.grid > div.col-10 > div.label-txt.error")),br))
         {   
                statusTracker(br,"Pass","Verify if User is able to see error message for less than 4 characters in  Username","Error Message for Username Less than 4 Characters:"+driver.findElement(By.cssSelector("form[name=\"userNameForm\"] > div.grid > div.col-10 > div.label-txt.error")).getText(),"User should be able to see error message for less than 4 characters in  Username");
         }
     else
     { 
        statusTracker(br,"Fail","Verify if User is able to see error message for for less than 4 characters in Username","User is not able to see error message  for less than 4 characters in  Username ","User should be able to see error message for less than 4 characters in  Username");     
     }
         driver.findElement(By.id("unfuserName")).clear();
         driver.findElement(By.id("unfuserName")).sendKeys(username);
         
         focusClick(driver, driver.findElement(By.xpath("(//button[@type='submit'])[4]")),br);
         statusTracker(br,"","Error Validation of Password","","");
         focusClick(driver,driver.findElement(By.linkText("Edit Password")),br);
           driver.findElement(By.id("pwfPassword")).clear();
           driver.findElement(By.id("pwfPassword")).sendKeys(pwd);
           driver.findElement(By.id("pwfNewPassword")).clear();
           driver.findElement(By.id("pwfNewPassword")).sendKeys(pwd);
           driver.findElement(By.id("pwfConfPassword")).clear();
           driver.findElement(By.id("pwfConfPassword")).sendKeys(pwd);
           focusClick(driver, driver.findElement(By.xpath("(//button[@type='submit'])[6]")),br);
           
           if( focusSearch(driver,driver.findElement(By.xpath("//html/body/section/div[7]/div/div/ul/li")),br))
                 statusTracker(br,"Pass","Verify if User is able to see error message for Same Password","Error Message for same Current and New Password:"+driver.findElement(By.xpath("//html/body/section/div[7]/div/div/ul/li")).getText(),"User should be able to see error message for same password");
                
            else
                statusTracker(br,"Fail","Verify if User is able to see error message for same password","User is not able to see error message for same password ","User should be able to see error message for same password");    
           
           driver.findElement(By.id("pwfPassword")).clear();
           driver.findElement(By.id("pwfPassword")).sendKeys("password2");
           driver.findElement(By.id("pwfNewPassword")).clear();
           driver.findElement(By.id("pwfNewPassword")).sendKeys(pwd);
           driver.findElement(By.id("pwfConfPassword")).clear();
           driver.findElement(By.id("pwfConfPassword")).sendKeys(pwd);
           focusClick(driver, driver.findElement(By.xpath("(//button[@type='submit'])[6]")),br);
           if( focusSearch(driver,driver.findElement(By.xpath("//html/body/section/div[7]/div/div/ul/li")),br))
                 statusTracker(br,"Pass","Verify if User is able to see error message for Invalid Current Password","Error Message for Invalid Current Password:"+driver.findElement(By.xpath("//html/body/section/div[7]/div/div/ul/li")).getText(),"User should be able to see error message for wrong current password");
                
            else
                statusTracker(br,"Fail","Verify if User is able to see error message for wrong current password","User is not able to see error message for wrong current password ","User should be able to see error message for wrong current password");    
           
           driver.findElement(By.id("pwfPassword")).clear();
           driver.findElement(By.id("pwfPassword")).sendKeys(pwd);
           driver.findElement(By.id("pwfNewPassword")).clear();
           driver.findElement(By.id("pwfNewPassword")).sendKeys("password2");
           driver.findElement(By.id("pwfConfPassword")).clear();
           driver.findElement(By.id("pwfConfPassword")).sendKeys("password2");
           focusClick(driver, driver.findElement(By.xpath("(//button[@type='submit'])[6]")),br);
           
           
           if((driver.findElements(By.xpath("//html/body/section/p[1]/strong")).size()>0))
           {
                 statusTracker(br,"Pass","Verify if User is able to Update password","User is able to Update Password Successfully","User should be able to see Updated password");
           }
            else
            {
                statusTracker(br,"Fail","Verify if User is able to Update  password","User is not able to see Updated password ","User should be able to see Updated password");    
            }
           Thread.sleep(2000);
          
           System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");  
           focusClick(driver,driver.findElement(By.linkText("Edit Security Questions")),br);
           driver.findElement(By.id("sa1")).clear();
           driver.findElement(By.id("sa1")).sendKeys("a");
           driver.findElement(By.id("sa2")).clear();
           driver.findElement(By.id("sa2")).sendKeys("a");
           driver.findElement(By.id("scfPassword")).clear();
           driver.findElement(By.id("scfPassword")).sendKeys("password2");
           focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[8]")),br);
           
        
           if(driver.findElements(By.xpath("//html/body/section/p[1]/strong")).size()>0)
              
             statusTracker(br,"Pass","Verify if User is able to Update Security Question & Answers","User is able to Update Security Question & Answers Successfully","User should be able to see Updated Security Question & Answers");
                
            else
                statusTracker(br,"Fail","Verify if User is able to Update  Security Question & Answers","User is not able to see Updated Security Question & Answers ","User should be able to see Updated Security Question & Answers");    
           statusTracker(br,"","Error Validation of Security Questions and Answers","","");
           Thread.sleep(2000);
           focusClick(driver,driver.findElement(By.linkText("Edit Security Questions")),br);
           driver.findElement(By.id("sa1")).clear();
           driver.findElement(By.id("sa1")).sendKeys("a");
           System.out.println("Executed till here");
           
           
           focusDropdown(driver,"//html/body/section/div[8]/div[1]/div[4]/div[2]/div[6]/form/div[6]/span","What is the name of the street you grew up on?",br);
           System.out.println("done");
           if(driver.findElements(By.xpath("/html/body/section/div[8]/div[1]/div[4]/div[2]/div[6]/form/div[6]/span/div")).size()>0)
              
              statusTracker(br,"Pass","Verify if User is able to see error message for same Security Question","Error Message displayed for same Security Questions: "+driver.findElement(By.cssSelector("span.dropdown.col-10 > div.label-txt.error")).getText(),"User should be able to see error message for same Security Question");
                
            else
                statusTracker(br,"Fail","Verify if User is able to see error message for same Security Question","User is not able to see error message for same Security Question ","User should be able to see error message for same Security Question");    
          
       
           focusClick(driver,driver.findElement(By.xpath("/html/body/section/div[8]/div[1]/div[4]/div[2]/div[6]/form/div[11]/button[1]")),br);
               
           System.out.println("Coming Herrererjkjkjk");
           Thread.sleep(2000);
           focusClick(driver,driver.findElement(By.linkText("Edit Security Questions")),br);
                  driver.findElement(By.id("sa1")).clear();
                  driver.findElement(By.id("sa1")).sendKeys("a");
                  driver.findElement(By.id("sa2")).clear();
                  driver.findElement(By.id("sa2")).sendKeys("a");
                  driver.findElement(By.id("scfPassword")).clear();
                  driver.findElement(By.id("scfPassword")).sendKeys("password6787");
                  focusClick(driver,    driver.findElement(By.xpath("(//button[@type='submit'])[8]")),br);
                  
    
           if((driver.findElements(By.xpath("/html/body/section/div[6]")).size()>0))
           { 
             statusTracker(br,"Pass","Verify if User is able to see error message for wrong password in Security Question tab","Error Message displayed for Wrong Password:","User should be able to see error message for wrong password in Security Question tab");
           }                                                                                                                                                                                         
            else
            {
                statusTracker(br,"Fail","Verify if User is able to see error message for wrong password in Security Question tab","User is not able to see error message for wrong password in Security Question tab ","User should be able to see error message for wrong password in Security Question tab");    
           
            }
           
           
         
         return state;   
           
  }
  
public String EditUser(String br,WebDriver driver) throws Exception
  {
         String state="Fail",Email="abc4";
         statusTracker(br,"","Editing First Name, Last Name and Email Address","","");
         focusClick(driver, driver.findElement(By.linkText("Edit User Info")),br);
      driver.findElement(By.id("uefirstName")).clear();
      driver.findElement(By.id("uefirstName")).sendKeys("Apollo");
      
      driver.findElement(By.id("uelastName")).clear();
      String s1="Account";
      s1=s1+randomNO(99,05);
      driver.findElement(By.id("uelastName")).sendKeys(s1);
      focusClick(driver, driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
      Thread.sleep(3000);
      String Edit=driver.findElement(By.xpath("/html/body/section/div[8]/div[1]/div[1]/div[2]/div[1]/div[1]/label")).getText();
      
      if((driver.findElements(By.xpath("/html/body/section/p[1]/strong")).size()>0))
                                       
      {
          statusTracker(br,"Pass","Verify if User is able to edit Name","The Updated Name is:"+ Edit,"User should be able to edit Name");
      } 
      else
      {
         statusTracker(br,"Fail","Verify if User is able to edit Name","User is not able to edit Name ","User should be able to edit Name");  
      }
      focusClick(driver,driver.findElement(By.linkText("Edit User Info")),br);
      
      String s=Email+randomNO(99,05)+"@gmail.com";
      
      driver.findElement(By.id("ueemailAddress")).clear();
      driver.findElement(By.id("ueemailAddress")).sendKeys(s);
      focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
      
      if((driver.findElements(By.xpath("/html/body/section/p[1]/strong")).size()>0))
      {  
      statusTracker(br,"Pass","Verify if User is able to edit  email","User is able to Edit Email Address Successfully" ,"User should be able to edit email");
      }
      else
      {
         statusTracker(br,"Fail","Verify if User is able to edit email","User is not able to edit email ","User should be able to edit email");  
      }
      focusClick(driver,driver.findElement(By.linkText("Edit User Info")),br);
      statusTracker(br,"","Error Validation For First Name, Last Name and Email Address","","");
      driver.findElement(By.id("uefirstName")).clear();
      driver.findElement(By.id("uelastName")).clear();
      
      if((driver.findElements(By.xpath("/html/body/section/div[8]/div[1]/div[2]/div[2]/form/div[2]/div[1]/div")).size()>0)&&(driver.findElements(By.xpath("/html/body/section/div[8]/div[1]/div[2]/div[2]/form/div[4]/div[1]/div")).size()>0))
      {                                                   
       statusTracker(br,"Pass","Verify if User is able to see error message for blank first name and last name","Error Message Displayed for Blank First Name and Last Name:"+driver.findElement(By.xpath("/html/body/section/div[8]/div[1]/div[2]/div[2]/form/div[2]/div[1]/div")).getText(),"User should be able to see error message for blank first name and last name");
      }
      else
      {
         statusTracker(br,"Fail","Verify if User is able to see error message for blank first name and last name","User is not able to see error message for blank first name and last name ","User should be able to see error message for blank first name and last name");  
      }
     driver.findElement(By.id("ueemailAddress")).clear();
      if(driver.findElements(By.xpath("/html/body/section/div[8]/div[1]/div[2]/div[2]/form/div[6]/div[1]/div")).size()>0)
      {  statusTracker(br,"Pass","Verify if User is able to see error message for blank email","Error Message Displayed for Blank Email Address:"+driver.findElement(By.xpath("/html/body/section/div[8]/div[1]/div[2]/div[2]/form/div[6]/div[1]/div")).getText(),"User should be able to see error message for blank email");
      }
     else
     {
        statusTracker(br,"Fail","Verify if User is able to see error message for blank email","User is not able to see error message for blank email ","User should be able to see error message for blank email");    
     }
        
  return state;
  }
  public String Unsavedpopup(String br,WebDriver driver) throws InterruptedException
  {
         String state="Fail";
      System.out.println("Unsavedpopup");
      statusTracker(br,"","The Unsaved Pop Up Validation for Profiles Page","",""); 
      Thread.sleep(3000);
      focusClick(driver, driver.findElement(By.linkText("Edit User Info")),br);
      driver.findElement(By.id("uefirstName")).clear();
      driver.findElement(By.id("uefirstName")).sendKeys("Apollo"+randomNO(99,05));
      focusClick(driver,driver.findElement(By.linkText("Home")),br);
         
     Boolean CH=  focusSearch(driver,driver.findElement(By.xpath("//*[@id='modal-save']/div")),br);
     
       System.out.println("pop up display");
       if(CH==true)
       {
          focusClick(driver,driver.findElement(By.id("cancelSaveFeature")),br);
       
         
        System.out.println("pop up display1");
        
        if(driver.findElements(By.xpath("//html/body/section/h1")).size()>0)
        {
          System.out.println("Success");
          statusTracker(br,"Pass","Verify if clicking on cancel of Unsaved pop up is navigating to Profile Page","Successfully navigate back to Profile Page on clicking cancel","Success");
        }   
        else
        {
          System.out.println("Fail");
          statusTracker(br,"Fail","Unsaved pop up Cancel dint work","Unsuccessful","Unable to process successfully");
        }
       }  
       Thread.sleep(2000);
       
       focusClick(driver,driver.findElement(By.linkText("Home")),br);
       System.out.println("done");
       focusClick(driver, driver.findElement(By.xpath("//*[@id='unsavedFeature']/span")),br);
       System.out.println("done1");    
         if(driver.findElements(By.xpath("/html/body/header/div[4]/div[2]/nav/ul/li[1]/a")).size()>0)
         {
               
               statusTracker(br,"Pass","Verify if clicking on OK navigating to Home Page","Successfully navigated to Home Page on clicking OK","Success");
        state="Pass";
        }  
         else
         {
           System.out.println("Fail");
           statusTracker(br,"Fail","Unsaved pop up Cancel didnt work","Unsuccessful","Unable to process successfully");
         }
         
                return state;
                  
  }
  public String Cancel(String br,WebDriver driver)
  {
         String state="Fail";
      
      System.out.println("Cancel");
      statusTracker(br,"","The Apollo Profile Page Cancel Transactions ","",""); 
      focusClick(driver,driver.findElement(By.linkText("Profile")),br);
      String Before=driver.findElement(By.xpath("/html/body/section/div[8]/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[2]/span")).getText();
      System.out.println(Before);
      focusClick(driver,driver.findElement(By.linkText("Edit User Info")),br);
      driver.findElement(By.id("ueemailAddress")).clear();
      focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-secondary")),br);
      String After=driver.findElement(By.xpath("/html/body/section/div[8]/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[2]/span")).getText();
      statusTracker(br,"","Verify if the user is able to cancel the changes made","Before Clicking Cancel: " +Before ,"Successfully cancel order");
      
      if( focusSearch(driver,driver.findElement(By.linkText("Edit User Info")),br))
      {
        System.out.println("Success");
        state="Pass";
        statusTracker(br,"Pass","Verify if the user is able to cancel the changes made","After Clicking Cancel: "+After ,"Successfully cancel order");
        
      }
       else
      {
        System.out.println("Fail");
        statusTracker(br,"Fail","Verify if the user is able to cancel the changes made","Not able to cancel order","Cancel did not work");
      }
      
       return state;
  }

  private boolean assertTrue(boolean elementPresent) {
       // TODO Auto-generated method stub
       return false;
}

  public void execute(String br, WebDriver driver, String url, int loc, String name1) throws Exception {
              
         
         int tlim=3;
         String status1="",state = "Fail";
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
        try {
        if(first==0)
            {
                login(driver,username,pwd);
            }
            logger.info("1");
            focusClick(driver, driver.findElement(By.linkText("Profile")),br);
                  state="Pass";
                  if(state.equals("Pass"))
                  {
                   state=EditUser(br,driver);
                   state=LoginandSecurity(br,driver);
                   state=Unsavedpopup(br,driver);
                   state=Cancel(br,driver);
                   
                   focusClick(driver, driver.findElement(By.xpath("//html/body/header/div[1]/nav/ul[2]/li[3]/a")),br);
                   Thread.sleep(3000);
                   driver.findElement(By.id("Ecom_User_ID")).sendKeys(username);
         		 
         		  driver.findElement(By.id("Ecom_Password")).sendKeys("password2");
         		 
         		  driver.findElement(By.id("btnLogin")).click();
                   focusClick(driver, driver.findElement(By.linkText("Profile")),br);
                   focusClick(driver,driver.findElement(By.linkText("Edit Password")),br);
                   driver.findElement(By.id("pwfPassword")).clear();
                   driver.findElement(By.id("pwfPassword")).sendKeys("password2");
                   driver.findElement(By.id("pwfNewPassword")).clear();
                   driver.findElement(By.id("pwfNewPassword")).sendKeys(pwd);
                   driver.findElement(By.id("pwfConfPassword")).clear();
                   driver.findElement(By.id("pwfConfPassword")).sendKeys(pwd);
                   focusClick(driver, driver.findElement(By.xpath("(//button[@type='submit'])[6]")),br);
                 
                   }
        
                  first=1;      
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
  
    



private By By(String attribute) {
          // TODO Auto-generated method stub
          return null;
}

}
