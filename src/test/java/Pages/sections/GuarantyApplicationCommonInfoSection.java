package Pages.sections;

import Pages.Components.CalendarComponent;
import Pages.Components.DocumentUploader;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GuarantyApplicationCommonInfoSection {
    CalendarComponent calendarComponent = new CalendarComponent();
    DocumentUploader documentUploader = new DocumentUploader();
    private final SelenideElement applicationCommonInfoTab= $(byXpath("//span[@class='ant-menu-title-content' and text()='Общие данные заявления']")),
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
    docDateField = $("#docDate"),
    saveDocumentButton = $(byXpath("//div[@class='ant-space-item']/button/span[text()='Сохранить']")),
    saveApplicationCommonInfoTab = $(byXpath("//div[@id='applicationCommonInfo']/main/button"));

    public void openApplicationCommonInfoTab(){
        applicationCommonInfoTab.click();
    }
    public void fillApplicationCommonInfoTabToRussia(){
        openApplicationCommonInfoTab();
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
        docDateField.click();
        calendarComponent.setDate(LocalDate.of(2025,6,18));
        documentUploader.upload("doc.jpg");
        saveDocumentButton.scrollIntoView(true).click();
        saveApplicationCommonInfoTab.scrollIntoView(true).click();
    }
}
