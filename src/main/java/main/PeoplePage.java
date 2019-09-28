package main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import capsulecrm.base.Base;

public class PeoplePage extends Base{

	public AddNewPeoplePage addPerson() {
		click("addPerson_XP");
		
		return new AddNewPeoplePage();
	}
	
	public static List<WebElement> getName(){
		
		List<WebElement> list = driver.findElements(By.xpath("//tr[@class='list-results-row ']/child::td[3]/child::a[1]"));
		
		System.out.println("list size is: "+list.size());
		
		return list;
		
	}
	
	
}
