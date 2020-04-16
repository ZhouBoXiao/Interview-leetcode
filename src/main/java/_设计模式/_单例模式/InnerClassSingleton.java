package _设计模式._单例模式;


public class InnerClassSingleton {
    /**
     * 基于类初始化
     */
    private static class InstanceHolder {
        public static InnerClassSingleton instance = new InnerClassSingleton();
    }
    public static InnerClassSingleton getInstance() {
        return InstanceHolder.instance;
    }
}
