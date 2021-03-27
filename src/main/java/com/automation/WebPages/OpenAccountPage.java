package com.automation.WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.DevOpsAssignment.SeleniumActions;
import com.automation.DevOpsAssignment.Waits;

public class OpenAccountPage {
	WebDriver driver;
	SeleniumActions actions;
	Waits waits;
	
	public OpenAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;	
		actions = new SeleniumActions(driver);
		waits = new Waits(driver);
	}
	
	@FindBy(xpath = "//select[@id='type']") WebElement accountTypesDropDown;
	//@FindBy(css = "input.button") WebElement openNewAccountButton;
	@FindBy(xpath = "//div/h1") WebElement accountOpenSUccessMessage;
	
	@FindAll({
		@FindBy(css = "input.button"),
		@FindBy(xpath = "//input[@type='submit']"),
		@FindBy(xpath = "//input[@value='Open New Account']")
		
	}) WebElement openNewAccountButton; 
	
	
	public void createAnAccount(String openNewAccount, String account) {
		waits.fluentWait(accountTypesDropDown);
		actions.selectValueFromTheDropDownUsingVisibleText(accountTypesDropDown, account); 
		
		//actions.jsClickOnElement(openNewAccountButton);
		actions.moveToElementOnly(openNewAccountButton);
		actions.clickOnElement(openNewAccountButton);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.findElements(By.cssSelector("input.button")).size() > 0) {
			System.out.println("Open Account button still found");
			openNewAccountButton.click();
		}
	}
	
	public String getTextOpenAccountSuccessMessage(String data) {
		waits.waitForTextPresent(accountOpenSUccessMessage, data);
		return accountOpenSUccessMessage.getText();
	}
}
