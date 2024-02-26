import java.util.*;
import java.io.*;


class Main {
  
    static int n,k;
    static long dp[][]=new long[1001][1001];
   
    public static void main(String[] args) throws IOException {
    	
    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		
    		n=Integer.parseInt(st.nextToken());
    		k=Integer.parseInt(st.nextToken());
    		
    		
    		
    		long result=pascal(n,k)%10007;
    		
    		System.out.print(result);
    		
    		
    	}
    
    	static long pascal(int n, int r) {
    		if(dp[n][r]>0) {
    			return dp[n][r]%10007;
    		}
    		else if(n==r || r==0) {
    			return dp[n][r]=1;
    		}
    		else {
    				dp[n][r]=pascal(n-1,r)%10007+pascal(n-1,r-1)%10007;
    			return dp[n][r]%10007;
    		}
    	}
    }
    
    

