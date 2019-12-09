package designPattern.builder;

public class BuilderTest {

    public static void main(String[] args) {

        BookMaker bookMaker = new BookMaker(new BookChinese());
        bookMaker.createBook();
        System.out.println(bookMaker.fetchBook());

        bookMaker.setBookBuilder(new BookEnglish());
        bookMaker.createBook();
        System.out.println(bookMaker.fetchBook());
    }
}
