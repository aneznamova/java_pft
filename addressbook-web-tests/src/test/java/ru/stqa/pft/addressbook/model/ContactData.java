package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String middle;
    private final String lastname;
    private final String nickname;
    private final String address;
    private final String mobile;
    private final String email;

    public ContactData(String firstname, String middle, String lastname, String nickname, String address, String mobile, String email) {
        this.firstname = firstname;
        this.middle = middle;
        this.lastname = lastname;
        this.nickname = nickname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
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

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }
}