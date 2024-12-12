package dio.springboot.Aula2;

import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

@Configuration
public class Bean {
	
	@org.springframework.context.annotation.Bean
	public Gson gson() {
		return new Gson();
	}
}
