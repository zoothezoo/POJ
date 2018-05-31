//zoothezoo1
import java.util.*;

class Main{

    static int n,s;
    static int num[][] = new int[1000][1000];

    public static boolean judge(int step){
        for(int i = 1;i <= n ; i++){
            if(num[0][i] != num[step][i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        int temp[] = new int[1000];
        for(int i = 1 ; i<=n ; i++){
            num[0][i] = Integer.parseInt(sc.nextLine());
        }
        int x = 0;
        while(true){
            x++;
            for(int i = 1; i<= n; i++){
                temp[i] = num[x-1][num[x-1][i]];
            }
            for(int i = 1; i<= n; i++){
                num[x][i] = temp[i];
            }
            if(judge(x)){
                break;
            }
        }
        s = x -( s % x );
        for(int i=1; i<= n ;i++){
            System.out.println(num[s][i]);
        }
    }
}
