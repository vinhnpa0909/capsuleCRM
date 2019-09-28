package capsulecrm.page;

import capsulecrm.base.Base;

public class LoginDomain extends Base{

	public LoginAccount inputDomain() {
		sendKeys("loginDomain_CSS", "vinhnpa");
		click("loginDomainBtn_CSS");
		
		return new LoginAccount();
	}
}
