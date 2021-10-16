package Test_Cases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_Classes.LandingPage;
import page_Classes.MoneyPage;
import page_Classes.MyPorFolioPage;
import page_Classes.MyPortfolioPage;
import page_Classes.PortFolioLoginPage;
import page_Classes.PortfolioLoginPage;
import base_Classes.BaseTestClass;
import base_Classes.PageBaseClass;
import base_Classes.TopMenuClass;
import uti_lities.ConstantValue;
import uti_lities.TestDataProvider;

public class MyPortfolioTest extends BaseTestClass{
	
	LandingPage landingPage;
	MoneyPage moneyPage;
	PortfolioLoginPage portfolioLoginPage;
	MyPortfolioPage myporfolioPage;
	TopMenuClass topMenu;
	
	@Test(dataProvider="getOpenPortfolioTestData", groups={"Regression", "LoginTest" }, priority=2)
	public void openPorfolio(Hashtable<String, String> testData){
		
		logger = report.createTest("Login Rediff Portfolio : " + testData.get("Comment"));
		
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		moneyPage =landingPage.clickMoneyLink();
		portfolioLoginPage = moneyPage.clickSingInLink();
		myporfolioPage = portfolioLoginPage.doLogin(testData.get("UserName"), testData.get("Password"));
		myporfolioPage.verifyMoneyBiz();
		myporfolioPage.getTitle(testData.get("PageTitle"));
		topMenu = myporfolioPage.gettopMenu();
		topMenu.singOutApplication();
	}
	
	@Test(dataProvider="verifyLoginTestData", groups={"Regression", "LoginTest" }, priority=3)
	public void verifyLogin(Hashtable<String, String> testData){
		logger = report.createTest("Login Rediff Portfolio : " + testData.get("Comment"));
		
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		moneyPage =landingPage.clickMoneyLink();
		portfolioLoginPage = moneyPage.clickSingInLink();
		portfolioLoginPage.enterUser(testData.get("UserName"));
		portfolioLoginPage.submitUserName();
		//below one line added - 5th may 2021
		//portfolioLoginPage.enterPassword(testData.get("Password"));
		portfolioLoginPage.verifyPasswordField();
		
	}
	
	@Test(dataProvider="addPortfolioTestData", groups={"Regression", "AddPortfolio" }, priority=1)
	public void addPortfolioTest(Hashtable<String, String> testData){
		logger = report.createTest("Create Porfolio Test : " + testData.get("Comment"));
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
	}
	
	
	@Test(dataProvider="addPortfolioTestData", groups={"Regression", "DeletePortfolio" }, priority=4)
	public void deletePortfolio(Hashtable<String, String> testData){
		System.out.println("In Delete portfolio - starting");
		logger = report.createTest("Delete Porfolio Test : " + testData.get("Comment"));
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		moneyPage =landingPage.clickMoneyLink();
		portfolioLoginPage = moneyPage.clickSingInLink();
		myporfolioPage = portfolioLoginPage.doLogin(ConstantValue.userName, ConstantValue.password);
		waitForPageLoad();
		myporfolioPage.verifyMoneyBiz();
		myporfolioPage = myporfolioPage.selectPortfolio(testData.get("PortfolioName"));
		myporfolioPage = myporfolioPage.deletePortFolio();
		waitForPageLoad();
		myporfolioPage.isPorfolioDeleted(testData.get("PortfolioName"));
		System.out.println("In Delete portfolio - Ending");
	}
	
	@DataProvider
	public Object[][] getOpenPortfolioTestData(){
		return TestDataProvider.getTestData("RediffPortFolioLaunch.xlsx", "RediffLoginTest", "openPorfolio");
	}
	
	@DataProvider
	public Object[][] verifyLoginTestData(){
		return TestDataProvider.getTestData("RediffPortFolioLaunch.xlsx", "RediffLoginTest", "verifyLogin");
	}
	
	@DataProvider
	public Object[][] addPortfolioTestData(){
		return TestDataProvider.getTestData("RediffPortFolioLaunch.xlsx", "RediffLoginTest", "addPortfolioTest");
	}

}
