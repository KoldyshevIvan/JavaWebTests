package core.base.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryByEmailMobilePage extends MobileBasePage {

    private SelenideElement emailMobField = $("[name = 'email']");
    private SelenideElement getCodeMobButton = $("[name = 'getCode']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления профиля по почте")
    private void verifyPageElements() {
        emailMobField.shouldBe(visible);
        getCodeMobButton.shouldBe(visible);
    }
}
