package DevVersionFeaturesFile.MobilityPackage.UserMode;



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
                
    String accst;
	String initialstate,chngetostate;
	String table, tns[];
    String tlimit,username,pwd;
    int tncount;				                        
    String butnxpath,accdcheck,AddnewNum,AddNum, Err;
    String TNxpath="//html/body/section/div[12]/div[2]/form/div[5]/div/label";
    String phoneline,phoneline_ac,Acccode,frntn,phoneline1;
    
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
                                  
                      focusClick(driver, driver.findElement(By.xpath(".//*[@id='collapseFeature5']/div[2]/div[1]/label")),br);
                                  
                      focusClick(driver, driver.findElement(By.xpath("//*[@id='collapseFeature5']/div[2]/form/div[2]/button[2]")),br);
                        	      

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
                          statusTracker(br,"Fail","Verify order process for changing status from: "+initialstate +" to: "+chngetostate,"The order failed to process"+ driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).getText(),"Unable to process successfully");
                        }
                      for(int i=1;i<50;i++){}
                      focusClick(driver, driver.findElement(By.xpath(".//*[@id='collapseFeature5']/div[2]/div[1]/label")),br);

                      //String num=randomNO(1111,5555);
                      driver.findElement(By.id("newNumber1")).clear();
                      driver.findElement(By.id("newNumber1")).sendKeys("9358462854");
                      
                      focusClick(driver, driver.findElement(By.xpath("//form[@name='selectiveCallReject']/div[1]//button[1]")),br);

                      do{
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                      focusClick(driver, driver.findElement(By.xpath("//*[@id='collapseFeature5']/div[2]/form/div[2]/button[2]")),br);
                      
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
                          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate,"The order failed to process"+ driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).getText(),"Unable to process successfully");
                        }
                      return state;
                  }
                  
                  public String turnOn(WebDriver driver, String status,String br) throws InterruptedException
                  {
                      String initialstate=status, chngetostate="On",state = "Fail";


                     if(driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]//div[1]/div[2]//a")).isDisplayed())
            	      {
            	        focusClick(driver, driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]//div[1]/div[2]//a")),br);
            	        Thread.sleep(2000);
            	      }
                                  
                      //String num=randomNO(1111,5555);
                      driver.findElement(By.id("newNumber1")).clear();
                      driver.findElement(By.id("newNumber1")).sendKeys("8326544689");
                      
                      focusClick(driver, driver.findElement(By.xpath("//form[@name='selectiveCallReject']/div[1]//button[1]")),br);
                                    do{

                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                    if(driver.findElement(By.cssSelector("section[class='inner-box ng-scope']")).isDisplayed())
                          		  {
                          			  logger.info("Success");
                          	          statusTracker(br,"Pass","Verify if the phone numbers are getting added ","The Phone number has been added Successfully ","Successfully processed order");
                          		  }
                          		  else
                          		  {
                          			  logger.info("Fail");
                          	          statusTracker(br,"Fail","Verify if the phone numbers are getting added ","The Phone number has not been added ","Thr order is failed to process");
                          		  }
                                    
                                    focusClick(driver, driver.findElement(By.xpath("//*[@id='collapseFeature5']/div[2]/div[1]/label")),br);
                      
                      focusClick(driver, driver.findElement(By.xpath("//*[@id='collapseFeature5']/div[2]/form/div[2]/button[2]")),br);
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
                          statusTracker(br,"Fail","Verify order process for changing status from: "+ initialstate +" to: "+chngetostate,"The order failed to process"+ driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).getText(),"Unable to process successfully");
                        }
                        
                        String initialstate1="On",chngetostate1="Off";
                        System.out.println("later"+initialstate);
                        System.out.println("later"+chngetostate);
                        
                      focusClick(driver, driver.findElement(By.xpath(".//*[@id='collapseFeature5']/div[2]/div[1]/label")),br);
                      
                      focusClick(driver, driver.findElement(By.xpath("//*[@id='collapseFeature5']/div[2]/form/div[2]/button[2]")),br);
                      
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
                          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate,"The order failed to process"+ driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).getText(),"Unable to process successfully");
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
                                      focusClick(driver, driver.findElement(By.xpath("//form[@name='selectiveCallReject']/div[1]//button[1]")),br);
                                                  
                                                  do{
                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                     }
                                  }
                                  focusClick(driver, driver.findElement(By.xpath("//*[@id='collapseFeature5']/div[2]/form/div[2]/button[2]")),br);

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
                          statusTracker(br,"Fail","Verify order process for editing TN","The order failed to process"+ driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).getText(),"Unable to process successfully");
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

                                                  focusClick(driver, driver.findElement(By.xpath("//*[@id='collapseFeature5']/div[2]/form/div[2]/button[2]")),br);

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
                                          statusTracker(br,"Fail","Verify order process for Deleting the TN","The order failed to process"+ driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).getText(),"Unable to process successfully");
                                        }
                                   }
                                    else
                                     {
                                                for(int i=1;i<5;i++){
                                                                String num=randomNO(1111,5555);
                                                      driver.findElement(By.id("newNumber1")).clear();
                                                      driver.findElement(By.id("newNumber1")).sendKeys(phoneline+num);
                                                      focusClick(driver,driver.findElement(By.xpath("//form[@name='selectiveCallReject']/div[1]//button[1]")),br);
                                                                  
                                                                  do{
                                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                                  }
                                                focusClick(driver, driver.findElement(By.xpath("//*[@id='collapseFeature5']/div[2]/form/div[2]/button[2]")),br);
                                      
                                      do{
                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                      focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/form/section/label/i")),br);

                                      focusClick(driver, driver.findElement(By.xpath("//*[@id='collapseFeature5']/div[2]/form/div[2]/button[2]")),br);

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
                                          statusTracker(br,"Fail","Verify order process for Deleting the TN","The order failed to process"+ driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).getText(),"Unable to process successfully");
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
                                                      focusClick(driver,driver.findElement(By.xpath("//form[@name='selectiveCallReject']/div[1]//button[1]")),br);
                                                                  
                                                                  do{
                                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                                  }
                                                  focusClick(driver, driver.findElement(By.xpath("//*[@id='collapseFeature5']/div[2]/form/div[2]/button[2]")),br);
                                                  
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
                                  focusClick(driver, driver.findElement(By.xpath("//*[@id='collapseFeature5']/div[2]/form/div[2]/button[2]")),br);
                                                  
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
                          statusTracker(br,"Fail","Verify order process for DeletAll","The order failed to process"+ driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).getText(),"Unable to process successfully");
                        }
                                  
                  }
                  
                  public void maxTN(WebDriver driver,String br) throws Exception
                  {
                                  int cnt;
                                  if(driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]//div[1]/div[2]//a")).isDisplayed())
                        	      {
                        	        focusClick(driver, driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]//div[1]/div[2]//a")),br);
                        	        Thread.sleep(2000);
                        	       
                        	          logger.info("Success");
                        	          statusTracker(br,"Pass","Verify order process for DeletAll","Successfully Deleted all the TN's","Successfully processed order");
                        	      }
                        		  
                  cnt=driver.findElements(By.xpath("//*[@id='collapseFeature5']/div[2]/form/section/label")).size();
                                  
                                  for(int i=cnt;i<30;i++){
                                                  //String num=randomNO(1111,5555);
                                                  int p=10;
                                    			  p = p+i;
                                    	  		  String phno = "72586654"+p;
                                    	  		  logger.info("Phone number to be added"+phno);
                                                  driver.findElement(By.id("newNumber1")).clear();
                                                  driver.findElement(By.id("newNumber1")).sendKeys(phno);
                                                focusClick(driver,driver.findElement(By.xpath("//form[@name='selectiveCallReject']/div[1]//button[1]")),br);
                                                  
                                                  do{
                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                  }
                                  
                                  focusClick(driver, driver.findElement(By.xpath("//*[@id='collapseFeature5']/div[2]/form/div[2]/button[2]")),br);
                                  do{
                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                  
                                  int cnt1=driver.findElements(By.xpath("//*[@id='collapseFeature5']/div[2]/form/section/label")).size();
                                  
                        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                      {
                        logger.info("Success");
                       statusTracker(br,"Pass","Verify order process for adding 30 TN's and count is: "+cnt1,"Successfully be able to process order","Successfully processed order");
                      }
                      else
                      {
                        logger.info("Fail");
                        statusTracker(br,"Fail","Verify order process for adding 30 TN's and count is: "+cnt1,"The order failed to process"+ driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).getText(),"Unable to process successfully");
                      }
                                  
                                  logger.info("Trying to add more than 30 Phone numbers");
                        		  
                        		  driver.findElement(By.id("newNumber1")).clear();
                          		  driver.findElement(By.id("newNumber1")).sendKeys("5213265440");
                          		focusClick(driver,driver.findElement(By.xpath("//form[@name='selectiveCallReject']/div[1]//button[1]")),br);
                        		  do{
                        	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                        		  
                        		  if(driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).isDisplayed())
                        	   	  {
                        	   		  statusTracker(br,"Pass","Verify if error message is displayed when adding more than 30 TN","Error message is displayed: "+ driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).getText(),"Error message should be displayed");
                        	   		  Thread.sleep(2000);
                        	   		  driver.findElement(By.id("newNumber1")).clear();
                        	   	  }
                        	   	  else
                        	   	  {
                        	   	  	  statusTracker(br,"Fail","Verify if error message is displayed when adding more than 30 TN","Error message is not displayed","Error message should be displayed");
                        	   	  }
                        		  
                        		  
                        		  String num1=randomNO(1111,5555);
                        		  driver.findElement(By.id("newNumber1")).clear();
                        		  driver.findElement(By.id("newNumber1")).sendKeys(phoneline+num1);
                        		  focusClick(driver,driver.findElement(By.xpath("//form[@name='selectiveCallReject']/div[1]//button[1]")),br);

                        		  Thread.sleep(2000);
                        		  if(driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).isDisplayed())
                        	   	  {
                        	   		  statusTracker(br,"Pass","Verify if error message is displayed when adding wrong TN","Error message is displayed: "+ driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).getText(),"Error message should be displayed");
                        	   		  Thread.sleep(2000);
                        	   		  driver.findElement(By.id("newNumber1")).clear();
                        	   	  }
                        	   	  else
                        	   	  {
                        	   	  	  statusTracker(br,"Fail","Verify if error message is displayed when adding wrong TN","Error message is not displayed","Error message should be displayed");
                        	   	  }
                        		  
                        		  
                  }
                  
                  public String TNcheck2(String Tn, WebDriver driver,String br) throws Exception
                  {
                         String schk="Fail";
                         driver.findElement(By.name("newNumber1")).clear();
                         driver.findElement(By.name("newNumber1")).sendKeys(Tn); 
                         
                         focusClick(driver,driver.findElement(By.xpath("//form[@name='selectiveCallReject']/div[1]//button[1]")),br);
                         
                         do{
                         }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                         
                         if(driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).isDisplayed())
                         {
                                 statusTracker(br,"Pass","Verify if error message is displayed when adding "+Tn+" TN/Acc code","Error message is displayed: "+ driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).getText(),"Error message should be displayed");
                                 schk="Pass";
                          }
                          else
                          {
                                 statusTracker(br,"Fail","Verify if error message is displayed when adding "+Tn+" TN","Error message is not displayed","Error message should be displayed");
                                 schk="Fail";
                          }
                         return schk;
                  }  
                  
                  public void DeleteTn(WebDriver driver,String br) throws Exception
            	  { int chk=0;
            		  int cnt;
            		  cnt=driver.findElements(By.xpath("//*[@id='collapseFeature5']/div[2]/form/section/label")).size();
            		  logger.info("The total number of phone numbers present: "+cnt);
            		  for(int i=1; i<= cnt; i++)
            		  {
            			  focusClick(driver,driver.findElement(By.xpath("//section[@class='inner-box ng-scope']/label[1]")),br);
            		  }
            		  
            		  focusClick(driver, driver.findElement(By.xpath(".//*[@id='collapseFeature5']/div[2]/div[1]/label")),br);
            		  Thread.sleep(3000);
            		  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature5']/div[2]/form/div[2]/button[2]")),br);
              		  
            		  do{
            	          chk++;
            	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

            	        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
            	        {
            	          logger.info("Success");
            	          statusTracker(br,"Pass","Verify order process for Deleting all the Phone numbers one by one","Successfully be able to process order","Successfully processed order");
            	        }
            	        else
            	        {
            	          logger.info("Fail");
            	          statusTracker(br,"Fail","Verify order process for Deleting all the Phone numbers one by one","Thr order is failed to process"+ driver.findElement(By.xpath("//div[@id='collapseFeature5']/div[2]/div[2]/div[@class='message-box']")).getText(),"Unable to process successfully");
            	        }
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
                         focusClick(driver, driver.findElement(By.xpath("//*[@id='collapseFeature5']/div[2]/form/div[2]/button[1]")),br);
                         do{
                         }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                         
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

            	              if(driver.findElement(By.cssSelector("a[href='/UserMain/UserCallSettings']")).isDisplayed())
                    		  {
                    			  statusTracker(br,"Pass","Verifying Whether the home page is displayed","Successfully Logged into VoiceManager application, home page is displayed","");
                    		  }
                    		  else
                    		  {
                    			  statusTracker(br,"Fail","Verifying Whether the home page is displayed","Could not Log into VoiceManager application, home page is not displayed","");
                    		  }
            	              logger.info("checkpoint1");
                              
                              for(int i=1;i<20;i++){}
                              Acccode=driver.findElement(org.openqa.selenium.By.xpath("//html/body/section/section/div[1]/aside[1]/ul/li[1]/strong")).getText();
                              logger.info("Acccode"+Acccode);
                              
                              focusClick(driver,driver.findElement(By.cssSelector("a[href='/UserIncomingCalls/IncomingCalls']")),br);
                             
                            	  int featureOrder=0;String featureName="SCR";
                            	  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature5']//h3")),br);    	  
            							System.out.println("c");

            							int divval=3;
            							try
             	       					{
            								if(driver.findElement(By.xpath(".//*[@id='collapseFeature5']/div[3]/div/h2")).isDisplayed())
            								{
            									statusTracker(br,"","SCR Modal pop up is  displayed","","");
            									divval=3;
            								}
             	       					}
             	       					catch(Exception e)
             	       					{
             	       						statusTracker(br,"","SCR Modal pop up is not displayed.","","");
             	       						first=1;
             	       					}												
               	  
                              boolean status= driver.findElement(By.id("toggleButton25")).isSelected();
                              int cnt;
                              
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
                              maxTN(driver,br);
                          	  DeleteTn(driver,br); 
                      	  	  TNValidation(driver,br);
                              
                      
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
            	    	      wb.close();
            	    	      //driver.close();
            	    	     
            	    	    }
            	    	  }
            	    	  
            	    	  private boolean isElementPresent(WebDriver driver, By xpath) {
            	    		// TODO Auto-generated method stub
            	    		return false;
            	    	}
            	    	}

