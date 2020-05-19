package _sortByNumber._600以上._853;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * 车队
 */
class Car {
    int mPosition;
    double mTime;
    public Car(int position, double time) {
        this.mPosition = position;
        this.mTime = time;
    }

    @Override
    public String toString() {
        return "mPosition " + mPosition + " mTime " + mTime;
    }
}

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        if (position == null || position.length == 0 || speed == null || speed.length ==0) {
            return 0;
        }
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            Car car = new Car(position[i], 1.0 * (target - position[i])/speed[i]);
            list.add(car);
        }
        Collections.sort(list, (a, b) -> {
            return b.mPosition - a.mPosition;
        });
        int num = 1;
        double sign = list.get(0).mTime;
        for (Car car : list) {
            if (car.mTime > sign) {
                sign = car.mTime;
                num++;
            }
        }
        return num;
    }
}
