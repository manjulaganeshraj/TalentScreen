package com.test.webPages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.talentscreen.pageObjects.LandingPage;
import com.talentscreen.pageObjects.LoginPage;
import com.test.base.Base;

import junit.framework.Assert;


public class HomePage extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String passWord, String text) throws IOException, InterruptedException{

		driver =initializeDriver();
		log.info("Driver is initialised");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");

		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getUserName().sendKeys(userName);
		lp.getPassWord().sendKeys(passWord);
		lp.getLoginTs().click();
		log.info(text);

		Thread.sleep(3000);
		String actual = lp.getErrorMessage();
		String expected = "You have not registered. Please sign up.";
		Assert.assertEquals(expected, actual);
		log.info("Successfully valiated Error Message");

	}
	

	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[2][3];

		data[0][0] = "admin@innovapath.com";
		data[0][1] = "Innovapath";
		data[0][2] = "Non-restrictedUser";

		data[1][0] = "candidate@gmail.com";
		data[1][1] = "course";
		data[1][2] = "restrictedUser";

		return data;
	}
}
