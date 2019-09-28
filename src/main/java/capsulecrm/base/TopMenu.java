package capsulecrm.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import capsulecrm.page.HomePage;
import configuration.AccountPage;
import main.CasesPage;
import main.PeoplePage;

public class TopMenu {

	public WebDriver driver;

	public TopMenu(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	public HomePage Dashboard() {
		// click("dashboardMenu_CSS");
		driver.findElement(By.xpath("//div//nav[@role='navigation']//child::div[1]"));

		return new HomePage();
	}

	public CasesPage Cases() {
		driver.findElement(By.xpath("//div[contains(@class,'nav-bar-section nav-bar-main')] // nav //child::div[5]"))
				.click();
		return new CasesPage();

	}

	public PeoplePage People() {
		driver.findElement(By.xpath("//nav[@role='navigation'] //child::div[2][contains(@class,'tooltipper')]"))
				.click();
		return new PeoplePage();
	}

	public AccountPage accountPage() {
		
		System.out.println(isPresent(By.xpath("//div[contains(@class,'account')]")));
		
		WebElement el = driver.findElement(By.xpath("//div[contains(@class,'account')]"));

		Actions action = new Actions(driver);

		action.moveToElement(el).perform();
		
		driver.findElement(By.xpath("//div[contains(@class,'account')]")).click();
		
		System.out.println(isPresent(By.xpath("//div[contains(@class,'bottom-right')]//child::a[2]")));

		driver.findElement(By.xpath("//div[contains(@class,'bottom-right')]//child::a[2]"))
				.click(); 

		return new AccountPage();
	}
}
