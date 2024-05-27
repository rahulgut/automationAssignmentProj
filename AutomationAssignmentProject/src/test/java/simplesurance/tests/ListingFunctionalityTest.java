package simplesurance.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import simplesurance.pageObjects.ListPage;
import simplesurance.testComponents.BaseTest;

public class ListingFunctionalityTest extends BaseTest {

	@Test
	public void listingVerify() {
		
		// Changing language to English
		// Calling changeLanguage() method in Page Object class LandingPage
		landingPage.changeLanguage();
		
		// Entering username and password and Clicking Login button 'Next'
		// Calling loginApplication() method in Page Object class Landing Page
		landingPage.loginApplication("testsellingpartner2@simplesurance.de", "TestSellingPartner2Pass");
		
		// Home Screen
		
		// Creating object of Page Object class for List Page screen
		ListPage lp= new ListPage(driver);
		
		// Click Search for
		// Calling clickSearchFor() method in Page Object class ListPage
		lp.clickSearchFor();
		
		// Click Policy Number
		// Calling clickOptionPolicyNumber() method in Page Object class ListPage
		lp.clickOptionPolicyNumber();
		
		// Enter Policy Number
		// Calling enterPolicyNumber() method in Page Object class ListPage
		lp.enterPolicyNumber("2500");
		
		// Validate Policy Number
		// Calling validatePolicyNum() method in Page Object class ListPage
		String policyNumberText= lp.validatePolicyNum();
		Assert.assertTrue(policyNumberText.contains("2500"));
		
		// Click X
		// Calling clickX() method in Page Object class ListPage
		lp.clickX();
		
		// Click Search for
		// Calling clickSearchFor() method in Page Object class ListPage
		lp.clickSearchFor();
				
		// Click E-Mail
		// Calling clickOptionEmail() method in Page Object class ListPage
		lp.clickOptionEmail();
				
		// Enter email id
		// Calling enterEmail() method in Page Object class ListPage
		lp.enterEmail("stevecooper@gmail.com");
		
		// Validate Email id
		// Calling validateEmail() method in Page Object class ListPage
		String emailIdText= lp.validateEmail();
		Assert.assertTrue(emailIdText.contains("stevecooper@gmail.com"));
		
		// Click X
		// Calling clickX() method in Page Object class ListPage		
		lp.clickX();
		
		// Click Search for
		// Calling clickSearchFor() method in Page Object class ListPage
		lp.clickSearchFor();
		
		// Toggle switch
		// Calling toggleSwitch() method in Page Object class ListPage
		lp.toggleSwitch();
		
		// Validate text after toggling
		// Calling validateToggleText() method in Page Object class ListPage
		String rowText= lp.validateToggleText();
		Assert.assertEquals("Rows per page", rowText);

	}

}
