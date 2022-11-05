package UNID_1.FloatingLetter.dto.response;

import UNID_1.FloatingLetter.domain.Letter;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LetterResponse {
    String text;
    String time; // 파싱 예정

    public static LetterResponse of(Letter letter) {
        return LetterResponse.builder()
                .text(letter.getText())
                .time(letter.getText())
                .build();
    }

}
