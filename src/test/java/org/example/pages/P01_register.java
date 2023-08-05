package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P01_register {

    By reg_link = By.className("ico-register");
    By gender_type = By.cssSelector("label[class=\"forcheckbox\"]");
    By first_name = By.id("FirstName");
    By last_name =By.id("LastName");
    By date_of_birth = By.cssSelector("div[class=\"date-picker-wrapper\"] select");
    By email = By.id("Email");

    By password = By.id("Password");
    By confirm_password = By.id("ConfirmPassword");

    By register_btn = By.id("register-button");

    By success_msg = By.cssSelector("div[class=\"result\"]");


    public WebElement registerLink(){
        return Hooks.driver.findElement(reg_link);
    }
    public List<WebElement> genderType(){
        return Hooks.driver.findElements(gender_type);
    }
    public WebElement firstName(){
        return Hooks.driver.findElement(first_name);
    }

    public WebElement lastName(){
        return Hooks.driver.findElement(last_name);
    }

    public List<WebElement> dateOfBirth(){
        return Hooks.driver.findElements(date_of_birth);
    }
    public WebElement email(){
        return Hooks.driver.findElement(email);
    }

    public WebElement password(){
        return Hooks.driver.findElement(password);
    }

    public WebElement confirmPassword(){
        return Hooks.driver.findElement(confirm_password);
    }

    public WebElement registerBtn(){
        return Hooks.driver.findElement(register_btn);
    }

    public WebElement registerSuccessMsg(){
        return Hooks.driver.findElement(success_msg);

    }


}
