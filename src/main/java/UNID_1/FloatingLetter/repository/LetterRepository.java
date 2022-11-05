package UNID_1.FloatingLetter.repository;

import UNID_1.FloatingLetter.domain.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterRepository extends JpaRepository<Letter, Long> {
}
