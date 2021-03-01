package pageobjects

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidFindByChainSet
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

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"More Filters\"`]")
    private var moreFiltersButton: MobileElement? = null

    fun clickMoreFiltersButton() {
        moreFiltersButton?.click()
    }

    val locationAlertPopup: LocationAlertPopupPage = LocationAlertPopupPage(driver)

    fun getSearchButtonTitle(): String? {
        return searchButton?.getAttribute("name")
    }

//    fun isSearchButtonVisible(): Boolean? {
//        return searchButton?.isDisplayed
//    }

    class LocationAlertPopupPage(driver: AppiumDriver<MobileElement>)  {
        init {
            PageFactory.initElements(AppiumFieldDecorator(driver), this)
        }

        @iOSXCUITFindBy(accessibility = "Enter postcode")
        private var enterPostcodeButton: MobileElement? = null

        @iOSXCUITFindBy(accessibility = "Enable current location")
        private var currentLocationButton: MobileElement? = null

        @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Location access\"]")
        private var title: MobileElement? = null

        fun getEnterPostcodeButtonLabel(): String? {
            return enterPostcodeButton?.getAttribute("label")
        }

        fun clickCurrentLocation() {
            currentLocationButton?.click()
        }
        
        fun getCurrentLocationButtonLabel(): String? {
            return currentLocationButton?.getAttribute("label")
        }

        fun titleDisplayValue(): String? {
            return title?.getAttribute("value")
        }

        fun isTitleVisible(): Boolean {
            return title?.isDisplayed ?: false
        }

    }

    fun clickSearch() {
        searchButton?.click()
    }
}
