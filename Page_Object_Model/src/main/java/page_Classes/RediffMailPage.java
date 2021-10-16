package page_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_Classes.PageBaseClass;

public class RediffMailPage extends PageBaseClass{
	
	WriteMailPage writeMailPage;
	RediffMailPage rediffMailPage;
	
	public RediffMailPage(WebDriver driver, ExtentTest logger){
		super(driver, logger);
	}
	
	@FindBy(xpath = "//*[@id=\"login1\"]")
	public WebElement usernameField;
	
	@FindBy(xpath = "//*[@id=\"password\"]")
	public WebElement passwordField;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]")
	public WebElement signin;
	
	public WriteMailPage doSignIn(String userName, String password) {
		
		logger.log(Status.INFO, "Entering Username");
		usernameField.sendKeys(userName);
		logger.log(Status.PASS, "Username Entered");
		
		logger.log(Status.INFO, "Entering Password");
		passwordField.sendKeys(password);
		logger.log(Status.PASS, "Password Entered");
		
		logger.log(Status.INFO, "Clicking the Sign In Button");
		signin.click();
		//waitForPageLoad();
		logger.log(Status.PASS, "Clicked the Sign In Button");

		logger.log(Status.PASS, "Signed In Sucessfully!");

		WriteMailPage writeMailPage = new WriteMailPage(driver, logger);
		PageFactory.initElements(driver, writeMailPage);
		
		return writeMailPage;
	}
}
