package guru.qa;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.TestBase;
import pages.RegistrationPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedFagLepraTestCsvSource extends TestBase {


    @CsvSource({
            "Terkin, Terkin",
            "sckmnta, sckmnta"

    })

    @DisplayName("UsernameNotesOnLeprosoriumUserpageShouldContainFagNote")
    @ParameterizedTest
    @Tags({@Tag("TRIVIAL"), @Tag("UI_TEST")})


    void UsernameNotesShouldContainFagNote(
            String userName1

    ) {

        new RegistrationPage().searchNameInput.setValue(userName1);
        $$("li.b-quick_search_section_item").findBy(text(userName1)).click();
        new RegistrationPage().searchResult.click();
        $$("a[href='javascript:;']").findBy(text("по дате")).click();
        new RegistrationPage().verifyResult.shouldHave(text("пидор"));





    }

}
