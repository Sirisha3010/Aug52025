package com.orangehrm.pages;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.Login_PageFactory;
import com.orangehrm.utility.ExcelUtiles;

public class LoginOrangeHRM extends BaseTest {

    Login_PageFactory loginPage;

    // Excel file path and sheet name
    String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Testdata\\data.xlsx";
    String sheetName = "Sheet1"; // update if your sheet name is different

    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException {
        return ExcelUtiles.getdata(excelPath, sheetName);
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        // Initialize page object
        loginPage = new Login_PageFactory(driver);

        // Debug print
        System.out.println("Trying login with -> Username: " + username + ", Password: " + password);

        // Enter credentials and click login
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        // Small wait for page load
        try {
            Thread.sleep(2000); // optional: replace with WebDriverWait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Assertion: check page title after login
        String expectedTitle = "OrangeHRM"; // replace with your actual post-login title
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Login failed: Title mismatch!");
    }
}
