package _设计模式._策略模式;

public class Test {
    public static void main(String[] args) {
        Role roleA = new RoleA("A");

        roleA.setAttackBehavior(new AttackJY())//
                .setDefendBehavior(new DefendTBS())//
                .setDisplayBehavior(new DisplayYZ())//
                .setRunBehavior(new RunJCTQ());
        System.out.println(roleA.name + ":");
        roleA.run();
        roleA.attack();
        roleA.defend();
        roleA.display();
    }
}
