import java.util.*;
import java.io.*;



class Main {
  
	static int n,m;
	static int[] dp;
	static int a,b;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		dp=new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			dp[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i];
		}
		
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			
			System.out.println(dp[b]-dp[a-1]);
		}
		
		
	}
	
	
}
