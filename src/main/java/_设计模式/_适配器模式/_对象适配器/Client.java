package _设计模式._适配器模式._对象适配器;

public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(" === 对象适配器模式 ====");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }

}