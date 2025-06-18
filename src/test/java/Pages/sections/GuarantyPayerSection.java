package Pages.sections;

import Utils.RandomUtils;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static Utils.RandomUtils.*;

public class GuarantyPayerSection {
    private final SelenideElement payerFillButton = $(byXpath("//button[@class='ant-btn css-gjh7v8 ant-btn-primary ant-btn-background-ghost']")),
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
            savePayerTabButton = $(byXpath("//button/span[text()='Сохранить']"));

    String phoneNumber = getRandomPhoneNumber();


    public void fillByAccount(){
        payerFillButton.shouldBe(visible).click();
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
        phoneField.setValue(phoneNumber);
        savePayerButton.click();
        savePayerTabButton.click();
    }
}
