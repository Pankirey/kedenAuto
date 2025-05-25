package Pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GuarantyJournal {
    private final SelenideElement createGuarantyButton = $(byXpath("//div[text()='Создать']")),
    createGuarantyRegistrationApplicationOption = $(byXpath("//span[text()='На регистрацию обеспечения']")),
    createGuarantyPledgeAgreementOption = $(byXpath("//span[text()='На регистрацию обеспечения']"));

    public GuarantyJournal createGuarantyButtonClick(){
        createGuarantyButton.click();
        return this;
    }

    public GuarantyRegistrationApplication createGuarantyRegistrationApplication(){
        createGuarantyRegistrationApplicationOption.click();
        return new GuarantyRegistrationApplication();
    }
}
