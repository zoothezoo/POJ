//zoothezoo
import java.util.*;

public class Main{
    public static void perm(int i, String s, int n, int[] usable){
        if(i == n){
            System.out.println(s);
            return;
        }
        for(char c = 'a';c <= 'z'; c++){
            int k = c - 'a';
            if(usable[k] > 0){
                usable[k]--;
                perm(i+1 ,s+c ,n ,usable  );
                usable[k]++;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] array = input.toCharArray();
        int length = array.length;
        int[] usable = new int[26];
        for(int i = 0 ;i< length ;i++){
            usable[array[i]-'a']++;
        }
        perm(0, "" ,length, usable);
    }
}
