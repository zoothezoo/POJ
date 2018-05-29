import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{



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
    }

    public static void main(String[] args){
        List<Integer> card = new ArrayList<Integer>();
        List<Integer> mark = new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        for(int i=1; i<=n; i++){
            int num = Integer.parseInt(sc.nextLine());
            card.add(num);
            ans.add(num);
        }
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
    }
}
