package com.talentscreen.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is Helper class with all generic methods
 **/
public class HelperManager {
	/**
	 * This method makes the driver wait for specified seconds
	 **/
	public static void normalWait(WebDriver driver, long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

	/**
	 * This method makes the driver wait implicitly
	 **/
	public static void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}

	/**
	 * This method makes the driver wait till the webelement is located
	 **/
	public static void explicitWait(WebElement wb, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(wb));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method makes the driver scroll to the specified webelement in
	 * browser
	 **/
	public static boolean scrollTo(WebElement wb, WebDriver driver) {
		try {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);", wb);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return wb.isDisplayed();
	}

	
	/**
	 * This method handles alert windows
	 **/
	public static void handleAlert(String status, WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		if (status.equalsIgnoreCase("Y")) {
			alert.accept();
		} else if (status.equalsIgnoreCase("N")) {
			alert.dismiss();
		}
	}

}
