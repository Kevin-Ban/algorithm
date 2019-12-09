package designPattern.builder;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Book {

    private String name;

    private String author;

    private Integer pages;
}
