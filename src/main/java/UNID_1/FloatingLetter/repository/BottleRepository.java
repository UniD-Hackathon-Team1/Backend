package UNID_1.FloatingLetter.repository;

import UNID_1.FloatingLetter.domain.Bottle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BottleRepository extends JpaRepository<Bottle, Long> {

    Bottle findByid(Long id);

    Bottle save(Bottle bottle);
}
