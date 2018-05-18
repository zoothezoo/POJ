//zoothezoo1
import java.util.Scanner;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int i=0 ; i<test ; i++){
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int q = Integer.parseInt(input[1]);
            UF uf = new UF(n);
            for(int j=0 ; j<q ; j++){
                String[] in = br.readLine().split(" ");
                String query = in[0];
                //System.out.println("query ==" + query);
                int a = Integer.parseInt(in[1]);
                int b = Integer.parseInt(in[2]);
                if(query.equals("D")){
                    uf.marge(a*2,b*2+1);
                    uf.marge(a*2+1,b*2);
                }
                else{
                    System.out.println(uf.same(a,b));
                }
            }
        }
    }
    static class UF{
        int[] parent;
        int[] rank;
        public UF(int N){
            this.parent = new int[N*2+2];
            this.rank = new int[N*2+2];
            for(int i=1 ; i<=N*2+1 ; i++){
                parent[i] = -1;
                rank[i] = 0;
            }
        }
        public void marge(int a, int b){
            a = root(a);
            b = root(b);
            if(a == b){
                return;
            }
            if(rank[a] < rank[b])
                parent[a] = b;
            else
                parent[b] = a;
            if(rank[a] == rank[b])
                rank[a]++;
            return;
        }

        public int root(int a){
            if(parent[a] == -1){
                return a;
            }
            else{
                return parent[a] = root(parent[a]);
            }
        }

        public String same(int a, int b){
            if(root(a*2) == root(b*2))
                return "In the same gang.";
            else if(root(a*2) == root(b*2+1))
                return "In different gangs.";
            else
                return "Not sure yet.";
        }
    }
}
