package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageSecond {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger(HomePageSecond.class);

    public HomePageSecond(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement openCentelaSerum() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By locator = By.xpath("//*[contains(@id, 'swiper-wrapper')]/div[1]//div[5]/a");

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        return element;
    }

    public WebElement selectProductType() {
        return driver.findElement(By.xpath("//*[@id=\"ProductGridContainer\"]/div/div[2]/div[2]/div/div/div[1]/ul/li[2]"));
    }

    public WebElement chooseCleanserProduct() {
        return driver.findElement(By.xpath("//*[@id=\"product-grid\"]/li[2]/div/div/div[1]/div[2]"));
    }

    public WebElement buyCleanser() {
        return driver.findElement(By.xpath("//*[@id=\"ProductSubmitButton-template--19382196797686__main\"]"));
    }

    public WebElement navigateToHomePage() {
        return driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--19382190637302__header\"]/sticky-header/header/a/div[1]"));
    }

    public void scrollToTitleElement() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement midlleTitle = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(@id,'swiper-wrapper')]//div[contains(@class,'swiper-slide-active')]//div[3]/div")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", midlleTitle);
            wait.until(ExpectedConditions.elementToBeClickable(midlleTitle)).click();
        } catch (Exception e) {
            logger.error("The element was not found or is not in the active slide.", e);
        }
    }
}
