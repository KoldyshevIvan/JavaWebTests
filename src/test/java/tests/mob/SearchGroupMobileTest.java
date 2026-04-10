package tests.mob;

import core.base.MobileBaseTest;
import core.base.pages.mob.LoginMobilePage;
import core.base.pages.mob.SearchGroupsMobilePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class SearchGroupMobileTest extends MobileBaseTest {

    private static LoginMobilePage loginMobilePage;
    private static SearchGroupsMobilePage searchGroupsMobilePage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginMobilePage = new LoginMobilePage();
    }

    @Test
    public void searchGroupMobileTest() {
        loginMobilePage.mobSearch("Тестировщик");
        searchGroupsMobilePage = new SearchGroupsMobilePage();
        searchGroupsMobilePage.verifyTestGroupsExist();
    }
}
