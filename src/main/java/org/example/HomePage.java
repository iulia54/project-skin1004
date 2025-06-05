package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement brandMenuButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"HeaderMenu-brand\"]")));
    }

    public WebElement collectionMenuButton() {
        return driver.findElement(By.xpath("//*[@id=\"Details-HeaderMenu-2\"]"));
    }

    public WebElement saleMenuButton() {
        return driver.findElement(By.xpath("//*[@id=\"HeaderMenu-sale\"]"));
    }

    public WebElement shopMenuButton() {
        return driver.findElement(By.xpath("//*[@id=\"HeaderMenu-shop\"]"));
    }

    public WebElement flagshipMenuButton() {
        return driver.findElement(By.xpath("//*[@id=\"HeaderMenu-flagship\"]"));
    }

    public WebElement retailersMenuButton() {
        return driver.findElement(By.xpath("//*[@id=\"HeaderMenu-retailers\"]"));
    }

    public void goToSkin1004Site() {
        driver.get("https://www.skin1004.com/");
    }

    public WebElement bannerLeftArrow() {
        return driver.findElement(By.xpath("//*[@id=\"shopify-section-template--19382195880182__main_slide_banner_WUhMfT\"]/div/div/div/div[3]/div[2]"));
    }

    public WebElement bannerRightArrow() {
        WebElement rightButton = driver.findElement(By.xpath("//*[@id=\"shopify-section-template--19382195880182__main_slide_banner_WUhMfT\"]/div/div/div/div[3]/div[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", rightButton);
        return rightButton;
    }

    public WebElement navigateToBox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='cart-icon-bubble']")
        ));
        cartIcon.click();
        return cartIcon;
    }

    public WebElement performSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchToggle = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("details-modal summary")));
        try {
            searchToggle.click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", searchToggle);
        }

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input#Search-In-Modal")));
        String searchProduct = "cleanser";
        searchInput.sendKeys(searchProduct);
        searchInput.sendKeys(Keys.ENTER);

        return searchInput;
    }
}
