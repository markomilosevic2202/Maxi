package org.example.definitions;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import data.DataSet;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.page_factory.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class StepDef {


    public static WebDriver driver;

    private Actions actions;
    DataSet dataSetTest;

    RegPage regPage;

    OnlinePage onlinePage;
    WebDriverWait wait;


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
        onlinePage = new OnlinePage(driver);
        wait = new WebDriverWait(driver, 10);



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

        Thread.sleep(3000);
        driver.quit();
    }


    @Given("go to the address {string}")
    public void go_to_the_address(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(1000);



    }

    @Given("enter your login email {string}")
    public void enter_your_login_email(String email) throws InterruptedException {

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



}


