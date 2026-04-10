package tests.mob;

import core.base.MobileBaseTest;
import core.base.pages.mob.AnonymRecoveryMobilePage;
import core.base.pages.mob.LoginMobilePage;
import core.base.pages.mob.RecoveryByPhoneMobilePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecoveryByPhoneMobileTest extends MobileBaseTest {

    private static LoginMobilePage loginMobilePage;
    private static AnonymRecoveryMobilePage anonymRecoveryMobilePage;
    private static RecoveryByPhoneMobilePage recoveryByPhoneMobilePage;

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
        anonymRecoveryMobilePage.goToRecoveryByPhone();
        recoveryByPhoneMobilePage = new RecoveryByPhoneMobilePage();
        String countryCode = recoveryByPhoneMobilePage.selectCountryByName("Болгария");
        assertEquals("+359", countryCode, "Код страны не совпадает с ожидаемым");
        recoveryByPhoneMobilePage.clickGetCode();

        String expectedErrorMessage = "Введен неверный номер телефона";
        String actualErrorMessage = recoveryByPhoneMobilePage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}
