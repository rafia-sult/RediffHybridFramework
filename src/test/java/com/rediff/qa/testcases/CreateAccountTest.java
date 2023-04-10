package com.rediff.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.qa.pages.CreateAccountPage;
import com.rediff.qa.pages.LandingPage;
import com.rediff.qa.testbase.TestBase;
import com.rediff.qa.utils.Utilities;

public class CreateAccountTest extends TestBase {

	public CreateAccountTest() throws Exception {
		super();
	}

	public static ChromeOptions options;
	public static WebDriver driver;
	public static SoftAssert softassert = new SoftAssert();
	public static Select select;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication("chrome");
		LandingPage landingpage = new LandingPage(driver);
		landingpage.clickOnCreateAccountLink();
//		driver.findElement(By.linkText("Create Account")).click();

	}

	@Test(priority = 1)
	public void varifyCreateAccountByEnteringAllValidFields() {
		CreateAccountPage createaccountpage = new CreateAccountPage(driver);
		createaccountpage.enterFullName(dataprop.getProperty("fullName"));
//		driver.findElement(By.xpath("//input[starts-with(@name, 'name')]")).sendKeys(dataprop.getProperty("fullName"));
	
		createaccountpage.enterRediffmailID(Utilities.generateNameforEmailWithTimeStamp());
//		driver.findElement(By.xpath("//input[starts-with(@name, 'login')]")).sendKeys(Utilities.generateNameforEmailWithTimeStamp());

		createaccountpage.clickOnCheckAvailabilityButton();
//		driver.findElement(By.className("btn_checkavail")).click();
		
//		String actualAvailableMessage = createaccountpage.retrieveEmailAvailabilityText();
//		String actualAvailableMessage = driver.findElement(By.id("check_availability")).getText();		
//		String expectedAvailableMessage = dataprop.getProperty("successAvailabilityIdMessage");
//		softassert.assertTrue(actualAvailableMessage.contains(expectedAvailableMessage));
		
		createaccountpage.enterCreateAccountPassword(dataprop.getProperty("createPassword"));
//		driver.findElement(By.id("newpasswd")).sendKeys(dataprop.getProperty("createPassword"));
		
		createaccountpage.enterCreateAccountRetypePassword(dataprop.getProperty("retypePassword"));
//		driver.findElement(By.id("newpasswd1")).sendKeys(dataprop.getProperty("retypePassword"));
		
		createaccountpage.enterAlternateEmailId(prop.getProperty("validUsername"));
//		driver.findElement(By.xpath("//input[starts-with(@name, 'altemail')]")).sendKeys(prop.getProperty("validUsername"));
		
		createaccountpage.enterMobileNo(dataprop.getProperty("mobileNo"));
//		driver.findElement(By.id("mobno")).sendKeys(dataprop.getProperty("mobilNo"));

		select = new Select(driver.findElement(By.xpath("//select[starts-with(@name, 'DOB_Day')]")));
		select.selectByVisibleText(dataprop.getProperty("dayDOB"));

		select = new Select(driver.findElement(By.xpath("//select[starts-with(@name, 'DOB_Month')]")));
		select.selectByVisibleText(dataprop.getProperty("monthDOB"));

		select = new Select(driver.findElement(By.xpath("//select[starts-with(@name, 'DOB_Year')]")));
		select.selectByVisibleText(dataprop.getProperty("yearDOB"));

		createaccountpage.clickOnGenderButton();
//		driver.findElement(By.xpath("//input[starts-with(@name, 'gender')][@value = 'm']")).click();

		select = new Select(driver.findElement(By.id("country")));
		select.selectByVisibleText(dataprop.getProperty("country"));

		driver.findElement(By.className("captcha")).sendKeys("ABCD");

		createaccountpage.clickOnCreateMyAccountButton();
//		driver.findElement(By.id("Register")).click();

		String actualFailureMessageCreateAccount = driver.findElement(By.className("errbody")).getText();
		String expectedFailureMessageCreateAccount = dataprop.getProperty("failedRegistrationMessage");
		softassert.assertEquals(actualFailureMessageCreateAccount, expectedFailureMessageCreateAccount);
		softassert.assertAll();

	}

	@Test(priority = 2)
	public void verifyCreateAccountBySkippingAllValidFields() {
		CreateAccountPage createaccountpage = new CreateAccountPage(driver);

		createaccountpage.clickOnCreateMyAccountButton();
//		driver.findElement(By.id("Register")).click();
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = dataprop.getProperty("createAlertWithoutAnyField");
		softassert.assertEquals(actualAlertText, expectedAlertText);
		if (actualAlertText.equals(expectedAlertText)) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		softassert.assertAll();

	}

	@Test(priority = 3)
	public void verifyCreateAccountByEnteringFullNameAndOtherFieldsBlank() {
		CreateAccountPage createaccountpage = new CreateAccountPage(driver);

		createaccountpage.enterFullName(dataprop.getProperty("fullName"));
//		driver.findElement(By.xpath("//input[starts-with(@name, 'name')]")).sendKeys(dataprop.getProperty("fullName"));

		createaccountpage.clickOnCreateMyAccountButton();
//		driver.findElement(By.id("Register")).click();

		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = dataprop.getProperty("createAlertWithoutEnteringRediffmailID");
		softassert.assertEquals(actualAlertText, expectedAlertText);
		if (actualAlertText.equals(expectedAlertText)) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		softassert.assertAll();

	}

	@Test(priority = 4)
	public void verifyCreateAccountByEnteringFullNameAndRediffmailIDButOtherFieldsBlank() {
		CreateAccountPage createaccountpage = new CreateAccountPage(driver);

		createaccountpage.enterFullName(dataprop.getProperty("fullName"));
//		driver.findElement(By.xpath("//input[starts-with(@name, 'name')]")).sendKeys(dataprop.getProperty("fullName"));

		createaccountpage.enterRediffmailID(Utilities.generateNameforEmailWithTimeStamp());
//		driver.findElement(By.xpath("//input[starts-with(@name, 'login')]")).sendKeys(Utilities.generateNameforEmailWithTimeStamp());

		createaccountpage.clickOnCreateMyAccountButton();
//		driver.findElement(By.id("Register")).click();

		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = dataprop.getProperty("createAlertWithoutEnteringPassword");
		softassert.assertEquals(actualAlertText, expectedAlertText);
		if (actualAlertText.equals(expectedAlertText)) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		softassert.assertAll();

	}

	@Test(priority = 5)
	public void verifyCreateAccountByEnteringUptoPassword() {
		CreateAccountPage createaccountpage = new CreateAccountPage(driver);

		createaccountpage.enterFullName(dataprop.getProperty("fullName"));
//		driver.findElement(By.xpath("//input[starts-with(@name, 'name')]")).sendKeys(dataprop.getProperty("fullName"));

		createaccountpage.enterRediffmailID(Utilities.generateNameforEmailWithTimeStamp());
//		driver.findElement(By.xpath("//input[starts-with(@name, 'login')]")).sendKeys(Utilities.generateNameforEmailWithTimeStamp());

		createaccountpage.enterCreateAccountPassword(dataprop.getProperty("createPassword"));
//		driver.findElement(By.id("newpasswd")).sendKeys(dataprop.getProperty("createPassword"));

		createaccountpage.clickOnCreateMyAccountButton();
//		driver.findElement(By.id("Register")).click();

		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = dataprop.getProperty("createAlertWithoutEnteringRetypePassword");
		softassert.assertEquals(actualAlertText, expectedAlertText);
		if (actualAlertText.equals(expectedAlertText)) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		softassert.assertAll();
	}

	@Test(priority = 6)
	public void verifyCreateAccountByEnteringUptoRetypePassword() {
		CreateAccountPage createaccountpage = new CreateAccountPage(driver);

		createaccountpage.enterFullName(dataprop.getProperty("fullName"));
//		driver.findElement(By.xpath("//input[starts-with(@name, 'name')]")).sendKeys(dataprop.getProperty("fullName"));

		createaccountpage.enterRediffmailID(Utilities.generateNameforEmailWithTimeStamp());
//		driver.findElement(By.xpath("//input[starts-with(@name, 'login')]")).sendKeys(Utilities.generateNameforEmailWithTimeStamp());

		createaccountpage.enterCreateAccountPassword(dataprop.getProperty("createPassword"));
//		driver.findElement(By.id("newpasswd")).sendKeys(dataprop.getProperty("createPassword"));

		createaccountpage.enterCreateAccountRetypePassword(dataprop.getProperty("retypePassword"));
//		driver.findElement(By.id("newpasswd1")).sendKeys(dataprop.getProperty("retypePassword"));

		createaccountpage.clickOnCreateMyAccountButton();
//		driver.findElement(By.id("Register")).click();

		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = dataprop.getProperty("createAlertWithoutEnteringAlternateEmail");
		softassert.assertEquals(actualAlertText, expectedAlertText);
		if (actualAlertText.equals(expectedAlertText)) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		softassert.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
