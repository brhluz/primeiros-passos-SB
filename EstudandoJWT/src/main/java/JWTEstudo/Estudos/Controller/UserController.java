package JWTEstudo.Estudos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JWTEstudo.Estudos.Model.User;
import JWTEstudo.Estudos.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}
	
}
