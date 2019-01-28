package com.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Base {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\manju\\workspace\\TalentScreenAutomationFW\\src\\main\\java\\com\\talentscreen\\resources\\data.properties");
		prop.load(fis);                           
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\manju\\workspace\\TalentScreenAutomationFW\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}
		else if(browserName.equals("firefox")){

		}
		
		return driver;


	}
	
	
	public void getScreenshot(String result) throws IOException{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://Users//manju//"+result+"screenshot.png"));
	}
	
	@AfterMethod
	public void tearDown() { 
		driver.close();
		driver=null;
	} 

}
