import Pages.GuarantyApplication;
import Pages.GuarantyApplicationForPledgeAgreement;
import Pages.GuarantyJournal;
import Utils.AuthService;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static java.nio.channels.Selector.open;

public class GuarantyJournalTest {

    AuthService auth = new AuthService();

    @Test
    void successfulCreatingGuarantyApplicationForRegistration(){
        auth.loginAs("testkeden2@proton.me","Qwerty123$");

        GuarantyJournal guarantyJournal = new GuarantyJournal();
        guarantyJournal.openGuarantyJournal()
                       .createGuarantyButtonClick()
                       .createGuarantyRegistrationApplication();

        GuarantyApplication guarantyApplication = new GuarantyApplication();
        guarantyApplication.shouldHaveSuccessNotification("Заявление на регистрацию обеспечения успешно создано");

    }

    @Test
    void successfulCreatingGuarantyApplicationForPledgeAgreement(){
        auth.loginAs("testkeden2@proton.me","Qwerty123$");
        GuarantyJournal guarantyJournal = new GuarantyJournal();
        guarantyJournal.openGuarantyJournal()
                .createGuarantyButtonClick()
                .createGuarantyApplicationForPledgeAgreement();

        GuarantyApplicationForPledgeAgreement guarantyApplicationForPledgeAgreement = new GuarantyApplicationForPledgeAgreement();
        guarantyApplicationForPledgeAgreement.shouldHaveSuccessNotification("Заявление на заключение договора залога успешно создано");
    }



}
