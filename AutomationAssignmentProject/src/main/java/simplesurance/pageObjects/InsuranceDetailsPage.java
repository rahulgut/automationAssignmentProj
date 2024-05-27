package simplesurance.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import simplesurance.abstractComponents.AbstractComponent;

public class InsuranceDetailsPage extends AbstractComponent{
	
	WebDriver driver;
	
	public InsuranceDetailsPage(WebDriver driver) {
		
		// Initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	// Insurance details screen
	
	// Assert icon on Insurance details screen
	//Boolean errorIcon= driver.findElement(By.cssSelector("div svg[data-testid='ErrorOutlineIcon']")).isDisplayed();
	
	@FindBy(css="div svg[data-testid='ErrorOutlineIcon']")
	WebElement errorIconEle;
		
	// Validate policy status
	
	// Grab status
	//String policyStatus= driver.findElement(By.xpath("//div/span[text()='Created']")).getText();
	
	@FindBy(xpath="//div/span[text()='Created']")
	WebElement policyStatusEle;
	
	// Validate name
	//String name= driver.findElement(By.xpath("//td/div[text()='Steve Cooper']")).getText();
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]")
	WebElement nameEle;
	
	// Validate city
	//String city= driver.findElement(By.xpath("//td/div[text()='Berlin']")).getText();
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[5]/td[2]/div[1]")
	WebElement cityEle;
	
	// Validate email
	//String email= driver.findElement(By.xpath("//td/div[text()='stevecooper@gm.com']")).getText();

	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[6]/td[2]/div[1]")
	WebElement emailEle;
	
	public boolean isErrorIconDisplayed() {
		return errorIconEle.isDisplayed();
	}
	
	public String getPolicyStatus() {
		return policyStatusEle.getText();
	}
	
	public String getName() {
		return nameEle.getText();
	}
	
	public String getCity() {
		return cityEle.getText();
	}
	
	public String getEmail() {
		return emailEle.getText();
	}
}
