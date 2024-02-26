import java.util.*;
import java.io.*;


class Main {
  
    static int a1,a2;
    static int b1,b2;
    static int result1,result2;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	a1=Integer.parseInt(st.nextToken());
    	a2=Integer.parseInt(st.nextToken());
    	
    	st=new StringTokenizer(br.readLine());
    	b1=Integer.parseInt(st.nextToken());
    	b2=Integer.parseInt(st.nextToken());
    	
    	
    	
    	result1=(a1*b2+a2*b1);
    	result2=(a2*b2);
    	
    	int d=gcd(result1,result2);
    	
    	result1/=d;
    	result2/=d;
    	
    	System.out.print(result1+" "+result2+"\n");
    	
               

    }
    
 // 유클리드 호제법
    public static int gcd(int a, int b) {
        // a가 b보다 큰 경우에 대해서 유클리드 호제법 수행.
        if (a <= b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (b == 0) {
            return a;
        }
        return gcd(b , a % b);
    }
    
}