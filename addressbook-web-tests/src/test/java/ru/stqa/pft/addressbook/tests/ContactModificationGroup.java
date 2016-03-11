package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by neznaa on 3/6/2016.
 */
public class ContactModificationGroup extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Anastasia", "G", "Neznamova", "NeZnaa", "Spb", "9213000000", "anastasia@emc.com", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToContactList();

    }
}
