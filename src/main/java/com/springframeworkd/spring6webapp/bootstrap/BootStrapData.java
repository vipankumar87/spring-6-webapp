package com.springframeworkd.spring6webapp.bootstrap;
import com.springframeworkd.spring6webapp.domain.Author;
import com.springframeworkd.spring6webapp.domain.Book;
import com.springframeworkd.spring6webapp.repositories.AuthorRepository;
import com.springframeworkd.spring6webapp.repositories.BookRepository;
import com.springframeworkd.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.springframeworkd.spring6webapp.domain.Publisher;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository,  PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        Author authorSaved = authorRepository.save(author);

        Book book = new Book();
        book.setTitle("PHP Development");
        book.setIsbn("PHPD1212");
        Book bookSaved = bookRepository.save(book);

        Book noEJB = new Book();
        noEJB.setTitle("NoEJB");
        noEJB.setIsbn("NOEJB12");
        Book noEJBBook = bookRepository.save(noEJB);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");
        Publisher publisherSaved = publisherRepository.save(publisher);

        bookSaved.setPublisher(publisherSaved);
        bookSaved.getAuthors().add(authorSaved);

        noEJBBook.setPublisher(publisherSaved);
        noEJBBook.getAuthors().add(authorSaved);

        authorSaved.getBooks().add(noEJB);
        authorSaved.getBooks().add(book);
        authorRepository.save(authorSaved);
        bookRepository.save(bookSaved);
        bookRepository.save(noEJBBook);



        publisherSaved.getBooks().add(bookSaved);
        publisherRepository.save(publisherSaved);
        System.out.println("In BootStrapData");
        System.out.println("Total Books: " + bookRepository.count());
        System.out.println("Total Authors: " + authorRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
