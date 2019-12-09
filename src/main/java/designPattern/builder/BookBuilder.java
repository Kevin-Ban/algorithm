package designPattern.builder;

public interface BookBuilder {

    void setAuthor();

    void setName();

    void setPages();

    Book fetchBook();
}
