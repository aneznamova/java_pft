package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by neznaa on 4/24/2016.
 */
public class RegistrationHelper {
    private final ApplicationManager app;
    private WebDriver wd;

    public RegistrationHelper(ApplicationManager app) {
        this.app = app;
        wd = app.getDriver();
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    }
}
