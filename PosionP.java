import java.util.List;
import java.util.Stack;

public class PosionP {
     public static int poisonousPlants(List<Integer> p) {
        if (p == null || p.size() <= 1) return 0;
        
        int n = p.size();
        int maxDays = 0;
        // Stack will store pairs: {pesticide value, days it survived}
        Stack<int[]> stack = new Stack<>();
        
        // Process each plant from left to right
        for (int i = 0; i < n; i++) {
            int currentValue = p.get(i);
            int days = 0;
            
            // Check if current plant will die and calculate after how many days
            while (!stack.isEmpty() && currentValue <= stack.peek()[0]) {
                days = Math.max(days, stack.pop()[1]);
            }
            
            // If stack is empty, plant survives forever
            // Otherwise, it dies after days+1
            if (!stack.isEmpty()) {
                days++;
                maxDays = Math.max(maxDays, days);
            } else {
                days = 0;
            }
            
            stack.push(new int[]{currentValue, days});
        }
        
        return maxDays;
    }
}
