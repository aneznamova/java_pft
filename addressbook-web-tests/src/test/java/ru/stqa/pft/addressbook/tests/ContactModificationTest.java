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
public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.contact().list().size() == 0) {

            app.contact().create(new ContactData().withFirstname("Anastasia").withMiddle("G").withLastname("Neznamova").withNickname("NeZnaa")
                    .withAddress("Spb").withMobile("9213000000").withEmail("anastasia@emc.com").withGroup("test1"));
        }
    }

    @Test
    public void testContactModification() {

        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("Anastasia").withMiddle("G").withLastname("Neznamova").withNickname("NeZnaa")
                .withAddress("Spb").withMobile("9213000000").withEmail("anastasia@emc.com");
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(modifiedContact)));
    }


}
