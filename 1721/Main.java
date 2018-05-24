import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{

    List<Integer> card = new ArrayList<Integer>();
    List<Integer> mark = new ArrayList<Integer>();
    List<Integer> ans = new ArrayList<Integer>();


    static void shuffle(int n){
        int length = 0;
        while(1){
            for(int i=1;i<=n;i++){
                mark.set
            }
        }

    }

    public static void main(String[] args){
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
        length = shuffle(n);
        System.out.println(card);
    }
}
