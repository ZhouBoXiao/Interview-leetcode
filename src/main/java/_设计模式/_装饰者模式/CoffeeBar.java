package _设计模式._装饰者模式;

public class CoffeeBar {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 装饰者模式下的订单：2份巧克力+一份牛奶的LongBlack

        // 1. 点一份 LongBlack
        Drink order = new LongBlack();
        System.out.println("费用1=" + order.cost());
        System.out.println("描述=" + order.getDes());

        // 2. order 加入一份牛奶
        order = new Milk(order);

        System.out.println("order 加入一份牛奶 费用 =" + order.cost());
        System.out.println("order 加入一份牛奶 描述 = " + order.getDes());

        // 3. order 加入一份巧克力

        order = new Chocolate(order);

        System.out.println("order 加入一份牛奶 加入一份巧克力  费用 =" + order.cost());
        System.out.println("order 加入一份牛奶 加入一份巧克力 描述 = " + order.getDes());

        // 3. order 加入一份巧克力

        order = new Chocolate(order);

        System.out.println("order 加入一份牛奶 加入2份巧克力   费用 =" + order.cost());
        System.out.println("order 加入一份牛奶 加入2份巧克力 描述 = " + order.getDes());

        System.out.println("===========================");

        Drink order2 = new DeCaf();

        System.out.println("order2 无因咖啡  费用 =" + order2.cost());
        System.out.println("order2 无因咖啡 描述 = " + order2.getDes());

        order2 = new Milk(order2);

        System.out.println("order2 无因咖啡 加入一份牛奶  费用 =" + order2.cost());
        System.out.println("order2 无因咖啡 加入一份牛奶 描述 = " + order2.getDes());


    }
}
class Coffee  extends Drink {
    @Override
    public float cost() {
        // TODO Auto-generated method stub
        return super.getPrice();
    }
}

class DeCaf extends Coffee {
    public DeCaf() {
        setDes(" ????? ");
        setPrice(1.0f);
    }
}
class Espresso extends Coffee {

    public Espresso() {
        setDes(" 意大利咖啡 ");
        setPrice(6.0f);
    }
}
class LongBlack extends Coffee {

    public LongBlack() {
        setDes(" longblack ");
        setPrice(5.0f);
    }
}
class ShortBlack extends Coffee{

    public ShortBlack() {
        setDes(" shortblack ");
        setPrice(4.0f);
    }
}
//具体的Decorator， 这里就是调味品
class Chocolate extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        setDes(" 巧克力 ");
        setPrice(3.0f); // 调味品 的价格
    }
}

class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        // TODO Auto-generated constructor stub
        setDes(" 牛奶 ");
        setPrice(2.0f);
    }
}

class Soy extends Decorator{

    public Soy(Drink obj) {
        super(obj);
        // TODO Auto-generated constructor stub
        setDes(" 豆浆  ");
        setPrice(1.5f);
    }

}
