package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GuarantyJournal {
    private final SelenideElement createGuarantyButton = $(byXpath("//div[text()='Создать']")),
    createGuarantyRegistrationApplicationOption = $(byXpath("//span[text()='На регистрацию обеспечения']")),
    createGuarantyPledgeAgreementOption = $(byXpath("//span[text()='На заключение договора залога']"));



    public GuarantyJournal openGuarantyJournal(){
        open("https://test-keden.codecraft.kz/provisions/journal");
        return this;
    }
    public GuarantyJournal createGuarantyButtonClick(){
        createGuarantyButton.click();
        return this;
    }

    public GuarantyApplication createGuarantyRegistrationApplication(){
        createGuarantyRegistrationApplicationOption.click();
        return new GuarantyApplication();
    }

    public GuarantyApplicationForPledgeAgreement createGuarantyApplicationForPledgeAgreement(){
        createGuarantyPledgeAgreementOption.click();
        return new GuarantyApplicationForPledgeAgreement();
    }

}
