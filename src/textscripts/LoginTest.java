/*"STEP 1 - Launch Chrome browser
STEP 2 - Hit https://staging.dev.theeliteqa.com URL
VERFIY - Login page is visible [Login button is displayed, useremail is enabled, password is enabled]
STEP 3 - Enter valid username
STEP 4 - Enter valid password
STEP 5 - Click on Login button
VERIFY - Dashboard page is displayed"
*/package textscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ControlActions;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest {
	
	@BeforeClass
	public void launchBrowser() {
		ControlActions.start("https://staging.dev.theeliteqa.com");
	}
	
	@Test
	public void testLoginFunctionality() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage();
		
		System.out.println("VERFIY - Login page is visible [Login button is displayed, useremail is enabled, password is enabled]");
		
		System.out.println("Verify - Login button is displayed");
		boolean loginBtnFlag = loginPage.isLoginBtnDisplayed();
		softAssert.assertTrue(loginBtnFlag, "login field was not displayed");
		
		System.out.println("Verify - useremail is enabled");
		boolean emailFieldFlag = loginPage.isEmailIdFeildEnabled();
		softAssert.assertTrue(emailFieldFlag, "email field was not displayed");

		System.out.println("Verify - password is enabled");
		boolean passwordFieldFlag = loginPage.isPasswordFeildEnabled();
		softAssert.assertTrue(passwordFieldFlag, "password field was not displayed");

		System.out.println("STEP 3 - Enter valid username");
		loginPage.enterEmail("ashwinimay24@gmail.com");
		
		System.out.println("STEP 4 - Enter valid password");
		loginPage.enterPassword("May@123");
		
		System.out.println("STEP 5 - Click on Login button");
		loginPage.clickOnLoginButton();
		
		System.out.println("VERIFY - Dashboard page is displayed");
		DashboardPage dashboardElement = new DashboardPage();
		boolean dashboardMenuFlag = dashboardElement.isDashboardPageDisplayed();
		Assert.assertTrue(dashboardMenuFlag, "Dashboard menu was not displayed");
	}
	
	@Test
	public void verifyInvalidAuthantication() {
		LoginPage loginPage = new LoginPage();
		
		System.out.println("STEP 3 - Enter valid username");
		loginPage.enterEmail("ashwinimay24@gmail.com");
		
		System.out.println("STEP 4 - Enter invalid password");
		loginPage.enterPassword("May@1234");
		
		System.out.println("STEP 5 - Click on Login button");
		loginPage.clickOnLoginButton();
		
		System.out.println("VERIFY - Popup with the error message \"Authentication failed, please check your username and password.\" "
				+ "should be displayed");
		String actualPopUpMsg = loginPage.getPopUpMessage();
		String expectedPopUpMsg = "Authentication failed, please check your username and password.";
		Assert.assertEquals(actualPopUpMsg, expectedPopUpMsg);
		
		System.out.println("VERIFY - Login page is still visible.");
		boolean loginBtnFlag = loginPage.isLoginBtnDisplayed();
		Assert.assertTrue(loginBtnFlag, "Login button was not displayed");
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("CLEAN UP - close all browsers");
		ControlActions.quitBrowser();
	}

}
