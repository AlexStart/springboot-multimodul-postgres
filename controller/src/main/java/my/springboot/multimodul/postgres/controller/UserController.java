package my.springboot.multimodul.postgres.controller;

import my.springboot.multimodul.postgres.domain.Recommendation;
import my.springboot.multimodul.postgres.domain.User;
import my.springboot.multimodul.postgres.service.IRecommendationService;
import my.springboot.multimodul.postgres.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Саша on 22.04.2017.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Value("${server.port}")
    private int port;

    @Autowired
    private IUserService userService;
    @Autowired
    private IRecommendationService recommendationService;

    public UserController(){

    }

    @PostMapping()
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping(value = "/{id}/recommendations")
    public List<Recommendation> createUserRecommendations(@PathVariable Long id, @RequestBody List<Recommendation> recommendations){
        return recommendationService.createUserRecommendations(id, recommendations);
    }

    //TODO :
    @PostMapping(value = "/user")
    public String createUserAndReturnUserLink(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return createdUser != null ? "http://localhost:"+port+"/users/"+createdUser.getId() : "NO USER";
    }

    @DeleteMapping(value="/{id}")
    public String removeUser(@PathVariable Long id){
        userService.removeUser(id);
        return "USER WITH ID : "+id+" IS SUCCESSFULLY REMOVED!";
    }

    @PutMapping()
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PatchMapping()
    public User patchUser(@RequestBody User user){
        return userService.patchUser(user);
    }

    @GetMapping()
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable Long id){
        return userService.findUser(id);
    }

    @GetMapping(value="/age/{age}")
    public List<User> findUserOlderThan(@PathVariable Integer age){
        return userService.findUsersOlderThan(age);
    }
}
