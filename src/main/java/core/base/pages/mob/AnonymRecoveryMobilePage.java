package core.base.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AnonymRecoveryMobilePage extends MobileBasePage {

    private SelenideElement recoveryByPhoneMobButton = $("[data-log-click*='phone']");
    private SelenideElement recoveryByEmailMobButton = $("[data-log-click*='email']");
    private SelenideElement goToSupportMobButton = $x("//a[@class='registration_footer_link' and text()='Служба поддержки']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        recoveryByPhoneMobButton.should(exist);
        recoveryByEmailMobButton.should(exist);
        goToSupportMobButton.should(exist);
    }

    @Step("Нажимаем на кнопку восстановления через телефон")
    public void goToRecoveryByPhone() {
        recoveryByPhoneMobButton.should(exist).click();
    }

    @Step("Нажимаем на кнопку восстановления через Email")
    public void goToRecoveryByEmail() {
        recoveryByEmailMobButton.should(exist).click();
    }

    @Step("Переходим к технической поддержке")
    public void goToSupport() {
        goToSupportMobButton.should(exist).click();
    }
}
