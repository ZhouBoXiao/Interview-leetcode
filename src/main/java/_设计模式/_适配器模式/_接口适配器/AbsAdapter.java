package _设计模式._适配器模式._接口适配器;

//在AbsAdapter 我们将 Interface4 的方法进行默认实现
public abstract class AbsAdapter implements Interface4 {

    //默认实现
    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }

    @Override
    public void m4() {

    }
}
interface Interface4 {
    void m1();
    void m2();
    void m3();
    void m4();
}
