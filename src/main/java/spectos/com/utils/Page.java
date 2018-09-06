package spectos.com.utils;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sun.reflect.Reflection;

public class Page {
	protected TestBase action;
	public HashMap<String, HashMap<String, By>> locationMap;
	protected HashMap<String, String> repoFile;
	protected HashMap<String, String> locationSheet;

	// hàm khởi tạo
	public Page(TestBase action) {
		this();
		this.action = action;
		waitForPageLoaded(action.driver);
	}

	public Page() {
		// TODO Auto-generated constructor stub
	}

	public void waitForPageLoaded(WebDriver driver) {
		// System.out.println("start wait for page load");
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		String url = driver.getCurrentUrl();
		// System.out.println("Bạn đang truy cập vào url = " + url);
		if (url.isEmpty() || url.equals("about:blank")) {
			return;
		}
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(pageLoadCondition);
		// System.out.println("page loaded");
	}

	public void waitForElementLocated(WebDriver driver, String locationName) {
		WebDriverWait wait = new WebDriverWait(action.driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(getLocation(locationName)));
	}

	public void initLocationMap() {
		if (this.locationMap == null) {
			this.locationMap = new HashMap<String, HashMap<String, By>>();
		}
		HashMap<String, By> map = new HashMap<String, By>();
		String strClassName = Reflection.getCallerClass(2).getSimpleName();
		String[][] repoObjects = Utils.getTableObject(this.getRepoFile(), this.getLocationSheet());
		String strLocationName = null;
		for (int i = 0; i < repoObjects.length; i++) {
			strLocationName = repoObjects[i][0];
			if (!strLocationName.isEmpty()) {
				map.put(strLocationName, Utils.getLocation(repoObjects[i][1], repoObjects[i][2]));
			}
		}
		this.locationMap.put(strClassName, map);
	}

	public By getLocation(String locationName) {
		String rootPage = "Page";
		Class<?> cls = this.getClass();
		String strClassName = cls.getSimpleName();
		HashMap<String, By> map = null;
		By loc = null;
		do {
			map = this.locationMap.get(strClassName);
			if (map.containsKey(locationName)) {
				loc = map.get(locationName);
			}
			// go up the nearest super class
			cls = cls.getSuperclass();
			strClassName = cls.getSimpleName();
		} while (loc == null && !strClassName.equals(rootPage));

		return loc;
	}

	/**
	 * @param strRepoFile
	 * @return
	 */
	public String setRepoFile(String strRepoFile) {
		if (this.repoFile == null) {
			this.repoFile = new HashMap<String, String>();
		}
		String strClassName = Reflection.getCallerClass(2).getSimpleName();
		return this.repoFile.put(strClassName, strRepoFile);
	}

	public String getRepoFile() {
		String strClassName = Reflection.getCallerClass(3).getSimpleName();
		return this.repoFile.get(strClassName);
	}

	@SuppressWarnings("restriction")
	public String setLocationSheet(String strLocationSheet) {
		if (this.locationSheet == null) {
			this.locationSheet = new HashMap<String, String>();
		}
		@SuppressWarnings("restriction")
		String strClassName = Reflection.getCallerClass(2).getSimpleName();
		return this.locationSheet.put(strClassName, strLocationSheet);
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public String getLocationSheet() {
		String strClassName = Reflection.getCallerClass(3).getSimpleName();
		return this.locationSheet.get(strClassName);
	}

}
