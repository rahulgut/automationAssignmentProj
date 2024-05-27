package simplesurance.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import simplesurance.pageObjects.CreatePolicyConfirmationPage;
import simplesurance.pageObjects.CreatePolicyCustomerDetailsPage;
import simplesurance.pageObjects.CreatePolicyProductDetailsPage;
import simplesurance.pageObjects.HomePage;
import simplesurance.pageObjects.InsuranceDetailsPage;
import simplesurance.pageObjects.PaymentInformationPage;
import simplesurance.pageObjects.PaymentMethodPage;
import simplesurance.pageObjects.PaymentRejectedPage;
import simplesurance.testComponents.BaseTest;

public class CreateSinglePolicyTest extends BaseTest {

	@Test(groups= {"CreatePolicy"}, dataProvider="getData")
	public void createPolicy(HashMap<String, String> input) throws IOException {
		
		// Changing language to English
		// Calling changeLanguage() method in Page Object class LandingPage
		landingPage.changeLanguage();
		
		// Entering username and password and Clicking Login button 'Next'
		// Calling loginApplication() method in Page Object class LandingPage
		HomePage hp= landingPage.loginApplication(input.get("username"), input.get("password"));
		
		// Home screen
		
		// Creating object of Page Object class for Home Page screen
		//HomePage hp= new HomePage(driver);
		
		// Calling getNewELe() method in Page Object class HomePage
		hp.getNewELe();
		
		// Calling createNewSingleInsurancePolicy() method in Page Object class HomePage
		CreatePolicyProductDetailsPage productDetails= hp.createNewSingleInsurancePolicy();
		
		// Creating object of Page Object class for Create Single Policy Product Details screen
		//CreatePolicyProductDetailsPage productDetails= new CreatePolicyProductDetailsPage(driver);
		
		// Explicit wait for 'New' locator to be visible
		//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button/span[text()='New']")));
		
		//productDetails.getNewELe();
		
		// Creating new single insurance policy
		// Calling createNewSingleInsurancePolicy() method in Page Object class CreatePolicyProductDetailsPage
		//productDetails.createNewSingleInsurancePolicy();
		
		// Product Details
		
		// Select country
		// Calling selectCountry() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.selectCountry(input.get("country"));
		
		// Select product name
		// Calling selectProductName() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.selectProductName();
		
		// Select tariff
		// Calling selectTariff() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.selectTariff();
		
		// Select Insurance Category
		// Calling selectInsuranceCategory() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.selectInsuranceCategory();
		
		// Select Duration
		// Calling selectDuration() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.selectDuration();
		
		// Select Payment Type
		// Calling selectPaymentFrequency() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.selectPaymentFrequency();
		
		// Select Class
		// Calling selectClass() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.selectClass();
		
		// Enter Serial number
		// Calling serialNumber() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.serialNumber(input.get("serialNum"));
		
		// Click Next
		// Calling proceedToNextPage() method in Page Object class CreatePolicyProductDetailsPage
		CreatePolicyCustomerDetailsPage customerDetails= productDetails.proceedToNextPage();
		
		// Customer details
		
		// Creating object of Page Object class for Create Single Policy Customer Details screen
		//CreatePolicyCustomerDetailsPage customerDetails= new CreatePolicyCustomerDetailsPage(driver);
		
		
		// Select Mr. Salutation
		// Calling selectSalutation() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.selectSalutation();
		
		// Enter first name
		// Calling enterFirstName() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterFirstName(input.get("firstName"));
		
		// Enter last name
		// Calling enterLastName() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterLastName(input.get("lastName"));
		
		// Enter email id
		// Calling enterEmailId() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterEmailId(input.get("email"));
		
		// Enter Street
		// Calling enterStreetName() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterStreetName(input.get("streetName"));
		
		// Enter house number
		// Calling enterHouseNumber() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterHouseNumber(input.get("houseNum"));
		
		// Enter Postal code
		// Calling enterPostalCode() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterPostalCode(input.get("postalCode"));
		
		// Enter City
		// Calling enterCity() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterCity(input.get("city"));
		
		// Enter Country
		// Calling enterCountry() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterCountry(input.get("countryCode"));
		
		// Click Next
		// Calling proceedToNextScreen() method in Page Object class CreatePolicyCustomerDetailsPage
		CreatePolicyConfirmationPage confirmation= customerDetails.proceedToNextScreen();
		
		// Confirmation details
		// Creating object of Page Object class for Create Single Policy Confirmation screen
		//CreatePolicyConfirmationPage confirmation= new CreatePolicyConfirmationPage(driver);
		
		// Check all the confirmation checkboxes
		// Calling confirmationCheckBoxes() method in Page Object class CreatePolicyConfirmationPage
		confirmation.confirmationCheckBoxes();
		
		// Click Create Insurance
		// Calling createInsurance() method in Page Object class CreatePolicyConfirmationPage
		PaymentMethodPage paymentMethod= confirmation.createInsurance();
		
		// Payment method screen
		// Creating object of Page Object class for Payment method screen
		//PaymentMethodPage paymentMethod= new PaymentMethodPage(driver);
		
		// Select radio SEPA Direct Debit as payment method
		//driver.findElement(By.xpath("//div/p[text()='SEPA Direct Debit']")).click();
		
		// Calling selectDirectDebit() method in Page Object class PaymentMethodPage
		paymentMethod.selectDirectDebit();
		
		// Click Continue to pay
		//driver.findElement(By.xpath("//button/span[text()='Continue to pay']")).click();
		
		// Calling continueToPay() method in Page Object class PaymentMethodPage
		PaymentInformationPage paymentInfo= paymentMethod.continueToPay();
		
		// Payment information screen
		
		// Creating object of Page Object class for Payment information screen
		//PaymentInformationPage paymentInfo= new PaymentInformationPage(driver);
		
		// Switch to iframe to send card details
		// Calling switchiFrame() method in Page Object class PaymentInformationPage
		paymentInfo.switchiFrame();
		
		// Enter Direct DebitCard details
		
		// Enter Direct DebitCard number
		// Calling enterDirectDebitCardNum() method in Page Object class PaymentInformationPage
		paymentInfo.enterDirectDebitCardNum(input.get("directDebitCard"));
		
		// Switching back to the parent or default frame
		// Calling switchBackFrame() method in Page Object class PaymentInformationPage
		paymentInfo.switchBackFrame();
		
		// Check the checkbox
		// Calling confirmCheckBox() method in Page Object class PaymentInformationPage
		paymentInfo.confirmCheckBox();
		
		// Click Place order
		// Calling placeOrder() method in Page Object class PaymentInformationPage
		paymentInfo.placeOrder();
		
		// Payment rejection screen
		// Creating object of Page Object class for Payment rejection screen
		PaymentRejectedPage paymentRejection= new PaymentRejectedPage(driver);
		
		// Validate payment rejection text
		
		// Calling getPaymentRejectText() method in Page Object class PaymentRejectedPage
		String rejectText= paymentRejection.getPaymentRejectText();
		Assert.assertEquals("Payment was rejected", rejectText);
		
		// Click Choose another payment method
		// Calling changePaymentMethod() method in Page Object class PaymentRejectedPage
		paymentRejection.changePaymentMethod();
		
		// Payment method screen
		
		// Select radio Credit Card / Debit Card as payment method
		// Calling selectCreditCard() method in Page Object class PaymentMethodPage
		paymentMethod.selectCreditCard();
		
		// Click Continue to pay
		// Calling continueToPay() method in Page Object class PaymentMethodPage
		paymentMethod.continueToPay();
		
		// Payment information screen
		
		// Switch to iframe to send card details
		// Calling switchiFrame() method in Page Object class PaymentInformationPage
		paymentInfo.switchiFrame();
		
		// Enter Credit Card details
		
		// Enter credit card number
		// Calling enterCreditCardNum() method in Page Object class PaymentInformationPage
		paymentInfo.enterCreditCardNum(input.get("creditCard"));
		
		// Enter card expiration date
		// Calling enterCardExpiryDate() method in Page Object class PaymentInformationPage
		paymentInfo.enterCardExpiryDate("0425");
		
		// Enter CVC
		// Calling enterCVC() method in Page Object class PaymentInformationPage
		paymentInfo.enterCVC("123");
		
		// Switching back to he parent or default frame
		// Calling switchBackFrame() method in Page Object class PaymentInformationPage
		paymentInfo.switchBackFrame();
		
		// Click Place order
		// Calling placeOrder() method in Page Object class PaymentInformationPage
		paymentInfo.placeOrder();
		
		// Insurance details screen
		
		// Creating object of Page Object class for Insurance details screen
		InsuranceDetailsPage insuranceDetails= new InsuranceDetailsPage(driver);
		
	
		
		System.out.println("Insurance successfully created");
		
		// Validate policy status
		
		// Grab status
		// Calling getPolicyStatus() method in Page Object class InsuranceDetailsPage
		String policyStatus= insuranceDetails.getPolicyStatus();
		Assert.assertEquals("Created", policyStatus);
		
		// Validate name
		// Calling getName() method in Page Object class InsuranceDetailsPage
		String grabName= insuranceDetails.getName();
		String name= input.get("firstName")+" "+input.get("lastName");
		Assert.assertEquals(name, grabName);
		
		// Validate city
		// Calling getCity() method in Page Object class InsuranceDetailsPage
		String grabcity= insuranceDetails.getCity();
		Assert.assertEquals(input.get("city"), grabcity);
		
		// Validate email
		// Calling getEmail() method in Page Object class InsuranceDetailsPage
		String grabEmail= insuranceDetails.getEmail();
		Assert.assertEquals(input.get("email"), grabEmail);

	}
	
