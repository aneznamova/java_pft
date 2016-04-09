package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by neznaa on 3/6/2016.
 */
public class ContactDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (app.contact().list().size() == 0) app.contact().create(new ContactData()
                .withFirstname("Anastasia").withMiddle("G").withLastname("Neznamova").withNickname("NeZnaa")
                .withAddress("Spb").withMobile("9213000000").withEmail("anastasia@emc.com").withGroup("test1"));
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(deletedContact)));

    }

}
