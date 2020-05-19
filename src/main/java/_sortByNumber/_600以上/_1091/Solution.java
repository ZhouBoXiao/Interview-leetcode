package _sortByNumber._600以上._1091;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    int n;
    private class Node implements Comparable<Node> {
        int x;
        int y;
        int f;
        Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            int distance = Math.max(n - 1 - x, n - 1 - y);
            this.f = distance + step;
        }

        @Override
        public int compareTo(Node o) {
            return this.f - o.f;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (!(obj instanceof Node)) return false;
            Node node = (Node) obj;
            return x == node.x &&  y == node.y;
        }

        @Override
        public int hashCode() {
            return x*n + y;
        }
    }


    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n == 1) return 1;
        int[][] dir = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                {-1, 1}, {-1, -1}, {1, -1}, {1, 1}
        };
        Node start = new Node(0, 0, grid[0][0] = 1);
        Queue<Node> queue = new PriorityQueue<>();

        queue.offer(start);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int step = grid[node.x][node.y];
            for (int[] d : dir) {
                int x = d[0] + node.x;
                int y = d[1] + node.y;
                if (x == n-1 && y == n-1) return step+1;
                if (x < 0 || x >= n || y < 0 || y >= n) continue;
                if (grid[x][y] != 0 && grid[x][y] <= step + 1) continue;
                Node next = new Node(x, y, grid[x][y] = step+1);
                queue.offer(next);
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        BigInteger a = new BigInteger("1");
        BigDecimal e = new BigDecimal("1.2");
    }
}
class Com implements Comparator<Person>{//该接口强制让集合具有比较性
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getAge()>o2.getAge()){
            return 1;
        }else if(o1.getAge()<o2.getAge()){
            return -1;
        }else{
            return o1.getName().compareTo(o2.getName());
        }
    }
}
class Person{
    private String name;
    private int age;
    public Person(String name,int age) {
        this.name = name;
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name +  ", age=" + age + "]";
    }
}