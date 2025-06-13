package Pages.Components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;

public class CalendarComponent {
    public void setDate(String day, String month, String year){
        $(".ant-picker-year-btn").click();
        String yearXpath = String.format(" //div[@class='ant-picker-cell-inner' and text()='%s']", year);
        $(byXpath(yearXpath)).shouldBe(visible).click();
        $(".ant-picker-month-btn").click();
    }
}
