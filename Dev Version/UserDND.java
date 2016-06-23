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
                                  
                                  
                                  focusClick(driver, driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[1]/label")),br);
                      
                                  focusClick(driver,  driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[4]/form/div/button[2]")),br);

                                do{
                                // logger.info("Processing!" +chk);
                                chk++;
                                }while(focusSearch(driver,driver.findElement(By.xpath("/html/body/div[3]/div/div[1]")),br));
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
                    }while(focusSearch(driver,driver.findElement(By.xpath("/html/body/div[3]/div/div[1]")),br));
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
         
                                return state; 
 
                }
                     
                  
                  public String Unsavedpopup(String br,WebDriver driver, String status)
                  {
                      String initialstate=status, chngetostate="Off",state="Fail";
                       logger.info("Unsavedpopup");

                       focusClick(driver,  driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[1]/label")),br);

                      logger.info("TurnOFF");
                       focusClick(driver,  driver.findElement(By.linkText("Outgoing Calls")),br);
                     Boolean CH= focusSearch(driver,driver.findElement(By.xpath("/html/body/div[2]/div")),br);
                       logger.info("pop up display");
                       if(CH==true)
                       {
                         focusClick(driver,  driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/span")),br);
                         logger.info("pop up display1");
                        if(driver.findElements(By.xpath("/html/body/section/div[4]/div[2]")).size()>0)
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
                         
                         if(driver.findElements(By.xpath("/html/body/section/div[4]/div[1]/div")).size()>0)
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

                  
                  public String Cancel(String br,WebDriver driver, String status)
                  {
                      String initialstate=status, chngetostate="Off",state="Fail";
                       logger.info("Cancel");
                       focusClick(driver,    driver.findElement(By.linkText("Incoming Calls")),br);
                       focusClick(driver, driver.findElement(By.cssSelector("#collapseFeature3 > div.accordian-header > div.header-right")),br);
                       focusClick(driver,  driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[1]/label/span")),br);
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
                  
                  public int Select_TN(WebDriver driver,String featureName,int rowCount,String br,int val)
              		{
              		int TN = 0;
              		for(int j=1;j<rowCount;j++)
              			{
              				try
              				{
              			
              					if(focusSearch(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+j+"]/tr/td[1]/i")),br))
              					{
              						System .out.println("TN is suspended");
              						continue;
              					}
              					else if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+j+"]/tr/td[2]/div/input")).getAttribute("class").contains("not"))
              					{ 
              						System.out.println("tn2");
              						TN=j;
              						break;
              					}
              					else
              					{
              						focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+j+"]/tr/td[2]/div/label")),br);
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

                                	 int featureOrder=0;String featureName="DND";
                       			  	focusClick(driver,driver.findElement(By.xpath(".//*[@id='accordion_"+featureName+"']/h3")),br);    	  
             							System.out.println("c");

             							int divval=3;
             							try
               	       					{
             								if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/div/h2")).isDisplayed())
             								{
             									statusTracker(br,"","DND Modal pop up is  displayed","","");
             									driver.findElement(By.cssSelector("i.icomatic.close-btn")).click();
             									divval=3;
             								}
               	       					}
               	       					catch(Exception e)
               	       					{
               	       						statusTracker(br,"","DND Modal pop up is not displayed second time","","");
               	       						first=1;
               	       					}												
                 	  
             							int rowCount=driver.findElements(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/table/tbody")).size();
             							System.out.println("d: "+rowCount);
             							int TN= Select_TN(driver,featureName,rowCount,br,divval);
             							String TN1=driver.findElement(org.openqa.selenium.By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+divval+"]/table/tbody["+TN+"]/tr/td[1]")).getText();

                                         if(TN1!=null)
                                         {
                                                  focusClick(driver,driver.findElement(By.linkText("Switch to User mode")),br);
                                                  logger.info("UserMode");
                                                                                         
                                                  focusClick(driver,driver.findElement(By.xpath("//section[@id='homepage-shortcuts']/div/a[3]/span/i")),br);
                                  
                                                  logger.info("DND");
                                                  new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(TN1); 
                                                  do{
                                                  //logger.info("Processing!" +chk);
                                                 
                                                  }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
                                                  focusClick(driver, driver.findElement(By.cssSelector("#collapseFeature3 > div.accordian-header > div.header-right")),br);
                                               Thread.sleep(3000);
                                   
                                               Boolean St=driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/div[1]/label")).isEnabled();
                                               System.out.println(St);
                                 
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
                                                   logger.info("started");
                                               


                                  }
                                                  Thread.sleep(2000);
                                 
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
