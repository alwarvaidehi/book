package tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SearchboxPage;
import pages.TestBase;
import pages.TodaysDealPage;
import utilities.ExcelUtility;
import utilities.Mylistener;
import utilities.Retry;

@Listeners(Mylistener.class)
public class SearchAndTodaysDealsteps extends TestBase{
	//public static void main(String[] args) throws InterruptedException {
		
		SearchboxPage sp;
		TodaysDealPage tp;

		HomePage hp;
		LoginPage lp;
		
		
		
		

		@Test(priority='1',dataProvider = "testdata",retryAnalyzer=Retry.class)
		public void search(String search,String email,String password) throws MalformedURLException, InterruptedException
		{
			
			sp.searchitem(search);
			sp.wishlistsearch();
			Thread.sleep(1500);
			lp.user_login(email, password);
		
		}
		@Test(priority='2',retryAnalyzer=Retry.class)
		public void dealstoday() throws InterruptedException, IOException
		{ 
			tp.todaysdeallog();

		}
		@BeforeTest()
		public void setup() throws InterruptedException, IOException
		{

			
			OpenBrowser();
			hp = new HomePage(driver);
			lp = new LoginPage(driver);
		   sp=new SearchboxPage();
		   tp=new TodaysDealPage();
           
		}  
	
			@AfterClass()
			public void generateReports() throws IOException
			{
				driver.close();
				
		   
			}

			@DataProvider(name="testdata")
			public Object[][] datasupplier() throws EncryptedDocumentException, IOException
			{

				Object[][] inputdata = ExcelUtility.getTestData("Sheet3");
				
				return inputdata;
			}
			

}
