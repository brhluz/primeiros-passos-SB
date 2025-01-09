package dio.web.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerRedirectController {
	
	@GetMapping("/swagger-ui")
    public String redirectSwagger() {
        return "redirect:/swagger-ui/index.html";
    }
}
