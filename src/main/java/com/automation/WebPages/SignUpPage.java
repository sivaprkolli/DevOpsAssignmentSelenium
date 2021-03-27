package com.automation.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.DevOpsAssignment.SeleniumActions;
import com.automation.DevOpsAssignment.Waits;

public class SignUpPage {
	WebDriver driver;
	SeleniumActions actions;
	Waits waits;
	
	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;	
		actions = new SeleniumActions(driver);
		waits = new Waits(driver);
	}
	
	@FindBy(id = "customer.firstName") WebElement firstNameInput;
	@FindBy(id = "customer.lastName") WebElement lastNameInput;
	@FindBy(id = "customer.address.street") WebElement addressInput;
	@FindBy(id = "customer.address.city") WebElement cityInput;
	@FindBy(id = "customer.address.state") WebElement stateInput;
	@FindBy(id = "customer.address.zipCode") WebElement zipCodeInput;
	@FindBy(css = "input[name='customer.phoneNumber']") WebElement phoneNumberInput;
	@FindBy(xpath = "//input[@id='customer.ssn']") WebElement ssnNumberInput;
	@FindBy(name = "customer.username") WebElement userNameInput;
	@FindBy(name = "customer.password") WebElement passwordInput;
	@FindBy(name = "repeatedPassword") WebElement confirmPasswordInput;
	@FindBy(css = "td input.button") WebElement registerButton;
	@FindBy(css = ".title") WebElement successfulRegistrationMessage;
	@FindBy(name = "username") WebElement userNameLoginInput;
	@FindBy(name = "password") WebElement passwordLoginInput;
	
	public void userRegistration(String firstName, String lastname, String address, String city, String state, String zip, String phone, String ssn, String userName, String password, String cPassword) {
		waits.fluentWait(firstNameInput);
		actions.typeValueInTextbox(firstNameInput, firstName);
		actions.typeValueInTextbox(lastNameInput, lastname);
		actions.typeValueInTextbox(addressInput, address);
		actions.typeValueInTextbox(cityInput, city);
		actions.typeValueInTextbox(stateInput, state);
		actions.typeValueInTextbox(zipCodeInput, zip);
		actions.typeValueInTextbox(phoneNumberInput, phone);
		
		actions.typeValueInTextbox(ssnNumberInput, ssn);
		actions.typeValueInTextbox(userNameInput, userName);
		actions.typeValueInTextbox(passwordInput, password);
		actions.typeValueInTextbox(confirmPasswordInput, cPassword);
		actions.clickOnElement(registerButton);
	}
	
	public String getTextOfSuccessfullRegistration() {
		return successfulRegistrationMessage.getText();
	}
	
	public void login(String un, String pwd) {
		actions.typeValueInTextbox(userNameLoginInput, un);
		actions.typeValueInTextbox(passwordLoginInput, pwd);
		passwordLoginInput.submit();
	}
	
}
