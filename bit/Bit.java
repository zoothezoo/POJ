import java.util.*;

public class Bit{
    public static List<Integer> solve(int n, int W, List<Integer> w){
        for(int i=0; i<(1<<n); i++){
            int sum = 0;
            //System.out.printf("i: %d\n",i);
            for(int j=0; j<n; j++){
                if((i&(1<<j)) != 0){
                    sum += w.get(j);
                }
            }
            if(sum == W){
                //リストaには番号を入れる
                List<Integer> a = new ArrayList<Integer>();
                //a.add();
                for(int j=0; j<n; j++){
                    if((i&(1<<j)) != 0){
                        a.add(j+1);
                    }
                }
                return a;
            }
        }
        return new ArrayList<Integer>();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        List<Integer> w = new ArrayList<Integer>();
        for(int test=0; test<m; test++){
            String[] input = sc.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int W = Integer.parseInt(input[1]);
            for(int i=0; i<n; i++){
                w.add(Integer.parseInt(sc.nextLine()));
            }
            List<Integer> ans = solve(n, W, w);
            if(ans.size() == 0){
                System.out.println("NO");
            }
            else{
                System.out.println(ans);
            }
        }
    }
}
