import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInti(sc.nextLine());
        for(int i=0; i<test; i++){
            int w[] = new int[n];
            String[] str = sc.nextLine().split(" ");
                int n = Integer.parseInt(str[0]);
            int W = Integer.parseInt(str[1]);
            for(int j=0; j<n; j++){
                w[j] = Integer.parseInt(str[2]);
            }
            System.out.println(solve(n, W, w));
        }
    }

    public static String solve(int n, int W, int w[]){
        boolean[][] f = new boolean[n+1][W+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<=W; j++){
                f[i][j] = false;
            }
        }
        f[0][0] = true;
        for(int i=0; i<n; i++){
            for(int U=0; U<=W; U++){
                f[i+1][U] |= f[i][U];
                if(U >= w[i]){
                    f[i+1][U] |= f[i][U-w[i]];
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= W; j++){
                if(f[i][j]){
                    return "YES";
                }
            }
        }
        return "NO";
    }
}
