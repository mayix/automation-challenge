package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestProperties;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MicrosoftVisualStudioProductSteps {

    WebDriver driver;
    String itemPrice;

    TestProperties testProperties = new TestProperties();

    @Given("Launch browser")
    public void launch_browser() {
        String webDriverPath = testProperties.getWebDriver("CHROMERIVER_HOME");
        System.setProperty("webdriver.chrome.driver", webDriverPath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("****Browser is open");
    }

    @When("Go to Microsoft website homepage")
    public void go_to_microsoft_website_homepage() {
        String endpoint = testProperties.getEndpoints(System.getProperty("environment"), "MICROSOFT_MAINPAGE");

        driver.get(endpoint);
        WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shellmenu_0\"]")));
    }

    @Then("Validate all menu items are present")
    public void validate_all_menu_items_are_present() {
        boolean microsoft365 = driver.findElement(By.xpath("//*[@id=\"shellmenu_0\"]")).isDisplayed();
        Assert.assertEquals(true, microsoft365);
        System.out.println("****Element Microsoft 365 validated");

        boolean office = driver.findElement(By.xpath("//*[@id=\"shellmenu_1\"]")).isDisplayed();
        Assert.assertEquals(true, office);
        System.out.println("****Element Office validated");

        boolean windows = driver.findElement(By.xpath("//*[@id=\"shellmenu_2\"]")).isDisplayed();
        Assert.assertEquals(true, windows);
        System.out.println("****Element Windows validated");

        boolean surface = driver.findElement(By.xpath("//*[@id=\"shellmenu_3\"]")).isDisplayed();
        Assert.assertEquals(true, surface);
        System.out.println("****Element Surface validated");

        boolean xBox = driver.findElement(By.xpath("//*[@id=\"shellmenu_4\"]")).isDisplayed();
        Assert.assertEquals(true, xBox);
        System.out.println("****Element X Box validated");

        boolean deals = driver.findElement(By.xpath("//*[@id=\"shellmenu_5\"]")).isDisplayed();
        Assert.assertEquals(true, deals);
        System.out.println("****Element Deals 365 validated");

        boolean support = driver.findElement(By.xpath("//*[@id=\"l1_support\"]")).isDisplayed();
        Assert.assertEquals(true, support);
        System.out.println("****Element Support validated");

    }

    @Then("go to Windows")
    public void go_to_windows() {
        driver.findElement(By.xpath("//*[@id=\"shellmenu_2\"]")).click();
        System.out.println("****Clicked on Windows element");
        WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"c-shellmenu_54\"]")));
    }

    @Then("Click on Windows ten menu")
    public void click_on_windows_menu() {
        WebElement windows10 = driver.findElement(By.xpath("//*[@id=\"c-shellmenu_54\"]"));
        windows10.click();
        System.out.println("****Clicked on Windows 10 element");
    }

    @Then("Print all elements in dropdown")
    public void print_all_elements_in_dropdown() {
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"uhf-g-nav\"]/ul/li[2]/div/ul"));
        List<WebElement> allElements = dropdown.findElements(By.tagName("li"));
        System.out.println("****Elements have been stored to allElements " + allElements);

        for (WebElement we:
             allElements)
            System.out.println(we.getText());

        System.out.println("****Elements have been printed");
    }

    @Then("Go to Search next to the Shopping Cart")
    public void go_to_next_to_the_shopping_cart() {
        driver.findElement(By.xpath("//*[@id=\"search\"]")).click();
        System.out.println("****Search button has been selected ");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Then("Search for Visual studio")
    public void search_for_visual_studio() {
        String testData = testProperties.testData("PRODUCT_SEARCH");

        WebElement search =  driver.findElement(By.xpath("//*[@id=\"cli_shellHeaderSearchInput\"]"));
        search.click();
        //search.sendKeys("visual studio");
        search.sendKeys(testData);
        driver.findElement(By.xpath("//*[@id=\"search\"]")).click();
        System.out.println("****Visual Studio search completed");
    }

    @Then("Print the price for the three first elements listed in Software result list")
    public void print_the_price_for_the_first_elements_listed_in_software_result_list() {
        boolean popUp = driver.findElement(By.xpath("//*[@id=\"R1MarketRedirect-close\"]")).isDisplayed();
        if (popUp == true){
            driver.findElement(By.xpath("//*[@id=\"R1MarketRedirect-close\"]")).click();
        }

        WebElement productPrices = driver.findElement(By.xpath("//*/div/div/span[3]"));
        List<WebElement> pricesList = productPrices.findElements(By.xpath("//span[@itemprop=\"price\"]"));
        System.out.println("Prices have been stored to pricesList " + pricesList);

        for (int i = 0; i <= 2; i++){
            WebElement price = pricesList.get(i);
            System.out.println(price.getText());
        }

        WebElement itemPrice = pricesList.get(0);
        this.itemPrice = itemPrice.getText();
        System.out.println("****Prices have been printed and first price was saved:" + this.itemPrice);

    }

    @Then("Click on the first one to go to the details page")
    public void click_on_the_first_one_to_go_to_the_details_page() {
        driver.findElement(By.xpath("//*[@id=\"coreui-productplacement-30l7ywa_0\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email-newsletter-dialog\"]/div[3]/div[2]/div[2]/h2")));
        driver.findElement(By.xpath("//*[@id=\"email-newsletter-dialog\"]/div[3]/div[1]")).click();
        System.out.println("****Reached product details page");
    }

    @Then("Once in the details page, validate both prices are the same")
    public void once_in_the_details_page_validate_both_prices_are_the_same() {
        WebElement itemPrice = driver.findElement(By.xpath("//*/div/*[contains(@id,'productPrice_PriceContainer')]"));
        String itemPriceStr = itemPrice.getText();
        Assert.assertEquals(this.itemPrice, itemPriceStr);
        System.out.println("****Price comparison successful");
    }

    @Then("Click Add To Cart")
    public void click_add_to_cart() {
        driver.findElement(By.xpath("//*[@id=\"buttonPanel_AddToCartButton\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"store-cart-root\"]/div/div/header/div[2]/h2")));

        System.out.println("****Element added to the Shopping Cart");
    }
    @Then("Verify all three price amounts are the same")
    public void verify_all_price_amounts_are_the_same() {
        List<WebElement> finalPrices = driver.findElements(By.xpath("//*//div//span[@itemprop = \"price\"]"));

        for (int i=0; i <= 2; i++){
            WebElement finalPrice = finalPrices.get(i);
            Assert.assertEquals(this.itemPrice, finalPrice.getText());
            System.out.println("Expected price: " + this.itemPrice + " Price in page: " + finalPrice.getText());
        }

        System.out.println("****Final prices are correct");
    }
    @Then("On the # of items dropdown select twenty and validate the Total amount is Unit Price multiplied by twenty")
    public void on_the_of_items_dropdown_select_and_validate_the_total_amount_is_unit_price() {
        driver.findElement(By.xpath("//select/option[20]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'$23')]")));

        List<WebElement> finalPrices = driver.findElements(By.xpath("//*//div//span[@itemprop = \"price\"]"));
        WebElement finalPrice = finalPrices.get(2);

        itemPrice = itemPrice.replaceAll("[$,]", "");
        String finalPriceStr = finalPrice.getText().replaceAll("[$,]", "");

        int itemPriceInt = Math.round(Float.parseFloat(itemPrice));
        int finalPriceInt = Math.round(Float.parseFloat(finalPriceStr));

        itemPriceInt = itemPriceInt * 20;
        Assert.assertEquals(itemPriceInt, finalPriceInt);
        System.out.println("Price validated: " + itemPriceInt + " = " + finalPriceInt);

    }
    @And("Close browser")
    public void close_browser() {
        driver.quit();
    }
}
