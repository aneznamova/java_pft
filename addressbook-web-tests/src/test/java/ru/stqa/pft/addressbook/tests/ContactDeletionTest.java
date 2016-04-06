package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by neznaa on 3/6/2016.
 */
public class ContactDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (app.contact().list().size() == 0) app.contact().create(new ContactData()
                .withFirstname("Anastasia").withMiddle("G").withLastname("Neznamova").withNickname("NeZnaa")
                .withAddress("Spb").withMobile("9213000000").withEmail("anastasia@emc.com").withGroup("test1"));
    }

    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);

    }

}
