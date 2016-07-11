package ApolloNew;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class UserDND extends CommonFunctions {

                
                String table,TN, tns[];
    String tlimit,username,pwd;
    int tncount;
    String initialstate,chngetostate;
                public UserDND(String path) {
                                this.path = path;
                }

//                public UserDND(String path, String file1, String file2) {
//                                this.path = path;
//                                this.path1 = file1;
//                                this.path2 = file2;
//                }

                public String turnon(String br,WebDriver driver, String status) throws InterruptedException
                  {
                                  initialstate=status;chngetostate="On";
                                  System.out.println(initialstate);
                                  System.out.println(chngetostate);
                                  String state="fail";
                                  int chk=0;
                                  
                                  focusClick(driver,  driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[1]/label")),br);
                                                   
                                  focusClick(driver, driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[4]/form/div/button[2]")),br);
                                   logger.info("TurnOFF"); 
                                   
                                  if(driver.findElements(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[4]/div/div")).size()>0)
                                  {
                                                  focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[4]/div/div/div[2]/span[2]")),br);
                                                   logger.info("TurnON1"); 
                                                   
                                                   do{
                                                       
                                                          chk++;
                                                        }while(focusSearch(driver,driver.findElement(By.xpath("//html/body/div[3]/div/div[1]")),br));

                                      if(driver.findElements(By.id("dataSaveSucess")).size()>0)
                                        {
                                           logger.info("Success");
                                          statusTracker(br,"Pass","Verify order process for changing status from:"+initialstate+ "to:"+chngetostate,"Successfully be able to process order","Successfully processed order");
                                        }
                                         else
                                        {
                                           logger.info("Fail");
                                          statusTracker(br,"Fail","Verify order process for changing status from:"+initialstate+ "to:"+chngetostate,"Successfully be able to process order","Unable to process successfully");
                                        }
                                  }
                                  
                                  
                                  focusClick(driver, driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[1]/label")),br);
                      
                                  focusClick(driver,  driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[4]/form/div/button[2]")),br);

                                do{
                                // logger.info("Processing!" +chk);
                                chk++;
                                }while(focusSearch(driver,driver.findElement(By.xpath("//html/body/div[3]/div/div[1]")),br));
                                      for(int i1=1;i1<100;i1++){}
                                     String initialstate1="On",chngetostate1="Off";
                                                  System.out.println("later"+initialstate);
                                                  System.out.println("later"+chngetostate);

                                      if(driver.findElements(By.id("dataSaveSucess")).size()>0)
                                        {
                                           logger.info("Success");
                                          state="Pass";
                                          statusTracker(br,"Pass","Verify order process for changing status from:"+initialstate1+ "to:"+chngetostate1,"Successfully be able to process order","Successfully processed order");
                                        }
                                         else
                                        {
                                           logger.info("Fail");
                                          statusTracker(br,"Fail","Verify order process for changing status from:"+chngetostate+ "to:"+initialstate,"Successfully be able to process order","Unable to process successfully");
                                        }
                                   
                                  
                      return state;
                }
                    
                public String turnoff(String br,WebDriver driver, String status) throws InterruptedException     
                {
                                initialstate="On";chngetostate="Off";
                                String state="fail";
                                int chk=0;
                    logger.info("TurnOFF");
                    focusClick(driver,   driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[1]/label")),br);
        
                    focusClick(driver, driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[4]/form/div/button[2]")),br);

                    do{
                    	// logger.info("Processing!" +chk);
                    	chk++;
                    }while(focusSearch(driver,driver.findElement(By.xpath("//html/body/div[3]/div/div[1]")),br));
        for(int i1=1;i1<100;i1++){}
        
        if(driver.findElements(By.id("dataSaveSucess")).size()>0)
          {
             logger.info("Success");
             state="Pass";
            statusTracker(br,"Pass","Verify order process for changing status from:"+chngetostate+ "to:"+initialstate,"Successfully be able to process order","Successfully processed order");
          }
           else
          {
             logger.info("Fail");
            statusTracker(br,"Fail","Verify order process for changing status from:"+chngetostate+ "to:"+initialstate,"Successfully be able to process order","Unable to process successfully");
          }

         logger.info("TurnOFF1");
         
         initialstate="Off";chngetostate="On";
         focusClick(driver,  driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[1]/label")),br);
         
         focusClick(driver,  driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[4]/form/div/button[2]")),br);
          logger.info("TurnOFF"); 
          if(driver.findElements(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[4]/div/div")).size()>0)
          {
                  focusClick(driver, driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[4]/div/div/div[2]/span[2]")),br);
                   logger.info("TurnON1"); 
      
                  do{
                 // logger.info("Processing!" +chk);
                 chk++;
               }while(focusSearch(driver,driver.findElement(By.xpath("/html/body/div[3]/div/div[1]")),br));

             if(driver.findElements(By.id("dataSaveSucess")).size()>0)
               {
                  logger.info("Success");
                 statusTracker(br,"Pass","Verify order process for changing status from:"+initialstate+ "to:"+chngetostate,"Successfully be able to process order","Successfully processed order");
               }
                else
               {
                  logger.info("Fail");
                 statusTracker(br,"Fail","Verify order process for changing status from:"+initialstate+ "to:"+chngetostate,"Successfully be able to process order","Unable to process successfully");
               }
         }  
         
                                return state; 
 
                }
                     
                  
                  public String Unsavedpopup(String br,WebDriver driver, String status)
                  {
                      String initialstate=status, chngetostate="Off",state="Fail";
                       logger.info("Unsavedpopup");

                       focusClick(driver,  driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[1]/label")),br);

                      logger.info("TurnOFF");
                       focusClick(driver,  driver.findElement(By.linkText("Outgoing Calls")),br);
                     Boolean CH= focusSearch(driver,driver.findElement(By.xpath("//html/body/div[2]/div")),br);
                       logger.info("pop up display");
                       if(CH==true)
                       {
                         focusClick(driver,  driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/span")),br);
                         logger.info("pop up display1");
                        if(driver.findElements(By.xpath("//html/body/section/div[4]/div[2]")).size()>0)
                        {
                           logger.info("Success");
                          statusTracker(br,"Pass","Verify if clicking on cancel navigating to DND Page","Successfully navigate back to DND Page on clicking cancel","Success");
                        }
                        else
                        {
                           logger.info("Fail");
                          statusTracker(br,"Fail","Cancel dint work","Unsuccessful","Unable to process successfully");
                        }
                       }     
                       focusClick(driver,  driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[1]/label")),br);

                         logger.info("TurnON");
                         focusClick(driver,   driver.findElement(By.linkText("Outgoing Calls")),br);
                        
                         focusClick(driver, driver.findElement(By.xpath("//a[@id='unsavedFeature']/span")),br);
                         logger.info("OK");
                         
                         if(driver.findElements(By.xpath("//html/body/section/div[4]/div[1]/div")).size()>0)
                         {
                                 statusTracker(br,"Pass","Verify if clicking on OK navigating to Outgoing Calls Page","Successfully navigated to Outgoing calls Page on clicking OK","Success");
                          state="Pass";
                        }
                         else
                        {
                           logger.info("Fail");
                          statusTracker(br,"Fail","OK dint work in Unsaved Pop Up","Unsuccessful","Unable to process successfully");
                        }
                                return state;
                                  
                  }

                  
                  public String Cancel(String br,WebDriver driver, String status) throws InterruptedException
                  {
                      String initialstate=status, chngetostate="Off",state="Fail";
                       logger.info("Cancel");
                       focusClick(driver,    driver.findElement(By.linkText("Incoming Calls")),br);
                       Thread.sleep(2000);
                       focusClick(driver, driver.findElement(By.cssSelector("#collapseFeature3 > div.accordian-header > div.header-right")),br);
                       focusClick(driver,  driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[1]/label")),br);
                       focusClick(driver,driver.findElement(By.cssSelector("form[name=\"doNotDisturbform\"] > div.accordian-actions > button.btn.btn-secondary")),br);
                      if(driver.findElements(By.xpath(".//*[@id='collapseFeature3']//div[1]/h3")).size()>0)
                      {
                         logger.info("Success");
                        state="Pass";
                        statusTracker(br,"Pass","Verify if the user is able to cancel the changes made","Successfully be able to cancel order","Successfully cancel order");
                      }
                       else
                      {
                         logger.info("Fail");
                        statusTracker(br,"Fail","Verify if the user is able to cancel the changes made","Not able to cancel order","Cancel did not work");
                      }
                                return state;
                  }
                  
                  
                 
                  public void execute(String br, WebDriver driver, String url, int loc, String name1) throws Exception {
                                                
                                  Feature_Name="UserDND";
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
                              switchTo(driver, "Admin",tlim,br);   
                                  do{
                                  }while(driver.findElements(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[2]/a")).size()<0);
                                  
                                  focusClick(driver,driver.findElement(By.xpath("//section[@id='admin-homepage-shortcuts']/div/a[3]/span/div")),br);
                                   
                                 logger.info("checkpoint4");  
                                
                                 if(!(InternalException(driver,br)))
                                      {

                                  int count1=driver.findElements(By.xpath("//html/body/section/div")).size();
                                              String featureName="Do Not Disturb";
                                              int featureOrder=FeatureListIncoming(driver,count1,featureName);

                                              System.out.println("Feature Order " + featureOrder);  
                                             
                                              focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature"+featureOrder+" > div.accordian-header > div.header-right")),br);
                                               Thread.sleep(3000);
                                              
                                              TN= Select_TN(driver,featureName,featureOrder,br);
                                              System.out.println(TN);
                                              logger.info("c");

                                              if(TN!=null)
                                              {
                                   focusClick(driver,driver.findElement(By.linkText("Switch to User mode")),br);
                                   logger.info("UserMode");
                                                                                         
                                   focusClick(driver,driver.findElement(By.xpath("//section[@id='homepage-shortcuts']/div/a[3]/span/i")),br);
                                  
                                   logger.info("DND");
                                   new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(TN); 
                                   do{
                                                  //logger.info("Processing!" +chk);
                                                 
                                   }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
                                   focusClick(driver, driver.findElement(By.cssSelector("#collapseFeature3 > div.accordian-header > div.header-right")),br);
                                               Thread.sleep(3000);
                                   
                                  Boolean St=driver.findElement(By.xpath("//div[@id='collapseFeature3']/div[2]/div[1]/label")).isEnabled();
                                  System.out.println("sataus"+St);
                                 
                                                  status1="On";
                                                  if(St=true)
                                                  {
                                                  status1="Off";
                                                  state=turnon(br,driver, status1);
                                                  state=Unsavedpopup(br,driver, status1);
                                                  state=Cancel(br,driver, status1);
                                                  }
                                                  else
                                                  {
                                                  status1="On";
                                                  state=turnoff(br,driver, status1);
                                                  state=Unsavedpopup(br,driver, status1);
                                                  state=Cancel(br,driver, status1);
                                                  }
                                                  
                                               


                                  }
                                                 
                                 
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
                                
                      wb.close();
                     
                    }
                  }

                private By By(String attribute) {
                                // TODO Auto-generated method stub
                                return null;
                }
                }