package capsulecrm;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import capsulecrm.base.Base;
import main.AddCasePage;
import main.CasesPage;

public class AddNewCase extends Base{
	
	AddCasePage addCase;
	
	@BeforeClass
	@Test(enabled=false)
	public void addCase() throws InterruptedException {
		CasesPage casePage = menu.Cases();
		 addCase = casePage.clickAddCase();
		 addCase.CaseRelatesSelect("nou nou");
	}
	
   @Test(dependsOnMethods="addCase", enabled=false)
	public void addNewCase() throws InterruptedException {
		addCase.CaseRelatesSelect("nou nou");
		sendKeys("caseName_XP", "waohhh");
		click("saveBtn_XP");
	}
}
