package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class WomenSectionPage extends BasePage{

    public WomenSectionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".price.product-price")
    List<WebElement> productPrices;

    public List<String> getProductPrices(){
        return productPrices.stream()
                .map(el -> el.getText().trim())
                .map(el -> el.replace("$",""))
                .filter(el -> !el.isEmpty())
                .collect(Collectors.toList());

    }

    public List<Float> getProductPricesFloat(){
        return getProductPrices().stream()
                .map(Float::parseFloat)
                .collect(Collectors.toList());
    }
}
