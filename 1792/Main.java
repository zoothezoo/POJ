//zoothezoo1

import java.util.*;
import java.math.*;

public class Main{
    static class Point{
        int x,y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String[] input = sc.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            if(x==0 && y==0){
                return;
            }
            calculate(x,y);
        }
    }

    public static void calculate(int a, int b){
        int ans;
        BigInteger sum;
        Point pa = getPoint(a);
        Point pb = getPoint(b);
        pa.x = pb.x-pa.x > 0 ? pb.x-pa.x : -(pb.x-pa.x);
        pa.y = pb.y-pa.y > 0 ? pb.y-pa.y : -(pb.y-pa.y);

        if(pa.y <= pa.x){
            ans= (pa.x+pa.y)/2;
            sum= getSum(ans, pa.y);
        }
        else{
            ans = pa.y;
            sum = getSum(ans, (pa.y - pa.x)/2);
        }
        System.out.print("There ");
        if(sum.compareTo(BigInteger.ONE) == 0){
            System.out.print("is 1 route");
        }
        else{
            System.out.printf("are %d routes",sum);
        }
        System.out.printf(" of the shortest length %d.\n",ans);
    }

    public static Point getPoint(int n){
        int[][] coordinate = new int[][]{{1,-1}, {2,0}, {1,1}, {-1,1}, {-2,0}, {-1,-1}};
        Point p = new Point(0,0);
        int delta;
        int i=0;
        int x, y;
        int count = 0;

        if(n == 1){
            return p;
        }
        for(i=2; i<=1000; i++){
            if(n <= (i*i*3 - i*3+1)){
                break;
            }
        }
        delta = i*i*3 - i*3+1 - n;
        i--;
        x = -2*i;
        y = 0;
        boolean flag = false;
        for(int j=0; j<6; j++){
            for(int k=0; k<i; k++){
                if(count == delta){
                    flag = true;
                    break;
                }
                count++;
                x += coordinate[j][0];
                y += coordinate[j][1];
            }
            if(flag){
                break;
            }
        }
        p.x = x;
        p.y = y;

        return p;
    }

    public static BigInteger getSum(int n, int k){
        BigInteger sum = BigInteger.ONE;
        if(n-k < k){
            k = n-k;
        }
        for(int i=1; i<=k; i++){
            sum = sum.multiply(new BigInteger(new String(n-i + 1 + "")));
            sum = sum.divide(new BigInteger(new String(i + "")));
        }
        return sum;
    }
}
