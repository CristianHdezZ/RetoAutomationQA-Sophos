package co.com.sophos.certification.falabella.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/endPointEmployee.feature",
        glue = {"co.com.sophos.certification.falabella.stepdefinitions"},
        snippets = SnippetType.CAMELCASE
)
public class EndPointEmployeeRunner {
}
