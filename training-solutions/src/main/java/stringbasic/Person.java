package stringbasic;

public class Person {

    private String name;
    private String email;
    private String taj;
    private String bankAccount;
    private String phoneNumber;

    public Person(String name, String email, String taj, String bankAccount, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.taj = taj;
        this.bankAccount = bankAccount;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaj() {
        return taj;
    }

    public void setTaj(String taj) {
        this.taj = taj;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
