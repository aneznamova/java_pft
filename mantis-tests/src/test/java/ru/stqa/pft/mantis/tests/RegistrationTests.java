package ru.stqa.pft.mantis.tests;

import com.sun.javafx.binding.StringFormatter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.MailHelper;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by neznaa on 4/24/2016.
 */
public class RegistrationTests extends TestBase {


    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException, MessagingException {
        long now = System.currentTimeMillis();
        UserData user = new UserData()
                .withUsername(String.format("user%s", now)).withPassword("password").withEmail(String.format("user%s@localhost.localdomain", now));
        app.user().registerNewUser(user);
        assertTrue(app.newSession().login(user.getUsername(), user.getPassword()));
    }



    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
