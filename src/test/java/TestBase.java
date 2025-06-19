import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import io.qameta.allure.selenide.AllureSelenide;
import com.codeborne.selenide.logevents.SelenideLogger;

public class TestBase {
    @BeforeAll
    static void setUp(){
        System.setProperty("allure.results.directory", "target/allure-results");
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
        WebDriverManager.chromedriver().setup();
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://test-keden.codecraft.kz/";
        Configuration.pageLoadStrategy = "eager";
        WebDriverManager.chromedriver().setup();
    }

}
