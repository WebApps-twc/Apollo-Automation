package ProdVersionFeaturesFile.CustomRouting.AdminMode;

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
import org.openqa.selenium.interactions.Actions;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class AutoAttendant extends CommonFunctions {
	
	String table, tns[];
    String tlimit,username,pwd;
    int tncount;				
	
    String phoneline,phoneline_ac,Acccode;
	int rank[]= new int[50];
	
	int c_sequence;
	String name_for_rank[]= new String[40];
	String price, rank_channels;

	public AutoAttendant(String path) {
		this.path = path;
	}
 
	public void featurestate(WebDriver driver,String br) throws Exception
    {
 	   boolean stus=driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[1]")).isSelected();
	       System.out.println("stus"+stus);
	       String Frm="Enabled", To="Disabled";
	      
	       if(stus==true){
	    	  Frm="Enabled";
	          To="Disabled";}
	       else{
	    	  Frm="Disabled";
	    	  To="Enable";}
	      
	       focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[1]/label")),br); 

	    	  focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br); 

	    	  do{
		       }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
        	
	    		if(driver.findElement(By.id("dataSaveSucess")).isDisplayed() )
	    		 {
	    			statusTracker(br,"Pass","Verify order processing for AutoAttendant from "+ Frm +" to "+ To,"Order processing has processed successfully","Order should be processed successfully");
	    			//schk="Pass";
	    		 }
	    		else
	    		 {
	    			statusTracker(br,"Fail","Verify order processing for AutoAttendant from "+ Frm +" to "+ To,"Order processing has failed"+driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[3]/div/div/ul")).getText(),"Order should be processed successfully");	
	    			Thread.sleep(1000);
	    			//schk="Fail";
	    		 }	
    }
    
    public void tunon(WebDriver driver,String br) throws Exception
    {
 	   String Frm1="", To1="";
 	   boolean alwsstatus=driver.findElement(By.id("alwaysTime")).isSelected();
	  	    System.out.println("alwsstatus"+alwsstatus);
	    	if(alwsstatus==true){
	  	    	  Frm1="Always";
	  	          To1="Specific times";
	  	        focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[4]/div[2]/label")),br); }
	  	    else{
	  	    	  Frm1="Specific times";
	  	    	  To1="Always";
	  	    	focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[4]/div[1]/label")),br); 
}	
	    	
	    	focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br); 

	    	  do{
		       }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
     	
	    		if(driver.findElement(By.id("dataSaveSucess")).isDisplayed() )
	    		 {
	    			statusTracker(br,"Pass","Verify order processing for AutoAttendant from "+ Frm1 + " to " + To1,"Order processing has processed successfully","Order should be processed successfully");
	    			//schk="Pass";
	    		 }
	    		else
	    		 {
	    			statusTracker(br,"Fail","Verify order processing for AutoAttendant from "+ Frm1 + " to " + To1,"Order processing has failed"+driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[3]/div/div/ul")).getText(),"Order should be processed successfully");	
	    			Thread.sleep(1000);
	    			//schk="Fail";
	    		 }
    }
    
    public void numrings(WebDriver driver, String n,String br) throws Exception
    {
 	   String n1=n;
 	  focusDropdown(driver,"//html/body/section/div[4]/div[2]/form/div[6]/span",n1,br);
 	  //focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[6]/span/select/option["+n1+"]")),br); 

	    	focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br); 

	    	  do{
		       }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
	    	  if(driver.findElement(By.id("dataSaveSucess")).isDisplayed() )
	    		 {
	    			statusTracker(br,"Pass","Verify order processing for AutoAttendant for changing the Rings to " + n1,"Order processing has processed successfully","Order should be processed successfully");
	    			//schk="Pass";
	    		 }
	    		else
	    		 {
	    			statusTracker(br,"Fail","Verify order processing for AutoAttendant for changing the Rings to " + n1,"Order processing has failed"+driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[3]/div/div/ul")).getText(),"Order should be processed successfully");	
	    			Thread.sleep(1000);
	    			//schk="Fail";
	    		 } 		    	  	    	  			    	
    }
    
    public void Errorvali(WebDriver driver,String br) throws Exception
    {
    	focusClick(driver,driver.findElement(By.linkText("Edit")),br); 
 	   
 	   int lst=driver.findElements(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/section/div[2]/div")).size();
 	   System.out.println("lst"+lst);
 	   if(lst>2)
 	   {
 		  focusClick(driver,driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/div[3]/div[2]/a")),br); 
 		   
 		   driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/section/div[2]/div/div[1]/input")).clear();
	    	   driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/section/div[2]/div/div[1]/input")).sendKeys("");
	    	   driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/section/div[2]/div/div[2]/input")).clear();
	    	   driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/section/div[2]/div/div[2]/input")).sendKeys("");
	    	   
	    	   focusClick(driver,driver.findElement(By.xpath("//div[@id='editModal']/div/div[2]/span[2]")),br); 
		            
	            do{
			       }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
	            
	            if(driver.findElements(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/div[4]")).size()>0)
	            {
	            	statusTracker(br,"Pass","Verify if error message is displayed when adding TN with blank name","Error message is displayed: "+ driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/div[4]/div/div/ul")).getText(),"Error message should be displayed");		         		  
	            }
	            
	            focusClick(driver,driver.findElement(By.cssSelector("#editModal > div.modal-container > div.modal-footer > span.btn.btn-secondary")),br); 

	            focusClick(driver,driver.findElement(By.linkText("Edit")),br); 
	            
	           int val1=0,val2=0; 
	           		            
 		   for(int i=1;i<=2;i++)
 		   {
 			  focusClick(driver,driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/section/div[2]/div["+i+"]/div[3]/span")),br); 

 			  do{
			       }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
	             if(driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/div[4]")).isDisplayed() && val1>=0)
	             {
	            	statusTracker(br,"Pass","Verify if error message is displayed when deleting TN used in menu tree","Error message is displayed: "+ driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/div[4]/div/div/ul")).getText(),"Error message should be displayed");		         		  
	            	val1=1;
	             }
	             else if(val2>=0)
	             {
	            	  val2=1;
	             }	    		   
 	       }
 		   
 		   if(val2>0)
 		   {
 			  focusClick(driver,driver.findElement(By.xpath("//div[@id='editModal']/div/div[2]/span[2]")),br); 		            
		            do{
				       }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed()); 
		            if(driver.findElement(By.id("dataSaveSucess")).isDisplayed() )
			    	 {
				    	statusTracker(br,"Pass","Verify order processing for Deleting the TN from memberlist","Order processing has processed successfully","Order should be processed successfully");			    					            	 					    		  
			    	 }
			    	else
			    	 {
			    		statusTracker(br,"Fail","Verify order processing for Deleting the TN from memberlist","Order processing has failed","Order should be processed successfully");			    					            	 					    		  
			    	 } 
 		    }	    		   
 	   }
    }
             
    public void MenuTree(WebDriver driver,String br) throws Exception
	  {
    	
    	if(br.equals("IE"))	  
	       {
    		focusDropdown(driver,"//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[1]/div[2]/div/span","2",br);
        	
     	   int num1=driver.findElements(By.xpath("//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[1]/div[4]/div/span/select/option")).size();
     	   String num2=randomNO(1,num1);
     	  focusDropdown(driver,"//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[1]/div[4]/div/span",num2,br);
     	    	   
     	 focusDropdown(driver,"//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[2]/div[2]/div/span","3",br);
     	focusDropdown(driver,"//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[2]/div[2]/div/span","4",br);
     	  focusDropdown(driver,"//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[4]/div[2]/div/span","5",br);
     	   int nu1=driver.findElements(By.xpath("//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[4]/div[4]/div/span/select/option")).size();
     	   String nu2=randomNO(1,nu1);
     	  focusDropdown(driver,"//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[4]/div[4]/div/span",nu2,br);
     	   focusDropdown(driver,"//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[5]/div[2]/div/span","6",br);
     	   }
	       else
	       {
	    	   	focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[1]/div[2]/div/span/select/option[2]")),br); 

	    	   int num1=driver.findElements(By.xpath("//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[1]/div[4]/div/span/select/option")).size();
	    	   String num2=randomNO(1,num1);
	    	   focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[1]/div[4]/div/span/select/option["+num2+"]")),br); 
	    	    	   
	    	  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[2]/div[2]/div/span/select/option[3]")),br); 
	    	  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[3]/div[2]/div/span/select/option[4]")),br); 
	    	 focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[4]/div[2]/div/span/select/option[5]")),br); 
	    	   int nu1=driver.findElements(By.xpath("//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[4]/div[4]/div/span/select/option")).size();
	    	   String nu2=randomNO(1,nu1);
	    	  focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[4]/div[4]/div/span/select/option["+nu2+"]")),br); 
	    	 focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[8]/div[1]/section/div[2]/div[5]/div[2]/div/span/select/option[6]")),br); 
	       }	       	
 	   
 	  focusClick(driver,driver.findElement(By.cssSelector("button.btn.btn-primary")),br); 
	    	  do{
		       }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
	    	  if(driver.findElement(By.id("dataSaveSucess")).isDisplayed() )
	    		 {
	    			statusTracker(br,"Pass","Verify order processing for AutoAttendant for Editing Menu Tree","Order processing has processed successfully","Order should be processed successfully");
	    			//schk="Pass";
	    		 }
	    		else
	    		 {
	    			statusTracker(br,"Fail","Verify order processing for AutoAttendant for Editing Menu Tree","Order processing has failed"+driver.findElement(By.xpath("//html/body/section/div[4]/div[2]/form/div[3]/div/div/ul")).getText(),"Order should be processed successfully");	
	    			Thread.sleep(1000);
	    			//schk="Fail";
	    		 } 
 	   
	    }
             	     
     public void NmeDir(WebDriver driver,String br) throws Exception
      {
             
    	focusClick(driver,driver.findElement(By.linkText("Edit")),br);   	 
     	
     	int n1=driver.findElements(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/div[2]/span/select/option")).size();
     	String num=randomNO(1,n1);
     	
     	if(n1>1)
     	{
     	//focusDropdown(driver,"//html/body/div[2]/div/div[1]/div[2]/div/form/div[2]/span",num,br);
     	//focusClick(driver,driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/div[2]/span/select/option["+num+"]")),br); 
        
	       if(br.equals("IE"))	  
	       {
	    	   focusDropdown(driver,"//html/body/div[2]/div/div[1]/div[2]/div/form/div[2]/span",num,br);
	       }
	       else
	       {
	    	   focusClick(driver,driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/div[2]/span/select/option["+num+"]")),br);
	       }	    	  
     	System.out.println("num"+num);
     	driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
         driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Home");
         driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
         driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Line");
         focusClick(driver,driver.findElement(By.cssSelector("div.col-3.align-right > button.btn.btn-primary")),br); 
         do{
		       }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
         
         focusClick(driver,driver.findElement(By.xpath("//div[@id='editModal']/div/div[2]/span[2]")),br); 
         
         do{
		       }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
       	
	    		if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	    		 {
	    			statusTracker(br,"Pass","Verify order processing for adding lines to memberlist","Order processing has processed successfully","Order should be processed successfully");
	    			//schk="Pass";
	    		 }
	    		else
	    		 {
	    			statusTracker(br,"Fail","Verify order processing for adding lines to memberlist","Order processing has failed"+driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/div[4]/div/div/ul")).getText(),"Order should be processed successfully");	
	    			Thread.sleep(1000);
	    			//schk="Fail";
	    		 }
	    		Thread.sleep(3000);
	    		focusClick(driver,driver.findElement(By.linkText("Edit")),br); 
	    		Thread.sleep(3000);
	    		focusClick(driver,driver.findElement(By.linkText("Edit names")),br); 
	    		String rdne=randomNO(1,100);
	    		
	    		driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/section/div[2]/div/div[1]/input")).clear();
	    	    driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/section/div[2]/div/div[1]/input")).sendKeys("Office2");
	    	    driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/section/div[2]/div/div[2]/input")).clear();
	    	    driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/section/div[2]/div/div[2]/input")).sendKeys("Line1242");
	    	    
	    	    focusClick(driver,driver.findElement(By.xpath("//div[@id='editModal']/div/div[2]/span[2]")),br); 
	            
	            do{
			       }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
	          	
		    		if(driver.findElement(By.id("dataSaveSucess")).isDisplayed() )
		    		 {
		    			statusTracker(br,"Pass","Verify order processing for Editing the memberlist names","Order processing has processed successfully","Order should be processed successfully");
		    			//schk="Pass";
		    		 }
		    		else
		    		 {
		    			statusTracker(br,"Fail","Verify order processing for Editing the memberlist names","Order processing has failed"+driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/form/div[4]/div/div/ul")).getText(),"Order should be processed successfully");	
		    			Thread.sleep(1000);
		    			//schk="Fail";
		    			focusClick(driver,driver.findElement(By.xpath(".//*[@id='editModal']/div/div[2]/span[1]")),br); 
		    		 }	    		
		    		
     	}
     	else
     		focusClick(driver,driver.findElement(By.xpath(".//*[@id='editModal']/div/div[2]/span[1]")),br);   
         
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
	            	
	              System.out.println("inside loop");
	            
	              switchTo(driver, "Admin",tlim,br);
	                  
	              focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]/a")),br); 
	              
	              int purchase = driver.findElements(By.xpath("//html/body/section/section/div[2]/aside/ul/li")).size();
	  	    	System.out.println("Feature"+driver.findElement(By.xpath("//html/body/section/section/div[2]/aside/ul/li[4]")).getText());
	  	    	String Feature="False";
	  	    	for(int i=1;i<=purchase;i++)
	  	    	{
	  	    		if(driver.findElement(By.xpath("//html/body/section/section/div[2]/aside/ul/li["+i+"]")).getText().equals("• Auto Attendants (1)") || driver.findElement(By.xpath("//html/body/section/section/div[2]/aside/ul/li["+i+"]")).getText().equals("• Auto Attendants (2)"))
	  	    		{
	  	    			statusTracker(br,"","The Auto Attendant Feature is present","","");
	  	    			Feature="true";
	  	    		}
	  	    	}
	  	    	
	  	     if(Feature.equals("true"))
	  	     {
	  	    	focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[5]")),br);     
	  	      Thread.sleep(3000);
	  	    if(!(InternalException(driver,br)))
            {
	  	    	focusClick(driver,driver.findElement(By.cssSelector("span.accordian-info.ng-binding")),br); 
	  	      
	  	      String status = driver.findElement(By.xpath("//html/body/section/div[4]/div[1]/div/div/h4")).getText();
	  	      System.out.println("status"+status);
	  	      if(status.equals("DISABLED") || status.equals("ENABLED"))
	  	       {	            	    	  
	  	    	featurestate(driver,br);	    	    	
	  	    	tunon(driver,br);
	  	    	String num=randomNO(1,4);
	  	    	numrings(driver,num,br);
	  	    	
	  	    	featurestate(driver,br);	    	    	
	  	    	tunon(driver,br);
	  	    	num=randomNO(6,10);
	  	    	numrings(driver,num,br);       	    		    		
	  	    	
	  	    	NmeDir(driver,br);
	  	    	num="5";
	  	    	numrings(driver,num,br);  
	  	    	   		    	
	  	    	MenuTree(driver,br);
	  	    	Errorvali(driver,br);
	  	    	  
	  	       }
	  	      	  	      
	  	     }
	        
        
	   }
	  else
	  	 statusTracker(br,"The Auto Attendant Feature is not present","","","");           
                  
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

	     
	    }
	  }
	  
	  private boolean isElementPresent(WebDriver driver, By xpath) {
		// TODO Auto-generated method stub
		return false;
	}
	}

