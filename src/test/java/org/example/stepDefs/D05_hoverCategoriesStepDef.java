package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.asserts.SoftAssert;

public class D05_hoverCategoriesStepDef {

    P03_homePage hover = new P03_homePage();
    String expectedTitle;


    @When("user select random one of the three main categories")
    public void userSelectRandomOneOfTheThreeMainCategories() throws InterruptedException {

       int rand = hover.selectRandomCate(hover.allCategories());
        hover.hoverOnRandomCategory(hover.allCategories(), rand);
    }

    @And("user select random one of the three sub categories")
    public void userSelectRandomOneOfTheThreeSubCategories() {
        int random =hover.selectRandomCate(hover.subCategories());
        expectedTitle = hover.subCategories().get(random).getText();
        hover.subCategories().get(random).click();
    }

    @Then("user is directed to the category page")
    public void userIsDirectedToTheCategoryPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(hover.pageTitle().getText().toLowerCase().trim().contains(expectedTitle));
        softAssert.assertAll();
    }
}
