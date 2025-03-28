package dio.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dio.spring.security.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username = :username")
	User findByUsername(@Param(value = "username") String username);
	
}
