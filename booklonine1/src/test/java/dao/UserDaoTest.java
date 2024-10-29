package dao;

import entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void insertUser() {
        UserDao userDao = new UserDaoImpl();
        User user=new User();
        user.setAccount("gwh");
        user.setCipher("123456");
        user.setNickname("gwh");
        user.setAddress("501");
        userDao.insertUser(user);


    }
}