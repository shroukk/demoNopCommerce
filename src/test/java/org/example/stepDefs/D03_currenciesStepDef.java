package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class D03_currenciesStepDef {

    P03_homePage currency = new P03_homePage();
    P02_login login = new P02_login();
    @When("user Select the preferred currency")
    public void userSelectThePreferredCurrency() throws InterruptedException {
        login.loginLink().click();
        login.email().sendKeys("test@example.com");
        login.password().sendKeys("P@ssw0rd");
        login.loginBtn().click();
        Thread.sleep(10);
        Select selectCurrency = new Select(currency.customerCurrency());
        selectCurrency.selectByIndex(1);


    }

    @Then("Euro Symbol is shown on the products displayed in Homepage")
    public void euroSymbolIsShownOnTheProductsDisplayedInHomepage() {
        for (int i = 0; i<currency.allProducts().size(); i++){

            Assert.assertTrue((currency.allProducts().get(i).getText()).contains("€"));
//            System.out.println((currency.allProducts().get(i).getText()).contains("€"));

        }


    }
}
