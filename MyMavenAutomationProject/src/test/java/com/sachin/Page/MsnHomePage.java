package com.sachin.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MsnHomePage {

	WebDriver driver;
	By MsnSignInLink = By.xpath("//*[@id=\"meCtrl\"]/a/span");
	
    //Defining a constructor (with the same name as that of the class here) explicitly that takes a paremeter.
    public MsnHomePage(WebDriver driver){
       this.driver = driver;
    }

    public void ClickSignInOnMsnHomePage() {
    	
    	driver.findElement(MsnSignInLink).click();
    } 
    
}
