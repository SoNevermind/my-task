package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONArray;

public class CalculateInterestService implements JavaDelegate {
    public void execute(DelegateExecution delegate) throws Exception {
        Fields fields = new Fields();
        ManagerFields managerFields = new ManagerFields();
        String title, first, last;

/*       delegate.setVariable("Surname", Surname);
        delegate.setVariable("Name", Name);
        delegate.setVariable("Middle", Middle);
        delegate.setVariable("Address", Address);
        delegate.setVariable("Age", Age);
        delegate.setVariable("Tariff", selected_tariff);*/

        Map<String, Object> variables = delegate.getVariables();

        String json = getJSON("https://randomuser.me/api/");
        JSONObject obj;

        try {
            obj = new JSONObject(json);
            JSONArray results_arr = obj.getJSONArray("results");

            final int n = results_arr.length();
            for (int i = 0; i < n; i++) {
                title = results_arr.getJSONObject(i).getJSONObject("name").getString("title");
                first = results_arr.getJSONObject(i).getJSONObject("name").getString("first");
                last = results_arr.getJSONObject(i).getJSONObject("name").getString("last");

                int number = results_arr.getJSONObject(i).getJSONObject("location").getJSONObject("street").getInt("number");
                String adName = results_arr.getJSONObject(i).getJSONObject("location").getJSONObject("street").getString("name");

                String FIO = title + " " + first + " " + last;
                String address = number + " " + adName;

                delegate.setVariable("FIO", FIO);
                delegate.setVariable("Address", address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        fields.setAge((Long) variables.get("Age"));
        fields.setSelected_tariff((String) variables.get("Selected_tariff"));

        /*managerFields.setClient((String) variables.get("Client"));
        managerFields.setClient_Age((Long) variables.get("Client_Age"));
        managerFields.setSelected_Tariff_Of_Client((String) variables.get("Selected_tariff"));
        managerFields.setNumber_Of_Application((Long) variables.get("Number_Of_Application"));*/
    }

    public static String getJSON(String url) {
        HttpsURLConnection con = null;

        try {
            URL u = new URL(url);
            con = (HttpsURLConnection) u.openConnection();

            con.connect();


            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();

            return sb.toString();


        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        return null;
    }

}
