package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.RegistrationPage;
import pages.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedFagLepraTest extends TestBase {


     @AfterAll
     static void setDown() {
        Configuration.holdBrowserOpen = false;
    }

    @CsvSource({
            "Terkin, Terkin",
            "sckmnta, sckmnta"

    })

    @DisplayName("Username Notes on Leprosorium userpage should contain Fag notes")
    @ParameterizedTest
    @Tags({@Tag("TRIVIAL"), @Tag("UI_TEST")})


    void UsernameNotesShouldContainFagNote(
            String userName1

    ) {

         new RegistrationPage().
        searchNameInput.setValue(userName1);
        $$("li.b-quick_search_section_item").findBy(text(userName1)).click();
        new RegistrationPage().searchResult.click();
        $$("a[href='javascript:;']").findBy(text("по дате")).click();
        new RegistrationPage().verifyResult.shouldHave(text("пидор"));





    }

}
