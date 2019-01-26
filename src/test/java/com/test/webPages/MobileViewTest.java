package com.test.webPages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.test.base.Base;



public class MobileViewTest extends Base{

	static DesiredCapabilities  capabilities;
	static String deviceName;
	
	@Test
	public void iPadProTest() throws IOException{     

		//  deviceName = "Google Nexus 5";
		//  deviceName = "Samsung Galaxy S4";
		//  deviceName = "Samsung Galaxy Note 3";
		//  deviceName = "Samsung Galaxy Note II";
		//  deviceName = "Apple iPhone 4";
		//  deviceName = "Apple iPhone 5";
		  deviceName = "iPad Pro";


		 initializeDriver();

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", deviceName);

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		this.driver = new ChromeDriver(chromeOptions);
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		

	}

}
