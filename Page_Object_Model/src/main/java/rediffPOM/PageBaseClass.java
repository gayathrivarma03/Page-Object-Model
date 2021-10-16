package rediffPOM;

import java.util.List;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;


public class PageBaseClass extends BaseTestClass {

	public PageBaseClass(WebDriver driver) {
		this.driver = driver;
	}

	/****************** OpenApplication ***********************/
	public LandingPage OpenApplication() {
		driver.get("https://www.rediff.com/");
		LandingPage landingPage = new LandingPage(driver);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}
	
	/****************** Get Page Title ***********************/
	public void getTitle(String expectedTitle) {
		try {
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			reportPass("Actual Title : " + driver.getTitle() + " - equals to Expected Title : " + expectedTitle);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}
	
	
	/****************** Accept Java Script Alert ***********************/
	public void acceptAlert(){
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	
	/****************** Cancel Java Script Alert ***********************/
	public void cancelAlert(){
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();;
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	
	/****************** Select value From DropDown ***********************/
	public void selectDropDownValue(WebElement webElement, String value){
		try {
			Select select = new Select(webElement);
			select.selectByVisibleText(value);
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	
	/****************** Verify Element is Present ***********************/
	public void veriyElementIsDisplayed(WebElement webElement){
		try {
			if(webElement.isDisplayed()){
				reportPass("Web Element is Displayed");
			}else {
				reportFail("Web Element is not displayed");
			}
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	
	/****************** Get All Elements of DropDown ***********************/
	public List<WebElement> getAllElementsOfDropDown(WebElement webElement){
		try {
			Select select = new Select(webElement);
			List<WebElement> allElements = select.getOptions();
			return allElements;
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		 return null;
	}
	

	/****************** Reporting Functions ***********************/
	public void reportFail(String reportString) {
		//takeScreenShotOnFailure();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
	}

	/****************** Capture Screen Shot ***********************/

}
