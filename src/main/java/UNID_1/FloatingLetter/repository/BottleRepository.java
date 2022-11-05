package UNID_1.FloatingLetter.repository;

import UNID_1.FloatingLetter.domain.Bottle;
import UNID_1.FloatingLetter.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BottleRepository extends JpaRepository<Bottle, Long> {
    List<Bottle> findAllByClosed(boolean closed);
}
