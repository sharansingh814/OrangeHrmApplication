package com.OrangeHrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHrm.testBase.BaseClass;

public class LoginPage extends BaseClass {
	//1 Creating WebDriver as public
	public WebDriver driver;
	
	//2 Creating a contructor
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;//assigning the driver passed from test cases to the local WebDriver driver.
		PageFactory.initElements(driver, this);
	}
	//3 - Locators for Username
	@FindBy(id="txtUsername")
	@CacheLookup// to improve the performanceof locating elements
	WebElement txtUsername;
	
	//4 Locator for Password
	@FindBy(id ="txtPassword")
	@CacheLookup
	WebElement txtPassword;
	
	//5 Locator for Login Button
	@FindBy(id="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	//6 Enter the username
	public void setUsername(String uname) {
		txtUsername.clear();
		txtUsername.sendKeys(uname);
		
	}
	//7 Enter the Password
	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
		
	}
	//8 Click on Login Button
	public void clickOnLoginButton() {
		btnLogin.click();
	}
}
