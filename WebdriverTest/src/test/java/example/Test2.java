package example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

public class Test2 {
  @Test(enabled=false)
  public void method1() {
	  System.out.println("i am in Test2 Method1");
	  //comments
  }
  
  @Test(enabled=true)
  public void getCurrentTimeinMillis() {
	 System.out.println(System.currentTimeMillis()%1000);
	 System.out.println(System.currentTimeMillis());

  }
  
  @Test(enabled=true)
  public void getCurrentTestCaseName() {
	 System.out.println(this);
  }
  
  @Test
  public void getCurrentTimeStamp() {
	  Date cal = Calendar.getInstance().getTime();
	  SimpleDateFormat sd = new SimpleDateFormat("HH_mm_ss_ddMMYYYY");
	  String text = sd.format(cal);
	  System.out.println(text);
  }
  
  @Test(enabled=false)
  public void getLengthofArray() {
	  Object[][] ob;
	  ob= new Object[2][3];
	  ob[0][0]=1;
	  ob[0][1]=2;
	  ob[0][2]=3;
	  
	  System.out.println(ob.length);
	  System.out.println(ob[0].length);
  }
}
