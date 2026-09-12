class Solution {
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        int digitcount[]=new int[10];
        for(int digit:digits){
            digitcount[digit]++;

        }
        int validcount=0;
        for(int i=100;i<=998;i+=2){
            int hundred=i/100;
            int tens=(i/10)%10;
            int unit=i%10;
            digitcount[hundred]--;
            digitcount[tens]--;
            digitcount[unit]--;
            if(digitcount[hundred]>=0&&digitcount[tens]>=0&&digitcount[unit]>=0){
                validcount++;
            }
             digitcount[hundred]
             ++;
            digitcount[tens]++;
            digitcount[unit]++;

        }
        return validcount;
        

        
    }
}