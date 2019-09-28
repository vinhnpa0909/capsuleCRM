package capsulecrm.page;

import capsulecrm.base.Base;

public class HomePage extends Base{

	public LoginDomain clickLoginBtn() {
		
		click("loginlink_XP");
		return new LoginDomain();
	}
}
