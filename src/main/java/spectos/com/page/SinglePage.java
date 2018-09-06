package spectos.com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import spectos.com.utils.Constants;
import spectos.com.utils.Page;
import spectos.com.utils.TestBase;

public class SinglePage extends Page {
	public SinglePage(TestBase action) {
		// call super constructor
		super(action);

		this.setRepoFile(action.config.getProperty("REPO_OBJECT_PATH_1"));
		this.setLocationSheet(Constants.SinglePage.SHEET_SINGLE_PAGE);

		// load object location
		this.initLocationMap();
		waitForPageLoaded(action.driver);
	}

	public void q1_choose1star() {
		action.click(getLocation(Constants.SinglePage.Q1_1STAR));
	}

	public void q1_choose2star() {
		action.click(getLocation(Constants.SinglePage.Q1_2STAR));
	}

	public void q1_choose3star() {
		action.click(getLocation(Constants.SinglePage.Q1_3STAR));
	}

	public void q1_choose4star() {
		action.click(getLocation(Constants.SinglePage.Q1_4STAR));
	}

	public void q1_choose5star() {
		action.click(getLocation(Constants.SinglePage.Q1_5STAR));
	}

	public void check_q2sub_appear(String comment) {
		if (action.isElementPresent(getLocation(Constants.SinglePage.Q2_TITLE))) {
			action.type(getLocation(Constants.SinglePage.Q2_TEXTAREA), comment);
		}
	}

	public void q3_chooseOption1() {
		action.click(getLocation(Constants.SinglePage.Q3_OPTION1));
	}

	public void q3_chooseOption2() {
		action.click(getLocation(Constants.SinglePage.Q3_OPTION2));
	}

	public void q4_chooseOption1() {
		action.click(getLocation(Constants.SinglePage.Q4_OPTION1));
	}

	public void q4_chooseOption2() {
		action.click(getLocation(Constants.SinglePage.Q4_OPTION2));
	}

	public void q4_chooseOption3() {
		action.click(getLocation(Constants.SinglePage.Q4_OPTION3));
	}

	public void q4_chooseOption4() {
		action.click(getLocation(Constants.SinglePage.Q4_OPTION4));
	}

	public void q5_chooseOption1() {
		action.click(getLocation(Constants.SinglePage.Q5_OPTION1));
	}

	public void q5_chooseOption2() {
		action.click(getLocation(Constants.SinglePage.Q5_OPTION2));
	}

	public void q5_chooseOption3() {
		action.click(getLocation(Constants.SinglePage.Q5_OPTION3));
	}

	public void q5_chooseOption4() {
		action.click(getLocation(Constants.SinglePage.Q5_OPTION4));
	}

	public void q5_chooseOption5() {
		action.click(getLocation(Constants.SinglePage.Q5_OPTION5));
	}

	public void q5_chooseOption6() {
		action.click(getLocation(Constants.SinglePage.Q5_OPTION6));
	}

	public void q5_chooseOption7() {
		action.click(getLocation(Constants.SinglePage.Q5_OPTION7));
	}

	public void q5_chooseOption8() {
		action.click(getLocation(Constants.SinglePage.Q5_OPTION8));
	}

	public void q5_chooseOption9() {
		action.click(getLocation(Constants.SinglePage.Q5_OPTION9));
	}

	public void q5_chooseOption10() {
		action.click(getLocation(Constants.SinglePage.Q5_OPTION10));
	}

	public void q5_chooseOptionDontKnow() {
		action.click(getLocation(Constants.SinglePage.Q5_OPTION11));

	}

	public void check_q5sub_appear(String comment) {
		if (action.isElementPresent(getLocation(Constants.SinglePage.Q5_SUBTITLE))) {
			action.type(getLocation(Constants.SinglePage.Q5_TEXTAREA), comment);
		}
	}

	public void q6_chooseOption0() {
		action.click(getLocation(Constants.SinglePage.Q6_0POINT));

	}

	public void q6_chooseOption1() {
		action.click(getLocation(Constants.SinglePage.Q6_1POINT));

	}

	public void q6_chooseOption2() {
		action.click(getLocation(Constants.SinglePage.Q6_2POINT));
	}

