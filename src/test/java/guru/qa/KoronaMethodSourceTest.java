package guru.qa;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class KoronaMethodSourceTest {

    static Stream<Arguments> localeDataProvider() {
        return Stream.of(Arguments.of(Locale.RU, List.of(
                        "Служба помощи клиентам", "Защита от мошенничества")),
                Arguments.of(Locale.EN, List.of(
                        "Customer help center", "Fraud protection")));

    }

    @BeforeAll
    static void beforeall() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://koronapay.com/";
    }

    @MethodSource("localeDataProvider")

    @ParameterizedTest
    void denizBankShouldHaveEnAndTrLangusges(Locale locale,
                                             List<String> buttons) {

        open("transfers/online/");
        $$("ul.I18nSwitch_langs__CpqDn").find((text(locale.name()))).click();
        //$("#clickable-button-locale-ru").click();
        //$("#clickable-button-locale-en").click();
        $$("div.container SubFooter_pre-footer__IdCaG").shouldHave(CollectionCondition.texts(buttons));


    }
}
