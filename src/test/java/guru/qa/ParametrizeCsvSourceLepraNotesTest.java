package guru.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.TestBase;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizeCsvSourceLepraNotesTest extends TestBase {


    @CsvSource({
            "sckmnta, sckmnta",
            "Terkin, Terkin"


    })

    @DisplayName("UsernameNotesOnLeprosoriumUserpageNotesTest")
    @ParameterizedTest
    @Tags({@Tag("TRIVIAL"), @Tag("UI_TEST")})
    void userNameNotesShouldContainAutotestWord(
            String userName

    ) {

        new RegistrationPage().searchNameInput.setValue(userName);
        $$("li.b-quick_search_section_item").findBy(text(userName)).click();
        new RegistrationPage().searchResult.click();
        $$("a[href='javascript:;']").findBy(text("по дате")).click();
        new RegistrationPage().verifyResult.shouldHave(text("autotest"));


    }

}
