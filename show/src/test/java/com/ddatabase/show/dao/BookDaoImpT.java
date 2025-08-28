package com.ddatabase.show.dao;

import com.ddatabase.show.dom.Book;
import com.ddatabase.show.imp.BookDao;
import com.ddatabase.show.imp.BookDaoImp;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImpT {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImp updateBookDao;

    @Test
    void updateBook() {
        Book book = Book.builder()
                .isbn("dafe")
                .title("money 1st")
                .author_id(22L)
                .build();
    updateBookDao.create(book);

    verify(jdbcTemplate).update(
            eq("INSERT INTO books(Isbn, Title,author_id) VALUES (?, ?, ?)"),
            eq("dafe"),
            eq("money 1st"),
            eq(22L)
    );
    }

}
