package com.automation.DevOpsAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.WebPages.HomePage;
import com.automation.WebPages.SignUpPage;

public class RegistrationTest extends TestBase{
	public HomePage homePage;
	public SignUpPage signUpPage;
	public ReadPropertiesData readPropertiesData;
	
	@BeforeClass
	public void initilizePages() {
		homePage = new HomePage(driver);
		signUpPage = new SignUpPage(driver);
		readPropertiesData = new ReadPropertiesData();
	}
	
	@Test
	public void verifyUserRegistration() throws Exception {
		homePage.acceptAlertOnHomePage();
		homePage.navigateToSignUpPage();
		int rn = CommonFunctions.randomNumber();
		signUpPage.userRegistration(
				readPropertiesData.readPropertyValue("firstName"),
				readPropertiesData.readPropertyValue("lastName"),
				readPropertiesData.readPropertyValue("address"),
				readPropertiesData.readPropertyValue("city"), 
				readPropertiesData.readPropertyValue("state"),
				readPropertiesData.readPropertyValue("zip"), 
				readPropertiesData.readPropertyValue("phone"), 
				readPropertiesData.readPropertyValue("ssn"), 
				readPropertiesData.readPropertyValue("firstName")+rn+readPropertiesData.readPropertyValue("lastName"),
				readPropertiesData.readPropertyValue("password"), 
				readPropertiesData.readPropertyValue("password"));
		Assert.assertEquals(signUpPage.getTextOfSuccessfullRegistration(), "Welcome " + readPropertiesData.readPropertyValue("firstName")+rn+readPropertiesData.readPropertyValue("lastName"));
	}
}
