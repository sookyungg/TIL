import java.util.*;
import java.io.*;


class Main {
  
    static int n;
    
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
        
    	n=Integer.parseInt(st.nextToken());
    	int d=2;
    	while(n!=1) {
    		if (n%d!=0) {
    			d+=1;
    		}
    		else {
    			n=n/d;
    			System.out.print(d+"\n");
    		}
    			
    	}
    	

    }
    
    
    
}