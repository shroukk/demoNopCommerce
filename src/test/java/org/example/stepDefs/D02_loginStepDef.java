package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.Color;


public class D02_loginStepDef {

    P02_login login = new P02_login();


    @Given("user go to login page")
    public void goToLoginPage (){
        login.loginLink().click();

    }

    @When("user enter valid email {string}")
    public void userEnterValidEmail(String arg0) {
        login.email().sendKeys(arg0);
    }

    @And("user enter valid password {string}")
    public void userEnterValidPassword(String arg0) {
        login.password().sendKeys(arg0);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.loginBtn().click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        softAssert.assertEquals(login.accountIcon().getText(),"My account");
//        System.out.println(login.accountIcon().getText());
        softAssert.assertAll();
    }

    @When("user enter invalid email {string}")
    public void userEnterInvalidEmail(String arg0) {
        login.email().sendKeys(arg0);
    }

    @And("user enter invalid password {string}")
    public void userEnterInvalidPassword(String arg0) {
        login.password().sendKeys(arg0);
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue((login.errorMsg().getText()).contains("Login was unsuccessful."));
        softAssert.assertTrue(Color.fromString("rgba(228, 67, 75, 1)").asHex().equals("#e4434b"));
        softAssert.assertAll();
//        System.out.println("login msg: "+(login.errorMsg().getText()).contains("Login was unsuccessful.")+" is red : "+Color.fromString("rgba(228, 67, 75, 1)").asHex().equals("#e4434b"));

    }
}
