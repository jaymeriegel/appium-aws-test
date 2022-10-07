package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class AppiumUtils {
    public static WaitUtils waitUtils = new WaitUtils();

    public static void waitAndClick(final MobileElement mobileElement, final WebDriver driver) {
        waitUtils.waitForElementToBeClickable(mobileElement, driver).click();
    }

    public static void waitAndClick(
            final MobileElement mobileElement, final WebDriver driver, long millisecondsToWait) {
        waitUtils.waitForElementToBeClickable(mobileElement, driver).click();
    }

    public static void waitAndSendKeys(
            final MobileElement mobileElement, final WebDriver driver, String text) {
        waitUtils.waitForElementToBeClickable(mobileElement, driver).sendKeys(text);
    }

    public static void staticWait(long milliseconds) {
        waitUtils.staticWait(milliseconds);
    }

    public static void waitForElementToBeVisible(final MobileElement mobileElement, WebDriver driver) {
        waitUtils.waitForElementToBeVisible(mobileElement, driver);
    }

    public static void waitForElementToBeVisible(
            final MobileElement mobileElement, WebDriver driver, long milliseconds) {
        waitUtils.waitForElementToBeVisible(mobileElement, driver);
    }

    public static void clickOnPoint(int x, int y, AppiumDriver<MobileElement> driver) {
        new TouchAction(driver)
                .press(PointOption.point(x, y)).release().perform();
    }

    public static void clickEnterOnKeyBoard(AppiumDriver<MobileElement> driver) {
        driver.getKeyboard().pressKey("\n");
    }

    public static void scrollToElement(MobileElement element, AppiumDriver<MobileElement> driver) {
        while (!element.isDisplayed()) {
            verticalScroll(driver);
            staticWait(700);
        }
    }

    public static boolean isElementDisplayed(MobileElement element) {
        waitUtils.staticWait(500);
        return element.isDisplayed();
    }

    public static void verticalScroll(AppiumDriver<MobileElement> driver) {
        Dimension size = driver.manage().window().getSize();
        int start_Y = (int) (size.getHeight() * 0.75);
        int end_Y = (int) (size.getHeight() * 0.10);
        int start_end_X = (int) (size.getWidth() * 0.50);

        new TouchAction(driver).press(PointOption.point(start_end_X, start_Y))
                .waitAction(waitOptions(ofSeconds(2)))
                .moveTo(PointOption.point(start_end_X, end_Y)).release().perform();
    }

    public static void scrollUpToElement(MobileElement element, AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int start_Y = (int) (size.getHeight() * 0.80);
        int end_Y = (int) (size.getHeight() * 0.20);
        int start_end_X = (int) (size.getWidth() * 0.50);
        while (!isElementDisplayed((MobileElement) element)) {
            TouchAction swipe = new TouchAction(driver).press(PointOption.point(start_end_X, end_Y))
                    .waitAction(waitOptions(ofSeconds(2)))
                    .moveTo(PointOption.point(start_end_X, start_Y)).release().perform();
        }
    }

    public static void verticalScroll(AppiumDriver driver, int startY, int endY) {
        Dimension size = driver.manage().window().getSize();
        // int start_Y = (int) (size.getHeight() * 0.95);
        //  int end_Y = (int) (size.getHeight() * 0.10);
        int start_end_X = (int) (size.getWidth() * 0.50);

        TouchAction swipe = new TouchAction(driver).press(PointOption.point(start_end_X, startY))
                .waitAction(waitOptions(ofSeconds(6)))
                .moveTo(PointOption.point(start_end_X, endY)).release().perform();
    }

    public static void doSwipe(int startX, int startY, int endX, int endY, AppiumDriver driver) {
        TouchAction swipe = new TouchAction(driver).press(PointOption.point(startX, startY))
                .waitAction(waitOptions(ofMillis(800)))
                .moveTo(PointOption.point(endX, endY)).release().perform();
    }

    public static String getRandomNumber() {
        return String.valueOf(System.currentTimeMillis() % 100000);
    }

    public static boolean isAlertPresent(AppiumDriver driver) {
        boolean alertIsPresent = false;
        try {
            driver.switchTo().alert();
            alertIsPresent = true;
        } catch (Exception ex) {
            alertIsPresent = false;
        }
        return alertIsPresent;
    }

    public static AndroidElement getElementFromText(AppiumDriver driver, List<AndroidElement> elementList, String textOfElement) {
        for (AndroidElement el : elementList) {
            if (textOfElement.equals(el.getText())) {
                return el;
            }
        }
        return null;
    }

}
