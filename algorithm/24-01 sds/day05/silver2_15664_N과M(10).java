import java.util.*;
import java.io.*;


public class Main {
	static int N,M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}// 배열 초기화
		
		// 오름차순으로 정렬
		Arrays.sort(arr);
		// 조합
		comb(0, new int[M], 0);
		
		System.out.println(sb);
		
	}
	static void comb(int cnt, int[] selected, int startIdx) {
		if(cnt == M) {
			StringBuilder tmp = new StringBuilder();
			for(int i=0;i<cnt;i++) {
				tmp.append(selected[i]).append(' ');
			}
			tmp.append('\n');
			String str = tmp.toString();
			if(!set.contains(str)) {
				set.add(str);
				sb.append(tmp);
			}
			return;
		}
		for(int i=startIdx;i<N;i++) {
			selected[cnt] = arr[i];
			comb(cnt+1, selected, i+1);
		}
	}
}