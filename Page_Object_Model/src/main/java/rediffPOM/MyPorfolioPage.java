package rediffPOM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class MyPorfolioPage extends PageBaseClass{
	
	public MyPorfolioPage(WebDriver driver) {
		super(driver);
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

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public MyPorfolioPage submitStock(){
		try {
			submitStock_Btn.click();

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		MyPorfolioPage myportfolio = new MyPorfolioPage(driver);
		PageFactory.initElements(driver, myportfolio);
		return myportfolio;
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
					if(column.getText().equalsIgnoreCase(StockName)){
						
						flag=true;
						
					}
				}
			}
			Assert.assertTrue(flag, "Given Stock : " +StockName + " is not present in this Portfolio");
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	
	
	public void enterStockPrice(String stockPrice){
		try {
			stockPrice_TxtBox.sendKeys(stockPrice);

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	public void enterStockQuantity(String quantity){
		try {
			stockQualitity_txtBox.sendKeys(quantity);

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void enterStockName(String stockName){
		try {
			stockName_TextBox.sendKeys(stockName);
			waitForPageLoad();
			stockValue.click();

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void clickAddStock(){
		try {
			addStock_Btn.click();

		} catch (Exception e) {
			reportFail(e.getMessage());;
		}
	}
	
	public MyPorfolioPage deletePortFolio(){
		try {
			deletePortfolio_Btn.click();
			acceptAlert();

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		MyPorfolioPage myportfolio = new MyPorfolioPage(driver);
		PageFactory.initElements(driver, myportfolio);
		return myportfolio;
	}
	
	public MyPorfolioPage selectPortfolio(String Value){
		selectDropDownValue(myPortfolioList, Value);
		MyPorfolioPage myportfolio = new MyPorfolioPage(driver);
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
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public MyPorfolioPage submitPortfolio(){
		try {
			submitCreatePortfolio_Btn.click();
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
		MyPorfolioPage myportfolio = new MyPorfolioPage(driver);
		PageFactory.initElements(driver, myportfolio);
		return myportfolio;
		
	}
	
	public void enterPortfolioName(String portfolioName){
		try {
			createportfolio_textbox.clear();
			createportfolio_textbox.sendKeys(portfolioName);
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	public void clickCreatePortfolio(){
		try {
			createPortfolio_Btn.click();
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void verifyMoneyBiz(){
			moneyBiz_text.isDisplayed();
	}
	

	
	

}
