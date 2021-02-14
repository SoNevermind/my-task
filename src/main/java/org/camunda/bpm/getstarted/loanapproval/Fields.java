package org.camunda.bpm.getstarted.loanapproval;

import java.io.Serializable;

public class Fields implements Serializable {
    protected String Surname;
    protected String Name;
    protected String Middle;
    protected String Address;
    protected Long Age;
    protected Tariff Selected_tariff;

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMiddle() {
        return Middle;
    }

    public void setMiddle(String middle) {
        Middle = middle;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Long getAge() {
        return Age;
    }

    public void setAge(Long age) {
        Age = age;
    }

    public Tariff getSelected_tariff() {
        return Selected_tariff;
    }

    public String setSelected_tariff(Tariff selected_tariff) {
        Selected_tariff = selected_tariff;
        return null;
    }

    @Override
    public String toString() {
        return "Fields{" +
                "Surname='" + Surname + '\'' +
                ", Name='" + Name + '\'' +
                ", Middle='" + Middle + '\'' +
                ", Address='" + Address + '\'' +
                ", Age=" + Age +
                ", Selected_tariff=" + Selected_tariff +
                '}';
    }
}
