package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GuarantyApplication {
    private final SelenideElement payerTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-payer']")),
    declarantTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-declarant']")),
    representedPersonTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-representedPerson']")),
    applicationCommonInfoTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-applicationCommonInfo']")),
    contractsTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-contracts']")),
    methodsTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-43754-4-methods']")),
    notificationMessage = $(".ant-notification-notice-message"),
    header = $(byXpath("//span[text()='Заявление на регистрацию обеспечения']")),
    fillPayerButton = $(byXpath("//button[@class='ant-btn css-gjh7v8 ant-btn-primary ant-btn-background-ghost']"));

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

}
