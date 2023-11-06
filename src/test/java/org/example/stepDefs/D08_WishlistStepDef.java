package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class D08_WishlistStepDef {
    P03_homePage wishlist = new P03_homePage();
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));



    @When("user add the third product to the wishlist")
    public void userAddTheThirdProductToTheWishlist(){
        wishlist.wishlistBtn().get(2).click();

    }


    @Then("success message will be appeared")
    public void successMessageWillBeAppeared() {
        wait.until(ExpectedConditions.visibilityOf(wishlist.wishlistSuccessMsg()));
//      convert color from rgb to hex format
        String bgcolor = Color.fromString(wishlist.wishlistSuccessMsg().getCssValue("background-color")).asHex();
//      assure that the success message
        Assert.assertTrue(wishlist.wishlistSuccessMsg().getText().contains("The product has been added to your wishlist"));
//      assure the background color
        Assert.assertTrue(bgcolor.equals("#4bb07a"));
    }


    @And("user click on Wishlist Tab")
    public void userClickOnWishlistTab() {
//      wait till the message disappear
        wait.until(ExpectedConditions.invisibilityOf(wishlist.wishlistSuccessMsg()));
//      wait till the wishlist icon appear
//      wait.until(ExpectedConditions.elementToBeClickable(wishlist.wishlistTab()));
        wishlist.wishlistTab().click();

    }

    @Then("user will be directed to the wishlist page")
    public void userWillBeDirectedToTheWishlistPage() {
        // 5- get qty value and assert it's larger than zero
        String count = wishlist.wishlistQuantityValue().getAttribute("value");
        int countInt = Integer.parseInt(count);
        Assert.assertTrue(Hooks.driver.getCurrentUrl().equals("https://demo.nopcommerce.com/wishlist"));
        Assert.assertTrue(countInt>0);
    }
}
