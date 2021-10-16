package mvn.Page_Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landing_page {
	
	Portfolio_Page portfoliopage;
	
	WebDriver localdriver;
	Signin_Page signinpage = new Signin_Page(localdriver);

	public Landing_page(WebDriver driver)
	{
		this.localdriver = driver;
	}
		
	@FindBy(xpath="//*[@id=\'signin_info\']/a[1]")
	public WebElement signinBtn;
	
	public Signin_Page clickSignin() throws InterruptedException {
		
		signinBtn.click();
		
		Signin_Page signinpage = new Signin_Page(localdriver);
		PageFactory.initElements(localdriver, signinpage);
		
		signinpage.enteremailid("pragatipatil3016@rediffmail.com");
		signinpage.enterpassword("Prag@3016");
		portfoliopage = signinpage.clickSubmit();
		
		return signinpage;
	}
}
