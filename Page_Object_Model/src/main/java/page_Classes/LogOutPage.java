package page_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_Classes.PageBaseClass;
import base_Classes.TopMenuClass;
import rediffPOM.PortFolioLoginPage;

public class LogOutPage extends PageBaseClass {

	public TopMenuClass topmenu;

	public LogOutPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		topmenu = new TopMenuClass(driver, logger);
		PageFactory.initElements(driver, topmenu);
	}

	@FindBy(xpath = "//*[@id='wrapper']/div[4]/a")
	public WebElement loginAgainLink;

	public PortFolioLoginPage clickLoginAgain() {
		logger.log(Status.INFO, "Clicking the Login-Again Link");
		loginAgainLink.click();
		logger.log(Status.PASS, "Clicked the Login-Again Link Link");
		PortfolioLoginPage portfolioLoginPage = new PortfolioLoginPage(driver, logger);
		PageFactory.initElements(driver, portfolioLoginPage);
		return portfolioLoginPage;
	}

}
