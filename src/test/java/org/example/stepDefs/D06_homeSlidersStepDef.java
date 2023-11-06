package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D06_homeSlidersStepDef {

    P03_homePage homeslider = new P03_homePage();
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;

    @When("user click on first slider")
    public void userClickOnFirstSlider() throws InterruptedException {


        js.executeScript("arguments[0].click();",homeslider.getSliderDot().get(0));
        Thread.sleep(1000);

        js.executeScript("arguments[0].click();", homeslider.getSliderLink().get(0));


    }

    @Then("user is directed to the iPhone page")
    public void userIsDirectedToTheIPhonePage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().equals("https://demo.nopcommerce.com/iphone-6"));
        softAssert.assertAll();
    }

    @When("user click on second slider")
    public void userClickOnSecondSlider() throws InterruptedException {

        js.executeScript("arguments[0].click();",homeslider.getSliderDot().get(1));
        Thread.sleep(1000);

        js.executeScript("arguments[0].click();", homeslider.getSliderLink().get(1));


    }

    @Then("user is directed to the Nokia Lumia 1020 page")
    public void userIsDirectedToTheNokiaLumiaPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().equals("https://demo.nopcommerce.com/nokia-lumia-1020"));
        softAssert.assertAll();
        System.out.println(Hooks.driver.getCurrentUrl());
    }
}
