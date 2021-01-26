package com.OrangeHrm.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.OrangeHrm.pageObjects.LoginPage;
import com.OrangeHrm.testBase.BaseClass;

public class TC001_LoginTest extends BaseClass {
	
	//3
	@Test
	public void loginTest() throws IOException {
		// launchin application
		logger.info("*******************Launching the Application*************************");
		driver.get(prop.getProperty("url"));
		logger.info("*******************Opened Application*************************");
		//creating Object Reference LoginPage.java to call all the method
		LoginPage lp = new LoginPage(driver);
		// calling all the methods of LoginPage.java
		lp.setUsername(prop.getProperty("username"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickOnLoginButton();
		//|Verifying if login is successful
		String expTitle = "OrangeHRM";
		String actTitle = driver.getTitle();
		
		if(expTitle.equalsIgnoreCase(actTitle)) {
			Assert.assertTrue(true);
			logger.info("**********************Login is successful***********************");
		}else {
			Assert.assertTrue(false, "Title is not correct");
			logger.info("**********************Login is failed***********************");
		}
	}
	
}
