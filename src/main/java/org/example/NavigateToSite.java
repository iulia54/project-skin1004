package org.example;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NavigateToSite {

    public static WebDriver initializeDriver() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.skin1004.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement acceptCookie = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(70) > div > div:nth-child(2) > div > div > div > div > div > form > div:nth-child(2) > div:nth-child(7) > div > button")));
            acceptCookie.click();
            System.out.println("Cookies were accepted!");
        } catch (Exception e) {
            System.out.println("Cookies pop-up not found.");
        }
        return driver;
    }
}
