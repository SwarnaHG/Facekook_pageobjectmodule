package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.base.TestBase;

public class ForgotPasswordPage extends TestBase {
	LoginPage login = new LoginPage();

	@FindBy(xpath="//a[text()='Forgotten passwor']")
	WebElement forgetPassword;

	//Initializing the page objects
	public ForgotPasswordPage() {
	PageFactory.initElements(driver,this);
	}

	//actions
	public void forgotPassword() {
	//login.login("swarnahg18@gmail.com","Swarna@91139");
	forgetPassword.click();
	}

}
