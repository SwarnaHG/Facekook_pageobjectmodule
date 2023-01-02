package com.facebook.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebook.base.TestBase;
import com.facebook.pages.ForgotPasswordPage;
import com.facebook.pages.HomePage;
import com.facebook.pages.LoginPage;
import com.facebook.pages.SignUpPage;
import com.facebook.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	SignUpPage signUpPage;
	TestUtil testUtil;
	HomePage home;
	public  String sheetName = "Login_Data";

	public LoginPageTest() {
	super();
	}

	@BeforeMethod
	public void setUp() {
	initialization();

	loginPage = new LoginPage();
	signUpPage = new SignUpPage();
	testUtil = new TestUtil();
	//home = new HomePage();
	}

	@Test
	public void verifyTitle() {
	String title = driver.getTitle();
	System.out.println("title is" + title);
	}

	@Test
	@Description("it is a login details")
	@Feature("login feature")
	@Story("it contains login details username nad password")
	public void loginTest() {
		log.info("login is Running...");
		home = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	System.out.println("home is" +home);
	}

	@Test
	@Description("it is sign up details")
	@Feature("signup feature")
	@Story("it contains signup details username and password and other things")
	public void SignUpTest() {
	signUpPage.signUp(prop.getProperty("firstName"), prop.getProperty("lastName"), prop.getProperty("mobileNumber"),
	prop.getProperty("password"), prop.getProperty("day"), prop.getProperty("month"),
	prop.getProperty("year"));
	}

	@Test
	public void forgetPasswordTest() {
	ForgotPasswordPage page = new ForgotPasswordPage();
	page.forgotPassword();
	}

	@DataProvider
	public Object[][] getLoginTestData() {
	Object data[][] = testUtil.getTestData(sheetName);
	System.out.println(data);
	return data;
	}

	@Test(dataProvider = "getLoginTestData")
	public void multipleLoign(String username, String password) {
	loginPage.multiUser(username, password);
	}

	@AfterMethod
	public void down() {
	// driver.quit();
	}

}
