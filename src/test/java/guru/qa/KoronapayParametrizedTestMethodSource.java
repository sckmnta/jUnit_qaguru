package guru.qa;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class KoronapayParametrizedTestMethodSource {

    static Stream<Arguments> koronaPayTransfersCountingShouldBeAvaliableInEngAndInRuLanguages() {
        return Stream.of(
                Arguments.of(Locale.En, List.of("Total transfer amount")),
                Arguments.of(Locale.Ru, List.of("Итого к оплате"))
        );

    }

    @BeforeAll
    static void beforeall() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://koronapay.com";
    }

    @MethodSource

    @ParameterizedTest
    void koronaPayTransfersCountingShouldBeAvaliableInEngAndInRuLanguages(Locale locale,
            List<String> buttons)
            {

        open("/transfers/online/");
        //$("#changeable-field-select-receivingCountry").click();
        //$("#clickable-button-locale-en").click();
        //$("#clickable-button-locale-ru").click();
        $$(".I18nSwitch_langs__CpqDn").findBy(Condition.text(locale.name())).click();
        $("#clickable-button-underSelectCountry-TUR").click();
        $("#changeable-field-input-amount").setValue("1000");
        $("#changeable-field-checkbox-paidNotification_wrapper").click();
        $("#clickable-button-next").click();
        //$("div.CalculatorStep_summary__rX5Ne").shouldHave(Condition.text(buttons));



    }
}
