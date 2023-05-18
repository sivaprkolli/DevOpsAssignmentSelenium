package com.automation.DevOpsAssignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	public WebDriverWait wdWait;
	public FluentWait<WebDriver> fWait;
	WebDriver driver;
	
	
	public Waits(WebDriver driver) {

		this.driver = driver;
		wdWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void waitForElementClickable(WebElement element) {
		wdWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForTextPresent(WebElement element, String data) {
		wdWait.until(ExpectedConditions.textToBePresentInElement(element, data));
	}
	
	public void waitForAlertExists() {
		wdWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void fluentWait(WebElement element) {
		 fWait = new FluentWait<WebDriver>(driver)
				.pollingEvery(Duration.ofSeconds(5))
				.withTimeout(Duration.ofSeconds(15))
				.withMessage("Wait message")
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		 fWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void fluentWaitForMultipleElements(List<WebElement> elements) {
		 fWait = new FluentWait<WebDriver>(driver)
					.pollingEvery(Duration.ofSeconds(5))
					.withTimeout(Duration.ofSeconds(15))
					.withMessage("Wait message")
					.ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class);
		 fWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
}
