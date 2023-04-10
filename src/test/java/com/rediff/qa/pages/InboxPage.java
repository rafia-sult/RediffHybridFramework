package com.rediff.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage {
	
	public WebDriver driver;
	
	@FindBy(className = "rd_logout")
	private WebElement logoutLink;
	
	
	
	
	public InboxPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean logoutLinkisDisplayedOrNot() {
		boolean displayStatus = logoutLink.isDisplayed();
		return displayStatus;
	}

}
