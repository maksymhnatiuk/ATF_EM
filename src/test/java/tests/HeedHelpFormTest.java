package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.BaseTest;
import core.CsvDataProvider;
import core.web.elements.AlertPopUp;
import core.web.pages.NeedHelpPage;
import core.web.pages.RequestInfoPage;

public class HeedHelpFormTest extends BaseTest {
	
	private NeedHelpPage needHelpPage;
	
	@BeforeTest
	public void setUp(){
		needHelpPage = new NeedHelpPage(driver).load();
		needHelpPage.waitUntilAvailable();
	}
	
	//check validation of fields on the Need Help Form (DDT)
	@Test (dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
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
	
	@Test
	public void testSendNeedHelpForm(){
		//fill the form with correct data and send it to the server (test GIT conflict)
		NeedHelpPage needHelpForm = new NeedHelpPage(driver).load();
		needHelpForm.waitUntilAvailable();
		needHelpForm.fillHeedHelpForm(
					"AUTO_TEST name (NH)", 
					"AUTO_TEST email (NH)", 
					"AUTO_TEST phone (NH)", 
					"Soccer", 
					"California", 
					"AUTO_TEST question (NH)");
		RequestInfoPage requestInfoPage = needHelpForm.clickRequestMoreInfoBtn();
		requestInfoPage.loadAndWaitUntilAvailable();
	}
	
}
