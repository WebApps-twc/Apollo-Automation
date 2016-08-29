package ProdVersionFeaturesFile.IncomingCalls.UserMode;

import com.thoughtworks.selenium.Selenium;

import ProdVersionFeaturesFile.CommonFunctions;

import java.io.File;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class UserSelectiveCallForwarding extends CommonFunctions {
	
	String table, tns[];
    String tlimit,username,pwd;
    int tncount;				                        
    String butnxpath,accdcheck,AddnewNum,Err;
    String svexpath="form[name=\"selectiveCallForward\"] > div.accordian-actions > button.btn.btn-primary";
    String TNxpath="//html/body/section/div[12]/div[2]/form/div[5]/div/label";
    String phoneline,phoneline_ac,Acccode,frntn,phoneline1;
    
	int rank[]= new int[50];
	int c_sequence;
	String name_for_rank[]= new String[40];
	String price, rank_channels;

	public UserSelectiveCallForwarding(String path) {
		this.path = path;
	}

	public UserSelectiveCallForwarding(String path, String file1, String file2) {
		this.path = path;
		this.path1 = file1;
		this.path2 = file2;
	}
		 	
	public int Select_TN(WebDriver driver,String featureName,int rowCount,String br,int val)
	{
		int TN = 0;
		for(int j=1;j<rowCount;j++)
			{
				try
				{
			
					if(focusSearch(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature"+featureName+"']/div["+val+"]/table/tbody["+j+"]/tr[1]/td[1]/i")),br))
					{
						System .out.println("TN is suspended");
						continue;
					}                                    
					else if(driver.findElement(By.xpath(".//*[@id='collapseFeature"+featureName+"']/div["+val+"]/table/tbody["+j+"]/tr[1]/td[2]/div/input")).getAttribute("class").contains("not"))
					{ 
						System.out.println("tn2");
						TN=j;
						break;
					}
					else
					{
						focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature"+featureName+"']/div["+val+"]/table/tbody["+j+"]/tr[1]/td[2]/div/label")),br);
						focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature"+featureName+"']/div[3]/table/tfoot/tr/td/button[2]")),br);
			  			  						  
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
	
	public String turnoff(WebDriver driver, String status, String acc,String br)
	  {
		  String initialstate=status, chngetostate="Off",state="Fail", accst=acc;
		  
		  focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
		  
		  for(int i=1;i<50;i++){}
		  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);

	      int chk=0;
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          statusTracker(br,"Pass","Verify order process for changing status from: "+initialstate +" to: "+chngetostate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
	        }
	         else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for changing status from: "+initialstate +" to: "+chngetostate+ " with "+accst,"Thr order is failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
	        }
	      for(int i=1;i<50;i++){}
	      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);

	      String num=randomNO(6666,9999);
	      driver.findElement(By.id("accountCodeCalls")).clear();
	      driver.findElement(By.id("accountCodeCalls")).sendKeys(phoneline+num);
	      for(int i1=1;i1<50;i1++){}
	      focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);

	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          state="Pass";
	          statusTracker(br,"Pass","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
	        }
	         else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Thr order is failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
	        }
	      return state;
	  }
	  
	  public String turnOn(WebDriver driver, String status, String acc,String br)
	  {
	      String initialstate=status, chngetostate="On",state = "Fail", accst=acc;
	      focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);

		  String num=randomNO(6666,9999);
		    driver.findElement(By.id("newNumber")).sendKeys(phoneline+num);
		    focusClick(driver,driver.findElement(By.xpath(AddnewNum)),br);

		    do{
		        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
		    
		    num=randomNO(6666,9999);
		    driver.findElement(By.id("accountCodeCalls")).clear();
		    driver.findElement(By.id("accountCodeCalls")).sendKeys(phoneline+num);
		  for(int i=1;i<50;i++){}
		  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);

	      int chk=0;
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          statusTracker(br,"Pass","Verify order process for changing status from: "+ initialstate +" to: "+chngetostate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
	        }
	        else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for changing status from: "+ initialstate +" to: "+chngetostate+ " with "+accst,"Thr order is failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
	        }
	        
	      for(int i1=1;i1<50;i1++){}
	      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);

	      focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
	      
	      do{
	          //logger.info("Processing!" +chk);
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          statusTracker(br,"Pass","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
	          state="Pass";
	        }
	         else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Thr order is failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
	        }
		return state;
		  
	  }
	  
	  public void EditTn(WebDriver driver,String br)
	  {
		  String num=randomNO(6666,9999);
		  driver.findElement(By.id("accountCodeCalls")).clear();
		  driver.findElement(By.id("accountCodeCalls")).sendKeys(phoneline+num);
		  
		  int cnt;
		  if(driver.findElement(By.xpath("//html/body/section/div[6]/div[1]/h3")).getText().equals("Custom Ring"))
          {
			  cnt=driver.findElements(By.xpath("//html/body/section/div[8]/div[2]/form/section/label")).size();
          }
          else
          {
        	  cnt=driver.findElements(By.xpath("//html/body/section/div[7]/div[2]/form/section/label")).size();
          }
		  
		  if(cnt<30)
		  {
		  for(int i=1;i<5;i++){
			  num=randomNO(6666,9999);
			  driver.findElement(By.id("newNumber")).clear();
			  driver.findElement(By.id("newNumber")).sendKeys(phoneline+num);
			  focusClick(driver,driver.findElement(By.xpath(AddnewNum)),br);

			  do{
		        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
		     }
		  }
		  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);

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
	          statusTracker(br,"Fail","Verify order process for editing TN","Thr order is failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
	        }
	  }
	  
	  public void DeltTn(WebDriver driver,String br)
	  {
		  int cnt;
		  if(driver.findElement(By.xpath("//html/body/section/div[6]/div[1]/h3")).getText().equals("Custom Ring"))
          {
			  cnt=driver.findElements(By.xpath("//html/body/section/div[8]/div[2]/form/section/label")).size();
          }
          else
          {
        	  cnt=driver.findElements(By.xpath("//html/body/section/div[7]/div[2]/form/section/label")).size();
          }
		  logger.info("tncunt"+tncount);
		  
		  boolean status= driver.findElement(By.id("toggleButton24")).isSelected();
		  
		  if(status==true)
	      {
			  focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
	      }
		  
		  if(cnt>=2)
		  {
			  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature4']/div[2]/form/section/label/i")),br);

			  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);

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
		          statusTracker(br,"Fail","Verify order process for Deleting the TN","Thr order is failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
		        }
		  }
		  else
		  {
			  for(int i=1;i<5;i++){
				  String num=randomNO(3333,6666);
				  driver.findElement(By.id("newNumber")).clear();
				  driver.findElement(By.id("newNumber")).sendKeys(phoneline+num);
				  focusClick(driver,driver.findElement(By.xpath(AddnewNum)),br);
			     }	      
			  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);

		      do{
		          //chk++;
		        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
		      focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature4']/div[2]/form/section/label/i")),br);

		      focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);

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
		          statusTracker(br,"Fail","Verify order process for Deleting the TN","Thr order is failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
		        }	      
		  }
	  }
	  
	  public void DeltTnAll(WebDriver driver,String br) throws Exception
	  {
		  int chk=0;
		  focusClick(driver,driver.findElement(By.cssSelector("form[name=\"selectiveCallForward\"] > div.accordian-actions > button.btn.btn-secondary")),br);

		  do{
			  chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
		  focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature4 > div.accordian-header > h3.ng-binding")),br);
		  
	      boolean status= driver.findElement(By.id("toggleButton24")).isSelected();
		  
		  if(status==true)
	      {
			  focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
	      }
		  
		  int cnt;
		  if(driver.findElement(By.xpath("//html/body/section/div[6]/div[1]/h3")).getText().equals("Custom Ring"))
          {
			  cnt=driver.findElements(By.xpath("//html/body/section/div[8]/div[2]/form/section/label")).size();
          }
          else
          {
        	  cnt=driver.findElements(By.xpath("//html/body/section/div[7]/div[2]/form/section/label")).size();
          }
		  
		  if(cnt>=2)
		  {
		  focusClick(driver,driver.findElement(By.xpath("(//a[contains(text(),'Delete All')])[1]")),br);
		  Thread.sleep(3000);
		  }
		  else{
		      for(int i=1;i<5;i++){
			  String num=randomNO(3333,6666);
			  driver.findElement(By.id("newNumber")).clear();
			  driver.findElement(By.id("newNumber")).sendKeys(phoneline+num);
			  focusClick(driver,driver.findElement(By.xpath(AddnewNum)),br);
		      }	   
		      
		      focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);

		      do{
		          chk++;
		        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
		      
		      focusClick(driver,driver.findElement(By.xpath("(//a[contains(text(),'Delete All')])[1]")),br);
		  }
		  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
		  		  
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
	          statusTracker(br,"Fail","Verify order process for DeletAll","Thr order is failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
	        }
		  
	  }
	  
	  public void maxTN(WebDriver driver,String br) throws Exception
	  {
		  int cnt;
		  if(driver.findElement(By.xpath("//html/body/section/div[6]/div[1]/h3")).getText().equals("Custom Ring"))
          {
			  cnt=driver.findElements(By.xpath("//html/body/section/div[8]/div[2]/form/section/label")).size();
          }
          else
          {
        	  cnt=driver.findElements(By.xpath("//html/body/section/div[7]/div[2]/form/section/label")).size();
          }
		  System.out.println("cnt"+cnt);
		  for(int i=cnt;i<30;i++){
	  		  String num=randomNO(6666,9999);
	  		  driver.findElement(By.id("newNumber")).clear();
	  		  driver.findElement(By.id("newNumber")).sendKeys(phoneline+num);	 
	  		focusClick(driver,driver.findElement(By.xpath(AddnewNum)),br);
	  		  
	  		  do{
	  	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
		  }
		  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
	  	  
		  do{
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
		  
		  int cnt1=driver.findElements(By.xpath("//html/body/section/div[8]/div[2]/form/section/label")).size();
		  
		  if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	      {
	        logger.info("Success");
	        statusTracker(br,"Pass","Verify order process for adding 30 TN's and count is: "+cnt1,"Successfully be able to process order","Successfully processed order");
	      }
	      else
	      {
	        logger.info("Fail");
	        statusTracker(br,"Fail","Verify order process for adding 30 TN's and count is: "+cnt1,"Thr order is failed to process"+ driver.findElement(By.xpath(Err)).getText(),"Unable to process successfully");
	      }
		  
		  String num1=randomNO(1111,5555);
		  driver.findElement(By.id("newNumber")).clear();
		  driver.findElement(By.id("newNumber")).sendKeys(phoneline+num1);
		  focusClick(driver,driver.findElement(By.xpath(AddnewNum)),br);

		  Thread.sleep(2000);
		  if(driver.findElement(By.xpath(Err)).isDisplayed())
	   	     {
	   		  statusTracker(br,"Pass","Verify if error message is displayed when adding more than 30 TN","Error message is displayed: "+ driver.findElement(By.xpath(Err)).getText(),"Error message should be displayed");
	   	     }
	   	  	 else
	   	  	 {
	   	  		 statusTracker(br,"Fail","Verify if error message is displayed when adding more than 30 TN","Error message is not displayed","Error message should be displayed");
	   	  	 }
	  }
	  
	  public String TNcheck(String Tn, String acode,WebDriver driver, int check,String br) throws Exception
	  {
	         String schk="Fail";
	         int check1=check;
	         driver.findElement(By.name("accountCodeCalls")).clear();
	         driver.findElement(By.name("accountCodeCalls")).sendKeys(Tn);       
	          
	         if(check1==2)
	         {
	        	 driver.findElement(By.name("accountCodeForwarding")).clear();
	        	 driver.findElement(By.name("accountCodeForwarding")).sendKeys(acode);
	         }
	         if(check1==3)
	         {
	        	 Tn=2+Acccode;
	        	 logger.info("ac"+Tn);
	        	 driver.findElement(By.name("accountCodeForwarding")).clear();
	        	 driver.findElement(By.name("accountCodeForwarding")).sendKeys(Tn);
	         }
	         focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
	                 
	         Thread.sleep(2000);
	     
	         if(driver.findElement(By.xpath(Err)).isDisplayed())
	   	     {
	   		  statusTracker(br,"Pass","Verify if error message is displayed for TO field when adding "+Tn+" TN/Acc code","Error message is displayed: "+ driver.findElement(By.xpath(Err)).getText(),"Error message should be displayed");
	   		  schk="Pass";
	   	     }
	   	  	 else
	   	  	 {
	   	  		 statusTracker(br,"Fail","Verify if error message is displayed for TO field when adding "+Tn+" TN","Error message is not displayed","Error message should be displayed");
	   	  		 schk="Fail";
	   	  	 }
	         return schk;
	  }  
	  
	  public String TNcheck2(String Tn, WebDriver driver,String br) throws Exception
	  {
	         String schk="Fail";
	         driver.findElement(By.name("newNumber")).clear();
	         driver.findElement(By.name("newNumber")).sendKeys(Tn);       
	         focusClick(driver,driver.findElement(By.xpath(AddnewNum)),br);
	                 
	         Thread.sleep(2000);
	     
	         if(driver.findElement(By.xpath(Err)).isDisplayed())
	   	     {
	   		  statusTracker(br,"Pass","Verify if error message is displayed for FROM field when adding "+Tn+" TN/Acc code","Error message is displayed: "+ driver.findElement(By.xpath(Err)).getText(),"Error message should be displayed");
	   		  schk="Pass";
	   	     }
	   	  	 else
	   	  	 {
	   	  		 statusTracker(br,"Fail","Verify if error message is displayed for FROM field when adding "+Tn+" TN","Error message is not displayed","Error message should be displayed");
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
	         if(driver.findElement(By.xpath("//html/body/section/div[6]/div[1]/h3")).getText().equals("Custom Ring"))
             {
	        	 
	        	 frntn=driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/section/label[1]")).getText();
             }
	         else
	         {
	        	 frntn=driver.findElement(By.xpath("//html/body/section/div[7]/div[2]/form/section/label[1]")).getText();
	         }
	         schk=TNcheck(phoneline_ac,"",driver,1,br);
	         System.out.println("frntn"+frntn);
	         schk=TNcheck(frntn,"",driver,1,br);
	         if(a==1 || a==2)
	         {
	          schk=TNcheck("9193220101","",driver,2,br); 
	          schk=TNcheck("9193220101","2",driver,2,br);
	          schk=TNcheck("919322","2",driver,2,br);
	          if(a==1)
	        	 schk=TNcheck("9193220101","",driver,3,br);
	         schk="Pass";
	         }
	         
	         schk=TNcheck2("0223004000",driver,br);
	         schk=TNcheck2("1223004000",driver,br);
	         schk=TNcheck2("9000004000",driver,br);
	         schk=TNcheck2("9760004000",driver,br);
	         schk=TNcheck2("9999",driver,br);
	         schk=TNcheck2(phoneline_ac,driver,br);
	         schk=TNcheck2(frntn,driver,br);
	         
	         return schk;
	  }
	  	    
	  public void execute(String br, WebDriver driver, String url, int loc, String name1) throws Exception {
	
		  Feature_Name="SCF";
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

	              switchTo(driver, "Admin",tlim,br);   
	              focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]")),br);

	              logger.info("checkpoint1");
                  
                  for(int i=1;i<20;i++){}
                  Acccode=driver.findElement(org.openqa.selenium.By.xpath("//html/body/section/section/div[1]/aside[1]/ul/li[1]/strong")).getText();
                  logger.info("Acccode"+Acccode);
                  
                  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[3]")),br);
                 
                	  int featureOrder=0;String featureName="SCF";
                	  focusClick(driver,driver.findElement(By.xpath("//*[@id='accordion_SCF']/h3")),br);    	  
							System.out.println("c");

							int divval=3;
							try
 	       					{
								if(driver.findElement(By.xpath(".//*[@id='collapseFeatureSCF']/div[3]/div/h2")).isDisplayed())
								{
									statusTracker(br,"","SCF Modal pop up is  displayed","","");
									//driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/div/button")).click();
									divval=3;
								}
 	       					}
 	       					catch(Exception e)
 	       					{
 	       						statusTracker(br,"","SCF Modal pop up is not displayed second time","","");
 	       						first=1;
 	       					}												
   	  
							int numberOfTns=driver.findElements(By.xpath("//*[@id='collapseFeatureSCF']/div["+divval+"]/table/tbody")).size(); 
							System.out.println("d: "+numberOfTns);
							int TN= Select_TN(driver,featureName,numberOfTns,br,divval);
							System.out.println("TN1"+TN);
                        	phoneline1=driver.findElement(org.openqa.selenium.By.xpath(".//*[@id='collapseFeatureSCF']/div["+divval+"]/table/tbody["+TN+"]/tr[1]/td[1]")).getText();
                        	phoneline=phoneline1.substring(0, 8);
                        	System.out.println("phoneline"+phoneline);
							
	              if(phoneline1!=null)
	              {
	              focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[1]/a")),br);

                  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[3]")),br);
                  focusDropdown(driver,"//html/body/header/div[4]/div[3]/div/div/span",phoneline_ac,br);
                  //new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(phoneline_ac);
                  do{
                	  //logger.info("Processing!" +chk);
                	 
                  }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                /*  phoneline_ac=driver.findElement(By.xpath("//html/body/header/div[4]/div[3]/div/div/span/select/option[1]")).getText();*/
                  phoneline=phoneline_ac.substring(0,8);
                  logger.info("phoneline"+phoneline);
                  focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature4 > div.accordian-header > div.header-right")),br);
                                                     
                  boolean status= driver.findElement(By.id("toggleButton24")).isSelected();
                  int cnt;
                  logger.info("Feature"+driver.findElement(By.xpath("//html/body/section/div[6]/div[1]/h3")).getText().equals("Custom Ring"));
                  if(driver.findElement(By.xpath("//html/body/section/div[6]/div[1]/h3")).getText().equals("Custom Ring"))
                  {
                	  butnxpath="//html/body/section/div[8]/div[2]/div[1]/label";
                	  cnt=driver.findElements(org.openqa.selenium.By.xpath("//html/body/section/div[8]/div[2]/form/div[3]/div")).size();
                	  logger.info("cnt is"+cnt);
                	  accdcheck="//html/body/section/div[8]/div[2]/form/div[3]/div[3]/div/label";
                	  AddnewNum="//html/body/section/div[8]/div[2]/form/div[1]/div[2]/div/button";
                	  Err="//html/body/section/div[8]/div[2]/div[2]/div/div/div/ul";                	  
                	  //tncount=driver.findElements(By.xpath("//html/body/section/div[8]/div[2]/form/section/label")).size();
                  }
                  else
                  {
                	  butnxpath="//html/body/section/div[7]/div[2]/div[1]/label";
                	  cnt=driver.findElements(org.openqa.selenium.By.xpath("//html/body/section/div[7]/div[2]/form/div[3]/div")).size();
                	  accdcheck="//html/body/section/div[7]/div[2]/form/div[3]/div[3]/div/label";
                	  AddnewNum="//html/body/section/div[7]/div[2]/form/div[1]/div[2]/div/button";
                	  Err="//html/body/section/div[7]/div[2]/div[2]/div/div/div/ul";
                	  System.out.println("frntn"+frntn);
                	  //tncount=driver.findElements(By.xpath("//html/body/section/div[7]/div[2]/form/section/label")).size();
                  }
                  
                  if(cnt==3)
                  {
                	  int a1=1;
                	  boolean acntcd= driver.findElement(By.id("check")).isSelected();
                	  logger.info("acntcd is"+acntcd);
                	  if(acntcd==true)
                      {
                		  logger.info("check is");
                		  statusTracker(br,"","The Account code is"+Acccode,"","");     
                		  focusClick(driver,driver.findElement(By.xpath(accdcheck)),br);
                		  driver.findElement(By.name("accountCodeForwarding")).sendKeys(Acccode);
                      }
                	  else
                	  {
                		  driver.findElement(By.name("accountCodeForwarding")).clear();
                		  driver.findElement(By.name("accountCodeForwarding")).sendKeys(Acccode);
                	  }
                	  logger.info("check is");
                	  String acc="Verified Account code";
                	  if(status==true)
                      {
                  	  status1="On";
                  	  state=turnoff(driver, status1, acc,br);
                      }
                      else
                      {
                  	  status1="Off";
                  	  state=turnOn(driver, status1, acc,br);
                      }
                	  logger.info("orderprocess is done");                                                                 
                  	  EditTn(driver,br);
                      maxTN(driver,br);
                  	  DeltTn(driver,br); 
                  	  TNValidation(driver,a1,br);
                  	  DeltTnAll(driver,br);
                  	  //TNValidation(driver,a1,br);
                  }
                  else if(cnt==2)
                  {
                	  int a2=2;
                	  driver.findElement(By.name("accountCodeForwarding")).clear();
            		  driver.findElement(By.name("accountCodeForwarding")).sendKeys("8956325485");
            		  String acc="Non-Verified Account code";
            		  if(status==true)
                      {
                  	  status1="On";
                  	  state=turnoff(driver, status1, acc,br);
                      }
                      else
                      {
                  	  status1="Off";
                  	  state=turnOn(driver, status1, acc,br);
                      }                     
                      logger.info("orderprocess is done");
                                           
                  	  EditTn(driver,br);
                      maxTN(driver,br);
                  	  DeltTn(driver,br);
                  	  TNValidation(driver,a2,br);
                  	  DeltTnAll(driver,br);                  	  
                  }
                  else
                  {
                	int a3=3;
                	String acc="No Account code";
                    if(status==true)
                    {
                	  status1="On";
                	  state=turnoff(driver, status1, acc,br);
                    }
                    else
                    {
                	  status1="Off";
                	  state=turnOn(driver, status1, acc,br);
                    }
                    logger.info("orderprocess is done");

                	  EditTn(driver,br);  
                      maxTN(driver,br);
                	  DeltTn(driver,br);
                	  TNValidation(driver,a3,br);
                	  DeltTnAll(driver,br);
                	  //TNValidation(driver,a3,br);
                  }                
                  
                  String canbut="//html/body/div[2]/div/div[2]/span";
              	  String Savbut="//html/body/div[2]/div/div[2]/a/span";  
              	  focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
              	  unsave(driver,br,canbut,Savbut);
                  
	              Thread.sleep(2000);
          
	              first=1;
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

