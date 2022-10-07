package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitUtils {
    public final int explicitWaitDefault = PropertyUtils.getIntegerProperty("explicitWait", 10);

    void staticWait(final long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

    WebElement waitForElementToBeClickable(final WebElement element, final WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.elementToBeClickable(element));

        return element;
    }

    WebElement waitForElementToBeClickable(
            final WebElement element, final WebDriver driver, long millisecondsToWait) {
        new WebDriverWait(driver, millisecondsToWait)
                .until(ExpectedConditions.elementToBeClickable(element));

        return element;
    }

    void waitForElementToBeVisible(final WebElement element, final WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.visibilityOf(element));
    }

    void waitForElementToBeVisible(
            final WebElement element, final WebDriver driver, long milliseconds) {
        new WebDriverWait(driver, milliseconds)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public MobileElement waitForElementToBePresent(final MobileElement element, final WebDriver driver) {
        int count = 0;
        while (true) {
            boolean visible = waitForElementToBePresentFlux(element, driver);
            if (visible) {
                return element;
            }
            
            if (count > 3) {
                throw new RuntimeException();
            }

            count++;
        }
    }

    private boolean waitForElementToBePresentFlux(final MobileElement element, final WebDriver driver) {
        boolean isElementPresent;
        try {
            WebDriverWait wait = new WebDriverWait(driver, this.explicitWaitDefault);
            wait.until(ExpectedConditions.visibilityOf(element));
            isElementPresent = element.isDisplayed();
            return isElementPresent;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    public void waitForElementToBeInvisible(final By locator, final WebDriver driver) {
        long s = System.currentTimeMillis();
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementToBePresent(final By locator, final WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }



    public void waitForElementToBeVisible(final By locator, final WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }



    public void waitForElementToBeVisible(final IOSElement element, final WebDriver driver, int time) {
        long s = System.currentTimeMillis();
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementsToBeInvisible(final List<WebElement> elements, final WebDriver driver) {
        final long s = System.currentTimeMillis();
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public void waitForElementToBeNotPresent(final By element, WebDriver driver) {
        long s = System.currentTimeMillis();
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(element)));
    }

    public void waitUntilNestedElementPresent(WebElement element, By locator, WebDriver driver) {
        new WebDriverWait(driver, explicitWaitDefault)
                .until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, locator));
    }
}
