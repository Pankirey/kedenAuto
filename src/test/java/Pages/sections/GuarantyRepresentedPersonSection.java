package Pages.sections;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GuarantyRepresentedPersonSection {
    private final SelenideElement representedPersonTab = $(byXpath("//span[@class='ant-menu-title-content' and text()='Представлен в лице']")),
    phoneOfRepresentedPerson = $("#contacts_1_communicationIdentifier"),
    checkDocumentInGBDFLButton = $(byXpath("//span[text()='Проверить документ в ГБД ФЛ']")),
    documentFromGBDFLInfo = $(byXpath("//div[@class='df ai-c fw-w']")),
    saveRepresentedPersonTabButton = $(byXpath("//button[@type='submit']//span[text()='Сохранить']"));

    public void openRepresentedPersonTab(){
        representedPersonTab.click();
    }
    public void fillRepresentedPersonTab(){
        openRepresentedPersonTab();
        phoneOfRepresentedPerson.sendKeys("+77088780570");
        checkDocumentInGBDFLButton.click();
        documentFromGBDFLInfo.shouldBe(visible);
        saveRepresentedPersonTabButton.click();
    }
}
