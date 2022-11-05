package UNID_1.FloatingLetter.repository;

import UNID_1.FloatingLetter.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
    User findUserByUserIdAndPassword(String userId, String Password);
}
