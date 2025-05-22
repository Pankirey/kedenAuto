package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPageAuthorized {
    private final SelenideElement goToSystemButton = $(byXpath("//span[text()='Перейти в систему']"));

    public void goToSystem(){
        goToSystemButton.shouldBe(visible).click();
    }
}
