class Solution {
    static class Pair{
        String name;
        int steps;
        public Pair(String name,int steps){
            this.name=name;
            this.steps=steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        Set<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord))return 0;
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair p=q.poll();
            String n=p.name;
            int step=p.steps;
            if(n.equals(endWord))return step;
            for(int i=0;i<n.length();i++){
            for(char ch='a';ch<='z';ch++){
                char replaced[]=n.toCharArray();
                replaced[i]=ch;
                String curr=new String(replaced);
                if(set.contains(curr)){
                    q.add(new Pair(curr,step+1));
                    set.remove(curr);
                }



            }}
        }
        return 0;

        
    }
}