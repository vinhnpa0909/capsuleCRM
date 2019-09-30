package main;

import capsulecrm.base.Base;

public class UserConfig extends Base {

	
	public boolean findUsers(String name) {
		sendKeys("findUsersInput_XP", name);
		
		return false;
	}
}
