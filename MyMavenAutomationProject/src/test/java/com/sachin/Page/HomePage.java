package com.sachin.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
    By homePageUserName = By.xpath("//table//tr[@class='heading3']");
    
    //Defining a constructor (with the same name as that of the class here) explicitly that takes a paremeter.
    public HomePage(WebDriver driver){
       this.driver = driver;
    }

    //Get the User name from Home Page
        public String getHomePageDashboardUserName(){
         return    driver.findElement(homePageUserName).getText();
        }
}
