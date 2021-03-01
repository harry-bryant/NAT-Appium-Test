package hello


import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.jupiter.api.Test
import pageobjects.HomePage
import pageobjects.SearchFormPage
import pageobjects.SearchOptionsSelectionPage
import pageobjects.SearchResultsPage

class HomePageTest: TestBase() {

    @Test
    fun `search button has correct title`() {
        val homePage = HomePage(driver)
        assertTrue(homePage.getSearchButtonTitle()?.contains("Search") ?: false)
        //assertEquals("SearchResultsPage -> "SearchResultsView"", "SearchResultsView")
    }

    @Test
    fun `given postcode is not set and search button is tapped then location access popup should be presented`() {
        val homePage = HomePage(driver)
        homePage.clickSearch()
        homePage.locationAlertPopup.clickCurrentLocation()

        assertEquals(
                "Location access",
                homePage.locationAlertPopup.titleDisplayValue()
        )

        assertEquals("Enable current location", homePage.locationAlertPopup.getCurrentLocationButtonLabel())
        assertEquals("Enter postcode", homePage.locationAlertPopup.getEnterPostcodeButtonLabel())
    }

    @Test
    fun `select make, model and run search`() {
        val homePage = HomePage(driver)
        homePage.clickMoreFiltersButton()

        val searchFormPage = SearchFormPage(driver)
        searchFormPage.clickMakeOption()

        val searchOptionsSelectionPage = SearchOptionsSelectionPage(driver)
        searchOptionsSelectionPage.selectMake("AUDI")

        searchFormPage.clickModelOption()
        searchOptionsSelectionPage.selectModel("A3")

        searchFormPage.clickSearchButton()

        val searchResultsPage = SearchResultsPage(driver)

        assertTrue(searchResultsPage.searchResultsViewIsVisible())
    }

//    @Test
//    fun `when search button is pressed, navigates to search results`() {
//        val homePage = HomePage(driver)
//
//        // invoke the search button action to launch the search results page
//        homePage.navigateToSearchResults() // -> return an instance of SearchResultsPage
//
//        val searchResultsPage = homePage.navigateToSearchResults()
//        assertEquals(searchResultsPage.getNavigationBarTitle(), "SearchResultsView")
//    }
}