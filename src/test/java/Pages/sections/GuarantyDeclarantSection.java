package Pages.sections;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GuarantyDeclarantSection {
    private final SelenideElement declarantTab = $(byXpath("//span[@class='ant-menu-title-content' and text()='Декларант в ТД']")),
    declarantFlagPayerMatch = $(byXpath("//span[text()='Признак совпадения с Плательщиком']")),
    fillDeclarantLikePayerConfirm = $(byXpath("//div[text()='Вы хотите скопировать данные из Плательщика?']/parent::div/parent::div/following-sibling::div/button/span[text()='Да']")),
    saveDeclarantTabButton = $(byXpath("//button/span[text()='Сохранить']"));

    public void openDeclarantSection(){
        declarantTab.click();
    }

    public void fillDeclarnatByPayer(){
        openDeclarantSection();
        declarantFlagPayerMatch.click();
        fillDeclarantLikePayerConfirm.click();
        saveDeclarantTabButton.click();
    }
}
