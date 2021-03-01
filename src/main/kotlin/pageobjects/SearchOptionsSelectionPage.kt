package pageobjects

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.By
import org.openqa.selenium.support.PageFactory

class SearchOptionsSelectionPage(val driver: AppiumDriver<MobileElement>) {
    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

fun selectMake(make: String) {
    driver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"$make\"]")).click()
}

    fun selectModel(model: String){
        driver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"$model\"]")).click()
    }



}


//XCUIElementTypeStaticText[@name="Make"]