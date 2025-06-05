import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.HomePageSecond;
import org.example.NavigateToSite;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageSecondTest {

    private WebDriver driver;
    private HomePageSecond homePageSecond;
    private static final Logger logger = LogManager.getLogger(HomePageSecondTest.class);

    @BeforeClass
    public void setUp() {
        driver = NavigateToSite.initializeDriver();
        homePageSecond = new HomePageSecond(driver);
        logger.info("WebDriver initialized and Skin1004 site loaded.");
    }

    @Test
    public void navigateToCentellaAmpoule() {
        homePageSecond.openCentelaSerum().click();
    }

    @Test(dependsOnMethods = {"navigateToCentellaAmpoule"})
    public void selectProductTypeCleanser() {
        homePageSecond.selectProductType().click();
    }

    @Test(dependsOnMethods = {"selectProductTypeCleanser"})
    public void openCleanserProduct() {
        homePageSecond.chooseCleanserProduct().click();
    }

    @Test(dependsOnMethods = {"openCleanserProduct"})
    public void buyCleanser() {
        homePageSecond.buyCleanser().click();
    }

    @Test(dependsOnMethods = {"buyCleanser"})
    public void returnToHomePage() {
        homePageSecond.navigateToHomePage().click();
    }

    @Test(dependsOnMethods = {"returnToHomePage"})
    public void scrollToSerumSection() {
        homePageSecond.scrollToTitleElement();
    }
}
