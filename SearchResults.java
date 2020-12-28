package Google.Google_Search_Results;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

		//Navigate to google website
		driver.get("https://www.google.com/");

		//Enter keyword "software tester" in searchbox
		driver.findElement(By.name("q")).sendKeys("software tester"); 

		//Click on Search button
		driver.findElement(By.name("btnK")).click();

		//Click on Next button of Google Search Result
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click(); 


		//Locating the links via class name 
		List<WebElement> results=driver.findElements(By.className("g"));

		//finding the number of elements with the same class name
		int size = results.size();

		System.out.println(size);

		//click on the 2nd link of second page of google results
		results.get(1).click();


		//Get page title	
		String Actual = driver.getTitle(); 
		String Expected = "Software tester Jobs | Glassdoor.co.nz"; 

		//Verify page title
		if (Actual.equals(Expected)) {        
			System.out.println("Page title matched!");
		} else {
			System.out.println("Page title not matched!");
		}

	}

	@AfterTest
	public void endSession() {
		driver.quit();
		driver.close();  //Close Chrome browser

	}



}
