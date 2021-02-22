package pageobjects

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.support.PageFactory

class HomePage(driver: AppiumDriver<MobileElement>) {
    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    //*[starts-with(@id, 'sometext') and ends-with(@id, '_text')]
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[starts-with(@name, \"Search \")]")
    private var searchButton: MobileElement? = null

    fun getSearchButtonTitle(): String? {
        return searchButton?.getAttribute("name")
    }

    fun isSearchButtonVisible(): Boolean? {
        return searchButton?.isDisplayed
    }

    fun navigateToSearchResults() {
        searchButton?.click()
    }
}