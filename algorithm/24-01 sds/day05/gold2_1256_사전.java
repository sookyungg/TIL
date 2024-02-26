import java.util.*;
import java.io.*;


class Main {
  
    static int n,m,t;
    static long dp[][]=new long[1001][1001];
   
    public static void main(String[] args) throws IOException {
    	
    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		
    		t=Integer.parseInt(st.nextToken());
    		
    		for(int i=0;i<t;i++) {
    			st=new StringTokenizer(br.readLine());
    			
	    		n=Integer.parseInt(st.nextToken());
	    		m=Integer.parseInt(st.nextToken());
	    		
	    	
	    		long result=pascal(m,n);
	    		
	    		System.out.println(result);
    		
    		}
    	}
    
    	static long pascal(int n, int r) {
    		if(dp[n][r]>0) {
    			return dp[n][r];
    		}
    		else if(n==r || r==0) {
    			return dp[n][r]=1;
    		}
    		else {
    				dp[n][r]=pascal(n-1,r)+pascal(n-1,r-1);
    			return dp[n][r];
    		}
    	}
    }
    
    

