package UNID_1.FloatingLetter.service;

import UNID_1.FloatingLetter.repository.BottleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BottleService {
    private BottleRepository bottleRepository;

    @Autowired
    public BottleService(BottleRepository bottleRepository) {
        this.bottleRepository = bottleRepository;
    }
}
