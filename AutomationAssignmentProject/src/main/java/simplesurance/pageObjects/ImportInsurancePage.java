package simplesurance.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import simplesurance.abstractComponents.AbstractComponent;

public class ImportInsurancePage extends AbstractComponent{
	
	WebDriver driver;
	
	public ImportInsurancePage(WebDriver driver) {
		
		// Initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.xpath("//input[@type='file']")).sendKeys(absolutePath);
	
	@FindBy(xpath="//input[@type='file']")
	WebElement fileEle;
	
	// Click Create insurance
	//driver.findElement(By.xpath("//button/span[text()='Create insurance']")).click();
	
	@FindBy(xpath="//button/span[text()='Create insurance']")
	WebElement createInsuranceEle;
	
	// Grab error message
	//String errorMsg= driver.findElement(By.cssSelector("div.MuiSnackbarContent-message ul li")).getText();
	
	@FindBy(css="div.MuiSnackbarContent-message ul li")
	WebElement errorMsgEle;
	
	public void getFile(String fileAbsolutePath) {
		fileEle.sendKeys(fileAbsolutePath);
	}
	
	public void createMultipleInsurance() {
		createInsuranceEle.click();
	}
	
	public String grabErrorMsg() {
		return errorMsgEle.getText();
	}

}
