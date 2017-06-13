package DevVersionFeaturesFile.IncomingCalls.UserMode;



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

                                  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature1']/div[2]/div[4]/div/div[2]/form//div/label/span[2]")),br);
                                  
                      focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[2]//div[4]/button[2]")),br);
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
                      
                      chngetostate="ON";

                      driver.findElement(By.xpath("//div[@id='collapseFeature1']/div[2]/div[4]/div/div[2]/form//div/label/span[2]")).click();
                      driver.findElement(By.name("callForwardPhone")).clear();
                      driver.findElement(By.name("callForwardPhone")).sendKeys("5625895476");

                      focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[2]//div[4]/button[2]")),br);
                      
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
                  
                public String Turnon(WebDriver driver, String br, String status, String acc)
          	  {
          		String st="On";
          		
          		 String initialstate=status, chngetostate="ON";
          		  logger.info("Turn On");
          			  
          		     driver.findElement(By.xpath("//div[@id='collapseFeature1']/div[2]/div[4]/div/div[2]/form//div/label/span[2]")).click();

          		     driver.findElement(By.name("callForwardPhone")).clear();
          		//TN=TN+randomNO(3333,9999);
          		   driver.findElement(By.name("callForwardPhone")).sendKeys("9259889546");

          		   focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[2]//div[4]/button[2]")),br);
          	   int chk=0;
          	   do{
                    chk++;
                  }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
                                   
          	   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
          	     {
          	     
          	       statusTracker(br,"Pass","Verify order process for changing from Off to "+st+"with non verified Account code "," Successfully be able to process order ","Successfully processed order");                                                                   
          	       status="Pass";
          	     }
          	      else
          	     {
          	    
          	       statusTracker(br,"Fail","Verify order process for changing from Off to "+st+"with non verified Account code ","Not able to process order","Successfully processed order");
          	       status="Fail";
          	     }
          	 String state="Fail", accst=acc;
          	initialstate=status; chngetostate="Off";

             focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature1']/div[2]/div[4]/div/div[2]/form//div/label/span[2]")),br);
             
             focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[2]//div[4]/button[2]")),br);
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
          	 return status;
          	  }
                
                
                  public String turnOnold(WebDriver driver, String br, String status, String acc)
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
                                  driver.findElement(By.name("callForwardPhone")).sendKeys("8854752865");
                                  for(int i=1;i<10;i++){}

                                  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[2]//div[4]/button[2]")),br);
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
                          
                         focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[2]//div[4]/button[2]")),br);
                                 
                         Thread.sleep(2000);
                     
                         if(driver.findElement(By.cssSelector("div[class='error-box inverted spacing'] div[class='message-box']")).isDisplayed())
                         {
                                statusTracker(br,"Pass","Verify if error message is displayed when adding "+ac+" TN/Acc code","Error message is displayed: "+ driver.findElement(By.cssSelector("div[class='error-box inverted spacing'] div[class='message-box']")).getText(),"Error message should be displayed");
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
                         
                         return schk;
                  }
                  
                  public void cancel(WebDriver driver,String br) throws Exception
            	  {
            		  logger.info("Switching the feature");
            		  driver.findElement(By.xpath("//div[@id='collapseFeature1']/div[2]/div[4]/div/div[2]/form//div/label/span[2]")).click();
            		  driver.findElement(By.cssSelector("a[href='/UserOutgoingCalls/OutgoingCalls']")).click();
            		  Thread.sleep(2000);
            		  logger.info("Clicking on cancel in the pop-up");
            		  driver.findElement(By.cssSelector("[class='modal-footer'] span[id='cancelSaveFeature']")).click();
            		  boolean enable = driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[2]//div[4]/button[2]")).isEnabled();
            		  if(enable)
            		  {
                          logger.info("Success");
                         statusTracker(br,"Pass","Verify if clicking on cancel navigating to Callforward Page","Successfully navigate back to Callforward Page on clicking cancel","Success");
                       }
                       else
                       {
                          logger.info("Fail");
                         statusTracker(br,"Fail","Cancel dint work","Unsuccessful","Unable to process successfully");
                       }
            		  Thread.sleep(2000);
            		  driver.findElement(By.cssSelector("a[href='/UserOutgoingCalls/OutgoingCalls']")).click();
            		  logger.info("Clicking on cancel in the pop-up");
            		  driver.findElement(By.cssSelector("[class='modal-footer'] a[id='unsavedFeature'] span")).click();
            		  Thread.sleep(2000);
            		  if(driver.findElements(By.xpath("/html/body/section/div[4]/div[1]/div")).size()>0)
                      {
            			  logger.info("Success");
                          statusTracker(br,"Pass","Verify if clicking on OK navigating to Outgoing Calls Page","Successfully navigated to Outgoing calls Page on clicking OK","Success");
                     }
                      else
                     {
                        logger.info("Fail");
                        statusTracker(br,"Fail","OK dint work in Unsaved Pop Up","Unsuccessful","Unable to process successfully");
                     }
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
                                  if(driver.findElement(By.cssSelector("a[href='/UserMain/UserCallSettings']")).isDisplayed())
                        		  {
                        			  statusTracker(br,"Pass","Verifying Whether the home page is displayed","Successfully Logged into VoiceManager application, home page is displayed","");
                        		  }
                        		  else
                        		  {
                        			  statusTracker(br,"Fail","Verifying Whether the home page is displayed","Could not Log into VoiceManager application, home page is not displayed","");
                        		  }
                                  
                                  focusClick(driver,driver.findElement(By.cssSelector("a[href='/UserIncomingCalls/IncomingCalls']")),br);
                  for(int i=1;i<20;i++){}
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
                  
                  boolean status= driver.findElement(By.id("toggleButton2")).isSelected();
                  
                  int cnt=driver.findElements(org.openqa.selenium.By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[2]/form/div/div")).size();
                  logger.info("cnt is"+cnt);
                  
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
                          state=Turnon(driver, br,status1, acc);
                    }
                    logger.info("orderprocess is done");
                    EditTn(driver,br);
                    TNValidation(driver,br,a3); 
                    cancel(driver,br);
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
