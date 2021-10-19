package pages;

import model.AddressInformationForm;
import model.PersonalInformationForm;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class SignInFormPage extends BasePage {

    public SignInFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement inputEmailAdress;

    @FindBy(className = "page-heading")
    WebElement pageHeadingCreateAnAccount;

    @FindBy(id = "SubmitCreate")
    WebElement buttonCreateAnAccount;

    @FindBy(id = "uniform-id_gender1")
    WebElement selectTitleMr;

    @FindBy(id = "uniform-id_gender2")
    WebElement selectTitleMrs;

    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;
    @FindBy(id = "customer_lastname")
    WebElement customerLastName;
    @FindBy(id = "passwd")
    WebElement inputPassword;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    WebElement specialOfferChcekbox;

    @FindBy(id = "days")
    WebElement selectDateDayOfBirth;

    @FindBy(id = "months")
    WebElement selectDateMonthOfBirth;

    @FindBy(id = "years")
    WebElement selectDateYearsOfBirth;

    @FindBy(id = "firstname")
    WebElement firstNameAddress;
    @FindBy(id = "lastname")
    WebElement lastNameAddress;
    @FindBy(id = "company")
    WebElement companyAddress;
    @FindBy(id = "address1")
    WebElement addressLine1;

    @FindBy(id = "address2")
    WebElement addressline2;

    @FindBy(id = "city")
    WebElement cityAddress;

    @FindBy(id = "id_state")
    WebElement idStateAddress;

    @FindBy(id = "postcode")
    WebElement postCodeAddress;

    @FindBy(id = "id_country")
    WebElement idCountryAddress;

    @FindBy(id = "other")
    WebElement additionalInformationAddress;

    @FindBy(id = "phone_mobile")
    WebElement phoneMobileAddress;

    @FindBy(id = "submitAccount")
    WebElement submittButtonRegister;

    @FindBy(className = "info-account")
    WebElement welcomeInfoAccount;


    public void addEmailAdressToCreateNewAccount() {

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);
        inputEmailAdress.sendKeys("username" + randomInt + "@gmail.com");
        System.out.println("Email adress: " + randomInt);

    }

    public boolean isDisplayedPageHeading() {
        wait.until(ExpectedConditions.visibilityOf(pageHeadingCreateAnAccount));
        boolean isDisplayed = false;
        try {
            isDisplayed = pageHeadingCreateAnAccount.isDisplayed();
        } catch (NoSuchElementException e) {
        }

        return isDisplayed;
    }

    public void clickOnButtonCreateAnAccount() {
        buttonCreateAnAccount.click();
    }

    public void setSelectTitleMr() {
        selectTitleMr.click();
    }


    public void setPersonalInformationToForm(PersonalInformationForm personalInformation) {


        customerFirstName.sendKeys(personalInformation.getFirstName());
        customerLastName.sendKeys(personalInformation.getLastName());
        inputPassword.sendKeys(personalInformation.getPassword());

        Select selectDay = new Select(selectDateDayOfBirth);
        selectDay.selectByIndex(5);

        Select selectMonth = new Select(selectDateMonthOfBirth);
        selectMonth.selectByIndex(personalInformation.getMonth().getValue());


        Select selectYears = new Select(selectDateYearsOfBirth);
        selectYears.selectByIndex(15);

        newsletterCheckbox.click();
        specialOfferChcekbox.click();
    }

    public void setAddressInformationToForm(AddressInformationForm addressInformationForm) {
        firstNameAddress.sendKeys(addressInformationForm.getFirstName());
        lastNameAddress.sendKeys(addressInformationForm.getLastName());
        companyAddress.sendKeys(addressInformationForm.getCompany());
        addressLine1.sendKeys(addressInformationForm.getAddress1());
        addressline2.sendKeys(addressInformationForm.getAddress2());
        cityAddress.sendKeys(addressInformationForm.getCity());

        Select selectState = new Select(idStateAddress);
        selectState.selectByIndex(addressInformationForm.getSelectState().getValue());

        postCodeAddress.sendKeys(addressInformationForm.getPostCode());

        Select selectCountry = new Select(idCountryAddress);
        selectCountry.selectByIndex(1);
        additionalInformationAddress.sendKeys(addressInformationForm.getAdditionalInformation());
        phoneMobileAddress.sendKeys(addressInformationForm.getMobilePhone());

        submittButtonRegister.click();


    }

    public String isWelcomingInformationDisplayed() {
        return welcomeInfoAccount.getText();
    }

}
