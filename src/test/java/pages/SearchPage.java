package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends BasePage{


    public SearchPage(WebDriver driver) {super(driver);}

    @FindBy(className = "product-count")
    WebElement numberOfItems;

    @FindBy(css = ".product-container .product-name")
    List<WebElement> listOfProductName;

    public String getNumberOfItems() {
        return numberOfItems.getText();
    }

    public List<String> getProductNames(){
        return listOfProductName.stream()
                .map(el ->el.getText().trim())
                .collect(Collectors.toList());
    }
}
