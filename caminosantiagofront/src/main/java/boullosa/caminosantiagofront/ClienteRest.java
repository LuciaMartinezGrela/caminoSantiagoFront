package boullosa.caminosantiagofront;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class ClienteRest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteRest.class);
	
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();
	
	public ClienteRest() {
	}

	public ExperienciaDto[] get(final String endpoint) throws JsonProcessingException {
		final String METHODNAME = "post";
		LOGGER.info("{} Crear llamada rest -> [POST] {}", METHODNAME, endpoint);

		HttpEntity<?> entity;
		ResponseEntity<ExperienciaDto[]> response = null;
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json");

		entity = new HttpEntity<>(httpHeaders);

		response = restTemplate.exchange(endpoint, HttpMethod.GET, entity, ExperienciaDto[].class);
		LOGGER.info(response.toString());

	
		return response.getBody();
	}

}
