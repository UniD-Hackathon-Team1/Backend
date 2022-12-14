package UNID_1.FloatingLetter.controller;

import UNID_1.FloatingLetter.config.JwtTokenProvider;
import UNID_1.FloatingLetter.domain.User;
import UNID_1.FloatingLetter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping(value = "/register")
    public Map<String, String> register(@RequestBody User user){
        Map<String, String> result = new HashMap<String, String>();

        String token = jwtTokenProvider.createToken(user.getUserId(), user.getRoles());
        if(userService.isExistUser(user.getUserId())){
            result.put("token", null);
        }
        else{
            userService.registerUser(user);
            result.put("token", token);
        }

        return result;
    }

    @PostMapping(value="/login")
    public Map<String, String> login(@RequestBody User inputUser){
        Map<String, String> result = new HashMap<String, String>();
        User user = userService.getUserByUserIdAndPassword(inputUser.getUserId(), inputUser.getPassword());
        String token = jwtTokenProvider.createToken(user.getUserId(), user.getRoles());
        if(user == null){
            result.put("token", null);
            result.put("nickname", user.getNickname());
        }
        else{
            result.put("token", token);
            result.put("nickname", user.getNickname());
        }
        return result;
    }

}
