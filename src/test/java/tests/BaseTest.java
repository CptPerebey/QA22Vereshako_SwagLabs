package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.asn1.cms.Time;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.util.TimeUtils;
import pages.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ProductDetailsPage productDetailsPage;
    protected ShoppingCartPage shoppingCartPage;
    protected CheckOutInformationPage checkOutInformationPage;
    protected CheckoutOverview checkoutOverview;



    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }
    @BeforeMethod
    public void negative() {
        driver.get("https://www.saucedemo.com/");
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}

