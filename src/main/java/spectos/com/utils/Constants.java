package spectos.com.utils;

public class Constants {
	public static String SHEET_SINGLEPAGE = "SinglePage";
	public static int WAIT_TIME = 5000; // 5s

	public class SinglePage {
		public static final String SHEET_SINGLE_PAGE = "SinglePage";

	// Element's location
		public static final String Q1_TITLE_EXPECTED = "title_question";
		public static final String Q1_LABEL_1STAR_EXPECTED = "1star";
		public static final String Q1_LABEL_2STAR_EXPECTED = "2star";
		public static final String Q1_LABEL_3STAR_EXPECTED = "3star";
		public static final String Q1_LABEL_4STAR_EXPECTED = "4star";
		public static final String Q1_LABEL_5STAR_EXPECTED = "5star";

		public static final String Q1_TITLE = "title_question_1";
		public static final String Q1_1STAR = "_q1_5star_1st";
		public static final String Q1_2STAR = "_q1_5star_2nd";
		public static final String Q1_3STAR = "_q1_5star_3rd";
		public static final String Q1_4STAR = "_q1_5star_4th";
		public static final String Q1_5STAR = "_q1_5star_5th";
		public static final String Q1_CUSTOMER_LABELS = "_q1_5star_customer_labels";
		
		public static final String Q2_TITLE_EXPECTED = "title_question";
		public static final String Q2_TEXTAREA_INPUT = "input_text";
		
		public static final String Q2_TITLE = "title_question_2";
		public static final String Q2_TEXTAREA = "_q2_comment_textarea";
		
		public static final String Q3_TITLE_EXPECTED = "title_question";
		public static final String Q3_OPTION1_EXPECTED = "option1";
		public static final String Q3_OPTION2_EXPECTED = "option2";
		
		public static final String Q3_TITLE = "title_question_3";
		public static final String Q3_OPTION1 = "_q3_single_option1";
		public static final String Q3_OPTION2 = "_q3_single_option2";
				
		public static final String Q4_TITLE_EXPECTED = "title_question";
		public static final String Q4_OPTION1_EXPECTED = "option1";
		public static final String Q4_OPTION2_EXPECTED = "option2";
		public static final String Q4_OPTION3_EXPECTED = "option3";
		public static final String Q4_OPTION4_EXPECTED = "option4";

		public static final String Q4_TITLE = "title_question_4";
		public static final String Q4_OPTION1 = "_q4_multi_option1";
		public static final String Q4_OPTION2 = "_q4_multi_option2";
		public static final String Q4_OPTION3 = "_q4_multi_option3";
		public static final String Q4_OPTION4 = "_q4_multi_option4";	
		
		public static final String Q5_TITLE_EXPECTED = "title_question";
		public static final String Q5_TITLE = "title_question_5";
		public static final String Q5_OPTION1 = "_q5_rating_1point";
		public static final String Q5_OPTION2 = "_q5_rating_2point";
		public static final String Q5_OPTION3 = "_q5_rating_3point";
		public static final String Q5_OPTION4 = "_q5_rating_4point";
		public static final String Q5_OPTION5 = "_q5_rating_5point";
		public static final String Q5_OPTION6 = "_q5_rating_6point";
		public static final String Q5_OPTION7 = "_q5_rating_7point";
		public static final String Q5_OPTION8 = "_q5_rating_8point";
		public static final String Q5_OPTION9 = "_q5_rating_9point";
		public static final String Q5_OPTION10 = "_q5_rating_10point";
		public static final String Q5_OPTION11 = "_q5_rating_dontknow";
		
		public static final String Q5_SUBTITLE_EXPECTED = "title_question";
		public static final String Q5_TEXTAREA_INPUTTED = "input_text";
		
		public static final String Q5_SUBTITLE = "q5_subquestion_title";
		public static final String Q5_TEXTAREA = "q5_subquestion_textarea";
	

