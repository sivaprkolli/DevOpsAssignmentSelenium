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
	public WebDriverWait wait;
	public FluentWait<WebDriver> fWait;
	WebDriver driver;
	
	
	public Waits(WebDriver driver) {
		wait = new WebDriverWait(driver, 20);
		this.driver = driver;
	}
	
	public void waitForElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForTextPresent(WebElement element, String data) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, data));
	}
	
	public void waitForAlertExists() {
		wait.until(ExpectedConditions.alertIsPresent());
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
