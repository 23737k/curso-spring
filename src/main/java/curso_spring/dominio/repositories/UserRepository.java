package curso_spring.dominio.repositories;

import curso_spring.dominio.user.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    //Creo este método para encontrar al usuario en la bd
    Optional<User> findByEmail(String email);
}
