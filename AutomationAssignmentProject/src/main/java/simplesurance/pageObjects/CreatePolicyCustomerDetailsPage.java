package simplesurance.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import simplesurance.abstractComponents.AbstractComponent;

public class CreatePolicyCustomerDetailsPage extends AbstractComponent{
	
	WebDriver driver;
	public CreatePolicyCustomerDetailsPage(WebDriver driver) {
		
		// Initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	// Customer details
	
	// Select Mr. Salutation
	//driver.findElement(By.cssSelector("input[value='male']")).click();
	
	@FindBy(css="input[value='male']")
	WebElement salutMr;
	
	// Enter first name
	//driver.findElement(By.cssSelector("#input-createCertificate_firstName")).sendKeys("Steve");
	
	@FindBy(css="#input-createCertificate_firstName")
	WebElement firstNameEle;
	
	// Enter last name
	//driver.findElement(By.cssSelector("#input-createCertificate_lastName")).sendKeys("Cooper");
	
	@FindBy(css="#input-createCertificate_lastName")
	WebElement lastNameEle;
	
	// Enter email id
	//driver.findElement(By.cssSelector("#input-createCertificate_email")).sendKeys("stevecooper@gm.com");
	
	@FindBy(css="#input-createCertificate_email")
	WebElement emailEle;
	
	// Enter Street
	//driver.findElement(By.cssSelector("#input-createCertificate_streetName")).sendKeys("Third Street");
	
	@FindBy(css="#input-createCertificate_streetName")
	WebElement streetEle;
	
	// Enter house number
	//driver.findElement(By.cssSelector("#input-createCertificate_streetNumber")).sendKeys("12");
	
	@FindBy(css="#input-createCertificate_streetNumber")
	WebElement houseNumEle;
	
	// Enter Postal code
	//driver.findElement(By.cssSelector("#input-createCertificate_zip")).sendKeys("10178");
	
	@FindBy(css="#input-createCertificate_zip")
	WebElement postalCodeEle;
	
	// Enter City
	//driver.findElement(By.cssSelector("#input-createCertificate_city")).sendKeys("Berlin");
	
	@FindBy(css="#input-createCertificate_city")
	WebElement cityEle;
	
	// Enter Country
	//driver.findElement(By.cssSelector("#input-createCertificate_country")).sendKeys("DE");
	
	@FindBy(css="#input-createCertificate_country")
	WebElement countryEle;
	
	// Click Next
	//driver.findElement(By.xpath("//button/span[text()='Next']")).click();
	
	@FindBy(xpath="//button/span[text()='Next']")
	WebElement nextEle;
	
	public void selectSalutation() {
		salutMr.click();
	}
	
	public void enterFirstName(String firstName) {
		firstNameEle.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameEle.sendKeys(lastName);
	}
	
	public void enterEmailId(String emailId) {
		emailEle.sendKeys(emailId);
	}
	
	public void enterStreetName(String streetName) {
		streetEle.sendKeys(streetName);
	}
	
	public void enterHouseNumber(String houseNum) {
		houseNumEle.sendKeys(houseNum);
	}
	
	public void enterPostalCode(String postalCode) {
		postalCodeEle.sendKeys(postalCode);
	}
	
	public void enterCity(String city) {
		cityEle.sendKeys(city);
	}
	
	public void enterCountry(String countryCode) {
		countryEle.sendKeys(countryCode);
	}
	
	public CreatePolicyConfirmationPage proceedToNextScreen() {
		nextEle.click();
		
		// Creating object of Page Object class for Create Single Policy Confirmation screen
		return new CreatePolicyConfirmationPage(driver);		
				
	}

}
