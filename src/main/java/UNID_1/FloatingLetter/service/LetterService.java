package UNID_1.FloatingLetter.service;

import UNID_1.FloatingLetter.repository.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LetterService {
    private LetterRepository letterRepository;

    @Autowired
    public LetterService(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }
}
