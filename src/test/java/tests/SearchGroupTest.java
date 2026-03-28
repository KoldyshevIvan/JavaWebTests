package tests;

import core.base.BaseTest;
import com.codeborne.selenide.SelenideElement;
import core.base.pages.AnonymRecoveryPage;
import core.base.pages.LoginPage;
import core.base.pages.SearchGroupsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class SearchGroupTest extends BaseTest {

    private static LoginPage loginPage;
    private static SearchGroupsPage searchGroupsPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void searchGroupTest() {
        loginPage.search("Тестировщик");
        searchGroupsPage = new SearchGroupsPage();
        searchGroupsPage.verifyTestGroupsExist();
    }
}
