package com.rediff.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;

	// Objects

	@FindBy(className = "signin")
	private WebElement signinLink;

	@FindBy(linkText = "Create Account")
	private WebElement createAccountLink;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
//		PageFactory.initElements(driver, LandingPage.class);
		// this is also correct, he prefer writing like this
		PageFactory.initElements(driver, this);

	}
	
	//Actions
	public void clickOnSignInLink() {
		signinLink.click();
	}
	
	public void clickOnCreateAccountLink() {
		createAccountLink.click();
		
	}
}
