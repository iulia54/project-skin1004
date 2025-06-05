package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CollectionsTab {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    public CollectionsTab(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCollectionTabElement() {
        return driver.findElement(By.xpath("//span[contains(text(),'COLLECTION')]"));
    }

    public WebElement getSkinTypeCheckbox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ProductGridContainer']//div[2]//ul/li[1]/label")));
    }

    public WebElement getSkinConcernCheckbox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ProductGridContainer']//div[2]//ul/li[1]")));
    }

    public WebElement getProductTypeCheckbox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ProductGridContainer']//div[3]//ul/li[2]/label")));
    }

    public WebElement getBuyCentellaAmpouleButton() {
        return driver.findElement(By.xpath("//*[@id=\"product-grid\"]/li[2]/div/div/div[2]/div[2]"));
    }

    public WebElement navigateToSaleSection() {
        return driver.findElement(By.xpath("//*[@id=\"HeaderMenu-sale\"]"));
    }

    public void getProductFromSalePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By locator = By.xpath("//*[@id='quick-add-template--19382195388662__product-grid9040898097398-submit']");

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            // Așteaptă să fie clickabil
            wait.until(ExpectedConditions.elementToBeClickable(locator));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            logger.info("Product from sale page clicked successfully.");

        } catch (TimeoutException e) {
            logger.error("Failed to locate or click the product from sale page in time.", e);
            throw e;
        }
    }

    public void scrollToBottomOfPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void navigateToTheSecondPage() {
        driver.findElement(By.xpath("//*[@id=\"ProductGridContainer\"]/div/div[3]/nav/ul/li[3]"));
    }

    public void clickProductSafe() {
        By locator = By.xpath("//*[@id='quick-add-template--19382195388662__product-grid9040898097398-submit']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            Thread.sleep(500); // small delay for potential animations/loaders

            try {
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                logger.info("Product button clicked successfully using regular Selenium click.");
            } catch (ElementClickInterceptedException e) {
                logger.warn("Element was intercepted. Falling back to JavaScript click.");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                logger.info("Product button clicked successfully using JavaScriptExecutor.");
            }

        } catch (Exception e) {
            logger.error("Failed to click the product button on the Sale page.", e);
        }
    }

}

