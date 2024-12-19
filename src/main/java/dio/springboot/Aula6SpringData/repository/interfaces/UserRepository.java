package dio.springboot.Aula6SpringData.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import dio.springboot.Aula6SpringData.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
