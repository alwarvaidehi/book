
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase{
	
	Actions a = new Actions(driver);
	
	@FindBy(xpath="//div[@class='col-sm-5 d-flex align-items-center justify-content-end']/descendant::span[3]")
	WebElement MyAccount;
	
	@FindBy(xpath="//div[@class='userpopup']/descendant::a[1]")
	WebElement LoginBtn;
	
	@FindBy(linkText="Fiction Books")
	WebElement FictionLink;
	
	@FindBy(xpath="//div[@class='row  w-100']/descendant::a[2]")
	WebElement Book1;
	
	@FindBy(xpath="//input[@class='btn themebackground text-white']")
	WebElement BuyNow;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void	clickLogin() throws InterruptedException {
		
		a.moveToElement(MyAccount).perform();
		Thread.sleep(1500);
		
		LoginBtn.click();
		
	}
	
	public void click_fiction() {
		FictionLink.click();
	}
	
	public void click_book1() throws InterruptedException {
		Thread.sleep(1500);
		Book1.click();
	}

	public void click_buynow() {
		BuyNow.click();
	}


}
