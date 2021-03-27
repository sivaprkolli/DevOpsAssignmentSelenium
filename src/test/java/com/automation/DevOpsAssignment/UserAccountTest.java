package com.automation.DevOpsAssignment;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.automation.WebPages.AccountPage;
import com.automation.WebPages.OpenAccountPage;
import com.automation.WebPages.SignUpPage;

public class UserAccountTest extends TestBase{
	public AccountPage accountPage;
	public SignUpPage signUpPage;
	public OpenAccountPage openAccountPage;
	
	@BeforeClass
	public void initilizePages() {
		accountPage = new AccountPage(driver);
		signUpPage = new SignUpPage(driver);
		openAccountPage = new OpenAccountPage(driver);
	}
	
	//@BeforeClass
	public void loginAsUser() {
		signUpPage.login("Selenium778Automation", "selenium");
	}
	
	@Test
	public void verifyAccountServicesList() {
		List<String> expectedAccountServices = new ArrayList<String>();
		expectedAccountServices.add("Open New Account");
		expectedAccountServices.add("Accounts Overview");
		expectedAccountServices.add("Transfer Funds");
		expectedAccountServices.add("Bill Pay");
		expectedAccountServices.add("Find Transactions");
		expectedAccountServices.add("Update Contact Info");
		expectedAccountServices.add("Request Loan");
		expectedAccountServices.add("Log Out");
		Assert.assertTrue(accountPage.getAccountServicesList().equals(expectedAccountServices));
	}	
	
	@Test 
	public void createNewAccount() {
		accountPage.naviagetToOpenNewAccount();
		openAccountPage.createAnAccount("Open New Account", "SAVINGS");
		Assert.assertEquals(openAccountPage.getTextOpenAccountSuccessMessage("Account Opened!"), "Account Opened!");
	}
}
