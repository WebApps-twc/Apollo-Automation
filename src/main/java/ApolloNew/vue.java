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

public class vue extends CommonFunctions {

	
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


	public vue(String path) {
		this.path = path;
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

	              for(int i=1;i<40;i++){}
	              
	              driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);  
            		if(!(InternalException(driver,br)))
	                    {

		
			              if(TN1!=null)
			              {
			              
		                
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
