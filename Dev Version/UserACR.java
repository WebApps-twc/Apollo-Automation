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

                     focusClick(driver,driver.findElement(By.linkText("Switch to User mode")),br);
                     logger.info("UserMode");
              
                     for(int i=1;i<100;i++){}
                     focusClick(driver,driver.findElement(By.xpath(xpath_ACRsection)),br);
                     do{
            
                     }while(driver.findElements(By.xpath("//html/body/header/div[4]/div[3]/div/div/span/select")).size()<0);
 
                     focusDropdown(driver,"//html/body/header/div[4]/div[3]/div/div/span",TN1,br);
                     do{
                    	 //logger.info("Processing!" +chk);
                 
                     }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                     logger.info("ACR");

                     focusClick(driver,driver.findElement(By.cssSelector("div.header-right")),br);

                     focusClick(driver,driver.findElement(By.xpath(xpath_ACRsection_header)),br);

                     logger.info("TurnOFF");

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

                     focusClick(driver,driver.findElement(By.xpath(xpath_ACRsection_submit)),br);
                     logger.info("TurnON");

                     focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br);

                     do{

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

                                  focusClick(driver,driver.findElement(By.xpath(xpath_ACRunsavedpopup_xpath1)),br);
                                  logger.info("TurnOFF");

                                  focusClick(driver,driver.findElement(By.linkText("Outgoing Calls")),br);
                                  logger.info("H1");
                                  Thread.sleep(3000);
                                  Boolean CH= focusSearch(driver,driver.findElement(By.xpath(xpath_ACRunsavedpopup_xpath2)),br);
                                  System.out.println(CH);

                                  logger.info("pop up display");
                                  if(CH==true)
                                  {
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

                                  focusClick(driver,driver.findElement(By.xpath(xpath_ACRunsavedpopup_xpath5)),br);
                                  logger.info("TurnON");

                                  focusClick(driver,driver.findElement(By.linkText("Outgoing Calls")),br);

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

                      focusClick(driver,driver.findElement(By.linkText("Incoming Calls")),br);
                     Thread.sleep(4000);

                      focusClick(driver,driver.findElement(By.cssSelector("div.header-right")),br);

                      focusClick(driver,driver.findElement(By.xpath(xpath_ACRcancel_xpath1)),br);
                      focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-secondary")),br);

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
              						focusClick(driver,driver.findElement(By.cssSelector("td > button.btn.btn-primary")),br);
              			  			  
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
                                                			  int featureOrder=0;String featureName="ACR";
                                                			  focusClick(driver,driver.findElement(By.xpath(".//*[@id='accordion_"+featureName+"']/h3")),br);    	  
                                      							System.out.println("c");

                                      							int divval=3;
                                      							try
                                        	       				{
                                        	       				if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/div/h2")).isDisplayed())
                                        	       				{
                                        	       				statusTracker(br,"","ACR Modal pop up is  displayed","","");
                                        	       				driver.findElement(By.cssSelector("i.icomatic.close-btn")).click();
                                        	       				divval=3;
                                        	       				}
                                        	       				}
                                        	       				catch(Exception e)
                                        	       				{
                                        	       					statusTracker(br,"","CF Modal pop up is not displayed second time","","");
                                        	       					first=1;
                                        	       				}												
                                          	  
                                      							int rowCount=driver.findElements(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/table/tbody")).size();
                                      							System.out.println("d: "+rowCount);
                                      							int TN= Select_TN(driver,featureName,rowCount,br,divval);
                                      							String TN1=driver.findElement(org.openqa.selenium.By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+divval+"]/table/tbody["+TN+"]/tr/td[1]")).getText();
                
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