package boullosa.caminosantiagofront;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class ExperienciasService {

	private ClienteRest clienteRest = new ClienteRest();
	
	public ExperienciasService() {
	}

	public ExperienciaDto[] obtenerExperiencias() {
		ExperienciaDto[] experiencias = null;
		try {
			experiencias = clienteRest.get("https://caminosantiago.herokuapp.com/obtenerExperiencias");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return experiencias;
	}
}
