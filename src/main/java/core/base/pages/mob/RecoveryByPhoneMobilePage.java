package core.base.pages.mob;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import core.base.MobileBasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RecoveryByPhoneMobilePage extends MobileBasePage {

    private SelenideElement phoneNumberMobField = $("[id='field_phone']");
    private SelenideElement countryMobDropdown = $("[id='countryName']");
    private SelenideElement getCodeMobButton = $("[id='getCode']");
    private SelenideElement errorMobMessage = $("[class='field_error-descr']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления профиля по телефону")
    private void verifyPageElements() {
        phoneNumberMobField.shouldBe(visible);
        countryMobDropdown.shouldBe(visible);
        getCodeMobButton.shouldBe(visible);
    }

    @Step("Выбираем код страны по номеру: {countryName}")
    public String selectCountryByName(String countryName) {
        countryMobDropdown.click();
        SelenideElement countryItem = $x(String.format(
                "//a[.//div[contains(@class, 'reg_choose_country') and contains(text(), '%s')]]",
                countryName.replace("'", "''")
        ));

        countryItem.scrollTo();
        String countryCode = countryItem.find(".reg_choose_prefix").text();

        ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("arguments[0].click();", countryItem);
        return countryCode;
    }

    @Step("Кликаем по кнопке 'Получить код'")
    public void clickGetCode() {
        getCodeMobButton.shouldBe(visible).click();
    }

    @Step("Проверяем видимость сообщения об ошибке получения кода")
    public boolean isErrorMessageVisible() {
        return errorMobMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке получения кода")
    public String getErrorMessageText() {
        return errorMobMessage.shouldBe(visible).getText();
    }
}
