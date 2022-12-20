package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;
public class TestsProductsPage extends BaseTest {


    @Test(groups = "Regression", description = "Тест проверку перехода на главную страницу после регистрации",retryAnalyzer = RetryAnalyzer.class)
    public void positiveAddItem() {
      String testItemName = "Sauce Labs Backpack";
      String testItemPrice = "$29.99";
      String testItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
      loginPage.setUsername("standard_user");
      loginPage.setPassword("secret_sauce");
      loginPage.clickLoginButton();
      Assert.assertEquals(productsPage.getItemPrice(testItemName), testItemPrice);
      Assert.assertEquals(productsPage.getItemDescription(testItemName), testItemDescription );

    }

    @Test(groups = "Regressive", description = "Тест на проверку фильтрации на главной странице")
    public void filterTest(){
        List<WebElement> allProduct = driver.findElements(By.cssSelector(".inventory_item"));
        String testItemName = "Test.allTheThings() T-Shirt (Red)";
        String testItemPrice = "$15.99";
        String testItemDescription = "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.";
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.filterList();
       // Assert.assertEquals(productsPage.getItemPrice(testItemName), testItemPrice);
        //Assert.assertEquals(productsPage.getItemDescription(testItemName), testItemDescription );
        Assert.assertEquals(allProduct.size(), 6);


    }
}
