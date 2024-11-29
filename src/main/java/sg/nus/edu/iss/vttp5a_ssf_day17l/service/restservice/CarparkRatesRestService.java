package sg.nus.edu.iss.vttp5a_ssf_day17l.service.restservice;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.nus.edu.iss.vttp5a_ssf_day17l.model.CarparkRate;
import sg.nus.edu.iss.vttp5a_ssf_day17l.util.APILink;

@Service
public class CarparkRatesRestService {
    
    RestTemplate restTemplate = new RestTemplate();

    public List<CarparkRate> getAllCarparkRates(){
        String carparkRatesData = restTemplate.getForObject(APILink.apiLink, String.class);

        JsonReader jReader = Json.createReader(new StringReader(carparkRatesData));
        JsonObject jObject = jReader.readObject().getJsonObject("result");
        JsonArray jArray = jObject.getJsonArray("records");

        // Set<Entry<String, JsonValue>> entries = jObject.entrySet();

        List<CarparkRate> carparkRates = new ArrayList<>();
        // List<String> carparkRates = new ArrayList<>();
        // for(Entry<String, JsonValue> entry:entries){
        //     carparkRates.add(entry.getValue().toString());
        // }
        for(int i  = 0; i < jArray.size(); i++){
            JsonObject jObjectFromArray = jArray.getJsonObject(i);
            CarparkRate carparkRate = new CarparkRate(jObjectFromArray.getInt("_id"), 
            jObjectFromArray.getString("carpark"), jObjectFromArray.getString("category"), jObjectFromArray.getString("weekdays_rate_1"), 
            jObjectFromArray.getString("weekdays_rate_2"), jObjectFromArray.getString("saturday_rate"), jObjectFromArray.getString("sunday_publicholiday_rate"));

            carparkRates.add(carparkRate);
        }
        return carparkRates; 
    }
}
