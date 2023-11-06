package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    P03_homePage search = new P03_homePage();

    @When("user could search using productname {string}")
    public void userCouldSearchUsingProductname(String arg0) {
        search.searchField().sendKeys(arg0);

    }

    @When("user could search using serial number {string}")
    public void userCouldSearchUsingSerialNumber(String arg0) {
        search.searchField().sendKeys(arg0);

    }

    @And("user press on search button")
    public void userPressOnSearchButton(){
        search.searchBtn().click();

    }





    @Then("user is directed to the result products using name {string} page")
    public void userIsDirectedToTheResultProductsUsingNamePage(String arg0) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue((Hooks.driver.getCurrentUrl()).contains("https://demo.nopcommerce.com/search?q="));
        System.out.println((Hooks.driver.getCurrentUrl()).contains("https://demo.nopcommerce.com/search?q="));

        for (int i = 0; i <search.allProducts().size();i++){
            System.out.println(arg0);
            softAssert.assertTrue((search.allProducts().get(i).getText().toLowerCase()).contains(arg0));

            System.out.println(search.allProducts().get(i).getText().toLowerCase());
            System.out.println((search.allProducts().get(i).getText().toLowerCase()).contains(arg0));

        }
        softAssert.assertAll();
    }

    @Then("user is directed to the result products using serial number {string} page")
    public void userIsDirectedToTheResultProductsUsingSerialNumberPage(String arg0) {
        search.allProducts().get(0).click();
        System.out.println("searchedd :"+ search.productBySku().getText());
        System.out.println("argument : "+ arg0);
        Assert.assertTrue((search.productBySku().getText()).contains(arg0));


    }
}
