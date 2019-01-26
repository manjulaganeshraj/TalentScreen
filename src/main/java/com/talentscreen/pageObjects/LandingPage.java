package com.talentscreen.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	WebDriver driver;

	By login = By.cssSelector("a[href*='login']");
	By title = By.cssSelector(".shell-input>h2");
	By subjects = By.cssSelector("#main-nav > ul > li:nth-child(1) > a");

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

}
