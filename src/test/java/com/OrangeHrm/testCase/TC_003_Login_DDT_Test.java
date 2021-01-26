package com.OrangeHrm.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHrm.pageObjects.LoginPage;
import com.OrangeHrm.testBase.BaseClass;
import com.OrangeHrm.utilities.excelUtil;

public class TC_003_Login_DDT_Test extends BaseClass{
	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir")+"/testData/loginData.xlsx";//whwnever you work with dropdown or excel sheet you need to rows and columns
		//get row count
		int rows = excelUtil.getRowCount(path, "sheet1");
		//get column count
		int cols = excelUtil.getCellCount(path, "sheet1", 1);
		String loginData[][]= new String[rows][cols];
		
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				loginData[i-1][j] = excelUtil.getCellData(path, "sheet1", i, j);
				
			}
			
		}
		return loginData;
	}
	
	@Test(dataProvider="loginData")
	public void loginTest(String user, String pwd, String exp) throws IOException {
		logger.info("Starting execution for TC_003_Login_DDT_Test" );
		driver.get(prop.getProperty("url"));
		logger.info("Entering the details for login");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(user);
		lp.setPassword(pwd);
		lp.clickOnLoginButton();
		String expTitle = "OrangeHRM";
		String actTitle = driver.getTitle();
		
		if(expTitle.equalsIgnoreCase(actTitle)) {
			Assert.assertTrue(true);
			logger.info("**********************Login is successful***********************");
		}else {
			Assert.assertTrue(false, "Title is not correct");
			logger.info("**********************Login is failed***********************");
			captureScreen(driver, "loginTest");
		}
	}

}
