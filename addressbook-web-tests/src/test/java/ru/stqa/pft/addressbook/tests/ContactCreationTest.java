package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {

        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().createContact(new ContactData("Anastasia", "G", "Neznamova", "NeZnaa", "Spb", "9213000000", "anastasia@emc.com","test1"));
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }

}
