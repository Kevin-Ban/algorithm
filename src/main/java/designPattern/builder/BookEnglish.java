package designPattern.builder;

import lombok.Data;

@Data
public class BookEnglish implements BookBuilder {

    private Book book;

    public BookEnglish() {
        book = new Book();
    }

    @Override
    public void setAuthor() {
        this.book.setAuthor("English Teacher");
    }

    @Override
    public void setName() {
        this.book.setName("English Book");
    }

    @Override
    public void setPages() {
        this.book.setPages(10);
    }

    @Override
    public Book fetchBook() {
        return this.book;
    }
}
