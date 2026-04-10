package tests.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import core.base.pages.mob.AnonymRecoveryMobilePage;
import core.base.pages.mob.LoginMobilePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoToSupportMobileTest extends MobileBaseTest {

    private static LoginMobilePage loginMobilePage;
    private static AnonymRecoveryMobilePage anonymRecoveryMobilePage;

    private SelenideElement SupportMobChat = $("[data-tsid='supportChatTitle']");
    private SelenideElement SupportChatMobClose = $("[data-icon-name='ico_close_16']");
    private SelenideElement SupportChatExitMobConfirm = $("[class='button__pe9qo button-core-container__0ej09 btn__x281t button__1ejp4 _mob__x281t']");

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginMobilePage = new LoginMobilePage();
    }

    @Test
    public void goToSupportMobileTest() {
        loginMobilePage.openForgotPasswordPage();
        anonymRecoveryMobilePage = new AnonymRecoveryMobilePage();
        anonymRecoveryMobilePage.goToSupport();
        SupportMobChat.shouldBe(visible);
        SupportChatMobClose.shouldBe(visible).click();
        SupportChatExitMobConfirm.shouldBe(visible).click();
    }
}
