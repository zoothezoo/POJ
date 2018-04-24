//ID:zoothezoo1

import java.util.Scanner;
public class Main{
    static void solve(int N){
        int co5=0;
        int co2=0;
        int seki=1;
        int mod=1;
        int rui=1;
        int m;
        for(int i=1;i<=N;i++){
            m=i;
            //System.out.println("N:"+m);
            while(m%2==0){
                m=m/2;
                co2++;
                //System.out.println("2:"+co2);
            }
            while(m%5==0){
                m=m/5;
                co5++;
                //System.out.println("5:"+co5);
            }
            seki=m*mod;
            mod=seki%10;
            //System.out.println("mod:"+mod+"   seki:"+seki);
        }
        for(int i=1;i<=co2-co5;i++){
            rui=rui*2;
            rui=rui%10;
            //System.out.println("rui:"+rui);
        }
        int ans=rui*mod;
        System.out.printf("%5d -> %d\n",N,ans%10);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int N = sc.nextInt();
            solve(N);
        }
    }
}
