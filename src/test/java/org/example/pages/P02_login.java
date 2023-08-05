package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {

    By login_link = By.className("ico-login");
    By email = By.id("Email");
    By password = By.id("Password");

    By login_btn = By.cssSelector("button[class=\"button-1 login-button\"]");
    By account_icon =By.className("ico-account");
    By error_msg = By.cssSelector("[class=\"message-error validation-summary-errors\"]");
    public WebElement loginLink(){
        return Hooks.driver.findElement(login_link);
    }

    public WebElement email(){
        return Hooks.driver.findElement(email);

    }

    public WebElement password(){
        return Hooks.driver.findElement(password);
    }

    public WebElement loginBtn(){
        return Hooks.driver.findElement(login_btn);
    }

    public WebElement accountIcon(){
        return Hooks.driver.findElement(account_icon);
    }

    public WebElement errorMsg(){
        return Hooks.driver.findElement(error_msg);
    }



}
