package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by neznaa on 3/6/2016.
 */
public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().confirmDeletionContact();
        app.getContactHelper().returnToContactList();

    }
}
