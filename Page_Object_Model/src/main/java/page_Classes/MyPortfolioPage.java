package page_Classes;

import java.util.List;

import javax.swing.LookAndFeel;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_Classes.PageBaseClass;
import base_Classes.TopMenuClass;

public class MyPortfolioPage extends PageBaseClass{
	
	public TopMenuClass topmenu;
	
	public MyPortfolioPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		topmenu = new TopMenuClass(driver, logger);
		PageFactory.initElements(driver, topmenu);
	}
	
	@FindBy(xpath="//*[@id='headcontent']/div[1]/div[1]/a/span")
	public WebElement moneyBiz_text;
	
	@FindBy(id="createPortfolio")
	public WebElement createPortfolio_Btn;
	
	@FindBy(id="create")
	public WebElement createportfolio_textbox;
	
	@FindBy(id="createPortfolioButton")
	public WebElement submitCreatePortfolio_Btn;
	
	@FindBy(id="portfolioid")
	public WebElement myPortfolioList;
	
	@FindBy(id="deletePortfolio")
	public WebElement deletePortfolio_Btn;
	
	@FindBy(id="addStock")
	public WebElement addStock_Btn;
	
	@FindBy(id="addstockname")
	public WebElement stockName_TextBox;
	
	@FindBy(xpath="//*[@id='ajax_listOfOptions']/div[1]")
	public WebElement stockValue;
	
	@FindBy(id="addstockqty")
	public WebElement stockQualitity_txtBox;
	
	@FindBy(id="addstockprice")
	public WebElement stockPrice_TxtBox;
	
	@FindBy(id="addStockButton")
	public WebElement submitStock_Btn;
	
	@FindBy(id="stock")
	public WebElement StockTable;
	
	//added below item - 29th july 21
	@FindBy(xpath="//*[@id='stock']/tbody/tr")
	public List<WebElement> stockrow;
	
	@FindBy(id="stockPurchaseDate")
	public WebElement stockPurchaseDate;
	
	
	public void clickStockPurchaseCalendar(){
		
		try {
			stockPurchaseDate.click();
			logger.log(Status.PASS, "Clicked the Stock purchase Calendar");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public MyPortfolioPage submitStock(){
		try {
			submitStock_Btn.click();
			logger.log(Status.PASS, "Submitted the Stock");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		MyPortfolioPage myPortfolioPage = new MyPortfolioPage(driver, logger);
		PageFactory.initElements(driver, myPortfolioPage);
		return myPortfolioPage;
	}
	
	public void verifyStock(String StockName){
		boolean flag= false;
		try {
			//List<WebElement> tableRows = StockTable.findElements(By.xpath("/tbody/tr"));
			List<WebElement> tableRows = stockrow;
			System.out.println("tableRows");
			System.out.println(tableRows);
			for (WebElement row : tableRows) {
				List<WebElement> tableColumsn = row.findElements(By.tagName("td"));
				System.out.println("tableColumsn");
				System.out.println(tableColumsn);
				for (WebElement column : tableColumsn) {
					System.out.println("Verifystock - column.getText");
					System.out.println(column.getText());
					if(column.getText().startsWith(StockName)){
						
						flag=true;
						System.out.println(flag);
					}
				}
			}
			Assert.assertTrue(flag, "Given Stock : " +StockName + " is present in this Portfolio");
			logger.log(Status.PASS, "Given Stock : " +StockName + " is present in this Portfolio");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	
	
	public void enterStockPrice(String stockPrice){
		try {
			stockPrice_TxtBox.sendKeys(stockPrice);
			logger.log(Status.PASS, "Entered the Price : " + stockPrice);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	public void enterStockQuantity(String quantity){
		try {
			stockQualitity_txtBox.sendKeys(quantity);
			logger.log(Status.PASS, "Add the Quantity : " + quantity);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void enterStockName(String stockName){
		try {
			stockName_TextBox.sendKeys(stockName);
			waitForPageLoad();
			stockValue.click();
			logger.log(Status.PASS, "Typed Stock Name : " + stockName);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void clickAddStock(){
		try {
			addStock_Btn.click();
			logger.log(Status.PASS, "Clicked the Add Stock Button");
		} catch (Exception e) {
			reportFail(e.getMessage());;
		}
	}
	
	public MyPortfolioPage deletePortFolio(){
		try {
			deletePortfolio_Btn.click();
			acceptAlert();
			logger.log(Status.PASS, "Deleted the Portfolio");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		MyPortfolioPage myportfolio = new MyPortfolioPage(driver, logger);
		PageFactory.initElements(driver, myportfolio);
		return myportfolio;
	}
	
	public MyPortfolioPage selectPortfolio(String Value){
		selectDropDownValue(myPortfolioList, Value);
		MyPortfolioPage myportfolio = new MyPortfolioPage(driver, logger);
		PageFactory.initElements(driver, myportfolio);
		return myportfolio;
	}
	
	public void isPorfolioExists(String portfolio){
		boolean flag = false;
		try {
			List<WebElement> allOptions = getAllElementsOfDropDown(myPortfolioList);
			for (WebElement option : allOptions) {
				if (option.getText().equalsIgnoreCase(portfolio)){
					flag=true;
				}else{
					flag = false;
				}
			}
			Assert.assertTrue(flag);
			logger.log(Status.PASS, "Given Portfolio : " + portfolio + " , Present in Portfolio List");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	public void isPorfolioDeleted(String portfolio){
		boolean flag = false;
		try {
			List<WebElement> allOptions = getAllElementsOfDropDown(myPortfolioList);
			for (WebElement option : allOptions) {
				if (!option.getText().equalsIgnoreCase(portfolio)){
					flag=true;
				}else{
					flag = false;
				}
			}
			Assert.assertTrue(flag);
			logger.log(Status.PASS, "Given Portfolio : " + portfolio + " , is not Prsent in Portfolio List");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public MyPortfolioPage submitPortfolio(){
		try {
			submitCreatePortfolio_Btn.click();
			logger.log(Status.PASS, "Submitted the Portfolio");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
		MyPortfolioPage myportfolio = new MyPortfolioPage(driver, logger);
		PageFactory.initElements(driver, myportfolio);
		return myportfolio;
		
	}
	
	public void enterPortfolioName(String portfolioName){
		try {
			createportfolio_textbox.clear();
			createportfolio_textbox.sendKeys(portfolioName);
			logger.log(Status.PASS, "Entered Portfolio Name : " + portfolioName);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	public void clickCreatePortfolio(){
		try {
			createPortfolio_Btn.click();
			logger.log(Status.PASS, "Clicked the Create Portfolio Button");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void verifyMoneyBiz(){
			moneyBiz_text.isDisplayed();
	}
	
	public TopMenuClass gettopMenu(){
		return topmenu;
	}
	
	

}
