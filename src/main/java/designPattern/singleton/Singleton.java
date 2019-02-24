package designPattern.singleton;

public class Singleton {

    // region 双重锁机制

    private static Singleton instance;

    private Singleton(){
    }

    public Singleton getInstance(){
        if(instance == null){
            synchronized (this){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    // endregion

    // region 在程序启动就生成单例
    private static Singleton singleton = new Singleton();

    public static Singleton getSingleton1(){
        return singleton;
    }
    // endregion
}
