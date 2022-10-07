package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.AppiumUtils;
import utils.PropertyUtils;
import utils.WaitUtils;

import javax.validation.constraints.NotNull;
import java.time.Duration;

public class BasePO {
    public final static int IMPLICIT_WAIT = PropertyUtils.getIntegerProperty("implicitWait", 30);
    WaitUtils waitUtils;
    protected final AppiumDriver<MobileElement> driver;

    protected BasePO(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        initElements();
        waitUtils = new WaitUtils();
    }

    private void initElements() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(IMPLICIT_WAIT)), this);
    }

    protected void scrollToElement(@NotNull MobileElement element) {
        while (true) {
            if (!element.isDisplayed()) {
                AppiumUtils.verticalScroll(driver);
            } else {
                break;
            }
        }
    }
}
