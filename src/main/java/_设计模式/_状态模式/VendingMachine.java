package _设计模式._状态模式;


import java.util.Random;

interface State{
    /**
     * 放钱
     */
    public void insertMoney();
    /**
     * 退钱
     */
    public void backMoney();
    /**
     * 转动曲柄
     */
    public void turnCrank();
    /**
     * 出商品
     */
    public void dispense();
}

class NoMoneyState implements State {

    private VendingMachine machine;

    public NoMoneyState(VendingMachine machine)
    {
        this.machine = machine;

    }

    @Override
    public void insertMoney()
    {
        System.out.println("投币成功");
        machine.setState(machine.getHasMoneyState());
    }

    @Override
    public void backMoney()
    {
        System.out.println("您未投币，想退钱？...");
    }

    @Override
    public void turnCrank()
    {
        System.out.println("您未投币，想拿东西么？...");
    }

    @Override
    public void dispense()
    {
        throw new IllegalStateException("非法状态！");
    }

}

class HasMoneyState implements State
{

    private VendingMachine machine;
    private Random random = new Random();

    public HasMoneyState(VendingMachine machine)
    {
        this.machine = machine;
    }

    @Override
    public void insertMoney()
    {
        System.out.println("您已经投过币了，无需再投....");
    }

    @Override
    public void backMoney()
    {
        System.out.println("退币成功");

        machine.setState(machine.getNoMoneyState());
    }

    @Override
    public void turnCrank()
    {
        System.out.println("你转动了手柄");
        int winner = random.nextInt(10);
        if (winner == 0 && machine.getCount() > 1)
        {
            machine.setState(machine.getWinnerState());
        } else
        {
            machine.setState(machine.getSoldState());
        }
    }

    @Override
    public void dispense()
    {
        throw new IllegalStateException("非法状态！");
    }

}
class SoldOutState implements State
{

    private VendingMachine machine;

    public SoldOutState(VendingMachine machine)
    {
        this.machine = machine;
    }

    @Override
    public void insertMoney()
    {
        System.out.println("投币失败，商品已售罄");
    }

    @Override
    public void backMoney()
    {
        System.out.println("您未投币，想退钱么？...");
    }

    @Override
    public void turnCrank()
    {
        System.out.println("商品售罄，转动手柄也木有用");
    }

    @Override
    public void dispense()
    {
        throw new IllegalStateException("非法状态！");
    }

}
class SoldState implements State {

    private VendingMachine machine;

    public SoldState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        System.out.println("正在出货，请勿投币");
    }

    @Override
    public void backMoney() {
        System.out.println("正在出货，没有可退的钱");
    }

    @Override
    public void turnCrank() {
        System.out.println("正在出货，请勿重复转动手柄");
    }

    @Override
    public void dispense() {
        machine.dispense();
        if (machine.getCount() > 0) {
            machine.setState(machine.getNoMoneyState());
        } else
        {
            System.out.println("商品已经售罄");
            machine.setState(machine.getSoldOutState());
        }
    }
}
class WinnerState implements State {

    private VendingMachine machineBetter;

    public WinnerState(VendingMachine machineBetter) {
        this.machineBetter = machineBetter;
    }

    @Override
    public void insertMoney() {
        throw new IllegalStateException("非法操作!");
    }

    @Override
    public void backMoney() {
        throw new IllegalStateException("非法操作!");
    }

    @Override
    public void turnCrank() {
        throw new IllegalStateException("非法操作!");
    }

    @Override
    public void dispense() {
        System.out.println("WinnerState---您中奖了, 恭喜您,将获得2件商品!");
        machineBetter.dispense();
        if (machineBetter.getCount() == 0) {
            System.out.println("WinnerState---商品已售罄,中奖失效...");
            machineBetter.setState(machineBetter.getSoldOutState());
        } else {
            machineBetter.dispense();
            if (machineBetter.getCount() > 0) {
                machineBetter.setState(machineBetter.getNoMoneyState());
            } else {
                machineBetter.setState(machineBetter.getSoldOutState());
            }
        }
    }
}
public class VendingMachine{
    private int count = 0;
    private State currentState;
    private State noMoneyState;
    private State hasMoneyState;
    private State soldState;
    private State soldOutState;
    private State winnerState;

    public VendingMachine(int count) {
        noMoneyState = new NoMoneyState(this);
        hasMoneyState = new HasMoneyState(this);
        soldOutState = new SoldOutState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        if (count > 0) {
            this.count = count;
            currentState = noMoneyState;
        }
    }

    /**
     * 放钱
     */
    public void insertMoney() {
        currentState.insertMoney();
    }

    /**
     * 退钱
     */
    public void backMoney() {
        currentState.backMoney();
    }

    /**
     * 转动曲柄
     */
    public void turnCrank() {
        currentState.turnCrank();
        if (currentState == soldState || currentState == winnerState) {
            currentState.dispense();//两种情况会出货
        }
    }

    /**
     * 出商品
     */
    public void dispense() {
        System.out.println("VendingMachineBetter-发出一件商品");
        if (count > 0) {
            count--;
        }
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getNoMoneyState() {
        return noMoneyState;
    }

    public State getHasMoneyState() {
        return hasMoneyState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public int getCount() {
        return count;
    }
}
