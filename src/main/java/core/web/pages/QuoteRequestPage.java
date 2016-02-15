package core.web.pages;

import org.openqa.selenium.WebDriver;

import core.web.WebPage;

public class QuoteRequestPage extends WebPage<QuoteRequestPage>{

	private static final String PAGE_URL = BASE_URL + "/request-quote/";
	
	public QuoteRequestPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public QuoteRequestPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		
		return false;
	}
	
	

}
