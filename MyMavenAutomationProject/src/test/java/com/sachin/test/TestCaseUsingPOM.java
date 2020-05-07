package com.sachin.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sachin.Page.HomePage;
import com.sachin.Page.LoginPage;

public class TestCaseUsingPOM {
	
	//Initializing the Objects of the class from Pages-package.
    WebDriver driver;
    LoginPage objLogin;
    HomePage objHomePage;
   
    @BeforeTest
    public void setup(){

    	System.setProperty("webdriver.chrome.driver", "D:\\Users\\sachisha\\Desktop\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Calling setup() - Initializing the browser");
        driver.get("http://demo.guru99.com/V4/");
    }

    /**
     * This test case will login in http://demo.guru99.com/V4/
     * Verify login page title as guru99 bank
     * Login to application
     * Verify the home page using Dashboard message
     */

    @Test(priority=0)
    public void testLoginAndThenHomePage(){
	    
    	//Create Login Page object -- Constructor is initilized here with driver parameter sent!
	    objLogin = new LoginPage(driver);
	    
	    //Verify login page title
	    String loginPageTitle = objLogin.getLoginTitle();
	    System.out.println("****************loginPageTitle=" + loginPageTitle);
	    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
	    
	    //login to application --- BY calling LoginPage -- from PAGES
	    System.out.println("****************Logging in using Username=mgr123 and password=mgr123");
	    objLogin.loginToGuru99("mgr123", "mgr!23");
	    
	    
	    // Go the next page --- BY calling HomePage -- from PAGES. Passing the DRIVER-Object to another class here.
	    objHomePage = new HomePage(driver);
	    
	    //Verify home page
	    System.out.println("Verifying the Home page after logging in");
	    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    }
    
    @AfterTest
    public void tearDown() {
    	
    	System.out.println("Calling tearDown() - closing the browser");
    	driver.quit();
    	}
    
}
