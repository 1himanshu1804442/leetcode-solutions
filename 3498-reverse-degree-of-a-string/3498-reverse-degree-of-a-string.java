class Solution {
    public int reverseDegree(String s) {
        int l=s.length();
        int indexalphabet[]=new int[256];
        int a=26;
        for(char ch='a';ch<='z';ch++){
            indexalphabet[ch]=a--;
        }
        int prod=1;
        int sum=0;
        for(int i=0;i<l;i++){
            char ch=s.charAt(i);
            prod=(indexalphabet[ch]*(i+1));
            sum+=prod;
        }
        return sum;

    }
}