package spectos.com.test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import spectos.com.page.SinglePage;
import spectos.com.utils.Constants;
import spectos.com.utils.TestBase;
import spectos.com.utils.TestCase;

public class SinglePage_Test extends TestCase {

	public SinglePage_Test() {
		this.dataFile = action.config.getProperty("TEST_DATA_PATH");
		this.dataSheet = Constants.SinglePage.SHEET_SINGLE_PAGE;
	}

	public SinglePage_Test(TestBase action) {
		super(action);
		this.dataFile = action.config.getProperty("TEST_DATA_PATH");
		this.dataSheet = Constants.SinglePage.SHEET_SINGLE_PAGE;
	}

// Complete survey with valid data
	@DataProvider(name = "testcase1")
	public Object[][] dptestcase1() {
		return dpPrepareData("testcase1");
	}

	@Test(dataProvider = "testcase1")
	public void testcase_1(HashMap<String, String> getData_01) {
		System.out.println("Please answer this survey!");
		action.gotoPage(action.config.getProperty("APP_URL"));
		SinglePage survey1 = new SinglePage(action);

		survey1.q1_choose2star();
		survey1.check_q2sub_appear(getData_01.get(Constants.SinglePage.Q2_TEXTAREAINPUT).trim());
		survey1.q3_chooseOption2();
		survey1.q4_chooseOption1();
		survey1.q4_chooseOption3();
		survey1.q5_chooseOption8();
		survey1.check_q5sub_appear(getData_01.get(Constants.SinglePage.Q5_TEXTAREAINPUTTED.trim()));
		survey1.q6_chooseOption8();
		survey1.q7_answer_customerInfo(getData_01.get(Constants.SinglePage.Q7_FULLNAMEINPUTTED.trim()),
				getData_01.get(Constants.SinglePage.Q7_BOOKINGNUMBERINPUTTED.trim()),
				getData_01.get(Constants.SinglePage.Q7_FLIGHTNUMBERINPUTTED.trim()),
				getData_01.get(Constants.SinglePage.Q7_FLIGHTDATEINPUTTED.trim()));
		survey1.q9_chooseYes();
		survey1.q10_clickKeep();
		survey1.click_Submit(action.driver);
		Assert.assertEquals(survey1.get_msg_successful(action.driver),
				getData_01.get(Constants.SinglePage.Successf_msg_EXPECTED.trim()));

	}

// Check required field
	@DataProvider(name = "testcase2")
	public Object[][] dptestcase2() {
		return dpPrepareData("testcase2");
	}

	@Test(dataProvider = "testcase2")
	public void testcase_2(HashMap<String, String> getData_01) throws Exception {
		System.out.println("Please answer this survey!");
		openNewTab(action.config.getProperty("APP_URL"));
		SinglePage survey1 = new SinglePage(action);
		survey1.click_Submit(action.driver);
		Assert.assertEquals(survey1.get_required_msg_q1(action.driver),
				getData_01.get(Constants.SinglePage.WARNING_MSG1_EXPECTED.trim()));
		Assert.assertEquals(survey1.get_required_msg_q3(action.driver),
				getData_01.get(Constants.SinglePage.WARNING_MSG1_EXPECTED.trim()));
		Assert.assertEquals(survey1.get_required_msg_q8(action.driver),
				getData_01.get(Constants.SinglePage.WARNING_MSG2_EXPECTED.trim()));

	}

}
