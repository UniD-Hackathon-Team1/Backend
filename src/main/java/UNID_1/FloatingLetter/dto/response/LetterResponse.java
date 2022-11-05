package UNID_1.FloatingLetter.dto.response;

import UNID_1.FloatingLetter.domain.Letter;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
@Builder
public class LetterResponse {
    String text;
    Map<String, Integer> time;

    public static LetterResponse of(Letter letter) {
        Map<String, Integer> parsedTime = new HashMap<>();
        parsedTime.put("year", letter.getTime().getYear());
        parsedTime.put("month", letter.getTime().getMonth().getValue());
        parsedTime.put("day", letter.getTime().getDayOfMonth());

        return LetterResponse.builder()
                .text(letter.getText())
                .time(parsedTime)
                .build();
    }

}
