package core.base.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginMobilePage extends MobileBasePage {

    private SelenideElement usernameMobField = $("[name='st.email']");
    private SelenideElement passwordMobField = $("[name='st.password']");
    private SelenideElement loginMobButton = $("[type='submit']");
    private SelenideElement forgotMobPasswordLink = $x("//button[text()='Не получается войти?']");
    private SelenideElement registrationMobButton = $x("//span[@class='vkuiButton__content'" +
            " and text()='Регистрация']");
    private SelenideElement vkMobButton = $("[title='Войти через VK ID']");
    private SelenideElement mailRuMobButton = $("[title='Войти через Почту']");
    private SelenideElement yandexMobButton = $("[title='Войти через Яндекс']");
    private SelenideElement errorMobMessage =
            $("[class='LoginForm-module__error___1xmAD vkuiCaption__sizeYNone vkuiCaption__level1 vkuiTypography__host vkuiTypography__normalize vkuiRootComponent__host']");
    private SelenideElement goToRecoveryMobButton = $x("//span[@class='vkuiButton__content' and text()='Восстановить']");
    private SelenideElement goToRecoveryMobButtonCancel = $x("//span[@class='vkuiButton__content' and text()='Отмена']");
    private SelenideElement goToRecoveryMobButtonExit = $("[role='button'] [style='fill: currentcolor;']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        usernameMobField.shouldBe(visible);
        passwordMobField.shouldBe(visible);
        loginMobButton.shouldBe(visible);
        forgotMobPasswordLink.shouldBe(visible);
        registrationMobButton.shouldBe(visible);
        vkMobButton.shouldBe(visible);
        mailRuMobButton.shouldBe(visible);
        yandexMobButton.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMobMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMobMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином: {username} и {password}")
    public void login(String username, String password) {
        usernameMobField.shouldBe(visible).setValue(username);
        passwordMobField.shouldBe(visible).setValue(password);
        loginMobButton.shouldBe(visible).click();
    }

    @Step("Вводим только логин: {username}")
    public void loginUsername(String username) {
        usernameMobField.shouldBe(visible).setValue(username);
        loginMobButton.shouldBe(visible).click();
    }

    @Step("Вводим только пароль: {password}")
    public void loginPassword(String password) {
        passwordMobField.shouldBe(visible).setValue(password);
        loginMobButton.shouldBe(visible).click();
    }


    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotMobPasswordLink.shouldBe(visible).click();
    }

    @Step("Переход на страницу регистрации")
    private void openRegistrationPage() {
        registrationMobButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через ВКонтакте")
    private void loginWithVk() {
        vkMobButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Mail.ru")
    private void loginMailru() {
        mailRuMobButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Yandex")
    private void loginYandex() {
        yandexMobButton.shouldBe(visible).click();
    }

    @Step("Нажимаем Восстановить")
    public void goToRecovery() {
        goToRecoveryMobButton.shouldBe(visible).click();
    }

    @Step("Нажимаем Отмена")
    public void clickToRecoveryButtonCancel() {
        goToRecoveryMobButtonCancel.shouldBe(visible).click();
    }

    @Step("Нажимаем крестик")
    public void clickToRecoveryButtonExit() {
        goToRecoveryMobButtonExit.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку войти")
    public void clickLogin() {
        loginMobButton.shouldBe(visible).click();
    }
}
