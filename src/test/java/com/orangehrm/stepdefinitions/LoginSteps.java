package com.orangehrm.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
    WebDriver driver;

    // Launch browser
    @Given("Launch the Browser")
    public void launch_the_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    // Navigate to URL
    @Given("Navigate to the URL")
    public void navigate_to_the_url() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    // Enter valid credentials
    @When("Enter the username and password")
    public void enter_the_username_and_password() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
    }

    // Enter invalid credentials
    @When("Enter the invalid username and password")
    public void enter_the_invalid_username_and_password() {
        driver.findElement(By.name("username")).sendKeys("fgdfgdfg");
        driver.findElement(By.name("password")).sendKeys("admin123");
    }

    // Click login button
    @When("Click on Login Button")
    public void click_on_login_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    // Verify login successful (dashboard)
    @Then("Login should be successful")
    public void login_should_be_successful() {
        String title = driver.getTitle();
        System.out.println("The Title is: " + title);
        if (title.equalsIgnoreCase("OrangeHRM")) {
            System.out.println("Login Successful");
        } else {
            throw new AssertionError("Login Unsuccessful! Found title: " + title);
        }
    }
    @Then("Login should be unsuccessful")
	public void login_should_be_unsuccessful() {
		WebElement error=driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
		if(error.isDisplayed())
		{
			System.out.println("login unsccessfull");
		}
				
		
	}
 

    // Verify dashboard after successful login
    @Then("verify dashboard")
    public void verify_dashboard() {
        boolean isDashboardDisplayed = driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
        if (isDashboardDisplayed) {
            System.out.println("Dashboard Verified Successfully");
        } else {
            throw new AssertionError("Dashboard not displayed!");
        }
    }

    // Verify login failed (unsuccessful login)
    @Then("Login should fail")
    public void login_should_fail() {
        System.out.println("Login Failed as expected");
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        String errorMsg = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
        if(errorMsg.contains("Invalid credentials")) {
            System.out.println("Error message displayed correctly: " + errorMsg);
        } else {
            throw new AssertionError("Unexpected error message: " + errorMsg);
        }
    }

    // Close browser
    @Then("Close the browser")
    public void close_the_browser() {
        driver.quit();
    }
}
