package capsulecrm;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import capsulecrm.base.Base;

public class ConfigurationTest extends Base {

	@Test
	public void clickAccountSettings() {
		menu.accountPage();
	}
	
	@Test(dependsOnMethods="clickAccountSettings")
	public void titleAccount() {
		assertTrue(isContent(driver.findElement(By.xpath(OR.getProperty("accountTab_XP"))), driver.findElement(By.xpath(OR.getProperty("accountTitle_XP")))));
		Actions action = new Actions(driver);
	}
	
	
}
