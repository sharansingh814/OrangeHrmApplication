package com.OrangeHrm.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
		
		//1
		public WebDriver driver;
		public Properties prop;
		//log4j2 concept
		public Logger logger = LogManager.getLogger(this.getClass());
		//2
		@BeforeClass
		@Parameters("browser")
		public void setup(String br) throws IOException {
			// to load the config properties file
			prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\resources\\config.properties");
			prop.load(fis);
			// to load the config properties file
			/*WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();*/
			
			if (br.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if(br.equalsIgnoreCase("firefox")){
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
		}
		//Capturing the screenshots of the application
		public void captureScreen(WebDriver driver, String testName) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + testName + ".png");
			System.out.println(target);
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot capture for :" +testName);
		}
		
		//4
		@AfterClass
		public void tearDown() {
			driver.quit();
		}
}
