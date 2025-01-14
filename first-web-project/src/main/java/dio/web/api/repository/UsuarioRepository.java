package dio.web.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dio.web.api.domain.Usuario;
import dio.web.api.handler.BusinessException;
import dio.web.api.handler.CampoObrigatorioException;

@Repository
public class UsuarioRepository {

	public void save(Usuario usuario) {
		System.out.println("SAVE - Recebendo o usuário na camada de repositório");
		System.out.println(usuario);
	}

	public void update(Usuario usuario){
		
//		if(usuario.getUserName()==null || usuario.getUserName().length()<=0) {
//			throw new BusinessException("O Campo Login é Obrigatório");
//		}
		
//		if(usuario.getUserName()==null || usuario.getUserName().length()<=0) {
//			throw new Exception("O Campo Login é Obrigatório");
//		}
		
		if(usuario.getUserName()==null || usuario.getUserName().length()<=0) {
			throw new RuntimeException("O Campo Login é Obrigatório");
		}
		
//		if(usuario.getUserName()==null || usuario.getUserName().length()<=0) {
//			throw new CampoObrigatorioException("userName");
//		}
//		if(usuario.getSenha()==null || usuario.getSenha().length()<=0) {
//			throw new CampoObrigatorioException("senha");
//		}
		
		System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
		System.out.println(usuario);
	}

	public void remove(Long id) {
		System.out.println(String.format("Delete/id - Recebendo o id: %d para excluir um usuário"));
	}
	
	public List<Usuario> listAll(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		usuarios.add(new Usuario("Bruno", "Password"));
		usuarios.add(new Usuario("Stephany", "Senha"));
		
		return usuarios;
	}
	
	public Usuario findById(Long id) {
		System.out.println(String.format("GET/id - Recebendo o id: %d para localizar um usuário", id));
		return new Usuario("Bruno", "Password");
	}
	
	public Usuario findByUserName(String userName) {
		System.out.println(String.format("FIND/username - Recebendo o username: %s para localizar um usuário", userName));
		return new Usuario(userName, "Password");
	}

}
