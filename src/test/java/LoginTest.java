import Pages.LoginPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class LoginTest extends TestBase{
    LoginPage loginPage = new LoginPage();

    @Test
    void successfulLoginTest(){
        loginPage.openPage().
                setUsername("testkeden2@proton.me").
                setPassword("Qwerty123$").
                loginClick();
    }
}
