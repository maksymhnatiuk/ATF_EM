package core;
// Base class for all tests (it configures Driver for tests)
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import core.DriverMaster;
import static core.Configuration.setGlobalEnvironment;

public abstract class BaseTest {
    
	protected WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	@Parameters({"browser", "environment"})
	public void setUp (@Optional ("firefox") String browser, @Optional ("prod") String environment){
		/*
		if (browser.equals("firefox")){
			System.out.println("-----------firefox driver creation---------");
			driver = new FirefoxDriver();
		} else if(browser.equals("ie")){
			System.out.println("-----------ie driver creation---------");
			driver = new InternetExplorerDriver();
		} else if (browser.equals("chrome")){
			System.out.println("-----------CHROME driver creation---------");
			driver = new ChromeDriver();
		} else if (browser.equals("opera")){
			System.out.println("-----------opera driver creation---------");
			driver = new OperaDriver();
		} else {
			System.out.println("-----------other driver creation (a needed driver was not found... FF driver will be created by default)---------");
			driver = new FirefoxDriver();
		}
		*/
		setGlobalEnvironment(environment);
		driver = DriverMaster.getDriver(browser);
		driver.manage().window().maximize();
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
}
