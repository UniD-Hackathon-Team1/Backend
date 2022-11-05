package UNID_1.FloatingLetter.service;

import UNID_1.FloatingLetter.domain.User;
import UNID_1.FloatingLetter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        User newUser = userRepository.save(user);
        return newUser;
    }

    public User getUserByUserIdAndPassword(String userId, String password){
        return userRepository.findUserByUserIdAndPassword(userId, password);
    }

}
