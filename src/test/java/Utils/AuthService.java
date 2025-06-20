package Utils;

import Pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AuthService {

    public void loginAs(String username, String password){
        new LoginPage()
                .openPage()
                .setUsername(username)
                .setPassword(password)
                .loginClick();
    }
}
