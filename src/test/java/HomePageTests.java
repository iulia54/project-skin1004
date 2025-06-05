
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.HomePage;
import org.example.NavigateToSite;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTests {
    private WebDriver driver;
    private HomePage homePage;
    private static final Logger logger = LogManager.getLogger();

    @BeforeClass
    public void setUp() {
        driver = NavigateToSite.initializeDriver();
        homePage = new HomePage(driver);
        logger.info("WebDriver initialized and skin1004 site loaded");
    }

    @Test
    public void navigateToBrand() {
        homePage.brandMenuButton().click();
        logger.info("Navigated to 'Brand' section.");
    }

    @Test(dependsOnMethods = {"navigateToBrand"})
    public void navigateToCollection() {
        homePage.collectionMenuButton().click();
        logger.info("Navigated to 'Collection' section.");
    }

    @Test(dependsOnMethods = {"navigateToCollection"})
    public void navigateToSale() {
        homePage.saleMenuButton().click();
        logger.info("Navigated to 'Sale' section.");
    }

    @Test(dependsOnMethods = {"navigateToSale"})
    public void navigateToShop() {
        homePage.shopMenuButton().click();
        logger.info("Navigated to 'Shop' section.");
    }

    @Test(dependsOnMethods = {"navigateToShop"})
    public void navigateToFlagship() {
        homePage.flagshipMenuButton().click();
        logger.info("Navigated to 'Flagship' section.");
    }

    @Test(dependsOnMethods = {"navigateToFlagship"})
    public void navigateToRetailers() {
        homePage.retailersMenuButton().click();
        logger.info("Navigated to 'Retailers' section.");
    }

    @Test(dependsOnMethods = {"navigateToRetailers"})
    public void navigateToSkin1004Site() {
        homePage.goToSkin1004Site();
        logger.info("Navigated to Skin1004 external site.");
    }

    @Test(dependsOnMethods = {"navigateToSkin1004Site"})
    public void navigateToTheLeft() {
        homePage.bannerLeftArrow().click();
        logger.info("Navigated left on homepage banner.");
    }

    @Test(dependsOnMethods = {"navigateToTheLeft"})
    public void navigateToTheRight() {
        homePage.bannerRightArrow().click();
        logger.info("Navigated right on homepage banner.");
    }

    @Test(dependsOnMethods = {"navigateToTheRight"})
    public void navigateToCheckBox() {
        homePage.navigateToBox();
        logger.info("Navigated to checkbox section.");
    }

    @Test(dependsOnMethods = {"navigateToTheRight"})
    public void navigateToSearchButton() {
        homePage.performSearch();
        logger.info("Search button used for product search.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("WebDriver closed");
        }
    }
}
