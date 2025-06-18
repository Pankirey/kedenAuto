package Pages;

import Pages.Components.CalendarComponent;
import Pages.Components.DocumentUploader;
import Pages.sections.*;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GuarantyApplication {

    CalendarComponent calendarComponent = new CalendarComponent();
    DocumentUploader documentUploader = new DocumentUploader();
    public GuarantyPayerSection payer = new GuarantyPayerSection();
    public GuarantyDeclarantSection declarant = new GuarantyDeclarantSection();
    public GuarantyRepresentedPersonSection representedPerson = new GuarantyRepresentedPersonSection();
    public GuarantyApplicationCommonInfoSection guarantyApplicationCommonInfoSection = new GuarantyApplicationCommonInfoSection();
    public GuarantyPaymentMethodsSection guarantyPaymentMethodsSection = new GuarantyPaymentMethodsSection();
    private final SelenideElement payerTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-payer']")),
    applicationCommonInfoTab = $(byXpath("//span[@class='ant-menu-title-content' and text()='Общие данные заявления']")),
    contractsTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-contracts']")),
    methodsTab = $(byXpath("//span[@class='ant-menu-title-content' and text()='Иные способы обеспечения']")),
    notificationMessage = $(".ant-notification-notice-message"),
    header = $(byXpath("//span[text()='Заявление на регистрацию обеспечения']")),
    refusalReasonsButton = $(byXpath("//div[@class='ant-space-item']/button/span[text()='Причины отказа']")),
    checkApplicationButton = $(byXpath("//div[@class='ant-space-item']/button/span[text()='Проверить данные']")),
    checkApplicationResultButton = $(byXpath("//div[@class='ant-space-item']/button/span[text()='Результат проверок']")),
    closeApplicationResultButton = $(byXpath("//div[@class='ant-modal-content']/button")),
    signSendButton = $(byXpath("//div[@class='ant-space-item']/button/span[text()='Подписать и отправить']")),
    firstCheckboxBeforeSign = $(byXpath("(//span[contains(@class,'ant-checkbox ant-wave-target ')])[1]")),
    secondCheckboxBeforeSign = $(byXpath("(//span[contains(@class,'ant-checkbox ant-wave-target ')])[2]")),
    continueToSignButton = $(byXpath("//button/span[text()='Продолжить']"));


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
    public GuarantyApplication fillAll(){
        payer.fillByAccount();
        declarant.fillDeclarnatByPayer();
        representedPerson.fillRepresentedPersonTab();
        guarantyApplicationCommonInfoSection.fillApplicationCommonInfoTabToRussia();
        guarantyPaymentMethodsSection.fillMoneyPaymentMethod();
        return this;
    }
    public GuarantyApplication checkSignSend(){
        checkApplicationButton.scrollIntoView(true).click();
        checkApplicationResultButton.click();
        closeApplicationResultButton.click();
        signSendButton.click();
        firstCheckboxBeforeSign.shouldBe(visible).click();
        secondCheckboxBeforeSign.scrollIntoView(true).shouldBe(visible).click();
        continueToSignButton.click();
        return this;
    }
}
