package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import utils.DriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",            // Path to feature files
    glue = "steps",                                      // Package containing step definitions
    plugin = {
        "pretty",                                        // Pretty console output
        "html:cucumber-reports/cucumber-report.html"     // HTML report output path
    },
    tags = "@login"                                      // Tag to filter which scenarios to run
)

public class TestRunner {

    @AfterClass
    public static void cleanDriver() {
        DriverManager.quitDriver(); // Quit WebDriver instance
    }
    
}
