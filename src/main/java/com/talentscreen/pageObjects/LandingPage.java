package com.talentscreen.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.talentscreen.utils.HelperManager;

public class LandingPage  {

	WebDriver driver;

	By login = By.cssSelector("a[href*='login']");
	By title = By.cssSelector(".shell-input>h2");
	By subjects = By.cssSelector("#main-nav > ul > li:nth-child(1) > a");
	By search = By.xpath("//input[@ng-model='search']");
	By listOfElements = By.xpath("/html/body[@class='fp-viewing-firstPage']/div[1]//div[@class='ng-scope']/div/div[1]//search-job-resume[@class='ng-isolate-scope']//ul[@role='listbox']");

	public LandingPage(WebDriver driver) {

		this .driver=driver;
	}

	public WebElement getLogin(){
		return driver.findElement(login);
	}

	public WebElement getTitle(){
		return driver.findElement(title);
	}

	public WebElement getNavigation(){
		return driver.findElement(subjects);
	}
	
	public List<String> selectOptionWithText (String textToSelect){
		
		HelperManager.waitForLoad(driver);
		
		List<String> results = new ArrayList<String>();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// **@! MOVE it to base class
		
		try {
			
			//WebElement autoOptions = driver.findElement(search);
			//explicitWait(autoOptions, driver);
			
//			WebDriverWait wait= new WebDriverWait(driver, 30);
//			WebElement element= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(search)));
//			element.click();
			
			driver.findElement(search).sendKeys(".");
			driver.findElement(search).clear();
			
			//driver.findElement(search).sendKeys(textToSelect);
					
			for(int i=0;i<textToSelect.length();i++ )
			{
				driver.findElement(search).sendKeys(String.valueOf(textToSelect.charAt(i)));
			}
			
			//WebElement wb = driver.findElement(By.xpath("//ul[@role='listbox']/li[1]"));
			
			//WebElement listData = driver.findElement(listOfElements);
					
			//explicitWait(listData, driver);
			
			WebElement listData2 = driver.findElement(listOfElements);
			
			List<WebElement> optionsToSelect = listData2.findElements(By.tagName("li"));
			
			if(optionsToSelect.size()>0)
				optionsToSelect.forEach(x -> results.add(x.getText()));
			
//			for(WebElement option : optionsToSelect){
//				
//				results.add
//		        if(option.getText().equals(textToSelect)) {
//		        	System.out.println("Trying to select: "+textToSelect);
//		            option.click();
//		        	explicitWait(option, driver);
//		            break;
//		        }
//		    }
			
		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		return results;
		
	}

}
