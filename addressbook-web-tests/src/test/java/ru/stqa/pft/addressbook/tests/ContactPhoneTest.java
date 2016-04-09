package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by neznaa on 4/9/2016.
 */
public class ContactPhoneTest extends TestBase {

    @Test
    public void testContactPhones() {
        app.goTo().goToHomePage();
        ContactData  contact = app.contact().all().iterator().next();
        ContactData contactInfoFronEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getHomephone(), equalTo(cleaned(contactInfoFronEditForm.getHomephone())));
        assertThat(contact.getWorkphone(), equalTo(cleaned(contactInfoFronEditForm.getWorkphone())));
        assertThat(contact.getMobilephone(), equalTo(cleaned(contactInfoFronEditForm.getMobilephone())));

    }

    public String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]","");
    }
}
