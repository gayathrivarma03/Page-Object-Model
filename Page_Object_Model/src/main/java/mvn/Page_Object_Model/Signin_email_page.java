package mvn.Page_Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signin_email_page {
	WebDriver localdriver;
	public Signin_email_page(WebDriver driver)
	{
		this.localdriver = driver;
	}

	@FindBy(xpath="//*[@id='identifierId']")
	public WebElement email;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	public WebElement nextbtn;
	
	
	public void enteremailid( String emailid) {
		email.sendKeys(emailid);
	}
	
	
	
	public Signin_Unable_page clickNext() {
		nextbtn.click();
		
		//Signin_pwd_page signinpwd = new Signin_pwd_page(localdriver);
		Signin_Unable_page signinunable = new Signin_Unable_page(localdriver);
		PageFactory.initElements(localdriver, signinunable);
		return signinunable;
	}


}
