package core.base.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RecoveryByPhonePage extends BasePage {

    private SelenideElement phoneNumberField = $("[id='field_phone']");
    private SelenideElement countryField = $x("//div[@data-l='t,country']");
    private SelenideElement getCodeButton = $("[data-l='t,submit']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления профиля по телефону")
    private void verifyPageElements() {
        phoneNumberField.shouldBe(visible);
        countryField.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }
}
