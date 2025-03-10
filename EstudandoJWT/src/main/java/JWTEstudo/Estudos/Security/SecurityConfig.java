package JWTEstudo.Estudos.Security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {
	
	/*
	 * o spring com @ConfigurationProperties, geralmente não gerencia bem com
	 * atributos staticos... qualquer coisa remover.
	 */
	
	public static String PREFIX; /*-> Geralmente utilizado Bearer -> facilita a validação e o parsing do token
									-> Define o prefixo do token no cabeçalho "Authorization"
									-> Exemplo de token: Authorization: Bearer <seu_token_jwt>*/
	public static String KEY; 	/*
								 * -> Define a chave secreta usada para assinar e verificar a autenticidade do token JWT
								 * -> No JWT, a assinatura garante que o token não foi alterado depois de gerado
								 * -> Essa chave deve ser secreta e segura. Em produção, nunca deve ser colocado no source do projeto.
								 * 	  deve ficar em variaveis de ambientes ou serviços de configuração seguros (AWS Secrets Manager, HashiCorp Vault)...
								 */
	public static Long EXPIRATION; // -> Define o tempo de expiração do token (em ms)

	public void setPrefix(String prefix) {
		PREFIX = prefix;
	}

	public void setKey(String key) {
		KEY = key;
	}

	public void setExpiration(Long expiration) {
		EXPIRATION = expiration;
	}

}
