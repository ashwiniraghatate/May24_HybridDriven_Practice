package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ControlActions;

public class DashboardPage extends ControlActions{

	public boolean isDashboardPageDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement inviteUsed = driver.findElement(By.xpath("//span[text()='Invites Used']"));
		return inviteUsed.isDisplayed();
	}
}
