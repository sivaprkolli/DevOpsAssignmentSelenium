package com.automation.WebPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.DevOpsAssignment.SeleniumActions;
import com.automation.DevOpsAssignment.Waits;

public class AccountPage {

	WebDriver driver;
	SeleniumActions actions;
	Waits waits;

	public AccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new SeleniumActions(driver);
		waits = new Waits(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='Account Services']")
	WebElement accountServicesLabel;
	
	@FindBy(css = "#leftPanel > ul > li")
	List<WebElement> accountServicesList;

	public List<String> getAccountServicesList() {
		waits.fluentWaitForMultipleElements(accountServicesList);
		List<String> accountServices = new ArrayList<String>();

		for (int i = 0; i < accountServicesList.size(); i++) {
			accountServices.add(accountServicesList.get(i).getText());
		}
		System.out.println("accountServices ========= " + accountServices);

		return accountServices;
	}

	public void naviagetToOpenNewAccount() {
		waits.fluentWaitForMultipleElements(accountServicesList);
		for (int i = 0; i < accountServicesList.size(); i++) {
			if (accountServicesList.get(i).getText().equals("Open New Account")) {
				actions.clickOnElement(accountServicesList.get(i));
			}
		}
	}

}
