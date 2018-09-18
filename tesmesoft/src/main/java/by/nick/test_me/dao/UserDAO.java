package by.nick.test_me.dao;

import by.nick.test_me.entity.User;
import by.nick.test_me.exception.DAOException;

import java.util.List;

public interface UserDAO {

    User authorUser(String login, String password) throws DAOException;

    User getUserById(int id) throws DAOException;

    List<User> getUsers() throws DAOException;

    int addUser(User user) throws DAOException;

    boolean deleteUser(int userID) throws DAOException;

}
