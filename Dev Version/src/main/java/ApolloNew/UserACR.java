package ApolloNew;
import java.io.File;

import org.openqa.selenium.support.ui.Select;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class UserACR extends CommonFunctions {

                
                String table,TN1, tns[];
    String tlimit,username,pwd;
    int tncount;
                
                String xpath_ACRsection;
                String xpath_ACRsection_header;
                String xpath_ACRsection_submit;
                String xpath_ACRunsavedpopup_xpath1;
                String xpath_ACRunsavedpopup_xpath2;
                String xpath_ACRunsavedpopup_xpath3;
                String xpath_ACRunsavedpopup_xpath4;
                String xpath_ACRunsavedpopup_xpath5;
                String xpath_ACRunsavedpopup_xpath6;
                String xpath_ACRunsavedpopup_xpath7;
                String xpath_ACRcancel_xpath1;
                String xpath_ACRcancel_xpath2;
                
                String xpath_ACRexecute_xpath1;
                String xpath_ACRexecute_xpath2;
                String xpath_ACRexecute_xpath3;
                String xpath_ACRexecute_xpath4;
                String xpath_ACRexecute_xpath5;
                String css_ACRexecute_css1;
                String css_ACRexecute_css2;
                String css_ACRexecute_css3;
                
                
                int rank[]= new int[50];
                

                int c_sequence;
                String name_for_rank[]= new String[40];
                String price, rank_channels;

                public UserACR(String path) {
                                this.path = path;
                }
/*
                public UserACR(String path, String file1, String file2) {
                                this.path = path;
                                this.path1 = file1;
                                this.path2 = file2;
                }
                                */
                
                  public String turnoffon(String br, WebDriver driver, String status,String TN1)throws Exception
                  {
                                  xpath_ACRsection = ACR.getProperty("xpath_ACRsection");
                                  xpath_ACRsection_header = ACR.getProperty("xpath_ACRsection_header");
                                  xpath_ACRsection_submit = ACR.getProperty("xpath_ACRsection_submit");
  
          String initialstate=status, chngetostate="Off",state="Fail";
  
          //driver.findElement(By.linkText("Switch to User mode")).click();
          focusClick(driver,driver.findElement(By.linkText("Switch to User mode")),br);
          logger.info("UserMode");
              
          for(int i=1;i<100;i++){}
          //driver.findElement(By.xpath(xpath_ACRsection)).click();
          focusClick(driver,driver.findElement(By.xpath(xpath_ACRsection)),br);
          do{
            
          }while(driver.findElements(By.xpath("//html/body/header/div[4]/div[3]/div/div/span/select")).size()<0);
          //new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(TN1);  
          focusDropdown(driver,"//html/body/header/div[4]/div[3]/div/div/span",TN1,br);
          do{
                  //logger.info("Processing!" +chk);
                 
          }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
           logger.info("ACR");
           //driver.findElement(By.cssSelector("div.header-right")).click();
           focusClick(driver,driver.findElement(By.cssSelector("div.header-right")),br);
        
          //driver.findElement(By.xpath(xpath_ACRsection_header)).click();
          focusClick(driver,driver.findElement(By.xpath(xpath_ACRsection_header)),br);

          logger.info("TurnOFF");
         // driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
          focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
          int chk=0;
          do{
                  //logger.info("Processing!" +chk);
                  chk++;
          }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
          


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
             
          //driver.findElement(By.xpath(xpath_ACRsection_submit)).click();
          focusClick(driver,driver.findElement(By.xpath(xpath_ACRsection_submit)),br);
          logger.info("TurnON");
          //driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
          focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br);

          do{
                  //logger.info("Processing!" +chk);
                  chk++;
          }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
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
          return state;
                  }
                  
                  public String Unsavedpopup(String br, WebDriver driver, String status) throws Exception
                  {
                                  xpath_ACRunsavedpopup_xpath1 = ACR.getProperty("xpath_ACRunsavedpopup_xpath1");
                                  xpath_ACRunsavedpopup_xpath2 = ACR.getProperty("xpath_ACRunsavedpopup_xpath2");
                                  xpath_ACRunsavedpopup_xpath3 = ACR.getProperty("xpath_ACRunsavedpopup_xpath3");
                                  xpath_ACRunsavedpopup_xpath4 = ACR.getProperty("xpath_ACRunsavedpopup_xpath4");
                                  xpath_ACRunsavedpopup_xpath5 = ACR.getProperty("xpath_ACRunsavedpopup_xpath5");
                                  xpath_ACRunsavedpopup_xpath6 = ACR.getProperty("xpath_ACRunsavedpopup_xpath6");
                                  xpath_ACRunsavedpopup_xpath7 = ACR.getProperty("xpath_ACRunsavedpopup_xpath7");
  
                                  String initialstate=status, chngetostate="Off",state="Fail";
                                  logger.info("Unsavedpopup");
                                
                                  //driver.findElement(By.xpath(xpath_ACRunsavedpopup_xpath1)).click();
                                  focusClick(driver,driver.findElement(By.xpath(xpath_ACRunsavedpopup_xpath1)),br);
                                  logger.info("TurnOFF");
                                  //driver.findElement(By.linkText("Outgoing Calls")).click();
                                  focusClick(driver,driver.findElement(By.linkText("Outgoing Calls")),br);
                                  logger.info("H1");
                                  Thread.sleep(3000);
                                  Boolean CH= focusSearch(driver,driver.findElement(By.xpath(xpath_ACRunsavedpopup_xpath2)),br);
                                  System.out.println(CH);
                                                                  //driver.findElement(By.xpath(xpath_ACRunsavedpopup_xpath2)).isDisplayed();
                                  logger.info("pop up display");
                                  if(CH==true)
                                  {
                                                  //driver.findElement(By.xpath(xpath_ACRunsavedpopup_xpath3)).click();
                                                  focusClick(driver,driver.findElement(By.xpath(xpath_ACRunsavedpopup_xpath3)),br);
                                                  logger.info("pop up display1");
                                                  if(driver.findElements(By.xpath(xpath_ACRunsavedpopup_xpath4)).size()>0)
                                                  {
                                                                  logger.info("Success");
                                                                  statusTracker(br,"Pass","Verify if clicking on cancel navigating to ACR Page","Successfully navigate back to ACR Page on clicking cancel","Success");
                                                  }
                                                  else
                                                  {
                                                                  logger.info("Fail");
                                                                  statusTracker(br,"Fail","Cancel dint work","Unsuccessful","Unable to process successfully");
                                                  }
                                  }     
                                 // driver.findElement(By.xpath(xpath_ACRunsavedpopup_xpath5)).click();
                                  focusClick(driver,driver.findElement(By.xpath(xpath_ACRunsavedpopup_xpath5)),br);
                                  logger.info("TurnON");
                                // driver.findElement(By.linkText("Outgoing Calls")).click();
                                  focusClick(driver,driver.findElement(By.linkText("Outgoing Calls")),br);
                                // driver.findElement(By.xpath(xpath_ACRunsavedpopup_xpath6)).click();
                                  focusClick(driver,driver.findElement(By.xpath(xpath_ACRunsavedpopup_xpath6)),br);
                                  logger.info("OK");

                                  if(driver.findElements(By.xpath(xpath_ACRunsavedpopup_xpath7)).size()>0)
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

                  
                  public String Cancel(String br,WebDriver driver, String status) throws Exception
                  {
                                  xpath_ACRcancel_xpath1 = ACR.getProperty("xpath_ACRcancel_xpath1");
                                  xpath_ACRcancel_xpath2 = ACR.getProperty("xpath_ACRcancel_xpath2");
                                  
                      String initialstate=status, chngetostate="Off",state="Fail";
                      logger.info("Cancel");
                     // driver.findElement(By.linkText("Incoming Calls")).click();
                      focusClick(driver,driver.findElement(By.linkText("Incoming Calls")),br);
                     Thread.sleep(4000);
                      //driver.findElement(By.cssSelector("div.header-right")).click();
                      focusClick(driver,driver.findElement(By.cssSelector("div.header-right")),br);
                      
                      //driver.findElement(By.xpath(xpath_ACRcancel_xpath1)).click();
                      focusClick(driver,driver.findElement(By.xpath(xpath_ACRcancel_xpath1)),br);
                      focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-secondary")),br);
                   //   focusClick(driver,driver.findElement(By.xpath("html/body/section/div[4]/div[2]/div[5]/form/div/button[1]")),br);
                      if(driver.findElements(By.xpath(xpath_ACRcancel_xpath2)).size()>0)
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
                
                                  Feature_Name="ACR";
                                  xpath_ACRexecute_xpath1 = ACR.getProperty("xpath_ACRexecute_xpath1");
                                  xpath_ACRexecute_xpath2 = ACR.getProperty("xpath_ACRexecute_xpath2");
                                  xpath_ACRexecute_xpath3 = ACR.getProperty("xpath_ACRexecute_xpath3");
                                  xpath_ACRexecute_xpath4 = ACR.getProperty("xpath_ACRexecute_xpath4");
                                  xpath_ACRexecute_xpath5 = ACR.getProperty("xpath_ACRexecute_xpath5");
                                  css_ACRexecute_css1 = ACR.getProperty("css_ACRexecute_css1");
                                  css_ACRexecute_css2 = ACR.getProperty("css_ACRexecute_css2");
                                  css_ACRexecute_css3 = ACR.getProperty("css_ACRexecute_css3");
                                
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
                                  logger.info("b");   
                              switchTo(driver, "Admin",tlim,br);
                              logger.info("c");
                                                                                      
                              focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]/a")),br);
                              
                               logger.info("checkpoint1");
                              
                  //driver.findElement(org.openqa.selenium.By.xpath(xpath_ACRexecute_xpath2)).click();
                  focusClick(driver,driver.findElement(By.xpath(xpath_ACRexecute_xpath2)),br);
                  for(int i=1;i<30;i++){}
                  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);  
                  if(!(InternalException(driver,br)))
                                  {
                                  logger.info("c");  
                                  int count1=driver.findElements(By.xpath("//html/body/section/div")).size();
                                              String featureName="Anonymous Call Rejection";
                                              int featureOrder=FeatureListIncoming(driver,count1,featureName);
                                              System.out.println("Feature Order is"+featureOrder);
                                  //driver.findElement(By.cssSelector(css_ACRexecute_css1)).click();
                                  focusClick(driver,driver.findElement(By.cssSelector(css_ACRexecute_css1)),br);
                                 Thread.sleep(2000);
                                  TN1= Select_TN(driver,featureName,featureOrder,br);
                                              System.out.println("TN is"+TN1);
                                              logger.info("c1");
                
                                              if(TN1!= null)
                                              {
                                                  logger.info("print");
                                                  status1="On";
                                      state=turnoffon(br,driver, status1,TN1);
                                      Thread.sleep(1000);
                                      state=Unsavedpopup(br,driver, status1);
                                      state=Cancel(br,driver, status1);
                                      logger.info("started");
                                              }
                                             
                                  //first=1;
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
                                //statusTracker("end","","");
                      wb.close();
                      //driver.close();
                     
                    }
                  }
                }