package DevVersionFeaturesFile.IncomingCalls.UserMode;

import com.thoughtworks.selenium.Selenium;

import DevVersionFeaturesFile.CommonFunctions;

import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class UserCallForwardUnconditional extends CommonFunctions {
                
                String table, tns[];
    String tlimit,username,pwd;
    int tncount;                    
                
    String xpath_CFUexecute_xpath1;
                String Acccode,phoneline_ac,phoneline;
                String butnxpath="//html/body/section/div[5]/div[2]/div[4]/div[1]/div[2]/form/div/div[1]/div/div/div/label";
    String svexpath="div.col-16 > div.accordian-actions > button.btn.btn-primary";
    String TNxpath="//html/body/section/div[5]/div[2]/form/div[5]/div/label";
                int rank[]= new int[50];
                

                int c_sequence;
                String name_for_rank[]= new String[40];
                String price, rank_channels;

                public UserCallForwardUnconditional(String path) {
                                this.path = path;
                }

                public UserCallForwardUnconditional(String path, String file1, String file2) {
                                this.path = path;
                                this.path1 = file1;
                                this.path2 = file2;
                }
                                
                
                public String turnoff(WebDriver driver, String br, String status, String acc)
                  {
                                  String initialstate=status, chngetostate="Off",state="Fail", accst=acc;

                                  focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
                                  
                                  for(int i=1;i<100;i++){}

                      focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
                      int chk=0;
                      do{
                          chk++;
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                        {
                         logger.info("Success");
                          statusTracker(br,"Pass","Verify the order process for changing the status from: "+initialstate +" to: "+chngetostate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
                        }
                         else
                        {
                         logger.info("Fail");
                          statusTracker(br,"Fail","Verify the order process for changing the status from: "+initialstate +" to: "+chngetostate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div/div")).getText(),"Unable to process successfully");
                        }
                      for(int i=1;i<100;i++){}

                      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
                      String num=randomNO(3333,6666);
                      driver.findElement(By.name("callForwardPhone")).clear();
                      driver.findElement(By.name("callForwardPhone")).sendKeys(phoneline+num);
                      for(int i1=1;i1<100;i1++){}

                      focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
                      
                      do{
                          chk++;
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                        {
                                  logger.info("Success");
                          state="Pass";
                          statusTracker(br,"Pass","Verify the order process for changing the status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
                        }
                         else
                        {
                          logger.info("Fail");
                          statusTracker(br,"Fail","Verify the order process for changing the status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div/div")).getText(),"Unable to process successfully");
                        }
                      return state;
                  }
                  
                  public String turnOn(WebDriver driver, String br, String status, String acc)
                  {
                      String initialstate=status, chngetostate="On",state = "Fail", accst=acc;
                                  
                                  focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
                                  String num=randomNO(3333,6666);
                                  driver.findElement(By.name("callForwardPhone")).clear();
                                  driver.findElement(By.name("callForwardPhone")).sendKeys(phoneline+num);
                                  for(int i=1;i<100;i++){}

                      focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
                      int chk=0;
                      do{
                          chk++;
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                        {
                                logger.info("Success");
                          statusTracker(br,"Pass","Verify the order process for changing the status from: "+ initialstate +" to: "+chngetostate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
                        }
                        else
                        {
                                logger.info("Fail");
                          statusTracker(br,"Fail","Verify the order process for changing the status from: "+ initialstate +" to: "+chngetostate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div/div")).getText(),"Unable to process successfully");
                        }
                        
                      for(int i1=1;i1<100;i1++){}
                      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
                      
                      focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
                      
                      do{             
                          chk++;
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

                      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                        {
                                  logger.info("Success");
                          statusTracker(br,"Pass","Verify the order process for changing the status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
                          state="Pass";
                        }
                         else
                        {
                                 logger.info("Fail");
                          statusTracker(br,"Fail","Verify the order process for changing the status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Unable to process order" + driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div/div")).getText(),"Unable to process successfully");
                        }
                                return state;
                                  
                  }
                  
                  public void EditTn(WebDriver driver, String br)
                  {
                                  String num=randomNO(3333,6666);
                                  driver.findElement(By.name("callForwardPhone")).clear();
                                  driver.findElement(By.name("callForwardPhone")).sendKeys(phoneline+num);
                                  for(int i=1;i<10;i++){}

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
                          statusTracker(br,"Fail","Verify order process for editing TN","Unable to process order","Unable to process successfully");
                        }
                  }
                  
                  public String TNcheck(String ac, String acode,WebDriver driver, int check,String br) throws Exception
                  {
                         String schk="Fail";
                         int check1=check;
                         driver.findElement(By.name("callForwardPhone")).clear();
                         driver.findElement(By.name("callForwardPhone")).sendKeys(ac);       
                          
                         if(check1==2)
                         {                      
                                 driver.findElement(By.name("callForwardToAccount")).clear();
                                 driver.findElement(By.name("callForwardToAccount")).sendKeys(acode);
                         }
                         if(check1==3)
                         {
                                 ac=2+Acccode;
                                 logger.info("ac"+ac);
                                 driver.findElement(By.name("callForwardToAccount")).clear();
                                 driver.findElement(By.name("callForwardToAccount")).sendKeys(ac);
                         }

                         focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
                                 
                         Thread.sleep(6000);
                     
                         if(driver.findElement(By.xpath(".//*[@id='collapseFeature1']/div[2]/div[1]/div/div/div")).isDisplayed())
                                     {
                                                  statusTracker(br,"Pass","Verify if error message is displayed when adding "+ac+" TN/Acc code","Error message is displayed: "+ driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div/div")).getText(),"Error message should be displayed");
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
                  public String TNValidation(WebDriver driver, String br, int a) throws Exception
                  {
                                     statusTracker(br,"","","Error Validation","");
                         String schk ="Pass";
                         schk=TNcheck("0223004000","",driver,1,br);
                         schk=TNcheck("1223004000","",driver,1,br);
                         schk=TNcheck("9000004000","",driver,1,br);
                         schk=TNcheck("9760004000","",driver,1,br);
                         schk=TNcheck("9999","",driver,1,br);
                         schk=TNcheck(phoneline_ac,"",driver,1,br);
                         
                         if(a==1 || a==2)
                         {
                         schk=TNcheck("9193220101","",driver,2,br); 
                         schk=TNcheck("9193220101","2",driver,2,br);
                         schk=TNcheck("919322","2",driver,2,br);
                         
                         if(a==1)
                                 schk=TNcheck("9193220101","",driver,3,br);
                         
                         schk="Pass";
                         }
                         return schk;
                  }
                  
                    
                  public void execute(String br, WebDriver driver, String url, int loc, String name1) throws Exception {
                
                                  Feature_Name="CFU";                                 
                                  xpath_CFUexecute_xpath1 = ACR.getProperty("xpath_CFUexecute_xpath1");
                                  //arrcount=0;
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
                          //int tlim = Integer.parseInt(tlimit);
                      
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
                                  logger.info("a1");
                                  switchTo(driver,"Admin",tlim,br); 
                                  focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]/a")),br);
                            
                              logger.info("checkpoint1");
                  for(int i=1;i<20;i++){}
                  Acccode=driver.findElement(org.openqa.selenium.By.xpath("//html/body/section/section/div[1]/aside[1]/ul/li[1]/strong")).getText();
                  logger.info("Acccode"+Acccode);
                  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[3]")),br);

                  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);  
                 
                 if(!(InternalException(driver,br)))
                 {

                 int count1=driver.findElements(By.xpath("//html/body/section/div")).size();
                 String featureName="Call Forward";
                              int featureOrder=FeatureListIncoming(driver,count1,featureName);
                              System.out.println("Feature Order " + featureOrder);  
                              focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature1 > div.accordian-header > div.header-right")),br);                 
                Thread.sleep(2000);
                 phoneline_ac= Select_TN(driver,featureName,featureOrder,br);
                              System.out.println(phoneline_ac);
                              logger.info("c");

                              if(phoneline_ac!=null)
                              {
                  switchTo(driver, "User",tlim,br);
                  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[3]")),br);

                  //new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(phoneline_ac);
                  focusDropdown(driver,"//html/body/header/div[4]/div[3]/div/div/span",phoneline_ac,br);
                              do{
                                  
                                 
                              }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                
               
                  phoneline=phoneline_ac.substring(0,8);
                  focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature1 > div.accordian-header > div.header-right")),br);
                  
                  boolean status= driver.findElement(By.id("toggleButton2")).isSelected();
                  
                  int cnt=driver.findElements(org.openqa.selenium.By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[2]/form/div/div")).size();
                  logger.info("cnt is"+cnt);
                  
                  if(cnt==6)
                  {
                                  int a1=1;
                                  boolean acntcd= driver.findElement(By.id("first")).isSelected();
                                  logger.info("acntcd is"+acntcd);
                                  if(acntcd==true)
                      {
                                                  logger.info("check is");
                                                  statusTracker(br,"","The Account code is"+Acccode,"","");    
                                                  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[2]/form/div/div[4]/label")),br);           
                                                  driver.findElement(By.name("callForwardToAccount")).sendKeys(Acccode);
                      }
                                  else
                                  {
                                                  driver.findElement(By.name("callForwardToAccount")).clear();
                                                  driver.findElement(By.name("callForwardToAccount")).sendKeys(Acccode);
                                  }
                                  logger.info("check is");
                                  String acc="Verified Account code";
                                  if(status==true)
                      {
                                  status1="On";
                                  state=turnoff(driver, br,status1, acc);
                      }
                      else
                      {
                                  status1="Off";
                                  state=turnOn(driver, br,status1, acc);
                      }
                                  logger.info("orderprocess is done");                       
                                  EditTn(driver,br);
                                  
                      TNValidation(driver,br,a1);                     
                  }
                  else if(cnt==5)
                  {
                                  int a2=2;
                                  driver.findElement(By.name("callForwardToAccount")).clear();
                                  driver.findElement(By.name("callForwardToAccount")).sendKeys("8956325485");
                                  String acc="Non-Verified Account code";
                                  if(status==true)
                      {
                                  status1="On";
                                  state=turnoff(driver, br,status1, acc);
                      }
                      else
                      {
                                  status1="Off";
                                  state=turnOn(driver, br,status1, acc);
                      }                     
                      logger.info("orderprocess is done");

                                  EditTn(driver,br);
                                  
                      TNValidation(driver,br,a2);                      
                  }
                  else
                  {
                                int a3=3;
                                String acc="No Account code";
                    if(status==true)
                    {
                                  status1="On";
                                  state=turnoff(driver, br,status1, acc);
                    }
                    else
                    {
                                  status1="Off";
                                  state=turnOn(driver, br,status1, acc);
                    }
                    logger.info("orderprocess is done");
                                  EditTn(driver,br);
                                  
                                  TNValidation(driver,br,a3);                         
                  } 
                                                  
                  String canbut="//html/body/div[2]/div/div[2]/span";
                  String Savbut="//html/body/div[2]/div/div[2]/a/span";                               
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
                     
                    }
                  }
                  
                  private boolean assertTrue(Object elementPresent) {
                                // TODO Auto-generated method stub
                                return false;
                }

                private Object isElementPresent(By id) {
                                // TODO Auto-generated method stub
                                return null;
                }

                private boolean isElementPresent(WebDriver driver, By xpath) {
                                // TODO Auto-generated method stub
                                return false;
                }
                }
