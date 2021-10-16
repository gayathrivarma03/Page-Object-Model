package mvn.Page_Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Signin_Unable_page {
	
	WebDriver localdriver;


	public Signin_Unable_page(WebDriver driver)
	{
		this.localdriver = driver;
		
	}
	
	@FindBy(linkText="Terms")
	public WebElement linkTerms;
	

	
	public void clickTerms() {
		linkTerms.click();
	}
	
}
