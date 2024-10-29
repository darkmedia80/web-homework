package dao;

import entity.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtil;

import java.sql.Connection;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private final JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());

    @Override
    public List<Book> selectAll() {
        String sql = "select * from t_book";
        return template.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
    }

    @Override
    public Book getBookById(int id) {
            String sql = "select * from t_book where id = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(Book.class),id);
    }
}
