package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiPageTest {
    // STEPS:
    // 1) Open page Selenide Project on Github
    // 2) Go to the Wiki page
    // 3) Check that the page list has page Soft assertions
    // 4) Open SoftAssertions page
    // ER: the page has JUnit 5 example code

    @Test
    public void searchSelenideInGithub() {

        // Step 1
        open("https://github.com/");
        //for nav-search-input no needs quotes, but for 'nav-search.input' it needs, use ''
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click(); //$$("ul.repo-list li").first() the same that $("ul.repo-list li")
        $("h1").shouldHave(text("selenide / selenide"));

        // Step 2
        $("#wiki-tab").click();
        $(".markdown-body").shouldHave(text("Welcome to the selenide wiki!"));

        // Step 3
        $("#wiki-pages-filter").setValue("softAssertion");
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));

        // Step 4
        $(byText("SoftAssertions")).click();
        $("#wiki-wrapper").shouldHave(text("SoftAssertions"));

        // Expected result
        // headers check
        $("#wiki-wrapper").shouldHave(text("Using JUnit5 extend test class"));
        // code check
        $("#wiki-wrapper").shouldHave(text("SoftAssertsExtension.class"));
    }
}