		public static final String Q6_TITLE_EXPECTED = "title_question";
		public static final String Q6_TITLE = "title_question_6";		
		public static final String Q6_0POINT = "_q6_NPS_0point";
		public static final String Q6_1POINT = "_q6_NPS_1point";
		public static final String Q6_2POINT = "_q6_NPS_2point";
		public static final String Q6_3POINT = "_q6_NPS_3point";
		public static final String Q6_4POINT = "_q6_NPS_4point";
		public static final String Q6_5POINT = "_q6_NPS_5point";
		public static final String Q6_6POINT = "_q6_NPS_6point";
		public static final String Q6_7POINT = "_q6_NPS_7point";
		public static final String Q6_8POINT = "_q6_NPS_8point";
		public static final String Q6_9POINT = "_q6_NPS_9point";
		public static final String Q6_10POINT = "_q6_NPS_10point";
		
		public static final String Q7_TITLE_INPUTTED = "title_question";
		public static final String Q7_FULLNAME_INPUTTED = "fullname";
		public static final String Q7_BOOKINGNUMBER_INPUTTED = "bookingnumber";
		public static final String Q7_FLIGHTNUMBER_INPUTTED = "flightnumber";
		public static final String Q7_FLIGHTDATE_INPUTTED = "flightdate";
		
		public static final String Q7_TITLE = "title_question_7";		
		public static final String Q7_FULLNAME = "_q7_customer_fullname";
		public static final String Q7_BOOKINGNUMBER = "_q7_customer_bookingnumber";
		public static final String Q7_FLIGHTNUMBER = "_q7_customer_flightnumber";
		public static final String Q7_FLIGHTDATE = "_q7_customer_flightdate";
		
		
		public static final String Q8_TITLE = "title_question_8";		
		public static final String Q8_TAKEPHOTO = "_q8_attachfile_takephoto";
		public static final String Q8_RECORDVIDEO = "_q8_attachfile_recordvideo";
		public static final String Q8_UPLOAD = "_q8_attachfile_upload";
		
		public static final String Q9_TITLE_EXPECTED = "title_question";
		
		public static final String Q9_TITLE = "title_question_9";		
		public static final String Q9_YES = "_q9_yesno_yes";
		public static final String Q9_NO = "_q9_yesno_no";
		
		public static final String Q10_TITLE_EXPECTED = "title_question";
		public static final String Q10_NOTETEXT_EXPECTED = "note_text";
		
		public static final String Q10_TITLE = "title_question_10";		
		public static final String Q10_KEEPCURRENTSORTING = "_q10_sorting_keepcurrentsorting";
		public static final String Q10_NOTETEXT = "_q10_notetext";		
		public static final String Q10_LOCATION_1ST = "_q10_location_1st";
		public static final String Q10_LOCATION_2ND = "_q10_location_2nd";
		public static final String Q10_LOCATION_3RD = "_q10_location_3rd";
		public static final String Q10_LOCATION_4TH = "_q10_location_4th";
		public static final String Q10_LOCATION_5TH = "_q10_location_5th";
		
		
		
		
		
		
		
		public static final String Q11_TITLE_EXPECTED = "title_question";
		public static final String Q11_TITLE = "title_question_11";		
		public static final String Q11_GETLOCATION = "_q11_getLocation";
		public static final String Q11_msg_get_location_success = "msg_get_location_success";
		public static final String Q11_msg_get_location_expected = "msgGetLocation";
		
		
		

		
		public static final String SUBMIT_BTN = "submit_btn";
		
		public static final String WARNING_MSG1_EXPECTED = "required_msg_q1_3";
		public static final String WARNING_MSG2_EXPECTED = "required_msg_q8";		
		
		public static final String WARNING_REQUIRED_QUESTION1 = "required_msg_q1";
		public static final String WARNING_REQUIRED_QUESTION3 = "required_msg_q2";	
		public static final String WARNING_REQUIRED_QUESTION8 = "required_msg_q3";
		
		public static final String Successf_msg_EXPECTED = "msg";
		
		public static final String Successf_msg = "msg_sent_success";
		
		
		
	// Data TC1
		
		public static final String Q2_TEXTAREAINPUT = "q2";
		public static final String Q5_TEXTAREAINPUTTED = "q5_1";
		public static final String Q7_FULLNAMEINPUTTED = "q7_1";
		public static final String Q7_BOOKINGNUMBERINPUTTED = "q7_2";
		public static final String Q7_FLIGHTNUMBERINPUTTED = "q7_3";
		public static final String Q7_FLIGHTDATEINPUTTED = "q7_4";
		
	}

}
