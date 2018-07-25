import java.util.*;

public class Main{
    public static int[] dx = {-1,1, 0, 0, 0};
    public static int[] dy = {0, 0, -1, 1, 0};
    public static String[][] input;
    public static int step = 0;
    public static boolean flag = false;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[][] in = new String[4][4]; //receiver sample input
        input = new String[6][6]; //receiver sample input with Space
        //receive
        for(int i=0; i<4; i++){
            in[i] = sc.nextLine().split("");
        }
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                input[i+1][j+1] = in[i][j];
            }
        }

        for(step=0; step<=16; step++){
            solve(1, 1, 0);
            if(flag){
                break;
            }
        }
        if(flag){
            System.out.println(step);
        }
        else{
            System.out.println("Impossible");
        }
        for(int i=0; i<6; i++){
            System.out.println();
            for(int j=0; j<6; j++){
                System.out.print(input[i][j]);
            }
        }
    }

    public static void solve(int x, int y, int depth){
        if(depth == step){
            flag = judge();
            return;
        }
        if(flag || x == 5){
            return;
        }
        flip(x, y);
        if(y < 4){
            solve(x, y+1, depth+1);
        }
        else{
            solve(x+1, 1, depth+1);
        }
        flip(x, y);
        if(y < 4){
            solve(x, y+1, depth);
        } else {
            solve(x+1, 1, depth);
        }
        return;
    }

    public static void flip(int x, int y){
        for(int i = 0; i < 5; i++){
            if(input[x+dx[i]][y+dy[i]] != null){
                if(input[x+dx[i]][y+dy[i]].equals("b")){
                    input[x+dx[i]][y+dy[i]] = "w";
                }
                else{
                    input[x+dx[i]][y+dy[i]] = "b";
                }
            }
        }
    }

    public static boolean judge(){
        for(int i = 1; i < 5; i++){
            for(int j = 1; j < 5; j++){
                if(!input[i][j].equals(input[1][1])){
                    return false;
                }
            }
        }
        return true;
    }
}
