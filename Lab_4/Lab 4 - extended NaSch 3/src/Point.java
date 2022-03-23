import java.util.Arrays;
import java.util.List;

public class Point {
    public int type;
    public Point next;
    public Point prev;
    public boolean moved;
    public int velocity;
    public static Integer[] types = {0, 1, 2, 3, 5};
    public int max_vel;
    public static List carTypes = Arrays.asList(1, 2, 3);

//    public Point() {
//        velocity = 1;
//        max_vel = 0;
//    }

    public void move() {
        Point nextPoint = next;
        for (int nextPos = 1; nextPos < velocity; nextPos++) {
            nextPoint = nextPoint.next;
        }

        if (carTypes.contains(type) && nextPoint.type == 0 && !moved){
            nextPoint.type = type;
            nextPoint.moved = true;
            nextPoint.velocity = velocity;
            nextPoint.max_vel = 1 + 2 * type;

            type = 0;
            moved = true;
            velocity = 0;
            max_vel = 0;
        }
    }

    public void speedUp() {
        if (velocity < max_vel)
            velocity++;
    }

    public void slowDown() {
    }

    public void random() {
        if (velocity >= 1){
            if (Math.random() < 0.3){
                velocity -= 1;
            }
        }
    }

    public void clicked() {
        this.type = 0;
    }


    public void clear() {
        type = 0;
    }

    public void overtake(){
        Point prevCar = prev;
        int distance1 = 1;
        for (; distance1 <= max_vel; distance1++) {
            if (carTypes.contains(prevCar.type)){
                if (distance1 <= velocity){
                    velocity = distance1 + 1;
                }
                break;
            }
            prevCar = prevCar.prev;
        }
        Point prevCar2 = prev;
        int distance2 = 1;
        for (; distance2 <= max_vel; distance2++) {
            if (carTypes.contains(prevCar2.type)){
                if (distance2 <= velocity){
                    velocity = distance2 + 1;
                }
                break;
            }
            prevCar2 = prevCar2.prev;
        }
        Point nextCar = next;
        int distance3 = 1;
        for (; distance3 <= max_vel; distance3++) {
            if (carTypes.contains(nextCar.type)){
                if (distance3 <= velocity){
                    velocity = distance3 - 1;
                }
                break;
            }
            nextCar = nextCar.next;
        }
        if ((velocity < max_vel) && (distance1 >= max_vel) && (distance2 >= max_vel) && (distance3 >= velocity)){

        }
    }


}

