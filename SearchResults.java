package Google.Google_Search_Results;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SearchResults {
	WebDriver driver;

	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}


	@Test
	private void GoogleSearch () {

		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("software tester");
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Software tester Jobs | Glassdoor.co.nz')]")).click();
		//	Assert.assertEquals("Expected page title", driver.getTitle());

		String Actual = driver.getTitle();
		String Expected = "Software tester Jobs | Glassdoor.co.nz";

		if (Actual.equals(Expected)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}

	}
	@AfterTest
	public void endSession() {
		driver.quit();
		driver.close();

	}
}
