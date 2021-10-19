package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage {

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(linkText = "Women")
    WebElement buttonWomen;

    @FindBy(id = "search_query_top")
    WebElement searchBar;

    @FindBy(css = "#searchbox .button-search")
    WebElement buttonSearch;

    @FindBy(linkText = "Sign in")
    WebElement signInLink;

    public void clickOnContactUsLink() {
        contactUsLink.click();
    }


    public void clickOnButtonWomen(){
        buttonWomen.click();
    }

    public void enterSearch(String search) {
        searchBar.sendKeys(search);
    }

    public void clickOnSearchButton(){
        buttonSearch.click();
    }

    public void clickOnSignInLink() {
        signInLink.click();
    }
}
