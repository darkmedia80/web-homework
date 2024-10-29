package dao;

import entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.MetaDataAccessException;
import util.JdbcUtil;
import util.Md5Util;

import java.util.zip.DataFormatException;

public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());

    public int insertUser(User user) {
        //编写SQL
        String sql = "insert into t_user(account,nickname,cipher,address) values(?,?,?,?)";
        //调用query方法
        return jdbcTemplate.update(sql, user.getAccount(),  user.getNickname(), Md5Util.crypt(user.getCipher()), user.getAddress());
    }

    @Override
//    public User findUser(User userDto) {
//        try {
//            //编写sql
//            String sql = "select * from t_user where account=? and cipher=?";
//            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), userDto.getAccount());
//
//        }catch (DataAccessException e){e.printStackTrace();return null;}
//    }

    public User findUser(User userDto) {
        try {
            // 编写SQL
            String sql = "select * from t_user where account=? and cipher=?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    userDto.getAccount(), Md5Util.crypt(userDto.getCipher())); // 这里传递了加密后的密码
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }



}