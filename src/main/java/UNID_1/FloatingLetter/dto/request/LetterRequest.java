package UNID_1.FloatingLetter.dto.request;

import UNID_1.FloatingLetter.domain.Letter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LetterRequest {
    String text;
    Long bottleId;
}