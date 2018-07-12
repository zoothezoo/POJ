//zoothezoo1
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    static int[] coin = new int[4];
    static int[] cost = new int[4];
    static int[][] optS = new int[4][10001];
    static int[][] memo = new int[4][10001];


    // i: コインの種類を表す添字
    // Q: 支払総額(残りの支払額)
    public static int opt(int i, int Q){
        if(Q==0){
            return 0;
        }
        //再帰しない場合
        if(i < 0){
            if(Q == 0){
                return 0;
            }else{
                return -1;
            }
        }
        int max = -1; //枚数:returnする

        if(memo[i][Q] != -10){
            return memo[i][Q];
        }
        //System.out.println("i: " + i + " q: " + Q);
        //再帰する場合
        for(int s=0; s<=coin[i]; s++){ // s: コインの支払い枚数
            if(Q < cost[i]*s){
                break;
            }
            int o = opt(i-1,Q-cost[i]*s);
            if(o < 0){
                continue;
            }
            int v = o + s;
            if(v >= max){
                optS[i][Q] = s;
                max = v;
            }
        }
        memo[i][Q] = max;
        return max;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cost[0] = 1;
        cost[1] = 5;
        cost[2] = 10;
        cost[3] = 25;

        while(true){
            String[] input = br.readLine().split(" ");
            int price = Integer.parseInt(input[0]);
            for(int i=0; i<4; i++){
                coin[i] = Integer.parseInt(input[i+1]);
            }
            if(price == 0 && coin[0] == 0 && coin[1] == 0 && coin[2] == 0 && coin[3] == 0){
                return;
            }
            for(int i=0; i<4; i++){
                for(int j=0; j<price+1; j++){
                    memo[i][j] = -10;
                }
            }
            int ans = opt(3,price);
            int quarters = optS[3][price];
            int dimes = optS[2][price - cost[3]*quarters];
            int nickels= optS[1][price - cost[3]*quarters - cost[2]*dimes];
            int cents= optS[0][price - cost[3]*quarters - cost[2]*dimes - cost[1]*nickels];

            if(ans == -1){
                System.out.println("Charlie cannot buy coffee.");
            }
            else{
                System.out.printf("Throw in %d cents, %d nickels, %d dimes, and %d quarters.\n",cents,nickels,dimes,quarters);
            }

        }
    }
}
