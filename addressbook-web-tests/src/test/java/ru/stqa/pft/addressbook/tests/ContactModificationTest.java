package ru.stqa.pft.addressbook.tests;

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
        if (app.db().contacts().size() == 0) {

            app.contact().create(new ContactData()
                    .withFirstname("Semen").withLastname("Efimov").withAddress("Spb Test street 23 kv.76")
                    .withMobilephone("9213000000").withHomephone("34-323-55").withWorkphone("43 23 212")
                    .withEmail("name-nick@test.com").withEmail2("test@test.ru").withEmail3("test@test111.com").withGroup("test1"));
        }
    }

    @Test
    public void testContactModification() {

        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withFirstname("Semen").withLastname("Efimov").withAddress("Spb Test street 23 kv.76")
                .withMobilephone("9213000000").withHomephone("34-323-55").withWorkphone("43 23 212")
                .withEmail("name-nick@test.com").withEmail2("test@test.ru").withEmail3("test@test111.com").withGroup("test1");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(modifiedContact)));
    }

}
