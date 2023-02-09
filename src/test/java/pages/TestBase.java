package pages;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
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


}
