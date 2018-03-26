package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
	
  @Test
  public void f() {
	  
	  driver.get("http://demo.guru99.com/test/guru99home/");  
		String title = driver.getTitle();	;
		System.out.println();
		Assert.assertTrue(title.contains("Demo Guru99 Page")); 
  }
  
  @BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "WebDriver/chromedriver.exe");
		driver= new ChromeDriver();
		//driver.get("http://demo.guru99.com/v4/index.php");
	}
  
  @AfterClass
  public void close() {
 	 driver.close();
  }
  
  
}
