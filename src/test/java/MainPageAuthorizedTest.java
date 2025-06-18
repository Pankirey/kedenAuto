import Pages.MainPageAuthorized;
import Utils.AuthService;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class MainPageAuthorizedTest extends TestBase {

    AuthService auth = new AuthService();

    @Test
    void openAuthorizedMainPageAndClickSystemButton(){
        auth.loginAs("testkeden2@proton.me","Qwerty123$");

        open("https://test-keden.codecraft.kz/");
        MainPageAuthorized mainPageAuthorized = new MainPageAuthorized();
        mainPageAuthorized.goToSystem();

    }
}
