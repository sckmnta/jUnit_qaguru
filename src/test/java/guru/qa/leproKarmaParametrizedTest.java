package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class leproKarmaParametrizedTest {
    @BeforeAll

    static void beforeall() {

        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://leprosorium.ru";

    }
    @Test

    void karmaOnProfilePageShouldBe1674() {
        open("/login");
        $(".b-login_navigation_auth").click();
        $("#js-auth_username").setValue("******");
        $("#js-auth_password").setValue("******");
        $("#js-auth_forever").click();
        $("#js-auth_remember_ip").click();
        $("#js-auth_form_submit").click();


    }

}
