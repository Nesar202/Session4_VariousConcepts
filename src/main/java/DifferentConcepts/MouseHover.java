package DifferentConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseHover {
	
	WebDriver driver;

	@BeforeTest
	public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.dell.com/en-us");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test
	public void testMouseHover() {
		
		WebElement ProductElement = driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
		WebElement MonitorsElement = driver.findElement(By.xpath("//button[text()='Monitors']"));
		WebElement AllMonitorsElement = driver.findElement(By.xpath("//a[text()='View All Monitors']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(ProductElement).build().perform();
		action.moveToElement(MonitorsElement).build().perform();
		AllMonitorsElement.click();
		
	}


}
