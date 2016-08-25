package ProdVersionFeaturesFile.UsersTab;

import com.thoughtworks.selenium.Selenium;

import ProdVersionFeaturesFile.CommonFunctions;

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

public class EditUser extends CommonFunctions {
                
                String table, tns[];
    String tlimit,username,pwd,fname,lname,email, name1,email1,ustatus1,name2,email2,ustatus2;
    int tncount;                                                    
                                
    String phoneline,phoneline_ac,Acccode;
                int rank[]= new int[50];
                

                int c_sequence;
                String name_for_rank[]= new String[40];
                String price, rank_channels;

                public EditUser(String path) {
                                this.path = path;
                }
                
    public String Errval(WebDriver driver, int test,String br) throws Exception
    {                                                                                                                             
                    focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[2]/form/div[4]/div/div[3]/a")),br);

                driver.findElement(By.id("uefirstName")).clear();                                           
                statusTracker(br,"","The error message for blank first name is",driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[3]/form/div[3]/div[1]/div")).getText(),"");
                                
                driver.findElement(By.id("uelastName")).clear();
                statusTracker(br,"","The error message for blank last name is",driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[3]/form/div[5]/div[1]/div")).getText(),"");
                
                driver.findElement(By.id("ueemailAddress")).clear();
                statusTracker(br,"","The error message for blank Email is",driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[3]/form/div[7]/div[1]/div")).getText(),"");
                
                focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-secondary")),br);

                Thread.sleep(1000);
                    logger.info("cancel"+driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[3]")).getAttribute("class"));
                    if(driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[3]")).getAttribute("class").equals("inner-box ng-hide"))
                {
                                statusTracker(br,"","The User info cancel working fine","","");
                }
                Thread.sleep(2000);
                    focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[2]/form/div[4]/div/div[3]/a")),br);

                driver.findElement(By.id("ueemailAddress")).clear();
                driver.findElement(By.id("ueemailAddress")).sendKeys("k.y.sada");
                statusTracker(br,"","The error message for invalid Email is",driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[3]/form/div[7]/div[1]/div")).getText(),"");
                
                   if(test==1)
                   {
                   focusClick(driver,driver.findElement(By.linkText("Change Status")),br);
                   focusClick(driver,driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/div[6]/div[2]/label")),br);
                   focusClick(driver,driver.findElement(By.xpath("//div[@id='userStatusModal']/div/div[2]/span[2]")),br);

                     Thread.sleep(4000);
                     logger.info("url"+driver.getCurrentUrl());
                     if(driver.getCurrentUrl().equals("https://voicemanager.timewarnercable.com/UserAdmin/Users"))
                                 {
                                               statusTracker(br,"Pass","Verify if able to delete the user","The user is delete sucessfully","The user should be removed sucessfully");
                                 }
                                else
                                 {
                                               statusTracker(br,"Fail","Verify if able to delete the user","The user is not delete sucessfully","The user should be removed sucessfully");
                                 }
                    }
                
                return email;
    
    }
    
    public String EditUser(WebDriver driver,String fname,String lname,String email,int test,String br) throws Exception
    {
                logger.info("Edit User");
                    name2=driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[2]/form/div[2]/div/label")).getText();
                                email2=driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[2]/form/div[4]/div/div[1]/div[2]/span")).getText();
                                ustatus2=driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[2]/form/div[3]/div[1]/span")).getText();
                                
                                if(name2.equals(name1))
                                {
                                                statusTracker(br,"Pass","The name in users landing and edit user page are matching",name1,"");
                                }
                                if(email2.equals(email1))
                                {
                                                statusTracker(br,"Pass","The email in users landing and edit user page are matching",email1,"");
                                }
                                if(ustatus2.equals(ustatus1))
                                {
                                                statusTracker(br,"Pass","The User Role in users landing and edit user page are matching",ustatus2,"");
                                }                                                                                                                                                              
                                
                                focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[2]/form/div[4]/div/div[3]/a")),br);

                                Thread.sleep(2000);
                                String o=randomNO(1,9);
                                driver.findElement(By.id("uefirstName")).clear();
                    driver.findElement(By.id("uefirstName")).sendKeys(fname+o);
                    
                    driver.findElement(By.id("uelastName")).clear();
                    driver.findElement(By.id("uelastName")).sendKeys(lname+o);                                                                                                                     
                    
                    focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[2]")),br);

                                do{
        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                    Thread.sleep(2000);
                    logger.info("name"+fname+" "+lname);
                    if(driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[2]/form/div[2]/div/label")).getText().equals((fname+o)+" "+(lname+o)))
                    {
                                statusTracker(br,"Pass","Verify name update for the user","The name is updated successfully " +driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[2]/form/div[2]/div/label")).getText() ,"The first name should be updated successfully");
                    }
                    else
                    {
                                statusTracker(br,"Fail","Verify name update for the user","The name is not updated successfully " +driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[2]/form/div[2]/div/label")).getText() ,"The first name should be updated successfully");
                    }                          
                    
                    if(email.equals(email2))
                    {
                                statusTracker(br,"","Verify email update for the user","The same email is present","");
                    }
                    else
                    {
                                    focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[2]/form/div[4]/div/div[3]/a")),br);

                                Thread.sleep(2000);
                                driver.findElement(By.id("ueemailAddress")).clear();
                    driver.findElement(By.id("ueemailAddress")).sendKeys(email);
                    focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[2]")),br);

                                do{
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                    if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                    {
                                statusTracker(br,"Pass","Verify email update for the user","The email is sent successfully " +email,"The first name should be sent successfully");
                        }
                    else
                    {
                                statusTracker(br,"Fail","Verify email update for the user","The name is not sent successfully " +email,"The first name should be sent successfully");
                    }          
                                
                    }                                          
                    Thread.sleep(3000);
                    if(test==1)
                    {
                                String status=driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[1]/div[2]/label[1]")).getText();
                                logger.info("status"+status);
                                focusClick(driver,driver.findElement(By.linkText("Change Status")),br);

                                Thread.sleep(2000);
                                    focusClick(driver,driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/div[6]/div[2]/label")),br);
                                focusClick(driver,driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/span[1]")),br);

                                if(driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]")).isDisplayed())
                               {
                                statusTracker(br,"Pass","Verify change status cancel","The change status pop up closed on cancel without changesing the status","");
                                }
                                else
                                {
                                statusTracker(br,"Fail","Verify change status cancel","The change status pop up closed on cancel with changesing the status","");          
                                }
                                Thread.sleep(1000);
                                focusClick(driver,driver.findElement(By.linkText("Change Status")),br);
                  
                                Thread.sleep(2000);
                                    focusClick(driver,driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/div[6]/div[2]/label")),br);
                                focusClick(driver,driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/i")),br);

                                if(driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]")).isDisplayed())
                                {
                                statusTracker(br,"Pass","Verify change status close","The change status pop up closed on close without changesing the status","");
                                }
                                else
                                {
                                statusTracker(br,"Fail","Verify change status close","The change status pop up closed on close with changesing the status","");          
                                }
                                Thread.sleep(1000);       
                                focusClick(driver,driver.findElement(By.linkText("Change Status")),br);

                                Thread.sleep(2000);
                                focusClick(driver,driver.findElement(By.xpath("//div[@id='userStatusModal']/div/div[2]/span[2]")),br);

                                    do{
                                    }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                if(status.equals("DISABLED question"))
                                {                                                                                              
                                   if(driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[1]/div[2]/label[1]")).getText().equals("ACTIVE question"))
                                   {
                                                   statusTracker(br,"Pass","Verify if able to change the status from Disable to Enable","The status is changes sucessfully to "+ driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[1]/div[2]/label[1]")).getText(),"The status should be changes sucessfully");
                                   }
                                   else
                                   {
                                                                statusTracker(br,"Fail","Verify if able to change the status from Disable to Enable","The status is changes sucessfully to "+ driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[1]/div[2]/label[1]")).getText(),"The status should be changes sucessfully");                                                              
                                   }
                                }
                                else
                                {
                                                if(driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[1]/div[2]/label[1]")).getText().equals("DISABLED question"))
                                   {
                                                   statusTracker(br,"Pass","Verify if able to change the status from Enable to Disable","The status is changes sucessfull to " + driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[1]/div[2]/label[1]")).getText(),"The status should be changes sucessfully");
                                   }
                                   else
                                   {
                                                                statusTracker(br,"Fail","Verify if able to change the status from Enable to Disable","The status is not changes sucessfull to " + driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[1]/div[2]/label[1]")).getText(),"The status should be changes sucessfully");                                                              
                                   }
                                }
                                
                                Thread.sleep(1000);
                                focusClick(driver,driver.findElement(By.linkText("Change User Role")),br);

                                Thread.sleep(2000);
                                    focusClick(driver,driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[2]/div/div[2]/div[2]/label")),br);
                                focusClick(driver,driver.findElement(By.xpath("//html/body/div[4]/div/div[2]/span[1]")),br);

                                if(driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]")).isDisplayed())
                                {
                                statusTracker(br,"Pass","Verify change Role cancel","The change Role pop up closed on cancel without changesing the status","");
                                }
                                else
                                {
                                statusTracker(br,"Fail","Verify change Role cancel","The change Role pop up closed on cancel with changesing the status","");          
                                }
                                
                                Thread.sleep(1000);
                                focusClick(driver,driver.findElement(By.linkText("Change User Role")),br);
                                Thread.sleep(2000);
                                    focusClick(driver,driver.findElement(By.xpath("//html/body/div[4]/div/div[1]/div[2]/div/div[2]/div[2]/label")),br);
                                focusClick(driver,driver.findElement(By.xpath("//html/body/div[4]/div/div[1]/i")),br);

                                if(driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]")).isDisplayed())
                                {
                                statusTracker(br,"Pass","Verify change Role close","The change Role pop up closed on close without changesing the status","");
                                }
                                else
                                {
                                statusTracker(br,"Fail","Verify change Role close","The change Role pop up closed on close with changesing the status",""); 
                                }
                                
                                Thread.sleep(1000);
                                focusClick(driver,driver.findElement(By.linkText("Change User Role")),br);
                                Thread.sleep(2000);
                                    focusClick(driver,driver.findElement(By.xpath("//html/body/div[4]/div/div[1]/div[2]/div/div[2]/div[2]/label")),br);
                                focusClick(driver,driver.findElement(By.xpath("//div[@id='userRoleModal']/div/div[2]/span[2]")),br);

                                    do{
                                    }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                    focusClick(driver,driver.findElement(By.cssSelector("#confirmModel > div.modal-container > div.modal-footer > span.btn.btn-secondary")),br);

                                if(ustatus2.equals("Standard User"))
                                {
                                                if(driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[2]/form/div[3]/div[1]/span")).getText().equals("Co-Administrator"))
                                   {
                                                   statusTracker(br,"Pass","Verify if able to change the role from standared to Co-Administrator","The role is changes sucessfull to " + driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[2]/form/div[3]/div[1]/span")).getText(),"The role should be changes sucessfully");
                                   }
                                   else
                                   {
                                                                statusTracker(br,"Fail","Verify if able to change the role from standared to Co-Administrator","The role is not changes sucessfull to " + driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[3]/div[2]/form/div[3]/div[1]/span")).getText(),"The role should be changes sucessfully");                                                     
                                   }
                                }
                                                                                                                                                                                                                                                                    
                    }
                    
                    int lndrp=driver.findElements(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/div[2]/div[2]/div/div/span[1]/select/option")).size();
                                int ln=driver.findElements(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/section[1]/div[2]/div")).size();
                                int gmlndrp=driver.findElements(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/div[3]/div[2]/div/div/span[1]/select/option")).size();
                                int gmln=driver.findElements(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/section[2]/div[2]/div")).size();
                    logger.info("lndrp"+lndrp);
                    logger.info("ln"+ln);
                    logger.info("gmlndrp"+gmlndrp);
                    logger.info("gmln"+gmln);
                    
                    if(lndrp>1)
                    {
                                String line="";
                                String tn3=driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/div[2]/div[2]/div/div/span[1]/select/option[1]")).getText();
                                    focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/div[2]/div[2]/div/div/button")),br);
                                    focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/div[4]/div[3]/button")),br);

                                do{
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                for(int k3=1;k3<lndrp;k3++)
                                 {
                                
                                                 if(driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/div[2]/div[2]/div/div/span[1]/select/option["+(k3)+"]")).getText().equals(tn3))
                                                {
                                                                 line="Fail";
                                                }
                                                else
                                                {
                                                                 line="Pass";
                                                }
                                 }
                                if(line.equals("Pass"))
                                {
                                                statusTracker(br,"Pass","Verify if able to add the TN from the list","The line is added sucessfully"+tn3,"The TN should be added sucessfully");
                                }
                                else
                                {
                                                statusTracker(br,"Fail","Verify if able to add the TN from the list","The line is not added sucessfully"+tn3,"The TN should be added sucessfully");
                                }
                    }
                    if(gmlndrp>1)
                    {
                                String Gline="";
                                String tn4=driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/div[3]/div[2]/div/div/span[1]/select/option")).getText();
                                    focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/div[3]/div[2]/div/div/button")),br);
                                    focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/div[4]/div[3]/button")),br);

                                do{
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                for(int k4=1;k4<gmlndrp;k4++)
                                 {
                                                 if(driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/div[2]/div[2]/div/div/span[1]/select/option["+(k4)+"]")).getText().equals(tn4))
                                                {
                                                                Gline="Fail";
                                                }
                                                else
                                                {
                                                                 Gline="Pass";
                                                }                                                                                                              
                                 }
                                if(Gline.equals("Pass"))
                                {
                                statusTracker(br,"Fail","Verify if able to add the GMB Sec TN from the list","The GMB Sec line is not added sucessfully"+tn4,"The GMB Sec TN should be added sucessfully");
                                   }
                                   else
                                   {
                                               statusTracker(br,"Pass","Verify if able to add the GMB Sec TN from the list","The GMB Sec line is not added sucessfully"+tn4,"The GMB Sec TN should be added sucessfully");
                                   }
                                
                    }
                                                                                    
                    if(ln>1)
                    {
                                String DelLine="";
                                String tn1=driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/section[1]/div[2]/div/div[1]")).getText();
                                focusClick(driver,driver.findElement(By.xpath("//div/div[3]/i")),br);
                                    focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/div[4]/div[3]/button")),br);

                                do{
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                 for(int k1=1;k1<=lndrp;k1++)
                                 {
                                                 if(driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/div[2]/div[2]/div/div/span[1]/select/option["+(k1)+"]")).getText().equals(tn1))
                                                {
                                                                DelLine="Pass";
                                                }
                                                else
                                                {
                                                                DelLine="Fail";
                                                }                                                                                                                                              
                                 }
                     if(DelLine.equals("Pass"))
                  { 
                                 statusTracker(br,"Pass","Verify if able to remove the TN from the list","The line is removed sucessfully"+tn1,"The TN should be removed sucessfully");
                                 }
                                else
                                 {
                                               statusTracker(br,"Fail","Verify if able to remove the TN from the list","The line is not removed sucessfully"+tn1,"The TN should be removed sucessfully");
                                 }                                                                            
                    }
                    
                    else if(gmln>1)
                    {
                                String DelGline="";
                                String tn2=driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/section[2]/div[2]/div/div[1]")).getText();
                                focusClick(driver,driver.findElement(By.xpath("//section[2]/div[2]/div/div[3]/i")),br);
                                    focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/div[4]/div[3]/button")),br);

                                do{
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                for(int k2=1;k2<=gmlndrp;k2++)
                                 {
                                                 if(driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div[5]/div/form/div[2]/div[2]/div/div/span[1]/select/option["+(k2)+"]")).getText().equals(tn2))
                                                {
                                                                DelGline="Pass";
                                                }
                                                else
                                                {
                                                                DelGline="Fail";
                                                }                                                                                                                              
                                 }
                     if(DelGline.equals("Pass"))
                      {
                        statusTracker(br,"Pass","Verify if able to remove the GMB sec TN from the list","The GMB sec line is removed sucessfully"+tn2,"The GMB sec TN should be removed sucessfully");
                                 }
                                else
                                 {
                                               statusTracker(br,"Fail","Verify if able to remove the GMB sec TN from the list","The GMB sec line is not removed sucessfully"+tn2,"The GMB sec TN should be removed sucessfully");
                                 }
                    }                                                                                                            
                                                                                                
                                return pwd;                        
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
                          fname= sheet2.getCell(10, 27).getContents();
                                      lname= sheet2.getCell(12, 27).getContents();
                                      email= sheet2.getCell(14, 27).getContents();
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

                              focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[3]/a")),br);
                                      
                                      int usrcnt=driver.findElements(By.xpath("//html/body/section/div[4]/section/div")).size();
                                      logger.info("Count"+usrcnt);
                                      int j = 0,test=0;
                                      for(int i=1;i<usrcnt;i++)
                                      {
                                                  if((driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[4]")).getText()).equals("ACTIVE") || (driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[4]")).getText()).equals("DISABLED"))
                                                  {                                              
                                                                  if((driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[3]")).getText()).equals("Standard") || (driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[3]")).getText()).equals("Co-Administrator"))
                                                                  {
                                                                                  name1=driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[1]")).getText();
                                                                                  email1=driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[2]")).getText();
                                                                                  ustatus1=driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[3]")).getText();
                                                                                  j=i+1;
                                                                                  test=1;
                                                                                  break;
                                                                  }
                                                                                                                  
                                                  }
                                                  else if((driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[4]")).getText()).contains("PENDING"))
                                                  {                                              
                                                                  if((driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[3]")).getText()).equals("Standard") || (driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[3]")).getText()).equals("Co-Administrator"))
                                                                  {
                                                                                  name1=driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[1]")).getText();
                                                                                  email1=driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[2]")).getText();
                                                                                  ustatus1=driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+(i+1)+"]/div/div[3]")).getText();
                                                                                  j=i+1;
                                                                                  test=0;
                                                                                  break;
                                                                  }
                                                                                                                  
                                                  }
                                      }
                                      logger.info("j"+j);
                                      if(j>0){
                                      focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/section/div["+j+"]/div/div[1]/a")),br);
                                      
                                      Thread.sleep(3000);
                                      EditUser(driver,fname,lname,email,test,br);
                                                      
                                      Errval(driver,test,br);
                                      }
                                      else
                                    	  statusTracker(br,"Only Admin present","","","");
                                      
                                      driver.navigate().refresh();
                              Thread.sleep(2000);
                  first=1; 
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
