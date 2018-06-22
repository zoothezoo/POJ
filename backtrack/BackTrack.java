import java.util.*;

public class BackTrack {
    public static List<Integer> ans;
    public static List<Integer> num;
    public static int n;
    public static int W;
    public static List<Integer> w;


    // i: 深さ
    //    深さは1から始める
    //    深さiの再帰呼び出しでは, w_iを選ぶのか選ばないのかを決める
    // k: 選んだ正整数の個数
    // t: 選んだ正整数の番号のリスト
    //    tは長さkのリストである
    // 戻り値: 解が見つかったらtrue, まだ見つかっていないのであればfalse
    public static boolean generate(int i, int k, List<Integer> t) {
        int sum = 0;
        if(i == n+1) {
            // t (ここで要素数がkのはず)が表す解の候補が解となるかを調べる
            for(int j=0;j<k;j++){
                sum += w.get(t.get(j));
            }
            if(sum == W){
                return true;
            }
            else{
                return false;
            }
        }
        // w_iを選ぶ場合
        t.add(i);
        if(generate(i+1, k+1, t)) {
            return true;
        }
        // w_iを選ばない場合
        t.remove(k);
        if(generate(i+1, k, t)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m =Integer.parseInt(sc.nextLine());
        for(int test = 0; test < m; test++) {
            String[] input = sc.nextLine().split(" ");
            n = Integer.parseInt(input[0]);
            W = Integer.parseInt(input[1]);
            w = new ArrayList<Integer>();
            w.add(0);
                for(int j = 0; j < n; j++) {
                    w.add(Integer.parseInt(sc.nextLine()));
                }
            ans = new ArrayList<>();
            List<Integer> t = new ArrayList<>();
            boolean boo = generate(1,0,t);
            if(boo == true){
                System.out.println(Arrays.toString(t.toArray()));
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
