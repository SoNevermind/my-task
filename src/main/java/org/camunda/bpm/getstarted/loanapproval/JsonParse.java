package org.camunda.bpm.getstarted.loanapproval;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class JsonParse {
    public void parseJson() throws IOException {
        String url = "https://randomuser.me/api/";
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer responce = new StringBuffer();

        while((inputLine = in.readLine()) != null){
            responce.append(inputLine);
        }
        in.close();

        String json = responce.toString().replace("{\"results\":[", "");

        HashMap<String, Object> map = new HashMap<String, Object>();

        ObjectMapper mapper = new ObjectMapper();
        try{
            map = (HashMap<String, Object>) mapper.readValue(json, new TypeReference<Map<String,  Object>>(){});

            System.out.println(map.get("title"));
        } catch (JsonGenerationException e){
            e.printStackTrace();
        } catch (JsonMappingException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
