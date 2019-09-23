package me.iampeach.bookspringboot.dao;

import me.iampeach.bookspringboot.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class BookRowMapper implements RowMapper<Book> {
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("price"));
    }
}
