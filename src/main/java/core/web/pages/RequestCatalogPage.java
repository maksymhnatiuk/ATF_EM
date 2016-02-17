package core.web.pages;

import org.openqa.selenium.WebDriver;

import core.web.WebPage;

public class RequestCatalogPage extends WebPage<RequestCatalogPage>{

	private static final String PAGE_URL = BASE_URL + "/request-quote/";
	
	public RequestCatalogPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public RequestCatalogPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		
		return false;
	}
	
	

}
