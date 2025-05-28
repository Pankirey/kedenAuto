package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GuarantyApplicationForPledgeAgreement {

    private final SelenideElement PartiesTab = $(byXpath("//li[@data-menu-id='rc-menu-uuid-84503-4-parties']")),
    notificationMessage = $(".ant-notification-notice-content");

    public GuarantyApplicationForPledgeAgreement shouldHaveSuccessNotification(String expectedText){
        notificationMessage
                .shouldBe(visible)
                .shouldHave(text(expectedText));
        return this;
    }
}
