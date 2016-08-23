package ApolloNew;


import java.io.File;

import java.util.Locale;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class HuntGroup extends CommonFunctions {
                
                String table, tns[];
    String tlimit,username,pwd;
    int tncount;                                                    
                                
    String phoneline,phoneline_ac,Acccode;
                int rank[]= new int[50];
                

                int c_sequence;
                String name_for_rank[]= new String[40];
                String price, rank_channels;

                public HuntGroup(String path) {
                                this.path = path;
                }
                                
   public String crtgrup(WebDriver driver, int k1,String br) throws Exception
      {
      int a = 0, a1=0, a2=0, k=k1, b=0, c=0, d=0;String type = null;
                
       if(k==1)
         type="Circular";
       else if(k==2)
         type="Sequential";
       else if(k==3)
         type="Uniform";
             
       focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature3']/div[2]/form/div/div/div[2]/div["+k+"]/label")),br);
                
       int cnt=driver.findElements(By.xpath("//*[@id='collapseFeature3']/div[2]/form/div[3]/div[2]/section/div[2]/div")).size();
       logger.info("cnt"+cnt);
                
       String bglst[]=new String[cnt+1];
       String addlst[]=new String[cnt+1]; 
        for(int i=1;i<=cnt;i++)
                {
                  bglst[i]=driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/form/div[3]/div[2]/section/div[2]/div["+i+"]/div[2]")).getText();
                  addlst[i]=driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/form/div[3]/div[2]/section/div[2]/div["+i+"]/div[3]/a")).getText();
                                logger.info("bglst"+bglst[i]);
                                                                
                                if(bglst[i].equals("") && a2==0 && addlst[i].equals("Add To Group"))
                                {
                                 logger.info("loop1");
                                 focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/form/div[3]/div[2]/section/div[2]/div["+i+"]/div[3]/a")),br);
                                 a1++;
                                }
                                else if(bglst[i].equals("check") && a1==0 && addlst[i].equals("Add To Group"))
                               {
                                  logger.info("loop2");
                                  focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/form/div[3]/div[2]/section/div[2]/div["+i+"]/div[3]/a")),br);
                                 a2++;
                                }                                               
                 }
                
       logger.info("save1");
       focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/div[4]/button[2]")),br);
       logger.info("save123");
                
                if(drive.findElements(By.id("cfuOnPilotModal")).size()!=0)
                 {
                                logger.info("savecont");
                                focusClick(driver,driver.findElement(By.xpath("//div[@id='cfuOnPilotModal']/div/div[2]/span[2]")),br);                                                        
                                a=1;
                 }
                int cnft=0;           
       if(assertTrue(isElementPresent(By.xpath("//*[@id='collapseFeature3']/div[2]/div[3]/div/div")))){      
       cnft=driver.findElements(By.xpath("//*[@id='collapseFeature3']/div[2]/div[3]/div/div")).size();
       logger.info("cnft"+cnft);    
                                                                
                 do{
                                if(cnft >= 1 && driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[3]/div/div/div/span[2]/a")).isDisplayed())
                                {
                                                logger.info("resolve");
                                                focusClick(driver,driver.findElement(By.linkText("Resolve all conflicts on this line")),br);
                                                do{
                                        }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
                                                b=1;                                                                       
                                }              
                                --cnft;
                 }while(cnft>=1);
       }
                                
        if(b==1)
          {
                  logger.info("savetwice");
                  focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/div[4]/button[2]")),br);
                
                  if(a==1)
                  {
                	  focusClick(driver,driver.findElement(By.xpath("//div[@id='cfuOnPilotModal']/div/div[2]/span[2]")),br);
                  }
                                                                  
         }     
                
         do{
                        }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
                
         String schk;
                                                if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                                                {
                                                                statusTracker(br,"Pass","Verify order processing for "+type+" huntgoup creation","Order processing has processed successfully","Order should be processed successfully");
                                                                schk="Pass";
                                                }
                                                else
                                                {
                                                                statusTracker(br,"Fail","Verify order processing for "+type+" huntgoup creation","Order processing has failed","Order should be processed successfully");            
                                                                Thread.sleep(1000);
                                                                schk="Fail";
                                                }
                                                
                                logger.info("modification");                                                                                                                                        
                                if(schk.equals("Pass"))
                                  {
                                                int lstcnt=driver.findElements(By.xpath("//*[@id='collapseFeature3']/div[2]/form/div[3]/div[1]/section/div[2]/div")).size();
                                                logger.info("lstcnt"+lstcnt);
                                                
                                                 if(lstcnt>3)
                                                 {
                                                	 focusClick(driver,driver.findElement(By.xpath("//div[@id='sortable']/div[4]/div[2]/span[2]")),br);
                                                  
                                                                focusClick(driver,driver.findElement(By.linkText("Remove From Group")),br);
                                                 }
                                                
                                                if(k==1 && k==2)
                                                	focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature3']/div[2]/form/div/div/div[2]/div["+(k+1)+"]/label")),br);

                                                else if(k==3)
                                                	focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature3']/div[2]/form/div/div/div[2]/div["+(k-1)+"]/label")),br);
                                                 
                                                logger.info("save2");
                                                focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/div[4]/button[2]")),br);
                                                logger.info("save245");
                                                
                  if(drive.findElements(By.id("cfuOnPilotModal")).size()!=0)
                    {
                                logger.info("savecont1");
                                focusClick(driver,driver.findElement(By.xpath("//div[@id='cfuOnPilotModal']/div/div[2]/span[2]")),br);                                                        
                                c=1;
                }
                
                int cnft1=driver.findElements(By.xpath("//*[@id='collapseFeature3']/div[2]/div[3]/div/div")).size();
                logger.info("cnft"+cnft);
                
                do{
                                if(cnft1 >= 1 && driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[3]/div/div/div/span[2]/a")).isDisplayed())
                                {
                                	focusClick(driver,driver.findElement(By.linkText("Resolve all conflicts on this line")),br);
                                                do{

                                        }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                                                d=1;                                                                       
                                }
                                --cnft1;
                                
                }while(cnft1>=1);
                                
                if(d==1)
                {
                  logger.info("savetwice");
                  focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/div[4]/button[2]")),br);
                
                  if(c==1)
                  {
                	  focusClick(driver,driver.findElement(By.xpath("//div[@id='cfuOnPilotModal']/div/div[2]/span[2]")),br);
                  }
                                                                  
                }                             
                
                do{
                        }while(driver.findElement(By.cssSelector("div.modal-loading")).isDisplayed());
                
                                                if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                                                 {
                                                                statusTracker(br,"Pass","Verify order processing for modifying huntgoup","Order processing has processed successfully","Order should be processed successfully");
                                                                schk="Pass";
                                                 }
                                                else
                                                 {
                                                                statusTracker(br,"Fail","Verify order processing for modifying huntgoup","Order processing has failed","Order should be processed successfully");  
                                                                Thread.sleep(1000);
                                                                schk="Fail";
                                                 }
                                                
                                  }
                                                
                                 return schk;                                       
       }
       
       private boolean assertTrue(Object elementPresent) {
                                // TODO Auto-generated method stub
                                return false;
                }

                private Object isElementPresent(By xpath) {
                                // TODO Auto-generated method stub
                                return null;
                }

                public String reset(WebDriver driver,String br) throws Exception
       {
         String schk;
         						  focusClick(driver,driver.findElement(By.linkText("Clear Group")),br);

                                  focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/div[4]/button[2]")),br);
                                                                
                                  do{
                          //logger.info("Processing!" +chk);
                          //chk++;
                          }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());                                                              
                                                
                                                if(driver.findElement(By.id("dataSaveSucess")).isDisplayed())
                                                 {
                                                                statusTracker(br,"Pass","Verify order processing for clear huntgoup","Order processing has processed successfully","Order should be processed successfully");
                                                                schk="Pass";
                                                 }
                                                else
                                                 {
                                                                statusTracker(br,"Fail","Verify order processing for clear huntgroup","Order processing has failed","Order should be processed successfully");          
                                                                Thread.sleep(1000);
                                                                schk="Fail";
                                                 }                                                                                             
                                                return schk;                        
                                                
       }
       
       public void val(WebDriver driver,String br) throws Exception
       {
    	   focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/div[4]/button[1]")),br);
                do{
                          }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature3 > div.accordian-header > div.header-right")),br);
                
                String stsus=driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[1]/div/div/h4")).getText();
                if(stsus.equals("ENABLED"))
                {
                	focusClick(driver,driver.findElement(By.linkText("Clear Group")),br);
                }
                
                int a = 0, a1=0, a2=0;
                
                int cnt=driver.findElements(By.xpath("//*[@id='collapseFeature3']/div[2]/form/div[3]/div[2]/section/div[2]/div")).size();
        logger.info("cnt"+cnt);
                
        String bglst[]=new String[cnt+1];
        String addlst[]=new String[cnt+1]; 
         for(int i=1;i<=cnt;i++)
                {
                  bglst[i]=driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/form/div[3]/div[2]/section/div[2]/div["+i+"]/div[2]")).getText();
                  addlst[i]=driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/form/div[3]/div[2]/section/div[2]/div["+i+"]/div[3]/a")).getText();
                                logger.info("bglst"+bglst[i]);
                                                                
                                if(bglst[i].equals("") && a2==0 && addlst[i].equals("Add To Group"))
                                {
                                 logger.info("loop1");
                                 focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/form/div[3]/div[2]/section/div[2]/div["+i+"]/div[3]/a")),br);
                                 a1++;
                                }
                                else if(bglst[i].equals("check") && a1==0 && addlst[i].equals("Add To Group"))
                                {
                                 logger.info("loop2");
                                 focusClick(driver,driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/form/div[3]/div[2]/section/div[2]/div["+i+"]/div[3]/a")),br);
                                 a2++;
                                }                                               
                 }
                                
         focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/div[4]/button[2]")),br);
                
                    if(driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[3]/div/div/ul")).isDisplayed())
                     {
                                   statusTracker(br,"Pass","Verify if error message is displayed while trying to create hunting without selecting the type","Error message is displayed: "+ driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[3]/div/div/ul/li")).getText(),"Error message should be displayed");
                                  //schk="Pass";
                     }
                                 else
                                 {
                                   statusTracker(br,"Fail","Verify if error message is displayed while trying to create hunting without selecting the type","Error message is not displayed","Error message should be displayed");
                                                 //schk="Fail";
                                 }
                
                    focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/div[4]/button[1]")),br);
                  do{
                          }while(driver.findElement(By.cssSelector("img[alt='icon-loading.gif']")).isDisplayed());
                  focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature3 > div.accordian-header > div.header-right")),br);
                
                  focusClick(driver,driver.findElement(By.xpath("//div[@id='collapseFeature3']/div[2]/form/div/div/div[2]/div[1]/label")),br);

                  focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/div[4]/button[2]")),br);

                    if(driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[3]/div/div/ul")).isDisplayed())
                     {
                                   statusTracker(br,"Pass","Verify if error message is displayed while trying to create hunting without line","Error message is displayed: "+ driver.findElement(By.xpath("//*[@id='collapseFeature3']/div[2]/div[3]/div/div/ul/li")).getText(),"Error message should be displayed");
                                  //schk="Pass";
                     }
                                 else
                                 {
                                   statusTracker(br,"Fail","Verify if error message is displayed while trying to create hunting without line","Error message is not displayed","Error message should be displayed");
                                                 //schk="Fail";
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
                  if(!(InternalException(driver,br)))
	              {
                	  focusClick(driver,driver.findElement(By.xpath("/html/body/section/div[2]/section/div/a[5]")),br);                    
                              Thread.sleep(3000);
                              
                              String stsus=driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[1]/div/div/h4")).getText();

                              logger.info("before expand"+stsus);
                              focusClick(driver,driver.findElement(By.cssSelector("#collapseFeature3 > div.accordian-header > div.header-right")),br);
                              String schk="Pass";                        
                              logger.info("after expand");

                               if(stsus.equals("ENABLED"))
                                {
                                          statusTracker(br,"","The huntgroup is already present","","");                                   
                                          schk=reset(driver,br);                                   
                                }
                              Thread.sleep(3000);      
                                          
                                                        for(int k=1;k<=3;k++)
                                                         {logger.info("loop"+k);
                                                                        if(schk.equals("Pass"))
                                                             {
                                                                           schk=crtgrup(driver, k,br);
                                                                           logger.info("loop"+k);
                                                                           
                                                                             if(schk.equals("Pass"))
                                                                                schk=reset(driver,br);
                                                                             
                                                                             logger.info("loop"+k);
                                                             }                            
                                 }
                                                        
                                                        val(driver,br);  
                                                        focusClick(driver,driver.findElement(By.xpath(".//*[@id='collapseFeature3']/div[2]/form/div[4]/button[1]")),br);                                                        
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
          
          private boolean isElementPresent(WebDriver driver, By xpath) {
                        // TODO Auto-generated method stub
                        return false;
        }
        }

