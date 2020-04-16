package _设计模式._工厂模式.pizza;

public class LDCheesePizza extends Pizza{
    @Override
    public void prepare() {
        // TODO Auto-generated method stub
        setName("伦敦的奶酪pizza");
        System.out.println(" 伦敦的奶酪pizza 准备原材料");
    }
}
