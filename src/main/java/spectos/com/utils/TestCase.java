package spectos.com.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestCase {
	public TestBase action;
	protected String dataFile;
	protected String dataSheet;
	public static String pathResultTestSuilt;

	public TestCase() {
		action = new TestBase();
	}

	public TestCase(TestBase action) {
		this.action = action;
	}

	public void setDataFile(String dataFile) {
		this.dataFile = dataFile;
	}

	public void setDataSheet(String dataSheet) {
		this.dataSheet = dataSheet;
	}

	public List<HashMap<String, String>> loadData(String tableName) {
		return Utils.getTestData(this.dataFile, this.dataSheet, tableName);
	}

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		action.initSeleniumTest();
	}

	@AfterClass
	public void afterClass() {
		action.driver.manage().deleteAllCookies();
		Utils.pause(7000);
		action.driver.quit();
	}

	public void quitBrowser() {
		action.driver.manage().deleteAllCookies();
		Utils.pause(7000);
		action.driver.quit();
	}

	public void openNewTab(String strURL) {
		action.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		ArrayList<String> tabs = new ArrayList<String>(action.driver.getWindowHandles());
		action.driver.switchTo().window(tabs.get(1));
		action.driver.navigate().to(strURL);
	}


	public Object[][] dpPrepareData(String tblData) {
		int size = 0;
		List<HashMap<String, String>> datas = loadData(tblData);
		Object[][] array = new Object[datas.size()][];

		size = datas.size();
		for (int i = 0; i < size; i++) {
			array[i] = new Object[] { datas.get(i) };
		}
		return array;
	}

	/**
	 * Not work yet
	 */
	public void waitTime() {
		action.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
