package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by neznaa on 3/4/2016.
 */
public class ContactHelper  extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void submitContactForm() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("middlename"),contactData.getMiddle());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("nickname"),contactData.getNickname());
        type(By.name("address"),contactData.getAddress());
        type(By.name("home"),contactData.getHomephone());
        type(By.name("mobile"),contactData.getMobilephone());
        type(By.name("work"),contactData.getWorkphone());
        type(By.name("email"),contactData.getEmail());
        attach(By.name("photo"), contactData.getPhoto());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void initContactModification() {
        click(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void initContactModificationByID(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void confirmDeletionContact() {
        wd.switchTo().alert().accept();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void create(ContactData contact) {
        initContactCreation();
        fillContactForm(contact, true);
        submitContactForm();
        contactCache = null;
        returnToContactList();
    }

        public void modify(ContactData contact) {
        initContactModification();
        fillContactForm(contact, false);
        submitContactModification();
        contactCache = null;
        returnToContactList();
    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectedContact();
        confirmDeletionContact();
        contactCache = null;
        returnToHome();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        confirmDeletionContact();
        contactCache = null;
        returnToHome();
    }

    public void returnToHome() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public void returnToContactList() {
        click(By.linkText("home page"));
    }


    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for(WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }

        return contacts;
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for(WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String adress = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            String allPhones = cells.get(5).getText();
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withAddress(adress).withAllEmails(allEmails).withAllPhones(allPhones));
        }

        return new Contacts(contactCache);
    }


    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationByID(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value").replaceAll("[-()]","").replaceAll("\\s", "");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value").replaceAll("[-()]","").replaceAll("\\s", "");
        String work = wd.findElement(By.name("work")).getAttribute("value").replaceAll("[-()]","").replaceAll("\\s", "");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomephone(home).withMobilephone(mobile).withWorkphone(work).withAddress(address)
                .withEmail(email).withEmail2(email2).withEmail3(email3);


    }

    public ContactData infoFromDetailsForm(ContactData contact) {
        initContactDetails(contact.getId());
        String allDetails = wd.findElement(By.id("content")).getText();
        String[] details = allDetails.split("\n");
        String firstname = details[0].replaceAll(" .+", "");
        String lastname = details[0].replaceAll(".+ ", "");
        String address = details[1];
        String home = details[3].replaceAll("H: ", "").replaceAll("[-()]","").replaceAll("\\s", "");
        String mobile = details[4].replaceAll("M: ", "").replaceAll("[-()]","").replaceAll("\\s", "");
        String work = details[5].replaceAll("W: ", "").replaceAll("[-()]","").replaceAll("\\s", "");
        String email = details[7].replaceAll(" \\(.+\\)", "");
        String email2 = details[8].replaceAll(" \\(.+\\)", "");
        String email3 = details[9].replaceAll(" \\(.+\\)", "");
              //  .replaceAll("(Member of.*|Notice:.*|test.*|[WMH]: | \\(www.*\\))", "")
               // .replaceAll("\\s", "").replaceAll("[-()]", "")
               // .replaceAll("\n+", "\n");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withAddress(address).withHomephone(home).withMobilephone(mobile)
                .withWorkphone(work).withEmail(email).withEmail2(email2).withEmail3(email3);
    }

    private void initContactDetails(int id) {
        wd.findElement((By.cssSelector(String.format("a[href='view.php?id=%s']", id)))).click();
    }
}
