# stuff





Find Strings:
public static List<String> findStrings(List<String> w, List<Integer> queries) {
        // Use TreeSet to maintain unique substrings in sorted order
        TreeSet<String> set = new TreeSet<>();
        // For each string in input
        for (String s : w) {
            // Skip if string is null or empty
            if (s == null || s.isEmpty()) continue;
            // Generate all possible substrings
            int len = s.length();
            for (int i = 0; i < len; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < len; j++) {
                    sb.append(s.charAt(j));
                    set.add(sb.toString());
                }
            }
        }
        // Convert set to list for indexed access
        List<String> sortedSubstrings = new ArrayList<>(set);
        List<String> results = new ArrayList<>();
        // Process each query
        for (Integer k : queries) {
            // k is 1-indexed, so we subtract 1 for 0-based list access
            if (k == null || k <= 0 || k > sortedSubstrings.size()) {
                results.add("INVALID");
            } else {
                results.add(sortedSubstrings.get(k - 1));
            }
        }
        return results;
    }
----------------------
P-Plants:
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
