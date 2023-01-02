package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.base.TestBase;

public class HomePage  extends TestBase{
	@FindBy(xpath="//a[@aria-label='Facebook']")
	WebElement logoText;

	@FindBy(xpath="//a[@aria-label='Priya Pande']")
	WebElement viewProfile;

	@FindBy(xpath="//a[@aria-label='Friends']")
	WebElement viewFriends;

	//Initializing the page objects
	public HomePage() {
	PageFactory.initElements(driver,this);
	}

	//methods

	public String verifyHomePageTitle() {
	return driver.getTitle();
	}

	//public ViewProfile clickOnProfileLink() {
	//viewProfile.click();
	//return new ViewProfile();
	//}

	//public ViewFriends  clickOnFriends() {
	//viewFriends.click();
	//return new ViewFriends();
	}


