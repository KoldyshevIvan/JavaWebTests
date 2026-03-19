package core.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");
    protected SelenideElement searchField = $("[name ='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");

    // Метод для поиска по сайту
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    // Пример общего метода для клика по иконке уведомлений
    public void openVkServices() {
        vkServices.shouldBe(visible).click();
    }

    // Клик на логотип ОК
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }

}
