package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class P03_homePage {
    By customer_currency = By.id("customerCurrency");
    By all_products = By.className("product-item");

    By search_btn = By.cssSelector("button[class=\"button-1 search-box-button\"]");
    By search_field = By.id("small-searchterms");

    By product_by_sku = By.className("sku");

    By page_title = By.cssSelector("[class=\"page-title\"] h1");

    By get_slider_link = By.cssSelector("[class=\"nivo-imageLink\"]");
    By get_slider_dot = By.cssSelector("[class=\"nivo-controlNav\"] a");
    By social_media_link = By.cssSelector("[class=\"networks\"] a");

    By wishlist_btn = By.cssSelector("[class=\"button-2 add-to-wishlist-button\"]");

    By wishlist_success_msg = By.cssSelector("div[class=\"bar-notification success\"]");

    By wishlist_tab = By.cssSelector("span[class=\"wishlist-label\"]");

    By wishlist_quantity_value= By.cssSelector("input[class=\"qty-input\"]");


    public WebElement customerCurrency(){
        return Hooks.driver.findElement(customer_currency);
    }

    public List<WebElement> allProducts(){
//        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOf((WebElement) Hooks.driver.findElements(all_products)));
        return Hooks.driver.findElements(all_products);
    }

    public WebElement searchField(){
        return Hooks.driver.findElement(search_field);
    }

    public WebElement searchBtn(){
        return Hooks.driver.findElement(search_btn);
    }

    public WebElement productBySku(){
        return Hooks.driver.findElement(product_by_sku);
    }



    public int selectRandomCate(List<WebElement> category){
        int min = 0;
        int max = 2;   // you are selecting random value from 0 to 2 that's why  max = count-1
        int selectedUser = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return selectedUser;

    }

    By SelectedMainCategory = By.cssSelector("[class=\"top-menu notmobile\"]> li");
    public int hoverOnRandomCategory() {
        List<WebElement> mainCategory= Hooks.driver.findElements(SelectedMainCategory);
        int randomCate = selectRandomCate(mainCategory);
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(mainCategory.get(randomCate)).perform();
        return randomCate;
    }
    public String chooseSubCategory(int randomCate){
        By SelectedSubCategory = By.cssSelector("[class=\"top-menu notmobile\"]> li:nth-child("+(randomCate+1)+") li");
        System.out.println("[class=\"top-menu notmobile\"]> li:nth-child("+(randomCate+1)+") li");
        List<WebElement> SubCategory=Hooks.driver.findElements(SelectedSubCategory);
        int randomSubCate = selectRandomCate(SubCategory);
        String title = SubCategory.get(randomSubCate).getText();
        SubCategory.get(randomSubCate).click();
        return title;
    }


    public WebElement pageTitle(){
        return Hooks.driver.findElement(page_title);
    }


    public List <WebElement> getSliderLink(){

        return Hooks.driver.findElements(get_slider_link);
    }

    public List <WebElement> getSliderDot(){

        return Hooks.driver.findElements(get_slider_dot);
    }

    public List <WebElement> socialMediaLink(){
        return Hooks.driver.findElements(social_media_link);
    }

    public List<WebElement> wishlistBtn(){
        return Hooks.driver.findElements(wishlist_btn);
    }

    public WebElement wishlistSuccessMsg(){
        return Hooks.driver.findElement(wishlist_success_msg);
    }


    public WebElement wishlistTab(){
        return Hooks.driver.findElement(wishlist_tab);
    }

    public WebElement wishlistQuantityValue(){
        return Hooks.driver.findElement(wishlist_quantity_value);
    }
}
