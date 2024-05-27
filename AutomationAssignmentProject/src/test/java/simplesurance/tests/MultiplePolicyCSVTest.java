package simplesurance.tests;

import org.testng.annotations.Test;
import java.io.File;
import org.testng.Assert;
import simplesurance.pageObjects.HomePage;
import simplesurance.pageObjects.ImportInsurancePage;
import simplesurance.testComponents.BaseTest;

public class MultiplePolicyCSVTest extends BaseTest {

	@Test
	public void createMultiplePolicyCSV() {
		
		// Changing language to English
		// Calling changeLanguage() method in Page Object class LandingPage
		landingPage.changeLanguage();
		
		// Entering username and password and Clicking Login button 'Next'
		// Calling loginApplication() method in Page Object class Landing Page
		HomePage hp= landingPage.loginApplication("testsellingpartner2@simplesurance.de", "TestSellingPartner2Pass");
		
		// Home screen
		
		// Creating object of Page Object class for Home Page screen
		//HomePage hp= new HomePage(driver);
		
		// Click Import
		// Calling importFile() method in Page Object class HomePage
		ImportInsurancePage importInsurance= hp.gotoImport();
		
		// Creating object of Page Object class for Import insurance screen
		//ImportInsurancePage importInsurance= new ImportInsurancePage(driver);
		
		// Import CSV file
		String relativePath = "testdata.csv";
		File file = new File(relativePath);
		String absolutePath = file.getAbsolutePath();
		
		// Calling getFile() method in Page Object class ImportInsurancePage
		importInsurance.getFile(absolutePath);
		
		// Click Create insurance
		// Calling createMultipleInsurance() method in Page Object class ImportInsurancePage
		importInsurance.createMultipleInsurance();
		
		// Grab error message
		// Calling grabErrorMsg() method in Page Object class ImportInsurancePage
		String errorMsg= importInsurance.grabErrorMsg();
		
		// Assertion on error message
		Assert.assertTrue(errorMsg.contains("Error"));

	}

}
