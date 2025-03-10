package JWTEstudo.Estudos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import JWTEstudo.Estudos.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT e FROM User e JOIN FETCH e.role_id WHERE e.username = :username")
	public User findByUsername(@Param("username")  String username);
	
	boolean existsByUsername(String usernamge);
}
