// id: ramenjuniti
import java.util.Scanner;

public class Main {
  public static int[] v = {1, 5, 10, 25};
  public static int p;
  public static int[] c = new int[4];
  public static int[] dp;
  public static int[][] num;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(true) {
      p = sc.nextInt();
      for(int i = 0; i < c.length; i++) {
        c[i] = sc.nextInt();
      }
      if(p + c[0] + c[1] + c[2] + c[3] == 0) {
        return;
      }
      dp = new int[p+1];
      num = new int[p+1][4];
      solve();
    }
  }

  public static void solve() {
    for(int i = 0; i <= p; i++) {
      dp[i] = -1;
      dp[0] = 0;
    }
    for(int i = 0; i < 4; i++) {
      for(int j = v[i]; j <= p; j++) {
        if(dp[j-v[i]] >= 0 && num[j-v[i]][i] < c[i] && dp[j-v[i]]+1 > dp[j]) {
          dp[j] = dp[j-v[i]] + 1;
          for(int k = 0; k < 4; k++) {
            if(k == i) {
              num[j][k] = num[j-v[i]][k] + 1;
            } else {
              num[j][k] = num[j-v[i]][k];
            }
          }
        }
      }
    } 
    if(dp[p] <= 0) {
      System.out.println("Charlie cannot buy coffee.");
    } else {
      System.out.println("Throw in " + num[p][0] + " cents, " + num[p][1] + " nickels, " + num[p][2] + " dimes, and " + num[p][3] + " quarters.");
    }
  }
}
