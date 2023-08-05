package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {

    P03_homePage wishlist = new P03_homePage();
    SoftAssert softAssert = new SoftAssert();
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    @When("user add the third product to the wishlist")
    public void userAddTheThirdProductToTheWishlist(){
        wishlist.wishlistBtn().get(2).click();

    }

    @Then("success message will be appeared")
    public void successMessageWillBeAppeared() {
        wait.until(ExpectedConditions.visibilityOf(wishlist.wishlistSuccessMsg()));
        softAssert.assertTrue(wishlist.wishlistSuccessMsg().getText().equals("The product has been added to your wishlist"));
        softAssert.assertTrue(wishlist.wishlistSuccessMsg().getCssValue("background-color").equals("#4bb07a"));
        softAssert.assertAll();
        System.out.println(wishlist.wishlistSuccessMsg().getCssValue("background-color"));
        System.out.println(wishlist.wishlistSuccessMsg().getText());
    }



    @And("user click on wishlist Tab")
    public void userClickOnWishlistTab() {
        wait.until(ExpectedConditions.invisibilityOf(wishlist.wishlistSuccessMsg()));
        wishlist.wishlistTab().click();
    }

    @Then("user will be directed to the wishlist page")
    public void userWillBeDirectedToTheWishlistPage() {
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().equals("https://demo.nopcommerce.com/wishlist"));
        softAssert.assertTrue(!wishlist.wishlistQuantityValue().getAttribute("value").equals(0));
        System.out.println(wishlist.wishlistQuantityValue().getAttribute("value"));


    }
}
