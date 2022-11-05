package UNID_1.FloatingLetter.repository;

import UNID_1.FloatingLetter.domain.Letter;
import UNID_1.FloatingLetter.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LetterRepository extends JpaRepository<Letter, Long> {

    Letter save(Letter letter);
    List<Letter> findAllByUser(User user);
    List<Letter> findAll();
}
