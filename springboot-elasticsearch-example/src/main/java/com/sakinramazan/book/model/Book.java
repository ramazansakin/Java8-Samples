package com.sakinramazan.book.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

// defining ES index name
@Builder
@Getter
@Setter
@ToString
@Document(indexName = "book-es", type = "books")
public class Book {

    @Id
    private String id;

    private String title;

    private String author;

    public Book() {
    }

    private Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}
