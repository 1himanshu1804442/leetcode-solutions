import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Step 1: Create a map to store reservations by row
        Map<Integer, Integer> rowToMask = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            // Use bitwise OR to add the seat to that row's mask
            rowToMask.put(row, rowToMask.getOrDefault(row, 0) | (1 << col));
        }
        
        // Step 2: Calculate groups for completely empty rows
        // Every empty row can hold exactly 2 families
        int maxGroups = (n - rowToMask.size()) * 2;
        
        // Step 3: Bitmask values for the three valid 4-seat blocks
        int leftBlock = 60;   // Seats 2,3,4,5
        int rightBlock = 960; // Seats 6,7,8,9
        int middleBlock = 240;// Seats 4,5,6,7
        
        // Step 4: Check the rows that have reservations
        for (int mask : rowToMask.values()) {
            // A block is free if (mask AND block) == 0
            boolean leftFree = (mask & leftBlock) == 0;
            boolean rightFree = (mask & rightBlock) == 0;
            boolean middleFree = (mask & middleBlock) == 0;
            
            // If both sides are free, we fit 2 groups
            if (leftFree && rightFree) {
                maxGroups += 2;
            } 
            // Otherwise, if any single block is free, we fit 1 group
            else if (leftFree || rightFree || middleFree) {
                maxGroups += 1;
            }
        }
        
        return maxGroups;
    }
}