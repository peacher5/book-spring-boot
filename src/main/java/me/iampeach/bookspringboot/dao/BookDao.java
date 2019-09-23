package me.iampeach.bookspringboot.dao;

import me.iampeach.bookspringboot.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Book book) {
        String query = "INSERT INTO books (id, name, price) VALUES (?, ?, ?);";
        Object[] args = new Object[]{book.getId(), book.getName(), book.getPrice()};
        jdbcTemplate.update(query, args);
    }

    public void update(int id, Book book) {
        String query = "UPDATE books SET id = ?, name = ?, price = ? WHERE id = ?;";
        Object[] args = new Object[]{book.getId(), book.getName(), book.getPrice(), id};
        jdbcTemplate.update(query, args);
    }

    public void deleteById(int id) {
        String query = "DELETE FROM books WHERE id = ?;";
        Object[] args = new Object[]{id};
        jdbcTemplate.update(query, args);
    }

    public Book findById(int id) {
        String query = "SELECT * FROM books WHERE id = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.queryForObject(query, args, new BookRowMapper());
    }

    public List<Book> findAll() {
        String query = "SELECT * FROM books";
        return jdbcTemplate.query(query, new BookRowMapper());
    }
}
