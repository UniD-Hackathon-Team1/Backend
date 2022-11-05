package UNID_1.FloatingLetter.service;

import UNID_1.FloatingLetter.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LetterService {

    private LetterRepository letterRepository;

}
