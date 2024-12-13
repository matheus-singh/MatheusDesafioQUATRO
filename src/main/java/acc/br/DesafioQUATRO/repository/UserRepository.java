package acc.br.DesafioQUATRO.repository;

import acc.br.DesafioQUATRO.repository.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}