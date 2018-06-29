//zoothezoo1
import java.util.*;

public class Main{
    static int[] coin = new int[4];
    static int[] cost = new int[4];
    static int[][] optS;
    // i: コインの種類を表す添字
    // Q: 支払総額(残りの支払額)
    public static int opt(int i, int Q){
        //再帰しない場合
        if(i < 0){
            if(Q == 0){
                return 0;
            }else{
                return -1;
            }
        }
        System.out.println("i: " + i + " q: " + Q);
        //再帰する場合
        int max = -1; //枚数:returnする
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
        return max;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String[] input = sc.nextLine().split(" ");
            int price = Integer.parseInt(input[0]);
            for(int i=0; i<4; i++){
                coin[i] = Integer.parseInt(input[i+1]);
            }
            if(price == 0 && coin[0] == 0 && coin[1] == 0 && coin[2] == 0 && coin[3] == 0){
                return;
            }
            cost[0] = 1;
            cost[1] = 5;
            cost[2] = 10;
            cost[3] = 25;
            optS = new int[4][price+1];
            int ans = opt(3,price);
            int quarters = optS[3][price];
            int dimes = optS[2][price - cost[3]*quarters];
            int nickels= optS[1][price - cost[3]*quarters - cost[2]*dimes];
            int cents= optS[0][price - cost[3]*quarters - cost[2]*dimes - cost[1]*nickels];
            //System.out.printf("It costs %d. I have %d cents, %d nickels, %d dimes and %d quarters.\n\n",price,coin[0],coin[1],coin[2],coin[3]);
            // System.out.println("price: "+ price);
            // System.out.println("ans: "+ans);
            // System.out.println("paying: "+ (cost[3]*quarters + cost[2]*dimes + cost[1]*nickels + cost[0]*cents));
            if(ans == -1){
                System.out.println("Charlie cannot buy coffee.");
            }
            else{
                System.out.printf("Throw in %d cents, %d nickels, %d dimes, and %d quarters.\n",cents,nickels,dimes,quarters);
            }

        }
    }
}
