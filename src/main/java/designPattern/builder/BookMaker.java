package designPattern.builder;

import lombok.Data;

@Data
public class BookMaker {

    private BookBuilder bookBuilder;

    public BookMaker(BookBuilder bookBuilder) {
        this.bookBuilder = bookBuilder;
    }

    public void createBook() {
        bookBuilder.setAuthor();
        bookBuilder.setName();
        bookBuilder.setPages();
    }

    public Book fetchBook() {
        return bookBuilder.fetchBook();
    }
}
