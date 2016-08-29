package DevVersionFeaturesFile.OutgoingCalls.UserMode;

import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

import DevVersionFeaturesFile.CommonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;


public class UserSpeedDial extends CommonFunctions 
{
                String table,TN, tns[];
                String tlimit,username,pwd;
                int tncount;
                String phoneline,phoneline_ac,phoneline_midtn,phoneline_lastfour;
                String Acccode;
                Boolean status1=null;
                String Enabled;
                int chk=0;

                public UserSpeedDial(String path) {
                                this.path = path;
                }

                public UserSpeedDial(String path, String file1, String file2) {
                                this.path = path;
                                this.path1 = file1;
                                this.path2 = file2;
                }
  
                public int Select_TN(WebDriver driver,String featureName,int rowCount,String br,int tab,int val)
             	{
             		int TN = 0;
             		for(int j=1;j<rowCount;j++)
             			{
             				try
             				{
             			
             					if(focusSearch(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+j+"]/tr[1]/td[1]/i")),br))
             					{
             						System .out.println("TN is suspended");
             						continue;
             					}                                    
             					else if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+j+"]/tr[1]/td[2]/div/input")).getAttribute("class").contains("not"))
             					{ 
             						System.out.println("tn2");
             						TN=j;
             						break;
             					}
             					else
             					{
             						focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+val+"]/table/tbody["+j+"]/tr[1]/td[2]/div/label")),br);
             						focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/table/tfoot/tr/td/button[2]")),br);

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
  public String TurnSpeedDialOn(String br,WebDriver driver,String status,String TN) throws Exception
  {
                  String state="Fail";
                  String schk ="Fail";
                  String pin=randomNO(9999,1000); 
                  
                  focusClick(driver, driver.findElement(By.linkText("Switch to User mode")),br);
                  
                  focusClick(driver,  driver.findElement(By.xpath("//section[@id='homepage-shortcuts']/div/a[4]/span/div")),br);
                  focusDropdown(driver,"//html/body/header/div[4]/div[3]/div/div/span",TN,br);
                  //new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(TN);
                             do{
                                  
                                 
                              }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
                
                  
                             focusClick(driver,driver.findElement(By.cssSelector("div.header-right")),br);
            
                  status1= focusSearch(driver,driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[1]/label[3]")),br);
                  System.out.println(status1);
                
                  
                  if(status1==true)
                  {
                                  statusTracker(br,"","The Speed Dial is having Verified Account code","",""); 
                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).clear();
                                  if(driver.findElement(By.id("check1")).isSelected())
                                  {
                                                  System.out.println("enabled");
                                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).clear();
                                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).sendKeys("816425"+pin);
                                                  focusClick(driver, driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[3]/label")),br);
                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[4]/span/input")).clear();
                          driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[4]/span/input")).sendKeys(Acccode);
                          focusClick(driver, driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
                          do{
                              
                              
                              chk++;
                            }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
                                                
                                  }
                                  else
                                  {
                                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).clear();
                                                 driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).sendKeys("816425"+pin);
                                                  focusClick(driver, driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
                                                  do{
                                                      
                                                      
                                                      chk++;
                                                    }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
                                  }
                  
                  }                 
                                   
                  boolean AccCode= focusSearch(driver,driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[4]/span/input")),br);   
                  boolean LocalCalls= focusSearch(driver,driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[1]/label[3]")),br);
                  
                  if(AccCode==true && LocalCalls==false)
                  {
                                  statusTracker(br,"","The Speed Dial is having Unverified Account code","","");   
                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).clear();
                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).sendKeys("816425"+pin);
                      driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[4]/span/input")).sendKeys("17687"+pin);
                      focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
                      do{
                          
                          
                          chk++;
                        }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
                                  
                  }  
                  
                  if(AccCode==false && LocalCalls==false)
                  {
                                  statusTracker(br,"","The Speed Dial is having No Account code","","");   
                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).clear();
                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).sendKeys("816425"+pin);
                                  focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
                                  do{
                                      
                                      
                                      chk++;
                                   }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
                  }
                  if(driver.findElements(By.cssSelector("img[alt='icon-loading.gif']")).size()>0)
                  {
                                  statusTracker(br,"Pass","Verify order process for setting SpeedDial successfully","Successfully able to process order","Successfully processed order");   
                                  state= "Pass";}
                  else
                  {System.out.println("Fail");
                  statusTracker(br,"Fail","Verify order process for setting SpeedDial successfully" ,"Unable to process order","Unable to process successfully");
                  }
                
                  
                  if(AccCode==true)
              {
                  statusTracker(br,"","The Error Validation of Speed Dial for TNS having Account code","","");  
                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[4]/span/input")).clear();
                  System.out.println("cleared");
                  Thread.sleep(500);
                  schk=SpeedDialNumbers(br,"81642578343","Without entering Account Code",driver);
                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[4]/span/input")).sendKeys(Acccode);
                  schk=SpeedDialNumbers(br,"","Without entering Phone Number",driver);
                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[4]/span/input")).clear();
                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[4]/span/input")).sendKeys("1");
                  schk=SpeedDialNumbers(br,"81642578342","Invalid Account Code",driver);
              }
          return state;
  }
  public String EditTN(String br,WebDriver driver,String status) throws Exception
  
  {
                  String state="Fail";
      String schk ="Fail";
      String pin=randomNO(9999,1000); 
      
      status1=focusSearch(driver, driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[1]/label[3]")),br);
      System.out.println(status1);
    
      
      if(status1==true)
      {
                  statusTracker(br,"","Editing Speed Dial which is having Verified Account code","",""); 
                 driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).clear();
                  if(driver.findElement(By.id("check1")).isSelected())
                  {
                                  System.out.println("enabled");
                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).clear();
                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).sendKeys("816424"+pin);
                                  focusClick(driver,  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[3]/label")),br);
              driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[4]/span/input")).clear();
              driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[4]/span/input")).sendKeys(Acccode);
              focusClick(driver, driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
              do{
                  
                  
                  chk++;
                }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
                                
                  }
                  else
                  {
                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).clear();
                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).sendKeys("816424"+pin);
                                  focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
                                  do{
                                      
                                      
                                      chk++;
                                    }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
                  }
      
      }                 
   
     
      boolean AccCode= focusSearch(driver,driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[4]/span/input")),br);   
      boolean LocalCalls= focusSearch(driver,driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[1]/label[3]")),br);
      
      if(AccCode==true && LocalCalls==false)
      {
                  statusTracker(br,"","Editing Speed Dial which is having Unverified Account code","","");   
                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).clear();
                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).sendKeys("816424"+pin);
          driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[4]/span/input")).sendKeys("17687"+pin);
          focusClick(driver, driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
          do{
              
              
              chk++;
            }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
                  
      }  
      
      if(AccCode==false && LocalCalls==false)
      {
                  statusTracker(br,"","Editing Speed Dial which is having No Account code","","");   
                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).clear();
                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).sendKeys("816424"+pin);
                  focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
                  do{
                      
                      
                      chk++;
                    }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
      }
     
     
      
      if(driver.findElements(By.cssSelector("img[alt='icon-loading.gif']")).size()>0)
      {
                  statusTracker(br,"Pass","Verify order process for Editing SpeedDial successfully","Successfully able to process order","Successfully processed order");   
                  state= "Pass";
                    
          
      }
      else
      {System.out.println("Fail");
      statusTracker(br,"Fail","Verify order process for Editing SpeedDial successfully" ,"Unable to process order","Unable to process successfully");
      }
                  return state;
  }
  
  public String Unsavedpopup(String br,WebDriver driver, String status) throws InterruptedException
  {
                  String state="Fail";
      System.out.println("Unsavedpopup");
      statusTracker(br,"","The SpeedDial Unsaved Pop Up ","",""); 
      driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).clear();                              
      focusClick(driver,driver.findElement(By.linkText("Incoming Calls")),br);
       System.out.println("ggggggggggggggggggggggggggggggggg");           
     Boolean CH= focusSearch(driver,driver.findElement(By.xpath("/html/body/div[2]/div")),br);
       System.out.println("pop up display");
       if(CH==true)
       {
        focusClick(driver, driver.findElement(By.id("cancelSaveFeature")),br);                       
        if(driver.findElements(By.xpath("/html/body/section/div[4]/div[1]/h3")).size()>0)
        {
          System.out.println("Success");
          statusTracker(br,"Pass","Verify if clicking on cancel navigating to SpeedDial Page","Successfully navigate back to SpeedDial Page on clicking cancel","Success");
        }   
        else
        {
          System.out.println("Fail");
          statusTracker(br,"Fail","Cancel dint work","Unsuccessful","Unable to process successfully");
        }
       }  
       Thread.sleep(1000);
     
        System.out.println("TurnON");
        focusClick(driver,  driver.findElement(By.linkText("Incoming Calls")),br);
        focusClick(driver,driver.findElement(By.xpath("//a[@id='unsavedFeature']/span")),br);
         
         if(driver.findElements(By.xpath("/html/body/section/div[4]/div[1]/h3")).size()>0)
         {
                 statusTracker(br,"Pass","Verify if clicking on OK navigating to Incoming Calls Page","Successfully navigated to Incoming calls Page on clicking OK","Success");
        state="Pass";
        }
         else
        {
          System.out.println("Fail");
          statusTracker(br,"Fail","OK dint work in Unsaved Pop Up","Unsuccessful","Unable to process successfully");
        }
                return state;
                  
  }

  public String Cancel(String br,WebDriver driver, String status)
  {
      String state="Fail";
      System.out.println("Cancel");
      statusTracker(br,"","The SpeedDial cancel Transactions ","",""); 
      driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).clear();
      driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).sendKeys("4353");
      focusClick(driver,  driver.findElement(By.cssSelector("button.btn.btn-secondary")),br);
      if(driver.findElements(By.xpath("/html/body/section/div[4]")).size()>0)
      {
        System.out.println("Success");
        state="Pass";
        statusTracker(br,"Pass","Verify if the user is able to cancel the changes made","Successfully be able to cancel order","Successfully cancel order");
        
      }
       else
      {
        System.out.println("Fail");
        statusTracker(br,"Fail","Verify if the user is able to cancel the changes made","Not able to cancel order","Cancel did not work");
      }
                return state;
  }
  
  public String SpeedDialNumbers(String br,String Number, String check,WebDriver driver) throws Exception
  {
                  
                  System.out.println("Iam cumng too");
                  String schk="Fail";
                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).clear();
                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).sendKeys(Number);
    
                  focusClick(driver, driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
      
                  do{
                      
                      
                      chk++;
                    }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
      
      System.out.println("after submitting");
      
      Thread.sleep(1000);
    //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  /*    if(status1==true)
                  {
                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).clear();
                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[2]/span/input")).sendKeys("8164256464");  
                                  driver.findElement(By.cssSelector("button.btn.btn-primary")),br);  
                                  statusTracker("Pass","Verify if error message is displayed when adding "+check+" Number","Error message is displayed:"+driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/div[1]/div")).getText(),"Error message should be displayed");
          Thread.sleep(1000);
                                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[4]/span/input")).sendKeys(Acccode);
                                  driver.findElement(By.cssSelector("button.btn.btn-primary")),br);  
                  }  
      */
      if((focusSearch(driver,driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/div[1]/div")),br)))
     {
                  System.out.println("printing");
                  statusTracker(br,"Pass","Verify if error message is displayed when adding "+check+" Number","Error message is displayed:"+driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/div[1]/div")).getText(),"Error message should be displayed");
     } 
     
      else
      {
                  
                  statusTracker(br,"Fail","Verify if error message is displayed when adding "+check+" PIN","Error message is not displayed","Error message should be displayed");
      }
                  
       schk ="Pass";
     
  return schk;
  }
  private String getText() {
                // TODO Auto-generated method stub
                return null;
}


public String SpeedDialValidation(String br,WebDriver driver) throws Exception
  {
                
                System.out.println("iam cumng");
                  //String pin1 = randomNO(9999,1000);
                  String schk ="Fail";
                  focusClick(driver,driver.findElement(By.linkText("Outgoing Calls")),br);
                  statusTracker(br,"","The SpeedDial Defect Validation","",""); 
                  focusClick(driver,driver.findElement(By.xpath("/html/body/section/div[4]/div[1]/div")),br);
      System.out.println("SpeedDial");
      String pin=randomNO(9999999,100000000); 
                  schk=SpeedDialNumbers(br,"0","Number starting with 0",driver);
                  schk=SpeedDialNumbers(br,"1","Number starting with 1",driver);
                  schk=SpeedDialNumbers(br,"900"+pin,"Number starting with 900",driver);
                  schk=SpeedDialNumbers(br,"976"+pin,"Number starting with 976",driver);
                  schk=SpeedDialNumbers(br,"242"+pin,"Number starting with 242",driver);
                  schk=SpeedDialNumbers(br,"246"+pin,"Number starting with 246",driver);
                  schk=SpeedDialNumbers(br,"264"+pin,"Number starting with 264",driver);
                  schk=SpeedDialNumbers(br,"268"+pin,"Number starting with 268",driver);
                  schk=SpeedDialNumbers(br,"284"+pin,"Number starting with 284",driver);
                  schk=SpeedDialNumbers(br,"345"+pin,"Number starting with 345",driver);
                  schk=SpeedDialNumbers(br,"441"+pin,"Number starting with 441",driver);
                  schk=SpeedDialNumbers(br,"473"+pin,"Number starting with 473",driver);
                  schk=SpeedDialNumbers(br,"649"+pin,"Number starting with 649",driver);
                  schk=SpeedDialNumbers(br,"664"+pin,"Number starting with 664",driver);
                  schk=SpeedDialNumbers(br,"758"+pin,"Number starting with 758",driver);
                  schk=SpeedDialNumbers(br,"767"+pin,"Number starting with 767",driver);
                  schk=SpeedDialNumbers(br,"784"+pin,"Number starting with 784",driver);
                  schk=SpeedDialNumbers(br,"8096565444","Number starting with 809",driver);
                  Thread.sleep(500);
                  schk=SpeedDialNumbers(br,"829"+pin,"Number starting with 829",driver);
                  schk=SpeedDialNumbers(br,"868"+pin,"Number starting with 868",driver);
                  schk=SpeedDialNumbers(br,"849"+pin,"Number starting with 849",driver);
                  schk=SpeedDialNumbers(br,"869"+pin,"Number starting with 869",driver);
                  schk=SpeedDialNumbers(br,"876"+pin,"Number starting with 876",driver);
                  
                 System.out.println(TN);
                schk=SpeedDialNumbers(br,TN,"SelfTN Error",driver);
                  
                  schk=SpeedDialNumbers(br,"816425","Less Than 10 Digits",driver);
                  System.out.println("order done");
                   
      //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       schk="Pass";
                  return schk;
  }

                  public void execute(String br, WebDriver driver, String url, int loc, String name1) throws Exception {
          

                                  
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
                                 logger.info("User Speed Dial");

                                 switchTo(driver, "Admin",tlim,br);
                                 focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]/a")),br);
                                 System.out.println("checkpoint1");
                                 for(int i1=1;i1<20;i1++){}
                                 Acccode=driver.findElement(By.xpath("//html/body/section/section/div[1]/aside[1]/ul/li[1]/strong")).getText();
                                 System.out.println("Acccode"+Acccode);
                  
                  
                                 for(int i=1;i<30;i++){}
                                 focusClick(driver, driver.findElement(By.xpath("//section[@id='admin-homepage-shortcuts']/div/a[4]/span/div")),br);

                                 int featureOrder=0;String featureName="SC1D";
                                 focusClick(driver,driver.findElement(By.xpath("//*[@id='accordion_SC1D']/h3")),br);    	  
                                 System.out.println("c");

                                 int divval=3;
                                 try
                                 {
                                	 if(driver.findElement(By.xpath(".//*[@id='collapseFeature_SC1D']/div[3]/div/h2")).isDisplayed())
                                	 {
                                		 statusTracker(br,"","Speed Dial Modal pop up is  displayed","","");
                                		 //driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/div/button")).click();
                                		 divval=3;
                                	 }
                                 }
                                 catch(Exception e)
                                 {
	       						statusTracker(br,"","Speed Dial Modal pop up is not displayed second time","","");
	       						first=1;
                                 }					
                       
                                                              int rowCount=driver.findElements(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/table/tbody")).size();
                                   							System.out.println("d: "+rowCount);
                                   							int TN= Select_TN(driver,"SC1D",rowCount,br,2,divval);
                                   							String TN1=driver.findElement(org.openqa.selenium.By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div["+divval+"]/table/tbody["+TN+"]/tr/td[1]")).getText();

                                
                                                              if(TN1!=null)
                                                              {
                                                                                System.out.println("print");
                                                                                                  state=TurnSpeedDialOn(br,driver,status1,TN1);
                                                                                      Thread.sleep(5000);
                                                                                    state= EditTN(br,driver,status1);
                                                                        state=Unsavedpopup(br,driver,status1);
                                                                        state=SpeedDialValidation(br,driver);
                                                                                                state=Cancel(br,driver,status1);
                                                                                   
                                                                                                  
                                                  }
                                               
                                                          
                                                  first=1;      
                                       
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
//      wb.close();
     
    }
  }

}
