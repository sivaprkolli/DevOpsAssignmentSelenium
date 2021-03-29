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
	public void loginAsUser() throws Exception {
		signUpPage.login(signUpPage.getUserName(), readPropertiesData.readPropertyValue("password"));
	}
	
	@Test
	public void verifyAccountServicesList() {
		List<String> expectedAccountServices = new ArrayList<String>();
		expectedAccountServices.add(TestConstants.OPEN_NEW_ACCOUNT);
		expectedAccountServices.add(TestConstants.ACCOUNTS_OVERVIEW);
		expectedAccountServices.add(TestConstants.TRANSFER_FUNDS);
		expectedAccountServices.add(TestConstants.BILL_PAY);
		expectedAccountServices.add(TestConstants.FIND_TRANSACTIONS);
		expectedAccountServices.add(TestConstants.UPDATE_CONTACT_INFO);
		expectedAccountServices.add(TestConstants.REQUEST_LOAN);
		expectedAccountServices.add(TestConstants.LOG_OUT);
		Assert.assertTrue(accountPage.getAccountServicesList().equals(expectedAccountServices));
	}	
	
	@Test 
	public void createNewAccount() {
		accountPage.naviagetToOpenNewAccount();
		openAccountPage.createAnAccount("Open New Account", TestConstants.SAVINGS);
		Assert.assertEquals(openAccountPage.getTextOpenAccountSuccessMessage("Account Opened!"), TestConstants.ACCOUNT_OPENED);
	}
}
