package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
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
        ContactData contact = new ContactData(before.get(before.size()-1).getId(), "Anastasia", "G", "Neznamova", "NeZnaa", "Spb", "9213000000", "anastasia@emc.com", null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactList();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
