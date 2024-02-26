import java.util.*;
import java.io.*;


class Main {
  
    static int n,k;
   
    public static void main(String[] args) throws IOException {
    	
    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		
    		n=Integer.parseInt(st.nextToken());
    		k=Integer.parseInt(st.nextToken());
    		
    		int result=1;
    		for(int i=0;i<k;i++) {
    			result*=(n-i);
    			result/=i+1;
    		}
    		System.out.print(result);
    		
    		
    	}
    }
    
    

