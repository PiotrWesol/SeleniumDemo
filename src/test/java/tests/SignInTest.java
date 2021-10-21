package tests;

import enums.Month;
import enums.State;
import model.AddressInformationForm;
import model.PersonalInformationForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignInFormPage;
import pages.TopMenuPage;
import utils.PageTitlesUtils;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class SignInTest extends BasteTest{

    private SignInFormPage signInFormPage;
    private TopMenuPage topMenuPage;

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        assertThat(driver.getTitle()).isEqualTo(PageTitlesUtils.HOME_PAGE_TITLE);

        signInFormPage = new SignInFormPage(driver);
        topMenuPage = new TopMenuPage(driver);
    }

    @Test
    public void createAnAccountWithCorrectData() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        topMenuPage.clickOnSignInLink();
        signInFormPage.addEmailAdressToCreateNewAccount();
        signInFormPage.clickOnButtonCreateAnAccount();

        assertThat(signInFormPage.isDisplayedPageHeading()).isTrue();

        signInFormPage.setSelectTitleMr();

        PersonalInformationForm personalInformationForm = new PersonalInformationForm();
        personalInformationForm.setFirstName("John");
        personalInformationForm.setLastName("Doe");
        personalInformationForm.setPassword("Test123");
        personalInformationForm.setMonth(Month.JUNE);

        signInFormPage.setPersonalInformationToForm(personalInformationForm);

        AddressInformationForm addressInformationForm = new AddressInformationForm();
        addressInformationForm.setFirstName("John");
        addressInformationForm.setLastName("Doe");
        addressInformationForm.setCompany("TestCompany");
        addressInformationForm.setAddress1("Casa grnade street 7/15");
        addressInformationForm.setAddress2("2 floor");
        addressInformationForm.setCity("Phoenix");
        addressInformationForm.setSelectState(State.ARIZONA);
        addressInformationForm.setPostCode("77900");
        addressInformationForm.setAdditionalInformation("Additional information test !!!");
        addressInformationForm.setMobilePhone("+48951623478");

        signInFormPage.setAddressInformationToForm(addressInformationForm);

        assertThat(signInFormPage.isWelcomingInformationDisplayed()).isEqualTo("Welcome to your account. Here you can manage all of your personal information and orders.");

    }


}
