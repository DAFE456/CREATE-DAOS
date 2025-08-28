package com.ddatabase.show.imp;


import com.ddatabase.show.dom.Author;
import org.springframework.jdbc.core.JdbcTemplate;

public class AuthorDaoImp implements AuthorDao {
    private final JdbcTemplate jdbcTemplate;
    public AuthorDaoImp(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update(
                "INSERT INTO authors(id, name,age) VALUES (?, ?, ?)",
                author.getId(),author.getName(),author.getAge()

        );
    }
}
