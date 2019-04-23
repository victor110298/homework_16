package dao;

import entity.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User findUserById(Long id);

    List<User> getAllUsers();
}
