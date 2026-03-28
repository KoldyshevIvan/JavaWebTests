package core.base.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RecoveryByPhonePage extends BasePage {

    private SelenideElement phoneNumberField = $("[id='field_phone']");
    private SelenideElement countryDropdown = $x("//div[@data-l='t,country']");
    private SelenideElement getCodeButton = $("[data-l='t,submit']");
    private SelenideElement errorMessage = $("[class='input-e js-ph-vl-hint']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления профиля по телефону")
    private void verifyPageElements() {
        phoneNumberField.shouldBe(visible);
        countryDropdown.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }

    @Step("Выбираем код страны по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        countryDropdown.click();
        SelenideElement countryItem = $(String.format(".country-select_i[data-name='%s']", countryName));
        countryItem.scrollTo();
        String countryCode = countryItem.find(".country-select_code").text();
        countryItem.click();
        return countryCode;
    }

    @Step("Кликаем по кнопке 'Получить код'")
    public void clickGetCode() {
        getCodeButton.shouldBe(visible).click();
    }

    @Step("Проверяем видимость сообщения об ошибке получения кода")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке получения кода")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }
}
