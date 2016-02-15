package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.opera.core.systems.OperaDriver;

public class DriverMaster {

	private final static FirefoxProfile profileFireFox = new FirefoxProfile();
	
	private DriverMaster(){}
	
	public static WebDriver getDriver(String driverKey){
		BrowserType browser = BrowserType.get(driverKey);
		WebDriver driver;
		switch (browser) {
			case FIREFOX:
				profileFireFox.setEnableNativeEvents(false);	
				driver = new FirefoxDriver(profileFireFox);
				break;
			case IE:
				driver = new InternetExplorerDriver();
				break;
			case CHROME:
				driver = new ChromeDriver();
				break;
			case OPERA:
				driver = new OperaDriver();
				break;
			default:
				driver = new FirefoxDriver();
				break;
		}
		return driver;
	}
	
}
