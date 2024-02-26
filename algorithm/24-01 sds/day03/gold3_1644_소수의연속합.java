import java.util.*;
import java.io.*;


class Main {
  
    static int n;
    
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
        
    	n=Integer.parseInt(st.nextToken());
    	
    	//n까지의 소수 담는 arr
    	ArrayList<Integer> arr=new ArrayList<Integer>();
    	for(int i=2;i<=n;i++) {
    		if (isPrime(i)==1) {
    			arr.add(i);
    		}
    	}
    	
    	//System.out.print(arr);
    	int s=0, e=0, sum=0, cnt=0;
		while(true) {
			if(sum>=n) {
				sum -= arr.get(s);
				s++;
			}else if(e==arr.size()) break;
			else {
				sum += arr.get(e);
				e++;
			}
			if(sum==n) {
				cnt++;
			}

		}
		System.out.print(cnt);

    
    }
    
    public static int isPrime(int x) {
		for(int i=2;i<=Math.sqrt(x);i++) {
			if (x%i==0) {
				return 0;
			}
		}
		return 1;
	
    }
}
