package com.agiletdd.application.service;

import com.agiletdd.application.domain.User;
import com.agiletdd.application.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String city) {
        User exists = userRepository.findByName(name);
        if (null != exists) {
            throw new RuntimeException("duplicated name");
        }

        User user = new User(name, city);

        userRepository.save(user);

        return user;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}
