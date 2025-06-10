package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GuarantyApplication {
    private final SelenideElement payerTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-payer']")),
    declarantTab = $(byXpath("//span[@class='ant-menu-title-content' and text()='Декларант в ТД']")),
    representedPersonTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-representedPerson']")),
    applicationCommonInfoTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-applicationCommonInfo']")),
    contractsTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-contracts']")),
    methodsTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-methods']")),
    notificationMessage = $(".ant-notification-notice-message"),
    header = $(byXpath("//span[text()='Заявление на регистрацию обеспечения']")),
    fillPayerButton = $(byXpath("//button[@class='ant-btn css-gjh7v8 ant-btn-primary ant-btn-background-ghost']")),
    fillPayerFromAccount = $(byXpath("//span[text()='Заполнить из личного профиля']")),
    addAddressButton = $(byXpath("//span[text()='Добавить адрес']")),
    fillAddressButton = $(byXpath("//article[text()='Адрес ']/ancestor::div[@class='df ai-c']/following-sibling::button")),
    typeOfAddressField = $(byXpath("//span[@class='ant-select-selection-item']")),
    actualAddressOption = $(byXpath("//div[text()='2 - Фактический адрес']")),
    countryField = $("#country"),
    countryOption1 = $(byXpath("//div[text()='AD Княжество Андорра']")),
    saveAddressButton = $(byXpath("//div[text()='Добавить адрес']/parent::div/following-sibling::div[@class='ant-modal-footer']//button[@form='addressForm']"));

    public void shouldHaveSuccessNotification(String expectedText){
        notificationMessage
                .shouldBe(visible)
                .shouldHave(text(expectedText));
    }

    public GuarantyApplication createGuarantyApplication(){
        open("https://test-keden.codecraft.kz/provisions/journal");
        GuarantyJournal guarantyJournal = new GuarantyJournal();
        guarantyJournal.createGuarantyButtonClick().createGuarantyRegistrationApplication();
        header.shouldBe(visible);
        return this;
    }

    public GuarantyApplication fillPayerButtonClick(){
        fillPayerButton.shouldBe(Condition.visible).click();
        return this;
    }

    public GuarantyApplication fillPayerFromAccountClick(){
        fillPayerFromAccount.shouldBe(visible).click();
        addAddressButton.shouldBe(visible).click();
        fillAddressButton.shouldBe(visible).click();
        typeOfAddressField.shouldBe(visible).click();
        actualAddressOption.click();
        countryField.click();
        countryOption1.click();
        saveAddressButton.shouldBe(visible).click();
        return this;
    }

    public GuarantyApplication clickDeclarantTab(){
        declarantTab.shouldBe(visible).click();
        return this;
    }

    public GuarantyApplication addActualAddressButton(){
        addAddressButton.shouldBe(visible).click();
        return this;
    }

    public GuarantyApplication fillAddressButtonClick(){
        fillAddressButton.shouldBe(visible).click();
        return this;
    }

}
