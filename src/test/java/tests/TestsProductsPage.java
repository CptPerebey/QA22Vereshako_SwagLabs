package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

public class TestsProductsPage extends BaseTest {


    @Test
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
}
