import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeoPopup extends BaseScreen {
    public GeoPopup(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "body > div:nth-child(9) > div > div")
    private WebElement popup;

    @Step("Close popup \"На данный момент IQ Option не предоставляет услуги в вашей стране.\"")
    public void closePopup() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(popup));
        popup.sendKeys(Keys.ESCAPE);
    }

}
