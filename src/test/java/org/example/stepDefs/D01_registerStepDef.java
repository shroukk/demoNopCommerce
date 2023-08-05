package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    P01_register register = new P01_register();

    @Given("user go to register page")
    public void goToRegisterPage(){

        register.registerLink().click();
    }

    @When("user select gender type")
    public void userSelectGenderType() {
        register.genderType().get(1).click();

    }

    @And("user enter first name {string}")
    public void userEnterFirstName(String arg0) {
        register.firstName().sendKeys(arg0);
    }

    @And("last name {string}")
    public void lastName(String arg0) {
        register.lastName().sendKeys(arg0);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        Select selectDay = new Select(register.dateOfBirth().get(0));
        selectDay.selectByVisibleText("2");
        Select selectMonth = new Select(register.dateOfBirth().get(1));
        selectMonth.selectByVisibleText("September");
        Select selectYear = new Select(register.dateOfBirth().get(2));
        selectYear.selectByVisibleText("1996");
    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String arg0) {
        register.email().sendKeys(arg0);
    }
    @And("user fills Password field {string}")
    public void userFillsPasswordField(String arg0) {
        register.password().sendKeys(arg0);
    }

    @And("user fills confirm password field {string}")
    public void userFillsConfirmPasswordField(String arg0) {
        register.confirmPassword().sendKeys(arg0);
    }


    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        register.registerBtn().click();
        //assert that user directed to another page
        Assert.assertFalse(Hooks.driver.getCurrentUrl().equals("https://demo.nopcommerce.com/register?returnUrl=%2F"));
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        String expectedMsg = "Your registration completed";
        // soft assertion
        SoftAssert softAssert = new SoftAssert();
        // assert that expected message is true
        softAssert.assertEquals(register.registerSuccessMsg().getText(),expectedMsg);
        // assert that success message is green
        softAssert.assertEquals(register.registerSuccessMsg().getCssValue("color"), "rgba(76, 177, 124, 1)");
        softAssert.assertAll();
        System.out.println(register.registerSuccessMsg().getCssValue("color"));
        System.out.println(register.registerSuccessMsg().getText());




    }


}