	@Test
	public void createPolicyError() throws IOException {
		
		// Open Application URL
//		// Calling goTo() method in Page Object class LandingPage to launch application
//		landingPage.goTo();
		
		//landingPage= launchApplication();
		
		// Changing language to English
		// Calling changeLanguage() method in Page Object class LandingPage
		landingPage.changeLanguage();
		
		// Entering username and password and Clicking Login button 'Next'
		// Calling loginApplication() method in Page Object class LandingPage
		HomePage hp= landingPage.loginApplication("testsellingpartner2@simplesurance.de", "TestSellingPartner2Pass");
		
		// Home screen
		
		// Creating object of Page Object class for Home Page screen
		//HomePage hp= new HomePage(driver);
		
		// Explicit wait for 'New' locator to be visible
		// Calling getNewELe() method in Page Object class HomePage
		hp.getNewELe();
		
		// Calling createNewSingleInsurancePolicy() method in Page Object class HomePage
		CreatePolicyProductDetailsPage productDetails= hp.createNewSingleInsurancePolicy();
		
		// Creating object of Page Object class for Create Single Policy Product Details screen
		//CreatePolicyProductDetailsPage productDetails= new CreatePolicyProductDetailsPage(driver);
		
		// Product Details
		
		// Select country
		// Calling selectCountry() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.selectCountry("Cyprus");
		
		// Select product name
		// Calling selectProductName() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.selectProductName();
		
		// Select tariff
		// Calling selectTariff() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.selectTariff();
		
		// Select Insurance Category
		// Calling selectInsuranceCategory() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.selectInsuranceCategory();
		
		// Select Duration
		// Calling selectDuration() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.selectDuration();
		
		// Select Payment Type
		// Calling selectPaymentFrequency() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.selectPaymentFrequency();
		
		// Select Class
		// Calling selectClass() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.selectClass();
		
		// Enter Serial number
		// Calling serialNumber() method in Page Object class CreatePolicyProductDetailsPage
		productDetails.serialNumber("12134");
		
		// Click Next
		// Calling proceedToNextPage() method in Page Object class CreatePolicyProductDetailsPage
		CreatePolicyCustomerDetailsPage customerDetails= productDetails.proceedToNextPage();
		
		// Customer details
		
		// Creating object of Page Object class for Create Single Policy Customer Details screen
		//CreatePolicyCustomerDetailsPage customerDetails= new CreatePolicyCustomerDetailsPage(driver);
		
		
		// Select Mr. Salutation
		// Calling selectSalutation() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.selectSalutation();
		
		// Enter first name
		// Calling enterFirstName() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterFirstName("Steve");
		
		// Enter last name
		// Calling enterLastName() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterLastName("Cooper");
		
		// Enter email id
		// Calling enterEmailId() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterEmailId("stevecooper@gm.com");
		
		// Enter Street
		// Calling enterStreetName() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterStreetName("Third Street");
		
		// Enter house number
		// Calling enterHouseNumber() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterHouseNumber("12");
		
		// Enter Postal code
		// Calling enterPostalCode() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterPostalCode("10178");
		
		// Enter City
		// Calling enterCity() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterCity("Berlin");
		
		// Enter Country
		// Calling enterCountry() method in Page Object class CreatePolicyCustomerDetailsPage
		customerDetails.enterCountry("DE");
		
		// Click Next
		// Calling proceedToNextScreen() method in Page Object class CreatePolicyCustomerDetailsPage
		CreatePolicyConfirmationPage confirmation= customerDetails.proceedToNextScreen();
		
		// Confirmation details
		// Creating object of Page Object class for Create Single Policy Confirmation screen
		//CreatePolicyConfirmationPage confirmation= new CreatePolicyConfirmationPage(driver);
		
		// Check all the confirmation checkboxes
		// Calling confirmationCheckBoxes() method in Page Object class CreatePolicyConfirmationPage
		confirmation.confirmationCheckBoxes();
		
		// Click Create Insurance
		// Calling createInsurance() method in Page Object class CreatePolicyConfirmationPage
		PaymentMethodPage paymentMethod= confirmation.createInsurance();
		
		// Payment method screen
		// Creating object of Page Object class for Payment method screen
		//PaymentMethodPage paymentMethod= new PaymentMethodPage(driver);
		
		// Select radio SEPA Direct Debit as payment method
		//driver.findElement(By.xpath("//div/p[text()='SEPA Direct Debit']")).click();
		
		// Calling selectDirectDebit() method in Page Object class PaymentMethodPage
		paymentMethod.selectDirectDebit();
		
		// Click Continue to pay
		//driver.findElement(By.xpath("//button/span[text()='Continue to pay']")).click();
		
		// Calling continueToPay() method in Page Object class PaymentMethodPage
		PaymentInformationPage paymentInfo= paymentMethod.continueToPay();
		
		// Payment information screen
		
		// Creating object of Page Object class for Payment information screen
		//PaymentInformationPage paymentInfo= new PaymentInformationPage(driver);
		
		// Switch to iframe to send card details
		// Calling switchiFrame() method in Page Object class PaymentInformationPage
		paymentInfo.switchiFrame();
		
		// Enter Direct DebitCard details
		
		// Enter Direct DebitCard number
		// Calling enterDirectDebitCardNum() method in Page Object class PaymentInformationPage
		paymentInfo.enterDirectDebitCardNum("DE89370400440532013000");
		
		// Switching back to the parent or default frame
		// Calling switchBackFrame() method in Page Object class PaymentInformationPage
		paymentInfo.switchBackFrame();
		
		// Check the checkbox
		// Calling confirmCheckBox() method in Page Object class PaymentInformationPage
		paymentInfo.confirmCheckBox();
		
		// Click Place order
		// Calling placeOrder() method in Page Object class PaymentInformationPage
		paymentInfo.placeOrder();
		
		// Payment rejection screen
		// Creating object of Page Object class for Payment rejection screen
		PaymentRejectedPage paymentRejection= new PaymentRejectedPage(driver);
		
		// Validate payment rejection text
		
		// Calling getPaymentRejectText() method in Page Object class PaymentRejectedPage
		String rejectText= paymentRejection.getPaymentRejectText();
		Assert.assertEquals("Payment was rejected", rejectText);
		
		// Click Choose another payment method
		// Calling changePaymentMethod() method in Page Object class PaymentRejectedPage
		paymentRejection.changePaymentMethod();
		
		// Payment method screen
		
		// Select radio Credit Card / Debit Card as payment method
		// Calling selectCreditCard() method in Page Object class PaymentMethodPage
		paymentMethod.selectCreditCard();
		
		// Click Continue to pay
		// Calling continueToPay() method in Page Object class PaymentMethodPage
		paymentMethod.continueToPay();
		
		// Payment information screen
		
		// Switch to iframe to send card details
		// Calling switchiFrame() method in Page Object class PaymentInformationPage
		paymentInfo.switchiFrame();
		
		// Enter Credit Card details
		
		// Enter credit card number
		// Calling enterCreditCardNum() method in Page Object class PaymentInformationPage
		paymentInfo.enterCreditCardNum("4242424242424242");
		
		// Enter card expiration date
		// Calling enterCardExpiryDate() method in Page Object class PaymentInformationPage
		paymentInfo.enterCardExpiryDate("0425");
		
		// Enter CVC
		// Calling enterCVC() method in Page Object class PaymentInformationPage
		paymentInfo.enterCVC("123");
		
		// Switching back to he parent or default frame
		// Calling switchBackFrame() method in Page Object class PaymentInformationPage
		paymentInfo.switchBackFrame();
		
		// Click Place order
		// Calling placeOrder() method in Page Object class PaymentInformationPage
		paymentInfo.placeOrder();
		
		// Insurance details screen
		
		// Creating object of Page Object class for Insurance details screen
		InsuranceDetailsPage insuranceDetails= new InsuranceDetailsPage(driver);
		
		// Assert icon on Insurance details screen
		
		// Calling isErrorIconDisplayed() method in Page Object class InsuranceDetailsPage
		Boolean errorIcon= insuranceDetails.isErrorIconDisplayed();
		
		Assert.assertTrue(errorIcon);
		System.out.println("Insurance not created");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> data= getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//simplesurance//data//CreateInsurance.json");
		
		return new Object[][] { {data.get(0)},{data.get(1)} };
	}
	
	public String getScreenshot(String testCaseName) throws IOException {
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir")+ "//reports//"+testCaseName+ ".png");
		FileUtils.copyFile(source, file);
		
		return System.getProperty("user.dir")+ "//reports//"+testCaseName+ ".png";
	}

}
