package Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement usernameInput = $("#username"),
    passwordInput = $("#password"),
    loginButton = $(byXpath("//input[@value='Войти']")),
    forgotPasswordText = $(byLinkText("Забыли пароль?")),
    singUpText = $(byLinkText("Зарегистрируйтесь"));

    public LoginPage openPage(){
        open("https://test-keden.codecraft.kz/login");
        return this;
    }

    public LoginPage setUsername(String username){
        usernameInput.setValue(username);
        return this;
    }

    public LoginPage setPassword(String password){
        passwordInput.setValue(password);
        return this;
    }

    public MainPageAuthorized loginClick(){
        loginButton.click();
        return new MainPageAuthorized();
    }
}
