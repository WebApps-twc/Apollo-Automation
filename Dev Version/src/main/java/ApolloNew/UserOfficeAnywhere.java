package ApolloNew;

import com.thoughtworks.selenium.Selenium;



import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
//import org.apache.bcel.generic.Select;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;


public class UserOfficeAnywhere extends CommonFunctions {

                
                String table, tns[];
    String tlimit,username,pwd,schk1,phoneline_ac;
    int tncount;
    Boolean TnStatus;
    String Enabled;
    
                public UserOfficeAnywhere(String path) {
                                this.path = path;
                }

                /*public UserOfficeAnywhere(String path, String file1, String file2) {
                                this.path = path;
                                this.path1 = file1;
                                this.path2 = file2;
                }*/
                public String Select_TN(WebDriver driver,String Featurename,int count, String br)
                {
                Featurename="{\"name\":\"RemoteOffice_FeatureName\",\"value\":\"Office Anywhere\",\"parameters\":[],\"text\":\"Office Anywhere\",\"exampleText\":\"Office Anywhere\"}";
                                int numberOfTns=countNumberTns(count,Featurename,driver,br);
                                System.out.println(numberOfTns);
                                String TN="";
                                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                                for(int j=0;j<numberOfTns;j++)
                                {
                                                try
                                                {
                                                if(focusSearch(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature"+count+"']/div[2]/form/div["+(6+j)+"]/i")),br))
                                                {
                                                                System .out.println("TN is suspended");
                                                                continue;
                                                }
                                                else if(driver.findElement(By.id("check"+Featurename+j)).isSelected())
                                                { 
                                                                System.out.println("tn2");
                                                                TN=driver.findElement(By.xpath(".//*[@id='collapseFeature"+count+"']/div[2]/form/div["+(6+j)+"]/label")).getText();    
                                                                schk1="Pass";
                                                                break;
                                                                
                                                }
                                                else
                                                {
                                                                /*driver.findElement(By.id("check"+Featurename+j)),br);*/
                                                                focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature"+count+"']/div[2]/form/div["+(6+j)+"]/label")),br);
                                                                focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature"+count+" > div.accordian-body.in > form[name=\"featureForm\"] > div.accordian-actions > button.btn.btn-primary")),br);
                                                   int chk=0;
                                                                do{
                 
                                                                                
                 chk++;
               }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
             if(focusSearch(driver,driver.findElement(By.id("dataSaveSucess")),br))
             {
                             TN=driver.findElement(By.xpath(".//*[@id='collapseFeature"+count+"']/div[2]/form/div["+(6+j)+"]/label")).getText();    
                  schk1="Pass";
                break;
             }
             else
                  {
                  System.out.println("This feature cannot be  Enabled because "+driver.findElement(By.cssSelector("div.ng-scope > ul > li.ng-scope.ng-binding")).getText());   
                 schk1="Fail";
                  }
                                                                
                                                }
                                                }
                                                catch(Exception e)
                                                  {numberOfTns++;
                                                  }
                                                
                                }
                  return TN;
                
                } 
public int countNumberTns(int featureOrder, String featureName, WebDriver driver, String br)
  {
                  int numberOfTns=0;
                  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                  for(int i=0;i<50;i++)
                  {
                                                  //if(driver.findElements(By.id("check"+featureName+i)).size()>0)
                                  try{
                                                if(focusSearch(driver,driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/div["+(6+i)+"]/label")),br))
                                                {
                                                                System.out.println("in11");
                                                                  numberOfTns++;
                                                }
                                                else
                                                {
                                                                System.out.println("in22");
                                                                  i=101;
                                                }
                                                }
                                  catch(Exception e)
                                  {
                                                i=51;  
                                  }
                  }
                  
                  return numberOfTns;
  }
  public String turnoffon(String br,WebDriver driver, String status,String phoneline_ac)throws Exception
  {
                  String state="Fail";
                  
                  focusClick(driver, driver.findElement(By.linkText("Switch to User mode")),br);
                  logger.info("UserMode");
                  
                  for(int i=1;i<100;i++){}
      
                  focusClick(driver, driver.findElement(By.xpath("//section[@id='homepage-shortcuts']/div/a[5]/span/div")),br);
                  
                  logger.info("OfficeAnywhere");
                  focusDropdown(driver,"//html/body/header/div[4]/div[3]/div/div/span",phoneline_ac,br);
         
                  //new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(phoneline_ac);
                  do{
                                  //logger.info("Processing!" +chk);
                                 
                  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                  focusClick(driver,driver.findElement(By.xpath("/html/body/section/div[4]/div[1]/div")),br);            
                  statusTracker(br,"","The officeanywhere Normal Transaction","",""); 
                  driver.findElement(By.id("pin1")).clear();
                  driver.findElement(By.id("pin1")).sendKeys("4562");
                  driver.findElement(By.id("pin2")).clear();
                  driver.findElement(By.id("pin2")).sendKeys("4562");
                  focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
      int chk=0;
      do{
          //logger.info("Processing!" +chk);
          chk++;
        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

      if(driver.findElements(By.id("dataSaveSucess")).size()>0)
        {
          logger.info("Success");
          statusTracker(br,"Pass","Verify order process for setting office anywhere successfully","Successfully able to process order","Successfully processed order");
        }
         else
        {
          logger.info("Fail");
          statusTracker(br,"Fail","Verify order process for setting office anywhere successfully" ,"Unable to process order","Unable to process successfully");
        }
                 
          return state;
  }
  public String Unsavedpopup(String br,WebDriver driver, String status)
  {
                  String state="Fail";
      logger.info("Unsavedpopup");
      statusTracker(br,"","The officeanywhere Unsaved Pop Up ","",""); 
    //  driver.findElement(By.cssSelector("h3.ng-binding")),br);
     
      driver.findElement(By.id("pin1")).clear();
      driver.findElement(By.id("pin1")).sendKeys("4562");
      driver.findElement(By.id("pin2")).clear();
      driver.findElement(By.id("pin2")).sendKeys("4562");
      
      logger.info("TurnOFF");
      focusClick(driver,driver.findElement(By.linkText("Outgoing Calls")),br);
     Boolean CH= focusSearch(driver,driver.findElement(By.xpath("/html/body/div[3]/div/div[1]")),br);
       logger.info("pop up display");
       if(CH==true)
       {
                   focusClick(driver, driver.findElement(By.id("cancelSaveFeature")),br);
                  
        logger.info("pop up display1");
        
        if(driver.findElements(By.xpath("/html/body/section/div[4]/div[1]/h3")).size()>0)
        {
          logger.info("Success");
          statusTracker(br,"Pass","Verify if clicking on cancel navigating to officeanywhere Page","Successfully navigate back to officeanywhere Page on clicking cancel","Success");
        }   
        else
        {
          logger.info("Fail");
          statusTracker(br,"Fail","Cancel dint work","Unsuccessful","Unable to process successfully");
        }
       }  
    
       driver.findElement(By.id("pin1")).clear();
       driver.findElement(By.id("pin1")).sendKeys("4562");
       driver.findElement(By.id("pin2")).clear();
       driver.findElement(By.id("pin2")).sendKeys("4562");


        logger.info("TurnON");
        focusClick(driver, driver.findElement(By.linkText("Outgoing Calls")),br);
        
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
      focusClick(driver,driver.findElement(By.linkText("Mobility Package")),br);  
      focusClick(driver,driver.findElement(By.xpath("/html/body/section/div[4]/div[1]/div")),br);   
      statusTracker(br,"","The officeanywhere cancel Transactions ","",""); 
      driver.findElement(By.id("pin1")).clear();
      driver.findElement(By.id("pin1")).sendKeys("4562");    
      focusClick(driver, driver.findElement(By.cssSelector("button.btn.btn-secondary")),br);
      
      if(driver.findElements(By.xpath("/html/body/section/div[4]/div[1]/h3")).size()>0)
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
  
  public String OfficePin(String br,String pin, String confirmnewpin, String check,WebDriver driver) throws Exception
  {
                  
                  logger.info("Iam cumng too");
                  String schk="Fail";
                
      driver.findElement(By.id("pin1")).clear();  
      driver.findElement(By.id("pin1")).sendKeys(pin);
      driver.findElement(By.id("pin2")).clear();
      driver.findElement(By.id("pin2")).sendKeys(confirmnewpin);
    
      focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
      logger.info("after submitting");
      
      Thread.sleep(3000);
    //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      
      
      if((focusSearch(driver,driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/div[2]/div")),br)))
     {
                  logger.info("printing");
       statusTracker(br,"Pass","Verify if error message is displayed when adding "+check+" PIN","Error message is displayed:"+driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/div[2]/div")).getText(),"Error message should be displayed");
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


public String PinValidation(String br,WebDriver driver) throws Exception
  {
                
                  //String pin1 = randomNO(9999,1000);
                  String schk ="Fail";
                  String pin,pin2;
                  statusTracker(br,"","The officeanywhere Defect Validation","",""); 
                  schk=OfficePin(br,"","1234","Blank New ",driver);
                  
                 schk=OfficePin(br,"1234","","Blank Confirm Field",driver);
     Thread.sleep(2000);
    
     logger.info(phoneline_ac);
     phoneline_ac=phoneline_ac.substring(8);
                logger.info(phoneline_ac);
                schk=OfficePin(br,phoneline_ac,phoneline_ac,"Self",driver);
                  
                  schk=OfficePin(br,"3456","3456","Consecutive",driver);
                  logger.info("order done");
                  
                  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                  
                pin=randomNO(9,1);
                  pin=pin+pin+pin+pin;
                  logger.info("m not hapenning"+pin);
                  schk=OfficePin(br,pin,pin,"same digits",driver);
                  
                 
                  pin=randomNO(999,100);
                  schk=OfficePin(br,pin,pin,"less than 4 digit",driver);
                  logger.info("4 digits");
                // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                  
                  pin=randomNO(9999,1000);
                  pin2=randomNO(9999,1000);
                  schk=OfficePin(br,pin,pin2,"different confirm",driver);
      logger.info("different");
      //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       schk="Pass";
                  return schk;
  }

public void execute(String br, WebDriver driver, String url, int loc, String name1) throws Exception {
                 
                  Feature_Name="UserOfficeAnywhere";
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
              
                   logger.info("checkpoint3");
                  
                   focusClick(driver, driver.findElement(By.xpath("//section[@id='admin-homepage-shortcuts']/div/a[6]/span/div")),br);
                       
                       
                       
                       if(!(InternalException(driver,br)))
                   {

                       int count1=driver.findElements(By.xpath("//html/body/section/div")).size();
                   System.out.println("count here: " + count1);  
                       String featureName="Office Anywhere";
                   int featureOrder=FeatureListIncoming(driver,count1,featureName);

                   System.out.println("Feature Order " + featureOrder);  
                   
                   focusClick(driver, driver.findElement(By.cssSelector("#collapseFeature"+featureOrder+" > div.accordian-header > div.header-right")),br);
                    System.out.println("c");
                    phoneline_ac= Select_TN(driver,featureName,featureOrder,br);
                              System.out.println(phoneline_ac);
                              System.out.println(schk1);
                              logger.info("c");
                    
                   
                  if(schk1=="Pass")
                  {
                                logger.info("print");
                                  status1="On";
                                    state=turnoffon(br,driver, status1,phoneline_ac);
                                          
                                    state= PinValidation(br,driver);
                                    state=Unsavedpopup(br,driver, status1); 
                                    state=Cancel(br,driver, status1);                             
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
//      wb.close();
     
    }
  }
private By By(String attribute) {
                // TODO Auto-generated method stub
                return null;
}        

}