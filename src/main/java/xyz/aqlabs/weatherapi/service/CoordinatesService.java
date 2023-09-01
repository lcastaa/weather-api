package xyz.aqlabs.weatherapi.service;


import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyz.aqlabs.weatherapi.model.coordinate.Root;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service
public class CoordinatesService {


    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_BASE = "http://api.weatherstack.com/current";
    private final String ACCESS_KEY = "?access_key=d204a8afc9bc89a0c95b70459d9a55d7";


    // gets JSON response from External API containing Coordinates
    public ResponseEntity<?> getCoordinates(String query){
        var fullQuery = "&query="+query;
        var response = restTemplate.exchange(API_BASE+ACCESS_KEY+fullQuery, HttpMethod.GET, createEntity(), Root.class);
        return trimmer(response);
    }


    // trims all excess data and the weather application and return just the important information
    private ResponseEntity<?> trimmer(ResponseEntity<Root> response){
        if(!response.hasBody())
            return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body("Response was empty from external api");
        var location = Objects.requireNonNull(response.getBody()).location();
        Map<String,String> map = new HashMap<>();
        map.put("City", location.name());
        map.put("State", location.region());
        map.put("Country", location.country());
        map.put("latitude", location.lat());
        map.put("longitude", location.lon());
        return ResponseEntity.ok().body(map);
    }


    // creates the response entity for the external request
    private HttpEntity<Void> createEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);;
        return new HttpEntity<Void>(headers);
    }


}
