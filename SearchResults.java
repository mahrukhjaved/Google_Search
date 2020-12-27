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

		
		driver.get("https://www.google.com/"); //Navigate to google website
		driver.findElement(By.name("q")).sendKeys("software tester"); //Enter keyword "software tester" in searchbox
		driver.findElement(By.name("btnK")).click(); //Click on Search button
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click(); //Click on Next button of Google Search Result
		driver.findElement(By.xpath("//span[contains(text(),'Software tester Jobs | Glassdoor.co.nz')]")).click(); //Click of 2nd link of 2nd page of Google Search Result 
	

		String Actual = driver.getTitle();  //Get page title
		String Expected = "Software tester Jobs | Glassdoor.co.nz"; 

		if (Actual.equals(Expected)) {         //Verify page title
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}

	}
	@AfterTest
	public void endSession() {
		driver.quit();
		driver.close();  //Close chrome browser

	}
}
