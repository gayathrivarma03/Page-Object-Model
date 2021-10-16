package Test_Cases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page_Classes.LandingPage;
import page_Classes.MoneyPage;
import page_Classes.MyPorfolioPage;
import page_Classes.MyPortfolioPage;
import page_Classes.PortFolioLoginPage;
import page_Classes.PortfolioLoginPage;
import base_Classes.BaseTestClass;
import base_Classes.PageBaseClass;
import uti_lities.ConstantValue;
import uti_lities.TestDataProvider;

public class MyStockTest extends BaseTestClass{
	LandingPage landingPage;
	MoneyPage moneyPage;
	PortfolioLoginPage portfolioLoginPage;
	MyPortfolioPage myporfolioPage;
	
	
	@Test(dataProvider="AddStockTestData")
	public void AddStockTest(Hashtable<String, String> testData){
		logger = report.createTest("Add Stock in: " + testData.get("PortfolioName") + " - Stock Name" + testData.get("StockName"));
		
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		moneyPage =landingPage.clickMoneyLink();
		portfolioLoginPage = moneyPage.clickSingInLink();
		myporfolioPage = portfolioLoginPage.doLogin(ConstantValue.userName, ConstantValue.password);
		myporfolioPage.verifyMoneyBiz();
		myporfolioPage.clickCreatePortfolio();
		waitForPageLoad();
		myporfolioPage.enterPortfolioName(testData.get("PortfolioName"));
		myporfolioPage = myporfolioPage.submitPortfolio();
		waitForPageLoad();
		myporfolioPage.isPorfolioExists(testData.get("PortfolioName"));
		myporfolioPage.clickAddStock();
		myporfolioPage.enterStockName(testData.get("StockName"));
		myporfolioPage.clickStockPurchaseCalendar();
		selectDateIncalendar("14/10/2017");
		myporfolioPage.enterStockQuantity(testData.get("Quantity"));
		myporfolioPage.enterStockPrice(testData.get("StockPrice"));
		myporfolioPage = myporfolioPage.submitStock();
		waitForPageLoad();
		myporfolioPage.verifyStock(testData.get("StockName"));
		
		
	}
	
	@DataProvider
	public Object[][] AddStockTestData(){
		return TestDataProvider.getTestData("RediffPortFolioLaunch.xlsx", "StockTestData", "AddStockTest");
	}

}