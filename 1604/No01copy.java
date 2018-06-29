import java.util.Scanner;
public class No01{
    public static void main(String[] args){
        int co5=0;
        int co2=0;
        int seki=1;
        int mod=1;
        int rui=1;
        int m;
        int ans;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=1;i<=N;i++){
            m=i;
            System.out.println("N:"+m);
            while(m%2==0){
                m=m/2;
                co2++;
                System.out.println("2:"+co2);
            }
            while(m%5==0){
                m=m/5;
                co5++;
                System.out.println("5:"+co5);
            }
            seki=m*mod;
            mod=seki%10;
            System.out.println("mod:"+mod+"   seki:"+seki);
        }
        for(int t=1;t<=co2-co5;t++){
            rui=2*rui;
            rui=rui%10;
            System.out.println("rui:"+rui);
        }
        ans=rui*mod;
        System.out.println(ans%10);
    }
}
