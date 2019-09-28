package main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import capsulecrm.base.Base;

public class AddCasePage extends Base{

	
	public void CaseRelatesSelect(String name) throws InterruptedException {
		sendKeys("caseRelates_XP", name);
		Thread.sleep(2000);
		
		List<WebElement> element = driver.findElements(By.xpath("//span[@class='search-select-option-text']"));
		
		WebElement el = null;
		
		for(WebElement elm:element) {
			if(elm.getText().equals(name)) {
				el = elm;
				break;
			}
		}
		
		Actions action = new Actions(driver);
		action.moveToElement(el).perform();
		el.click();
		
	}
}
