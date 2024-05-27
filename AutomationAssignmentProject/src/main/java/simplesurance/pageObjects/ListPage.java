package simplesurance.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import simplesurance.abstractComponents.AbstractComponent;

public class ListPage extends AbstractComponent{

	WebDriver driver;
	
	public ListPage(WebDriver driver) {
		
		// Initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	// Click Search for
	//driver.findElement(By.cssSelector("div[role='combobox']")).click();
	
	@FindBy(css="div[role='combobox']")
	WebElement searchForEle;
	
	// Click Policy Number
	//driver.findElement(By.xpath("//ul/li/span[text()='Policy number']")).click();
	
	@FindBy(xpath="//ul/li/span[text()='Policy number']")
	WebElement policyNumberEle;
	
	// Enter Policy Number
	//driver.findElement(By.cssSelector("input.MuiInputBase-input")).sendKeys("2500" + Keys.RETURN);
	
	@FindBy(css="input.MuiInputBase-input")
	WebElement inputFieldEle;
	
	// Validate Policy Number
	//String policyNumberText= driver.findElement(By.cssSelector("div span.MuiChip-label")).getText();
	
	@FindBy(css="div span.MuiChip-label")
	WebElement validateEle;
	
	// Click X
	//driver.findElement(By.cssSelector("div.MuiInputAdornment-root button.MuiButtonBase-root")).click();
	
	@FindBy(css="div.MuiInputAdornment-root button.MuiButtonBase-root")
	WebElement xEle;
	
			
	// Click E-Mail
	//driver.findElement(By.xpath("//ul/li/span[text()='E-Mail']")).click();
			
	@FindBy(xpath="//ul/li/span[text()='E-Mail']")
	WebElement emailEle;
	
	// Enter email id
	//driver.findElement(By.cssSelector("input.MuiInputBase-input")).sendKeys("stevecooper@gmail.com" + Keys.RETURN);
	
	
	// Validate Email id
	//String emailIdText= driver.findElement(By.cssSelector("div span.MuiChip-label")).getText();
	
	// Toggle switch
	//driver.findElement(By.cssSelector(".MuiSwitch-root")).click();
	
	@FindBy(css=".MuiSwitch-root")
	WebElement toggleSwitchEle;
	
	// Validate text after toggling
	//String rowText= driver.findElement(By.cssSelector("div p.MuiTablePagination-selectLabel")).getText();
	
	@FindBy(css="div p.MuiTablePagination-selectLabel")
	WebElement textToggleEle;
	
	public void clickSearchFor() {
		searchForEle.click();
	}
	
	public void clickOptionPolicyNumber() {
		policyNumberEle.click();
	}
	
	public void enterPolicyNumber(String policyNumber) {
		inputFieldEle.sendKeys(policyNumber + Keys.RETURN);
	}
	
	public String validatePolicyNum() {
		return validateEle.getText();
	}
	
	public void clickX() {
		xEle.click();
	}
	
	public void clickOptionEmail() {
		emailEle.click();
	}
	
	public void enterEmail(String email) {
		inputFieldEle.sendKeys(email + Keys.RETURN);
	}
	
	public String validateEmail() {
		return validateEle.getText();
	}
	
	public void toggleSwitch() {
		toggleSwitchEle.click();
	}
	
	public String validateToggleText() {
		return textToggleEle.getText();
	}
}
