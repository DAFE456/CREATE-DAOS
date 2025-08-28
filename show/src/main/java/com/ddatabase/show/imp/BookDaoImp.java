package com.ddatabase.show.imp;

import com.ddatabase.show.dom.Book;
import org.springframework.jdbc.core.JdbcTemplate;

import static javax.management.Query.eq;

public class BookDaoImp implements BookDao {
    private final JdbcTemplate jdbcTemplate;
    public BookDaoImp(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books(Isbn, Title,author_id) VALUES (?, ?, ?)",
                book.getIsbn(),book.getTitle(),book.getAuthor_id()

        );
    }
}
