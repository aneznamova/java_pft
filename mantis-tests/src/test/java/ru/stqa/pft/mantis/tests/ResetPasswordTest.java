package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by neznaa on 4/25/2016.
 */
public class ResetPasswordTest extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testResetPassword() throws IOException, MessagingException {
        String newPassword = "newPassword";
        Users allUsers = app.db().users();
        for (UserData user : allUsers)
            if (user.getId() > 1) {
                app.user().uiLogin("administrator", "root");
                app.user().resetPassword(user, newPassword);
                assertTrue(app.newSession().login(user.getUsername(), newPassword));
                break;
            }
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }

}
