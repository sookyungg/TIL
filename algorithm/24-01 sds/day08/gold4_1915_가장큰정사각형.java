import java.util.*;
import java.io.*;


public class Main {
    
	static int n,m;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        
        int max_num=0;
        int [][]dp=new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                char c = input.charAt(j - 1);

                if (c == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max_num = Math.max(max_num, dp[i][j]);
                }
            }
        }
        
        //for(int i=0;i<n;i++) System.out.println(Arrays.toString(dp[i]));    

        

        System.out.println(max_num*max_num);
    }
}