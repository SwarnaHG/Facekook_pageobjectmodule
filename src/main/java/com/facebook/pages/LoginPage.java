package com.facebook.pages;

import com.facebook.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase  {
	//@FindBy(xpath= "//input[@id='email']")
	@FindBy(xpath="//input[@id='email']")
	WebElement email;


	@FindBy(xpath="//input[@type='password'][@name='pass']")
	WebElement password;

	@FindBy(xpath="//button[text()='Log in']")
	WebElement login;

	@FindBy(linkText="Forgotten password?")
	WebElement click;

	//Initializing the page objects
	//public LoginPage() {
	//PageFactory.initElements(driver,this);
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions:
	public HomePage login(String name,String psd) {
	email.sendKeys(name);
	password.sendKeys(psd);
	login.click();

	return new HomePage();

	}

	public void multiUser(String name,String psd) {
	email.sendKeys(name);
	password.sendKeys(psd);
	login.click();

	//return ();
	}

}
