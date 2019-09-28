package capsulecrm;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import capsulecrm.base.Base;

public class ConfigurationTest extends Base {

	@Test
	public void clickAccountSettings() {
		menu.accountPage();
	}
	
}
