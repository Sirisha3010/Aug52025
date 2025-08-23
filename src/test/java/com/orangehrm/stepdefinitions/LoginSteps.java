package com.orangehrm.stepdefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

    WebDriver driver;

    @Given("Launch the Browser")
    public void launch_the_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Browser launched successfully.");
    }

    @Given("Navigate to the URL")
    public void navigate_to_the_url() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Navigated to URL.");
    }

    @When("Enter the username and password")
    public void enter_the_username_and_password() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        System.out.println("Entered username and password.");
    }

    @When("Click on Login Button")
    public void click_on_login_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Clicked login button.");
    }

    @Then("Login should be successful")
    public void login_should_be_successful() {
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        if (title.contains("OrangeHRM")) {
            System.out.println("✅ Login Successful");
        } else {
            System.out.println("❌ Login Failed");
        }

        driver.quit();
    }
}
