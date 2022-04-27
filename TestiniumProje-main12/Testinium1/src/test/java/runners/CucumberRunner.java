package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        glue = "/step_definations",

        features = "src/test/features",

        dryRun = false,

        plugin ={

                "html:target/default-report",
                "json:target/cucumber2.json",
                "rerun:target/rerun.txt"
        }
)
public class CucumberRunner {

}
