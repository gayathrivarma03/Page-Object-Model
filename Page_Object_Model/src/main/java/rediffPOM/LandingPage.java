package rediffPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class LandingPage extends PageBaseClass {
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[contains(@class,'moneyicon')]")
	public WebElement moneyLink;
	
	public MoneyPage clickMoneyLink() {
		moneyLink.click();
		MoneyPage moneyPage = new MoneyPage(driver);
		PageFactory.initElements(driver, moneyPage);
		return moneyPage;
	}

	public PortFolioLoginPage clickSingIn() {
		// Perform the Click
		PortFolioLoginPage portFolioLoginPage = new PortFolioLoginPage(driver);
		PageFactory.initElements(driver, portFolioLoginPage);
		return portFolioLoginPage;
	}
}
