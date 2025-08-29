package com.orangehrm.base;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.orangehrm.utility.ExtentManager;
import com.orangehrm.utility.Screenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.getinstance();
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    
    @Test
    public void question1_google() throws IOException {
        navigateurl("https://www.google.com/");
        test = extent.createTest("Verify the title of the Google page");
        String actualTitle = driver.getTitle();
        
        // Google title usually is "Google"
        if (actualTitle.equalsIgnoreCase("Google")) {
            test.pass("Google title is matched");
        } else {
            String screenPath = Screenshot.Capture(driver, "Title_mismatched");
            test.fail("Google title is not matched: " + actualTitle)
                .addScreenCaptureFromPath(screenPath);
        }
    }

    @Test
    public void question2() throws IOException {
    	 navigateurl("https://the-internet.herokuapp.com/login");
    	test = extent.createTest("Verify login functionality on HerokuApp");
    	//driver.get("https://the-internet.herokuapp.com/login");
    	
  	  driver.findElement(By.name("username")).sendKeys("tomsmith");
    	  driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
    	  driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    	  
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    WebElement flashMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

    	    String smsg = flashMsg.getText();

      
    	 if (smsg.contains("You logged into a secure area!")) {
    	        test.pass("Login successful: " + smsg);
    	        String screenpath = Screenshot.Capture(driver, "LoginSuccess");
    	        test.addScreenCaptureFromPath(screenpath);
    	    } else {
    	        test.fail("Login failed: " + smsg);
    	        String screenpath = Screenshot.Capture(driver, "LoginFailed");
    	        test.addScreenCaptureFromPath(screenpath);
    	    }
    	}
    

    @Test
    public void question3_amazonSearchUS() throws IOException, InterruptedException {
        test = extent.createTest("Amazon US Search for 'laptop'");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        navigateurl("https://www.amazon.com/");

        // Stable search box locator
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input#twotabsearchtextbox, input[name='field-keywords']")));
        searchBox.sendKeys("laptop");

        // Stable search button locator
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[type='submit'], input#nav-search-submit-button")));
        searchBtn.click();

        // Wait for results
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.s-main-slot")));

        // Fetch products
        List<WebElement> products = driver.findElements(
                By.cssSelector("span.a-size-medium.a-color-base.a-text-normal"));

        // Scroll until at least 5 products
        int attempts = 0;
        while (products.size() < 5 && attempts < 3) {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
            Thread.sleep(2000);
            products = driver.findElements(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal"));
            attempts++;
        }

        String screenPath = Screenshot.Capture(driver, "AmazonSearchResultsUS");

        if (products.size() > 0) {
            test.pass("Products found for 'laptop'").addScreenCaptureFromPath(screenPath);
            for (int i = 0; i < Math.min(5, products.size()); i++) {
                ((org.openqa.selenium.JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView(true);", products.get(i));
                Thread.sleep(500);
                test.info((i + 1) + ". " + products.get(i).getText());
                System.out.println((i + 1) + ". " + products.get(i).getText());
            }
        } else {
            test.fail("No products found for 'laptop'").addScreenCaptureFromPath(screenPath);
        }
    }

    @Test
    public void question4_handleDropdown() throws IOException {
        test = extent.createTest("Dropdown selection on Selenium Web Form");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        navigateurl("https://www.selenium.dev/selenium/web/web-form.html");

        // Wait for dropdown
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-select")));
        Select dropdown = new Select(dropdownElement);

        // Loop to select Option 2 robustly
        boolean optionSelected = false;
        for (WebElement opt : dropdown.getOptions()) {
            if (opt.getText().trim().equalsIgnoreCase("Option 2")) {
                opt.click();
                optionSelected = true;
                break;
            }
        }

        String selectedOption = dropdown.getFirstSelectedOption().getText();
        String screenPath = Screenshot.Capture(driver, "DropdownSelection");

        if (optionSelected && selectedOption.contains("Option 2")) {
            test.pass("Dropdown selection verified: " + selectedOption).addScreenCaptureFromPath(screenPath);
            System.out.println("Dropdown selection verified: " + selectedOption);
        } else {
            test.fail("Dropdown selection failed, selected: " + selectedOption).addScreenCaptureFromPath(screenPath);
            System.out.println("Dropdown selection failed, selected: " + selectedOption);
        }
    }
    @Test
    public void question5_handleAlertPopup() throws IOException {
        test = extent.createTest("Handle JS Alert Popup");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        navigateurl("https://the-internet.herokuapp.com/javascript_alerts");

        try {
            // Click the "Click for JS Alert" button
            WebElement alertButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='Click for JS Alert']")));
            alertButton.click();

            // Switch to alert and accept
            driver.switchTo().alert().accept();

            // Wait for result text
            WebElement resultText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
            String actualText = resultText.getText();

            String screenPath = Screenshot.Capture(driver, "JSAlertResult");

            if (actualText.equals("You successfully clicked an alert")) {
                test.pass("Alert handled successfully: " + actualText)
                    .addScreenCaptureFromPath(screenPath);
                System.out.println("Alert handled successfully: " + actualText);
            } else {
                test.fail("Alert handling failed: " + actualText)
                    .addScreenCaptureFromPath(screenPath);
                System.out.println("Alert handling failed: " + actualText);
            }
        } catch (Exception e) {
            String screenPath = Screenshot.Capture(driver, "JSAlertError");
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(screenPath);
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
    @Test
    public void question6_handleCheckbox() throws IOException {
        test = extent.createTest("Handle Checkboxes");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        navigateurl("https://the-internet.herokuapp.com/checkboxes");

        try {
            // Wait for checkboxes to be visible
            List<WebElement> checkboxes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.cssSelector("input[type='checkbox']")));

            // Select both checkboxes if not already selected
            for (WebElement checkbox : checkboxes) {
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
            }

            // Verify both checkboxes are selected
            boolean allSelected = true;
            for (WebElement checkbox : checkboxes) {
                if (!checkbox.isSelected()) {
                    allSelected = false;
                    break;
                }
            }

            String screenPath = Screenshot.Capture(driver, "CheckboxSelection");

            if (allSelected) {
                test.pass("Both checkboxes are selected successfully").addScreenCaptureFromPath(screenPath);
                System.out.println("Both checkboxes are selected successfully");
            } else {
                test.fail("Checkbox selection failed").addScreenCaptureFromPath(screenPath);
                System.out.println("Checkbox selection failed");
            }

        } catch (Exception e) {
            String screenPath = Screenshot.Capture(driver, "CheckboxError");
            test.fail("Exception occurred: " + e.getMessage()).addScreenCaptureFromPath(screenPath);
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
    @Test
    public void question7_webTableData() throws IOException {
        test = extent.createTest("Web Table Data Extraction");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        navigateurl("https://the-internet.herokuapp.com/tables");

        try {
            // Wait for the first table to be visible
            WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table1")));

            // Get all rows except header
            List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

            System.out.println("First names in the first table:");
            test.info("First names in the first table:");

            String jasonEmail = "";

            for (WebElement row : rows) {
                String firstName = row.findElement(By.xpath("./td[2]")).getText().trim(); // second column = first name
                System.out.println(firstName);
                test.info("First name found: " + firstName);

                if (firstName.equalsIgnoreCase("Jason")) {
                    jasonEmail = row.findElement(By.xpath("./td[3]")).getText().trim(); // email in third column
                }
            }

            String screenPath = Screenshot.Capture(driver, "WebTableData");

            if (!jasonEmail.isEmpty()) {
                test.pass("Web table data extracted successfully. Jason's email: " + jasonEmail)
                    .addScreenCaptureFromPath(screenPath);
                System.out.println("Jason's email: " + jasonEmail);
            } else {
                test.fail("Could not find Jason in the table").addScreenCaptureFromPath(screenPath);
                System.out.println("Could not find Jason in the table");
            }

        } catch (Exception e) {
            String screenPath = Screenshot.Capture(driver, "WebTableError");
            test.fail("Exception occurred: " + e.getMessage()).addScreenCaptureFromPath(screenPath);
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
    @Test
    public void question8_multipleWindows() throws IOException {
        test = extent.createTest("Multiple Windows Handling");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        navigateurl("https://the-internet.herokuapp.com/windows");

        try {
            // Click "Click Here" to open a new window
            WebElement clickHere = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Click Here")));
            clickHere.click();

            // Get all window handles
            String parentWindow = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();

            // Switch to new window
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(parentWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            // Print title of new window
            String newWindowTitle = driver.getTitle();
            System.out.println("New Window Title: " + newWindowTitle);
            String screenPathNew = Screenshot.Capture(driver, "NewWindow");
            test.pass("Switched to new window successfully. Title: " + newWindowTitle)
                .addScreenCaptureFromPath(screenPathNew);

            // Switch back to parent window
            driver.switchTo().window(parentWindow);
            String parentWindowTitle = driver.getTitle();
            System.out.println("Parent Window Title: " + parentWindowTitle);
            String screenPathParent = Screenshot.Capture(driver, "ParentWindow");
            test.pass("Switched back to parent window successfully. Title: " + parentWindowTitle)
                .addScreenCaptureFromPath(screenPathParent);

        } catch (Exception e) {
            String screenPath = Screenshot.Capture(driver, "WindowHandlingError");
            test.fail("Exception occurred: " + e.getMessage()).addScreenCaptureFromPath(screenPath);
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
    @Test
    public void question9_screenshotCapture() throws IOException {
        test = extent.createTest("Q9: Screenshot Capture");

        // Open Wikipedia homepage
        navigateurl("https://www.wikipedia.org/");

        // Capture screenshot
        String screenPath = Screenshot.Capture(driver, "homepage");

        // Verify if screenshot path is not empty and log in ExtentReports
        if (screenPath != null && !screenPath.isEmpty()) {
            test.pass("Screenshot of Wikipedia homepage captured successfully")
                .addScreenCaptureFromPath(screenPath);
            System.out.println("Screenshot saved at: " + screenPath);
        } else {
            test.fail("Failed to capture screenshot");
            System.out.println("Screenshot capture failed");
        }
    }


  public void navigateurl(String url)
  	{
  		 driver.get(url);
  	}
   

    

	@AfterMethod
    public void teardown() {
        driver.quit();
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
