package simplesurance.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import simplesurance.abstractComponents.AbstractComponent;

public class PaymentRejectedPage extends AbstractComponent{

	WebDriver driver;
	
	public PaymentRejectedPage(WebDriver driver) {
		
		// Initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	// Payment rejection screen
	
	// Validate payment rejection text
	//String rejectText= driver.findElement(By.xpath("//div/h1[text()='Payment was rejected']")).getText();
	
	@FindBy(xpath="//div/h1[text()='Payment was rejected']")
	WebElement paymentRejectEle;
	
	// Click Choose another payment method
	//driver.findElement(By.xpath("//button/span[text()='Choose another payment method']")).click();
	
	@FindBy(xpath="//button/span[text()='Choose another payment method']")
	WebElement anotherPayMethodEle;
	
	public String getPaymentRejectText() {
		return paymentRejectEle.getText();
	}
	
	public void changePaymentMethod() {
		anotherPayMethodEle.click();
	}
	
}
