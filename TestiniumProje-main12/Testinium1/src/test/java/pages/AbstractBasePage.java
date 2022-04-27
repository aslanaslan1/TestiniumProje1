package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.logging.Logger;

public abstract class AbstractBasePage {
        protected WebDriver driver = Driver.getDriver();
        public AbstractBasePage() {
            PageFactory.initElements(driver, this);
        }
        final static Logger logger= Logger.getLogger(AbstractBasePage.class.getName());

    public void jsExecutor(String script, Object... args) {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript(script, args);

    }
}

