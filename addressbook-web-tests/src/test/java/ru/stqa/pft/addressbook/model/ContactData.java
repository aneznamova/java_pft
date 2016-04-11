package ru.stqa.pft.addressbook.model;

import java.io.File;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String middle;
    private String lastname;
    private String nickname;
    private String address;
    private String homephone;
    private String mobilephone;
    private String workphone;
    private String email;
    private String email2;
    private String email3;
    private String group;
    private String allPhones;
    private String allEmails;
    private String allDetails;
    private File photo;

    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getAllDetails() {
        return allDetails;
    }

    public ContactData withAllDetails(String allDetails) {
        this.allDetails = allDetails;
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getEmail2() {
        return email2;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public String getEmail3() {
        return email3;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withMiddle(String middle) {
        this.middle = middle;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomephone (String homephone) {
        this.homephone = homephone;
        return this;
    }

    public ContactData withMobilephone (String mobilephone) {
        this.mobilephone = mobilephone;
        return this;
    }

    public ContactData withWorkphone (String workphone) {
        this.workphone = workphone;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddle() {
        return middle;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAddress() {
        return address;
    }

    public String getHomephone() {
        return homephone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }



    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        return firstname != null ? firstname.equals(that.firstname) : that.firstname == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        return result;
    }

}
