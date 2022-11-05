package UNID_1.FloatingLetter.controller;

import UNID_1.FloatingLetter.domain.Letter;
import UNID_1.FloatingLetter.domain.User;
import UNID_1.FloatingLetter.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class LetterController {

    private final LetterService letterService;

    @PostMapping(value = "/write")
    public Letter writeLetter(@AuthenticationPrincipal User user, @RequestBody Map<String, Object> request){
        return letterService.save(request, user);
    }

    @PutMapping(value = "/continuing")
    public Letter continueLetter(@AuthenticationPrincipal User user, @RequestBody Map<String, Object> request){
        return letterService.save(request, user);
    }

    @GetMapping(value = "/letter_list")
    public List<Letter> letterList(@AuthenticationPrincipal User user){
        return letterService.list(user);
    }
//
//    @GetMapping(value = "/letter")
//    public String letter(@RequestBody Map<String, Object> request){
//    }

}
