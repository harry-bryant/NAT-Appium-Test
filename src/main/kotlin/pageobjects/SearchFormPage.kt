package pageobjects

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.support.PageFactory

class SearchFormPage(driver: AppiumDriver<MobileElement>) {
    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[starts-with(@name, \"Make\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Auto Trader\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeOther[1]")
    private var makeOption: MobileElement? = null

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Auto Trader\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeOther[1]")
    private var modelOption: MobileElement? = null

    @iOSXCUITFindBy(accessibility = "Run Search")
    private var searchButton: MobileElement? = null

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Filter search\"]")
    private var searchFormView: MobileElement? = null

    fun isVisible(): Boolean {
        return searchFormView?.isDisplayed ?: false
    }

    fun clickMakeOption() {
        makeOption?.click()
    }

    fun clickModelOption() {
        modelOption?.click()
    }

    fun clickSearchButton() {
        searchButton?.click()
    }

}