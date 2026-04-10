package tests.mob;

import core.base.MobileBaseTest;
import core.base.pages.mob.AnonymRecoveryMobilePage;
import core.base.pages.mob.LoginMobilePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AnonymRecoveryMobileTest extends MobileBaseTest {

    private static LoginMobilePage loginMobilePage;
    private static AnonymRecoveryMobilePage anonymRecoveryMobilePage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginMobilePage = new LoginMobilePage();
    }

    @Test
    public void anonymRecoveryMobileTest() {
        loginMobilePage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 1; i++) {
            loginMobilePage.loginPassword("1");
            loginMobilePage.clickLogin();
        }

        loginMobilePage.goToRecovery();
        anonymRecoveryMobilePage = new AnonymRecoveryMobilePage();
    }
}
