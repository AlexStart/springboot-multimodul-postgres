package my.springboot.multimodul.postgres.service;

import my.springboot.multimodul.postgres.domain.User;

import java.util.List;

/**
 * Created by Саша on 22.04.2017.
 */
public interface IUserService {

    public User createUser(User user);

    public void removeUser(Long id);

    public User updateUser(User user);

    public User patchUser(User user);

    public List<User> findAllUser();

    public User findUser(Long id);

    public List<User> findUsersOlderThan(Integer age);
}
