package com.automation.WebPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.DevOpsAssignment.SeleniumActions;
import com.automation.DevOpsAssignment.Waits;

public class AccountOverviewPage {
	WebDriver driver;
	SeleniumActions actions;
	Waits waits;
	
	public AccountOverviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;	
		actions = new SeleniumActions(driver);
		waits = new Waits(driver);
	}
	
	@FindBy(xpath = "//*[@href='/parabank/overview.htm']") WebElement accountOverviewLink;
	@FindBy(css = "#accountTable > tbody > tr[ng-repeat='account in accounts'] > td >a") List<WebElement> accountNumbers;
	@FindBy(css = "#accountTable > tbody > tr[ng-repeat='account in accounts'] > td") List<WebElement> numberOfRowsInTable;
	@FindBy(css = "#accountTable > thead > tr > th") List<WebElement> numberOfColumnsInTable;
	@FindBy(css = ".title") WebElement headingOfThePage;
	
	
	public void openAccountOverview() {
		actions.clickOnElement(accountOverviewLink);
	}
	
	public List<String> getAccountNumbers(){
		waits.fluentWaitForMultipleElements(accountNumbers);
		List<String> accountNumbersList = new ArrayList<String>(); 
		for(int i=0; i<accountNumbers.size(); i++) {
			accountNumbersList.add(accountNumbers.get(i).getText());
		}
		return accountNumbersList;
	}
	
	public List<String> getColumnsData(){
		List<String> columnData = new ArrayList<String>(); 
		for(int i=0; i<numberOfColumnsInTable.size(); i++) {
			columnData.add(numberOfColumnsInTable.get(i).getText());
		}
		return columnData;
	}
	
	public List<String> getRowsData(){
		List<String> columnData = new ArrayList<String>(); 
		for(int i=0; i<numberOfRowsInTable.size(); i++) {
			columnData.add(numberOfRowsInTable.get(i).getText());
		}
		return columnData;
	}
	
	public List<String> getRowWiseData(String accountNumber){
		List<String> rowWiseData = new ArrayList<String>();
		rowWiseData.add(driver.findElement(By.xpath("//*[@id='accountTable']/tbody/tr/td/a[text()='"+accountNumber+"']/../../td")).getText());
		return rowWiseData;
	}
	
	public String getHeadingOfAccountOverview() {
		return actions.getTextOfTheElement(headingOfThePage);
	}
}
