import java.util.*;
import java.io.*;


public class Main {
    
	
	static String n,m;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        n=st.nextToken();
        st = new StringTokenizer(br.readLine());
        m=st.nextToken();
        
        
        
        int[][] dp=new int[n.length()][m.length()];
        int answer=0;
        
        for(int i=0;i<n.length();i++) {
        	for(int j=0;j<m.length();j++) {
        		if(n.charAt(i)==m.charAt(j)) {
        			dp[i][j]=1;
        			if(i>=1&&j>=1) dp[i][j]+=dp[i-1][j-1];
        			
        			answer=Math.max(dp[i][j], answer);
        		}
        	}
        }
        
        
        System.out.println(answer);
        
        
        
        }

    }

