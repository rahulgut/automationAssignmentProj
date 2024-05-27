package simplesurance.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import simplesurance.abstractComponents.AbstractComponent;

public class PaymentMethodPage extends AbstractComponent{

	WebDriver driver;
	
	public PaymentMethodPage(WebDriver driver) {
		
		// Initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	// Payment method screen
	
	// Select radio SEPA Direct Debit as payment method
	//driver.findElement(By.xpath("//div/p[text()='SEPA Direct Debit']")).click();
	
	@FindBy(xpath="//div/p[text()='SEPA Direct Debit']")
	WebElement directDebitEle;
	
	// Select radio Credit Card / Debit Card as payment method
	//driver.findElement(By.xpath("//div/p[text()='Credit Card / Debit Card']")).click();
	
	@FindBy(xpath="//div/p[text()='Credit Card / Debit Card']")
	WebElement creditCardEle;
	
	// Click Continue to pay
	//driver.findElement(By.xpath("//button/span[text()='Continue to pay']")).click();
	
	@FindBy(xpath="//button/span[text()='Continue to pay']")
	WebElement continuePayEle;
	
	public void selectDirectDebit() {
		directDebitEle.click();
	}
	
	public void selectCreditCard() {
		creditCardEle.click();
	}
	
	public PaymentInformationPage continueToPay() {
		continuePayEle.click();
		// Creating object of Page Object class for Payment information screen
		return new PaymentInformationPage(driver);
	}
	
}
