package mvn.Page_Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Portfolio_Page {
	WebDriver localdriver;

	public Portfolio_Page(WebDriver driver)
	{
		this.localdriver = driver;		
	}
	
	@FindBy(xpath="//*[@id=\'createPortfolio\']")
	public WebElement createBtn;
	
	public void clickButton() {
		createBtn.click();
	}
}
