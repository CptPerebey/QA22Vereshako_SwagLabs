package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailslPageTest extends BaseTest{
    @Test
    public void ProductDetailsTestOne(){
        String itemName = "Sauce Labs Backpack";
        String itemPrice = "$29.99";
        String itemDesc = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.openItem(itemName);
        Assert.assertEquals(productDetailsPage.getItemPrice(),itemPrice);

    }

}
