package pageobjects

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.support.PageFactory

class SearchResultsPage(driver: AppiumDriver<MobileElement>) {
    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    //*[starts-with(@id, 'sometext') and ends-with(@id, '_text')]
    @iOSXCUITFindBy(accessibility = "SearchResultsView")
    private var searchResultsView: MobileElement? = null

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Filters\"]")
    private var filtersButton: MobileElement? = null

    fun clickFiltersButton() {
        filtersButton?.click()
    }

    fun searchResultsViewIsVisible(): Boolean {
        return searchResultsView?.isDisplayed ?: false
    }

    fun getSearchResultsViewTitle(): String {
        return searchResultsView?.text ?: ""
    }
}