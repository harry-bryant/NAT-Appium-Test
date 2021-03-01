package hello
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

class ProjectCapabilities {
    companion object {
        fun iOSBaseCapabilities() = DesiredCapabilities().apply {
            setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS")
            setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest")
            setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11")
            setCapability("bundleId", "com.autotrader.snapit")
            setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.3")
            setCapability("autoDismissAlerts", true)
        }
    }
}