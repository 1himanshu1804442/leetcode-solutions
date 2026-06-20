class Solution {
    public int minLights(int[] lights) {
        int n=lights.length;
        int diff[]=new int[n+1];
        for(int i=0;i<n;i++){
            if(lights[i]>0){
                int left=Math.max(0,i-lights[i]);
                int right=Math.min(n-1,i+lights[i]);
                diff[left]++;
                diff[right+1]--;
            } 
        }
        boolean islit[]=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
             count+=diff[i];
            if(count>0){
                islit[i]=true;
            }
            
        }
        int additionalbulb=0;
        for(int i=0;i<n;i++){
            if(!islit[i]){
                additionalbulb++;
                i+=2;
            }
            
            
        }
        return additionalbulb;
        
        
    }
}