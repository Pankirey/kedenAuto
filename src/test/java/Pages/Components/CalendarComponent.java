package Pages.Components;

import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    public void setDate(LocalDate date){
        String day = String.format("%02d",date.getDayOfMonth());
        String month = date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        String year = String.valueOf(date.getYear());

        SelenideElement calendarPopup = $$(byXpath("//div[contains(@class,'ant-picker-dropdown')]")).findBy(visible);

        SelenideElement
                monthName = calendarPopup.$(byXpath(".//button[contains(@class,'ant-picker-month-btn')]")).shouldBe(visible),
                nextMonthButton = calendarPopup.$(byXpath(".//button[contains(@class,'ant-picker-header-next-btn')]")),
                yearElement = calendarPopup.$(byXpath(".//button[contains(@class,'ant-picker-year-btn')]")),
                nextYearButton = calendarPopup.$(byXpath(".//button[contains(@class,'ant-picker-header-super-next-btn')]")),
                prevYearButton = calendarPopup.$(byXpath(".//button[contains(@class,'ant-picker-header-super-prev-btn')]"));

        int currentYear = Integer.parseInt(yearElement.shouldBe(visible).getText());
        int expectedYear = Integer.parseInt(year);

        while (currentYear != expectedYear) {
            if (currentYear < expectedYear) {
                nextYearButton.click();
            } else {
                prevYearButton.click();
            }
            currentYear = Integer.parseInt(yearElement.getText());
        }

        while (!monthName.shouldBe(visible).getText().equals(month)) {
            nextMonthButton.click();
        }

        String normalizedDay = String.valueOf(Integer.parseInt(day));
        calendarPopup.$$("td .ant-picker-cell-inner").findBy(text(normalizedDay)).click();
    }
}
