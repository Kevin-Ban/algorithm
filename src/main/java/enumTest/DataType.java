package enumTest;

public enum DataType {

    /**
     *
     */
    Select("select", "查询数据"),

    Delete("delete", "删除数据");

    DataType(String type, String msg){
        this.type = type;
        this.msg = msg;
    }

    private String  type;

    private String msg;

    public String getType(){
        return this.type;
    }

    public String getMsg(){
        return this.msg;
    }

}
