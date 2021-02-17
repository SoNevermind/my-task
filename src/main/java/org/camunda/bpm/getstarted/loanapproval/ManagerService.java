package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.variable.VariableMap;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ManagerService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegate) throws Exception{
        ManagerFields managerFields = new ManagerFields();
        Map<String, Object> variables = new HashMap<String, Object>();

        try {
            managerFields.setClient((String) variables.get("FIO"));
            managerFields.setClient_Age((Long) variables.get("Client_Age"));
            managerFields.setSelected_Tariff_Of_Client((String) variables.get("Selected_tariff"));
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        String json = getJSON("https://randomuser.me/api/");
        JSONObject obj;

        try {
            obj = new JSONObject(json);
            JSONArray results_arr = obj.getJSONArray("results");

            final int n = results_arr.length();
            for (int i = 0; i < n; i++) {
                long numberOfApp = results_arr.getJSONObject(i).getJSONObject("location").getLong("postcode");

                delegate.setVariable("Number_Of_Application", numberOfApp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
