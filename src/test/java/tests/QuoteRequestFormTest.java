package tests;

import java.util.Map;

import org.testng.annotations.Test;

import core.BaseTest;
import core.CsvDataProvider;

public class QuoteRequestFormTest extends BaseTest{

	@Test (dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
	public void testFieldsValidation (Map <String, String> testData){
		
	}
}
