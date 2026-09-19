class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x=0;
        int y=0;
        if(x1>xCenter){
            x=x1;
        }
        else if(x2<xCenter){
            x=x2;

        }
        else{
            x=xCenter;
        }
        
        if(y1>yCenter){
            y=y1;
        }
        else if(y2<yCenter){
            y=y2;

        }
        else{
            y=yCenter;
        }
        int a=Math.abs(x-xCenter);
        int b=Math.abs(y-yCenter);
        int res=a*a+b*b;
        int dist=(int)Math.sqrt(res);
        if(dist<=radius)return true;
        else return false;
    }
}