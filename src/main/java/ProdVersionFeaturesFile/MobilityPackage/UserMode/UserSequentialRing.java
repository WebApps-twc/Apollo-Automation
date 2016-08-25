package ProdVersionFeaturesFile.MobilityPackage.UserMode;

import com.thoughtworks.selenium.Selenium;

import ProdVersionFeaturesFile.CommonFunctions;

import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;


public class UserSequentialRing extends CommonFunctions 
{
                String table, tns[];
                String tlimit,username,pwd,schk1;
                int tncount;
                String phoneline,phoneline_ac,phoneline_midtn,phoneline_lastfour;
                String Acccode;
                Boolean status1=null;
                String Enabled;
                int chk=0;
                
                
                public UserSequentialRing(String path) {
                                this.path = path;
                }

                public UserSequentialRing(String path, String file1, String file2) {
                                this.path = path;
                                this.path1 = file1;
                                this.path2 = file2;
                }
     public String Select_TN(WebDriver driver,String Featurename,int count, String br)
                                {
                                Featurename="{\"name\":\"SequentialRing_FeatureName\",\"value\":\"Sequential Ring\",\"parameters\":[],\"text\":\"Sequential Ring\",\"exampleText\":\"Sequential Ring\"}";
                                                int numberOfTns=countNumberTns(count,Featurename,driver,br);
                                                System.out.println(numberOfTns);
                                                String TN="";
                                                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                                                for(int j=0;j<numberOfTns;j++)
                                                {
                                                                try
                                                                {
                                                                if(focusSearch(driver,driver.findElement(By.xpath("//html/body/section/div["+(4+count)+"]/div[2]/form/div["+(6+j)+"]/i")),br))
                                                                {
                                                                                System .out.println("TN is suspended");
                                                                                continue;
                                                                }
                                                                else if(driver.findElement(By.id("check"+Featurename+j)).isSelected())
                                                                { 
                                                                                System.out.println("tn2");

                                                                                
                                                                             TN=driver.findElement(By.xpath("//html/body/section/div["+(4+count)+"]/div[2]/form/div["+(6+j)+"]/label")).getText();    
                                                                schk1="Pass";
                                                                break;
                                                            
                                                                }
                                                                else
                                                                {
                                                                                /*driver.findElement(By.id("check"+Featurename+j)),br);*/
                                                                                focusClick(driver,driver.findElement(By.xpath("//html/body/section/div["+(4+count)+"]/div[2]/form/div["+(6+j)+"]/label")),br);
                                                                                focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature"+count+" > div.accordian-body.in > form[name=\"featureForm\"] > div.accordian-actions > button.btn.btn-primary")),br);
                                                                   int chk=0;
                                                                                do{
                                 
                                                                                                
                                 chk++;
                               }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
                             if(focusSearch(driver,driver.findElement(By.id("dataSaveSucess")),br))
                             {
                                             TN=driver.findElement(By.xpath("//html/body/section/div["+(4+count)+"]/div[2]/form/div["+(6+j)+"]/label")).getText();    
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
           public int countNumberTns(int featureOrder, String featureName, WebDriver driver,String br)
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
                                 
  public String SequentialRingOff(String br,WebDriver driver,String status) throws Exception
  {
                  String state="Fail";
                  String schk ="Fail";
                  String initialstate="On", chngetostate="Off";
                  String pin=randomNO(9999,1000); 
                  focusClick(driver,driver.findElement(By.linkText("Switch to User mode")),br);
                  
                  focusClick(driver,driver.findElement(By.xpath("//section[@id='homepage-shortcuts']/div/a[5]/span/div")),br);
                 logger.info(Enabled);
                 focusDropdown(driver,"//html/body/header/div[4]/div[3]/div/div/span",phoneline_ac,br);
                 //new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(phoneline_ac);

                 logger.info("done");
                  
                 focusClick(driver, driver.findElement(By.xpath("//html/body/section/div[6]/div[1]/h3")),br);
  
                  
                  status1= focusSearch(driver,driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[5]/label")),br);
            System.out.println(status1);
                                  System.out.println("AAAAAAAAAAAAAAAAAAA");    
                  
                  if(status1==true)
                  {
                                  statusTracker(br,"","The SequentialRing is having Verified Account code","",""); 
                                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).clear();
                                  if(driver.findElement(By.id("checkSim2")).isSelected())
                                  {
                                                 logger.info("enabled");
                                                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).clear();
                                                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).sendKeys("816425"+pin);
                                                  focusClick(driver,driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[5]/label")),br);
                                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[6]/input")).clear();
                          driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[6]/input")).sendKeys(Acccode);
                          //new Select(driver.findElement(By.xpath("//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div[2]/div[7]/span/select"))).selectByVisibleText("4");
                          focusDropdown(driver,"//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div[2]/div[7]/span","4",br);
                                  }
                                                
                                  
                                  else
                                  {
                                                  System.out.println("AAAAAAAAAAAAAAAAAAA1");
                                                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).clear();
                                                  System.out.println("AAAAAAAAAAAAAAAAAAA2");
                                                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).sendKeys("816425"+pin);
                                                  //new Select(driver.findElement(By.xpath("//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div[2]/div[7]/span/select"))).selectByVisibleText("3");
                                                  focusDropdown(driver,"//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div[2]/div[7]/span","3",br);
                                  }
                                  focusClick(driver, driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[1]/label/span[1]")),br);
                                  focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature2 > div.accordian-body.in > div.ng-scope > form[name=\"featureForm\"] > div.accordian-actions > button.btn.btn-primary")),br);      
                                                do{
                                 
                                                                                                
                                 chk++;
                               }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
                  }
                  
