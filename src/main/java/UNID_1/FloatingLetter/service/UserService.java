package UNID_1.FloatingLetter.service;

import UNID_1.FloatingLetter.domain.User;
import UNID_1.FloatingLetter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isExistUser(String userId){
        User user = userRepository.findByUserId(userId);
        if(user == null){
            return false;
        }
        else{
            return true;
        }
    }

    public User registerUser(User user){
        User newUser = new User(user.getUserId(), passwordEncoder.encode(user.getPassword()), user.getNickname());
        userRepository.save(newUser);
        return newUser;
    }

    public User getUserByUserIdAndPassword(String userId, String password) throws RuntimeException{
        User user = userRepository.findByUserId(userId);
        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException();
        }
        else{
            return userRepository.findUserByUserIdAndPassword(userId, user.getPassword());
        }
    }

}
