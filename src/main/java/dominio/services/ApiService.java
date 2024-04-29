package dominio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class ApiService {
	private final String URL = "https://api.distancematrix.ai/maps/api/distancematrix/json?key=vMfcmmkYwdLfltNDTjqRHbMJlpvbWkfvzRzTZzHwspHzfFWEw5r8HMRSvXRPTfd2";
	@Autowired
	private RestTemplate restTemplate;

	public String obtenerDistancia(String origen, String destino) {
		String queryParams = "&origins=" + origen + "&destinations=" + destino;
		JsonNode response = restTemplate.getForObject(URL + queryParams, JsonNode.class);
		String distanceText;
		if (response != null) {
			JsonNode distanceNode = response.path("rows").get(0).path("elements").get(0).path("distance").path("text");
			distanceText = distanceNode.asText();
		} else {
			distanceText = "Error al obtener la respuesta de la API";
		}
		return distanceText;
	}
}