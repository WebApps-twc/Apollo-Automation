package DevVersionFeaturesFile;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.apache.log4j.xml.DOMConfigurator;

public class Main_Function extends CommonFunctions{
                
                public int loc;
                
                @BeforeClass
                public void Reader() throws IOException, BiffException
                {
                                
                                DOMConfigurator.configure("Logger.xml");
                                
                                dir1 = new File(".");
                                spath1 = dir1.getCanonicalPath();       
                                spath = spath1 + "\\"+"src\\" + "main\\" + "java\\" + "DevVersionFeaturesFile";
                                spath = spath.replaceAll("////", "////////");
                                logger.info(""+"Path "+spath);
                                Load_Properties_File(spath1);
                    
                                inputfile=spath+path_config.getProperty("inputSheet");
                                
                                outputfile=spath+path_config.getProperty("resultSheet");
                                logger.info(""+"inputfile "+inputfile+" outputfile "+outputfile);
                                data11 = new File(inputfile);
                                
                                ws11 = new WorkbookSettings();
                                ws11.setLocale(new Locale("er", "ER"));
                                wb11 = Workbook.getWorkbook(data11, ws11);
                                sheet11 = wb11.getSheet("Apollo");
                                gr=sheet11.getCell(3,4).getContents();
                                Grid_Status=gr;
                                Sheet_name = sheet11.getName();
                                
                                for(int c=0;c<10;c++)
                                {
                                                total[c]=0;
                                                counter_result_sheet[c]=10;
                                                counter_result_initial[c]=9;
                                                logger.info(""+"RO initialized");
                                                ro[c]=10;
                                                l_browser[c]=0;
                                                pass_br_wise[c]=0;
                                                no_run[c]=0;
                                                black[c]=0;
                                                arrcount[c]=0;
                                }
                                sheetname="Apollo";
                                int first_row=Row_locator_full_scan("TEST CASE",inputfile,sheetname);
                                
                                int LastRow=sheet11.getRows();
                                logger.info(""+"Last_row "+LastRow);
                                logger.info(""+"first_row "+first_row);
                                for( int im=first_row;im<LastRow;im++)
                                {
                                                String tc1= sheet11.getCell(3, im).getContents();
                                                logger.info(""+"TC1 "+tc1+" IM variable "+im+" "+sheet11.getCell(0, im).getContents());
                                                if(tc1.equalsIgnoreCase("Y"))
                                                {
                                                                first_tc=im;
                                                                logger.info("first_tc: "+first_tc);
                                                                break;
                                                }
                                                
                                }
                                
                                File Pass_a = new File(Overall_Path + "//" + "//Test_Results"+"//"+"ACR_Pass_Screenshots////");
                                deleteFolder(Pass_a);
                                File Fail_a = new File(Overall_Path + "//" + "//Test_Results"+"//"+"ACR_Fail_Screenshots////");
                                deleteFolder(Fail_a);
                                File Exception_a = new File(Overall_Path + "//"+ "//Test_Results"+"//"+"ACR_Exception_Screenshots////");
                                deleteFolder(Exception_a);
                }
                
                @DataProvider(parallel=true)
                public Object[][] getData() throws IOException, BiffException{
                                logger.info(""+"Getting inside");
                                String no_of_browsers=sheet11.getCell(4,4).getContents();
                                logger.info("no_of_browsers "+no_of_browsers);
                                if(gr.equals("Yes"))
                                {
                                                logger.info(""+"no_of_browsers : "+no_of_browsers);
                                                if(no_of_browsers.contains("1"))
                                                {
                                final Object data[][]={{"FF"}};
                                return data;
                                                }
                                                if(no_of_browsers.contains("2"))
                                                {
                                                                final       Object data[][]={{"FF"},{"chrome"}};
                                                                return data;
                                                }
                                                else if(no_of_browsers.contains("3"))
                                                {
                                                                final       Object data[][]={{"FF"},{"chrome"},{"IE"},{""}};
                                                                return data;
                                                }
                                                else if(no_of_browsers.contains("4"))
                                                {
                                                                final       Object data[][]={{"FF"},{"chrome"},{"IE10"},{"IE11"}};
                                                                return data;
                                                }
                                                else if(no_of_browsers.contains("5"))
                                                {
                                                                final       Object data[][]={{"FF"},{"chrome"},{"IE"},{"IE10"},{"IE11"}};
                                                                return data;
                                                }}
                                else if(gr.equals("No"))
                                {
                                                logger.info(""+"Grid option set to NO");
                                                final Object data[][]={{""}};
                                                return data;
                                                
                                }
                
                return null;
                }
                
