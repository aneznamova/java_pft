package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by neznaa on 3/4/2016.
 */
public class ContactHelper {
    private FirefoxDriver wd;


    public ContactHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void returnToContactList() {
        wd.findElement(By.linkText("home")).click();
    }

    public void submitContactForm() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactForm(ContactData contactData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(new CharSequence[]{contactData.getFirstname()});
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(new CharSequence[]{contactData.getMiddle()});
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(new CharSequence[]{contactData.getLastname()});
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(new CharSequence[]{contactData.getNickname()});
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(new CharSequence[]{contactData.getAddress()});
        wd.findElement(By.name("theform")).click();
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(new CharSequence[]{contactData.getMobile()});
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(new CharSequence[]{contactData.getEmail()});
    }

    public void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }
}
