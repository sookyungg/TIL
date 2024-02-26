import java.util.*;
import java.io.*;

public class Main {

	static int n,s;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		n=Integer.parseInt(st.nextToken());
		s=Integer.parseInt(st.nextToken());

		arr=new int[n+1];
		st=new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}

		int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;

		while(start<=end && end<=n){
			if (sum>=s) {
				min=Math.min(min,end-start);
				sum -= arr[start];
				start++;
			}
			else{
				//if(end==n) break;
				sum+=arr[end];
				end++;
			}

		}

		if (min ==Integer.MAX_VALUE){
			System.out.print(0);
		} else {
			System.out.print(min);
		}

	}



}
