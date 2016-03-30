package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {

        List<ContactData> before = app.getContactHelper().getContactList();

        app.getContactHelper().createContact(new ContactData("Anastasia", "G", "Neznamova", "NeZnaa", "Spb", "9213000000", "anastasia@emc.com","test1"));
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

}
