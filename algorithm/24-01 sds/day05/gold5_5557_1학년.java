import java.util.*;
import java.io.*;



class Main {
  
    static int n,m;
    static int[] arr;
   
    static Long[][] dp=new Long[101][21];
   
    public static void main(String[] args) throws IOException {
    	
    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		
    		n=Integer.parseInt(st.nextToken());
	    	arr=new int[n];
	    	
	    	st=new StringTokenizer(br.readLine());
	    	for (int i=0;i<n;i++) {
	    		arr[i]=Integer.parseInt(st.nextToken());
	    	}
	    	
	    	for(int i=0;i<=100;i++){
	            for(int j=0;j<=20;j++)
	                dp[i][j]=0L;
	        }
	
	    	//System.out.println(Arrays.toString(arr));
	    	int target=arr[n-1];
	    	
	    	dp[0][arr[0]]=(long) 1;
	    	
	    	for (int i=1;i<n-1;i++) {
	    		
	    		int plus=arr[i];
	    		
	    		for(int j=0;j<=20;j++) {
	    			
	    			long tmp=dp[i-1][j];
	    			
	    			if(tmp!=(long) 0) {
	    				if(j+plus<=20) {
	    					dp[i][plus+j]+=tmp;
	    				}
	    				if(j-plus>=0) {
	    					dp[i][j-plus]+=tmp;
	    				}
	    			}
	    		}
	    		
	    		
	    	}
	    	
	    	System.out.println(dp[n-2][target]);
    		
    	}
    
  }
    	
    
    
    

