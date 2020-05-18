package _单例;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/18 14:52
 */
public class Main {

}
class Singleton {

    private Singleton(){}


    private static class Handler{
        static Singleton INSTANCE = new Singleton();
    }

    public Singleton getInstance() {
        return Handler.INSTANCE;
    }

}