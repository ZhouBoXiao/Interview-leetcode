package _设计模式._单例模式;

 //使用枚举，可以实现单例, 推荐
public enum Singleton {
    INSTANCE; //属性
    public Singleton getInstance() {
        return Singleton.INSTANCE;
    }
}