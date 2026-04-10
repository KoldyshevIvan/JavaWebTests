package tests.mob;

import core.base.MobileBaseTest;
import core.base.pages.mob.LoginMobilePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithWrongCredentialsMobileTest extends MobileBaseTest {
    private static LoginMobilePage loginMobilePage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginMobilePage = new LoginMobilePage();
    }

    @Test
    public void loginWithWrongCredentialsMobileTest() {
        loginMobilePage.login("test", "testpass");
        assertTrue(loginMobilePage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        String expectedErrorMessage = "Неверный логин или пароль";
        String actualErrorMessage = loginMobilePage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}
