package dio.springboot.Aula3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SistemMensageria {

	@Autowired
	private Remetente noReply;

	@Autowired
	private Remetente techTeam;
	
	public void enviarConfirmacaoCadastro() {
		System.out.println(noReply);
		System.out.println("Cadastro Realizado com Sucesso!!!");
	}

	public void enviarEmailBoasVindas() {
		techTeam.setEmail("testadotech123@testando.com.br");
		System.out.println(techTeam);
		System.out.println("Seja bem-vindo à TechLead !!!");
		System.out.println(noReply);
	}
	
}
