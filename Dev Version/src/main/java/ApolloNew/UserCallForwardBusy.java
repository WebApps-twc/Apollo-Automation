package ApolloNew;


import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class UserCallForwardBusy extends CommonFunctions {

	
	String table, tns[];
    String tlimit,username,pwd,TN,TN1,NonAccountcode,acccode;
    int tncount;
    
    String xpath_Accountcode;
	String xpath_GPS;
	String xpath_divCount;
	String id_CFBAdminTNStatus;
	String xpath_TNxpath;
	String css_submit;
	String css_loader;
	String xpath_home_shortcut;
	String id_CFBUserTNStatus;


	public UserCallForwardBusy(String path) {
		this.path = path;
	}

	/*public UserCallForwardBusy(String path, String file1, String file2) {
		this.path = path;
		this.path1 = file1;
		this.path2 = file2;
	}
		*/ 
	
	 
	  public void Turnoff(String br,WebDriver driver,String d,int featureOrder) throws Exception
	  {
		  String st="OFF";
		    
		  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]/form/div/div[1]/div/div/div/label")),br);
		  Thread.sleep(1000);
	      
	  
	  focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]/form/div/div["+featureOrder+"]/button[2]")),br);
	  
	   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	     {
	      
	       statusTracker(br,"Pass","Verify order process for changing from On to "+st," Successfully be able to process order","Successfully processed order");                                                                   
	     }
	      else
	     {
	       
	       statusTracker(br,"Fail","Verify order process for changing from On to "+st,"Not able to process order"+ driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div")).getText(),"Successfully processed order");
	     }
	   
	   
	  }
	  
	  public void EditTN(String br,WebDriver driver,String d,int featureOrder,String TN) throws Exception
	  {
		  TN=TN.substring(0,8);
		  int divcount;String st = null;
		  divcount=driver.findElements(By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[2]/form/div/div")).size();
		  logger.info("divcount is........."+divcount);
		//Non Verified Account code  
		  if (divcount==5)
		  {
			  logger.info("Edit TN");
		
		  
		  driver.findElement(By.name("forwardBusyCallTo")).clear();
		  TN1=TN+randomNO(3333,9999);
		   driver.findElement(By.name("forwardBusyCallTo")).sendKeys(TN1);
		  for(int i=1;i<100;i++){}
		  driver.findElement(By.name("forwardBusyCallAccount")).clear();
		  driver.findElement(By.name("forwardBusyCallAccount")).sendKeys(acccode);
		  for(int i=1;i<100;i++){}

		  focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]/form/div/div["+featureOrder+"]/button[2]")),br);
	
	   
	   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	     {
	      
	       statusTracker(br,"Pass","Verify order process for  editing TN with non verified Account code "," Successfully be able to process order with non verified Account code","Successfully processed order with non verified Account code");                                                                   
	     }
	      else
	     {
	       
	       statusTracker(br,"Fail","Verify order process for editing TN with non verified Account code ","Not able to process order for non verified Account code"+ driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div")).getText(),"Successfully processed order with non verified Account code");
	     }
		  }
	   //Verified Account code
		  else if (divcount==6)
		  {
			 
			  driver.findElement(By.name("forwardBusyCallTo")).clear();
		       TN1=TN+randomNO(3333,9999);
			   driver.findElement(By.name("forwardBusyCallTo")).sendKeys(TN1);
			  for(int i=1;i<100;i++){}
			  if(driver.findElement(By.id("second")).isSelected())
			  {
			   focusClick(driver, driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[3]/form/div/div[4]/label")),br);

			  driver.findElement(By.name("forwardBusyCallAccount")).clear();
			  driver.findElement(By.name("forwardBusyCallAccount")).sendKeys(acccode);
			  
			  for(int i=1;i<100;i++){}
			  }
			  driver.findElement(By.name("forwardBusyCallAccount")).clear();
			  driver.findElement(By.name("forwardBusyCallAccount")).sendKeys(acccode);
			  
			  for(int i=1;i<100;i++){}

			  focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]/form/div/div[6]/button[2]")),br);
		
		   
		   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
		     {
		      
		       statusTracker(br,"Pass","Verify order process for editing TN with  verified Account code "," Successfully be able to process order with  verified Account code","Successfully processed orderwith  verified Account code");                                                                   
		     }
		      else
		     {
		       
		       statusTracker(br,"Fail","Verify order process for editing TN with  verified Account code ","Not able to process order for  verified Account code"+ driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div")).getText(),"Successfully processed order with  verified Account code");
		     }  
			  
			  
		  }
		  //Normal TN
		  else
		  {
			  
			  driver.findElement(By.name("forwardBusyCallTo")).clear();
			  TN1=TN+randomNO(3333,9999);
			   driver.findElement(By.name("forwardBusyCallTo")).sendKeys(TN1);
		
			  
			   focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]/form/div/div[4]/button[2]")),br);
			   
			   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
			     {
			       
			       statusTracker(br,"Pass","Verify order process for editing TN"," Successfully be able to process order ","Successfully processed order ");                                                                   
			     }
			      else
			     {
			       
			       statusTracker(br,"Fail","Verify order process for editing TN","Not able to process order "+ driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div")).getText(),"Successfully processed order ");
			     }
		  }
	  }
	  
	 
	  public String TNcheck(String br,String TN,String acc, String check,WebDriver driver,int divcount) throws Exception
	  {
	         String schk="Fail";
	         driver.findElement(By.name("forwardBusyCallTo")).clear();
			 driver.findElement(By.name("forwardBusyCallTo")).sendKeys(TN);
			
			  
			//Non Verified Account code Or Verified 
		   	  if (divcount==5||divcount==6)
		   	  {
		   		  
		         
		       driver.findElement(By.name("forwardBusyCallAccount")).clear();
				driver.findElement(By.name("forwardBusyCallAccount")).sendKeys(acc);
				
				  
				 
		   	  }
		   	 focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]/form/div/div["+divcount+"]/button[2]")),br);
			Thread.sleep(4000); 
		    
				  if(driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div")).isDisplayed())
				  	  {
				  		  statusTracker(br,"Pass","Verify if error message is displayed when adding "+check+" TN","Error message is displayed: "+ driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div")).getText(),"Error message should be displayed");
				  		  schk="Pass";
				  	  }
		  	  	 else
		  	  	 {
		  	  		 statusTracker(br,"Fail","Verify if error message is displayed when adding "+check+" TN","Error message is not displayed","Error message should be displayed");
		  	  		 schk="Fail";
		  	  	 }
		            	  
	  return schk;
	  }  
	  
	  

	public void ErrorValidation(String br,WebDriver driver,String TN1)throws Exception
	  {
		
		  int divcount=driver.findElements(By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[2]/form/div/div")).size();
	   	  logger.info("Count is"+divcount);
	   	  if(divcount==6)
	   	  {
	   		  if(driver.findElement(By.id("second")).isSelected())
	   		  {
	   			 driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]/form/div/div[4]/label")).click();
	   			  
	   		  }
	   		  
	   		  
	   	  }
		  String schk ="Pass";  
		  schk=TNcheck(br,"0227845619","3784","first digit 0",driver,divcount);
		  schk=TNcheck(br,"1227845619","3784","first digit 1",driver,divcount);
		  schk=TNcheck(br,"9007845619","3784","TN with starting 900",driver,divcount);
		  schk=TNcheck(br,"9767845619","3784","TN with starting 976",driver,divcount);
		  schk=TNcheck(br,"9945","3784","Invalid",driver,divcount);
		  schk=TNcheck(br,"","3784","Blank",driver,divcount);
		  schk=TNcheck(br,TN1,"","Blank Accountcode",driver,divcount);
		  schk=TNcheck(br,TN1,"3","Account code less than specified lenght",driver,divcount);
		  
	  }
	public void Turnon(String br,WebDriver driver,String d,int featureOrder,String TN) throws Exception
	  {
		TN=TN.substring(0,8);
		String st="On";
		 
		  logger.info("Turn On");
		  int divcount;
		  divcount=driver.findElements(By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[2]/form/div/div")).size();
		  logger.info("divcount"+divcount);
		//Non Verified Account code  
		  if (divcount==5)
		  {
			  
			  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]/form/div/div[1]/div/div/div/label")),br);
		  driver.findElement(By.name("forwardBusyCallTo")).clear();
		TN=TN+randomNO(3333,9999);
		   driver.findElement(By.name("forwardBusyCallTo")).sendKeys(TN);
		  for(int i=1;i<100;i++){}
		  driver.findElement(By.name("forwardBusyCallAccount")).clear();
		  driver.findElement(By.name("forwardBusyCallAccount")).sendKeys(acccode);
		  for(int i=1;i<100;i++){}
		  focusClick(driver,driver.findElement(By.cssSelector(".//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]/form/div/div[5]/button[2]")),br);
	   
	   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
	     {
	     
	       statusTracker(br,"Pass","Verify order process for changing from Off to "+st+"with non verified Account code "," Successfully be able to process order with non verified Account code","Successfully processed orderwith non verified Account code");                                                                   
	     }
	      else
	     {
	    
	       statusTracker(br,"Fail","Verify order process for changing from Off to "+st+"with non verified Account code ","Not able to process order for non verified Account code"+ driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div")).getText(),"Successfully processed order with non verified Account code");
	     }
		  }
	   //Verified Account code
		  else if (divcount==6)
		  {
			  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]/form/div/div[1]/div/div/div/label")),br);
			  for(int i=1;i<100;i++){}
			  driver.findElement(By.name("forwardBusyCallTo")).clear();
			  TN1=TN+randomNO(3333,9999);
			   driver.findElement(By.name("forwardBusyCallTo")).sendKeys(TN1);
			  for(int i=1;i<100;i++){}
			  if(driver.findElement(By.id("second")).isSelected())
			  {
			   
			   Thread.sleep(2000);
			  driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[3]/form/div/div[4]/label")).click();
			  driver.findElement(By.name("forwardBusyCallAccount")).clear();
			  driver.findElement(By.name("forwardBusyCallAccount")).sendKeys(acccode);
			  
			  for(int i=1;i<100;i++){}
			  }
			  driver.findElement(By.name("forwardBusyCallAccount")).clear();
			  driver.findElement(By.name("forwardBusyCallAccount")).sendKeys(acccode);
			  for(int i=1;i<100;i++){}
			  focusClick(driver,driver.findElement(By.cssSelector(".//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]/form/div/div[6]/button[2]")),br);
		   
		   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
		     {
		      
		       statusTracker(br,"Pass","Verify order process for changing from Off to "+st+"with  verified Account code "," Successfully be able to process order with  verified Account code","Successfully processed orderwith  verified Account code");                                                                   
		     }
		      else
		     {
		       
		       statusTracker(br,"Fail","Verify order process for changing from Off to "+st+"with  verified Account code ","Not able to process order for  verified Account code"+ driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div")).getText(),"Successfully processed order with  verified Account code");
		     }  
			  
			  
		  }
		  //Normal TN
		  else
		  {
			  
			  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]/form/div/div[1]/div/div/div/label")),br);
			  for(int i=1;i<100;i++){}
			  driver.findElement(By.name("forwardBusyCallTo")).clear();
			  TN1=TN+randomNO(3333,9999);
			   driver.findElement(By.name("forwardBusyCallTo")).sendKeys(TN1);
			 Thread.sleep(2000);
			 focusClick(driver,driver.findElement(By.cssSelector(".//*[@id='collapseFeature1']/div[2]/div[4]/div[1]/div[3]/form/div/div[4]/button[2]")),br);
			  
			   if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
			     {
			      
			       statusTracker(br,"Pass","Verify order process for changing from Off to On"," Successfully be able to process order ","Successfully processed order ");                                                                   
			     }
			      else
			     {
			       
			       statusTracker(br,"Fail","Verify order process for changing from Off to On","Not able to process order "+ driver.findElement(By.xpath("//html/body/section/div[5]/div[2]/div[1]/div/div")).getText(),"Successfully processed order ");
			     }
		  }
		  
	  }
	  
	
	  public String randomNO(int max, int min)
	  {
	  	  	int Max=max;
	  	  	int Min=min;
	  	  	double random1=Min + (int)(Math.random() * ((Max - Min) + 1));
	  		logger.info("random"+random1);
	  		int random2=(int)random1;
	  		logger.info("random2"+random2);
	  		String s1 = new Integer(random2).toString();
	  		logger.info("TN"+s1);
	  		return(s1);
	  		
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
						if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
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
	
         xpath_Accountcode="//aside/ul/li[1]/strong";
		 xpath_GPS="//html/body/section/div[2]/section/div/a[3]";
		 xpath_divCount="//html/body/section/div";
	     id_CFBAdminTNStatus="checkCall Forward Busy0";
		 xpath_TNxpath="//div[@id='collapseFeature2']/div[2]/form/div[5]/div/label";
		 css_submit="#collapseFeature2 > div.accordian-body.in > form[name=\"featureForm\"] > div.accordian-actions.ng-scope > button.btn.btn-primary";
		 css_loader="img[alt='icon-loading.gif']";
		 xpath_home_shortcut="//section[@id='homepage-shortcuts']/div/a[3]/span/div";
		id_CFBUserTNStatus="toggleButton2Forward Busy Calls";
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
	          
	          
	          NonAccountcode=sheet2.getCell(8, loc).getContents();
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
	        	  if(!(InternalException(driver,br)))
                  {

	        	  switchTo(driver, "Admin",tlim,br);

	        	  focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]/a")),br);
	              	                  
	        	  do{
                  }while(driver.findElements(By.xpath("//html/body/section/div[2]/section/div/a[3]")).size()<0);
	                  
	              if(driver.findElement(By.cssSelector("h3")).getText().equals("Account Codes"))
	        	  { 
	            	  acccode = driver.findElement(By.xpath(xpath_Accountcode)).getText();
	        		  logger.info(acccode);
	        	  }
	              focusClick(driver,driver.findElement(By.xpath("//html/body/section/div[2]/section/div/a[3]")),br);

	              System.out.println("b");
                  
                  driver.manage().timeouts().implicitlyWait(tlim,TimeUnit.SECONDS);

                  System.out.println("checkpoint1");
	              
	             
              		if(!(InternalException(driver,br)))
	                    {

              			logger.info("c");  
          			  int featureOrder=0;String featureName="CF";
          			  focusClick(driver,driver.findElement(By.xpath(".//*[@id='accordion_"+featureName+"']/h3")),br);    	  
							System.out.println("c");

						int divval=3;
						try
  	       				{
  	       				if(driver.findElement(By.xpath(".//*[@id='collapseFeature_"+featureName+"']/div[3]/div/h2")).isDisplayed())
  	       				{
  	       				statusTracker(br,"","CF Modal pop up is  displayed","","");
  	       			 driver.findElement(By.xpath(".//*[@id='collapseFeature_CF']/div[3]/div/button")).click();
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
			            
			              System.out.println(TN1);
			              logger.info("c");
		
			              if(TN1!=null)
			              {
			              driver.findElement(By.linkText("Switch to User mode")).click();
		
			            
			              Thread.sleep(4000);
			              driver.findElement(By.xpath(xpath_home_shortcut)).click();
			              
			              
			              focusDropdown(driver,"//html/body/header/div[4]/div[3]/div/div/span",TN1,br);
			              do{
			            	  //logger.info("Processing!" +chk);
			            	 
			              }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
			              focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature1 > div.accordian-header > div.header-right")),br);
			            
			             
			        	boolean status=driver.findElement(By.id(id_CFBUserTNStatus)).isSelected();
			        	featureOrder=driver.findElements(By.xpath("//html/body/section/div[5]/div[2]/div[4]/div[1]/div[2]/form/div/div")).size();
			            logger.info("Status is"+status);
			            logger.info("order is"+featureOrder);
			            if (status)
			            	  {
			            	 Turnoff(br,driver,acccode,featureOrder);
			                  EditTN(br,driver,acccode,featureOrder,TN1);
			                  Turnon(br,driver,acccode,featureOrder,TN1);
			                  ErrorValidation(br,driver,TN1);
			                 
			            	  }
			              else
			            	  {
			            	  Turnon(br,driver,acccode,featureOrder,TN1);
			                  EditTN(br,driver,acccode,featureOrder,TN1);
			                  Turnoff(br,driver,acccode,featureOrder);
			                   ErrorValidation(br,driver,TN1);
			                  
			            	  }
			           
			            String canbut="//html/body/div[2]/div/div[2]/span";
		            	  String Savbut="//html/body/div[2]/div/div[2]/a/span";                  	 
		            	  unsave(driver,br,canbut,Savbut);
			            	  	
		                
		              first=1;
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
	}