package UNID_1.FloatingLetter.repository;

import UNID_1.FloatingLetter.domain.Letter;
import UNID_1.FloatingLetter.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LetterRepository extends JpaRepository<Letter, Long> {
    int countByUser(User user);
    Page<Letter> findAllByUser(User user, Pageable pageable);
    List<Letter> findAllByUser(User user);
}
