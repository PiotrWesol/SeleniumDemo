package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TopMenuPage;
import pages.WomenSectionPage;
import utils.PageTitlesUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WomenSectionTest extends BasteTest{

    private TopMenuPage topMenuPage;
    private WomenSectionPage womenSectionPage;

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitlesUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        womenSectionPage = new WomenSectionPage(driver);
    }

    @Test

    public void productPricesShouldNotBeZeroInTheWomenSection () {
        topMenuPage.clickOnButtonWomen();

        List<Float> productPrices = womenSectionPage.getProductPricesFloat();

        boolean allPricesHigherThanZero = productPrices.stream()
                .allMatch(s -> s > 0);

        Assertions.assertThat(allPricesHigherThanZero).isTrue();

    }



}
