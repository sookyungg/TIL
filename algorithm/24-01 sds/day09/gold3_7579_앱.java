import java.util.*;
import java.io.*;


public class Main {
    
	static int n,m;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] M=new int[n];
        for(int i=0;i<n;i++) {
        	M[i]=Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int[] C=new int[n];
        int sum=0;
        for(int i=0;i<n;i++) {
        	C[i]=Integer.parseInt(st.nextToken());
        	sum+=C[i];
        }
        
        
        int[] dp=new int[sum+1];
        for(int i=0;i<n;i++) {
        	for(int j=sum;j>=C[i];j--) {
        		dp[j]=Math.max(dp[j],dp[j-C[i]]+M[i]);
        	}
        }
        
        int answer=0;
        for(int i=0;i<=sum;i++) {
        	if(dp[i]>=m) {
        		answer=i;
        		break;
        	}
        }
        System.out.println(answer);
        }

    }

