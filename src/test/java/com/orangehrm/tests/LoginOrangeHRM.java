package com.orangehrm.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPageFactory;
import com.orangehrm.utility.ExcelUtiles;

public class LoginOrangeHRM extends BaseTest {

    LoginPageFactory loginPage;

    // Excel file path and sheet name
    String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Testdata\\data.xlsx";
    String sheetName = "Sheet1"; // Update if your sheet name is different

    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException {
        return ExcelUtiles.getdata(excelPath, sheetName);
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        // Initialize page object
        loginPage = new LoginPageFactory(driver);

        // Debug: show driver and page object
        System.out.println("Driver null? " + (driver == null));
        System.out.println("LoginPage initialized? " + (loginPage != null));

        // Debug: show credentials
        System.out.println("Trying login with -> Username: " + username + ", Password: " + password);

        // Wait for username field to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginPage.usernameField));

        // Enter credentials and click login
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);

        // Wait until login button is clickable and click
        WebElement loginBtn = loginPage.loginButton;
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();

        // Wait for dashboard page to load (adjust if necessary)
        wait.until(ExpectedConditions.titleContains("OrangeHRM")); // Update to your dashboard title

        // Debug: print actual title
        String actualTitle = driver.getTitle();
        System.out.println("Actual title after login: " + actualTitle);

        // Assertion: title contains "OrangeHRM" (adjust if necessary)
        Assert.assertTrue(actualTitle.contains("OrangeHRM"), 
                "Login failed for Username: " + username);

        System.out.println("Login successful for Username: " + username);
    }
}
