package designPattern.singleton;

public enum SingletonEnum {
    /**
     *
     */
    INSTANCE;

    private SingletonEnumTest singleton;

    SingletonEnum(){
        System.out.println("枚举初始化");
        this.singleton = new SingletonEnumTest();
    }

    public SingletonEnumTest getInstance(){
        return this.singleton;
    }

}
