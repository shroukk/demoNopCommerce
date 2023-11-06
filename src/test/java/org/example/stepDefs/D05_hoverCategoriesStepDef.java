package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.asserts.SoftAssert;

public class D05_hoverCategoriesStepDef {

    P03_homePage hover = new P03_homePage();
    String expectedTitle;
    static int random ;


    @When("user select random one of the three main categories")
    public void userSelectRandomOneOfTheThreeMainCategories() throws InterruptedException {
        random = hover.hoverOnRandomCategory();
    }

    @And("user select random one of the three sub categories")
    public void userSelectRandomOneOfTheThreeSubCategories() {
        expectedTitle = hover.chooseSubCategory(random);
    }

    @Then("user is directed to the category page")
    public void userIsDirectedToTheCategoryPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(hover.pageTitle().getText().equals(expectedTitle));
        softAssert.assertAll();
    }
}
