package simplesurance.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import simplesurance.abstractComponents.AbstractComponent;

public class HomePage extends AbstractComponent{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		// Initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	// Creating new single insurance policy
	//driver.findElement(By.xpath("//button/span[text()='New']")).click();
	
	@FindBy(xpath="//button/span[text()='New']")
	WebElement newEle;
	
	By newLocator= By.xpath("//button/span[text()='New']");
	
	// Click Import
	//driver.findElement(By.xpath("//button/span[text()='Import']")).click();
	
	@FindBy(xpath="//button/span[text()='Import']")
	WebElement importEle;
	
	public void getNewELe() {
		waitForElementToAppear(newLocator);
	}
	
	public CreatePolicyProductDetailsPage createNewSingleInsurancePolicy() {
		
		newEle.click();
		// Creating object of Page Object class for Create Single Policy Product Details screen
		return new CreatePolicyProductDetailsPage(driver);
				
	}
	
	public ImportInsurancePage gotoImport() {
		importEle.click();
		// Creating object of Page Object class for Import insurance screen
		return new ImportInsurancePage(driver);
		
	}

}
