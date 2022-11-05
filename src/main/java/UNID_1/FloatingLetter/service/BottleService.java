package UNID_1.FloatingLetter.service;

import UNID_1.FloatingLetter.domain.Bottle;
import UNID_1.FloatingLetter.domain.Letter;
import UNID_1.FloatingLetter.domain.User;
import UNID_1.FloatingLetter.dto.response.LetterResponse;
import UNID_1.FloatingLetter.dto.response.RandomResponse;
import UNID_1.FloatingLetter.repository.BottleRepository;
import UNID_1.FloatingLetter.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BottleService {

    private final BottleRepository bottleRepository;
    private final LetterRepository letterRepository;

    @Transactional(readOnly = true)
    public RandomResponse getRandomBottle(User user) {
        // 랜덤 유리병
        long count = letterRepository.count();
        int randomIndex = (int) (Math.random() * count);
        System.out.println(randomIndex);
        Page<Letter> page1 = letterRepository
                .findAll(
                        PageRequest.of(randomIndex, 1)
                );
        Long glassBottleId = null;
        if (page1.hasContent()) glassBottleId = page1.getContent().get(0).getBottle().getId();

        // 내 글이 포함된 유리병
        count = letterRepository.countByUser(user);
        randomIndex = (int) (Math.random() * count);
        Page<Letter> page2 = letterRepository
                .findAllByUser(
                        user,
                        PageRequest.of(randomIndex, 1)
                );
        Long pelicanBottleId = null;
        if (page2.hasContent()) pelicanBottleId = page2.getContent().get(0).getBottle().getId();

        return RandomResponse.of(pelicanBottleId, glassBottleId);
    }

    @Transactional(readOnly = true)
    public List<LetterResponse> getBottleLetters(Long bottleId) {
        Bottle bottle = bottleRepository.findById(bottleId)
                .orElse(null);
        List<Letter> letterList = bottle.getLetterList();
        return letterList.stream().map(LetterResponse::of).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Long> getClosedBottles() {
        List<Bottle> bottleList = bottleRepository.findAllByClosed(true);
        return bottleList.stream().map(Bottle::getId).collect(Collectors.toList());
    }

}
