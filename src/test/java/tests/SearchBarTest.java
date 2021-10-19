package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchPage;
import pages.TopMenuPage;
import utils.PageTitlesUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchBarTest extends BasteTest {

    private TopMenuPage topMenuPage;
    private SearchPage searchPage;

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitlesUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void searchingItemsOnTheSearchBar() {

        topMenuPage.enterSearch("Blouse");
        topMenuPage.clickOnSearchButton();
        List<String> productNames = searchPage.getProductNames();

        assertThat(productNames).anyMatch(el -> el.equals("Blouse"));
        assertThat(searchPage.getNumberOfItems()).isEqualTo("Showing 1 - 1 of 1 item");

    }

}
