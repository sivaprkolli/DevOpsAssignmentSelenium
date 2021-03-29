package com.automation.DevOpsAssignment;


import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.WebPages.AccountOverviewPage;
import com.automation.WebPages.OpenAccountPage;

public class AccountOverviewTest extends TestBase {
	public AccountOverviewPage accountOverviewPage;
	public OpenAccountPage openAccountPage;
	
	@BeforeClass
	public void initializePages() {
		accountOverviewPage = new AccountOverviewPage(driver);
		openAccountPage = new OpenAccountPage(driver);
	}
	
	@Test
	public void verifyAccountOverview() {
		String newAccountNumber = openAccountPage.getNewAccountNumber();
		accountOverviewPage.openAccountOverview();
		List<String> allAccountNumbers = accountOverviewPage.getAccountNumbers();
		Assert.assertTrue(allAccountNumbers.contains(newAccountNumber));
	}
	
	@Test
	public void verifyTableDataAndPrintOnConsole() {
		List<String> columnData = accountOverviewPage.getColumnsData();
		List<String> rowsData = accountOverviewPage.getRowsData();
		List<String> accountNumbers = accountOverviewPage.getAccountNumbers();
		
		List<List<String>> table = new ArrayList<>();
		
		table.add(columnData);
		for(int i=0; i< accountNumbers.size(); i++) {
			table.add(accountOverviewPage.getRowWiseData(accountNumbers.get(i)));
		}
		
		System.out.println("================================================");
		System.out.println(table);
		
		//System.out.println(CommonFunctions.formatAsTable(table));
	}

	@Test
	public void verifyAccountOverviewHeading() {
		String heading = accountOverviewPage.getHeadingOfAccountOverview();
		Assert.assertEquals(heading, "Account Overview");
	}
}
