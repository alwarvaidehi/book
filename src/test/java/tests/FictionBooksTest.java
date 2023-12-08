package tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.FictionBooksPage;
import pages.HomePage;
import pages.LoginPage;
import pages.TestBase;
import utilities.ExcelUtility;
import utilities.Mylistener;

@Listeners(Mylistener.class)
public class FictionBooksTest extends TestBase {

		HomePage hp;
		LoginPage lp;
		FictionBooksPage fp;
		public static int RowNum=1;
		@BeforeTest
		public void start_browser()
		{
			OpenBrowser();
			hp = new HomePage(driver);
			lp = new LoginPage(driver);
		}

		
		@Test(dataProvider="testdata")
		public void test_login(String email, String password) throws IOException, InterruptedException
		{
			hp.clickLogin();
			lp.user_login(email,password);
			String uname=lp.get_uname();
			
			Assert.assertEquals(uname, email);
			//lp.user_logout();
			RowNum=RowNum+1;
		}
		  @DataProvider(name="testdata") 
		  public Object[][] datasupplier() throws EncryptedDocumentException, IOException {
		  
		  Object[] [] input = ExcelUtility.getTestData("Sheet2"); 
		  return input;
		  
		  }
		  
			@Test(priority=2)
			public void FictionBooksclick() throws InterruptedException
			{
				Thread.sleep(1000);
				hp.click_fiction();
				//lp.user_logout();
			}
		 

			@Test(priority=3)
			public void book1_click() throws InterruptedException 
			{
				hp.click_book1();
				//lp.user_logout();
			}
			
			@Test(priority=4)
			public void buynow_click() throws InterruptedException 
			{
				hp.click_buynow();
				lp.user_logout();
			}

		@AfterTest
		public void close_browser()
		{
			driver.close();
		}
		

		

}
