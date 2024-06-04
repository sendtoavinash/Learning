package com.avi.dsa;

import java.util.*;
import java.util.stream.Collectors;

class VisitCounter {
    public Map<Long, Long> count(List<Map<String, UserStats>> visits) {
        if (visits == null) {
            return Collections.emptyMap();
        }

        return visits.stream()
                .filter(Objects::nonNull) // Filter out null maps
                .flatMap(map -> map.entrySet().stream())
                .filter(entry -> {
                    try {
                        Long.parseLong(entry.getKey());
                        return true;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                .filter(entry -> entry.getValue() != null) // Filter out entries with null UserStats
                .filter(entry -> entry.getValue().getVisitCount().isPresent()) // Filter out entries with empty Optional visitCount
                .collect(Collectors.toMap(
                        entry -> Long.parseLong(entry.getKey()), // Convert key to Long
                        entry -> entry.getValue().getVisitCount().get(), // Extract visitCount
                        Long::sum // Merge function to sum visits per user
                ));
    }
}

class UserStats {
    private Optional<Long> visitCount;

    public UserStats(Long visitCount) {
        this.visitCount = Optional.ofNullable(visitCount);
    }

    public Optional<Long> getVisitCount() {
        return visitCount;
    }
}


public class visitorTest {

    public static void main(String[] args) {
        {
            VisitCounter vc = new VisitCounter();

            // Test Case 1: Basic case with valid inputs
            List<Map<String, UserStats>> visits1 = new ArrayList<>();
            Map<String, UserStats> map1 = new HashMap<>();
            map1.put("1", new UserStats(10L));
            map1.put("2", new UserStats(20L));
            visits1.add(map1);
            Map<String, UserStats> map2 = new HashMap<>();
            map2.put("1", new UserStats(5L));
            map2.put("3", new UserStats(15L));
            visits1.add(map2);

            System.out.println(vc.count(visits1)); // Expected: {1=15, 2=20, 3=15}

            // Test Case 2: Handling null maps
            List<Map<String, UserStats>> visits2 = Arrays.asList(null, new HashMap<>());
            System.out.println(vc.count(visits2)); // Expected: {}

            // Test Case 3: Handling null UserStats and invalid keys
            List<Map<String, UserStats>> visits3 = new ArrayList<>();
            Map<String, UserStats> map3 = new HashMap<>();
            map3.put("1", null);
            map3.put("abc", new UserStats(10L));
            map3.put("2", new UserStats(null));
            visits3.add(map3);

            System.out.println(vc.count(visits3)); // Expected: {}

            // Test Case 4: Handling empty visitCount (Optional.empty)
            List<Map<String, UserStats>> visits4 = new ArrayList<>();
            Map<String, UserStats> map4 = new HashMap<>();
            map4.put("1", new UserStats(null));
            visits4.add(map4);

            System.out.println(vc.count(visits4)); // Expected: {}

            // Test Case 5: Mixed valid and invalid inputs
            List<Map<String, UserStats>> visits5 = new ArrayList<>();
            Map<String, UserStats> map5 = new HashMap<>();
            map5.put("1", new UserStats(10L));
            map5.put("invalidKey", new UserStats(20L));
            map5.put("2", null);
            visits5.add(map5);
            Map<String, UserStats> map6 = new HashMap<>();
            map6.put("1", new UserStats(15L));
            map6.put("2", new UserStats(25L));
            visits5.add(map6);

            System.out.println(vc.count(visits5)); // Expected: {1=25, 2=25}

            // Test Case 6: Null input list
            System.out.println(vc.count(null)); // Expected: {}

            // Test Case 7: Empty input list
            System.out.println(vc.count(new ArrayList<>())); // Expected: {}
        }
    }
}
