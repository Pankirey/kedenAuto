import Pages.DeclarationsJournal;
import Utils.AuthService;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class DeclarationsJournalTest extends TestBase{
    AuthService auth = new AuthService();

    @Test
    void successfulOpeningOfDeclarationJournal(){
        auth.loginAs("testkeden2@proton.me","Qwerty123$");

        DeclarationsJournal declarationsJournal = new DeclarationsJournal();
        declarationsJournal.openDeclarationsJournal();
        Selenide.sleep(5000);
        //написать проверки
    }
}
