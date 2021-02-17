package org.camunda.bpm.getstarted.loanapproval;

import java.io.Serializable;

public class Fields implements Serializable {
    protected String FIO;
    protected String Address;
    protected Long Age;
    protected String Selected_tariff;

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
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

    public String getSelected_tariff() {
        return Selected_tariff;
    }

    public void setSelected_tariff(String selected_tariff) {
        Selected_tariff = selected_tariff;
    }

    @Override
    public String toString() {
        return "Fields{" +
                "FIO='" + FIO + '\'' +
                ", Address='" + Address + '\'' +
                ", Age=" + Age +
                ", Selected_tariff='" + Selected_tariff + '\'' +
                '}';
    }
}
