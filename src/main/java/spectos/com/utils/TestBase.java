package spectos.com.utils;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;

public class TestBase {
	public WebDriver driver;
	public Properties config;
	public int defaultTimeOut;
	public int waitInterval;

	public TestBase() {
		config = Utils.loadConfig("config.properties");
		defaultTimeOut = Integer.parseInt(config.getProperty("DEFAULT_TIMEOUT"));
	}

	public void gotoPage(String strURL) {
		driver.get(strURL);
		// maximize window browser
		driver.manage().window().maximize();
	}

	
	@Parameters("browser")
	public void initSeleniumTest(String... webUrl) {
		String browser = System.getProperty("browser");
//		System.err.println(" __BrowserRun__ " + browser + " __BrowserRun__ "
//				+ "\r\n");
		if ("chrome".equalsIgnoreCase(browser)) {
			System.setProperty("webdriver.chrome.driver","D:\\Eclipse\\FDBE\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if ("ie".equalsIgnoreCase(browser)) {
			System.setProperty("webdriver.ie.driver","D:\\Eclipse\\FDBE\\driver\\geckodriver.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver(caps);
		} else {
			System.setProperty("webdriver.gecko.driver", "D:\\Eclipse\\FDBE\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}

	public WebElement getElement(Object locator) {
		WebElement elem = null;
		try {
			By by = locator instanceof By ? (By) locator : By.xpath(locator
					.toString());

			elem = driver.findElement(by);
		} catch (NoSuchElementException e) {
			AssertJUnit.fail(e.getMessage());
		} catch (NullPointerException nullException) {
			AssertJUnit.fail(nullException.getMessage());
		}
		AssertJUnit.assertTrue(elem != null);
		return elem;
	}
	
	public void check(Object locator) {
		Actions actions = new Actions(driver);
		try {
			WebElement element = getElement(locator);
			if (!element.isSelected()) {
				actions.click(element).perform();
			} else {
				System.out.println("Element " + locator
						+ " is already checked .");
			}
		} catch (StaleElementReferenceException e) {
			e.getStackTrace();
		}
	}

	public String getText(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			if (element.isDisplayed()) {
				return element.getText();
			}

		} catch (NoSuchElementException e) {
			e.getStackTrace();
		}
		return "";

	}

	public String getTitle(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			if (element.isDisplayed()) {
				String actualTitle = driver.getTitle();
				return actualTitle;
			}
		} catch (NoSuchElementException e) {
			e.getStackTrace();
		}
		return "";

	}

	public String getValue(Object locator) {
		try {
			return getElement(locator).getAttribute("value");
		} catch (StaleElementReferenceException e) {
			return "";
		}
	}

	public String getAtributeValue(Object locator, String attributeName) {
		try {
			return getElement(locator).getAttribute(attributeName);
		} catch (StaleElementReferenceException e) {
			return "";
		}
	}

	/**
	 * kiem tra item co duoc hien thi hay khong
	 * 
	 * @param locator
	 *            locator cua phan tu muon kiem tra
	 * @return true neu element tuong ung voi locator dang duoc hien thi
	 */
	public boolean isElementPresent(Object locator) {
		WebElement element = null;
		try {
			By by = locator instanceof By ? (By) locator : By.xpath(locator.toString());
			element = driver.findElement(by);
		} catch (Exception e) {
			return false;
		}
		return element != null && element.isDisplayed();
	}

	public boolean isElementNotPresent(Object locator) {
		return !isElementPresent(locator);
	}

	public void select(Object locator, String option) {
		try {
			Select select = new Select(getElement(locator));
			select.selectByVisibleText(option);
			Utils.pause(waitInterval);

		} catch (StaleElementReferenceException e) {

		}
	}

	public void click(Object locator) {
		try {
			WebElement element = getElement(locator);
			if (element.isEnabled()) {
				element.click();
			} else {
				System.out.println("Element is not enabled");

			}
		} catch (ElementNotVisibleException e) {
			e.getStackTrace();
		}
	}

	public void type(Object locator, String value) {
		try {
			WebElement element = getElement(locator);
			if (element != null) {
				element.clear();
				if (element.getAttribute("readonly") != null
						&& element.getAttribute("readonly").equals("true"))
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].value=arguments[1]", element, value);
				else {
					element.click();
					element.sendKeys(value);
				}
			} else {
				System.out.println("Element is not displayed");

			}
		} catch (ElementNotVisibleException e) {
			e.getStackTrace();
		}
	}

}
