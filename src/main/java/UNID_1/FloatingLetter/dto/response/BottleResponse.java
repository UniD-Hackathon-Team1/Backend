package UNID_1.FloatingLetter.dto.response;

import UNID_1.FloatingLetter.domain.Letter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BottleResponse {

    private Long bottleId;
    private List<LetterResponse> letter;

}
