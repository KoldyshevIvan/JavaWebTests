package core.base.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SearchGroupsPage extends BasePage {

    SelenideElement TestGroups = $x("//span[contains(text(), 'Тестировщик')]");

    public void verifyTestGroupsExist() {
        TestGroups.shouldBe(visible);
    }
}