	public void q6_chooseOption3() {
		action.click(getLocation(Constants.SinglePage.Q6_3POINT));
	}

	public void q6_chooseOption4() {
		action.click(getLocation(Constants.SinglePage.Q6_4POINT));
	}

	public void q6_chooseOption5() {
		action.click(getLocation(Constants.SinglePage.Q6_5POINT));
	}

	public void q6_chooseOption6() {
		action.click(getLocation(Constants.SinglePage.Q6_6POINT));
	}

	public void q6_chooseOption7() {
		action.click(getLocation(Constants.SinglePage.Q6_7POINT));
	}

	public void q6_chooseOption8() {
		action.click(getLocation(Constants.SinglePage.Q6_8POINT));
	}

	public void q6_chooseOption9() {
		action.click(getLocation(Constants.SinglePage.Q6_9POINT));
	}

	public void q6_chooseOption10() {
		action.click(getLocation(Constants.SinglePage.Q6_10POINT));
	}

	public void q7_answer_customerInfo(String fullname, String bookingnumber, String flightnumber, String flighdate) {
		action.type(getLocation(Constants.SinglePage.Q7_FULLNAME), fullname);
		action.type(getLocation(Constants.SinglePage.Q7_BOOKINGNUMBER), bookingnumber);
		action.type(getLocation(Constants.SinglePage.Q7_FLIGHTNUMBER), flightnumber);
		action.type(getLocation(Constants.SinglePage.Q7_FLIGHTDATE), flighdate);
	}

	public void q9_chooseYes() {
		action.click(getLocation(Constants.SinglePage.Q9_YES));
	}

	public void q9_chooseNo() {
		action.click(getLocation(Constants.SinglePage.Q9_NO));
	}

	public void q10_clickKeep() {
		action.click(getLocation(Constants.SinglePage.Q10_KEEPCURRENTSORTING));
	}

	public void q11_clickGetLocation() {
		action.click(getLocation(Constants.SinglePage.Q11_GETLOCATION));
	}

	public void click_Submit(WebDriver driver) {
		waitForElementLocated(driver, Constants.SinglePage.SUBMIT_BTN);
		action.click(getLocation(Constants.SinglePage.SUBMIT_BTN));
	}

	public String get_msg_get_location_success(WebDriver driver) {
		waitForElementLocated(driver, Constants.SinglePage.Q11_msg_get_location_success);
		return action.getText(getLocation(Constants.SinglePage.Q11_msg_get_location_success));
	}
	public String get_msg_successful(WebDriver driver) {
//		action.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement element = wait.until(
//		        ExpectedConditions.visibilityOfElementLocated(getLocation(Constants.SinglePage.Successf_msg)));
		waitForElementLocated(driver, Constants.SinglePage.Successf_msg);
		return action.getText(getLocation(Constants.SinglePage.Successf_msg));
	}
	public String get_required_msg_q1(WebDriver driver) {
		waitForElementLocated(driver, Constants.SinglePage.WARNING_REQUIRED_QUESTION1);
		return action.getText(getLocation(Constants.SinglePage.WARNING_REQUIRED_QUESTION1));
	}
	public String get_required_msg_q3(WebDriver driver) {
		waitForElementLocated(driver, Constants.SinglePage.WARNING_REQUIRED_QUESTION3);
		return action.getText(getLocation(Constants.SinglePage.WARNING_REQUIRED_QUESTION3));
	}
	public String get_required_msg_q8(WebDriver driver) {
		waitForElementLocated(driver, Constants.SinglePage.WARNING_REQUIRED_QUESTION8);
		return action.getText(getLocation(Constants.SinglePage.WARNING_REQUIRED_QUESTION8));
	}
	
//	private void q8_changeOrder() {
//		WebElement from = driver.findElement(By.xpath(".//a[@id='j3_7_anchor']"));
//        WebElement to = driver.findElement(By.xpath(".//a[@id='j3_1_anchor']"));
//         
//        Actions builder = new Actions(driver);
//        Action dragAndDrop = builder.clickAndHold(from)
//                .moveToElement(to).release(to).build();
//         
//        dragAndDrop.perform();
//
//	}
}
