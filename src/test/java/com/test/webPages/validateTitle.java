package com.test.webPages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.talentscreen.pageObjects.LandingPage;
import com.test.base.Base;



public class validateTitle extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test
	public void validateTSTitle() throws IOException{

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		String actual = l.getTitle().getText();
		String expected = "Welcome To TalentScreen";
		Assert.assertEquals(expected, actual);
		log.info("Successfully valiated Text Message");

	}

	
}
