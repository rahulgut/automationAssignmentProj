package simplesurance.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import simplesurance.abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		
		// Initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	// Changing language to English
	//driver.findElement(By.cssSelector("button[aria-label='Menu']")).click();
	
	@FindBy(css="button[aria-label='Menu']")
	WebElement languageMenu;
	
	//driver.findElement(By.xpath("//li/span[text()='Englisch']")).click();
	
	@FindBy(xpath="//li/span[text()='Englisch']")
	WebElement englishListItem;
	
	// Entering username and password
	//driver.findElement(By.cssSelector("#login_username")).sendKeys("testsellingpartner2@simplesurance.de");
	
	@FindBy(css="#login_username")
	WebElement userNameEle;
	
	//driver.findElement(By.cssSelector("#login_password")).sendKeys("TestSellingPartner2Pass");
	
	@FindBy(css="#login_password")
	WebElement passwordEle;
	
	// Click Login button 'Next'
	//driver.findElement(By.cssSelector("button[type='submit']")).click();
	
	@FindBy(css="button[type='submit']")
	WebElement loginBtn;
	
	public void goTo() {
		driver.get("https://insurance-manager.sb-qa-candidatetask.sisu.sh/login");
	}
	
	public void changeLanguage() {
		
		languageMenu.click();
		englishListItem.click();
	}
	
	public HomePage loginApplication(String userName, String password) {
		
		userNameEle.sendKeys(userName);
		passwordEle.sendKeys(password);
		loginBtn.click();
		
		// Creating object of Page Object class for Home Page screen
		return new HomePage(driver);
	}

}
