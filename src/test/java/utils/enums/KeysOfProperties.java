package utils.enums;

public enum KeysOfProperties {
    PLATFORM_NAME("android.platform"),
    PLATFORM_VERSION("android.platform.version"),
    APP_NAME("android.app.name"),
    DEVICE_NAME("android.device.name"),
    APP_RELATIVE_PATH("android.app.hml.location"),
    APP_PACKAGE_NAME("android.app.packageName"),
    APP_ACTIVITY_NAME("android.app.activityName"),
    APP_FULL_RESET("android.app.full.reset"),
    APP_NO_RESET("android.app.no.reset"),
    APPIUM_SERVER_URL("appium.server.url"),
    IMPLICIT_WAIT("implicitWait"),
    CAPABILITY_TYPE("capabilities.option");


    public final String value;
    KeysOfProperties(String value) {
        this.value = value;
    }
}
