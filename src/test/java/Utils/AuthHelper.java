package Utils;

import static com.codeborne.selenide.Selenide.*;

public class AuthHelper {
    public static void authorizeWithToken(String token) {
        open("https://test-keden.codecraft.kz"); // чтобы инициализировать localStorage
        executeJavaScript("localStorage.setItem('jwt', '" + token + "');");
        refresh(); // чтобы применился токен
    }
}
