package page_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_Classes.PageBaseClass;
import rediffPOM.PortFolioLoginPage;

public class LandingPage extends PageBaseClass {
	
	WriteMailPage writeMailPage;

	public LandingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(xpath = "//*[contains(@class,'moneyicon')]")
	public WebElement moneyLink;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/a[1]")
	public WebElement rediffMailLink;

	public RediffMailPage clickRediffMailLink() {
		
		logger.log(Status.INFO, "Clicking the RediffMail Link, Present in Header");
		rediffMailLink.click();
		//waitForPageLoad();
		logger.log(Status.PASS, "Clicked the RediffMail Link");
		
		RediffMailPage rediffMailPage = new RediffMailPage(driver, logger);
		PageFactory.initElements(driver, rediffMailPage);
		
		return rediffMailPage;
	}
	
	public MoneyPage clickMoneyLink() {
		
		logger.log(Status.INFO, "Clicking the Money Link, Present in Header");
		moneyLink.click();
		logger.log(Status.PASS, "Clicked the Money Link");
		MoneyPage moneyPage = new MoneyPage(driver, logger);
		PageFactory.initElements(driver, moneyPage);
		return moneyPage;
	}

	public PortFolioLoginPage clickSingIn() {
		
		// Perform the Click
		PortfolioLoginPage portfolioLoginPage = new PortfolioLoginPage(driver, logger);
		PageFactory.initElements(driver, portfolioLoginPage);
		return portfolioLoginPage;
	}
}
