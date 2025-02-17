public class FindStrings {
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
}
