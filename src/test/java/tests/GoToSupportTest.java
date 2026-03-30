package tests;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseTest;
import core.base.pages.AnonymRecoveryPage;
import core.base.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoToSupportTest extends BaseTest {

    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private SelenideElement SupportChat = $("[data-bundle-name='support-chat']");
    private SelenideElement SupportChatClose = $("[title='Закрыть чат со службой поддержки']");
    private SelenideElement SupportChatExitConfirm = $("[class='button-core__0ej09 __size-m__0ej09 __wide__0ej09']");

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void goToSupportTest() {
        loginPage.openForgotPasswordPage();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToSupport();
        SupportChat.shouldBe(visible);
        SupportChatClose.shouldBe(visible).click();
        SupportChatExitConfirm.shouldBe(visible).click();
    }
}
