package functions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base 
{
	WebDriver driver;
	Properties prop = new Properties();
	public WebDriver driverInitialize() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/Data.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser");
		String url = prop.getProperty("url");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("headlessChrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");
			ChromeOptions chromeOptionsObject = new ChromeOptions();
			chromeOptionsObject.addArguments("headless");
			driver = new ChromeDriver(chromeOptionsObject);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/resources/geckodriver");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("HeadlessFirefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/resources/BrowserDrivers/geckodriver");
			FirefoxOptions firefoxOptionsObject = new FirefoxOptions();
			firefoxOptionsObject.addArguments("headless");
			firefoxOptionsObject.setHeadless(true);
			driver = new FirefoxDriver(firefoxOptionsObject);
		}
		driver.get(url);
		return driver;
	}
}
