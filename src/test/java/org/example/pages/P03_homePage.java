package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P03_homePage {
    By customer_currency = By.id("customerCurrency");
    By all_products = By.className("product-item");

    By search_btn = By.cssSelector("button[class=\"button-1 search-box-button\"]");
    By search_field = By.id("small-searchterms");

    By product_by_sku = By.className("sku");

    By all_categories = By.cssSelector("ul[class=\"top-menu notmobile\"] li");

    By sub_categories = By.cssSelector("ul[class=\"top-menu notmobile\"] li li");

    By page_title = By.cssSelector("[class=\"page-title\"] h1");

    By get_slider_link = By.cssSelector("[class=\"nivo-imageLink\"]");
    By get_slider_dot = By.cssSelector("[class=\"nivo-controlNav\"] a");
    By social_media_link = By.cssSelector("[class=\"networks\"] a");

    By wishlist_btn = By.cssSelector("[class=\"button-2 add-to-wishlist-button\"]");

    public By wishlist_success_msg = By.cssSelector("[class=\"bar-notification success\"]");

    By wishlist_tab = By.cssSelector("[class=\"header-links\"] a[href=\"/wishlist\"]");

    By wishlist_quantity_value= By.cssSelector("input[name=\"itemquantity11219\"]");


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

    public  List<WebElement> allCategories(){
        return Hooks.driver.findElements(all_categories);
    }

    public List<WebElement> subCategories(){
        return Hooks.driver.findElements(sub_categories);

    }

    public int selectRandomCate(List<WebElement> category){
        int count = category.size();
        System.out.println(count);



        int min = 0;
        int max = 2;   // you are selecting random value from 0 to 2 that's why  max = count-1
        int selectedUser = (int) Math.floor(Math.random() * (max - min + 1) + min);
        System.out.println(selectedUser);
        return selectedUser;

    }

    public void hoverOnRandomCategory(List<WebElement> category, int num) throws InterruptedException {
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(category.get(num)).perform();
        Thread.sleep(10000);

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
