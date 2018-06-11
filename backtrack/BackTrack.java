import java.util.*;

public class BackTrack {
    public static List<Integer> ans;
    public static List<Integer> t;
    public static List<Integer> num;
    public static int n;
    public static int w;

    public static void generate(int i,List<Integer> t, int k, int sum) {
        if(sum == w) {
            for(int j = 0; j < t.size(); j++) {
                ans.add(t.get(j));
            }
            return;
        }
        if(i == n+1) {
            return;
        }
        t.set(k,i);
        generate(i+1,t, k+1, sum+num.get(i-1));
        t.set(k,0);
        generate(i+1,t, k ,sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m =Integer.parseInt(sc.nextLine());
        for(int i = 0; i < m; i++) {
            String[] input = sc.nextLine().split(" ");
            n = Integer.parseInt(input[0]);
            w = Integer.parseInt(input[1]);
            num = new ArrayList<Integer>();
            for(int j = 0; j < n; j++) {
                num.add(Integer.parseInt(sc.nextLine()));
            }

            ans = new ArrayList<>();
            t = new ArrayList<>();
            generate(1,t, 0, 0);

            if(ans.size() == 0) {
                System.out.print("NO");
            } else {
                String min = "999999";
                String ansStr = "";
                for(int j = 0; j < ans.size(); j++) {
                    if((j+1) % n == 0) {
                        if(min.compareTo(ansStr) > 0) {
                            min = ansStr.trim();
                        }
                        ansStr = "";
                    }
                    if(ans.get(j) > 0) {
                        ansStr += ans.get(j) + " ";
                    }
                }
                System.out.print(min);
            }
            System.out.println();
        }
        sc.close();
    }
}
