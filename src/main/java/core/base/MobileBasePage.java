package core.base;

import com.codeborne.selenide.SelenideElement;
import core.base.pages.mob.SearchGroupsMobilePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MobileBasePage {

    protected SelenideElement headerMobLogo = $("[class='ticLgo tics portal-logo_img']");
    protected SelenideElement searchMobButton = $("[data-log-click*='search']");
    protected SelenideElement searchMobField = $("[data-func='inputInteraction']");
    protected SelenideElement vkMobServices = $("[class='sidebar-menu-icon toolbar_actions-i_inner']");
    protected SelenideElement searchMobGroup = $("[class = 'item it search-all_item search_item __compact']");

    public SearchGroupsMobilePage mobSearch(String query) {
        searchMobButton.shouldBe(visible).click();
        searchMobField.shouldBe(visible).setValue(query);
        SelenideElement searchGroupHighGround = $x("//a[@class='clickarea']");
        searchGroupHighGround.click();
        searchMobGroup.click();
        return new SearchGroupsMobilePage();
    }

    // Пример общего метода для клика по иконке уведомлений
    public void openVkServices() {
        vkMobServices.shouldBe(visible).click();
    }

    // Клик на логотип ОК
    public void clickLogo() {
        headerMobLogo.shouldBe(visible).click();
    }
}
