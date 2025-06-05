import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.CollectionsTab;
import org.example.NavigateToSite;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CollectionTests {
    private WebDriver driver;
    private CollectionsTab colectionsTab;
    private static final Logger logger = LogManager.getLogger();

    @BeforeClass
    public void setUp() {
        driver = NavigateToSite.initializeDriver();
        colectionsTab = new CollectionsTab(driver);
        logger.info("WebDriver initialized and Skin1004 site loaded");
    }

    @Test
    public void navigateToCollectionTab() {
        colectionsTab.getCollectionTabElement().click();
        logger.info("Navigated to COLLECTION tab");
    }

    @Test(dependsOnMethods = {"navigateToCollectionTab"})
    public void chooseSkinType() {
        colectionsTab.getSkinTypeCheckbox().click();
        logger.info("Skin type checkbox selected");
    }

    @Test(dependsOnMethods = {"chooseSkinType"})
    public void chooseSkinConcerns() {
        colectionsTab.getSkinConcernCheckbox().click();
        logger.info("Skin concern selected");
    }

    @Test(dependsOnMethods = {"chooseSkinConcerns"})
    public void chooseProductType() {
        colectionsTab.getProductTypeCheckbox().click();
        logger.info("Product type selected");
    }

    @Test(dependsOnMethods = {"chooseProductType"})
    public void buySinCare() {
        colectionsTab.getBuyCentellaAmpouleButton().click();
    }

    @Test(dependsOnMethods = {"buySinCare"})
    public void refreshThePage() {
        driver.navigate().refresh();
        logger.info("Page refreshed");
    }

    @Test(dependsOnMethods = {"refreshThePage"})
    public void goToSaleSection() {
        colectionsTab.navigateToSaleSection().click();
        logger.info("Navigated to SALE section");
    }

    @Test(dependsOnMethods = {"goToSaleSection"})
    public void chooseProductFromSalePage() {
        colectionsTab.getProductFromSalePage();
        logger.info("Selected product from SALE page");
    }

    @Test(dependsOnMethods = {"chooseProductFromSalePage"})
    public void scrollToBottom() {
        colectionsTab.scrollToBottomOfPage();
        logger.info("Scrolled to bottom of the page");
    }

    @Test(dependsOnMethods = {"scrollToBottom"})
    public void goToPageTwoFromSale() {
        colectionsTab.navigateToTheSecondPage();
        logger.info("Navigated to page 2 in SALE");
    }

    @Test(dependsOnMethods = {"goToPageTwoFromSale"})
    public void refreshPage() {
        driver.navigate().refresh();
        logger.info("Final page refresh");
    }

    @Test(dependsOnMethods = {"refreshPage"})
    public void buyProductFromSecondPage() {
        colectionsTab.clickProductSafe();
        logger.info("Product bought from second page");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("WebDriver was closed.");
        }
    }
}
