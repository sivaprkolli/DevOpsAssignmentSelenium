package com.automation.DevOpsAssignment;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumActions {
	public Waits waits;
	public WebDriver driver;

	public SeleniumActions(WebDriver driver) {
		waits = new Waits(driver);
		this.driver = driver;
	}

	public void clickOnElement(WebElement element) {
		try {
			waits.waitForElementClickable(element);
			element.click();
		} catch (NoSuchElementException ne) {
			ne.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jsClickOnElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		try {
			waits.waitForElementClickable(element);
			jse.executeScript("arguments[0].click()", element);

		} catch (NoSuchElementException ne) {
			ne.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void typeValueInTextbox(WebElement element, String data) {
		try {
			waits.waitForElementClickable(element);
			element.sendKeys(data);
		} catch (NoSuchElementException ne) {
			ne.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectValueFromTheDropDownUsingVisibleText(WebElement element, String data) {
		try {
			Select selectValueFromDropDown = new Select(element);
			selectValueFromDropDown.selectByVisibleText(data);
		} catch (NoSuchElementException ne) {
			ne.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveToElementAndClickOnElement(WebElement sourceElement, WebElement destinationElement) {
		waits.waitForElementClickable(sourceElement);
		Actions mouseACtions = new Actions(driver);
		mouseACtions.moveToElement(sourceElement).build().perform();
		mouseACtions.moveToElement(destinationElement).click().build().perform();
	}
	
	public void moveToElementOnly(WebElement element) {
		waits.waitForElementClickable(element);
		Actions mouseACtions = new Actions(driver);
		mouseACtions.moveToElement(element).build().perform();
	}

}
