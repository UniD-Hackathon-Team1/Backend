package UNID_1.FloatingLetter.controller;

import UNID_1.FloatingLetter.domain.User;
import UNID_1.FloatingLetter.dto.response.BottleResponse;
import UNID_1.FloatingLetter.dto.response.LetterResponse;
import UNID_1.FloatingLetter.dto.response.RandomResponse;
import UNID_1.FloatingLetter.service.BottleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bottle")
public class BottleController {

    private final BottleService bottleService;

    @GetMapping("/random")
    public ResponseEntity<RandomResponse> getRandomBottle(@AuthenticationPrincipal User user) {
        return ResponseEntity
                .status(OK)
                .body(bottleService.getRandomBottle(user));
    }

    @GetMapping("/{bottleId}")
    public ResponseEntity<BottleResponse> getBottleLetters(@PathVariable Long bottleId) {
        return ResponseEntity
                .status(OK)
                .body(bottleService.getBottleLetters(bottleId));
    }

    @GetMapping("/closed/list")
    public ResponseEntity<List<Long>> getClosedBottles() {
        return ResponseEntity
                .status(OK)
                .body(bottleService.getClosedBottles());
    }

}
