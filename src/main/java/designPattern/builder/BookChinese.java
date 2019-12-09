package designPattern.builder;

import lombok.Data;

/**
 * @author BDX
 */
@Data
public class BookChinese implements BookBuilder {

    private Book book;

    public BookChinese() {
        this.book = new Book();
    }

    @Override
    public void setAuthor() {
        this.book.setAuthor("Chinese Teacher");
    }

    @Override
    public void setName() {
        this.book.setName("Chinese Book");
    }

    @Override
    public void setPages() {
        this.book.setPages(100);
    }

    @Override
    public Book fetchBook() {
        return this.book;
    }
}
