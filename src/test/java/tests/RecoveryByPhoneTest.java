package tests;

import core.base.BaseTest;
import core.base.pages.AnonymRecoveryPage;
import core.base.pages.LoginPage;
import core.base.pages.RecoveryByPhonePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class RecoveryByPhoneTest extends BaseTest {

    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static RecoveryByPhonePage recoveryByPhonePage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void anonymRecoveryTest() {
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 1; i++) {
            loginPage.loginPassword("1");
            loginPage.clickLogin();
        }

        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();

        anonymRecoveryPage.goToRecoveryByPhone();
        recoveryByPhonePage = new RecoveryByPhonePage();
    }
}
