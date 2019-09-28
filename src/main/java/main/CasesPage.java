package main;

import capsulecrm.base.Base;

public class CasesPage extends Base {

	public AddCasePage clickAddCase() {
		click("addCaseBtn_XP");
		
		return new AddCasePage();
	}
}
