package com.automation.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.DevOpsAssignment.SeleniumActions;

public class HomePage {
	WebDriver driver;
	SeleniumActions actions;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new SeleniumActions(driver);
	}

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerLink;

	public void navigateToSignUpPage() {
		actions.clickOnElement(registerLink);
	}
}
