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
        this.book.setAuthor("中文教师");
    }

    @Override
    public void setName() {
        this.book.setName("中文书");
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
