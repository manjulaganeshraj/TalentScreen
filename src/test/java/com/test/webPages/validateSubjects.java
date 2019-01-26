package com.test.webPages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.talentscreen.pageObjects.LandingPage;
import com.test.base.Base;

import junit.framework.Assert;


public class validateSubjects extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test
	public void validateTSSubjects() throws IOException{
		
		driver =initializeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigation().isDisplayed());
		log.info("Subjects bar is displayed");
		
	}
		
	
}
