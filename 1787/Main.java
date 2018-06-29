import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int price = Integer.parseInt(input[0]); //
        int cent = Integer.parseInt(input[1]); //1cent
        int nickel= Integer.parseInt(input[2]); //5cent
        int dime = Integer.parseInt(input[3]); //10cent
        int quarter = Integer.parseInt(input[4]); //25cent

        System.out.printf("I have %d cents, %d nickels, %d dimes and %d quarters.\nI am the richest man of the world.\n",cent,nickel,dime,quarter);
    }
}
