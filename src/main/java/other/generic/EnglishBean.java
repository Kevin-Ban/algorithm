package other.generic;

import lombok.Data;

@Data
public class EnglishBean {

    private String param;

    public EnglishBean(String param){
        this.param = param;
    }

}
