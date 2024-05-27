package simplesurance.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import simplesurance.abstractComponents.AbstractComponent;

public class PaymentInformationPage extends AbstractComponent{
	
	WebDriver driver;
	public PaymentInformationPage(WebDriver driver) {
		
		// Initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	// Payment information screen
	
	// Switch to iframe to send card details
	//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[allow='payment *']")));
			
	@FindBy(css="iframe[allow='payment *']")
	WebElement iframeEle;
	
	// Enter Direct DebitCard details
						
	// Enter Direct DebitCard number
	//driver.findElement(By.cssSelector("input.InputElement")).sendKeys("DE89370400440532013000");
	
	@FindBy(css="input.InputElement")
	WebElement cardNumInputFieldEle;
			
	// Switching back to the parent or default frame
	//driver.switchTo().defaultContent();
	
	// Check the checkbox
	//driver.findElement(By.cssSelector("input[type=checkbox]")).click();
	
	@FindBy(css="input[type=checkbox]")
	WebElement checkboxEle;
	
	// Click Place order
	//driver.findElement(By.xpath("//button/span[text()='Place order']")).click();
	
	@FindBy(xpath="//button/span[text()='Place order']")
	WebElement placeOrderEle;
	
	// Enter Credit Card details
	
	// Enter credit card number
	//driver.findElement(By.cssSelector("input.InputElement")).sendKeys("4242424242424242");
	
	
	// Enter card expiration date
	//driver.findElement(By.cssSelector("input[name='exp-date']")).sendKeys("0425");
	
	@FindBy(css="input[name='exp-date']")
	WebElement expDateEle;
	
	// Enter CVC
	//driver.findElement(By.cssSelector("input[name='cvc']")).sendKeys("123");
	
	@FindBy(css="input[name='cvc']")
	WebElement cvcEle;
	
	public void switchiFrame() {
		driver.switchTo().frame(iframeEle);
	}
	
	public void enterDirectDebitCardNum(String ddCardNum) {
		cardNumInputFieldEle.sendKeys(ddCardNum);
	}
	
	public void enterCreditCardNum(String creditCardNum) {
		cardNumInputFieldEle.sendKeys(creditCardNum);
	}
	
	public void enterCardExpiryDate(String expDate) {
		expDateEle.sendKeys(expDate);
	}
	
	public void enterCVC(String cvc) {
		cvcEle.sendKeys(cvc);
	}
	
	public void switchBackFrame() {
		driver.switchTo().defaultContent();
	}
	
	public void confirmCheckBox() {
		checkboxEle.click();
	}
	
	public void placeOrder() {
		placeOrderEle.click();
	}

}
