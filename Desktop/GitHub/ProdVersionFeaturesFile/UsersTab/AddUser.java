package ApolloNew;


import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.openqa.selenium.*;

public class AddUser extends CommonFunctions
{
    String table, tns[];
    String tlimit,username,pwd,Email,firstname;
    int tncount;
    String name1,email1,ustatus1;

  public AddUser(String path) {
                                this.path = path;
                }
  
  private boolean isElementPresent(WebDriver driver, By by)
  {
                  try{
                                                  driver.findElement(by);
                                                  return true;
                                  }
                                                  catch(NoSuchElementException e){
                                                  return false;
                                  }
  }
    
  public void NewUser1(WebDriver driver)throws Exception
  {
      driver.findElement(By.id("uefirstName")).clear();
      driver.findElement(By.id("uefirstName")).sendKeys("test");
      driver.findElement(By.id("uelastName")).clear();
      driver.findElement(By.id("uelastName")).sendKeys("One"+randomNO(99,05));
      driver.findElement(By.id("ueemailAddress")).clear();
      driver.findElement(By.id("ueemailAddress")).sendKeys(Email);
  
  }
  public void AddNewUser(String br,WebDriver driver,int c)throws Exception
  {
                  
                  focusClick(driver, driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
                  focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserModal']/div/div/div[2]/div/form/div/div/label")),br);
      NewUser1(driver);
      focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserModal']/div/div[2]/span[2]")),br);
      focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserPhoneLines']/div/div[2]/span[2]")),br);
      focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserSecondStep']/div/div/div[2]/div/div[11]/div/span")),br);

      focusDropdown(driver,"//html/body/section/div[4]/div[1]/div[2]/div/span","Pending",br);
      
      int chk=0;
      do{
                  
          chk++;
                }
      while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
      int rowCount=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
      System.out.println("count is after adding"+rowCount);
      if (rowCount>=c)
      {
          System.out.println("Success");
          statusTracker(br,"Pass","Verify Admin is able to send email for adding Coadmin without lines "," Admin is able to send email for adding Coadmin without lines ","Admin should be  able to send email for adding Coadmin without lines ");                                                                   
      }
      else
      {
                      System.out.println("Fail");
                      statusTracker(br,"Fail","Verify Admin is  able to send email for adding Coadmin without lines  ","Admin is not  able to send email for adding Coadmin without lines ","Admin should be  able to send email for adding Coadmin without lines ");
      }
      
      focusClick(driver, driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
      
      NewUser1(driver);
      focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserModal']/div/div[2]/span[2]")),br);
      focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserPhoneLines']/div/div[2]/span[2]")),br);
      focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserSecondStep']/div/div/div[2]/div/div[11]/div/span")),br);
      
      Thread.sleep(2000);
      focusDropdown(driver,"//html/body/section/div[4]/div[1]/div[2]/div/span","Pending",br);
     
      chk=0;
      do{
                  System.out.println("Processing!" +chk);
          chk++;
                }
      while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
      rowCount=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
      System.out.println("count is after adding"+rowCount);
      if (rowCount>c)
      {
          System.out.println("Success");
          statusTracker(br,"Pass","Verify Admin is able to send email for adding User without lines "," Admin is able to send email for adding User without lines ","Admin should be  able to send email for adding User without lines ");                                                                   
      }
      else
      {
                      System.out.println("Fail");
                      statusTracker(br,"Fail","Verify Admin is  able to send email for adding User without lines  ","Admin is not  able to send email for adding User without lines ","Admin should be  able to send email for adding User without lines ");
      }
      
      
      focusClick(driver, driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
       NewUser1(driver);
       focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserModal']/div/div[2]/span[2]")),br);
       focusClick(driver, driver.findElement(By.xpath("//button[@type='submit']")),br);
       focusClick(driver, driver.findElement(By.xpath("//button[@type='submit']")),br);
      
       focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserPhoneLines']/div/div[2]/span[2]")),br);
       focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserSecondStep']/div/div/div[2]/div/div[11]/div/span")),br);
      Thread.sleep(2000);

      focusDropdown(driver,"//html/body/section/div[4]/div[1]/div[2]/div/span","Pending",br);
      
       chk=0;
      do{
                  System.out.println("Processing!" +chk);
          chk++;
                }
      while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
      rowCount=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
      System.out.println("count is after adding"+rowCount);
      if (rowCount>c)
      {
          System.out.println("Success");
          statusTracker(br,"Pass","Verify Admin is able to send email for adding User with lines "," Admin is able to send email for adding User with lines ","Admin should be  able to send email for adding User with lines ");                                                                   
      }
      else
      {
                      System.out.println("Fail");
                      statusTracker(br,"Fail","Verify Admin is  able to send email for adding User with lines  ","Admin is not  able to send email for adding User with lines ","Admin should be  able to send email for adding User with lines ");
      }
      
      
      focusClick(driver, driver.findElement(By.linkText("Users")),br);
      focusClick(driver, driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
      focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserModal']/div/div/div[2]/div/form/div/div/label")),br);
      NewUser1(driver);
     
      focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserModal']/div/div[2]/span[2]")),br);
      focusClick(driver, driver.findElement(By.xpath("//button[@type='submit']")),br);
      focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserPhoneLines']/div/div[2]/span[2]")),br);
      focusClick(driver,    driver.findElement(By.linkText("Edit User Info")),br);
      do{
          System.out.println("Processing!" +chk);
          chk++;
        }while(!(driver.findElement(By.xpath("//*[@id='addUserModal']/div/div[1]/div[1]")).isDisplayed()));
      
    
      if(driver.findElements(By.xpath("//*[@id='addUserModal']/div/div[1]/div[1]")).size()>0)
    statusTracker(br,"Pass","Verify Admin is able to Edit User Info "," Admin is able to Edit User Info","Admin should be  able to Edit User Info");   
      else
                  statusTracker(br,"Fail","Verify Admin is able to Edit User Info "," Admin is  not able to Edit User Info","Admin should be  able to Edit User Info");     
      driver.findElement(By.id("uefirstName")).clear();
      driver.findElement(By.id("uefirstName")).sendKeys("Stest");
      focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserModal']/div/div[2]/span[2]")),br);
      focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserPhoneLines']/div/div[2]/span[2]")),br);
      focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserSecondStep']/div/div/div[2]/div/div[11]/div/span[3]")),br);
      Thread.sleep(2000);
      if(driver.findElement(By.xpath("//html/body/header/div[4]/div[1]/div[1]/span")).isDisplayed())
                  statusTracker(br,"Pass","Verify Admin is able to Navigate to Home page "," Admin is able to Navigate to Home page","Admin should be  able to Navigate to Home page");   
       else
                  statusTracker(br,"Fail","Verify Admin is able to Navigate to Home page "," Admin is  not able to Navigate to Home page","Admin should be  able to Navigate to Home page");           
  }

  public void DisplaybyName(String br,WebDriver driver,int c) throws Exception
  {
                  System.out.println("In Display by Name");
                  focusClick(driver,  driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[3]/a")),br);

                  focusDropdown(driver,"//html/body/section/div[4]/div[1]/div[2]/div/span","All Statuses",br);
                  
                 
      int chk=0;
      do{
                    System.out.println("Processing!" +chk);
                    chk++;
      }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                  focusClick(driver,  driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[1]/ul/li[1]/span")),br);
                  Thread.sleep(4000);
                  int rowCount=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
                  System.out.println("Number of rows is"+rowCount);
                  if(rowCount<=c)
                  {
                                  statusTracker(br,"Pass"," Verify Admin is able to Display data by Name -A","Admin is able to Display data by Name -A ","Admin should be  able to Display data by Name -A"); 
                  
                                                  if(rowCount<=2)
                                                  {
                                                                String s= driver.findElement(By.xpath("//html/body/section/div[4]/section/div[2]")).getText();
                                                                   
                                                                  statusTracker(br,""," "," "+s,"");                
                                                  }
                                                  else
                                                  {
                                                                  for(int i=1;i<rowCount;i++)
                                                                  {
                                                                                  String s = driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div")).getText();
                                                                                
                                                                                  statusTracker(br,""," "," "+s,""); 
                                                                  }
                                                  }
                  }
                  else
                                  statusTracker(br,"Fail"," Verify Admin is able to Display data by Name -A","Admin is not able to Display data by Name -A ","Admin should be  able to Display data by Name -A");   
                 
                  focusClick(driver, driver.findElement(By.cssSelector("li.line-height-2x > span > strong")),br);
                  Thread.sleep(2000);
                int rowCount1=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
                  System.out.println("Number of rows is"+rowCount1);
                  if(rowCount1>=rowCount)
                  {
                                  System.out.println("Number");
                                                  statusTracker(br,"Pass"," Verify Admin is able to Display all data ","Admin is able to Display all data ","Admin should be  able to Display all data "); 

                                                  if(rowCount1<=2)
                                                  {
                                                                String s= driver.findElement(By.xpath("//html/body/section/div[4]/section/div[2]")).getText();
                                                                   
                                                                  statusTracker(br,""," "," "+s,"");                
                                                  }
                                                  else
                                                  {
                                                                                  for(int i=1;i<rowCount1;i++)
                                                                                  {
                                                                                                  String s=driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div")).getText();
                                                                                                  
                                                                                                  statusTracker(br,""," "," "+s," "); 
                                                                                  }
                                                  }
                  }
                  else
                                  statusTracker(br,"Fail"," Verify Admin is able to Display all data","Admin is not able to Display all data ","Admin should be  able to Display  all data ");                     
  }

  public String ChangeUserStatus(String br,WebDriver driver,int c,String schk)throws Exception
  {
                  schk="Fail";int f=1;
                  
                  focusClick(driver,  driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[3]/a")),br);

                  focusDropdown(driver,"//html/body/section/div[4]/div[1]/div[2]/div/span","Active",br);
                
                  
                  int chk=0;
      do{
       chk++;
      }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
      
      int usrcnt=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
      System.out.println("Count"+usrcnt);
     
      for(int i=1;i<usrcnt;i++)
      {
                  if((driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[3]")).getText()).equals("Standard") || (driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[3]")).getText()).equals("Co-Administrator"))
          {
              f=0;
                 
                 focusClick(driver, driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[5]/a")),br);
                 focusClick(driver, driver.findElement(By.xpath("//div[@id='userStatusModal']/div/div[2]/span[2]")),br);

                 focusDropdown(driver,"//html/body/section/div[4]/div[1]/div[2]/div/span","Disabled",br);
               
    chk=0;
      do{
                    System.out.println("Processing!" +chk);
                    chk++;
      }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
      int  rowCount=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
        System.out.println("Number of rows is"+rowCount);
        if (rowCount>=c)
        
           
            statusTracker(br,"Pass","Verify Admin is able to Change User status to Disable "," Admin is able to Change User status to Disable","Admin should be  able to Change User status to Disable");                                                                   
          
           else
          
            
            statusTracker(br,"Fail","Verify Admin is  able to Change User status to Disable ","Admin is not  able to Change User status to Disable","Admin should be  able to Change User status to Disable");
        Thread.sleep(2000);
        focusClick(driver, driver.findElement(By.linkText("Change Status")),br);
        focusClick(driver, driver.findElement(By.xpath("//div[@id='userStatusModal']/div/div[2]/span[2]")),br);
       Thread.sleep(2000);
       int rowCount1=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
       System.out.println("Number of rows is"+rowCount1);
                  if(rowCount1<=rowCount)

          statusTracker(br,"Pass","Verify Admin is able to Change User status to Active "," Admin is able to Change User status to Active","Admin should be  able to Change User status to Active");                                                                   
        
         else
        
          
          statusTracker(br,"Fail","Verify Admin is  able to Change User status to Active ","Admin is not  able to Change User status to Active","Admin should be  able to Change User status to Active");
                  schk="Pass";
                  break;
          
          }
                   
                  
      }
     if(f==1)
                                  
                   {statusTracker(br,"Fail","Verify Admin is  able to Change User status  ","There is no Users in this account",""); 
                   schk="Fail";
                   } 
     return schk;
  } 
  
  public void ExpiredUser(String br,WebDriver driver,int c)throws Exception
  { 
                  System.out.println("In Expired User");

                  focusDropdown(driver,"//html/body/section/div[4]/div[1]/div[2]/div/span","Expired",br);
                
                  int chk=0;
      do{
                    
                    chk++;
      }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
      
      int usrcnt=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
      System.out.println("Count"+usrcnt);  
                  
                  if(usrcnt==2)
                  {
                                  String s=driver.findElement(By.xpath("//html/body/section/div[4]/section/div[2]")).getText();
                                  System.out.println(s);
                                  if(s.contains("No data"))
                                                  statusTracker(br,"Fail","Verify Admin is able to  resend email for adding Expired User  "," No Expired Users","");      
                                  else
                                  { 
                                                driver.findElement(By.xpath("//html/body/section/div[4]/section/div[2]/div/div[5]/a")).click();
                                   NewUser1(driver);
                                   focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserModal']/div/div[2]/span[2]")),br);
                      focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserPhoneLines']/div/div[2]/span[2]")),br);
                      focusClick(driver, driver.findElement(By.xpath("//div[@id='addUserSecondStep']/div/div/div[2]/div/div[11]/div/span")),br);

                      focusDropdown(driver,"//html/body/section/div[4]/div[1]/div[2]/div/span","Pending",br);
                     
                                      chk=0;
                                      do{
                                                  
                                          chk++;
                                                }
                                      while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                      
                                      Thread.sleep(3000);
                                      int rowCount=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
                                      System.out.println("count after adding"+rowCount);
                                      if (rowCount>=c)
                                      {
                                          System.out.println("Success");
                                          statusTracker(br,"Pass","Verify Admin is able to  resend email for adding Expired User  "," Admin is able to resend email for Expired User ","Admin should be  able to resend email for Expired User");                                                                   
                                      }
                                      else
                                      {
                                                      System.out.println("Fail");
                                                      statusTracker(br,"Fail","Verify Admin is  able to resend email for adding Expired User   ","Admin is not  able to resend email for adding Expired User ","Admin should be  able to resend email for adding Expired User ");
                                      }
                                  }   
                  }
                  else 
                  {
                                  driver.findElement(By.xpath("//html/body/section/div[4]/section/div[2]/div/div[5]/a")).click();
                                  NewUser1(driver);
                                  driver.findElement(By.xpath("//div[@id='addUserModal']/div/div[2]/span[2]")).click();
                                   
                                    driver.findElement(By.xpath("//div[@id='addUserPhoneLines']/div/div[2]/span[2]")).click();
                                    driver.findElement(By.xpath("//div[@id='addUserSecondStep']/div/div/div[2]/div/div[11]/div/span")).click();
                                    focusDropdown(driver,"//html/body/section/div[4]/div[1]/div[2]/div/span","Pending",br);
                                      chk=0;
                                      do{
                                                  System.out.println("Processing!" +chk);
                                          chk++;
                                                }
                                      while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                      Thread.sleep(5000);
                                      int rowCount=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
                                      System.out.println("count after adding"+rowCount);
                                      if (rowCount>=c)
                                      {
                                          System.out.println("Success");
                                          statusTracker(br,"Pass","Verify Admin is able to  resend email for Expired User  "," Admin is able to resend email for Expired User ","Admin should be  able to resend email for Expired User ");                                                                   
                                      }
                                      else
                                      {
                                                      System.out.println("Fail");
                                                      statusTracker(br,"Fail","Verify Admin is  able to resend email for adding Expired User   ","Admin is not  able to resend email for adding Expired User ","Admin should be  able to resend email for adding Expired User ");
                                      }
                                      
                                  
                  }
                
                                                  
  }
  
  
  
  public void DeleteUser(String br,WebDriver driver)throws Exception
                  {
                  
                  System.out.println("In Delete User");

                                  focusDropdown(driver,"//html/body/section/div[4]/div[1]/div[2]/div/span","Active",br);
                  
                  int chk=0;
      do{
                   
                    chk++;
      }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
      
    int  rowCount=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
    System.out.println("Number of rows are"+rowCount);
    for(int i=1;i<rowCount;i++)
    {
                String s=driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[3]")).getText();
                System.out.println(s);
                String s1=driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[3]")).getText();
                System.out.println(s1);
       if((s).equals("Standard") || (s1).equals("Co-Administrator"))
        {
            
                        focusClick(driver, driver.findElement(By.linkText("Change Status")),br);
                       focusClick(driver, driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/span[1]")),br);
                if(driver.findElement(By.xpath("//html/body/section/div[4]/section/div[1]/div/label[1]")).isDisplayed())
                statusTracker(br,"Pass","Verify Admin is able to Cancel change user status "," Admin is able to  cancel Change User status ","Admin should be  able to cancel Change User status ");                                                                   
                
                else
               
                 statusTracker(br,"Pass","Verify Admin is able to Cancel change user status "," Admin is not  able to  cancel Change User status ","Admin should be  able to cancel Change User status ");                                                           
                focusClick(driver, driver.findElement(By.linkText("Change Status")),br);
                focusClick(driver,  driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/i")),br);
                if(driver.findElement(By.xpath("//html/body/section/div[4]/section/div[1]/div/label[1]")).isDisplayed())
                statusTracker(br,"Pass","Verify Admin is able to Close change user status pop up "," Admin is able to  Close Change User status pop up ","Admin should be  able to Close Change User status pop up ");                                                                   
                
                else
               
                 statusTracker(br,"Pass","Verify Admin is able to Close change user status pop up "," Admin is not  able to  Close Change User status pop up ","Admin should be  able to Close Change User status pop up ");  
                
                Thread.sleep(2000);
                focusClick(driver, driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[5]/a")),br);
            
                focusClick(driver, driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/div[6]/div[2]/label")),br);
               focusClick(driver, driver.findElement(By.xpath("//div[@id='userStatusModal']/div/div[2]/span[2]")),br);
               Thread.sleep(2000);
               int rowCount1=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
                  if(rowCount1<rowCount)

                  statusTracker(br,"Pass","Verify Admin is able to Delete User "," Admin is able to Delete User","Admin should be  able to Delete User");                                                                   
                
                 else
                
                  
                  statusTracker(br,"Fail","Verify Admin is  able to Delete User ","Admin is not  able to Delete User","Admin should be able to Delete User");
                 
               
               
              break;    
        }   
                                    
   }
   
                  
                  }
                      
  

public void execute(String br, WebDriver driver, String url, int loc, String name1) throws Exception {
      
     // arrcount=0;
     int tlim=3;
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
             Email=sheet2.getCell(8, loc).getContents();
             firstname=sheet2.getCell(9, loc).getContents();
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
                  String schk ="Pass";
                 
                  focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]/a")),br);
                  focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[3]/a")),br);
                  System.out.println("checkpoint1");
                  if(!(InternalException(driver,br)))
                              {
                  int rowCount=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
                  System.out.println("total count is"+rowCount);
                  
                  focusDropdown(driver,"//html/body/section/div[4]/div[1]/div[2]/div/span","Pending",br);
         
                int chk=0;
                  do{
                                System.out.println("Processing!" +chk);
                                chk++;
                  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                int rowCoun=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
                  System.out.println(" Pending count is"+rowCoun);
                  
                  focusDropdown(driver,"//html/body/section/div[4]/div[1]/div[2]/div/span","Disabled",br);
                  
                 chk=0;
                  do{
                                System.out.println("Processing!" +chk);
                                chk++;
                  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                  int rc=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
                  System.out.println(" Disabled count is"+rc);
                 AddNewUser(br,driver,rowCoun);
                 DisplaybyName(br,driver,rowCount);
                schk=ChangeUserStatus(br,driver,rc,schk);
                if(schk=="Pass")
                 {
                 DeleteUser(br,driver);
                 }
                 ExpiredUser(br,driver,rowCoun);
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
                //wb.close();
                
                }
                }
                
                private boolean isElementPresent(org.openqa.selenium.By xpath) {
                                // TODO Auto-generated method stub
                                return false;
                }
                
                private By By(String attribute) {
                          // TODO Auto-generated method stub
                          return null;
                }
}