import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main1{
    public static void main(Array[] String){
        Scanner sc = new Scanner(System.in);
        int tests = Integer.parseInt(sc.nextLine());
        String[] line = sc.nextLine().split(" ");
        int crim = Integer.parseInt(line[0]);
        int mess = Integer.parseInt(line[1]);
        //int[] vertex = new int[crim];
        List<Integer> vertex = new ArrayList<Integer>();
        int a , b;
        for(int i=0 ; i<=crim ; i++){
            vertex.add(i);
        }
        for(int i=0 ; i<mess ; i++){
            if(sc.next() == "D"){
                a = Integer.parseInt(sc.next());
                b = Integer.parseInt(sc.next());

                if(vertex.get(a) < vertex.get(b)){
                    vertex.get(b) = vertex.get(a);
                }
                else{
                    vertex.get(a) = vertex.get(b);
                }
            }
            else if(sc.next() == "A"){
                a = Integer.parseInt(sc.next());
                b = Integer.parseInt(sc.next());

                if(getLeader(a, vertex) == getLeader(b, vertex)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
        sc.close();
    }

    public static int getLeader(int a, int[] vertex){
        while(a != vertex[a]){
            a = vertex[a];
        }
        return a;

    }
}
