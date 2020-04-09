package other.result;

import lombok.Data;

@Data
public class ResponseBean extends BasePage {

    private Integer code;

    private String msg;

    private Object data;

    public ResponseBean(){
    }

    public static ResponseBean success(Object data){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(0);
        responseBean.setData(data);
        responseBean.setMsg("操作成功");
        return responseBean;
    }

    public static ResponseBean failure() {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(0);
        responseBean.setMsg("操作失败");
        return responseBean;
    }



}
