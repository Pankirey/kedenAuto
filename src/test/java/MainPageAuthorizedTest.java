import Pages.MainPageAuthorized;
import Utils.AuthApi;
import Utils.AuthHelper;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class MainPageAuthorizedTest {
    @Test
    void openAuthorizedMainPageAndClickSystemButton(){
        String token = AuthApi.getToken("testkeden2@proton.me","Qwerty123$");
        AuthHelper.authorizeWithToken(token);

        open("https://test-keden.codecraft.kz/");
        MainPageAuthorized mainPageAuthorized = new MainPageAuthorized();
        mainPageAuthorized.goToSystem();

    }
}
