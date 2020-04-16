package _设计模式._工厂模式.order;

import _设计模式._工厂模式.pizza.LDCheesePizza;
import _设计模式._工厂模式.pizza.LDPepperPizza;
import _设计模式._工厂模式.pizza.Pizza;

public class LDOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String orderType) {

        Pizza pizza = null;
        if(orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        // TODO Auto-generated method stub
        return pizza;
    }

}
