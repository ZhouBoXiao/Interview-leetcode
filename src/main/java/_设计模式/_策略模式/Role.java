package _设计模式._策略模式;

interface IAttackBehavior {
    void attack();
}
interface IDefendBehavior {
    void defend();
}
interface IDisplayBehavior {
    void display();
}
class DisplayYZ implements IDisplayBehavior {

    @Override
    public void display() {
        System.out.println("样子2");
    }
}
class AttackJY implements IAttackBehavior {

    @Override
    public void attack()
    {
        System.out.println("九阳神功！");
    }
}
class DefendTBS implements IDefendBehavior {

    @Override
    public void defend()
    {
        System.out.println("铁布衫");
    }

}
interface IRunBehavior {
    void run();
}

class RunJCTQ implements IRunBehavior
{

    @Override
    public void run()
    {
        System.out.println("金蝉脱壳");
    }

}



public abstract class Role {
    protected String name;

    protected IDefendBehavior defendBehavior;
    protected IDisplayBehavior displayBehavior;
    protected IRunBehavior runBehavior;
    protected IAttackBehavior attackBehavior;

    public Role setDefendBehavior(IDefendBehavior defendBehavior) {
        this.defendBehavior = defendBehavior;
        return this;
    }

    public Role setDisplayBehavior(IDisplayBehavior displayBehavior) {
        this.displayBehavior = displayBehavior;
        return this;
    }

    public Role setRunBehavior(IRunBehavior runBehavior) {
        this.runBehavior = runBehavior;
        return this;
    }

    public Role setAttackBehavior(IAttackBehavior attackBehavior) {
        this.attackBehavior = attackBehavior;
        return this;
    }

    protected void display() {
        displayBehavior.display();
    }

    protected void run() {
        runBehavior.run();
    }

    protected void attack() {
        attackBehavior.attack();
    }

    protected void defend() {
        defendBehavior.defend();
    }

}
class RoleA extends Role {

    public  RoleA(String name){
        this.name = name;
    }
}

