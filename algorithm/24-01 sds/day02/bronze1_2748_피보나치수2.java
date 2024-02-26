import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static long[] a;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());


		a = new long[n+1];
		Arrays.fill(a,-1);
		a[0]=0;
		a[1]=1;

		System.out.print(fibo(n));

	}

	static long fibo(int k){
		if (k==0) return a[0];
		if (k==1) return a[1];
		if (a[k]==-1){
			a[k]=fibo(k-1)+fibo(k-2);
		}
		return a[k];
	}
}
