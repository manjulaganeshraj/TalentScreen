package com.test.webPages;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.talentscreen.pageObjects.LandingPage;
import com.talentscreen.utils.ExcelHelper;
import com.talentscreen.utils.FileUtilityManager;
import com.talentscreen.utils.TestUtil;
import com.test.base.Base;

public class AutocompleteTest extends Base {
	
	@DataProvider
	public Object[][] getAutocompleteData(){
		
		Object data[][] = TestUtil.getTestData("TestData");
		return data;
	}

	@Test(dataProvider = "getAutocompleteData")
	public void searchBoxTest(String words) throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		LandingPage l = new LandingPage(driver);



		List<String> results = l.selectOptionWithText(words);
		
		System.out.println(words +" - results:"+results.size() );	
		
//		if(results.size()==0)
//		{
//			System.out.println("here");	
//			Assert.fail();
//		}
		
		results.forEach(x -> 
		{
			//System.out.println(x);		
			if((x.toLowerCase().contains(words.toLowerCase()) == false))
				Assert.fail(x+" does not contain "+ words);
				
		});
		
		//l.normalWait(driver, 5);
	}
	
	/*@DataProvider(name="searchData")
	public Object[][] testData() throws IOException{
		return ExcelHelper.getData("TestData");
	}
	
	@Test(dataProvider="searchData")//(groups="smoke")
	public void searchTest(String searchKeyWord, String expected){
		
	
	}*/
	
}
