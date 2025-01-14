package dio.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dio.web.api.domain.Usuario;
import dio.web.api.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/users")
	public List<Usuario> getUsers() {
		return usuarioRepository.listAll();
	}
	
	@GetMapping("/users/{username}")
	public Usuario getOne(@PathVariable("username") String userName) {
		return usuarioRepository.findByUserName(userName);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		usuarioRepository.remove(id);
	}
	
	@PostMapping("/users")
	public void saveUser(@RequestBody Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	@PutMapping("/users")
	public void updateUser(@RequestBody Usuario usuario) {
		usuarioRepository.update(usuario);
	}
}
