package cat.tecnocampus.services;

import cat.tecnocampus.domain.Station;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by roure on 16/11/2016.
 */
@Service
public class LaPoblaService {

    private static String XARXA_URL = "http://lleidalapobla.fgc.cat/api/1.0/xarxa";

    public List<Station> getLaPoblaStations() {
        List<Station> stations = null;
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(XARXA_URL, String.class);

        stations = getStationsFromResponse(response);
        return stations;
    }

    private List<Station> getStationsFromResponse(ResponseEntity<String> response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response.getBody());
            Iterator<JsonNode> nodes = root.path("nodes").elements();

            //convert Iterator to Stream
            Iterable<JsonNode> iterable = () -> nodes;
            Stream<JsonNode> nodesStream = StreamSupport.stream(iterable.spliterator(), false);

            //get stations
            return nodesStream
                    .filter(n -> n.path("estacio").asBoolean())
                    .map(n -> jsonToStation(mapper, n))
                    .collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<Station>();
        }
    }

    private Station jsonToStation(ObjectMapper mapper, JsonNode node) {
        try {
            System.out.println(node.path("nom"));
            return mapper.treeToValue(node, Station.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new Station();
        }
    }
}
