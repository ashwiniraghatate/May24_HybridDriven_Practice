package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ControlActions {

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	
	public static void start(String url) {
		System.out.println("STEP - Launch Chrome browser and open the url");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get(url);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
}
