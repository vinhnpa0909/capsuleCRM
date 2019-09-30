package capsulecrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Base {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	// read file excel
	public static ExcelReader excel = new ExcelReader(
			"D:\\Working\\5.Tester\\7.Workspace\\capsulecrm\\src\\test\\resources\\excel\\capsuleCRM.xlsx");

	// create explicit wait
	public static WebDriverWait wait;
	
	public static WebElement dropDown;
	
	public static TopMenu menu;
	
	public void initialize() {
		if (driver == null) {

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				config.load(fis);
				//log.debug("Config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				OR.load(fis);
				//log.debug("Object Repository file loaded");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
						+ "\\src\\test\\resources\\runner\\chromedriver.exe");
				driver = new ChromeDriver();
			}

			/*System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\executables\\chromedriver.exe");
			driver = new ChromeDriver(); */
			driver.get(config.getProperty("testsiteurl"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			menu = new TopMenu(driver);
			//menu = new TopMenu(driver);
		}
	}
	
	public static void select(String locator, String value) {
		if (locator.endsWith("_CSS")) {
			List<WebElement> test = driver.findElements(By.cssSelector(OR.getProperty(locator)));

			System.out.println(test.size());

			dropDown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}
		if (locator.endsWith("_XP")) {
			List<WebElement> test = driver.findElements(By.xpath(OR.getProperty(locator)));

			System.out.println(test.size());

			dropDown = driver.findElement(By.xpath(OR.getProperty(locator)));
		}
		Select s = new Select(dropDown);
		s.selectByVisibleText(value);
	}

	public static void click(String locator) {
		if (locator.endsWith("_CSS")) {
			List<WebElement> test = driver.findElements(By.cssSelector(OR.getProperty(locator)));

			System.out.println(test.size());
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}
		if (locator.endsWith("_XP")) {
			List<WebElement> test = driver.findElements(By.xpath(OR.getProperty(locator)));

			System.out.println(test.size());
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}
	}
	
	public static void sendKeys(String locator, String keysToSend) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(keysToSend);
		}
		
		if (locator.endsWith("_XP")) {
			List<WebElement> test = driver.findElements(By.xpath(OR.getProperty(locator)));

			System.out.println(test.size());
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(keysToSend);
		}
	}
	
	public static boolean isPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	public static boolean isContent(WebElement menu, WebElement content) {
		if(menu.getText().equals(content.getText()))
			return true;
		else
			return false;
		
	}
}
