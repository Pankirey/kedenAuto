package Pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeclarationsJournal {

    private final SelenideElement preliminaryInformationTab = $("#rc-tabs-1-tab-PI"),
    transitDeclarationTab = $("#rc-tabs-1-tab-TD"),
    goodsDeclarationTab = $("#rc-tabs-1-tab-DT");

    public DeclarationsJournal openDeclarationsJournal(){
        open("https://test-keden.codecraft.kz/declarations/journal");
        transitDeclarationTab.click();
        return this;
    }
}
