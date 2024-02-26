import java.util.*;
import java.io.*;


class Main {
  
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
        
    	n=Integer.parseInt(st.nextToken());
    	
    	st=new StringTokenizer(br.readLine());
    	arr=new int[n+1];
    	for(int i=1;i<n+1;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    	}
    	
    	
    	
    	int[] leftgcd=new int[n+1];
    	int[] rightgcd=new int[n+1];
    	
    	leftgcd[1]=arr[1];
    	rightgcd[n]=arr[n];
    	
    	for(int i=2;i<=n;i++) {
    		leftgcd[i]=gcd(leftgcd[i-1],arr[i]);
    	}
    	
    	for (int i = n - 1; i >= 1; i--) {
            rightgcd[i] = gcd(rightgcd[i + 1], arr[i]);
        }
    	
    	int answer=0;
    	int gcd=0;
    	
    	for (int i = 1; i < n; i++) {
            int currentGcd = gcd(leftgcd[i - 1], rightgcd[i + 1]);
            if (arr[i] % currentGcd != 0 && gcd < currentGcd) {
                answer = arr[i];
                gcd = currentGcd;
            }
        }

        if (answer == 0 && gcd == 0) {
            System.out.println(-1);
        } else {
            System.out.println(gcd + " " + answer);
        }

    }
    
    // 유클리드 호제법
    public static int gcd(int a, int b) {
    	while(b!=0) {
    		int temp=b;
    		b=a%b;
    		a=temp;
    	}
    	return a;

    }
    
}