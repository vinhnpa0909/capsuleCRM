package capsulecrm;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import capsulecrm.base.Base;
import capsulecrm.base.TestUtil;
import capsulecrm.page.HomePage;
import capsulecrm.page.LoginAccount;
import capsulecrm.page.LoginDomain;
import main.PeoplePage;

public class AddPersonTest extends Base {

	HomePage homePage = new HomePage();
	LoginAccount loginAcc = new LoginAccount();
	LoginDomain loginDomain = new LoginDomain();
	
	Object[][] hashObject = new Object[2][1];

	@BeforeSuite
	public void login() {
		initialize();
		LoginDomain domain = homePage.clickLoginBtn();
		LoginAccount account = domain.inputDomain();
		account.clickLoginBtn();
	}
	
	@Test(enabled=false)
	public void clickAddUser() {
		PeoplePage people = homePage.menu.People();
		people.addPerson();
	}
	
	@Test(enabled=false,dataProviderClass = TestUtil.class
			,dataProvider="dp", dependsOnMethods="clickAddUser")
	public void addUser(HashMap<String, String> hash) {
		
		select("title_XP", hash.get("Title"));
		sendKeys("firstName_XP", hash.get("First Name"));
		sendKeys("lastName_XP", hash.get("Last Name"));
		sendKeys("jobTitle_XP", hash.get("Job Title"));
		sendKeys("organi_XP", hash.get("Organisation"));
		sendKeys("phone_XP", hash.get("Phone Numbers"));
		click("addAddresses_XP");
		sendKeys("address_XP", hash.get("Addresses"));
		
		click("saveBtn_XP");
		
		for(int i=0;i<=2;i++) {
			for(int j=0;j<1;j++) {
				if(hashObject[i][j]==null) {
					hashObject[i][j] = hash;
					break;
				}
			}
			break;
		}
		
		for(int i=0;i<hashObject.length;i++) {
			for(int j=0;j<hashObject[0].length;j++) {
				System.out.println("value hash object is: "+ hashObject[i][j]);
			}
		}
		
		System.out.println(hash.size());
		
		clickAddUser();
		Assert.assertTrue(true);
	}
}
