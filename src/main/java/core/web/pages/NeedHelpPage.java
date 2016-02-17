package core.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.lang.System;

import core.web.WebPage;
import core.web.elements.Button;
import core.web.elements.DropDown;
import core.web.elements.TextInput;

public class NeedHelpPage extends WebPage<NeedHelpPage>{

	private static final String PAGE_URL = BASE_URL + "/";
	
	
	public NeedHelpPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public NeedHelpPage load() {
		System.out.println(PAGE_URL);
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		
		return getNameInput().isAvailable() &&
				getEmailInput().isAvailable() &&
				getQuestionInput().isAvailable() &&
				getSportDropDown().isAvailable() &&
				getStateDropDown().isAvailable() &&
				getRequestMoreInfoBtn().isAvailable() &&
				getRequestCatalogBtn().isAvailable();
	}
	
	public NeedHelpPage fillHeedHelpForm (String name, String email, String phone, String sport, String state, String question){
		fillNameInput(name);
		fillEmailInput(email);
		fillPhoneInput(phone);
		fillSportDrop(sport);
		fillStateDrop(state);
		fillQuestionInput(question);
		return this;
	}
	
	public void fillNameInput(String text){
		getNameInput().inputClear();
		getNameInput().inputText(text);
	}
	
	public void fillEmailInput(String text){
		getEmailInput().inputClear();
		getEmailInput().inputText(text);
	}
	
	public void fillPhoneInput(String text){
		getPhoneInput().inputClear();
		getPhoneInput().inputText(text);
	}
	
	public void fillSportDrop(String text){
		try {
			getSportDropDown().selectByVisibleText(text);
		} catch (Exception e) {
			e = new Exception("The Sport drop-down has no value: " + text);
		}
	}
	
	public void fillStateDrop(String text){
		try {
			getStateDropDown().selectByVisibleText(text);
		} catch (Exception e) {
			e = new Exception("The State drop-down has no value: " + text);
		}
	}
	
	public void fillQuestionInput(String text){
		getQuestionInput().inputClear();
		getQuestionInput().inputText(text);
	}
	
	public NeedHelpPage submitFormExpectingError (){
		getRequestMoreInfoBtn().click();
		return this;
	}
	
	public RequestInfoPage clickRequestMoreInfoBtn(){
		getRequestMoreInfoBtn().click();
		return new RequestInfoPage(driver);
	}
	
	public RequestCatalogPage clickRequestCatalogBtn (){
		getRequestCatalogBtn().click();
		return new RequestCatalogPage(driver);
	}
	
	private TextInput getNameInput (){
		return new TextInput(driver, By.name("name"));
	}
	
	private TextInput getEmailInput (){
		return new TextInput(driver, By.name("email"));
	}
	
	private TextInput getPhoneInput(){
		return new TextInput(driver, By.name("phone"));
	}
	
	private DropDown getSportDropDown (){
		return new DropDown(driver, By.name("sport"));
	}
	
	private DropDown getStateDropDown (){
		return new DropDown(driver, By.name("state"));
	}
	
	private TextInput getQuestionInput (){
		return new TextInput(driver, By.name("question"));
	}
	
	private Button getRequestMoreInfoBtn (){
		return new Button(driver, By.id("quote-button"));
	}
	
	private Button getRequestCatalogBtn(){
		return new Button(driver, By.id("request-catalog-button"));
	}
	
}
