package capsulecrm.base;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class TestUtil extends Base{

	@DataProvider(name="dp")
	public Object[][] getData(){
		
		String sheetName = "addUser";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] obj = new Object[rows-1][1];
		
		Map<String, String> hash;
		for(int i=2; i<=rows; i++) {
			hash = new HashMap<String, String>();
			for(int j=0; j<=cols; j++) {
				hash.put(excel.getCellData(sheetName, j, 1), excel.getCellData(sheetName, j, i));
				obj[i-2][0] = hash;
			}
		}
		
		return obj;	
	}
}
