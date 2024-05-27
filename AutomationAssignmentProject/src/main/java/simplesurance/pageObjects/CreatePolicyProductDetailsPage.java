package simplesurance.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import simplesurance.abstractComponents.AbstractComponent;

public class CreatePolicyProductDetailsPage extends AbstractComponent{
	
	WebDriver driver;
	public CreatePolicyProductDetailsPage(WebDriver driver) {
		
		// Initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	// Product Details
	
	// Select country
	//driver.findElement(By.cssSelector("#country-select")).click();
	
	@FindBy(css="#country-select")
	WebElement countryDropDown;
	
	//List<WebElement> countryList= driver.findElements(By.cssSelector("ul[aria-labelledby='country-select-label'] li"));
	
	@FindBy(css="ul[aria-labelledby='country-select-label'] li")
	List<WebElement> countryList;
	
	
	// Select product name
	//driver.findElement(By.cssSelector("#product-name-select")).click();
	
	@FindBy(css="#product-name-select")
	WebElement productNameDropDown;
	
	//driver.findElement(By.cssSelector("ul[aria-labelledby='product-name-select-label'] li")).click();
	
	@FindBy(css="ul[aria-labelledby='product-name-select-label'] li")
	WebElement productEle;
	
	// Select tariff
	//driver.findElement(By.cssSelector("#tariff-name-select")).click();
	
	@FindBy(css="#tariff-name-select")
	WebElement tariffDropDown;
	
	//driver.findElement(By.cssSelector("ul[aria-labelledby='tariff-name-select-label'] li")).click();
	
	@FindBy(css="ul[aria-labelledby='tariff-name-select-label'] li")
	WebElement tariffEle;
	
	// Select Insurance Category
	//driver.findElement(By.cssSelector("#category-name-select")).click();
	
	@FindBy(css="#category-name-select")
	WebElement categoryDropDown;
	
	//driver.findElement(By.cssSelector("ul[aria-labelledby='category-name-select-label'] li")).click();
	
	@FindBy(css="ul[aria-labelledby='category-name-select-label'] li")
	WebElement categoryEle;
	
	// Select Duration
	//driver.findElement(By.cssSelector("#duration-select")).click();
	
	@FindBy(css="#duration-select")
	WebElement durationDropDown;
	
	//driver.findElement(By.cssSelector("ul li[data-value='12 month(s)']")).click();
	
	@FindBy(css="ul li[data-value='12 month(s)']")
	WebElement durationEle;
	
	// Select Payment Type
	//driver.findElement(By.cssSelector("#frequency-select")).click();
	
	@FindBy(css="#frequency-select")
	WebElement frequencyDropDown;
	
	//driver.findElement(By.cssSelector("ul[aria-labelledby='frequency-select-label'] li")).click();
	
	@FindBy(css="ul[aria-labelledby='frequency-select-label'] li")
	WebElement frequencyEle;
	
	// Select Class
	//driver.findElement(By.cssSelector("#class-name-select")).click();
	
	@FindBy(css="#class-name-select")
	WebElement classDropDown;
	
	//driver.findElement(By.cssSelector("ul li[data-value='PDCODE504843']")).click();
	
	@FindBy(css="ul li[data-value='PDCODE504843']")
	WebElement classEle;
	
	// Enter Serial number
	//driver.findElement(By.cssSelector("#input-createCertificate_serialNumber")).sendKeys("SER-12134");
	
	@FindBy(css="#input-createCertificate_serialNumber")
	WebElement serialNumEle;
	
	// Click Next
	//driver.findElement(By.xpath("//button/span[text()='Next']")).click();
	
	@FindBy(xpath="//button/span[text()='Next']")
	WebElement NextEle;
	
	public void selectCountry(String countryName) {
		
		countryDropDown.click();
		for(int i=0;i<countryList.size();i++) {
			if(countryList.get(i).getText().equalsIgnoreCase(countryName)) {
				countryList.get(i).click();
			}
		}
	}
	
	public void selectProductName() {
		
		productNameDropDown.click();
		productEle.click();
	}
	
	public void selectTariff() {
		
		tariffDropDown.click();
		tariffEle.click();
	}
	
	public void selectInsuranceCategory() {
		
		categoryDropDown.click();
		categoryEle.click();
	}
	
	public void selectDuration() {
		
		durationDropDown.click();
		durationEle.click();
	}
	
	public void selectPaymentFrequency() {
		
		frequencyDropDown.click();
		frequencyEle.click();
	}
	
	public void selectClass() {
		
		classDropDown.click();
		classEle.click();
	}
	
	public void serialNumber(String serialNumber) {
		serialNumEle.sendKeys(serialNumber);
	}
	
	public CreatePolicyCustomerDetailsPage proceedToNextPage() {
		NextEle.click();
		// Creating object of Page Object class for Create Single Policy Customer Details screen
		return new CreatePolicyCustomerDetailsPage(driver);
	}

}
