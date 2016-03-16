package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by neznaa on 3/6/2016.
 */
public class ContactModificationGroup extends TestBase {

    @Test
    public void testContactModification() {
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {

            app.getContactHelper().createContact(new ContactData("Anastasia", "G", "Neznamova", "NeZnaa", "Spb", "9213000000", "anastasia@emc.com", "test1"));
        }

        app.getContactHelper().initContactModification(before - 1);
        app.getContactHelper().fillContactForm(new ContactData("Anastasia", "G", "Neznamova", "NeZnaa", "Spb", "9213000000", "anastasia@emc.com", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactList();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);

    }
}
