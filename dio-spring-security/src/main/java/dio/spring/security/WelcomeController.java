package dio.spring.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {

	@GetMapping
	public String welcome() {
		return "Welcome to my spring boot API";
	}
	
	@GetMapping("users")
//	@PreAuthorize("hasAnyRole('MANAGERS', 'USERS')") // removido pois era usado na autenticacao simples
	public String users() {
		return "Authorized user";
	}
	
	@GetMapping("managers")
//	@PreAuthorize("hasRole('MANAGERS')") // removido pois era usado na autenticacao simples
	public String managers() {
		return "Authorized manager";
	}
	
}
