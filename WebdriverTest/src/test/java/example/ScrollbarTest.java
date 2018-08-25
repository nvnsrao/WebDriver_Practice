package example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollbarTest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "WebDriver/chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.computerhope.com/jargon/s/scrollba.htm");
		WebElement element = driver.findElement(By.xpath("//*[@class='facebook']"));

		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-5000)");
		Thread.sleep(1000);

		js.executeScript("arguments[0].scrollIntoView()", element);
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].click()", element);
		js.executeScript("window.location='https://www.google.com/gmail/about/#'");
		//js.executeScript("document.getElementById(\"name\").value='narasimha'");
	}

}
