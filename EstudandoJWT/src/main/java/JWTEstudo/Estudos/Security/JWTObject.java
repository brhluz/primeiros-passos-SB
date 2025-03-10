package JWTEstudo.Estudos.Security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/*
 * Objeto que representa o token, este será convertido e desconvertido pelo JWT, possuirá as informações pertinentes a autenticação e autorização.
 * 
 * */
public class JWTObject {

	private String subject; // nome do usuario
	private Date issuedAt; // data criacao do token
	private Date expirationDate; // data expiracao do token
	private List<String> roles; // data expiracao do token

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(Date issuedAt) {
		this.issuedAt = issuedAt;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = new ArrayList<String>(roles);
	}

}
