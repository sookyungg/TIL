import java.util.*;
import java.io.*;



class Main {
  
	static int n;
	static int[][] dp;
	static int[][] tri;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		dp=new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				dp[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) {
					dp[i][j]+=dp[i-1][j];
				}
				else if(j==i) {
					dp[i][j]+=dp[i-1][j-1];
				}
				else {
					dp[i][j]+=Math.max(dp[i-1][j-1],dp[i-1][j]);
				}
			}
		}
		Arrays.sort(dp[n-1]);
		System.out.print(dp[n-1][dp.length-1]);
	}
	
	
}
    	
    
    
    

