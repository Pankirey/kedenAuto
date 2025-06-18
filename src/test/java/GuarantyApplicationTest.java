import Pages.Components.CalendarComponent;
import Pages.GuarantyApplication;
import Utils.AuthService;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class GuarantyApplicationTest extends TestBase{
    AuthService auth = new AuthService();

    @Test
    @DisplayName("Проверка успешной отправки сертификата обеспечения на страны ПКОП")
      public void successfulGuarantyApplicationSendForRegistration(){
        auth.loginAs("testkeden2@proton.me","Qwerty123$");
        GuarantyApplication guarantyApplication = new GuarantyApplication();
        guarantyApplication.createGuarantyApplication()
                .fillAll()
                .checkSignSend();
    }
}
