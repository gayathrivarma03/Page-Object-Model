package mvn.Page_Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signin_Page {
		
	WebDriver localdriver;
	
	public Signin_Page(WebDriver driver)
	{
		this.localdriver = driver;
	}

	@FindBy(xpath="//*[@id=\'useremail\']")
	public WebElement emailField;
	
	@FindBy(xpath="//*[@id=\'userpass\']")
	public WebElement passwordField;
	
	@FindBy(xpath="//*[@id=\'loginsubmit\']")
	public WebElement submitBtn;
	
	public void enteremailid(String emailid) {
		emailField.sendKeys(emailid);
	}
	
	public void enterpassword(String password) {
		passwordField.sendKeys(password);
	}

	public Portfolio_Page clickSubmit() throws InterruptedException {

		submitBtn.click();

		Portfolio_Page portfoliopage = new Portfolio_Page(localdriver);
		PageFactory.initElements(localdriver, portfoliopage);
		
		Thread.sleep(5000);
		
		portfoliopage.clickButton();

		return portfoliopage;
	}

}
