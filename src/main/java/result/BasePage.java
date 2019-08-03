package result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class BasePage {

    @JsonIgnore
    private Integer pageNo;

    @JsonIgnore
    private Integer pageSize;

    private List<?> list;

    private long total;
}
