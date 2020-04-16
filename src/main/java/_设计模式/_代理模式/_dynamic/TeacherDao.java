package _设计模式._代理模式._dynamic;


public class TeacherDao implements ITeacherDao {

    @Override
    public void teach() {
        // TODO Auto-generated method stub
        System.out.println(" 老师授课中.... ");
    }

    @Override
    public void sayHello(String name) {
        // TODO Auto-generated method stub
        System.out.println("hello " + name);
    }

}
