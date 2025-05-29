package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GuarantyApplication {
    private final SelenideElement payerTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-payer']")),
    declarantTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-declarant']")),
    representedPersonTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-representedPerson']")),
    applicationCommonInfoTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-applicationCommonInfo']")),
    contractsTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-contracts']")),
    methodsTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-methods']")),
    notificationMessage = $(".ant-notification-notice-message"),
    applicationNumber = $(byXpath("//span[text()='Номер заявления: ']/following-sibling::text()[1]"));

    public GuarantyApplication shouldHaveSuccessNotification(String expectedText){
        notificationMessage
                .shouldBe(visible)
                .shouldHave(text(expectedText));
        return this;
    }

    public GuarantyApplication getApplicationNumber(){
        applicationNumber.getText();
        return this;
    }
}
