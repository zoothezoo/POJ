
class Fib {
    static int[] memo = new int[10000];
    // memo[i] fib(i)
    public static int memoFib(int n) {
        if(n <= 1){
            return 1;
        }

        if(memo[n] != -1) {
            return memo[n];
        }

        memo[n] = memoFib(n - 1) + memoFib(n - 2);
        return memo[n];
    }

    public static int fib(int n) {
        if(n <= 1){
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args){
        java.util.Arrays.fill(memo, -1);
        int n = Integer.valueOf(args[0]);


        long begin1 = System.currentTimeMillis();
        System.out.println(memoFib(n));
        long end1 = System.currentTimeMillis();

        long begin2 = System.currentTimeMillis();
        System.out.println(fib(n));
        long end2 = System.currentTimeMillis();

        System.out.println(end1 - begin1);
        System.out.println(end2 - begin2);

        int dp = new int[100];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 99; i++) {
            dp[i] = d[i - 1] + dp[i - 2];
        }
        System.out.println(dp[99]);
    }
}
