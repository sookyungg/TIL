import java.io.*;
import java.util.*;

class Main {

	static int n,m,k;
	static int[] depth;
	static int[][] parent;
	static ArrayList[] tree;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		n=Integer.parseInt(st.nextToken());

		//1. 2^k >n인 첫번째 k 찾기
		k=-1;
		for(int i=1;i<=n;i*=2){
			k++;
		}

		// LCA 관련 변수 초기화
		depth=new int[n+1];
		parent=new int[k+1][n+1];

		//tree 관련 변수 초기화
		tree=new ArrayList[n+1];
		for(int i=1;i<=n;i++){
			tree[i]=new ArrayList<Integer>();
		}

		int a,b;

		for(int i=1;i<n;i++){
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());

			tree[a].add(b);
			tree[b].add(a);
		}

		//depth 확인
		dfs(1,1);

		// 3. 2^K 까지 parent 채우기
		for (int i = 1; i<=k; i++) {
			for (int j = 1; j<=n; j++) {
				// parent[K][V] = parent[K-1][parent[K-1][V]];
				parent[i][j] = parent[i-1][parent[i-1][j]];
			}
		}
		st=new StringTokenizer(br.readLine());
		m=Integer.parseInt(st.nextToken());
		// 4. LCA 진행
		for(int i=0;i<m;i++){
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());

			System.out.println(lca(a,b));
		}

	}

	static void dfs(int idx,int cnt){
		//depth를 기록
		depth[idx]=cnt;

		// 2. 자식들의 depth를 기록
		int len=tree[idx].size();
		for(int i=0;i<len;i++){
			int next=(int)tree[idx].get(i);
			// 아직 깊이를 모르면 → 미방문 노드
			if(depth[next]==0){
				dfs(next,cnt+1);
				// 첫번째 부모를 기록  (2^0)
				parent[0][next]=idx;
			}

		}
		return;
	}
	static int lca(int a,int b){
		// 1. depth[a] >= depth[b] 이도록 조정하기
		if(depth[a]<depth[b]){
			int tmp=a;
			a=b;
			b=tmp;
		}
		// 2. 더 깊은 a를 2^K승 점프하여 depth를 맞추기
		for(int i=k;i>=0;i--){
			if(Math.pow(2,i)<=depth[a]-depth[b]){
				a=parent[i][a];
			}
		}
		// 3. depth를 맞췄는데 같다면 바로 종료
		if (a==b) return a;

		// 4. a-b는 같은 depth이므로 2^K승 점프하며 공통부모 바로 아래까지 올리기
		for(int i=k;i>=0;i--){
			if(parent[i][a]!=parent[i][b]){
				a=parent[i][a];
				b=parent[i][b];
			}
		}
		// 공통부모 바로 아래에서 반복문이 끝났으므로 첫번째 부모 (2^0) 리턴
		return parent[0][a];
	}

}
