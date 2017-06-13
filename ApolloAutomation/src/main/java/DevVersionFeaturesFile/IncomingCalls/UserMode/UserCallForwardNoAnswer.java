package DevVersionFeaturesFile.IncomingCalls.UserMode;



import DevVersionFeaturesFile.CommonFunctions;

import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class UserCallForwardNoAnswer extends CommonFunctions {
	
	String table,TN1, tns[];
    String tlimit,username,pwd;
    int tncount;				
	
	String butnxpath="//html/body/section/div[5]/div[2]/div[4]/div[1]/div[4]/form/div/div[1]/div/div/div/label";
    String svexpath="form[name=callForwardNoAnswerForm] > div.col-16 > div.accordian-actions > button.btn.btn-primary";
    String Tnxpath="//div[@id='collapseFeature3']/div[2]/form/div[5]/div/label";
    String phoneline,phoneline_ac,Acccode;
	int rank[]= new int[50];
	

	int c_sequence;
	String name_for_rank[]= new String[40];
	String price, rank_channels;

	public UserCallForwardNoAnswer(String path) {
		this.path = path;
	}

	public UserCallForwardNoAnswer(String path, String file1, String file2) {
		this.path = path;
		this.path1 = file1;
		this.path2 = file2;
	}
		 
	
	public String turnoff(WebDriver driver, String status, String acc,String br)
	  {
		  String initialstate=status, chngetostate="Off",state="Fail", accst=acc;
		  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature1']/div[2]/div[4]/div/div[4]/form//div/label/span[2]")),br);
		  
		  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[4]//div[4]/button[2]")),br);
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
		  
	      focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature1']/div[2]/div[4]/div/div[4]/form//div/label/span[2]")),br);
	      String num=randomNO(3333,6666);
	      driver.findElement(By.name("callForwardNoAnswerTo")).clear();
	      driver.findElement(By.name("callForwardNoAnswerTo")).sendKeys("7528654862");
	     
	      focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[4]//div[4]/button[2]")),br);
	      
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
 		 
 		  logger.info("Turn On");
 			  
 		     driver.findElement(By.xpath("//div[@id='collapseFeature1']/div[2]/div[4]/div/div[4]/form//div/label/span[2]")).click();

 		     driver.findElement(By.name("callForwardNoAnswerTo")).clear();
 		//TN=TN+randomNO(3333,9999);
 		   driver.findElement(By.name("callForwardNoAnswerTo")).sendKeys("8659889546");

 		   focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[4]//div[4]/button[2]")),br);
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
 	  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature1']/div[2]/div[4]/div/div[4]/form//div/label/span[2]")),br);
	  
	  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[4]//div[4]/button[2]")),br);
      do{	          
          chk++;
        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	     {
	     
	       statusTracker(br,"Pass","Verify order process for changing from ON to OFF with non verified Account code "," Successfully be able to process order ","Successfully processed order");                                                                   
	       status="Pass";
	     }
	      else
	     {
	    
	       statusTracker(br,"Fail","Verify order process for changing from ON to OFF with non verified Account code ","Not able to process order","Successfully processed order");
	       status="Fail";
	     }
 	 return status;
 	  }
	  
	  public String turnOnold(WebDriver driver, String status, String acc,String br)
	  {
	      String initialstate=status, chngetostate="On",state = "Fail", accst=acc;
	      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
		  String num=randomNO(3333,6666);
		  driver.findElement(By.name("callForwardNoAnswerTo")).clear();
		  driver.findElement(By.name("callForwardNoAnswerTo")).sendKeys(phoneline+num);
		  
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
	        focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
	      
	      for(int i1=1;i1<100;i1++){}
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
	  
	  public void EditTn(WebDriver driver,String br)
	  {
		  driver.findElement(By.name("callForwardNoAnswerTo")).clear();
		  driver.findElement(By.name("callForwardNoAnswerTo")).sendKeys("5482546582");
		  for(int i=1;i<10;i++){}
		  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[4]//div[4]/button[2]")),br);
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
	          statusTracker(br,"Fail","Verify order process for editing TN","Unable to process order" + driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div/div")).getText(),"Unable to process successfully");
	        }
	  }
	  
	  public String TNcheck(String ac, String acode,WebDriver driver, int check,String br) throws Exception
	  {
	         String schk="Fail";
	         int check1=check;
	         driver.findElement(By.name("callForwardNoAnswerTo")).clear();
	         driver.findElement(By.name("callForwardNoAnswerTo")).sendKeys(ac);       
	          
	         focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[4]//div[4]/button[2]")),br);
	                 
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
	  public String TNValidation(WebDriver driver, int a,String br) throws Exception
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
	  
	  public void numrngs(WebDriver driver,String br,String drpval) throws Exception
	  {
		  String n=randomNO(1,4);
		  focusClick(driver,driver.findElement(By.xpath(drpval+"/span[1]/select/option["+n+"]")),br);
	      Thread.sleep(3000);           
	      focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[4]//div[4]/button[2]")),br);

	      int chk=0;
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          statusTracker(br,"Pass","Verify the order process for changing the num of rings to" + n,"Successfully be able to process order","Successfully processed order");
	        }
	        else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify the order process for changing the num of rings to" + n,"Unable to process order","Unable to process successfully");
	        }
	      
	  }
	  
	  public void cancel(WebDriver driver,String br) throws Exception
	  {
		  logger.info("Switching the feature");
		  driver.findElement(By.xpath("//div[@id='collapseFeature1']/div[2]/div[4]/div/div[4]/form//div/label/span[2]")).click();
		  driver.findElement(By.cssSelector("a[href='/UserOutgoingCalls/OutgoingCalls']")).click();
		  Thread.sleep(2000);
		  logger.info("Clicking on cancel in the pop-up");
		  driver.findElement(By.cssSelector("[class='modal-footer'] span[id='cancelSaveFeature']")).click();
		  boolean enable = driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[4]//div[4]/button[2]")).isEnabled();
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
	
		  Feature_Name="CFNA";
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
	              if(!(InternalException(driver,br)))
                  {

	              switchTo(driver, "Admin",tlim,br);    
	              if(driver.findElement(By.cssSelector("a[href='/UserMain/UserCallSettings']")).isDisplayed())
        		  {
        			  statusTracker(br,"Pass","Verifying Whether the home page is displayed","Successfully Logged into VoiceManager application, home page is displayed","");
        		  }
        		  else
        		  {
        			  statusTracker(br,"Fail","Verifying Whether the home page is displayed","Could not Log into VoiceManager application, home page is not displayed","");
        		  }
                  
                  focusClick(driver,driver.findElement(By.cssSelector("a[href='/UserIncomingCalls/IncomingCalls']")),br);
                  for(int i1=1;i1<20;i1++){}
                  
                  if(!(InternalException(driver,br)))
                  {

                  int count1=driver.findElements(By.xpath("//html/body/section/div")).size();
                  String featureName="Call Forward No Answer";
	              int featureOrder=FeatureListIncoming(driver,count1,featureName);

	              System.out.println("Feature Order " + featureOrder);  
	              focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature1 > div.accordian-header > h3.ng-binding")),br);                
                 Thread.sleep(2000);
                  phoneline_ac= Select_TN(driver,featureName,featureOrder,br);
	              System.out.println(phoneline_ac);
	              logger.info("c");

	             /* if(phoneline_ac!=null)
	              {
            	  focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[1]/a")),br);

                  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[3]")),br);

	              //new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(phoneline_ac);
	              focusDropdown(driver,"//html/body/header/div[4]/div[3]/div/div/span",phoneline_ac,br);
	              do{
	            	  //logger.info("Processing!" +chk);
	            	 
	              }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                
                  phoneline=phoneline_ac.substring(0,8);*/
                                  
                  boolean status= driver.findElement(By.id("toggleButton2Forward No Answer")).isSelected();
                  
                  int cnt=driver.findElements(org.openqa.selenium.By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[4]/form/div/div")).size();
                  logger.info("cnt is"+cnt);
                  String drpval;
                  int a3=3;
                  drpval="//html/body/section/div[5]/div[2]/div[4]/div[1]/div[4]/form/div/div[3]";
                  String acc="No Account code";
                  if(status==true)
                  {
                	  status1="On";
                	  state=turnoff(driver, status1, acc,br);
                  }
                  else
                  {
                	  status1="Off";
                	  state=Turnon(driver, status1, acc,br);
                   }
                   logger.info("orderprocess is done");
                   EditTn(driver,br);
                   numrngs(driver,br,drpval);
                   TNValidation(driver,a3,br);
                   cancel(driver,br);
                  }     
                  
	              Thread.sleep(2000);
                  
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
	  
	  private boolean isElementPresent(WebDriver driver, By xpath) {
		// TODO Auto-generated method stub
		return false;
	}
	}
