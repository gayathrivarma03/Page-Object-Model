package page_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_Classes.PageBaseClass;

public class WriteMailPage extends PageBaseClass{
	
	WriteMailPage writeMailPage;

	public WriteMailPage(WebDriver driver, ExtentTest logger){
		super(driver, logger);
	}
	
	@FindBy(xpath = "//b[contains(text(),'Write mail')]")
	public WebElement WriteMailLink;
	
	@FindBy(xpath = "//*[@id=\"TO_IDcmp2\"]")
	public WebElement EnterName;
	
	@FindBy(xpath = "//*[@id=\"rd_compose_cmp2\"]/ul/li[4]/input")
	public WebElement EnterSubject;
	
	@FindBy(xpath = "//*[@id=\"rd_compose_cmp2\"]/div[1]/a[1]")
	public WebElement SendButton;
	
	public WriteMailPage writeMail(String name, String subject) {
		
		logger.log(Status.INFO, "Clicking Write Mail Button");
		WriteMailLink.click();
		//waitForPageLoad();
		logger.log(Status.PASS, "Write Mail Button Clicked");
		
		logger.log(Status.INFO, "Entering Recepient's Email");
		EnterName.sendKeys(name);
		logger.log(Status.PASS, "Recepient's Email Entered");
		
		logger.log(Status.INFO, "Entering Subject");
		EnterSubject.sendKeys(subject);
		logger.log(Status.PASS, "Subject Entered");
		
		logger.log(Status.INFO, "Clicking Send Button");
		SendButton.click();
		//waitForPageLoad();
		logger.log(Status.PASS, "Send Button Clicked");
		
		logger.log(Status.PASS, "Email Sent Successfully!");
		
		return writeMailPage;
	}
}
