package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {
        Contacts before = app.contact().all();
        File photo = new File ("src/test/resources/picture.jpg");
        ContactData contact = new ContactData()
                .withFirstname("Semen").withLastname("Efimov").withAddress("Spb Test street 23 kv.76")
                .withMobilephone("9213000000").withHomephone("34-323-55").withWorkphone("43 23 212")
                .withEmail("name-nick@test.com").withEmail2("test@test.ru").withEmail3("test@test111.com").withGroup("test1").withPhoto(photo);
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, CoreMatchers.equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }

}
