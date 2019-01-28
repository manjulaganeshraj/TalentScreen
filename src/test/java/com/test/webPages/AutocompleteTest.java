package com.test.webPages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.talentscreen.pageObjects.LandingPage;
import com.test.base.Base;

public class AutocompleteTest extends Base {

	@Test
	public void rightClickTest() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		LandingPage l = new LandingPage(driver);


		List<String> results = l.selectOptionWithText("ja");
		
		if(results.size()==0)
		{
			System.out.println("here");	
			Assert.fail();
		}
		
		results.forEach(x -> 
		{
			System.out.println(x);		
			if(x.contains("ja"))
				Assert.assertTrue(true);
				  
			else
				Assert.fail();
		});
		
		//l.normalWait(driver, 5);
	}
	
}
