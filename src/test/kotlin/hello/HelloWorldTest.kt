package hello


import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.jupiter.api.Test
import pageobjects.HomePage
import pageobjects.SearchResultsPage

class HelloWorldTest: TestBase() {
    @Test
    fun `search button has correct title`() {
        val homePage = HomePage(driver)
        assertTrue(homePage.getSearchButtonTitle()?.contains("Search") ?: false)
        //assertEquals("SearchResultsPage -> "SearchResultsView"", "SearchResultsView")
    }

    @Test
    fun `when search button is pressed, navigates to search results`() {
        val homePage = HomePage(driver)

        // invoke the search button action to launch the search results page
        homePage.navigateToSearchResults() // -> return an instance of SearchResultsPage

        val searchResultsPage = homePage.navigateToSearchResults()
        assertEquals(searchResultsPage.getNavigationBarTitle(), "SearchResultsView")
    }
}