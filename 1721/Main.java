//zoothezoo1
import java.util.*;

class Main{

<<<<<<< HEAD
    static int n,s;
    static int num[][] = new int[1000][1000];

    public static boolean judge(int step){
        for(int i = 1;i <= n ; i++){
            if(num[0][i] != num[step][i]){
                return false;
            }
        }
        return true;
=======


    public int shuffle(int n,List<Integer> card ,List<Integer> mark,List<Integer> ans){
        int length = 0;
        while(true){
            for(int i=1;i<=n;i++){
                mark.set(i,card.get(card.get(i)));
            }
            length++;
            boolean flag = true;
            for(int i=1; i<=n;i++){
                if(mark.get(i) != ans.get(i)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                break;
            }
            for(int i=1 ; i<=n ; i++){
                card.set(i,mark.get(i));
            }
        }
        return length;
>>>>>>> 82719fd74291a8b47ca0509ad304a8303c106a15
    }

    public static void main(String[] args){
        List<Integer> card = new ArrayList<Integer>();
        List<Integer> mark = new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
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
<<<<<<< HEAD
=======
        int length;
        length = shuffle(n,card ,mark, ans);
        s = s %length;
        for(int i= 1 ;i<=n;i++){
            mark.set(i,card.get(card.get(i)));
        }
        for(int i= 1 ;i<=n;i++){
            card.set(i,mark.get(i));
        }
        for(int i=1;i<=n;i++){
            System.out.println(card.get(i));
        }
>>>>>>> 82719fd74291a8b47ca0509ad304a8303c106a15
    }
}