                @Test(dataProvider="getData",priority=1)
                public  void UserACR_001 ( String br) throws Exception {
                                loc=8;
                                logger.info(""+"UserACR is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {
                                                throw new SkipException("Skipping tests because value is set has N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));

                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=2)
                public  void UserDND_001 ( String br) throws Exception {
                                loc=9;
                                logger.info(""+"UserDND is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {
                                                throw new SkipException("Skipping tests because value is set has N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=3)
                public  void GPSACR_001 ( String br) throws Exception {
                                loc=10;
                                logger.info(""+"GPSACR is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=4)
                public  void UserCFU_001 ( String br) throws Exception {
                                loc=11;
                                logger.info(""+"UserCFU is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=5)
                public  void UserCFNA_001 ( String br) throws Exception {
                                loc=12;
                                logger.info(""+"UserCFNA is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=6)
                public  void UserCFB_001 ( String br) throws Exception {
                                loc=13;
                                logger.info(""+"UserCFB is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=7)
                public  void UserSCF_001 ( String br) throws Exception {
                                loc=14;
                                logger.info(""+"UserSCF is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);                                                                            
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=8)
                public  void UserSCR_001 ( String br) throws Exception {
                                loc=15;
                                logger.info(""+"UserSCR is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=9)
                public  void UserSpeedDial_001 ( String br) throws Exception {
                                loc=16;
                                logger.info(""+"UserSpeedDial is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=10)
                public  void UserCallLogs_001 ( String br) throws Exception {
                                loc=17;
                                logger.info(""+"UserCallLogs is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }                              
                
                @Test(dataProvider="getData",priority=11)
                public  void VMSettings_001 ( String br) throws Exception {
                                loc=18;
                                logger.info(""+"VMSettings is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }                              
                
                @Test(dataProvider="getData",priority=12)
                public  void UserCallScheduler_001 ( String br) throws Exception {
                                loc=19;
                                logger.info(""+"UserCallScheduler is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=13)
                public  void UserOfficeAnywhere_001 ( String br) throws Exception {
                                loc=20;
                                logger.info(""+"UserOfficeAnywhere is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=14)
                public  void UserSequentialRing_001 ( String br) throws Exception {
                                loc=21;
                                logger.info(""+"UserSequentialRing is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=15)
                public  void UserSimultaneousRing_001 ( String br) throws Exception {
                                loc=22;
                                logger.info(""+"UserSimultaneousRing is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=16)
                public  void CustomCallerId_001 ( String br) throws Exception {
                                loc=23;
                                logger.info(""+"CustomCallerId is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=17)
                public  void Hotline_001 ( String br) throws Exception {
                                loc=24;
                                logger.info(""+"Hotline is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                                
                
                @Test(dataProvider="getData",priority=19)
                public  void AA_001 ( String br) throws Exception {
                                loc=25;
                                logger.info(""+"AA is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=18)
                public  void Hunting_001 ( String br) throws Exception {
                                loc=26;
                                logger.info(""+"Hunting is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=20)
                public  void EditUser_001 ( String br) throws Exception {
                                loc=27;
                                logger.info(""+"EditUser is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=21)
                public  void AddUser_001 ( String br) throws Exception {
                                loc=28;
                                logger.info(""+"AddUser is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=22)
                public  void MyProfile_001 ( String br) throws Exception {
                                loc=29;
                                logger.info(""+"MyProfile is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=23)
                public  void GPSCallForward_001 ( String br) throws Exception {
                                loc=30;
                                logger.info(""+"GPSCallForward is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=24)
                public  void GPSCallForwardBusy_001 ( String br) throws Exception {
                                loc=31;
                                logger.info(""+"GPSCallForwardBusy is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                @Test(dataProvider="getData",priority=25)
                public  void GPSCallForwardNoAnswer_001 ( String br) throws Exception {
                                loc=32;
                                logger.info(""+"GPSCallForwardNoAnswer is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                @Test(dataProvider="getData",priority=26)
                public  void GPSCallTransfer_001 ( String br) throws Exception {
                                loc=33;
                                logger.info(""+"GPSCallTransfer is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=27)
                public  void GPSCallWaiting_001 ( String br) throws Exception {
                                loc=34;
                                logger.info(""+"GPSCallWaiting is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=28)
                public  void GPSDoNotDisturb_001 ( String br) throws Exception {
                                loc=35;
                                logger.info(""+"GPSDoNotDisturb is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=29)
                public  void GPSSelectiveCallForwarding_001 ( String br) throws Exception {
                                loc=36;
                                logger.info(""+"GPSSelectiveCallForwarding is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=30)
                public  void GPSSelectiveCallRejection_001 ( String br) throws Exception {
                                loc=37;
                                logger.info(""+"GPSSelectiveCallRejection is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                   a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=31)
                public  void GPSCallLogs_001 ( String br) throws Exception {
                                loc=38;
                                logger.info(""+"CallLogs is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=32)
                public  void GPSCallReturn69_001 ( String br) throws Exception {
                                loc=39;
                                logger.info(""+"GPSCallReturn*69 is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=33)
                public  void GPSLastNumberRedial_001 ( String br) throws Exception {
                                loc=40;
                                logger.info(""+"GPSLastNumberRedial is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=34)
                public  void GPSSpeedDial_001 ( String br) throws Exception {
                                loc=41;
                                logger.info(""+"GPSSpeedDial is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=35)
                public  void GPSSuspendedLine_001 ( String br) throws Exception {
                                loc=42;
                                logger.info(""+"GPSSuspendedLine is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=36)
                public  void GPSThreeWayCalling_001 ( String br) throws Exception {
                                loc=43;
                                logger.info(""+"GPSThreeWayCalling is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=38)
                public  void GPSCallScheduler ( String br) throws Exception {
                                loc=44;
                                logger.info(""+"GPSCallScheduler is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=39)
                public  void GPSCallHold_001 ( String br) throws Exception {
                                loc=45;
                                logger.info(""+"GPSCallHold is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=40)
                public  void GPSCallParkandRetrieve_001 ( String br) throws Exception {
                                loc=46;
                                logger.info(""+"GPSCallParkandRetrieve is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                   a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=41)
                public  void GPSDirectedCallPickUp_001 ( String br) throws Exception {
                                loc=47;
                                logger.info(""+"GPSDirectedCallPickUp is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=42)
                public  void GPSOfficeAnywhere_001 ( String br) throws Exception {
                                loc=48;
                                logger.info(""+"GPSOfficeAnywhere is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=43)
                public  void GPSPersonalAttendant_001 ( String br) throws Exception {
                                loc=49;
                                logger.info(""+"GPSPersonalAttendant is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=44)
                public  void GPSSequentialRing_001 ( String br) throws Exception {
                                loc=50;
                                logger.info(""+"GPSSequentialRing is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                @Test(dataProvider="getData",priority=45)
                public  void GPSSimultaneousRing_001 ( String br) throws Exception {
                                loc=51;
                                logger.info(""+"GPSSimultaneousRing is called");
                                
                                String exec1 = sheet11.getCell(3, loc).getContents();
                                if(exec1.equalsIgnoreCase("N")) {;
                                                throw new SkipException("Skipping tests because value is set as N.");
                                }
                                else{
                                                
                                                Validation a = new Validation();
                                
                                                try {
                                                                logger.info(""+"Browser and excel location of test1  is "+br+" and "+loc);
                                                                
                                                                if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
                                                                {                                              
                                                                                Test_called++;
                                                                                logger.info(""+"Test_called in main  is"+Test_called );
                                                                                
                                                                                a.print(inputfile,outputfile+"_"+br+".xls", spath, true,br,loc,Test_called);
                                                                                
                                                                
                                                                }
                                                                else if(gr.equals("No") && br.equals("") && !br.equals("NA"))
                                                                {
                                                                                br=sheet11.getCell(2, loc).getContents();
                    logger.info(""+"GRID IS NOT In MAIN!");
                    a.print(inputfile,outputfile+"_"+br+".xls",spath, true,br,loc,browserSwitch(br));
                                                                                
                                                                }
                                                                logger.info(""+"Excel location value in test1 is "+loc);
                                                                
                                                                TestCompleted="Yes";
                                                                logger.info(""+"Test completed yes or NO"+TestCompleted);
                                                                
                                                                } catch (Exception e) {
                                                                                System.out.println("Error: There are issues regarding the IO files. Please verify and try again");
                                                                                logger.info(""+e);
                                                                                exceptionHandler(br,e);
                                                                                }
                                }
                }
                
                                               
                
                @AfterTest
                public void end()
                {
                	tear();
                }
                
                @Override
                public void execute(String br, WebDriver paramDriver, String url, int loc, String name1)
                                                throws Exception {
                                // TODO Auto-generated method stub
                                
                }
                
                }
