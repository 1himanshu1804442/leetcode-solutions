
import java.util.Arrays;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int[][] allRestrictions = new int[restrictions.length + 1][2];
        allRestrictions[0] = new int[]{1, 0};
        for (int i = 0; i < restrictions.length; i++) {
            allRestrictions[i + 1] = restrictions[i];
        }
        
        Arrays.sort(allRestrictions, (a, b) -> Integer.compare(a[0], b[0]));
        
        int m = allRestrictions.length;
        
        for (int i = 1; i < m; i++) {
            int maxPossible = allRestrictions[i - 1][1] + (allRestrictions[i][0] - allRestrictions[i - 1][0]);
            allRestrictions[i][1] = Math.min(allRestrictions[i][1], maxPossible);
        }
        
        for (int i = m - 2; i >= 0; i--) {
            int maxPossible = allRestrictions[i + 1][1] + (allRestrictions[i + 1][0] - allRestrictions[i][0]);
            allRestrictions[i][1] = Math.min(allRestrictions[i][1], maxPossible);
        }
        
        int maxHeight = 0;
        for (int i = 0; i < m - 1; i++) {
            int id1 = allRestrictions[i][0];
            int h1 = allRestrictions[i][1];
            int id2 = allRestrictions[i + 1][0];
            int h2 = allRestrictions[i + 1][1];
            
            int peak = (h1 + h2 + (id2 - id1)) / 2;
            maxHeight = Math.max(maxHeight, peak);
        }
        
        int lastId = allRestrictions[m - 1][0];
        int lastH = allRestrictions[m - 1][1];
        maxHeight = Math.max(maxHeight, lastH + (n - lastId));
        
        return maxHeight;
    }
}