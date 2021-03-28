package com.automation.DevOpsAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.WebPages.HomePage;
import com.automation.WebPages.SignUpPage;

public class RegistrationTest extends TestBase{
	public HomePage homePage;
	public SignUpPage signUpPage;
	
	@BeforeClass
	public void initilizePages() {
		homePage = new HomePage(driver);
		signUpPage = new SignUpPage(driver);
	}
	
	@Test
	public void verifyUserRegistration() {
		homePage.acceptAlertOnHomePage();
		homePage.navigateToSignUpPage();
		int rn = CommonFunctions.randomNumber();
		signUpPage.userRegistration("Siva", "Test", "Hyderabad", "Hyderabad", "TG", "500072", "123456789", "123456789", "Siva"+rn+"Automation", "selenium", "selenium");
		AssertJUnit.assertEquals(signUpPage.getTextOfSuccessfullRegistration(), "Welcome Siva"+rn+"Automation");
	}
}
