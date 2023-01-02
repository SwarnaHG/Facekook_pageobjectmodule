package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.base.TestBase;

public class SignUpPage  extends TestBase{
	@FindBy(xpath="//a[text()='Create New Account']")
	WebElement account;

	@FindBy(xpath="//input[@type='text'][@name='firstname']")
	WebElement firstName;

	@FindBy(xpath="//input[@type='text'][@name='lastname']")
	WebElement lastname;

	@FindBy(xpath="//input[@type='text'][@name='reg_email__']")
	WebElement mobileNumber;

	@FindBy(xpath="//input[@id='password_step_input'][@type='password']")
	WebElement password;


	@FindBy(xpath="//select[@title='Day']")
	WebElement day;


	@FindBy(xpath="//select[@title='Month']")
	WebElement month;

	@FindBy(xpath="//select[@title='Year']")
	WebElement year;

	@FindBy(xpath="//label[text()='Female']")
	WebElement female;

	@FindBy(xpath="//button[text()='Sign Up'][@type='submit'][@name='websubmit']")
	WebElement signUp;

	//initializing the page object
	public SignUpPage() {
	PageFactory.initElements(driver,this);
	}


	//Actions:
	public void signUp(String fname,String lname,String number,String pwd,String d,String m,String y) {
	account.click();
	firstName.sendKeys(fname);
	lastname.sendKeys(lname);
	mobileNumber.sendKeys(number);
	password.sendKeys(pwd);
	day.sendKeys(d);
	month.sendKeys(m);
	year.sendKeys(y);
	female.click();
	signUp.click();

	}


}
