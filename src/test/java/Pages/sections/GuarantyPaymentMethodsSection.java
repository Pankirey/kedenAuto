package Pages.sections;

import Pages.Components.CalendarComponent;
import Pages.Components.DocumentUploader;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.LocalDate;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GuarantyPaymentMethodsSection {

    CalendarComponent calendarComponent = new CalendarComponent();
    DocumentUploader documentUploader = new DocumentUploader();
    private final SelenideElement methodsTab = $(byXpath("//span[@class='ant-menu-title-content' and text()='Иные способы обеспечения']")),
    createPaymentMethodButton = $(byXpath("//h5/following-sibling::button")),
    moneyPaymentMethodOption = $(byXpath("//li[@role='menuitem']/span[text()='Деньгами']")),
    moneyPaymentOptionType = $("#paymentOptionType"),
    moneyDepositDocNumberField = $("#moneyDeposit_docNumber"),
    moneyDepositDocDateField= $("#moneyDeposit_docDate"),
    moneyDepositBikField = $("#moneyDeposit_bik"),
    moneyDepositIikField = $("#moneyDeposit_iik"),
    nonSuretyContractOption = $(byXpath("//span[@class='ant-radio ant-wave-target']/following-sibling::span[text()='Нет']")),
    suretyContractOption = $(byXpath("//span[@class='ant-radio ant-wave-target']/following-sibling::span[text()='Да']")),
    sumOfPaymentMethod = $("#sum"),
    startDateOfPaymentMethod = $(byXpath("//article[text()='Действует с']/parent::label/parent::div/following-sibling::div")),
    endDateOfPaymentMethod = $(byXpath("//article[text()='Действует по']/parent::label/parent::div/following-sibling::div")),
    addPaymentMethodButton = $(byXpath("//button/span[text()='Добавить']"));

    public void openPaymentMethodsTab(){
        methodsTab.click();
    }

    public void fillMoneyPaymentMethod(){
        openPaymentMethodsTab();
        createPaymentMethodButton.click();
        moneyPaymentMethodOption.click();
        moneyPaymentOptionType.click();
        moneyPaymentOptionType.sendKeys(Keys.ENTER);
        moneyDepositDocNumberField.setValue("2314");
        moneyDepositDocDateField.click();
        calendarComponent.setDate(LocalDate.now());
        moneyDepositBikField.setValue("87654321");
        moneyDepositIikField.setValue("12345678900987654321");
        nonSuretyContractOption.click();
        sumOfPaymentMethod.setValue("50000");
        startDateOfPaymentMethod.click();
        calendarComponent.setDate(LocalDate.now());
        endDateOfPaymentMethod.click();
        calendarComponent.setDate(LocalDate.now().plusDays(100));
        documentUploader.upload("doc.jpg");
        addPaymentMethodButton.click();
    }

}
