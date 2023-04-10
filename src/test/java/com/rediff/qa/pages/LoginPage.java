package com.rediff.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	// Objects
	@FindBy(id = "login1")
	private WebElement usernameTextBox;
	
	@FindBy(id = "password")
	private WebElement passwordTextBox;
	
	@FindBy(className = "signinbtn")
	private WebElement signinButton;
	
	@FindBy(id = "div_login_error")
	private WebElement temporaryIssueMessageLocator;
	

	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	// Actions

	public void enterUsername(String usernameText) {
		usernameTextBox.sendKeys(usernameText);
	}
	
	public void enterPassword(String passwordTest) {
		passwordTextBox.sendKeys(passwordTest);
	}
	
	public void clickOnsigninButton() {
		signinButton.click();
	}
	
	public String retrieveTemporaryErrorMessageText() {
		String tempErrorMessage = temporaryIssueMessageLocator.getText();
		return tempErrorMessage;
	}

}
