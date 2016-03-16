package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by neznaa on 3/6/2016.
 */
public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() {
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Anastasia", "G", "Neznamova", "NeZnaa", "Spb", "9213000000", "anastasia@emc.com","test1"));

        }
        app.getContactHelper().selectContact(before - 1);
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().confirmDeletionContact();
        app.getNavigationHelper().returnToHome();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);

    }
}
