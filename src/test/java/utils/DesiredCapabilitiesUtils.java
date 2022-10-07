package utils;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.enums.KeysOfProperties;

import java.io.File;

public abstract class DesiredCapabilitiesUtils {
    private static DesiredCapabilities desiredCapabilities;
    private static final String DRIVER_TO_USE = "uiautomator2";
    private static String platformName;
    private static String platformVersion;
    private static String appPath;
    private static String deviceName;
    private static String appPackageName;
    private static String appActivityName;
    private static String enabledFullReset;
    private static String enabledNoReset;
    private static String capabilityType;

    public static DesiredCapabilities getDesiredCapabilities() {
        setPropertiesValues();
        setCapabilities();
        return desiredCapabilities;
    }

    private static void setCapabilities() {
        if (capabilityType.equals("local"))
            setAndroidDesiredCapabilitiesLocal();
        else
            setDesiredCapabilitiesAwsFarms();
    }

    private static void setAndroidDesiredCapabilitiesLocal() {
        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, DRIVER_TO_USE);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, appPath);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackageName);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivityName);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, enabledFullReset);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, enabledNoReset);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
    }

    private static void setDesiredCapabilitiesAwsFarms() {
        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackageName);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivityName);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, enabledFullReset);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, enabledNoReset);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
    }

    private static void setPropertiesValues() {
        platformName = PropertyUtils.getProperty(KeysOfProperties.PLATFORM_NAME.value);
        platformVersion = PropertyUtils.getProperty(KeysOfProperties.PLATFORM_VERSION.value);
        String APP_NAME = PropertyUtils.getProperty(KeysOfProperties.APP_NAME.value);
        String APP_RELATIVE_PATH = PropertyUtils.getProperty(KeysOfProperties.APP_RELATIVE_PATH.value) + APP_NAME;
        appPath = getAbsolutePath(APP_RELATIVE_PATH);
        deviceName = PropertyUtils.getProperty(KeysOfProperties.DEVICE_NAME.value);
        appPackageName = PropertyUtils.getProperty(KeysOfProperties.APP_PACKAGE_NAME.value);
        appActivityName = PropertyUtils.getProperty(KeysOfProperties.APP_ACTIVITY_NAME.value);
        enabledFullReset = PropertyUtils.getProperty(KeysOfProperties.APP_FULL_RESET.value);
        enabledNoReset = PropertyUtils.getProperty(KeysOfProperties.APP_NO_RESET.value);
        capabilityType = PropertyUtils.getProperty(KeysOfProperties.CAPABILITY_TYPE.value);
    }

    private static String getAbsolutePath(String appRelativePath) {
        File file = new File(appRelativePath);
        return file.getAbsolutePath();
    }
}
