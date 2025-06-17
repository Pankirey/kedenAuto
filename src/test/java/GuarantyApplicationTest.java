import Pages.GuarantyApplication;
import Utils.AuthService;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class GuarantyApplicationTest extends TestBase{
    AuthService auth = new AuthService();

    @Test
      public void successfulGuarantyApplicationSendForRegistration(){
        auth.loginAs("testkeden2@proton.me","Qwerty123$");
        GuarantyApplication guarantyApplication = new GuarantyApplication();
        guarantyApplication.createGuarantyApplication()
                .fillPayerAndSave()
                .fillDeclarant()
                .fillRepresentedPerson()
                .fillApplicationCommonInfo()
                .fillMoneyDepositPaymentMethod()
                .checkSignSend();
        Selenide.sleep(5000);
    }
}
