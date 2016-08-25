package DevVersionFeaturesFile.MobilityPackage.UserMode;

import com.thoughtworks.selenium.Selenium;

import DevVersionFeaturesFile.CommonFunctions;

import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class UserSelectiveCallRejection extends CommonFunctions {
                
                String table, tns[];
    String tlimit,username,pwd;
    int tncount;                                                    
              
    String butnxpath,Err,AddNum;
    String svexpath="form[name=\"selectiveCallReject\"] > div.accordian-actions > button.btn.btn-primary";
    String TNxpath="//html/body/section/div[13]/div[2]/form/div[5]/div/label";
    String phoneline,phoneline_ac,Acccode,frntn;
                int rank[]= new int[50];
                

                
                int c_sequence;
                String name_for_rank[]= new String[40];
                String price, rank_channels;

                public UserSelectiveCallRejection(String path) {
                                this.path = path;
                }

                public UserSelectiveCallRejection(String path, String file1, String file2) {
                                this.path = path;
                                this.path1 = file1;
                                this.path2 = file2;
                }
                                
                
                public String turnoff(WebDriver driver, String status,String br)
                  {
                                  String initialstate=status, chngetostate="Off",state="Fail";
                                  
                                  focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
                                  
                                  for(int i=1;i<50;i++){}
                      
                                  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);

                      int chk=0;
                      do{
                          chk++;
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                        {
                          logger.info("Success");
                          statusTracker(br,"Pass","Verify order process for changing status from: "+initialstate +" to: "+chngetostate,"Successfully be able to process order","Successfully processed order");
                        }
                         else
                        {
                          logger.info("Fail");
                          statusTracker(br,"Fail","Verify order process for changing status from: "+initialstate +" to: "+chngetostate,"The order failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
                        }
                      for(int i=1;i<50;i++){}
                      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);

                      String num=randomNO(1111,5555);
                      driver.findElement(By.id("newNumber1")).clear();
                      driver.findElement(By.id("newNumber1")).sendKeys(phoneline+num);
                      
                      focusClick(driver,driver.findElement(By.xpath(AddNum)),br);

                      do{
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                      focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
                      
                      do{
                          chk++;
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                        {
                          logger.info("Success");
                          state="Pass";
                          statusTracker(br,"Pass","Verify order process for changing status from: "+chngetostate +" to: "+initialstate,"Successfully be able to process order","Successfully processed order");
                        }
                         else
                        {
                          logger.info("Fail");
                          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate,"The order failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
                        }
                      return state;
                  }
                  
                  public String turnOn(WebDriver driver, String status,String br)
                  {
                      String initialstate=status, chngetostate="On",state = "Fail";
                      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);

                                  String num=randomNO(1111,5555);
                      driver.findElement(By.id("newNumber1")).clear();
                      driver.findElement(By.id("newNumber1")).sendKeys(phoneline+num);
                      
                      focusClick(driver,driver.findElement(By.xpath(AddNum)),br);

                                    do{

                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                    focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
                      
                      int chk=0;
                      do{

                          chk++;
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                        {
                          logger.info("Success");
                          statusTracker(br,"Pass","Verify order process for changing status from: "+ initialstate +" to: "+chngetostate,"Successfully be able to process order","Successfully processed order");
                        }
                        else
                        {
                          logger.info("Fail");
                          statusTracker(br,"Fail","Verify order process for changing status from: "+ initialstate +" to: "+chngetostate,"The order failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
                        }
                        
                      for(int i1=1;i1<50;i1++){}
                      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);

                      focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
                      
                      do{
                          chk++;
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                        {
                          logger.info("Success");
                          statusTracker(br,"Pass","Verify order process for changing status from: "+chngetostate +" to: "+initialstate,"Successfully be able to process order","Successfully processed order");
                          state="Pass";
                        }
                         else
                        {
                          logger.info("Fail");
                          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate,"The order failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
                        }
                                return state;
                                  
                  }
                  
                  public void EditTn(WebDriver driver,String br)
                  {
                                  int cnt;
                                  if(driver.findElement(By.xpath("//html/body/section/div[6]/div[1]/h3")).getText().equals("Custom Ring"))
          {
                                                  cnt=driver.findElements(By.xpath("//html/body/section/div[9]/div[2]/form/section/label")).size();
          }
          else
          {
                  cnt=driver.findElements(By.xpath("//html/body/section/div[8]/div[2]/form/section/label")).size();
          }
                                  
                                  if(cnt<30){
                                  for(int i=1;i<5;i++){
                                                  String num=randomNO(1111,5555);
                                      driver.findElement(By.id("newNumber1")).clear();
                                      driver.findElement(By.id("newNumber1")).sendKeys(phoneline+num);
                                      focusClick(driver,driver.findElement(By.xpath(AddNum)),br);
                                                  
                                                  do{
                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                     }
                                  }
                                  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);

                      int chk=0;
                      do{
                          chk++;
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                        {
                          logger.info("Success");
                          statusTracker(br,"Pass","Verify order process for editing TN","Successfully be able to process order","Successfully processed order");
                        }
                        else
                        {
                          logger.info("Fail");
                          statusTracker(br,"Fail","Verify order process for editing TN","The order failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
                        }
                  }
                  
                  public void DeltTn(WebDriver driver,String br)
                  {
                                  int cnt;
                                  if(driver.findElement(By.xpath("//html/body/section/div[6]/div[1]/h3")).getText().equals("Custom Ring"))
          {
                                                  cnt=driver.findElements(By.xpath("//html/body/section/div[9]/div[2]/form/section/label")).size();
          }
          else
          {
                  cnt=driver.findElements(By.xpath("//html/body/section/div[8]/div[2]/form/section/label")).size();
          }
                                  
                                  boolean status= driver.findElement(By.id("toggleButton25")).isSelected();
                                  logger.info("status"+status);
                                  if(status==true)
                      {
                                                  focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
                      }
                                  
                                  if(cnt>=2)
                                  {
                                                  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/form/section/label/i")),br);

                                                  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);

                                                  int chk=0;
                                                  do{
                                          chk++;
                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                                        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                                        {
                                          logger.info("Success");
                                          statusTracker(br,"Pass","Verify order process for Deleting the TN","Successfully be able to process order","Successfully processed order");
                                        }
                                        else
                                        {
                                          logger.info("Fail");
                                          statusTracker(br,"Fail","Verify order process for Deleting the TN","The order failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
                                        }
                                   }
                                    else
                                     {
                                                for(int i=1;i<5;i++){
                                                                String num=randomNO(1111,5555);
                                                      driver.findElement(By.id("newNumber1")).clear();
                                                      driver.findElement(By.id("newNumber1")).sendKeys(phoneline+num);
                                                      focusClick(driver,driver.findElement(By.xpath(AddNum)),br);
                                                                  
                                                                  do{
                                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                                  }
                                                focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
                                      
                                      do{
                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                      focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/form/section/label/i")),br);

                                      focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);

                                                  int chk=0;
                                                  do{
                                          chk++;
                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                                        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                                        {
                                          logger.info("Success");
                                          statusTracker(br,"Pass","Verify order process for Deleting the TN","Successfully be able to process order","Successfully processed order");
                                        }
                                        else
                                        {
                                          logger.info("Fail");
                                          statusTracker(br,"Fail","Verify order process for Deleting the TN","The order failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
                                        }            
                                  }
                  }
                  
                  public void DeltTnAll(WebDriver driver,String br) throws Exception
                  {
                                  int chk=0;
                                  focusClick(driver,driver.findElement(By.cssSelector("form[name=\"selectiveCallReject\"] > div.accordian-actions > button.btn.btn-secondary")),br);
                                  do{
                                                  chk++;
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                  focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature5 > div.accordian-header > div.header-right")),br);
                                  
                      boolean status= driver.findElement(By.id("toggleButton25")).isSelected();
                                  
                                  if(status==true)
                      {
                                                  focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
                      }
                                  
                                  int cnt;
                                  if(driver.findElement(By.xpath("//html/body/section/div[6]/div[1]/h3")).getText().equals("Custom Ring"))
          {
                                                  cnt=driver.findElements(By.xpath("//html/body/section/div[9]/div[2]/form/section/label")).size();
          }
          else
          {
                  cnt=driver.findElements(By.xpath("//html/body/section/div[8]/div[2]/form/section/label")).size();
          }
                                  
                                  if(cnt>2){
                                   if(driver.findElements(By.xpath("(//a[contains(text(),'Delete All')])[2]")).size()>0)
                                   {
                                                  logger.info("looop");
                                                  focusClick(driver,driver.findElement(By.xpath("(//a[contains(text(),'Delete All')])[2]")),br);
                                   }
                       else
                       {
                                  logger.info("looop111");
                                  focusClick(driver,driver.findElement(By.xpath("(//a[contains(text(),'Delete All')])[1]")),br);
                       }
                                  }
                                  else
                                  {
                                                  for(int i=1;i<5;i++){
                                                                String num=randomNO(1111,5555);
                                                      driver.findElement(By.id("newNumber1")).clear();
                                                      driver.findElement(By.id("newNumber1")).sendKeys(phoneline+num);
                                                      focusClick(driver,driver.findElement(By.xpath(AddNum)),br);
                                                                  
                                                                  do{
                                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                                  }
                                                  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
                                                  
                                                  do{
                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                                  
                                                  if(driver.findElements(By.xpath("(//a[contains(text(),'Delete All')])[2]")).size()>0)
                                                   {
                                                                  logger.info("looop");
                                                                  focusClick(driver,driver.findElement(By.xpath("(//a[contains(text(),'Delete All')])[2]")),br);
                                                   }
                                       else
                                       {
                                                  logger.info("looop111");
                                                  focusClick(driver,driver.findElement(By.xpath("(//a[contains(text(),'Delete All')])[1]")),br);
                                       }
                                  }
                                  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
                                                  
                                  do{
                          chk++;
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                        {
                          logger.info("Success");
                          statusTracker(br,"Pass","Verify order process for DeletAll","Successfully be able to process order","Successfully processed order");
                        }
                        else
                        {
                          logger.info("Fail");
                          statusTracker(br,"Fail","Verify order process for DeletAll","The order failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
                        }
                                  
                  }
                  
                  public void maxTN(WebDriver driver,String br) throws Exception
                  {
                                  int cnt;
                                  if(driver.findElement(By.xpath("//html/body/section/div[6]/div[1]/h3")).getText().equals("Custom Ring"))
          {
                                                  cnt=driver.findElements(By.xpath("//html/body/section/div[9]/div[2]/form/section/label")).size();
          }
          else
          {
                  cnt=driver.findElements(By.xpath("//html/body/section/div[8]/div[2]/form/section/label")).size();
          }
                                  
                                  for(int i=cnt;i<30;i++){
                                                  String num=randomNO(1111,5555);
                                                  driver.findElement(By.id("newNumber1")).clear();
                                                  driver.findElement(By.id("newNumber1")).sendKeys(phoneline+num);
                                                focusClick(driver,driver.findElement(By.xpath(AddNum)),br);
                                                  
                                                  do{
                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                  }
                                  
                                  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
                                  do{
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                  
                                  int cnt1=driver.findElements(By.xpath("//html/body/section/div[9]/div[2]/form/section/label")).size();
                                  
                                  if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                      {
                        logger.info("Success");
                       statusTracker(br,"Pass","Verify order process for adding 30 TN's and count is: "+cnt1,"Successfully be able to process order","Successfully processed order");
                      }
                      else
                      {
                        logger.info("Fail");
                        statusTracker(br,"Fail","Verify order process for adding 30 TN's and count is: "+cnt1,"The order failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
                      }
                                  
                                   String num1=randomNO(1111,5555);
                                                  driver.findElement(By.id("newNumber1")).clear();
                                                  driver.findElement(By.id("newNumber1")).sendKeys(phoneline+num1);
                                      focusClick(driver,driver.findElement(By.xpath(AddNum)),br);
                                                  Thread.sleep(2000);
                                                  if(driver.findElement(By.xpath(Err)).isDisplayed())
                                                     {
                                                                  statusTracker(br,"Pass","Verify if error message is displayed when adding more than 30 TN","Error message is displayed: "+ driver.findElement(By.xpath(Err)).getText(),"Error message should be displayed");
                                                                  //schk="Pass";
                                                     }
                                                                 else
                                                                 {
                                                                                 statusTracker(br,"Fail","Verify if error message is displayed when adding more than 30 TN","Error message is not displayed","Error message should be displayed");
                                                                                 //schk="Fail";
                                                                }
                  }
                  
                  public String TNcheck2(String Tn, WebDriver driver,String br) throws Exception
                  {
                         String schk="Fail";
                         driver.findElement(By.name("newNumber1")).clear();
                         driver.findElement(By.name("newNumber1")).sendKeys(Tn);       
                        
                         focusClick(driver,driver.findElement(By.xpath(AddNum)),br);
                                 
                         Thread.sleep(2000);
                     
                         if(driver.findElement(By.xpath(Err)).isDisplayed())
                                     {
                                                  statusTracker(br,"Pass","Verify if error message is displayed when adding "+Tn+" TN/Acc code","Error message is displayed: "+ driver.findElement(By.xpath(Err)).getText(),"Error message should be displayed");
                                                  schk="Pass";
                                     }
                                                 else
                                                 {
                                                                 statusTracker(br,"Fail","Verify if error message is displayed when adding "+Tn+" TN","Error message is not displayed","Error message should be displayed");
                                                                 schk="Fail";
                                                 }
                         return schk;
                  }  
                    
                  //TN Validation
                  public String TNValidation(WebDriver driver,String br) throws Exception
                  {
                                     statusTracker(br,"","","Error Validation","");
                         String schk ="Pass";        
                         schk=TNcheck2("0223004000",driver,br);
                         schk=TNcheck2("1223004000",driver,br);
                         schk=TNcheck2("9000004000",driver,br);
                         schk=TNcheck2("9760004000",driver,br);
                         schk=TNcheck2("9999",driver,br);                            
                         schk=TNcheck2(phoneline_ac,driver,br);
                         if(driver.findElement(By.xpath("//html/body/section/div[6]/div[1]/h3")).getText().equals("Custom Ring"))
             {
                                 frntn=driver.findElement(By.xpath("/html/body/section/div[9]/div[2]/form/section/label[1]")).getText();
             }
                         else
                         {
                                 frntn=driver.findElement(By.xpath("/html/body/section/div[8]/div[2]/form/section/label[1]")).getText();
                         }
                         schk=TNcheck2(frntn,driver,br);
                         
                         return schk;
                  }
                                    
                  public void execute(String br, WebDriver driver, String url, int loc, String name1) throws Exception {      
                                  Feature_Name="SCR";
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
                              focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]")),br);
                  logger.info("checkpoint1");
                  for(int i=1;i<20;i++){}
                  Acccode=driver.findElement(org.openqa.selenium.By.xpath("//html/body/section/section/div[1]/aside[1]/ul/li[1]/strong")).getText();
                  logger.info("Acccode"+Acccode);
                  
                  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[3]")),br);

                 if(!(InternalException(driver,br)))
                 {

                 int count1=driver.findElements(By.xpath("//html/body/section/div")).size();
                              String featureName="Selective Call Rejection";
                              int featureOrder=FeatureListIncoming(driver,count1,featureName);

                              System.out.println("Feature Order " + featureOrder);  
                              focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature"+featureOrder+" > div.accordian-header > div.header-right")),br);
                               Thread.sleep(3000);
                              
                               phoneline_ac= Select_TN(driver,featureName,featureOrder,br);
                               
                              System.out.println(phoneline_ac);
                              logger.info("c");

                              if(phoneline_ac!=null)
                              {
                              focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[1]/a")),br);
                                   
                  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[3]")),br);
                  focusDropdown(driver,"//html/body/header/div[4]/div[3]/div/div/span",phoneline_ac,br);
                  //new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(phoneline_ac);
                  do{
                                  //logger.info("Processing!" +chk);
                                 
                  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                  focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature5 > div.accordian-header > div.header-right > span.accordian-info.ng-binding")),br);
                  phoneline=phoneline_ac.substring(0,8);
                  logger.info("phoneline"+phoneline);
                  
                
                  if(driver.findElement(By.xpath("//html/body/section/div[6]/div[1]/h3")).getText().equals("Custom Ring"))
                  {
                                  butnxpath="//html/body/section/div[9]/div[2]/div[1]/label";
                                  Err="//html/body/section/div[9]/div[2]/div[2]/div/div";
                                  AddNum="//html/body/section/div[9]/div[2]/form/div[1]/div[2]/div/button";
                                  
                  }
                  else
                  {
                                  butnxpath="//html/body/section/div[8]/div[2]/div[1]/label";
                                  Err="//html/body/section/div[8]/div[2]/div[2]/div/div";
                                  AddNum="//html/body/section/div[8]/div[2]/form/div[1]/div[2]/div/button";
                  }

                  boolean status= driver.findElement(By.id("toggleButton25")).isSelected();
                                    
                  if(status==true)
                  {
                  status1="On";
                  state=turnoff(driver, status1,br);
                  }
                  else
                  {
                  status1="Off";
                  state=turnOn(driver, status1,br);
                  }
                  logger.info("orderprocess is done");      
                  
                  EditTn(driver,br);                             
                  maxTN(driver,br);
                  DeltTn(driver,br);
                  TNValidation(driver,br);                                      
                  DeltTnAll(driver,br);
                  
                  String canbut="//html/body/div[2]/div/div[2]/span";
                  String Savbut="//html/body/div[2]/div/div[2]/a/span"; 
                  focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
                  unsave(driver,br,canbut,Savbut);
                  
                              Thread.sleep(2000);
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
                      //driver.close();
                     
                    }
                  }
                  
                  private boolean isElementPresent(WebDriver driver, By xpath) {
                                // TODO Auto-generated method stub
                                return false;
                }
                }

