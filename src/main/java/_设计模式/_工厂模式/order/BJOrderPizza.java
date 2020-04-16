package _设计模式._工厂模式.order;

import _设计模式._工厂模式.pizza.BJCheesePizza;
import _设计模式._工厂模式.pizza.BJPepperPizza;
import _设计模式._工厂模式.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {


    @Override
    Pizza createPizza(String orderType) {

        Pizza pizza = null;
        if(orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        // TODO Auto-generated method stub
        return pizza;
    }

}
