package example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadCookieData {
	WebDriver driver;
	File f;
	FileReader fr;
	BufferedReader br;
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "WebDriver/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	@Test
	public void readCookieData() throws IOException, ParseException {
		f = new File("D:\\Torex Retail\\personal\\JavaTranining\\Cookies.data");
		fr = new FileReader (f);
		br = new BufferedReader(fr);
		String strline;
		while((strline=br.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(strline,";");
			while(st.hasMoreTokens()) {
				String name = st.nextToken();
				System.out.println(name);
				String value = st.nextToken();
				System.out.println(value);
				String domain = st.nextToken();
				System.out.println(domain);
				String path = st.nextToken();
				System.out.println(path);
				Date expiry=null;
				String val;
				if (!(val=st.nextToken()).equals("null")) {
					System.out.println(val);
					//System.out.println(val.toString());
					  String sDate5 = "Thu, Dec 31 1998 23:37:50";  

				    SimpleDateFormat formatter5=new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");  
				  expiry=formatter5.parse(sDate5);  


					//expiry = new Date(sDate5);
					//System.out.println(expiry);
				}
				System.out.println(expiry);
				
				Boolean isSecure=new Boolean(st.nextToken());
				System.out.println(isSecure);

				//booleanValue();
				Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
				System.out.println(ck);
				driver.manage().addCookie(ck);
			}
		}
		driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
	}
	

}
