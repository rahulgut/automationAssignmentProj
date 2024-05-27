package simplesurance.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import simplesurance.pageObjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException {
		
		// Properties class
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//simplesurance//resources//GlobalData.properties");
		prop.load(fis);
		
		String browserName= prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			// Setting up chrome driver
			WebDriverManager.chromedriver().setup();
			
			// Creating driver object
			driver= new ChromeDriver();
		}
		
		// Opening browser window in maximum size
		driver.manage().window().maximize();
		
		// Implicit wait of 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		
		driver= initializeDriver();
		// Creating object of Page Object class for Login screen
		landingPage= new LandingPage(driver);
		
		// Open Application URL
		// Calling goTo() method in Page Object class LandingPage to launch application
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		
		// Read JSON to String
		String jsonContent= FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		
		// String to HashMap
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String, String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
			
		});
		
		return data;
		
	}

}
