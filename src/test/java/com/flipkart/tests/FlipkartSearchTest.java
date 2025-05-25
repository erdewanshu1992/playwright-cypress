// com.flipkart.tests.FlipkartSearchTest.java
package com.flipkart.tests;

import com.flipkart.base.BaseTest;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.SearchResultsPage;
import org.testng.annotations.Test;

public class FlipkartSearchTest extends BaseTest {

    @Test
    public void testSearchFunctionality() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResults = new SearchResultsPage(driver);

        homePage.closeLoginPopupIfPresent();
        homePage.searchFor("laptop");

        searchResults.printAllProductNames();
    }
}
