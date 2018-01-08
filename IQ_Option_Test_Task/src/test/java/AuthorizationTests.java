/*Написать автоматический тест для авторизации в системе. Тест должен проверять:
Поведение в системе при вводе корректных данных
Поведение системы при вводе некорректных данных
*/


import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
@Feature("Authorization")
public class AuthorizationTests extends BaseTest {
    @Test(description = "Valid login and password")
    @Description("Authorization with valid data")
    public void successfulAuthorization() {

        String login = "mretailertest@gmail.com";
        String password = "qwerty123";
        driver.get("https://iqoption.com/ru");
        GeoPopup geoPopup = new GeoPopup(driver);
        geoPopup.closePopup();
        Authorization auth = new Authorization(driver);
        auth.openAuthTab();
        auth.authorize(login, password);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.urlToBe("https://eu.iqoption.com/ru"));
        ProfileTab profile = new ProfileTab(driver);
        assertTrue( profile.checkUserEmail(login),  "User email not equals login");
    }

    @Test(description = "Invalid login or password")
    @Description("Authorization with invalid password")
    public void failedAuthorization() {
        String login = "mretailertest@gmail.com";
        String password = "njfdj";

        driver.get("https://iqoption.com/ru");
        GeoPopup geoPopup = new GeoPopup(driver);
        geoPopup.closePopup();
        Authorization auth = new Authorization(driver);
        auth.openAuthTab();
        auth.authorize(login, password);
        assertTrue(auth.check_login_error(), "Message \"Login or password is invalid\" not found");
    }
}
