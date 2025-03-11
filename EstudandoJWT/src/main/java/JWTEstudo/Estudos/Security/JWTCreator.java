package JWTEstudo.Estudos.Security;

import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTCreator {

	public static final String HEADER_AUTHORIZATION = "Authorization"; 
	public static final String ROLES_AUTHORITIES = "authorities";
	
	// cria o token
	public static String create(String prefix, String key, JWTObject jwtObject) {
		
		// token é formado por header; payload; signature
		
		String token = Jwts.builder()
				.setSubject(jwtObject.getSubject()) // seta usuario
				.setIssuedAt(jwtObject.getIssuedAt())
				.setExpiration(jwtObject.getExpirationDate())
				.claim(ROLES_AUTHORITIES, checkRoles(jwtObject.getRoles())) // o Payload do JWT contém as claims. 
				.signWith(SignatureAlgorithm.HS256, key) // SIGNATURE
				.compact();
		
		return prefix + " " + token;
	}
	
	
	// cria o objeto da autenticação a partir do token JWT
	public static JWTObject create(String token, String prefix, String key)
			throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException{
		
		JWTObject object = new JWTObject();
		
		token = token.replace(prefix, "").trim();
		
		// Recupera informações de autenticação/autorização do token
		Claims claims = Jwts.parser()
					.setSigningKey(key)
					.parseClaimsJws(token)
					.getBody();
		
		object.setSubject(claims.getSubject());
		object.setExpirationDate(claims.getExpiration());
		object.setIssuedAt(claims.getIssuedAt());
		object.setRoles((List<String>) claims.get(ROLES_AUTHORITIES, List.class));
		object.setSubject(claims.getSubject());
		
		return object;
	}
	 
	public static List<String> checkRoles(List<String> roles) {
		return roles.stream()
				.map(s -> "ROLE_".concat(s.replaceAll("ROLE_", "")))
				.collect(Collectors.toList());
	}
	
	
	
}
