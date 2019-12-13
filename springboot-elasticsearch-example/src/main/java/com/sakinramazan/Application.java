package com.sakinramazan;

import com.sakinramazan.book.model.Book;
import com.sakinramazan.book.service.BookService;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.util.Map;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ElasticsearchOperations es;

    @Autowired
    private BookService bookService;

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        printElasticSearchInfo();

        // creating test entities
        bookService.save(new Book("1", "Sample title 1", "Author 1", "23-FEB-2017"));
        bookService.save(new Book("2", "Sample title 2", "Author 2", "13-MAR-2017"));
        bookService.save(new Book("3", "Sample title 3", "Author 3", "21-MAR-2017"));

        //fuzzey search
        Page<Book> books = bookService.findByAuthor("AuthorX", new PageRequest(0, 10));

        //List<Book> books = bookService.findByTitle("Elasticsearch Basics");

        books.forEach(x -> System.out.println(x));


    }

    //useful for debug
    private void printElasticSearchInfo() {

        System.out.println("############################# Sample usage ElasticSearch #############################");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        asMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        System.out.println("################################ End of ElasticSearch #################################");
    }

}