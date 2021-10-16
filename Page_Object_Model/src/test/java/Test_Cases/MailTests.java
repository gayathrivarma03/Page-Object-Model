package Test_Cases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page_Classes.LandingPage;
import page_Classes.RediffMailPage;
import page_Classes.WriteMailPage;
import base_Classes.BaseTestClass;
import base_Classes.PageBaseClass;
import uti_lities.TestDataProvider;

public class MailTests extends BaseTestClass{
	
	LandingPage landingPage;
	RediffMailPage rediffMailPage;
	WriteMailPage writeMailPage;
	
	@Test(dataProvider="rediffMailTestData")
	public void writeMailTest(Hashtable<String, String> testData) {
		
		logger = report.createTest("Write Email Test Case");
		
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		rediffMailPage = landingPage.clickRediffMailLink();
		writeMailPage = rediffMailPage.doSignIn(testData.get("Username"), testData.get("Password"));
		writeMailPage = writeMailPage.writeMail(testData.get("Email ID"), testData.get("Subject"));
	}

	@DataProvider
	public Object[][] rediffMailTestData(){
		return TestDataProvider.getTestData("RediffPortFolioLaunch.xlsx", "RediffMailData", "writeMail");
	}
}
