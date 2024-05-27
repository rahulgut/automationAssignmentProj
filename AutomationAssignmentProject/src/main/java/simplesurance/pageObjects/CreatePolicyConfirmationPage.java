package simplesurance.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import simplesurance.abstractComponents.AbstractComponent;

public class CreatePolicyConfirmationPage extends AbstractComponent{

	WebDriver driver;
	
	public CreatePolicyConfirmationPage(WebDriver driver) {
		
		// Initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	// Confirmation details
	
	//List<WebElement> checkboxList= driver.findElements(By.cssSelector("input[type='checkbox']"));
	
	@FindBy(css="input[type='checkbox']")
	List<WebElement> checkboxList;
	
	
	
	// Click Create Insurance
	//driver.findElement(By.xpath("//button/span[text()='Create insurance']")).click();
	
	@FindBy(xpath="//button/span[text()='Create insurance']")
	WebElement createInsuranceEle;
	
	public void confirmationCheckBoxes() {
		for(int i=0;i<checkboxList.size();i++) {
			checkboxList.get(i).click();
		}
	}
	
	public PaymentMethodPage createInsurance() {
		createInsuranceEle.click();
		// Creating object of Page Object class for Payment method screen
		return new PaymentMethodPage(driver);
	}
}
