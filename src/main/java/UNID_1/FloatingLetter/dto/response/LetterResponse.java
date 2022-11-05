package UNID_1.FloatingLetter.dto.response;

import UNID_1.FloatingLetter.domain.Letter;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LetterResponse {
    String text;
    int year;
    int month;
    int day;// 파싱 예정

    public static LetterResponse of(Letter letter) {
        return LetterResponse.builder()
                .text(letter.getText())
                .year(letter.getTime().getYear())
                .month(letter.getTime().getMonth().getValue())
                .day(letter.getTime().getDayOfMonth())
                .build();
    }

}
