//zoothezoo1
import java.util.Arrays;
import java.util.Scanner;

public class Main{

    public static void carry(int[] t,int N){
        int time=0;
        while(N>0){
            if(N==1){
                time=time+t[0];
                N=0;
            }
            else if(N==2){
                time=time+t[1];
                N=0;
            }
            else if(N==3){
                time=time+t[0]+t[1]+t[2];
                N=0;
            }
            else if(N==4){
                if(t[2]-2*t[1]+t[0]<=0){
                    time=time+t[3]+t[2]+t[1]+2*t[0];
                }
                else{
                    time=time+t[3]+3*t[1]+t[0];
                }
                N=0;
            }
            else{
                if(t[N-2]-2*t[1]+t[0]<=0){
                    time=time+t[N-1]+t[N-2]+2*t[0];
                }
                else{
                    time=time+(t[0]+2*t[1]+t[N-1]);
                }
                N=N-2;
            }
        }
        System.out.println(time);
    }

    public static int[] sort(int[] a,int N){
        Arrays.sort(a);
        /*for(int i = 0;i<N;i++){
          System.out.print(a[i]);
          }*/
        return(a);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int j=0;j<test;j++){
            int people = sc.nextInt();
            int man[] = new int[people];
            for(int i=0;i<people;i++){
                man[i]=sc.nextInt();
            }
            man =  sort(man,people);
            carry(man,people);
        }
        return;
    }
}
