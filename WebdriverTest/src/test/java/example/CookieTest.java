package example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CookieTest {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "WebDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
	}
	
	@Test
	public void logIn() throws IOException {
		driver.findElement(By.name("username")).sendKeys("mngr143004");
		driver.findElement(By.name("password")).sendKeys("UrEvYvu");
		driver.findElement(By.name("submit")).click();
		File f = new File("D:\\Torex Retail\\personal\\JavaTranining\\Cookies.data");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for (Cookie ck:driver.manage().getCookies()) {
			bw.write(ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure());
			bw.newLine();
			bw.flush();
		}
		bw.close();
		fw.close();
	}
}
