package ProdVersionFeaturesFile.CustomRouting.UserMode;

import com.thoughtworks.selenium.Selenium;

import ProdVersionFeaturesFile.CommonFunctions;

import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class UserCallScheduler extends CommonFunctions {
	
	String table, tns[];
    String tlimit,username,pwd;
    int tncount;				
	
    String TNxpath="//*[@id='collapseFeature2']/div[2]/form/div[6]/label";
    String phoneline,phoneline_ac,Acccode;
	int rank[]= new int[50];
	

	int c_sequence;
	String name_for_rank[]= new String[40];
	String price, rank_channels;

	public UserCallScheduler(String path) {
		this.path = path;
	}

	public UserCallScheduler(String path, String file1, String file2) {
		this.path = path;
		this.path1 = file1;
		this.path2 = file2;
	}
		
	
	public int countNumberTns(int featureOrder, String featureName, WebDriver driver)
	  {
		  int numberOfTns=0;
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  for(int i=0;i<50;i++)
		  {
				  //if(driver.findElements(By.id("check"+featureName+i)).size()>0)
			  try{
				 if(driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/div["+(6+i)+"]/label")).isDisplayed())
				 {   //*[@id='collapseFeature2']/div[2]/form/div[6]/label
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
	public String Select_TN(WebDriver driver,String Featurename,int count,String br)
	{
			
		int numberOfTns=countNumberTns(count,Featurename,driver);
		System.out.println(numberOfTns);
		String TN="";
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		for(int k=10,j=0;j<numberOfTns;j++,k++)
		{  
			try
			{
			if(driver.findElement(By.xpath("//div[@id='collapseFeature"+count+"']/div[2]/form/div["+(6+j)+"]/i")).isDisplayed())
			{ 
				System .out.println("TN is suspended");
				continue;
			}
			else if(driver.findElement(By.id("check"+k)).isSelected())
			{ 
				System.out.println("tn2");
				TN=driver.findElement(By.xpath("//div[@id='collapseFeature"+count+"']/div[2]/form/div["+(6+j)+"]/label")).getText();
				break;
			}
			else
			{
				/*driver.findElement(By.id("check"+Featurename+j)).click();*/
				focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature"+count+"']/div[2]/form/div["+(6+j)+"]/label")),br);
				focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
			   int chk=0;
				do{
                 
					
                 chk++;
               }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
             if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
             {
             	TN=driver.findElement(By.xpath("//html/body/section/div["+(4+count)+"]/div[2]/form/div["+(6+j)+"]/label")).getText();    
            break;
             }
             else
           	  {
           	  System.out.println("This feature cannot be  Enabled because "+driver.findElement(By.cssSelector("div.ng-scope > ul > li.ng-scope.ng-binding")).getText());   
           	  
           	  }
				
			}
			}
			catch(Exception e)
			  {
				numberOfTns++;
			  }
			
		}
	  return TN;	
	}
	public void CFB(WebDriver driver, int a, int b,String br)
    {
	   logger.info("CFB");
	   int edt=a, ck=b;String from="",to="";
	   focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div["+ck+"]/form/div["+edt+"]/label[3]/a")),br);
	   
	   boolean status=driver.findElement(By.id("toggleButton4")).isSelected();
	   
	   if(status==true)
	   {
		    from="Enable";to="Disable";
	   }
	   else
	   {
		    from="Disabled";to="Enabled";
	   }
	   focusClick(driver,driver.findElement(By.xpath("//html/body/div[5]/form/div/div[1]/div[2]/div/div[1]/div/label")),br);
		   
		   int acctype=driver.findElements(By.xpath("//html/body/div[5]/form/div/div[1]/div[2]/div/div")).size();
		   if(acctype==4)
		   {
			   String num=randomNO(3333,6666);
			   driver.findElement(By.name("forwardBusyCallTo")).clear();
			   driver.findElement(By.name("forwardBusyCallTo")).sendKeys(phoneline+num);
			   
			   boolean acntcd= driver.findElement(By.id("checkCFB")).isSelected();
         	   logger.info("acntcd is"+acntcd);
         	   if(acntcd==true)
               {
         		  logger.info("check is");
         		 focusClick(driver,driver.findElement(By.xpath("//html/body/div[5]/form/div/div[1]/div[2]/div/div[4]/label")),br);
         		  driver.findElement(By.name("forwardBusyCallAccount")).sendKeys(Acccode);
               }
         	  else
         	  {
         		  driver.findElement(By.name("forwardBusyCallAccount")).clear();
         		  driver.findElement(By.name("forwardBusyCallAccount")).sendKeys(Acccode);
         	  }
         	  focusClick(driver,driver.findElement(By.xpath("//div[@id='modal-callForwardBusy']/form/div/div[2]/span[2]")),br);
         	 
         	do{
              }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
         	
         	if(ck==7)
         	{            	

            if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
              {
                logger.info("Success");
                statusTracker(br,"Pass","Verify order process for CFB in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Verified account code","Successfully be able to process order","Successfully processed order");
              }
               else
              {
                logger.info("Fail");
                statusTracker(br,"Fail","Verify order process for CFB in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Verified account code","The order is failed to process","Unable to process successfully");
              }
         	}
		   }
           else if(acctype==3)
			    {
				   String num=randomNO(3333,6666);
				   driver.findElement(By.name("forwardBusyCallTo")).clear();
				   driver.findElement(By.name("forwardBusyCallTo")).sendKeys(phoneline+num);

          		  driver.findElement(By.name("forwardBusyCallAccount")).clear();
          		  driver.findElement(By.name("forwardBusyCallAccount")).sendKeys(Acccode);              	  
          		focusClick(driver,driver.findElement(By.xpath("//div[@id='modal-callForwardBusy']/form/div/div[2]/span[2]")),br);
          	 
          	do{
                 //logger.info("Processing!" +chk);
                 //chk++;
               }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
          	
          	if(ck==7)
         	{

             if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
               {
                 logger.info("Success");
                 statusTracker(br,"Pass","Verify order process for CFB in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Non-Verified account code","Successfully be able to process order","Successfully processed order");
               }
                else
               {
                 logger.info("Fail");
                 statusTracker(br,"Fail","Verify order process for CFB in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Non-Verified account code","The order is failed to process","Unable to process successfully");
               }	
         	}
	       }
           else
           {
        	   String num=randomNO(3333,6666);
				   driver.findElement(By.name("forwardBusyCallTo")).clear();
				   driver.findElement(By.name("forwardBusyCallTo")).sendKeys(phoneline+num);
				   focusClick(driver,driver.findElement(By.xpath("//div[@id='modal-callForwardBusy']/form/div/div[2]/span[2]")),br);
           	 
	              	do{
	                     //logger.info("Processing!" +chk);
	                     //chk++;
	                   }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
	              	
	              	if(ck==9)
	             	{	             		
	                 if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	                   {
	                     logger.info("Success");
	                     statusTracker(br,"Pass","Verify order process for CFB in wizard configuration1 with changing status from: "+from +" to: "+to+ " without account code","Successfully be able to process order","Successfully processed order");
	                   }
	                    else
	                   {
	                     logger.info("Fail");
	                     statusTracker(br,"Fail","Verify order process for CFB in wizard configuration1 with changing status from: "+from +" to: "+to+ " without account code","The order is failed to process","Unable to process successfully");
	                   }	
	             	}
           }

    }
   
   public void CFNA(WebDriver driver, int a, int b,String br)
    {
	   logger.info("CFNA");
	   int edt=a,ck=b;String from="",to="";
	   focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div["+ck+"]/form/div["+edt+"]/label[3]/a")),br);
	   
	   boolean status=driver.findElement(By.id("toggleButton5")).isSelected();
	   
	   if(status==true)
	   {
		    from="Enable";to="Disable";
	   }
	   else
	   {
		    from="Disabled";to="Enabled";
	   }
	   focusClick(driver,driver.findElement(By.xpath("//html/body/div[6]/form/div/div[1]/div[2]/div/div[1]/div[1]/div/label")),br);
		   
		   int acctype=driver.findElements(By.xpath("//html/body/div[6]/form/div/div[1]/div[2]/div/div")).size();
		   logger.info("acctype"+acctype);
		   if(acctype==5)
		   {
			   String num=randomNO(3333,6666);
			   driver.findElement(By.name("callForwardNoAnswerTo")).clear();
			   driver.findElement(By.name("callForwardNoAnswerTo")).sendKeys(phoneline+num);
			   
			   boolean acntcd= driver.findElement(By.id("checkCFNA")).isSelected();
        	   logger.info("acntcd is"+acntcd);
        	   if(acntcd==true)
              {
        		  logger.info("check is");
        		  //statusTracker("","The Account code is"+Acccode,"","");                  
        		  focusClick(driver,driver.findElement(By.xpath("//html/body/div[6]/form/div/div[1]/div[2]/div/div[4]/label")),br);
        		  driver.findElement(By.name("callForwardNoAnswerAccount")).sendKeys(Acccode);
              }
        	  else
        	  {
        		  driver.findElement(By.name("callForwardNoAnswerAccount")).clear();
        		  driver.findElement(By.name("callForwardNoAnswerAccount")).sendKeys(Acccode);
        	  }
        	   focusClick(driver,driver.findElement(By.xpath("//*[@id='modal-callForwardNoAnswer']/form/div/div[2]/span[2]")),br);
        	 
        	do{
               //logger.info("Processing!" +chk);
               //chk++;
             }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
        	
        	if(ck==7)
         	{           		
             if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
             {
               logger.info("Success");
               statusTracker(br,"Pass","Verify order process for CFNA in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Verified account code","Successfully be able to process order","Successfully processed order");
             }
              else
             {
               logger.info("Fail");
               statusTracker(br,"Fail","Verify order process for CFNA in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Verified account code","The order is failed to process","Unable to process successfully");
             }	
         	}
	      }
		  
		   else if(acctype==4)
		    {
			   String num=randomNO(3333,6666);
			   driver.findElement(By.name("callForwardNoAnswerTo")).clear();
			   driver.findElement(By.name("callForwardNoAnswerTo")).sendKeys(phoneline+num);
			   
			   
        		  driver.findElement(By.name("callForwardNoAnswerAccount")).clear();
        		  driver.findElement(By.name("callForwardNoAnswerAccount")).sendKeys(Acccode);
        		  focusClick(driver,driver.findElement(By.xpath("//*[@id='modal-callForwardNoAnswer']/form/div/div[2]/span[2]")),br);
        	 
        	do{
               //logger.info("Processing!" +chk);
               //chk++;
             }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
        	
        	if(ck==7)
         	{
         	  if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
             {
               logger.info("Success");
               statusTracker(br,"Pass","Verify order process for CFNA in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Non-Verified account code","Successfully be able to process order","Successfully processed order");
             }
              else
             {
               logger.info("Fail");
               statusTracker(br,"Fail","Verify order process for CFNA in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Non-Verified account code","The order is failed to process","Unable to process successfully");
             }	
         	}
	       }
		   
		   else
		{
			String num=randomNO(3333,6666);
		   driver.findElement(By.name("callForwardNoAnswerTo")).clear();
		   driver.findElement(By.name("callForwardNoAnswerTo")).sendKeys(phoneline+num);
		   focusClick(driver,driver.findElement(By.xpath("//*[@id='modal-callForwardNoAnswer']/form/div/div[2]/span[2]")),br);
    	 
    	do{
           //logger.info("Processing!" +chk);
           //chk++;
         }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
    	
    	if(ck==7)
     	{
     		
       if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
         {
           logger.info("Success");
           statusTracker(br,"Pass","Verify order process for CFNA in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Non-Verified account code","Successfully be able to process order","Successfully processed order");
         }
          else
         {
           logger.info("Fail");
           statusTracker(br,"Fail","Verify order process for CFNA in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Non-Verified account code","The order is failed to process","Unable to process successfully");
         }		
     	}
       }
	   
    }
   
   public void CFU(WebDriver driver, int a,int b,String br)
    {
	   logger.info("CFU");
	   int edt=a,ck=b;String from="",to="";
	   focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div["+ck+"]/form/div["+edt+"]/label[3]/a")),br);
	   boolean status=driver.findElement(By.id("toggleButton6")).isSelected();
	   
	   if(status==true)
	   {
		    from="Enable";to="Disable";
	   }
	   else
	   {
		    from="Disabled";to="Enabled";
	   }
	   focusClick(driver,driver.findElement(By.xpath("//html/body/div[7]/form/div/div[1]/div[2]/div/div[1]/div/label")),br);
		   
		   int acctype=driver.findElements(By.xpath("//html/body/div[7]/form/div/div[1]/div[2]/div/div")).size();
		   if(acctype==4)
		   {
			   String num=randomNO(3333,6666);
			   driver.findElement(By.name("callForwardPhone")).clear();
			   driver.findElement(By.name("callForwardPhone")).sendKeys(phoneline+num);
			   
			   boolean acntcd= driver.findElement(By.id("checkCFU")).isSelected();
        	   logger.info("acntcd is"+acntcd);
        	   if(acntcd==true)
              {
        		  logger.info("check is");
        		  //statusTracker("","The Account code is"+Acccode,"","");      
        		  focusClick(driver,driver.findElement(By.xpath("//html/body/div[7]/form/div/div[1]/div[2]/div/div[4]/label")),br);
        		  driver.findElement(By.name("callForwardToAccount")).sendKeys(Acccode);
              }
        	  else
        	  {
        		  driver.findElement(By.name("callForwardToAccount")).clear();
        		  driver.findElement(By.name("callForwardToAccount")).sendKeys(Acccode);
        	  }
        	   focusClick(driver,driver.findElement(By.xpath("//*[@id='modal-callForwardUnconditional']/form/div/div[2]/span[2]")),br);
        	 
        	do{
               //logger.info("Processing!" +chk);
               //chk++;
             }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
        	
        	if(ck==7)
         	{
         	 if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
             {
               logger.info("Success");
               statusTracker(br,"Pass","Verify order process for CFU in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Verified account code","Successfully be able to process order","Successfully processed order");
             }
              else
             {
               logger.info("Fail");
               statusTracker(br,"Fail","Verify order process for CFU in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Verified account code","The order is failed to process","Unable to process successfully");
             }
         	}
		   
	      }
		   
		   else if(acctype==3)
		   {
			   String num=randomNO(3333,6666);
			   driver.findElement(By.name("callForwardPhone")).clear();
			   driver.findElement(By.name("callForwardPhone")).sendKeys(phoneline+num);
			   				   
        		  driver.findElement(By.name("callForwardToAccount")).clear();
        		  driver.findElement(By.name("callForwardToAccount")).sendKeys(Acccode);
        		  focusClick(driver,driver.findElement(By.xpath("//*[@id='modal-callForwardUnconditional']/form/div/div[2]/span[2]")),br);
        	 
        	do{
               //logger.info("Processing!" +chk);
               //chk++;
             }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
        	
        	if(ck==7)
         	{
         	 if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
             {
               logger.info("Success");
               statusTracker(br,"Pass","Verify order process for CFU in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Verified account code","Successfully be able to process order","Successfully processed order");
             }
              else
             {
               logger.info("Fail");
               statusTracker(br,"Fail","Verify order process for CFU in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Verified account code","The order is failed to process","Unable to process successfully");
             }	
         	}
	       }
		   
		   else 
		   {
			   String num=randomNO(3333,6666);
			   driver.findElement(By.name("callForwardPhone")).clear();
			   driver.findElement(By.name("callForwardPhone")).sendKeys(phoneline+num);
			   focusClick(driver,driver.findElement(By.xpath("//*[@id='modal-callForwardUnconditional']/form/div/div[2]/span[2]")),br);
        	 
        	do{
               //logger.info("Processing!" +chk);
               //chk++;
             }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
        	
        	if(ck==7)
         	{
         	if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
             {
               logger.info("Success");
               statusTracker(br,"Pass","Verify order process for CFU in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Verified account code","Successfully be able to process order","Successfully processed order");
             }
              else
             {
               logger.info("Fail");
               statusTracker(br,"Fail","Verify order process for CFU in wizard configuration1 with changing status from: "+from +" to: "+to+ " with Verified account code","The order is failed to process","Unable to process successfully");
             }	
         	}
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
	              focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]/a")),br);

	              Acccode=driver.findElement(org.openqa.selenium.By.xpath("//html/body/section/section/div[1]/aside[1]/ul/li[1]/strong")).getText();	
	              focusClick(driver,driver.findElement(By.xpath("/html/body/section/div[2]/section/div/a[5]")),br);
	     
	    	      Thread.sleep(3000);      
	    	      
	    	      if(!(InternalException(driver,br)))
                  {


                  String featureName="Call Scheduler";
	              int featureOrder=2;

	              System.out.println("Feature Order " + featureOrder);  
	              focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature2 > div.accordian-header > div.header-right > div.align-right.ng-scope")),br);

	               Thread.sleep(3000);
	              
	               phoneline_ac= Select_TN(driver,featureName,featureOrder,br);
		              System.out.println(phoneline_ac);
		              logger.info("c");

		          if(phoneline_ac!=null)
		          {
            	  focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[1]/a")),br);

	              for(int j=1;j<10;j++){}
	              focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[6]/span")),br);

	              //new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(phoneline_ac);
	              focusDropdown(driver,"//html/body/header/div[4]/div[3]/div/div/span",phoneline_ac,br);
	              do{
	            	  //logger.info("Processing!" +chk);
	            	 
	              }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
	              focusClick(driver,driver.findElement(By.cssSelector("span.accordian-info.ng-binding")),br);

	              if(!(InternalException(driver,br)))
                  {
	              phoneline=phoneline_ac.substring(0,8);
	              
	              if(driver.findElement(By.cssSelector("form[name=\"featureForm\"] > h2.ng-binding")).isDisplayed())
	              {
	            	  logger.info("Wizard");
	            	  focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br);
	            	  
	            	  do{
	            		  
	            	  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
	            		  
	            	  int fetcnt=driver.findElements(By.xpath("//html/body/section/div[4]/div[5]/form/div")).size();
	            	  logger.info("fetcnt"+fetcnt);
	            	   if(fetcnt>5)
	            	   {
	            	     for(int i=5;i<fetcnt;++i)
	            	     {
	            	    	 logger.info("inside the loop"+i); 
	            	    	if(driver.findElement(By.xpath("//html/body/section/div[4]/div[5]/form/div["+i+"]/label[1]")).getText().equals("Call Forward Busy"))
	            	    	   CFB(driver,i,5,br);
	            	    	
	            	    	else if(driver.findElement(By.xpath("//html/body/section/div[4]/div[5]/form/div["+i+"]/label[1]")).getText().equals("Call Forward No Answer"))
	             	    	   CFNA(driver,i,5,br);
	            	    	
	            	    	else if(driver.findElement(By.xpath("//html/body/section/div[4]/div[5]/form/div["+i+"]/label[1]")).getText().equals("Call Forward All Calls"))
	             	    	   CFU(driver,i,5,br);
	            	    	
	            	     }
	            	    	
	            	   }
	            	   focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[3]")),br);

	            	   do{        		  
	             	    }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
	            	   focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[4]")),br);

	            	   statusTracker(br,"Pass","Verify if error message is displayed for blank/invalid configuration2 name","Error message is displayed: "+ driver.findElement(By.xpath("//html/body/section/div[4]/div[5]/form/div[4]/div[1]/div/div/div")).getText(),"Error message should be displayed");
	            		  
	            	   driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
	            	   driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Config 2");
	            	   focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[4]")),br);
   	   
	            	   do{        		  
	            	    }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
	            	   focusClick(driver,driver.findElement(By.cssSelector("div.accordian-actions.ng-scope > button.btn.btn-primary")),br);

	            	   statusTracker(br,"Pass","Verify if error message is displayed for blank/invalid configuration3 name","Error message is displayed: "+ driver.findElement(By.xpath("//html/body/section/div[4]/div[5]/form/div[4]/div[1]/div/div/div")).getText(),"Error message should be displayed");      		
	            	   
	            	   driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
	            	   driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Config 3");
	            	   focusClick(driver,driver.findElement(By.cssSelector("div.accordian-actions.ng-scope > button.btn.btn-primary")),br);

	            	   do{        		  
	           	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
	            	   focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature0']/div[6]/div[5]/div[1]/div[13]/button")),br);
	
	            	   statusTracker(br,"Pass","Verify if error message is displayed for without selecting days","Error message is displayed: "+ driver.findElement(By.xpath("//html/body/section/div[4]/div[6]/div[4]/div[1]/div/div/div")).getText(),"Error message should be displayed");      		        	   
	            	          	   
	            	   String a=randomNO(1,2);
	            	   String a1=randomNO(1,3);
	            	   focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[6]/div[5]/div[1]/div[10]/div["+a+"]/div["+a1+"]/label")),br);
	            	   focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature0']/div[6]/div[5]/div[1]/div[13]/button")),br);

	            	   do{        		  
	          	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed()); 
	            	   
	            	   for(int i=1;i<=7;i++)
	            	   {
	            		   if(driver.findElement(By.xpath("//html/body/section/div[4]/div[6]/div[5]/div[2]/div[2]/section/div[2]/div/div[3]/ul/li["+i+"]")).getAttribute("class").equals("ng-scope active"))
	            			   driver.findElement(By.xpath("//html/body/section/div[4]/div[6]/div[5]/div[2]/div[2]/section/div[2]/div/div[3]/ul/li["+i+"]")).getText();
	            	   }
	            	   statusTracker(br,"","The Repeating Event is "+ driver.findElement(By.xpath("//html/body/section/div[4]/div[6]/div[5]/div[2]/div[2]/section/div[2]/div/div[1]")).getText()+driver.findElement(By.xpath("//html/body/section/div[4]/div[6]/div[5]/div[2]/div[2]/section/div[2]/div/div[2]")).getText()+driver.findElement(By.xpath("//html/body/section/div[4]/div[6]/div[5]/div[2]/div[2]/section/div[2]/div/div[3]/ul/li")).getAttribute("class"),"","");
	            	   focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature0']/div[6]/div[5]/div[1]/div[13]/button")),br);
	            	   statusTracker(br,"Pass","Verify if error message is displayed for without selecting days","Error message is displayed: "+ driver.findElement(By.xpath("//html/body/section/div[4]/div[6]/div[4]/div[1]/div/div/div")).getText(),"Error message should be displayed");      		        	         	          	   
	            	   
	            	   focusClick(driver,driver.findElement(By.cssSelector("div.align-right > button.btn.btn-primary")),br);
	            	   focusClick(driver,driver.findElement(By.cssSelector("div.buttons-wrapper > button.btn.btn-primary")),br);

	            	   do{        		  
	         	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed()); 
	            	   
	            	   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	                   {
	                     logger.info("Success");
	                     statusTracker(br,"Pass","Verify order process for call scheduler activate now","Successfully be able to process order","Successfully processed order");
	                   }
	                    else
	                   {
	                     logger.info("Fail");
	                     statusTracker(br,"Fail","Verify order process for call scheduler activate now","The order is failed to process","Unable to process successfully");
	                   }
	              }
	              else
                  {
                      logger.info("Scheduler Landing");
                      focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[8]/section/div[2]/div/div/div[3]/div[1]/div/div/div/button[1]")),br);
                      
                      int fetcnt1=driver.findElements(By.xpath("//html/body/section/div[4]/div[5]/form/div")).size();
                      logger.info("fetcnt"+fetcnt1);
                       if(fetcnt1>1)
                       {
                         for(int i=5;i<4+fetcnt1;++i)
                         {
                                     logger.info("inside the loop"+i); 
                                        if(driver.findElement(By.xpath("//html/body/section/div[4]/div[9]/form/div["+i+"]/label[1]")).getText().equals("Call Forward Busy"))
                                       CFB(driver,i,9,br);
                                    
                                    else if(driver.findElement(By.xpath("//html/body/section/div[4]/div[9]/form/div["+i+"]/label[1]")).getText().equals("Call Forward No Answer"))
                                       CFNA(driver,i,9,br);
                                    
                                    else if(driver.findElement(By.xpath("//html/body/section/div[4]/div[9]/form/div["+i+"]/label[1]")).getText().equals("Call Forward All Calls"))
                                       CFU(driver,i,9,br);
                                    
                         }
                         focusClick(driver,driver.findElement(By.cssSelector("form[name=\"EditConfigurationForm\"] > div.accordian-actions > button.btn.btn-primary")),br);

                                      do{
                            }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                        {
                          logger.info("Success");
                          statusTracker(br,"Pass","Verify order process for features in landing","Successfully be able to process order","Successfully processed order");
                        }
                         else
                        {
                          logger.info("Fail");
                          statusTracker(br,"Fail","Verify order process for features in landing","The order is failed to process","Unable to process successfully");
                          focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature0']/div[9]/form/div[8]/button[1]")),br);

                          do{
                            }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                        }          
                                    
                       }
                       
                       String from="",to="";
                       boolean status=driver.findElement(By.id("toggleButton1")).isSelected();
                                       
                                       if(status==true)
                                       {
                                                        from="Enable";to="Disable";
                                                        focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[8]/div[1]/div/div/label")),br);
                                                        focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[11]/div/div[1]/div/div/div[2]/span/select/option[2]")),br);
                                                        focusClick(driver,driver.findElement(By.xpath("//div[@id='overideScheduleModal']/div/div[2]/span[2]")),br);

                                                        do{
                            }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                                        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                            {
                              logger.info("Success");
                              statusTracker(br,"Pass","Verify order process for call scheduler from "+ from + " to "+ to,"Successfully be able to process order","Successfully processed order");
                            }
                             else
                            {
                              logger.info("Fail");
                              statusTracker(br,"Fail","Verify order process for call scheduler from "+ from + " to "+ to,"The order is failed to process","Unable to process successfully");
                            }      
                                       }
                                       else
                                       {
                                                        from="Disabled";to="Enabled";
                                                        focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[8]/div[1]/div/div/label")),br);
                                                        focusClick(driver,driver.findElement(By.xpath("//div[@id='overideScheduleModal']/div/div[2]/span[2]")),br);
                                                        do{
                            }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                                        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                            {
                              logger.info("Success");
                              statusTracker(br,"Pass","Verify order process for call scheduler from "+ from + " to "+ to,"Successfully be able to process order","Successfully processed order");
                            }
                             else
                            {
                              logger.info("Fail");
                              statusTracker(br,"Fail","Verify order process for call scheduler from "+ from + " to "+ to,"The order is failed to process","Unable to process successfully");
                            }      
                                       }  
                                       focusClick(driver,driver.findElement(By.xpath("(//button[@type='submit'])[14]")),br);

                                       String b=randomNO(1,2);
                                       String b1=randomNO(1,3);
                                       focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[10]/div/div[1]/div/div/div[4]/div[1]/div[1]/div[6]/div["+b+"]/div["+b1+"]/label")),br);
                                       focusClick(driver,driver.findElement(By.xpath("//div[@id='addEventModal']/div/div[2]/div/span")),br);

                                       do{                                        
                                          }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed()); 
                                       if(driver.findElements(By.xpath("//html/body/section/div[4]/div[10]/div/div[1]/div/div/div[3]/div/div/div")).size()>0)
                                       {
                                                       statusTracker(br,"","Verify adding the event from landing page",driver.findElement(By.xpath("//html/body/section/div[4]/div[10]/div/div[1]/div/div/div[3]/div/div/div")).getText(),"");                                                                                       
                                                       focusClick(driver,driver.findElement(By.xpath("//div[@id='addEventModal']/div/div[2]/span")),br);
                                       }
                                       else{
                                       if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                                          {
                                            logger.info("Success");
                                            statusTracker(br,"Pass","Verify order process for adding the repeating event from landing","Successfully be able to process order","Successfully processed order");                                    
                                          }
                                       else
                                          {
                                            logger.info("Fail");
                                            statusTracker(br,"Fail","Verify order process for adding the repeating event from landing","The order is failed to process","Unable to process successfully");
                                          }}
                                       focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[8]/section/div[2]/div/div/div[3]/div[1]/div/div/div/button[1]")),br);
                                       //driver.findElement(By.xpath("(//button[@type='submit'])[18]")).click();
                                       focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature0']/div[9]/form/div[8]/button[2]")),br);

                                       do{                                        
                                }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed()); 
                                       if(driver.findElements(By.xpath("//html/body/section/div[4]/div[9]/form/div[3]/div[1]/div/div/div")).size()>0)
                                       {
                                                       statusTracker(br,"","Verify order process for reseting the events",driver.findElement(By.xpath("//html/body/section/div[4]/div[9]/form/div[3]/div[1]/div/div/div")).getText(),"");                                          
                                                       focusClick(driver,driver.findElement(By.cssSelector("form[name=\"EditConfigurationForm\"] > div.accordian-actions > button.btn.btn-secondary")),br);
                                       }
                                       else{
                       if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                        {
                         logger.info("Success");
                         statusTracker(br,"Pass","Verify order process for reset event","Successfully be able to process order","Successfully processed order");
                        }
                      else
                        {
                         logger.info("Fail");
                         statusTracker(br,"Fail","Verify order process for reset event","The order is failed to process","Unable to process successfully");
                         focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature0']/div[9]/form/div[8]/button[1]")),br);
                          do{
                            }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                         }
                       }
                                     String c3=driver.findElement(By.xpath("//html/body/section/div[4]/div[8]/section/div[2]/div/div/div[3]/div[3]/div/div/div/button")).getAttribute("class");
                                     String c1="";
                                     logger.info("c3"+c3);
                     if(c3.equals("btn btn-primary ng-binding"))
                     {
                    	 			  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[8]/section/div[2]/div/div/div[3]/div[3]/div/div/div/button")),br);
                                     //driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
                                     driver.findElement(By.xpath(".//*[@id='collapseFeature0']/div[5]/form/div[4]/div/input")).sendKeys("config 3");
                                     focusClick(driver,driver.findElement(By.cssSelector("div.accordian-actions.ng-scope > button.btn.btn-primary")),br);
                                     do{                                          
                            }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed()); 
                                     if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                         {
                          logger.info("Success");
                          statusTracker(br,"Pass","Verify order process for adding configuration from landing","Successfully be able to process order","Successfully processed order");
                          c1="True";
                         }
                      else
                         {
                          logger.info("Fail");
                          statusTracker(br,"Fail","Verify order process for adding configuration from landing","The order is failed to process","Unable to process successfully");
                          focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature0']/div[5]/form/div[8]/button[1]")),br);

                          do{
                            }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                         }
                     }
                     
                        if(c1.equals("True"))   {           
                        	focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature0']/div[8]/section/div[2]/div/div/div/div[3]/div/div/i")),br);
                        	focusClick(driver,driver.findElement(By.xpath("//div[@id='deleteConfirmationModal']/div/div[2]/span[2]")),br);
                        	do{                                          
                            }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed()); 
                                     if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                          {
                           logger.info("Success");
                           statusTracker(br,"Pass","Verify order process for deleting the configuration from landing","Successfully be able to process order","Successfully processed order");
                          }
                       else
                          {
                           logger.info("Fail");
                           statusTracker(br,"Fail","Verify order process for deleting the configuration from landing","The order is failed to process","Unable to process successfully");
                           }}
                     
                     
                  }                           
                           
                  
	              Thread.sleep(2000);
                  first=1; 
		              }
		           }
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
	  
	  private boolean isElementPresent(WebDriver driver, By xpath) {
		// TODO Auto-generated method stub
		return false;
	}
	}


