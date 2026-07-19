class Solution {
    public String removeDuplicateLetters(String s) {
        int n=s.length();
        boolean seen[]=new boolean[26];
        StringBuilder stack =new StringBuilder();
        int lastseen[]=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            lastseen[ch-'a']=i;
        }
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(seen[c-'a']){
                continue;
            }
            while(!stack.isEmpty()&&stack.charAt(stack.length()-1)>c&&lastseen[stack.charAt(stack.length()-1)-'a']>i){
                char popped=stack.charAt(stack.length()-1);
                stack.deleteCharAt(stack.length()-1);
                seen[popped-'a']=false;

            }
            stack.append(c);
            seen[c-'a']=true;
        }
        return stack.toString();
        
    }
}