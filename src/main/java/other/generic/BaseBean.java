package other.generic;

import lombok.Data;

import java.util.List;

@Data
public class BaseBean<T> {

    private List<T> list;

    private Integer total;
}
