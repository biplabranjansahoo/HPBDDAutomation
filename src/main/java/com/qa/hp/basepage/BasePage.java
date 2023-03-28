package com.qa.hp.basepage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;

	public BasePage() {

		String filePath = System.getProperty("user.dir") + "\\config.properties";
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public WebDriver inilitize() {

		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {

			DesiredCapabilities capabilities = new DesiredCapabilities();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(capabilities);
			/* WebDriverManager.chromedriver().driverVersion("111.0.5563.64").setup(); */
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} 
		
		else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		return driver;
	}

	public void closeBrowser() {

		driver.close();
	}

}
