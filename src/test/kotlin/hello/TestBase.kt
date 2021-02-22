package hello

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.ios.IOSDriver
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.util.concurrent.TimeUnit

open class TestBase {
    protected lateinit var driver: AppiumDriver<MobileElement>
    protected open var caps: DesiredCapabilities? = null

    @BeforeEach
    fun setUp() {
        this.driver = IOSDriver(URL("http://127.0.0.1:4723/wd/hub"), ProjectCapabilities.iOSBaseCapabilities())
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    }

    @AfterEach
    fun tearDown() {
        this.driver?.quit() ?: throw Exception("Driver instance was unable to quit.")
    }

}