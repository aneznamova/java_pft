package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by neznaa on 3/6/2016.
 */
public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        if (! app.getContactHelper().isThereAContact()) {

            app.getContactHelper().createContact(new ContactData("Anastasia", "G", "Neznamova", "NeZnaa", "Spb", "9213000000", "anastasia@emc.com", "test1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification(before.size() - 1);
        app.getContactHelper().fillContactForm(new ContactData("Anastasia", "G", "Neznamova", "NeZnaa", "Spb", "9213000000", "anastasia@emc.com", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactList();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

    }
}
