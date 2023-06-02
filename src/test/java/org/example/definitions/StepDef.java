package org.example.definitions;


import data.DataSet;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.object.Product;
import org.example.page_factory.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.*;
import java.io.*;
import java.time.Duration;


public class StepDef {


    public static WebDriver driver;

    private Actions actions;
    DataSet dataSetTest;

    RegPage regPage;

    CheckoutPage checkoutPage;

    OnlinePage onlinePage;
    WebDriverWait wait;

    static double bill = 0;

    static List<Product> listProduct;

    static int totalNumberItem;


    @Before

    public void before() throws FileNotFoundException {
        dataSetTest = new DataSet();

        System.setProperty(dataSetTest.getData1(), dataSetTest.getData2()
        );
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(dataSetTest.getData3());
        chromeOptions.addArguments(dataSetTest.getData4()); // open Browser in maximized mode
        chromeOptions.addArguments(dataSetTest.getData5()); // disabling infobars
        chromeOptions.addArguments(dataSetTest.getData6()); // disabling extensions
        chromeOptions.addArguments(dataSetTest.getData7()); // applicable to windows os only
        chromeOptions.addArguments(dataSetTest.getData8()); // overcome limited resource problems
        chromeOptions.addArguments(dataSetTest.getData9()); // Bypass OS security model
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        regPage = new RegPage(driver);
        checkoutPage = new CheckoutPage(driver);
        onlinePage = new OnlinePage(driver);
        wait = new WebDriverWait(driver, 10);
        listProduct = new ArrayList<>();


    }

    @After(order = 1)
    public void teardown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            final byte[] src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");

        }

    }


    @After(order = 0)
    public void afterClass() throws InterruptedException {

        // Thread.sleep(33000);
        driver.quit();
    }


    @Given("go to the address {string}")
    public void go_to_the_address(String url) {
        driver.get(url);


    }

    @Given("enter your login email {string}")
    public void enter_your_login_email(String email) {

        regPage.enterEmail(email);


    }

    @Given("enter your password {string}")
    public void enter_your_password(String pass) {

        regPage.enterPass(pass);
    }


    @When("click on the page reg button Submit")
    public void click_on_the_page_reg_button_submit() {
        regPage.clickSubmit();
    }

    @When("click on the page online link Dobro dosli")
    public void click_on_the_page_online_link_dobro_dosli() {
        onlinePage.clickDobroDosli();
    }

    @When("click on the page online link Odjava")
    public void click_on_the_page_online_link_odjava() {
        onlinePage.clickOdjava();
    }

    @When("click on the page reg button Prihvatam")
    public void click_on_the_page_reg_button_prihvatam() {
        regPage.clickPrihvatam();
    }

    @When("click on the page online link product group {string}")
    public void click_on_the_page_online_link_product_group(String productGroup) {
        onlinePage.clickProductGroup(productGroup);
    }

    @When("click on the page online link product {string}")
    public void click_on_the_page_online_link_product(String product) {
        onlinePage.clickProduct(product);
    }

    @When("click on the page online link maxi")
    public void click_on_the_page_online_link_maxi() {

        onlinePage.clickHome();
    }

    @When("add a product that is {string} in a row of {string} pieces")
    public void add_a_product_that_is_in_a_row_of_pieces(String ordinalNumber, String numberOfPieces) throws InterruptedException {
        Product product = onlinePage.addProduct(Integer.parseInt(ordinalNumber), Integer.parseInt(numberOfPieces));
        listProduct.add(product);
        bill = bill + product.getTotalPrice();
        totalNumberItem = totalNumberItem + Integer.parseInt(numberOfPieces);
    }

    @When("click on the page online on basket")
    public void click_on_the_page_online_on_basket() {
        onlinePage.clickOnBasket();
    }


    @Then("verify that there is an element with text {string}")
    public void verify_that_there_is_an_element_with_text(String text) {
        onlinePage.verifyElementExist(text);
    }

    @Then("verify that there is no element with text {string}")
    public void verify_that_there_is_no_element_with_text(String text) throws InterruptedException {
        Thread.sleep(3000);
        onlinePage.verifyElementNotExist(text);
    }

    @Then("verify that the page is located at the address {string}")
    public void verify_that_the_page_is_located_at_the_address(String address) {
        wait.until(ExpectedConditions.urlContains(address));
        Assertions.assertTrue(driver.getCurrentUrl().contains(address), "The page is not at the address '"
                + address + "'. Address is '" + driver.getCurrentUrl() + "'");
    }

    @Then("wait for the window to select the delivery date to appear and click on the decision later")
    public void wait_for_the_window_to_select_the_delivery_date_to_appear_and_click_on_the_decision_later() {

        onlinePage.waitWindowScheduleDelivery();
        onlinePage.clickChooseLater();
    }

    @Then("verify that the basket has the correct number of selected items")
    public void verify_that_the_basket_has_the_correct_number_of_selected_items() throws InterruptedException {
        Thread.sleep(2000);
        onlinePage.verifyNumberItemsOnBasket(totalNumberItem);
    }

    @Then("verify that the item number on the checkout page is correct")
    public void verify_that_the_item_number_on_the_checkout_page_is_correct() {
        checkoutPage.verifyElementExist(listProduct.size());
    }

    @Then("verify that the total purchase amount is correct")
    public void verify_that_the_total_purchase_amount_is_correct() {
        checkoutPage.verifyTotalBill(bill);
    }

    @Then("check whether all parameters for each item are displayed correctly")
    public void check_whether_all_parameters_for_each_item_are_displayed_correctly() {
        List<Product> listCheckbox = checkoutPage.addAllElementsInList();
        verifyProducts(listProduct, listCheckbox);

    }

    @Then("verify that there is a message {string}")
    public void verify_that_there_is_a_message(String text) {
        regPage.messageExist(text);
    }

    @Then("verify that there is a message window {string}")
    public void verify_that_there_is_a_message_window(String text) {
        regPage.windowsMessageExist(text);
    }



    public static void verifyProducts(List<Product> expectedList, List<Product> actualList) {
        for (Product expectedProduct : expectedList) {
            boolean found = false;
            for (Product actualProduct : actualList) {
                if (expectedProduct.equals(actualProduct)) {
                    found = true;
                    break;
                }
            }
            assert found : "Expected product not found: " + expectedProduct.toString();
        }
    }


}


