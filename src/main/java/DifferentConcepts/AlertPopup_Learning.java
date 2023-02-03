package DifferentConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertPopup_Learning {
	
	WebDriver driver;

	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void testAlertPopup() throws InterruptedException {
		driver.findElement(
				By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/input[2]")).click();

		Thread.sleep(3000);
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

		System.out.println(alertText);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}


}
