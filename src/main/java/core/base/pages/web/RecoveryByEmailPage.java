package core.base.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryByEmailPage extends BasePage {

    private SelenideElement emailField = $("[name = 'email']");
    private SelenideElement getCodeButton = $("[data-l = 't,submit']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления профиля по почте")
    private void verifyPageElements() {
        emailField.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }
}
