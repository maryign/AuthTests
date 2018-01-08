import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseScreen {
    protected WebDriver driver;

    public BaseScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

