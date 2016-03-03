package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;


public class GroupDeletionTest extends TestBase {

    @Test
    public void testDeletionGroup() {

        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupForm();
    }

}
