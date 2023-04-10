package com.rediff.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
	public WebDriver driver;

	// Objects
	@FindBy(xpath = "//input[starts-with(@name, 'name')]")
	private WebElement fullNameTextBox;
	
	@FindBy(xpath = "//input[starts-with(@name, 'login')]")
	private WebElement rediffMailIDTextBox;
	
	@FindBy(className = "btn_checkavail")
	private WebElement checkAvailabilityButton;
	
	@FindBy(id = "check_availability")
	private WebElement emailAvaialbilityLocator;

	@FindBy(id = "newpasswd")
	private WebElement createAccountPasswordTextBox;

	@FindBy(id = "newpasswd1")
	private WebElement createAccountRetypePasswordTextBox;

	@FindBy(xpath = "//input[starts-with(@name, 'altemail')]")
	private WebElement alternateEmailIdTextBox;

	@FindBy(id = "mobno")
	private WebElement createAccountMobileNumberBox;
	
	@FindBy(xpath = "//input[starts-with(@name, 'gender')][@value = 'm']")
	private WebElement genderButton;
	
	@FindBy(id = "Register")
	private WebElement createMyAccountButton;
	
	@FindBy(className = "errbody")
	private WebElement failedRegistrationErrorMessageLocator;

	

	// Initialization
	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	//Action
	public void enterFullName(String fullNameText) {
		fullNameTextBox.sendKeys(fullNameText);
	}
	
	public void enterRediffmailID(String rediffmailIdText) {
		rediffMailIDTextBox.sendKeys(rediffmailIdText);
	}
	
	public void clickOnCheckAvailabilityButton() {
		checkAvailabilityButton.click();
	}
	
	public String retrieveEmailAvailabilityText() {
		String emailAvailableMessage = emailAvaialbilityLocator.getText();
		return emailAvailableMessage;
	}
	
	public void enterCreateAccountPassword(String createAccountPasswordText) {
		createAccountPasswordTextBox.sendKeys(createAccountPasswordText);
	}

	public void enterCreateAccountRetypePassword(String createAccountRetypePasswordText) {
		createAccountRetypePasswordTextBox.sendKeys(createAccountRetypePasswordText);
	}

	public void enterAlternateEmailId(String alternateEmailIDText) {
		alternateEmailIdTextBox.sendKeys(alternateEmailIDText);
	}

	public void enterMobileNo(String mobileNoText) {
		createAccountMobileNumberBox.sendKeys(mobileNoText);
	}
	
	public void clickOnGenderButton() {
		genderButton.click();
	}
	
	public void clickOnCreateMyAccountButton() {
		createMyAccountButton.click();
	}
	
	public String retrieveFailedRegistrationText() {
		String failedRegistrationMessage = failedRegistrationErrorMessageLocator.getText();
		return failedRegistrationMessage;
	}
	

}
