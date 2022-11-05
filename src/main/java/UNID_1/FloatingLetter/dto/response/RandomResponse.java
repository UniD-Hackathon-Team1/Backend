package UNID_1.FloatingLetter.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RandomResponse {
    Long pelicanBottleId;
    Long glassBottleId;

    public static RandomResponse of(Long pelicanBottleId, Long glassBottleId) {
        return RandomResponse.builder()
                .pelicanBottleId(pelicanBottleId)
                .glassBottleId(glassBottleId)
                .build();
    }
}
