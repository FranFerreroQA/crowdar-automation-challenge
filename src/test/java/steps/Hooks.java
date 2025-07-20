package steps;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
 
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import pages.BasePage;
import utils.DriverManager;
 
public class Hooks extends BasePage {
 
    public Hooks() {
        super();
    }
 
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.log("El WebDriver se cerrará y la ejecución será interrumpida");
            scenario.log("Escenario fallido, ver imagen adjunta");
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot del error");
            DriverManager.quitDriver();
        }
    }
 
}
