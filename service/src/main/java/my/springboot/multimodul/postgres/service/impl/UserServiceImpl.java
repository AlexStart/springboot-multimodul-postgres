package my.springboot.multimodul.postgres.service.impl;



import my.springboot.multimodul.postgres.domain.User;
import my.springboot.multimodul.postgres.persistence.IUserRepository;
import my.springboot.multimodul.postgres.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Саша on 22.04.2017.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }


    public void removeUser(Long id) {
        userRepository.delete(id);
    }


    public User updateUser(User user){
        return userRepository.save(user);
    }


    public User patchUser(User user){
        return userRepository.save(user);
    }


    public List<User> findAllUser(){
        return (List<User>)userRepository.findAll();
    }

    public User findUser(Long id){

        User foundUser = userRepository.findOne(id);

        if(foundUser == null) {
            User user = new User();
            user.setFirstName("***Alex-Test***");
            user.setLastName("***Smith-Test***");
            user.setAge(30);
            foundUser = createUser(user);
        }
        return foundUser;
    }


    public List<User> findUsersOlderThan(Integer age){
        return userRepository.findByAgeGreaterThan(String.valueOf(age));
    }

}
