package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by neznaa on 4/9/2016.
 */
public class ContactDetailsTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.contact().list().size() == 0) app.contact().create(new ContactData()
                .withFirstname("Semen").withLastname("Efimov").withAddress("Spb Test street 23 kv.76")
                .withMobilephone("9213000000").withHomephone("34-323-55").withWorkphone("43 23 212")
                .withEmail("name-nick@test.com").withEmail2("test@test.ru").withEmail3("test@test111.com"));//.withGroup("test1"));
    }

    @Test
    public void testContactDetails() {
        app.goTo().goToHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        MatcherAssert.assertThat(mergeDetails(contactInfoFromDetailsForm), CoreMatchers.equalTo(mergeDetails(contactInfoFromEditForm)));

    }

    private String  mergeDetails(ContactData contact) {
        return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress(),
                contact.getHomephone(), contact.getMobilephone(), contact.getWorkphone(),
                contact.getEmail())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining(""));
    }

}
