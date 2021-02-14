package org.camunda.bpm.getstarted.loanapproval;

public class ManagerFields {
    protected String Client;
    protected Long Client_Age;
    protected String Selected_Tariff_Of_Client;
    protected long Number_Of_Application;

    public String getClient() {
        return Client;
    }

    public void setClient(String client) {
        Client = client;
    }

    public Long getClient_Age() {
        return Client_Age;
    }

    public void setClient_Age(Long client_Age) {
        Client_Age = client_Age;
    }

    public String getSelected_Tariff_Of_Client() {
        return Selected_Tariff_Of_Client;
    }

    public void setSelected_Tariff_Of_Client(String selected_Tariff_Of_Client) {
        Selected_Tariff_Of_Client = selected_Tariff_Of_Client;
    }

    public long getNumber_Of_Application() {
        return Number_Of_Application;
    }

    public void setNumber_Of_Application(long number_Of_Application) {
        Number_Of_Application = number_Of_Application;
    }

    @Override
    public String toString() {
        return "ManagerFields{" +
                "Client='" + Client + '\'' +
                ", Client_Age=" + Client_Age +
                ", Selected_Tariff_Of_Client='" + Selected_Tariff_Of_Client + '\'' +
                ", Number_Of_Application=" + Number_Of_Application +
                '}';
    }
}
