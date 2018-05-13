//ID:zoothezoo1
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main{
    static boolean[] mark;
    static List<List<Integer>> criminals = new ArrayList<List<Integer>>();
    static String answer;

    static void search(int start,int goal,int step){
        if(start == goal){
            if(step % 2 == 0){
                answer = "In the same gang.";
            }
            else{
                answer = "In different gangs.";
            }
            return;
        }
        if(mark[start]){
            return;
        }
        mark[start] = true;
        for(int w : criminals.get(start)){
            search(w,goal,step+1);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tests = Integer.parseInt(sc.nextLine());
        for(int t = 0 ; t < tests ; t++){
            String[] line = sc.nextLine().split(" ");
            int numbers = Integer.parseInt(line[0]);
            mark = new boolean[numbers+1];
            int inputs = Integer.parseInt(line[1]);
            for(int i=0 ; i <= numbers ; i++){
                List<Integer> neighbors = new ArrayList<Integer>();
                criminals.add(neighbors);
            }
            for(int s=0 ; s < inputs ; s++){
                String[] input = sc.nextLine().split(" ");
                char command = input[0].charAt(0);
                int crimA = Integer.parseInt(input[1]);
                int crimB = Integer.parseInt(input[2]);
                if(command == 'A'){
                    for(int i=0 ; i < mark.length ; i++){
                        mark[i]=false;
                    }
                    answer = "Not sure yet.";
                    search(crimA,crimB,0);
                    System.out.println(answer);
                }
                else if(command == 'D'){
                    criminals.get(crimA).add(crimB);
                    criminals.get(crimB).add(crimA);
                }
            }
        }
    }
}
