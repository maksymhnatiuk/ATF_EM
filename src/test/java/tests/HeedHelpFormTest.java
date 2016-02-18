package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.BaseTest;
import core.CsvDataProvider;
import core.web.elements.AlertPopUp;
import core.web.pages.NeedHelpPage;
import core.web.pages.RequestInfoPage;

public class HeedHelpFormTest extends BaseTest {
	
	private NeedHelpPage needHelpPage;
	
	@BeforeMethod (alwaysRun = true, description = "Create and load new NeedHelpPage")
	public void setUp(){
		needHelpPage = new NeedHelpPage(driver).load();
		needHelpPage.waitUntilAvailable();
	}
	
	//check validation of fields on the Need Help Form (DDT)
	@Test (groups = {"validation"},
			priority = 0,
			dataProvider = "CsvDataProvider", 
			dataProviderClass = CsvDataProvider.class, 
			description = "check validation of fields on the Need Help Form (DDT)")
	public void testFieldsValidation(Map<String, String> testData) {
		needHelpPage.fillHeedHelpForm(
	    			testData.get("name"), 
	    			testData.get("email"), 
	    			testData.get("phone"), 
	    			testData.get("sport"), 
	    			testData.get("state"), 
	    			testData.get("question"));
		needHelpPage.submitFormExpectingError();
	    String allertText = new AlertPopUp(driver).closeAlertAndGetItsText();
	    assertThat("Allert error message should be as expected", allertText, is(equalTo(testData.get("error_message"))));
	}
	
	@Test (groups = {"smoke"},
			priority = 1,
			description = "fill the Need Help Form and send it to the server. After redirect to the InfoRequestPage - assert previouselly entered values")
	public void testSendNeedHelpForm(){
		//fill the form with correct data and send it to the server (test GIT conflict)
		needHelpPage.fillHeedHelpForm(
					"AUTO_TEST name (NH)", 
					"AUTO_TEST-email-NH@mail.com", 
					"1234567890", 
					"Soccer", 
					"California", 
					"AUTO_TEST question (NH)");
		
		needHelpPage.clickRequestMoreInfoBtn();
		RequestInfoPage requestInfoPage = new RequestInfoPage(driver).waitUntilAvailable();
		requestInfoPage.snapShotCurrentFormValues();
		assertThat("Value of the Name field on the RequestInfoPage should be as expected: ", 
					needHelpPage.nameInputValue, is(equalTo(requestInfoPage.nameInputValue)));
		assertThat("Value of the Email field on the RequestInfoPage should be as expected: ", 
					needHelpPage.emailInputValue, is(equalTo(requestInfoPage.emailInputValue)));
		assertThat("Value of the Sport field on the RequestInfoPage should be as expected: ", 
					needHelpPage.sportDropValue, is(equalTo(requestInfoPage.sportDropDownValue)));
		assertThat("Value of the State field on the RequestInfoPage should be as expected: ", 
					needHelpPage.stateDropValue, is(equalTo(requestInfoPage.stateDropDownValue)));
		assertThat("Value of the Additional Information field on the RequestInfoPage should be as expected: ", 
					needHelpPage.questionInputValue, is(equalTo(requestInfoPage.additionalInformationInputValue)));
	}
	
}
