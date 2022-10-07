package testCases;

import facades.PageFacades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import models.UserApp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.DesiredCapabilitiesUtils;
import utils.PropertyUtils;
import utils.ScreenshotUtility;
import utils.enums.KeysOfProperties;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners({ScreenshotUtility.class})
public abstract class BaseTest {
    public static AppiumDriver<MobileElement> driver;
    private static final String
            defaultAppiumServerUrl = "http://127.0.0.1:4723/wd/hub";
    private static final Integer defaultImplicitWait = 30;
    private final static String APPIUM_SERVER_URL = PropertyUtils.getProperty(
            KeysOfProperties.APPIUM_SERVER_URL.value, defaultAppiumServerUrl);
    public final static int IMPLICIT_WAIT = PropertyUtils.getIntegerProperty(
            KeysOfProperties.IMPLICIT_WAIT.value, defaultImplicitWait);
    protected static PageFacades pageFacades;

    /* data to tests */
    protected UserApp userToTest;
    protected String itemToTest;

    @BeforeMethod
    public void setUpAppium() throws MalformedURLException {
        driver = new AndroidDriver<>(new URL(APPIUM_SERVER_URL),
                DesiredCapabilitiesUtils.getDesiredCapabilities());

        pageFacades = new PageFacades(driver);
    }

    @BeforeTest
    public abstract void setUpPage();

    @AfterMethod(alwaysRun = true)
    public void afterMethod(final ITestResult result) {
        String fileName =
                result.getTestClass().getName() + "_" + result.getName();
        System.out.println("Test Case: [" + fileName + "] executed..!");
    }

    @AfterClass
    public void afterClass() {
    }

    @AfterSuite
    public void tearDownAppium() {
        quitDriver();
    }

    public static WebDriver getScreenshotableWebDriver() {
        return new Augmenter().augment(driver);
    }

    private static void setTimeOuts(AppiumDriver<MobileElement> driver) {
        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(
                IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    private void quitDriver() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
