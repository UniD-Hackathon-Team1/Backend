package UNID_1.FloatingLetter.service;

import UNID_1.FloatingLetter.domain.Bottle;
import UNID_1.FloatingLetter.domain.Letter;
import UNID_1.FloatingLetter.domain.User;
import UNID_1.FloatingLetter.repository.BottleRepository;
import UNID_1.FloatingLetter.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LetterService {

    private final LetterRepository letterRepository;
    private final BottleRepository bottleRepository;

    public Letter save(Map<String, Object> request, User user){
        Bottle bottle = bottleRepository.findById(request.get("bottleid")); // git test
        LocalDateTime now = LocalDateTime.now();

        if(bottle == null)
            bottle = new Bottle(now, false);

        if(bottle.getLetterList().size() == 2){
            bottle.updateClosed();
        }


        bottleRepository.save(bottle);
        Letter letter = new Letter(
                now,
                (String) request.get("text"),
                user,
                bottle
        );

        return letterRepository.save(letter);
    }

    public List<Letter> list(User user){
        return letterRepository.findAllByUser(user);
    }


}
