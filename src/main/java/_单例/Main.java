package _单例;



/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/18 14:52
 */


public class Main {
    public static void main(String[] args) {
        System.out.println(EnumSingleton.INSTANCE.getObj());
        System.out.println(EnumSingleton.INSTANCE.getObj());

    }
}
class Singleton {

    private Singleton(){}

    private static class Handler{
        public static Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() {
        return Handler.INSTANCE;
    }
}
/**
 * 使用枚举实现单例。
 */
enum EnumSingleton {

    INSTANCE; // 唯一的实例对象
    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
    // 单例对象的属性对象
    private Object obj = new Object();
    public Object getObj() {
        return obj;
    }
}

enum Singleton1{
    INSTANCE;
    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}
