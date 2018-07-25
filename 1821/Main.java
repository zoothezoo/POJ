import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int plank = Integer.parseInt(str[0]);
        int num = Integer.parseInt(str[1]);
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> c = new ArrayList<Integer>();
        for(int i=0; i<num; i++){
            String[] strB= sc.nextLine().split(" ");
            a.add(Integer.parseInt(strB[0]));
            b.add(Integer.parseInt(strB[1]));
            c.add(Integer.parseInt(strB[2]));
        }
        


    }



    /*
    opt(i,j)
         =max{opt(i-1, j),
         max(opt(i-1, j-h)+ h* Pi)
         
         }

    */
    
    /*
     主張
     opt(i, j) = opt(i-1, l')+(j+1-l')*P_i
     であるようなl'はl'>=l
     */
}
