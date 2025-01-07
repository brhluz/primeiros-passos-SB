package dio.springboot.Aula6SpringData.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.springboot.Aula6SpringData.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
