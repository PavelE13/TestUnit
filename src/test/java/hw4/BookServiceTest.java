package hw4;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

public class BookServiceTest {
        private BookRepository bookRepository;
        private BookService bookService;


        @Before
        public void setUp() {
            // создание заглушки для объекта bookRepository.
            bookRepository = mock(BookRepository.class);
            // создание объекта bookService с использованием заглушки bookRepository.
            bookService = new BookService(bookRepository);
        }

        @Test
        public void testFindBookById() {
            String id = "1";
            Book book = new Book(id, "Mest Djedaya", "Yamov");
            // определение поведения заглушки bookRepository при вызове метода findById.
            when(bookRepository.findById(id)).thenReturn(book);
            // вызов метода findBookById объекта bookService и сохранение результата.
            Book result = bookService.findBookById(id);
            // проверка ожидаемого значения (book) и фактического значения (result)
            assertEquals(book, result);
            // проверка, был ли вызван метод findById у заглушки bookRepository с параметром id один раз
            verify(bookRepository, times(1)).findById(id);
        }

        @Test
        public void testFindAllBook() {
            Book book1 = new Book("1", "Mest Djedaya", "Yamov");
            Book book2 = new Book("2", "Put voina", "Kolosov");
            // создание списка.
            List<Book> books = Arrays.asList(book1, book2);
            // определение поведения интерфейса bookRepository при вызове метода findAll.
            when(bookRepository.findAll()).thenReturn(books);
            // вызов метода findAllBooks объекта bookService и сохранение результата в переменную result.
            List<Book> result = bookService.findAllBooks();
            // проверка ожидаемого значения и фактического значения result с помощью метода assertEquals.
            assertEquals(books, result);
            // проверка, был ли вызван метод findAll у заглушки bookRepository один раз
            verify(bookRepository, times(1)).findAll();

        }
    }
