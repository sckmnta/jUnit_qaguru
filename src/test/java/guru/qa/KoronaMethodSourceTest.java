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
                        "Вопросы и ответы")),
                Arguments.of(Locale.EN, List.of(
                        "FAQ")));

    }

    @BeforeAll
    static void beforeall() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://koronapay.com/";
    }

    @MethodSource("localeDataProvider")

    @ParameterizedTest
    void koronapayShouldHaveEnAndRuLangusges(Locale locale,
                                             List<String> buttons) {

        open("transfers/online/");
        $$("li.I18nSwitch_item__QofMF").find((text(locale.name()))).click();
        //$("#clickable-button-locale-ru").click();
        //$("#clickable-button-locale-en").click();
        $$("div#__next").shouldHave(CollectionCondition.texts(buttons));


    }
}
