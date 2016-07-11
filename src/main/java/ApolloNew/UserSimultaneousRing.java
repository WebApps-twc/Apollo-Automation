package ApolloNew;
import java.io.File;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class UserSimultaneousRing extends CommonFunctions
{
                String table, tns[],Acccode,NonVacc;
                String tlimit,username,pwd,TN1,schk1="";
                int tncount,f=0;
                String phoneline,phoneline_ac,phoneline_midtn,phoneline_lastfour;
                String butnxpath="//*[@id='collapseFeature3']/div[2]/div[1]/label/span[1]";
                String svexpath="#collapseFeature3 > div.accordian-body.in > div.ng-scope > form[name=\"featureForm\"] > div.accordian-actions > button.btn.btn-primary";
  /*public UserSimultaneousRing(String path, String file1, String file2)
  {
	    this.path = path;
		this.path1 = file1;
		this.path2 = file2;
  }*/
  
  private boolean isElementPresent(String br,WebDriver driver, By by)
  {
                  try{
                                  driver.findElement(by);
                                  return true;
                  }
                  catch(NoSuchElementException e){
                	  
                                  return false;
                  }
  }
  
  public UserSimultaneousRing(String s)
  {
                  this.path = s;
  }
  
  public String Select_TN(String br,WebDriver driver,String Featurename,int count)
	{
	Featurename="{\"name\":\"SimultaneousRing_FeatureName\",\"value\":\"Simultaneous Ring\",\"parameters\":[],\"text\":\"Simultaneous Ring\",\"exampleText\":\"Simultaneous Ring\"}";
		int numberOfTns=countNumberTns(count,Featurename,driver);
		System.out.println(numberOfTns);
		String TN="";
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		for(int j=0;j<numberOfTns;j++)
		{
			try
			{
			if(driver.findElement(By.xpath(".//*[@id='collapseFeature"+count+"']/div[2]/form/div["+(6+j)+"]/i")).isDisplayed())
			{
				System .out.println("TN is suspended");
				continue;
			}
			else if(driver.findElement(By.id("check"+Featurename+j)).isSelected())
			{ 
				System.out.println("tn2");

				driver.findElement(By.xpath(".//*[@id='collapseFeature"+count+"']/div[2]/form/div["+(6+j)+"]/label")).click();
				System.out.println("tn22");
				driver.findElement(By.cssSelector("#collapseFeature"+count+" > div.accordian-body.in > form[name=\"featureForm\"] > div.accordian-actions > button.btn.btn-primary")).click();
			   int chk=0;
				do{
                 
					
                 chk++;
               }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
				Thread.sleep(2000);
				driver.findElement(By.xpath(".//*[@id='collapseFeature"+count+"']/div[2]/form/div["+(6+j)+"]/label")).click();
				/*driver.findElement(By.id("check"+Featurename+j)).click();*/
				driver.findElement(By.cssSelector("#collapseFeature"+count+" > div.accordian-body.in > form[name=\"featureForm\"] > div.accordian-actions > button.btn.btn-primary")).click();
			    chk=0;
				do{
                 
					
                 chk++;
               }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
					if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
		             {
		             	TN=driver.findElement(By.xpath(".//*[@id='collapseFeature"+count+"']/div[2]/form/div["+(6+j)+"]/label")).getText();    
		             	schk1="Pass";
		             	break;
		             }
					else
		           	  {
		           	  System.out.println("This feature cannot be  Enabled because "+driver.findElement(By.cssSelector("div.ng-scope > ul > li.ng-scope.ng-binding")).getText());   
		           	statusTracker(br,"Fail","","This feature cannot be  Enabled because "+driver.findElement(By.cssSelector("div.ng-scope > ul > li.ng-scope.ng-binding")).getText(),"");  
		           	  TN=null;
		           	  }
			}
			else
			{
				/*driver.findElement(By.id("check"+Featurename+j)).click();*/
				driver.findElement(By.xpath(".//*[@id='collapseFeature"+count+"']/div[2]/form/div["+(6+j)+"]/label")).click();
				driver.findElement(By.cssSelector("#collapseFeature"+count+" > div.accordian-body.in > form[name=\"featureForm\"] > div.accordian-actions > button.btn.btn-primary")).click();
			   int chk=0;
				do{
                 
					
                 chk++;
               }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
             if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
             {
             	TN=driver.findElement(By.xpath(".//*[@id='collapseFeature"+count+"']/div[2]/form/div["+(6+j)+"]/label")).getText();    
             	  schk1="Pass";
             	break;
             }
             else
           	  {
           	  System.out.println("This feature cannot be  Enabled because "+driver.findElement(By.cssSelector("div.ng-scope > ul > li.ng-scope.ng-binding")).getText());   
           	 TN=null;
           	  }
				
			}
			}
			catch(Exception e)
			  {numberOfTns++;
			  }
			
		}
	  return TN;
	
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
			 if(driver.findElement(By.xpath("//div[@id='collapseFeature"+featureOrder+"']/div[2]/form/div["+(6+i)+"]/label")).isDisplayed())
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
  public String turnoff(String br,WebDriver driver, String status, String acc)
  {
                  String initialstate=status, chngetostate="Off",state="Fail", accst=acc;
                  
                  driver.findElement(By.xpath(butnxpath)).click();
                  
                  for(int i=1;i<100;i++){}
      
      driver.findElement(By.cssSelector(svexpath)).click();
      int chk=0;
      do{
          //System.out.println("Processing!" +chk);
          chk++;
        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

      if(driver.findElements(By.id("dataSaveSucess")).size()>0)
        {
          System.out.println("Success");
          statusTracker(br,"Pass","Verify order process for changing status from: "+initialstate +" to: "+chngetostate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
        }
         else
        {
          System.out.println("Fail");
          statusTracker(br,"Fail","Verify order process for changing status from: "+initialstate +" to: "+chngetostate+ " with "+accst,"Successfully be able to process order","Unable to process successfully");
        }
      for(int i=1;i<100;i++){}
      
      driver.findElement(By.xpath(butnxpath)).click();
      if(driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).isDisplayed())
      {
    	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).clear();
		  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).sendKeys("8164256937");
      }
      else
      {
    	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[3]/input")).clear();
		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[3]/input")).sendKeys("8164256937");  
      }
      for(int i1=1;i1<100;i1++){}
      
      driver.findElement(By.cssSelector(svexpath)).click();
      
      do{
          //System.out.println("Processing!" +chk);
          chk++;
        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

      if(driver.findElements(By.id("dataSaveSucess")).size()>0)
        {
          System.out.println("Success");
          state="Pass";
          statusTracker(br,"Pass","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
        }
         else
        {
          System.out.println("Fail");
          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Successfully be able to process order","Unable to process successfully");
        }
      return state;
  }
  
  public String turnOn(String br,WebDriver driver, String status, String acc,String TN)
  {
	  TN=TN.substring(0,8); 
	 String s1=TN+randomNO(9999,2222);
      String initialstate=status, chngetostate="On",state = "Fail", accst=acc;
      focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
          
                  if(driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).isDisplayed())
                  {
                	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).clear();
            		  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).sendKeys(s1);
                  }
                  else
                  { 
                	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[3]/input")).clear();
            		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[3]/input")).sendKeys(s1);  
                  }
                  for(int i=1;i<100;i++){}
                  
     
      int chk=0;
      do{
          //System.out.println("Processing!" +chk);
          chk++;
        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

        if(driver.findElements(By.id("dataSaveSucess")).size()>0)
        {
          System.out.println("Success");
          statusTracker(br,"Pass","Verify order process for changing status from: "+ initialstate +" to: "+chngetostate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
        }
        else
        {
          System.out.println("Fail");
          statusTracker(br,"Fail","Verify order process for changing status from: "+ initialstate +" to: "+chngetostate+ " with "+accst,"Successfully be able to process order","Unable to process successfully");
        }
        
        focusClick(driver,driver.findElement(By.xpath(butnxpath)),br);
      
      
        focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
      
      do{
          //System.out.println("Processing!" +chk);
          chk++;
        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

      if(driver.findElements(By.id("dataSaveSucess")).size()>0)
        {
          System.out.println("Success");
          statusTracker(br,"Pass","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Successfully be able to process order","Successfully processed order");
          state="Pass";
        }
         else
        {
          System.out.println("Fail");
          statusTracker(br,"Fail","Verify order process for changing status from: "+chngetostate +" to: "+initialstate+ " with "+accst,"Successfully be able to process order","Unable to process successfully");
        }
                return state;
                  
  }
  public String randomNO(int max, int min)
  {
  	  	int Max=max;
  	  	int Min=min;
  	  	double random1=Min + (int)(Math.random() * ((Max - Min) + 1));
  		//System.out.println(random1);
  		int random2=(int)random1;
  		//System.out.println(random2);
  		String s1 = new Integer(random2).toString();
  		System.out.println(s1);
  		return(s1);
  		
  }
  public void MaxTn(String br,WebDriver driver,int c,String s1)
  
  {
	String  s=s1.substring(0,8);  
	  
	if(c==0) 
	{
		for(int i=9;i<13;i++)
		{
		  
		  s1=s+randomNO(9999,2222);
		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div["+i+"]/div[3]/input")).clear();
		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div["+i+"]/div[3]/input")).sendKeys(s1); 
		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div["+i+"]/div[5]/label")).click();
		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div["+i+"]/div[7]/input")).clear();
		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div["+i+"]/div[7]/input")).sendKeys(Acccode); 
		 
		}	
		 for(int i=1;i<10;i++){}
		 focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
	    
	      int chk=0;
	      do{
	          //System.out.println("Processing!" +chk);
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	        if(driver.findElements(By.id("dataSaveSucess")).size()>0)
	        {
	          System.out.println("Success");
	          statusTracker(br,"Pass","Verify order process for add max TN","Successfully be able to process order","Successfully processed order");
	        }
	        else
	        {
	          System.out.println("Fail");
	          statusTracker(br,"Fail","Verify order process for add max TN","Successfully be able to process order","Unable to process successfully");
	        }
		
	}
	else if(c==1)  
	{
		for(int i=9;i<13;i++)
		{
			
		s1=s+randomNO(9999,2222);	
		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div["+i+"]/div[3]/input")).clear();
		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div["+i+"]/div[3]/input")).sendKeys(s1); 
		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div["+i+"]/div[7]/input")).clear();
		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div["+i+"]/div[7]/input")).sendKeys(s1); 
		
		}
		 for(int i=1;i<10;i++){}
	      
		 focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
	      int chk=0;
	      do{
	          //System.out.println("Processing!" +chk);
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	        if(driver.findElements(By.id("dataSaveSucess")).size()>0)
	        {
	          System.out.println("Success");
	          statusTracker(br,"Pass","Verify order process for add max TN","Successfully be able to process order","Successfully processed order");
	        }
	        else
	        {
	          System.out.println("Fail");
	          statusTracker(br,"Fail","Verify order process for add max TN","Successfully be able to process order","Unable to process successfully");
	        }
	}
	else
	{
		for(int i=9;i<13;i++)
		{
			 s1=s+randomNO(9999,2222);
			System.out.println(s1);
			 
		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div["+i+"]/div[3]/input")).clear();
		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div["+i+"]/div[3]/input")).sendKeys(s1); 
		 
		}
		 for(int i=1;i<10;i++){}
	      
		 focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
	      int chk=0;
	      do{
	          //System.out.println("Processing!" +chk);
	          chk++;
	        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

	        if(driver.findElements(By.id("dataSaveSucess")).size()>0)
	        {
	          System.out.println("Success");
	          statusTracker(br,"Pass","Verify order process for add max TN","Successfully be able to process order","Successfully processed order");
	        }
	        else
	        {
	          System.out.println("Fail");
	          statusTracker(br,"Fail","Verify order process for add max TN","Successfully be able to process order","Unable to process successfully");
	        }
	}
  }
  
  public void EditTn(String br,WebDriver driver,String s)
  {        
            s=s+randomNO(9999,2222);

	  if(driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).isDisplayed())
      {
    	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).clear();
		  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).sendKeys(s);
      }
      else
      {
    	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[3]/input")).clear();
		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[3]/input")).sendKeys(s);  
      }
                  for(int i=1;i<10;i++){}
      
                  focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
      int chk=0;
      do{
          //System.out.println("Processing!" +chk);
          chk++;
        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());

        if(driver.findElements(By.id("dataSaveSucess")).size()>0)
        {
          System.out.println("Success");
          statusTracker(br,"Pass","Verify order process for editing TN","Successfully be able to process order","Successfully processed order");
        }
        else
        {
          System.out.println("Fail");
          statusTracker(br,"Fail","Verify order process for editing TN","Successfully be able to process order","Unable to process successfully");
        }
  }
  
  public String TNcheck(String br,String ac, String acode,WebDriver driver, int check) throws Exception
  {
         String schk="Fail";
         int check1=check;
         if(driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).isDisplayed())
         {
       	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).clear();
   		  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).sendKeys(ac);
         }
         else
         {
       	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[3]/input")).clear();
   		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[3]/input")).sendKeys(ac);  
         }     
          
         if(check1==2)
         {
                 //ac=acode;
        	 if(driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).isDisplayed())
             {
           	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[7]/input")).clear();
       		  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[7]/input")).sendKeys(acode);
             }
             else
             {
           	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[7]/input")).clear();
       		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[7]/input")).sendKeys(acode);  
             }
         }
         if(check1==3)
         {
                 ac=2+Acccode;
                 System.out.println("ac"+ac);
                 if(driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).isDisplayed())
                 {
               	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[7]/input")).clear();
           		  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[7]/input")).sendKeys(ac);
                 }
                 else
                 {
               	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[7]/input")).clear();
           		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[7]/input")).sendKeys(ac);  
                 }
         }
         
         focusClick(driver,driver.findElement(By.cssSelector(svexpath)),br);
                 
         Thread.sleep(3000);
     
         if(isElementPresent(br,driver,By.xpath("//*[@id='collapseFeature3']/div[2]/div[3]/div/div/div/ul")))
                     {
                                  statusTracker(br,"Pass","Verify if error message is displayed when adding "+ac+" TN/Acc code","Error message is displayed: "+ driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[3]/div/div/div/ul")).getText(),"Error message should be displayed");
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
  public String TNValidation(String br,WebDriver driver, int a) throws Exception
  {
                                 //int aa=Acccode.
         statusTracker(br,"","Error Validation","","");
         String schk ="Pass";
         schk=TNcheck(br,"0223004000","",driver,1);
         schk=TNcheck(br,"1223004000","",driver,1);
         schk=TNcheck(br,"9000004000","",driver,1);
         schk=TNcheck(br,"9760004000","",driver,1);
         schk=TNcheck(br,"9999","",driver,1);
         /*phoneline_ac=driver.findElement(By.xpath("//html/body/header/div[4]/div[3]/div/div/span/select/option[1]")).getText();
         System.out.println(phoneline_ac);*/
         schk=TNcheck(br,TN1,"",driver,1);
         if(a==1 || a==2)
         {
         schk=TNcheck(br,"9193220101","",driver,2); 
         schk=TNcheck(br,"9193220101","2",driver,2);
         schk=TNcheck(br,"919322","2",driver,2);
         if(a==1)
         schk=TNcheck(br,"9193220101","",driver,3);
         schk="Pass";
         }
         return schk;
  }
  
  
 
  public void execute(String br, WebDriver driver, String url, int loc, String name1) throws Exception {
                 
     // arrcount=0;
      int tlim=3;
      try
         {
               
              File data = new File(this.path);
              WorkbookSettings ws = new WorkbookSettings();
              ws.setLocale(new Locale("er", "ER"));
              Workbook wb = Workbook.getWorkbook(data, ws);
              Sheet sheet2 = wb.getSheet(0);
              tlimit = sheet2.getCell(5, loc).getContents();
	          username = sheet2.getCell(6, loc).getContents();
	          pwd = sheet2.getCell(7, loc).getContents();
              NonVacc=sheet2.getCell(8, loc).getContents();
              tlim = Integer.parseInt(tlimit);
              
              wb.close();

           driver.manage().timeouts().implicitlyWait(tlim,TimeUnit.SECONDS); 
                                  //TimeUnit.SECONDS);
           System.out.println("qtest1");
            try {
  
                  if(first==0)
                    {
                        login(driver,username,pwd);
                    }
                  System.out.println("a");
                  if(!(InternalException(driver,br)))
                  {

                  switchTo(driver, "Admin",tlim,br);             
                  focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[4]/div[2]/nav/ul/li[1]")),br);
                  System.out.println("checkpoint1");
                  for(int i=1;i<20;i++){}
                  Acccode=driver.findElement(org.openqa.selenium.By.xpath("//html/body/section/section/div[1]/aside[1]/ul/li[1]/strong")).getText();
                  System.out.println("Acccode"+Acccode);
                focusClick(driver,driver.findElement(By.xpath("//section[@id='admin-homepage-shortcuts']/div/a[6]/span/div")),br);
                 Thread.sleep(3000);
                 
                 if(!(InternalException(driver,br)))
                 {

                
                  int count1=driver.findElements(By.xpath("//html/body/section/div")).size();
                  System.out.println("count here: " + count1);   
                  String featureName="Simultaneous Ring";
                  int featureOrder=FeatureListIncoming(driver,count1,featureName);

                  System.out.println("Feature Order " + featureOrder);  
                  
                 
                   focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature"+featureOrder+" > div.accordian-header > div.header-right")),br);
                   System.out.println("c");
                  TN1= Select_TN(br,driver,featureName,featureOrder);
 	              System.out.println(TN1);
 	             
 	              logger.info("c");
                   
                  
                 if(TN1!=null)
                 {
                 
                  //Switch to User
                  
                  focusClick(driver,driver.findElement(By.xpath("//html/body/header/div[1]/a")),br);
                  
                  
                  focusClick(driver,driver.findElement(By.xpath("//section[@id='homepage-shortcuts']/div/a[5]/span/div")),br);
                 
                  int chk=0;
                  do{
                      //System.out.println("Processing!" +chk);
                      chk++;
                    }while(!(driver.findElement(By.xpath("html/body/section/section")).isDisplayed()));
                  System.out.println(TN1);
                  focusDropdown(driver,"//html/body/header/div[4]/div[3]/div/div/span",TN1,br);
                  //new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText(TN1);
              count1=driver.findElements(By.xpath("//html/body/section/div")).size();
                  System.out.println("count here: " + count1);   
                 
                featureName="Simultaneous Ring";
                featureOrder=FeatureListIncoming(driver,count1,featureName);
                focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature"+featureOrder+" > div.accordian-header > div.header-right")),br);
                  System.out.println("c");
                  
                  String status1="",state = "Fail";
                  boolean status= driver.findElement(By.id("toggleButton13")).isSelected();
                  
                  int cnt=driver.findElements(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[1]/label")).size();
                  System.out.println("cnt is"+cnt);
                  int c=0;
                  for(int k=1;k<=cnt;k=k+2)
                  { 
                	 if(driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[1]/label["+k+"]")).getText().equals("")) 
                	 {
                		 String s = driver.findElement(By.xpath("//div[@id='collapseFeature3']/div[2]/div[5]/form/section/div/label["+k+"]")).getText();
                		 System.out.println(s);
                		 c++;
                	 }
                	  
                  }
                  System.out.println("count is"+c);
                  if(c==0)
                  {
                                  int a1=1;
                                  
                                                  
                              if(driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).isDisplayed())
                                                    {
                                                	  if( driver.findElement(By.id("checkVm2")).isSelected())
                                                	  {
                                                	  driver.findElement(By.xpath("//div[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[5]/label")).click();
                                                      statusTracker(br,"","The Account code is"+Acccode,"",""); 
                                                	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[7]/input")).clear();
                                            	
                                                	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[7]/input")).sendKeys(Acccode);
                                                	  }
                                                	  else
                                                	  {
                                                		  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[7]/input")).clear();
                                            	
                                                	      driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[7]/input")).sendKeys(Acccode);
                                                		  
                                                	  }
                                                  }
                                       else
                                         {   
                                                        if( driver.findElement(By.id("checkVm1")).isSelected())
                                                        {
                                                    driver.findElement(By.xpath("//div[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[5]/label")).click();
                                                    statusTracker(br,"","The Account code is"+Acccode,"",""); 
                                                	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[7]/input")).clear();
                                            		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[7]/input")).sendKeys(Acccode); 
                                                        }
                                                        else
                                                        { driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[7]/input")).clear();
                                               		      driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[7]/input")).sendKeys(Acccode);
                                                        	
                                                        }
                                                        	
                                           }
                                  
                              
                         String acc="Verified Account code";
                  if(status==true)
                                {     
                                  status1="On";
                                  state=turnoff(br,driver, status1, acc);
                                }
                      else
                            {
                                  status1="Off";
                                  state=turnOn(br,driver, status1, acc,TN1);
                             }
                                                      
                                 EditTn(br,driver,TN1);
                                 MaxTn(br,driver,c,TN1);  
                               TNValidation(br,driver,a1);                     
              }
       else if(c==1)
                     {
                                  int a2=2;
                                  if(driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[3]/input")).isDisplayed())
                                  {
                                	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[7]/input")).clear();
                            		  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[8]/div[7]/input")).sendKeys("8134526678");
                                  }
                                  else
                                  {
                                	  driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[7]/input")).clear();
                            		 driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[5]/form/section/div[2]/div[7]/div[7]/input")).sendKeys("8134526678");  
                                  }
                                  String acc="Non-Verified Account code";
                       if(status==true)
                              {
                                  status1="On";
                                  state=turnoff(br,driver, status1, acc);
                             }
                      else
                      {
                                  status1="Off";
                                  state=turnOn(br,driver, status1, acc,TN1);
                      }                     
                          System.out.println("orderprocess is done");

                               EditTn(br,driver,TN1);
                                  MaxTn(br,driver,c,TN1);  
                              TNValidation(br,driver,a2);
                      
                  }
            else
                  {
                                int a3=3;
                                String acc="No Account code";
                    if(status==true)
                    {
                                  status1="On";
                                  state=turnoff(br,driver, status1, acc);
                    }
                    else
                    {
                                  status1="Off";
                                  state=turnOn(br,driver, status1, acc,TN1);
                    }
                    System.out.println("orderprocess is done");
                                  EditTn(br,driver,TN1);
                                  MaxTn(br,driver,c,TN1);  
                                 TNValidation(br,driver,a3);
                    
                  }
                  String canbut="//html/body/div[3]/div/div[2]/span";
            	  String Savbut="//html/body/div[3]/div/div[2]/a/span";                  	 
            	  unsave(driver,br,canbut,Savbut);
                 
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

}


