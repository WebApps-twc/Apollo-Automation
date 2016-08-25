package ProdVersionFeaturesFile.OutgoingCalls.AdminMode;

import com.thoughtworks.selenium.Selenium;

import ProdVersionFeaturesFile.CommonFunctions;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class GPSHotline extends CommonFunctions {
	
	String table, tns[];
    String tlimit,username,pwd;
    int tncount,ck;				
	
    String xpath_GPSexecute_xpath;
    
    String butnxpath;//="//html/body/section/div[8]/div[2]/form/section/div[2]/div[1]/div[1]/div/label";
    String svexpath="(//button[@type='submit'])[11]";
    String xpath911;//="//html/body/section/div[8]/div[2]/form/section/div[2]/div[1]/div[4]/div/label";
    String TNxpath,statusChx;
    String butnxpath1="//html/body/section/div[8]/div[2]/form/div[1]/label";
    String phoneline,phoneline_ac,Acccode;
	int rank[]= new int[50];
	
	int c_sequence;
	String name_for_rank[]= new String[40];
	String price, rank_channels;

	public GPSHotline(String path) {
		this.path = path;
	}
		 
	  public int countNumberTns(int featureOrder, String featureName, WebDriver driver)
	  {
		  int numberOfTns=0;
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  for(int i=0;i<50;i++)
		  {    
				  //if(driver.findElements(By.id("check"+featureName+i)).size()>0)
			  try{
				  Thread.sleep(4000);
				 if(driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/section/div[2]/div["+(1+i)+"]/div[1]/div/label")).isDisplayed())
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
	  
	  public int suspendedStatus(int numberOfTns, int featureOrder,String featureName, WebDriver driver)
	  {
		  String []a=new String[numberOfTns];
		  int j = 0;
		  
		  for(int i=1;i<numberOfTns;i++)
		  {
			  
				  if(isAttributePresent(driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/section/div[2]/div["+i+"]/div[1]/div/input")),"disabled"))
				  {
					  a[i]="yes";
					  System.out.println("yes");
				  }
				  else
				  {
					  a[i]="no";
					  System.out.println("no");	 
					  j=i;
					  break;
				  }
	  
		  }
		  return j;
	   }
	
	private void exit(int i) {
		// TODO Auto-generated method stub
		
	}

	public String turnoff(WebDriver driver, String status1,String br)
	  {
		  String initialstate=status1, chngetostate="Off",state="";
		  focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
		  
		  for(int i=1;i<100;i++){}
		  focusClick(driver,driver.findElement(By.xpath(svexpath)),br);
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
	          statusTracker(br,"Fail","Verify order process for changing status from: "+initialstate +" to: "+chngetostate,"The order is failed to process"+driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/div[3]/div/div")).getText(),"Unable to process successfully");
	        }
	      
	      for(int i=1;i<100;i++){}
	      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);

	      boolean status911= driver.findElement(By.xpath(xpath911)).isSelected();
	      
	      if(status911==true)
	    	  focusClick(driver,driver.findElement(By.xpath(xpath911)),br);
	    	  
	      String num=randomNO(3333,6666);
	      driver.findElement(By.xpath(TNxpath)).clear();
	      driver.findElement(By.xpath(TNxpath)).sendKeys(phoneline+num);  
	      
	      for(int i1=1;i1<100;i1++){}
	      focusClick(driver,driver.findElement(By.xpath(svexpath)),br);
    
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          state="Pass";
	          statusTracker(br,"Pass","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with Editing the TN","Successfully be able to process order","Successfully processed order");
	        }
	         else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with Editing the TN","The order is failed to process"+driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/div[3]/div/div")).getText(),"Unable to process successfully");
	        }
	      
	      for(int i=1;i<100;i++){}
	      focusClick(driver,driver.findElement(By.xpath(xpath911)),br);

	      focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/section/div[3]/div/div[2]/span[2]")),br);
	      
	      for(int i1=1;i1<100;i1++){}
	      focusClick(driver,driver.findElement(By.xpath(svexpath)),br);
   
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          state="Pass";
	          statusTracker(br,"Pass","Verify order process for hotline with Enabling 911","Successfully be able to process order","Successfully processed order");
	        }
	         else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for hotline with Enabling 911","The order is failed to process"+driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/div[3]/div/div")).getText(),"Unable to process successfully");
	        }
	      
	      for(int i=1;i<100;i++){}
	      focusClick(driver,driver.findElement(By.xpath(xpath911)),br);

	      focusClick(driver,driver.findElement(By.xpath(svexpath)),br);
     
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          state="Pass";
	          statusTracker(br,"Pass","Verify order process for hotline with disabling 911","Successfully be able to process order","Successfully processed order");
	        }
	         else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for hotline with disabling 911","The order is failed to process"+driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/div[3]/div/div")).getText(),"Unable to process successfully");
	        }
	      
	      return state;
	  }
	  
	  public String turnOn(WebDriver driver, String status1,String br)
	  {
	      String initialstate=status1, chngetostate="On",state = "";
	      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);

		  String num=randomNO(3333,6666);
		  
		  boolean status911= driver.findElement(By.xpath(xpath911)).isSelected();
	      logger.info("status911"+status911);
	      if(status911==true)
	    	  focusClick(driver,driver.findElement(By.xpath(xpath911)),br);

		  driver.findElement(By.xpath(TNxpath)).clear();
	      driver.findElement(By.xpath(TNxpath)).sendKeys(phoneline+num);
		  for(int i=1;i<100;i++){}
		  focusClick(driver,driver.findElement(By.xpath(svexpath)),br);

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
	          statusTracker(br,"Fail","Verify order process for changing status from: "+ initialstate +" to: "+chngetostate,"The order is failed to process"+driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/div[3]/div/div")).getText(),"Unable to process successfully");
	        }
	        
	        for(int i=1;i<100;i++){}
	        
	        if(status911==true){
	        	focusClick(driver,driver.findElement(By.xpath(xpath911)),br);
      
	        	focusClick(driver,driver.findElement(By.xpath(svexpath)),br);
    
	            do{
	                chk++;
	              }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	            if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	              {
	                logger.info("Success");
	                state="Pass";
	                statusTracker(br,"Pass","Verify order process for hotline with disabling 911","Successfully be able to process order","Successfully processed order");
	              }
	               else
	              {
	                logger.info("Fail");
	                statusTracker(br,"Fail","Verify order process for hotline with disabling 911","The order is failed to process"+driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/div[3]/div/div")).getText(),"Unable to process successfully");
	              }
	        }
	        else{        	       
	        	focusClick(driver,driver.findElement(By.xpath(xpath911)),br);

	        focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/section/div[3]/div/div[2]/span[2]")),br);
	        
	        for(int i1=1;i1<100;i1++){}
	        focusClick(driver,driver.findElement(By.xpath(svexpath)),br);
    
	        do{
	            chk++;
	          }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	        if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	          {
	            logger.info("Success");
	            state="Pass";
	            statusTracker(br,"Pass","Verify order process for hotline with Enabling 911","Successfully be able to process order","Successfully processed order");
	          }
	           else
	          {
	            logger.info("Fail");
	            statusTracker(br,"Fail","Verify order process for hotline with Enabling 911","The order is failed to process"+driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/div[3]/div/div")).getText(),"Unable to process successfully");
	          }
	        }

	      for(int i1=1;i1<100;i1++){}
	      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);

	      focusClick(driver,driver.findElement(By.xpath(svexpath)),br);
	      
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
	          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate,"The order is failed to process"+driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/div[3]/div/div")).getText(),"Unable to process successfully");
	        }
		return state;
		  
	  }
	  
	  public String turnoff1(WebDriver driver, String status2,String br)
	  {
		  String initialstate=status2, chngetostate="Disabled",state="";
		  focusClick(driver,driver.findElement(By.xpath(butnxpath1)),br);
		  
		  for(int i=1;i<100;i++){}
		  focusClick(driver,driver.findElement(By.xpath(svexpath)),br);

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
	          statusTracker(br,"Fail","Verify order process for changing status from: "+initialstate +" to: "+chngetostate,"The order is failed to process"+driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/div[3]/div/div")).getText(),"Unable to process successfully");
	        }
	      
	      for(int i=1;i<100;i++){}
	      focusClick(driver,driver.findElement(By.xpath(butnxpath1)),br);
         	        
	      focusClick(driver,driver.findElement(By.xpath(svexpath)),br);
   
	      do{
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	      if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	        {
	          logger.info("Success");
	          state="Pass";
	          statusTracker(br,"Pass","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with Editing the TN","Successfully be able to process order","Successfully processed order");
	        }
	         else
	        {
	          logger.info("Fail");
	          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with Editing the TN","The order is failed to process"+driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/div[3]/div/div")).getText(),"Unable to process successfully");
	        }
	            
	      return state;
	  }
	  
	  public String turnOn1(WebDriver driver, String status2,String br)
	  {
	      String initialstate=status2, chngetostate="Enabled",state = "";
		  
	      focusClick(driver,driver.findElement(By.xpath(butnxpath1)),br);
	      
		  focusClick(driver,driver.findElement(By.xpath(svexpath)),br);

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
	          statusTracker(br,"Fail","Verify order process for changing status from: "+ initialstate +" to: "+chngetostate,"The order is failed to process"+driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/div[3]/div/div")).getText(),"Unable to process successfully");
	        }                
	        
	      for(int i1=1;i1<100;i1++){}
	      focusClick(driver,driver.findElement(By.xpath(butnxpath1)),br);

	      focusClick(driver,driver.findElement(By.xpath(svexpath)),br);
	      
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
	          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate,"The order is failed to process"+driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/div[3]/div/div")).getText(),"Unable to process successfully");
	        }
		return state;
		  
	  }  
	  
	  
	  public String TNcheck(String ac,WebDriver driver,String br) throws Exception
	  {
		     boolean statusCh= driver.findElement(By.xpath(butnxpath)).isSelected();
		     
		     if(statusCh==true)
	         {
		    	 focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
	         }
		     
		     boolean status911= driver.findElement(By.xpath(xpath911)).isSelected();
		     if(status911==true)
		    	 focusClick(driver,driver.findElement(By.xpath(xpath911)),br);
		     
	         String schk="Fail";
	         //int check1=check;
	         driver.findElement(By.xpath(TNxpath)).clear();
	         driver.findElement(By.xpath(TNxpath)).sendKeys(ac);       
	         
	         focusClick(driver,driver.findElement(By.xpath(svexpath)),br);
	                 
	         Thread.sleep(2000);
	         
	         if(driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/div[3]/div/div/ul")).isDisplayed())
	   	     {
	   		  statusTracker(br,"Pass","Verify if error message is displayed when adding "+ac+" TN/Acc code","Error message is displayed: "+ driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/div[3]/div/div")).getText(),"Error message should be displayed");
	   		  schk="Pass";
	   	     }
	   	  	 else
	   	  	 {
	   	  		 statusTracker(br,"Fail","Verify if error message is displayed when adding "+ac+" TN","Error message is not displayed","Error message should be displayed");
	   	  		 schk="Fail";
	   	  	 }
	         return schk;
	  }  
	  private boolean isElementPresent(WebElement findElement) {
		// TODO Auto-generated method stub
		return false;
	}

	//TN Validation
	  public String TNValidation(WebDriver driver,String br, String phoneline1) throws Exception
	  {
		  	 //int aa=Acccode.
		     statusTracker(br,"","","Error Validation","");
	         String schk ="Pass";
	         schk=TNcheck("0223004000",driver,br);
	         schk=TNcheck("1223004000",driver,br);
	         schk=TNcheck("9000004000",driver,br);
	         schk=TNcheck("9760004000",driver,br);
	         schk=TNcheck("9999",driver,br);
	         //phoneline_ac=driver.findElement(By.xpath("//html/body/header/div[4]/div[3]/div/div/span/select/option[1]")).getText();
	         System.out.println("phoneline_ac"+phoneline1);
	         schk=TNcheck(phoneline1,driver,br);
	         
	         return schk;
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
	              logger.info("checkpoint1");
                  for(int i=1;i<20;i++){}
                  
                  xpath_GPSexecute_xpath = GPS.getProperty("xpath_GPSexecute_xpath");
                  
                  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[4]")),br);
            
                 if(!(InternalException(driver,br)))
                 {
                	 logger.info("checkpoint2");
                	 focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature4 > div.accordian-header > div.header-right > span.accordian-info.ng-binding")),br);
                 
                	 int count1=driver.findElements(By.xpath(xpath_GPSexecute_xpath)).size();
	                 String status2="";
	                 String featureName="Hotline";
	           	  	 int featureOrder=FeatureListIncoming(driver,count1,featureName);
	                 int numberOfTns=countNumberTns(featureOrder, featureName,driver);
	                 ck=suspendedStatus(numberOfTns, featureOrder,featureName, driver);
	                 logger.info("ck"+ck);
	                 xpath911=".//*[@id='collapseFeature4']/div[2]/form/section/div[2]/div["+ck+"]/div[4]/div/input";
	                 butnxpath=".//*[@id='collapseFeature4']/div[2]/form/section/div[2]/div["+ck+"]/div[1]/div/label";
	                 TNxpath=".//*[@id='collapseFeature4']/div[2]/form/section/div[2]/div["+ck+"]/div[3]/div/input";
	                 
	                 String phoneline1 = driver.findElement(By.xpath(".//*[@id='collapseFeature4']/div[2]/form/section/div[2]/div["+ck+"]/div[2]/label")).getText();
	                 phoneline=phoneline1.substring(0, 8);
	                 logger.info("phoneline"+phoneline);
	                 //statusChx=".//*[@id='collapseFeature4']/div[2]/form/section/div[2]/div["+ck+"]/div[1]/div/label";
                 boolean status= driver.findElement(By.id("toggleButton4")).isSelected();
                 boolean statusCh= driver.findElement(By.xpath(".//*[@id='collapseFeature4']/div[2]/form/section/div[2]/div["+ck+"]/div[1]/div/label")).isSelected();
                 
                 if(statusCh==true)
                 {            	  
             	   status1="On";
             	   state=turnoff(driver, status1,br);             	  
                 }
                 else
                 {
            	   status1="Off";
            	   state=turnOn(driver, status1,br);            	  
                 }
                 
                 if(status==true)
                 {            	  
             	   status2="Enabled";
             	   state=turnoff1(driver, status2,br);             	  
                 }
                 else
                 {
            	   status2="Disabled";
            	   state=turnOn1(driver, status2,br);            	  
                 }
                 
                 TNValidation(driver,br, phoneline1);
                 
                 boolean status911= driver.findElement(By.xpath(xpath911)).isSelected();
    		     if(status911==true){
    		    	 focusClick(driver,driver.findElement(By.xpath(xpath911)),br);
    		    	 focusClick(driver,driver.findElement(By.xpath(xpath911)),br);}
    		     else
    		    	 focusClick(driver,driver.findElement(By.xpath(xpath911)),br);
                     		    	 
                 if(driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/section/div[3]/div/div[1]/div/div/p")).isDisplayed())
                 {
                	 statusTracker(br,"","","The 911 pop up is displayed","");
                 }
                 
                 focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[8]/div[2]/form/section/div[3]/div/div[2]/span[1]")),br);
                 
                 if(assertTrue(isElementPresent(By.id("emergencyConfirmationHotlineModal"))))
                 {
                	 statusTracker(br,"Fail","Verifiy if the cancel in 911 pop up is closes","The cancel is not closes the 911 pop up","the cancel should close the pop up");
                 }
                 else
                 {
                	 statusTracker(br,"Pass","Verifiy id the cancel in 911 pop up is closes","The cancel closes the 911 pop up","the cancel should close the pop up");
                 }
                 
                 String canbut="//html/body/div[12]/div/div[2]/span";
             	 String Savbut="//html/body/div[12]/div/div[2]/a/span";                  	 
             	focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
             	focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]/a")),br);
            	
         	   if(driver.findElements(By.xpath("//html/body/div[11]/div")).size()>0)
         	    {
         		   statusTracker(br,"","","The Unsaved pop up is displayed","");
         	    }
         	   
         	  focusClick(driver,driver.findElement(By.xpath(canbut)),br);
         	    if(driver.findElement(By.xpath("//html/body/header/div[4]/div[3]/div/nav/ul/li[2]/span")).isDisplayed())
         	     {
         		   statusTracker(br,"Pass","Verifiy id the cancel in unsaved pop up is closes","The cancel closes the unsaved pop up","the cancel should close the pop up");
         	     }
         	    else
         	     {
         		   statusTracker(br,"Fail","Verifiy id the cancel in unsaved pop up is closes","The cancel is not closes the unsaved pop up","the cancel should close the pop up");
         	     }
         	    
         	   focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]/a")),br);
         	  focusClick(driver,driver.findElement(By.xpath(Savbut)),br);
         	  
         	    do{
         	      }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
         	     if(driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[2]/a")).isDisplayed())
         	      {
         		   statusTracker(br,"Pass","Verifiy id the save in unsaved pop up is closes","The save navigated properly","the save should navigated properly");
         	      }
         	     else
         	      {
         		   statusTracker(br,"Fail","Verifiy id the save in unsaved pop up is closes","The save navigated properly","the save should navigated properly");
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
	                //statusTracker("end","","");
	      wb.close();
	      //driver.close();
	     
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


