import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class ProfileTab extends BaseScreen {

    @FindBy(className = "SidebarProfile__UserEmail")
    private WebElement user_email;

    @Step("Check user email in user profile.")
    public  boolean checkUserEmail(String login) {
        return login.equals(user_email.getText());
    }

    public ProfileTab(WebDriver driver) {
        super(driver);
    }


}
