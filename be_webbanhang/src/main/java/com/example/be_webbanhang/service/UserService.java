package com.example.be_webbanhang.service;

import com.example.be_webbanhang.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.be_webbanhang.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        Optional<User> userOptional =
                userRepository.findUserById(user.getIdUser());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("Id taken");
        }
        userRepository.save(user);
    }

    public void removeUser(int idUser){
        boolean exists = userRepository.existsById(idUser);
        if (!exists) {
            throw new IllegalStateException("user with id " + idUser + " does not exists");
        }
        userRepository.deleteById(idUser);
    }

    @Transactional
    public User updateUser(User user, int idUser) {
        User user1 = this.userRepository.findOneById(idUser);
        BeanUtils.copyProperties(user, user1);
        return userRepository.saveAndFlush(user1);
    }
}
