package dio.springboot.Aula2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class ConversorJson {
	
	@Autowired
	private Gson gson;
	
	public ViaCepResponse converter(String json	) {
		return gson.fromJson(json, ViaCepResponse.class);
	}
	
}
