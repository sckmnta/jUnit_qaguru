package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedFagLepraTest {
    @BeforeAll

    static void beforeall() {

        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://leprosorium.ru";
        open("/login");
        $(".b-login_navigation_auth").click();
        $("#js-auth_username").setValue("autotest");
        $("#js-auth_password").setValue("autotest");
        $("#js-auth_forever").click();
        $("#js-auth_remember_ip").click();
        $("#js-auth_form_submit").click();


    }

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
        open("https://leprosorium.ru");
        $("#js-header_search_input").setValue(userName1);
        $$("li.b-quick_search_section_item").findBy(text(userName1)).click();
        $("div.b-user_public_notes_logo").click();
        $$("a[href='javascript:;']").findBy(text("по дате")).click();
        $("div.b-user_public_notes_list").shouldHave(text("пидор"));





    }

}
