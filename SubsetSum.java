import java.util.*;

class SubsetSum{
    public static void dp(){
       for(int j = 0;j>=w ;j++){
           dp[n][j]=0;
       }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int times = Integer.parseInt(sc.nextLine());
        for(int t = 0; t < times ; t++){
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        List<Integer> a = new ArrayList<Integer>();
        for(int i = 0; i < n ; i++){
            a.add(Integer.parseInt(sc.nextLine()));
        }
        System.out.println();
        System.out.printf("n:%d , a[]:%s , w:%d\n",n,Arrays.toString(a.toArray()),w);
        System.out.println();
        }

        if(flag == 0){
            System.out.println("Yes");
        }
    
    }
}
