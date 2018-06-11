//もとの問題
//入力：n,w_1,w_2,w_3,...,w_n,W
//
//部分問題
//入力：i(0<=i<=n),U(0<=U<=W)
//i,w_1,w_2,...,w_i,Uに対する集合部分和問題
//
//f(i,u):この問題の答え(true,false)を表す関数
//
//f(i,0) = true
//f(0,U) = false(U > 0)
//f(i + 1 , U) = f(i , U) or (U >= w_{i+1} and f(i,U - w_{i+1}))
//
// f(i+ 
//
//

import java.util.*;

class SubsetSum{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        List<Integer> a = new ArrayList<Integer>();
        for(int i = 1; i < n+1 ; i++){
            a.add(Integer.parseInt(input[i]));
        }
        int w = Integer.parseInt(input[n+1]);
        System.out.println();
        System.out.printf("n:%d , a[]:%s , w:%d\n",n,Arrays.toString(a.toArray()),w);
        System.out.println();

    }
}
