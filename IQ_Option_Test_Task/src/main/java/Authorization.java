import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Authorization extends BaseScreen {
    public Authorization(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[3]/div/div[1]/div/div/div/div/div[1]/button[1]")
    private WebElement authorization_tab;

    @Step("Open login tab.")
    public void openAuthTab() {
        authorization_tab.click();
    }

    @FindBy(css = "div.SidebarLogin__field:nth-child(1) > div:nth-child(1) > label:nth-child(1) > input:nth-child(2)")
    private WebElement login_field;

    @FindBy(css = "div.SidebarLogin__field:nth-child(2) > div:nth-child(1) > label:nth-child(1) > input:nth-child(2)")
    private WebElement password_field;

    @FindBy(css = "button.Button:nth-child(3)")
    private WebElement sign_in_button;

    @Step("Input login and password. Click submit button.")
    public void authorize(String login, String password) {
        login_field.sendKeys(login);
        password_field.sendKeys(password);
        sign_in_button.click();
    }

    @FindBy(css = ".SidebarLogin__error > span:nth-child(1)")
    private WebElement login_error;

    @Step("Check message that authorization is unsuccessful.")
    public boolean check_login_error() {
        return login_error.isDisplayed();
    }


}
