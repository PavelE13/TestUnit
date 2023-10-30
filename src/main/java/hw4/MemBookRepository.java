package hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemBookRepository implements BookRepository{
    private final Map <String, Book> books;

    public MemBookRepository() {
        this.books = new HashMap<>();
        books.put("1", new Book("1", "Book1", "Aut2"));
        books.put("2", new Book("2", "Book2", "Aut2"));
    }

    @Override
    public Book findById(String id) {
        return books.get(id);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
}
