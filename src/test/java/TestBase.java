import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll(){
        WebDriverManager.chromedriver().setup();
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://test-keden.codecraft.kz/";
        Configuration.pageLoadStrategy = "eager";
    }

}
