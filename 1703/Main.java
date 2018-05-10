import java.util.ArrayList
public class Gang{
    boolean[] mark;
    String answer;

    void search(int origin,int next,int step){
        //bを探索
        if(origin == next){
            if(step % 2 == 0){
                answer = "same"
            }
            else{
                answer = "differnt"
            }
            return;
        }
        if(mark[origin]){
            return;
        }
        mark[origin] = true;
        for(int w:neighbors[origin]){
            search(w,,step+1)
        }
    }

    public static void main(){
        neighbors = new ArrayList[100];
        neighbors[0] = new ArratList<Integer>();
        scanner sc = new Scanner(System.in);
        List<Integer> here = New ArrayList<Integer>();
        while(sc.hasNextLine()){
            int num = sc.nextline();
            list.add(Integer.parseInt(str));
        }

    }
}
