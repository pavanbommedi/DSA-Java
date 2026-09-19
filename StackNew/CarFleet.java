import java.util.*;
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // Store [position, speed]
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort cars by position
        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<Double> stack = new Stack<>();

        // Process from closest to target to farthest
        for (int i = n - 1; i >= 0; i--) {

            int pos = cars[i][0];
            int spd = cars[i][1];

            // Time needed to reach target
            double time = (double)(target - pos) / spd;

            // If this car takes longer than the fleet ahead,
            // it cannot catch that fleet -> new fleet
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }

            // Otherwise:
            // time <= stack.peek()
            // This car catches the fleet ahead and becomes
            // part of the same fleet.
        }

        return stack.size();
    }
}
