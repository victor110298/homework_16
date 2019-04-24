package dao;

import entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void saveUser(User user);

    void updateUser(User user);

    Optional<User> deleteUser(Long id);

    User findUserById(Long id);

    List<User> getAllUsers();
}
