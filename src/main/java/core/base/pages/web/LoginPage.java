package core.base.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private SelenideElement usernameField = $("[name='st.email']");
    private SelenideElement passwordField = $("[name='st.password']");
    private SelenideElement qrLoginButton = $("[data-l='t,qr_tab']");
    private SelenideElement loginButton = $("[label='Войти']");
    private SelenideElement forgotPasswordLink = $("[aria-label='Не получается войти?']");
    private SelenideElement registrationButton = $x("//span[text()='Зарегистрироваться']");
    private SelenideElement vkButton = $("[data-l='t,vkc']");
    private SelenideElement mailRuButton = $("[data-l='t,mailru']");
    private SelenideElement yandexButton = $("[data-l='t,yandex']");
    private SelenideElement errorMessage = $x("//span[contains(@class, 'LoginForm-module__error')]");
    private SelenideElement goToRecoveryButton = $x("//span[text()='Восстановить']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
        yandexButton.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином: {username} и {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт только с логином: {username}")
    public void loginUsername(String username) {
        usernameField.shouldBe(visible).click();
        usernameField.setValue(username);
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт только с паролем: {password}")
    public void loginPassword(String password) {
        passwordField.shouldBe(visible).click();
        passwordField.setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим по кнопке 'Войти'")
    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }

    @Step("Переход на страницу восстановления профиля")
    public void goToRecovery() {
        goToRecoveryButton.shouldBe(visible).click();
    }

    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переход на страницу регистрации")
    private void openRegistrationPage() {
        registrationButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через ВКонтакте")
    private void loginWithVk() {
        vkButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Mail.ru")
    private void loginMailru() {
        mailRuButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Yandex")
    private void loginYandex() {
        yandexButton.shouldBe(visible).click();
    }

    @Step("Переходим на вкладку входа по qr")
    public void openQrLoginTab() {
        qrLoginButton.shouldBe(visible).click();
    }
}
