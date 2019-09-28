package capsulecrm.page;

import capsulecrm.base.Base;

public class LoginAccount extends Base {

	
	public MainPage clickLoginBtn() {
		sendKeys("loginPageUser_XP", "vinhnpa");
		sendKeys("loginPagePasswd_XP","@Nhvinh99");
		click("loginPageBtn_XP");
		
		return new MainPage();
	}
}
