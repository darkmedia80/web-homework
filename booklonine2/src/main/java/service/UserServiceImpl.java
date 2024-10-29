package service;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User signIn(String account, String password) {
        User user = User.builder().account(account).cipher(password).build();
        return userDao.findUser(user);

    }
    public int register(String account, String password) {
        User user = User.builder().account(account).cipher(password).build();
        return userDao.insertUser(user);
    }

//    @Override
//    public int updataImage(String account, String avatar) {
//        return userDao.updataImage(account,avatar);
//    }
//
//    @Override
//    public User userInfo(String account) {
//        return userDao.userInfo(account);
//    }

}
