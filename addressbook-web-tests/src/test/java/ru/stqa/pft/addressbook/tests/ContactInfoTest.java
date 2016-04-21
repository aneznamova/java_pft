package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by neznaa on 4/9/2016.
 */
public class ContactInfoTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (app.contact().list().size() == 0) app.contact().create(new ContactData()
                .withFirstname("Semen").withLastname("Efimov").withAddress("Spb Test street 23 kv.76")
                .withMobilephone("9213000000").withHomephone("34-323-55").withWorkphone("43 23 212")
                .withEmail("name-nick@test.com").withEmail2("test@test.ru").withEmail3("test@test111.com"));//.withGroup("test1"));
    }

    
    @Test
    public void testContactInfo() {
        app.goTo().goToHomePage();
        ContactData  contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));

    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomephone(), contact.getMobilephone(), contact.getWorkphone())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactInfoTest::cleaned)
                .collect(Collectors.joining("\n"));

    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]","");
    }
}
