package Pages.Components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {
        SelenideElement calendarPopup = $(byXpath("//div[contains(@class,'ant-picker-dropdown css-gjh7v8 ant-picker-dropdown')]")).shouldBe(visible),
                monthName = calendarPopup.$(byXpath(".//button[@class='ant-picker-month-btn']")),
                nextMonthButton = calendarPopup.$(byXpath(".//button[@class='ant-picker-header-next-btn']")),
                yearElement = calendarPopup.$(byXpath(".//button[@class='ant-picker-year-btn']")),
                nextYearButton = calendarPopup.$(byXpath(".//button[@class='ant-picker-header-super-next-btn']")),
                prevMonthButton = calendarPopup.$(byXpath(".//button[@class='ant-picker-header-super-prev-btn']"));
        calendarPopup.shouldBe(visible);
        String expectedMonth = getMonthName(month);
        int currentYear = Integer.parseInt(yearElement.shouldBe(visible).getText());
        int expectedYear = Integer.parseInt(year);
        while (!monthName.shouldBe(visible).getText().equals(expectedMonth)) {
            nextMonthButton.click();
        }
        while (currentYear != expectedYear) {
            if (currentYear < expectedYear) {
                nextYearButton.shouldBe(visible).click();
            } else {
                prevMonthButton.shouldBe(visible).click();
            }
            currentYear = Integer.parseInt(yearElement.getText());
        }

            String normalizedDay = String.valueOf(Integer.parseInt(day));
            calendarPopup.$$("td .ant-picker-cell-inner").findBy(text(normalizedDay)).click();
    }

    private String getMonthName(String monthNumber) {
        return switch (monthNumber) {
            case "01" -> "Jan";
            case "02" -> "Feb";
            case "03" -> "Mar";
            case "04" -> "Apr";
            case "05" -> "May";
            case "06" -> "Jun";
            case "07" -> "Jul";
            case "08" -> "Aug";
            case "09" -> "Sep";
            case "10" -> "Oct";
            case "11" -> "Nov";
            case "12" -> "Dec";
            default -> throw new IllegalArgumentException("Invalid month: " + monthNumber);
        };
    }
}
