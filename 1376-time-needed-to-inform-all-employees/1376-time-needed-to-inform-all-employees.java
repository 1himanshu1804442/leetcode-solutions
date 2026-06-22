class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] mg=new ArrayList[n];
        for(int i=0;i<n;i++){
            mg[i]=new ArrayList<>();

        }
        for(int i=0;i<n;i++){
            int currmanager=manager[i];
            if(currmanager!=-1){
                mg[currmanager].add(i);
            }
        }
        return time(informTime,mg,headID);

        
    }
    public int time(int informtime[],List<Integer>[] mg,int currentmanager){
        int maxtime=0;
        for(int subordinate:mg[currentmanager]){
            maxtime=Math.max(maxtime,time(informtime,mg,subordinate));
        }
        return informtime[currentmanager]+maxtime;
    }
}