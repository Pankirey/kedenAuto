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
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GuarantyApplication {
    private final SelenideElement payerTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-payer']")),
    declarantTab = $(byXpath("//span[@class='ant-menu-title-content' and text()='Декларант в ТД']")),
    representedPersonTab = $(byXpath("//span[@class='ant-menu-title-content' and text()='Представлен в лице']")),
    applicationCommonInfoTab = $(byXpath("//span[@class='ant-menu-title-content' and text()='Общие данные заявления']")),
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
    saveAddressButton = $(byXpath("//div[text()='Добавить адрес']/parent::div/following-sibling::div[@class='ant-modal-footer']//button[@form='addressForm']")),
    addContactButton = $(byXpath("//span[text()='Добавить контакт']")),
    typeOfContactForEmail = $("#contacts_0_communicationRemedy"),
    typeOfContactForPhone = $("#contacts_1_communicationRemedy"),
    emailContactOption = $(byXpath("//div[@title='Электронная почта']")),
    phoneContactOption = $(byXpath("(//div[@title='Телефон'])[2]")),
    emailField = $("#contacts_0_communicationIdentifier"),
    phoneField = $("#contacts_1_communicationIdentifier"),
    savePayerButton = $(byXpath("//div[text()='Добавить контрагента']/parent::div/following-sibling::div[@class='ant-modal-footer']//button[@form='addressForm']")),
    savePayerTabButton = $(byXpath("//button/span[text()='Сохранить']")),
    declarantFlagPayerMatch = $(byXpath("//span[text()='Признак совпадения с Плательщиком']")),
    fillDeclarantLikePayerConfirm = $(byXpath("//div[text()='Вы хотите скопировать данные из Плательщика?']/parent::div/parent::div/following-sibling::div/button/span[text()='Да']")),
    saveDeclarantTabButton = $(byXpath("//button/span[text()='Сохранить']")),
    phoneOfRepresentedPerson = $("#contacts_1_communicationIdentifier"),
    checkDocumentInGBDFLButton = $(byXpath("//span[text()='Проверить документ в ГБД ФЛ']")),
    documentFromGBDFLInfo = $(byXpath("//div[@class='df ai-c fw-w']")),
    saveRepresentedPersonTabButton = $(byXpath("//button[@type='submit']//span[text()='Сохранить']")),
    guarantyTypeField = $("#guaranty_guarantyType"),
    enforcementOfDutyOption = $(byXpath("//div[@class='ant-select-item-option-content' and text()='Обеспечение исполнения обязанности']")),
    guarantyRequiredSum = $("#guarantyInfo_requiredSum"),
    guarantyCaseField = $("#guaranty_guarantyCase"),
    customsTransitOption = $(byXpath("//div[@title = 'Таможенный транзит']")),
    customsRegistrationAuthority = $("#guaranty_customs"),
    zhetysuAuthority = $(byXpath("//div[@title = '55301 ТАМОЖЕННЫЙ ПОСТ «ЖЕТЫСУ»']")),
    departureCustomsField = $("#guaranty_departureCustoms"),
    zhetysuAuthorityRegistration = $(byXpath("//div[@title = '39855301 ТАМОЖЕННЫЙ ПОСТ «ЖЕТЫСУ»']")),
    gurantyDestinationCustomsField=$("#guaranty_destinationCustoms"),
    saintPetersburgCustomPost = $(byXpath("//div[@title = '12402000 ЭКС ЦЭКТУ г. Санкт-Петербург']")),
    addCountryButton = $(byXpath("//button/span[text()='Добавить страну']")),
    departureCountryField = $("#departureCountry"),
    addRussiaOption = $(byXpath("//div[@title = 'RU Российская Федерация']")),
    addDocumentOfApplicationInfoButton = $(byXpath("//button/span[text()='Добавить документ']")),
    documentTypeField = $("#documentType"),
    copyNameOfDocumentCheckBox = $(byXpath("//span[text()='Скопировать с графы \"Вид документа\"']")),
    docNumberField = $("#docNumber"),
    docDateField = $("#docDate");


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


    public GuarantyApplication fillPayerAndSave(){
        fillPayerButton.shouldBe(visible).click();
        fillPayerFromAccount.shouldBe(visible).click();
        addAddressButton.shouldBe(visible).click();
        fillAddressButton.shouldBe(visible).click();
        typeOfAddressField.shouldBe(visible).click();
        actualAddressOption.click();
        countryField.click();
        countryOption1.click();
        saveAddressButton.shouldBe(visible).click();
        addContactButton.shouldBe(visible).click();
        typeOfContactForEmail.shouldBe(visible).click();
        emailContactOption.shouldBe(visible).click();
        emailField.setValue("asdfqwer@gmail.com");
        addContactButton.click();
        typeOfContactForPhone.shouldBe(visible).click();
        phoneContactOption.shouldBe(visible).click();
        phoneField.setValue("+77788482570");
        savePayerButton.click();
        savePayerTabButton.click();
        return this;
    }

    public GuarantyApplication fillDeclarant(){
        declarantTab.shouldBe(visible).click();
        declarantFlagPayerMatch.shouldBe(visible).click();
        fillDeclarantLikePayerConfirm.click();
        saveDeclarantTabButton.click();
        return this;
    }

    public GuarantyApplication fillRepresentedPerson(){
        representedPersonTab.click();
        phoneOfRepresentedPerson.sendKeys("+77088780570");
        checkDocumentInGBDFLButton.click();
        documentFromGBDFLInfo.shouldBe(visible);
        saveRepresentedPersonTabButton.click();
        return this;
    }

    public GuarantyApplication fillApplicationCommonInfo(){
        applicationCommonInfoTab.click();
        guarantyTypeField.click();
        enforcementOfDutyOption.shouldBe(visible).click();
        guarantyRequiredSum.setValue("50000");
        guarantyCaseField.click();
        customsTransitOption.click();
        customsRegistrationAuthority.setValue("55301");
        zhetysuAuthority.click();
        departureCustomsField.setValue("55301");
        zhetysuAuthorityRegistration.click();
        gurantyDestinationCustomsField.setValue("1240200");
        saintPetersburgCustomPost.click();
        addCountryButton.click();
        departureCountryField.setValue("RU");
        addRussiaOption.shouldBe(visible).click();
        addDocumentOfApplicationInfoButton.click();
        documentTypeField.click();
        documentTypeField.sendKeys(Keys.ENTER);
        copyNameOfDocumentCheckBox.click();
        docNumberField.setValue("Номер документа");
        docDateField.setValue("13.06.2025");


        return this;
    }

}
