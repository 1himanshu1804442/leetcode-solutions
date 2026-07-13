class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int l1=g.length;
        int l2=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int j1=0;
        int j2=0;
        int count=0;
        while(j1!=l1&&j2!=l2){
            if(s[j2]>=g[j1]){
                j2++;
                j1++;
                count++;
            }
            else{
                j2++;
            }
        }
        return count;

    
        
        
    }
}