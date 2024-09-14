package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.ControlActions;

public class LoginPage extends ControlActions{

	private String loginLocator = "//button[text()='Login']";
	private String emailLocator = "//input[@placeholder='Enter email']";
	private String passwordLocator = "//input[@placeholder='Enter password']";
	
	public boolean isLoginBtnDisplayed() {
		WebElement loginBtnLocator = driver.findElement(By.xpath(loginLocator));
		return loginBtnLocator.isDisplayed();
	}
	
	public boolean isEmailIdFeildEnabled() {
		WebElement emailFieldLocator = driver.findElement(By.xpath(emailLocator));
		return emailFieldLocator.isEnabled();
	}
	
	public boolean isPasswordFeildEnabled() {
		WebElement passwordFieldLocator = driver.findElement(By.xpath(passwordLocator));
		return passwordFieldLocator.isEnabled();
	}
	
	public void enterEmail(String emailId) {
		WebElement loginBtnEle = driver.findElement(By.xpath(loginLocator));
		loginBtnEle.sendKeys(emailId);
	}
	
	public void enterPassword(String password) {
		WebElement passwordFieldLocator = driver.findElement(By.xpath(emailLocator));
		passwordFieldLocator.sendKeys(password);
	}
	
	public void login(String emailId, String password) {
		enterEmail(emailId);
		enterPassword(password);
		clickOnLoginButton();
	}
	
	public void clickOnLoginButton() {
		WebElement loginBtnLocator = driver.findElement(By.xpath(loginLocator));
		loginBtnLocator.click();
	}
	
	public String getPopUpMessage() {
		WebElement popUpmessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Toastify__toast-container')]")));
		String actualPopUpMessage = popUpmessageElement.getText();
		return actualPopUpMessage;
		
	}
}
