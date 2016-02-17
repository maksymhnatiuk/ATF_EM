package core.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.web.WebPage;
import core.web.elements.Button;
import core.web.elements.CheckBox;
import core.web.elements.DropDown;
import core.web.elements.Radio;
import core.web.elements.TextInput;

public class RequestInfoPage extends WebPage<RequestInfoPage>{

	private static final String PAGE_URL = BASE_URL + "/request-info/";
	
	public String nameInputValue;
	public String companyInputValue;
	public String addressInputValue;
	public String cityInputValue;
	public String zipInputValue;
	public String stateDropDownValue;
	public String phoneInputValue;
	public String emailInputValue;
	public String sportDropDownValue;
	public String modelDropDownValue;
	public String colorDropDownValue;
	public String hardWiredDataCableRadioValue;
	public String scoreLinkWirelessRFRadioValue;
	public String carryingCaseCheckBoxValue;
	public String sponsorPanelCheckBoxValue;
	public String additionalInformationInputValue;
	
	public RequestInfoPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public RequestInfoPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		
		return getNameInput().isAvailable() &&
				getCompanyInput().isAvailable() &&
				getAddressInput().isAvailable() &&
				getCityInput().isAvailable() &&
				getZipInput().isAvailable() &&
				getStateDropDown().isAvailable() &&
				getPhoneInput().isAvailable() &&
				getEmailInput().isAvailable() &&
				getSportDropDown().isAvailable() &&
				getModelDropDown().isAvailable() &&
				getColorDropDown().isAvailable() &&
				getHardWiredDataCableRadio().isAvailable() &&
				getScoreLinkWirelessRFRadio().isAvailable() &&
				getCarryingCaseCheckBox().isAvailable() &&
				getSponsorPanelCheckBox().isAvailable() &&
				getAdditionalInformationInput().isAvailable() &&
				getAQuotebtn().isAvailable();
	}
	
	public RequestInfoPage fillRequestInfoForm (String name, String company, String address, String city, String zip,
												String state, String phone, String email, String sport, String model,
												String color, String setHardWiredDataCableRadio, String setScoreLinkWirelessRFRadio, 
												String setCarryingCaseCheckBox, String setSponsorPanelCheckBox, String info){
		getNameInput().inputText(name);
		getCompanyInput().inputText(company);
		getAddressInput().inputText(address);
		getCityInput().inputText(city);
		getZipInput().inputText(zip);
		getStateDropDown().selectByVisibleText(state);
		getPhoneInput().inputText(phone);
		getEmailInput().inputText(email);
		getSportDropDown().selectByVisibleText(sport);
		getModelDropDown().selectByVisibleText(model);
		getColorDropDown().selectByVisibleText(color);
		if (setHardWiredDataCableRadio == "1"){getHardWiredDataCableRadio().click();}
		if (setScoreLinkWirelessRFRadio == "1") {getScoreLinkWirelessRFRadio().click();}
		if (setCarryingCaseCheckBox == "1") {getCarryingCaseCheckBox().click();}
		if (setSponsorPanelCheckBox == "1") {getSponsorPanelCheckBox().click();}
		getAdditionalInformationInput().inputText(info);
		setCurrentlyEnteredValues(name, company, address, city, zip, state, phone, email, sport, model, color, 
								setHardWiredDataCableRadio, setScoreLinkWirelessRFRadio, setCarryingCaseCheckBox, 
								setSponsorPanelCheckBox, info);
		return this;
	}
	
	public RequestInfoPage snapShotCurrentFormValues (){
		String hardWiredDataCableRadio;
		String scoreLinkWirelessRFRadio;
		String carryingCaseCheckBox;
		String sponsorPanelCheckBox;
		
		if (getHardWiredDataCableRadio().isSelected()){
			hardWiredDataCableRadio = "1";
		} else {hardWiredDataCableRadio = "0";
		}
		if (getScoreLinkWirelessRFRadio().isSelected()) {
			scoreLinkWirelessRFRadio = "1";
		} else {
			scoreLinkWirelessRFRadio = "0";
		}
		if (getCarryingCaseCheckBox().isSelected()) {
			carryingCaseCheckBox = "1";
		} else {
			carryingCaseCheckBox = "0";
		}
		if (getSponsorPanelCheckBox().isSelected()) {
			sponsorPanelCheckBox = "1";
		} else {
			sponsorPanelCheckBox = "0";
		}
		setCurrentlyEnteredValues(
				getNameInput().getText(), 
				getCompanyInput().getText(), 
				getAddressInput().getText(), 
				getCityInput().getText(), 
				getZipInput().getText(), 
				getStateDropDown().getText(),
				getPhoneInput().getText(), 
				getEmailInput().getText(), 
				getSportDropDown().getText(), 
				getModelDropDown().getText(), 
				getColorDropDown().getText(), 
				hardWiredDataCableRadio, 
				scoreLinkWirelessRFRadio, 
				carryingCaseCheckBox, 
				sponsorPanelCheckBox, 
				getAdditionalInformationInput().getText());
		return this;
	}
	
	public RequestInfoPage submitFormExpectingError(){
		getAQuotebtn().click();
		return this;
	}
	
	public void submitForm(){
		getAQuotebtn().click();
	}
	
	private TextInput getNameInput(){
		return new TextInput(driver, By.name("name"));
	}
	
	private TextInput getCompanyInput(){
		return new TextInput(driver, By.name("company"));
	}
	
	private TextInput getAddressInput(){
		return new TextInput(driver, By.name("address"));
	}
	
	private TextInput getCityInput(){
		return new TextInput(driver, By.name("city"));
	}
	
	private TextInput getZipInput(){
		return new TextInput(driver, By.name("zip"));
	}
	
	private DropDown getStateDropDown(){
		return new DropDown(driver, By.name("state"));
	}
	
	private TextInput getPhoneInput(){
		return new TextInput(driver, By.name("phone"));
	}
	
	private TextInput getEmailInput (){
		return new TextInput(driver, By.name("email"));
	}
	
	private DropDown getSportDropDown (){
		return new DropDown(driver, By.name("sport"));
	}
	
	private DropDown getModelDropDown (){
		return new DropDown(driver, By.name("model"));
	}
	
	private DropDown getColorDropDown (){
		return new DropDown(driver, By.name("color"));
	}
	
	private Radio getHardWiredDataCableRadio (){
		return new Radio(driver, By.xpath("(//input[@name='communication_system'])[1]"));
	} 
	
	private Radio getScoreLinkWirelessRFRadio(){
		return new Radio(driver, By.xpath("(//input[@name='communication_system'])[2]"));
	} 
	
	private CheckBox getCarryingCaseCheckBox (){
		return new CheckBox(driver, By.name("carrying_case"));
	}
	
	private CheckBox getSponsorPanelCheckBox(){
		return new CheckBox(driver, By.name("sponsor_panel"));
	}
	
	private TextInput getAdditionalInformationInput (){
		return new TextInput(driver, By.name("additional_information"));
	}
	
	private Button getAQuotebtn (){
		return new Button(driver, By.xpath("//input[@value='Click to Get a Quote']"));
	}
	
	private void setCurrentlyEnteredValues(String name, String company, String address, String city, String zip,
			String state, String phone, String email, String sport, String model,
			String color, String setHardWiredDataCableRadio, String setScoreLinkWirelessRFRadio, 
			String setCarryingCaseCheckBox, String setSponsorPanelCheckBox, String info){
		nameInputValue = name;
		companyInputValue = company;
		addressInputValue = address;
		cityInputValue = city;
		zipInputValue = zip;
		stateDropDownValue = state;
		phoneInputValue = phone;
		emailInputValue = email;
		sportDropDownValue = sport;
		modelDropDownValue = model;
		colorDropDownValue = color;
		hardWiredDataCableRadioValue = setHardWiredDataCableRadio;
		scoreLinkWirelessRFRadioValue = setScoreLinkWirelessRFRadio;
		carryingCaseCheckBoxValue = setCarryingCaseCheckBox;
		sponsorPanelCheckBoxValue = setSponsorPanelCheckBox;
		additionalInformationInputValue = info;
	}

}
