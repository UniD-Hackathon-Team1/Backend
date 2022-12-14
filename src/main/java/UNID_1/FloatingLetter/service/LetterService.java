package UNID_1.FloatingLetter.service;

import UNID_1.FloatingLetter.domain.Bottle;
import UNID_1.FloatingLetter.domain.Letter;
import UNID_1.FloatingLetter.domain.User;
import UNID_1.FloatingLetter.dto.request.LetterRequest;
import UNID_1.FloatingLetter.dto.response.LetterResponse;
import UNID_1.FloatingLetter.repository.BottleRepository;
import UNID_1.FloatingLetter.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LetterService {

    private final LetterRepository letterRepository;
    private final BottleRepository bottleRepository;

    public LetterResponse save(LetterRequest request, User user) {
        Bottle bottle;
        if (request.getBottleId() == null) {
            bottle = new Bottle();
            bottleRepository.save(bottle);
        } else {
            bottle = bottleRepository.findById(request.getBottleId()).orElse(null);
        }

        if (bottle.getLetterList().size() == 2) {
            bottle.updateClosed();
            bottleRepository.save(bottle);
        }

        Letter letter = new Letter(
                request.getText(),
                user,
                bottle
        );

        return LetterResponse.of(letterRepository.save(letter));
    }

    public List<LetterResponse> list(User user) {
        List<Letter> letterList = letterRepository.findAllByUser(user);
        return letterList.stream().map(LetterResponse::of).collect(Collectors.toList());
    }

}
