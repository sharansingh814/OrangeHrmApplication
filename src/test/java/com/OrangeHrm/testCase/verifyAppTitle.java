package com.OrangeHrm.testCase;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.OrangeHrm.testBase.BaseClass;

public class verifyAppTitle extends BaseClass {
	String expurl = "https://opensource-demo.orangehrmlive.com/";
	
	SoftAssert sa = new SoftAssert();
	@Test
	public void verifyApplicationTitle() throws IOException {
		logger.info("***************Launching URL*************************");
		driver.get(prop.getProperty("url"));
		logger.info("**************Application opened*********************");
		String appUrl = driver.getCurrentUrl();
		if (expurl.equalsIgnoreCase(appUrl)) {
			sa.assertTrue(true);
			logger.info("****************URL is correct********************");
		}else {
			sa.assertTrue(false);
			logger.error("*******************URL is wrong*******************");
			captureScreen(driver, "verifyApplicationTitle");
			sa.assertAll();
		}
	}

}
