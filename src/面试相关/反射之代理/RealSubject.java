package 面试相关.反射之代理;

public class RealSubject implements Subject {

    @Override

    public void Request() {
        System.out.println("RealSubject");

    }

}