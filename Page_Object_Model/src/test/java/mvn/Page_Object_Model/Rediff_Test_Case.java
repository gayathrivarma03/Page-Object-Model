package mvn.Page_Object_Model;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class Rediff_Test_Case {
	
	Signin_Page signinpage;
	
	@Test
	public void testCase() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Pragati\\eclipse\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver=new ChromeDriver();
		driver.get("https://money.rediff.com");
		
		Landing_page landingpage = new Landing_page(driver);
		
		PageFactory.initElements(driver, landingpage);
		
		signinpage = landingpage.clickSignin();
		
		Thread.sleep(5000);
		driver.close();
		
		System.out.println("End of code");
		
	}

}
