package guru.qa;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;





public class ParametrizedEbayCheapestPokemonGoGtaOnlineAccountValueSource {

    @ValueSource (strings = {"pokemon go acccount", "gta online account"})



    @ParameterizedTest





    void EbayShouldContainCheapestPokemonGoAccountAndGtaOnlineAccountOnSale(String productName) {

        open("https://www.ebay.com/");
        $("#gh-ac").setValue(productName).pressEnter();
        $$(".btn__cell").findBy(Condition.text("Best Match")).click();
        $$("a.fake-menu-button__item").findBy(Condition.text("Price + Shipping: lowest first")).click();
        $$("#srp-river-results").first().shouldHave(Condition.text("Best Offer"));
        //switchTo().window(1);
        //$("div.vim-buybox-wrapper").shouldHave(Condition.text("Buy It Now"));


    }
}
