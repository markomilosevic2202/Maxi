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
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
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

        //pedja caraaaaasssssss
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
    public void go_to_the_address(String string) {

    }
    @When("click on the page mozzart button {string}")
    public void click_on_the_page_mozzart_button(String string) {

    }




}


