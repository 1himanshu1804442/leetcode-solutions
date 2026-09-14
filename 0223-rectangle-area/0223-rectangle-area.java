class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int l1=ax2-ax1;
        int b1=ay2-ay1;
        int l2=by2-by1;
        int b2=bx2-bx1;
        int overlapx1=Math.max(ax1,bx1);
        int overlapy1=Math.max(ay1,by1);
        int overlapx2=Math.min(ax2,bx2);
        int overlapy2=Math.min(ay2,by2);
        int areaoverlap=(overlapx2-overlapx1)*(overlapy2-overlapy1);
        if(overlapx2>overlapx1&&overlapy2>overlapy1){
        return l1*b1+l2*b2-areaoverlap;}
        return l1*b1+l2*b2;
        
    }
}