                  boolean AccCode= focusSearch(driver,driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[6]/input")),br);   
                  boolean LocalCalls= focusSearch(driver,driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[5]/label")),br);
                  
                  if(AccCode==true && LocalCalls==false)
                  {
                                  statusTracker(br,"","The SequentialRing is having Unverified Account code","","");   
                                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).clear();
                                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).sendKeys("816425"+pin);
                      driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[6]/input")).sendKeys("17687"+pin);
                      //new Select(driver.findElement(By.xpath("//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div[2]/div[7]/span/select"))).selectByVisibleText("3");
                      focusDropdown(driver,"//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div[2]/div[7]/span","3",br);
                    //  driver.findElement(By.cssSelector("#collapseFeature2 > div.accordian-body.in > div.ng-scope > form[name=\"featureForm\"] > div.accordian-actions > button.btn.btn-primary")),br);
                                  
                  }  
                  
                  if(AccCode==false && LocalCalls==false)
                  {
                                  statusTracker(br,"","The SequentialRing is having No Account code","","");   
                                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).clear();
                                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).sendKeys("816425"+pin);
                                  //new Select(driver.findElement(By.xpath("//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div[2]/div[7]/span/select"))).selectByVisibleText("5");
                                  focusDropdown(driver,"//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div[2]/div[7]/span","5",br);
                  }
                  
                  focusClick(driver,  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[1]/label/span[1]")),br);
                  focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature2 > div.accordian-body.in > div.ng-scope > form[name=\"featureForm\"] > div.accordian-actions > button.btn.btn-primary")),br);    
                  do{                                                                       
                                chk++;
                              }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
                 logger.info(" M executed");
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
                 
                  
                  Thread.sleep(5000);
                   
                  if(AccCode==true)
                  {
                 
                 
                  statusTracker(br,"","The Error Validation of SequntialRing for TNS having Account code","","");  
                 
                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[6]/input")).clear();
                   schk=SequentialRing(br,"81642573333","Without entering Account Code",driver);
                   
                  Thread.sleep(5000);
                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).clear();
                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[6]/input")).sendKeys(Acccode);
                  schk=SequentialRing(br,"","Without entering Phone Number",driver);
              }
          return state;
  }
  public String SequentialRingOn(String br,WebDriver driver,String status) throws Exception
  {
                  String state="Fail";
                  String schk ="Fail";                                                                                                                                                                                                                                                                                         
                  String initialstate="Off", chngetostate="On";
                  String pin=randomNO(9999,1000);            
                    
                  status1=focusSearch(driver, driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[5]/label")),br);
                 System.out.println(status1);;
                  
                 focusClick(driver,  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[1]/label/span[1]")),br);
                 focusClick(driver, driver.findElement(By.cssSelector("#collapseFeature2 > div.accordian-body.in > div.ng-scope > form[name=\"featureForm\"] > div.accordian-actions > button.btn.btn-primary")),br);    
                do{
                                 
                                                                                
                                 chk++;
                               }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
                 logger.info(" M executed1");
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
                 

        
          return state;
  }  

  public String SequentialRingEditTNs(String br,WebDriver driver,String status) throws Exception
  {
                  String state="Fail";
      String schk ="Fail";
      String initialstate="On", chngetostate="Off";
      String pin;

      
      
     // driver.findElement(By.cssSelector("#collapseFeature2 > div.accordian-header > div.header-right")),br);

      status1= focusSearch(driver,driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[5]/label")),br);
      System.out.println(status1);
    
      
     if(status1==true)
     {
                  statusTracker(br,"","The SequentialRing is having Verified Account code","",""); 
                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).clear();
                  
                  if(driver.findElement(By.id("checkSim2")).isSelected())
                  {
                                  pin=randomNO(9999,1000); 
                                  
                                  for(int j=2;j<=6;j++)
                        { 
                                                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div["+j+"]/div[4]/input")).clear();
                                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div["+j+"]/div[4]/input")).sendKeys("816425"+pin);
                 
                                  focusClick(driver,driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div["+j+"]/div[5]/label")),br);
                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div["+j+"]/div[6]/input")).clear();
              driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div["+j+"]/div[6]/input")).sendKeys(Acccode);
              //new Select(driver.findElement(By.xpath("//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div[2]/div[7]/span/select"))).selectByVisibleText("4");
              focusDropdown(driver,"//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div[2]/div[7]/span","4",br);
              statusTracker(br,"Pass","Able to add and Edit the TNS in the" +j+ "position to the list","Successfully be able to process order","Successfully processed order"); 
              Thread.sleep(5000);}
                  
                  }
                  else
                  {
                                  for(int j=2;j<=6;j++)
                                  {
                                                  pin=randomNO(9999,1000); 
                                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div["+j+"]/div[4]/input")).sendKeys("816425"+pin);
                                  //new Select(driver.findElement(By.xpath("//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div[2]/div[7]/span/select"))).selectByVisibleText("3");
                                  focusDropdown(driver,"//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div[2]/div[7]/span","3",br);
                                  Thread.sleep(5000);
                                  statusTracker(br,"Pass","Able to add and Edit the TNS in the" +j+ "position to the list","Successfully be able to process order","Successfully processed order");}}
                  
     }
     focusClick(driver, driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[1]/label/span[1]")),br);
     focusClick(driver,  driver.findElement(By.cssSelector("#collapseFeature2 > div.accordian-body.in > div.ng-scope > form[name=\"featureForm\"] > div.accordian-actions > button.btn.btn-primary")),br);      
                do{
        
                                
        chk++;
      }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
                 
      
      
      boolean AccCode= focusSearch(driver,driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[6]/input")),br);   
      boolean LocalCalls=focusSearch(driver, driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[5]/label")),br);
     

      if(AccCode==true && LocalCalls==false)
      {
                  
                  statusTracker(br,"","The SequentialRing is having Unverified Account code","","");   
                 logger.info("Cumng here");
                  for(int j=2;j<=6;j++)
                         {  
                      System.out.println(j);
                                 pin=randomNO(9999,1000); 
                                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div["+j+"]/div[4]/input")).sendKeys("816425"+pin);
  
                                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div["+j+"]/div[6]/input")).sendKeys("17687"+pin);
              //new Select(driver.findElement(By.xpath("//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div[2]/div[7]/span/select"))).selectByVisibleText("1");
              focusDropdown(driver,"//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div[2]/div[7]/span","1",br);
              Thread.sleep(5000); statusTracker(br,"Pass","Able to add the" +j+ "TN to the list","Successfully be able to process order","Successfully processed order");
                        } 
      }  
      
      
     

      if(AccCode==false && LocalCalls==false)
      {
                  
                  statusTracker(br,"","The SequentialRing is having No Account code","","");   
                  for(int j=2;j<=6;j++)
                         {  
                                  pin=randomNO(9999,1000); 
                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div["+j+"]/div[4]/input")).sendKeys("816425"+pin);
                  //new Select(driver.findElement(By.xpath("//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div["+j+"]/div[7]/span/select"))).selectByVisibleText("1");
                  focusDropdown(driver,"//div[@id='collapseFeature2']/div[2]/div[5]/form/section/div[2]/div["+j+"]/div[7]/span","1",br);
                  Thread.sleep(5000);statusTracker(br,"Pass","Able to add and Edit the TNS in the" +j+ "position to the list","Successfully be able to process order","Successfully processed order");
      }
      }
     // driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[1]/label/span[1]")),br);
      Thread.sleep(5000);
      focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature2 > div.accordian-body.in > div.ng-scope > form[name=\"featureForm\"] > div.accordian-actions > button.btn.btn-primary")),br);    
                
                do{
        
                                
        chk++;
      }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
      if(driver.findElements(By.id("dataSaveSucess")).size()>0)
      {
       logger.info("Success");
        statusTracker(br,"Pass","Verify whether 5 tns are added to TN's list","Successfully be able to process order","Successfully processed order");
      }
       else
      {
       logger.info("Fail");
        statusTracker(br,"Fail","Verify order process for changing status from:"+initialstate+ "to:"+chngetostate,"Successfully be able to process order","Unable to process successfully");
      }
      
      
/*     if(status1==true || LocalCalls==false)
  {
                  statusTracker(br,"","The Error Validation of Speed Dial for TNS having Account code","","");  
                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[4]/span/input")).clear();
                  schk=SpeedDialNumbers("81642578343","Without entering Account Code",driver);
                  driver.findElement(By.xpath("/html/body/section/div[4]/div[2]/form/section/div[2]/div[1]/div[4]/span/input")).sendKeys(Acccode);
                  schk=SpeedDialNumbers("","Without entering Phone Number",driver);
}
  }*/
return state;

  }
  
  
  
  public String Unsavedpopup(String br,WebDriver driver, String status) throws InterruptedException
  {
                  String state="Fail";
     logger.info("Unsavedpopup");
      statusTracker(br,"","The Sequential Ring Unsaved Pop Up ","",""); 
    //  driver.findElement(By.cssSelector("h3.ng-binding")),br);
     
      driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).clear();
      driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).sendKeys("81111");
      focusClick(driver,  driver.findElement(By.linkText("Incoming Calls")),br);

     Boolean CH= focusSearch(driver,driver.findElement(By.xpath("/html/body/div[3]/div")),br);
      logger.info("pop up display");
       if(CH==true)
       {
                   focusClick(driver,driver.findElement(By.id("cancelSaveFeature")),br);
                  
                  
       logger.info("pop up display1");
        
        if(driver.findElements(By.xpath("/html/body/section/div[6]/div[1]/h3")).size()>0)
        {
         logger.info("Success");
          statusTracker(br,"Pass","Verify if clicking on cancel navigating to SequentialRing Page","Successfully navigate back to SequentialRing Page on clicking cancel","Success");
        }   
        else
        {
         logger.info("Fail");
          statusTracker(br,"Fail","Cancel dint work","Unsuccessful","Unable to process successfully");
        }
       }  
       Thread.sleep(1000);
     
       logger.info("TurnON");
        
      
       focusClick(driver,driver.findElement(By.linkText("Incoming Calls")),br);
        
       focusClick(driver, driver.findElement(By.xpath("//a[@id='unsavedFeature']/span")),br);
       
         
         if(driver.findElements(By.xpath("/html/body/section/div[4]/div[1]/h3")).size()>0)
         {
                 statusTracker(br,"Pass","Verify if clicking on OK navigating to Incoming Calls Page","Successfully navigated to Incoming calls Page on clicking OK","Success");
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
      statusTracker(br,"","The SequentialRing cancel Transactions ","",""); 
  
   //   driver.findElement(By.cssSelector("#collapseFeature2 > div.accordian-header > div.header-right")),br);
      driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).clear();
      driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).sendKeys("81111");
      focusClick(driver, driver.findElement(By.cssSelector("#collapseFeature2 > div.accordian-body.in > div.ng-scope > form[name=\"featureForm\"] > div.accordian-actions > button.btn.btn-secondary")),br);
      
      if(driver.findElements(By.xpath("/html/body/section/div[6]/div[1]/div")).size()>0)
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
  
  public String SequentialRing(String br,String Number, String check,WebDriver driver) throws Exception
  {
                  

                  String schk="Fail";
                
                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).clear();
                  driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).sendKeys(Number);
    
                  focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature2 > div.accordian-body.in > div.ng-scope > form[name=\"featureForm\"] > div.accordian-actions > button.btn.btn-primary")),br);
                                do{
            
                                                
            chk++;
          }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
     logger.info("after submitting");
      
      Thread.sleep(1000);
    
      if((focusSearch(driver,driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[3]/div")),br)))
     {
                logger.info("printing");
       statusTracker(br,"Pass","Verify if error message is displayed when adding "+check+" Number","Error message is displayed:"+driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[3]/div")).getText(),"Error message should be displayed");
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


public String SequentialRingValidation(String br,WebDriver driver) throws Exception
  {
                
                System.out.println("iam cumng");
                  //String pin1 = randomNO(9999,1000);
                  String schk ="Fail";
                  focusClick(driver,driver.findElement(By.linkText("Mobility Package")),br);
                  focusClick(driver,  driver.findElement(By.cssSelector("#collapseFeature2 > div.accordian-header > div.header-right")),br);
                  statusTracker(br,"","The Sequential Ring Validation","",""); 

     logger.info("Sequential Ring");
      String pin=randomNO(9999999,100000000); 
                  schk=SequentialRing(br,"0","Number starting with 0",driver);
                  schk=SequentialRing(br,"1","Number starting with 1",driver);
                  schk=SequentialRing(br,"900"+pin,"Number starting with 900",driver);
                  schk=SequentialRing(br,"976"+pin,"Number starting with 976",driver);
                  schk=SequentialRing(br,"242"+pin,"Number starting with 242",driver);
                  schk=SequentialRing(br,"246"+pin,"Number starting with 246",driver);
                  schk=SequentialRing(br,"264"+pin,"Number starting with 264",driver);
                  schk=SequentialRing(br,"268"+pin,"Number starting with 268",driver);
                  schk=SequentialRing(br,"284"+pin,"Number starting with 284",driver);
                  schk=SequentialRing(br,"345"+pin,"Number starting with 345",driver);
                  schk=SequentialRing(br,"441"+pin,"Number starting with 441",driver);
                  schk=SequentialRing(br,"473"+pin,"Number starting with 473",driver);
                  schk=SequentialRing(br,"649"+pin,"Number starting with 649",driver);
                  schk=SequentialRing(br,"664"+pin,"Number starting with 664",driver);
                  schk=SequentialRing(br,"758"+pin,"Number starting with 758",driver);
                  schk=SequentialRing(br,"767"+pin,"Number starting with 767",driver);
                  schk=SequentialRing(br,"784"+pin,"Number starting with 784",driver);
                  schk=SequentialRing(br,"809"+pin,"Number starting with 809",driver);
                  Thread.sleep(3000);
                  schk=SequentialRing(br,"829"+pin,"Number starting with 829",driver);
                  schk=SequentialRing(br,"868"+pin,"Number starting with 868",driver);
                  schk=SequentialRing(br,"849"+pin,"Number starting with 849",driver);
                  schk=SequentialRing(br,"869"+pin,"Number starting with 869",driver);
                  schk=SequentialRing(br,"876"+pin,"Number starting with 876",driver);
                  
   
                 schk=SequentialRing(br,phoneline_ac,"SelfTN Error",driver);
                System.out.println("Checking"+phoneline_ac);  
                  schk=SequentialRing(br,"816425","Less Than 10 Digits",driver);
                logger.info("order done");
                   
      //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       schk="Pass";
                  return schk;
  }
public String SequentialRingSort(String br,WebDriver driver,String status) throws Exception
{
                
                String state="Fail";
   logger.info("Sorting");
    String pin=randomNO(9999,1000); 
    
  //  driver.findElement(By.cssSelector("#collapseFeature2 > div.accordian-header > div.header-right > span.accordian-info.ng-binding")),br);
    statusTracker(br,"","The SequentialRing Sort Transactions ","","");
    driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).clear();
    driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[2]/div[4]/input")).sendKeys(816425+pin);
    
    
    
    for(int k=2; k<6;k++)
    {
                int l=k+1;
                System.out.println(k);
                System.out.println(l);
                    focusClick(driver,driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div["+k+"]/div[1]/span[2]")),br);
                statusTracker(br,"","Sorting TNS from Top To Bottom from "+k+"th position to "+l+"th position" ,"Able to sort the TNS from Top to Bottom","Success");
    }

   
   driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[6]/div[4]/input")).clear();
   driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div[6]/div[4]/input")).sendKeys(816426+pin);
    
   for(int k=6;k>=3;k--)
    {
                
                int j=k-1;
                System.out.println(k);
                System.out.println(j);
                focusClick(driver,                driver.findElement(By.xpath("/html/body/section/div[6]/div[2]/div[5]/form/section/div[2]/div["+k+"]/div[1]/span[1]")),br);
                statusTracker(br,"","Sorting TNS from Bottom to top from "+k+"th position to "+j+"th position" ,"Able to sort the TNS from Bottom to top","Success");
                
    }
   
   focusClick(driver, driver.findElement(By.cssSelector("#collapseFeature2 > div.accordian-body.in > div.ng-scope > form[name=\"featureForm\"] > div.accordian-actions > button.btn.btn-primary")),br);
                do{
        
                                
        chk++;
      }while(focusSearch(driver,driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")),br));
   if(driver.findElements(By.id("dataSaveSucess")).size()>0)
    {
                 statusTracker(br,"Pass","Verify if Sorting the Tns from top to bottom and Bottom to top is successful","Successfully sorted to First Position ","Success");
           state="Pass";
   }
    else
   {
    logger.info("Fail");
     statusTracker(br,"Fail","OK dint work in Unsaved Pop Up","Unsuccessful","Unable to process successfully"); 
    
   } 
                return state; 
}


public void execute(String br, WebDriver driver, String url, int loc, String name1) throws Exception {
                 

                  Feature_Name="UserSequentialRing";
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
                 logger.info("User Sequential Ring");
                 if(!(InternalException(driver,br)))
                 {

                 switchTo(driver, "Admin",tlim,br);
                 focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]")),br);
                 logger.info("checkpoint5");
                  for(int i1=1;i1<20;i1++){}
                 Acccode=driver.findElement(By.xpath("//html/body/section/section/div[1]/aside[1]/ul/li[1]/strong")).getText();
                 logger.info("Acccode"+Acccode);
                  
                  
                  for(int i=1;i<30;i++){}
                  focusClick(driver,  driver.findElement(By.xpath("//section[@id='admin-homepage-shortcuts']/div/a[6]/span/div")),br);
                   

                  if(!(InternalException(driver,br)))
                  {

                  int count1=driver.findElements(By.xpath("//html/body/section/div")).size();
                  System.out.println("count here: " + count1);   
                  String featureName="Sequential Ring";
                  int featureOrder=FeatureListIncoming(driver,count1,featureName);

                  System.out.println("Feature Order " + featureOrder);  
                  
                  focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature"+featureOrder+" > div.accordian-header > div.header-right")),br);
                   System.out.println("c");
                   phoneline_ac= Select_TN(driver,featureName,featureOrder,br);
                             System.out.println(phoneline_ac);
                             System.out.println(schk1);
                             logger.info("c");
                   
                  
                 if(schk1=="Pass")
                 {
                                        status1="off";
                                       System.out.println("print");
                                                                                
                                 state=SequentialRingOff(br,driver,status1);
                                                 state=SequentialRingOn(br,driver,status1);
                                                 state=SequentialRingEditTNs(br,driver,status1);
                                                 Thread.sleep(5000);
                                    state=Unsavedpopup(br,driver,status1);                            
                                    state=SequentialRingValidation(br,driver);  
                                     state=SequentialRingSort(br,driver,status1);
                                      state=Cancel(br,driver,status1); 
                  }
               
                    switchTo(driver, "Admin",tlim,br);
                    
                    System.out.println("else");
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
                //statusTracker(br,"end","","");
//      wb.close();
     
    }
  }


                // TODO Auto-generated method stub
                
}
