package rediffPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;



public class PortFolioLoginPage extends PageBaseClass {
	
	public PortFolioLoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "useremail")
	public WebElement useremail_TextBox;

	@FindBy(id = "emailsubmit")
	public WebElement emailSubmit_button;

	@FindBy(id = "userpass")
	public WebElement password_TextBox;

	@FindBy(id = "loginsubmit")
	public WebElement submitLogin_button;

	public MyPorfolioPage doLogin(String userName, String password) {
		
		useremail_TextBox.sendKeys(userName);
		//Commented below link, since its not required now
		//emailSubmit_button.click();
		waitForPageLoad();
		password_TextBox.sendKeys(password);
		System.out.println("Entered password");
		submitLogin_button.click();
		waitForPageLoad();
		

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currentPageTitle = driver.getTitle();
		if (currentPageTitle.equals("Indian stock markets: Login to Portfolio")){
			reportFail("Login is failed on Portfolio Login Page");
			Assert.fail("Login Failed");
		}
		MyPorfolioPage myportFolioPage = new MyPorfolioPage(driver);
		PageFactory.initElements(driver, myportFolioPage);
		return myportFolioPage;
	}
	
	public void enterUser(String userName){
		useremail_TextBox.sendKeys(userName);
		
	}
	
	public void submitUserName(){
		emailSubmit_button.click();
	}
	
	public void enterPassword(String password){
		password_TextBox.sendKeys(password);
	}
	
	public MyPorfolioPage submitLogin(){
		submitLogin_button.click();
		MyPorfolioPage myportFolioPage = new MyPorfolioPage(driver);
		PageFactory.initElements(driver, myportFolioPage);
		return myportFolioPage;
	}
	
	public void verifyPasswordField(){
		veriyElementIsDisplayed(password_TextBox);
	}

}
