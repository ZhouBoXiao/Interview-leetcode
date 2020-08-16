package _题型分类._拒绝抽样._470_用Rand7实现Rand10;

/**
 * 用 Rand7() 实现 Rand10()
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 *
 * 不要使用系统的 Math.random() 方法。
 *
 */
class SolBase{
    int rand7() {
        return 0;
    }
    int rand3() {
        return 0;
    }
}

public class Solution extends SolBase {
    public int rand10() {
        while (true) {
            int num = rand7() + (rand7() - 1) * 7;
            if (num <= 40) {
                return 1 + (num - 1)% 10;
            }
            num = (num - 40 - 1) * 7 + rand7();
            if (num <= 60) {
                return 1 + (num - 1) % 10;
            }
            num = (num - 60 - 1) * 7 + rand7();
            if (num <= 20) {
                return 1 +(num - 1) % 10;
            }
        }
    }

}

