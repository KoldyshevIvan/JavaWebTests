package core.base.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchGroupsMobilePage extends MobileBasePage {

    SelenideElement TestMobGroups = $("[data-log-click*='Тестировщик']");

    public void verifyTestGroupsExist() {
        TestMobGroups.shouldBe(visible);
    }
}