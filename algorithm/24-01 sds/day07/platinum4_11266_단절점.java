
import java.util.*;
import java.io.*;


class Main {
  
    static int v,e;
    static int a,b;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
   
    public static void main(String[] args) throws IOException {
    	
    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		
    		//init
    		v=Integer.parseInt(st.nextToken());
    		e=Integer.parseInt(st.nextToken());
    		cut=new int[v+1];
    		
    		
    		for(int i=0;i<=v;i++) {
    			arr.add(new ArrayList<>());
    		}
    		
    		
    		for(int i=0;i<e;i++) {
    			st=new StringTokenizer(br.readLine());
    			a=Integer.parseInt(st.nextToken());
    			b=Integer.parseInt(st.nextToken());
    			
    			arr.get(a).add(b);
    			arr.get(b).add(a);
    					
    		}
    		//System.out.print(arr);
    		
    		//dfs
    		visited=new int[v+1];
    		
    		for(int i=1;i<=v;i++) {
    			if(visited[i]==0) {
    				dfs(i,true);
    			}
    		}
    		
    		
    		
    		//결과 프린트
    		int cnt=0;
    		for(int i=1;i<=v;i++) {
    			if(cut[i]==1) {
    				cnt++;
    			}
    		}
    		System.out.println(cnt);
    		for(int i=1;i<=v;i++) {
    			if(cut[i]==1) {
    				System.out.print(i+" ");
    			}
    		}
    		
    		
    		
    }
    
    static int order=1;//방문 순서
    static int[] cut;//단절점 표시
    
    static int dfs(int vertax,boolean isRoot) {
    	visited[vertax]=order;// 방문 순서 업뎃
    	order++;
    	
    	int ret=visited[vertax];
    	int child=0;
    	//System.out.println(Arrays.toString(visited));
    	//자식 정점 탐색
    	for(int now:arr.get(vertax)) {
    		if(visited[now]==0) {//자식 정점이 방문되지 않았을 때
    			child++;
    			
    			//자식 정점 중 순서가 가장 빠른 값
    			int low=dfs(now,false);
    			
    			//루트 정점이 아니고, 
    			//가장 작은 방문 순서(low)가 vertax의 방문 순서 보다 크거나 같을 경우
    			//단절점
    			if(isRoot==false&&low>=visited[vertax]) {
    				cut[vertax]=1;
    			}
    			
    			ret=Math.min(ret, low);
    			
    		}else {
    			ret=Math.min(ret,visited[now]);
    		}
    	}
    	//루트 정점이고 자식의 개수가 2개 이상이면 단절점
    	if(isRoot&&child>=2) {
    		cut[vertax]=1;
    	}
    	
    	return ret;
    }
    
    
  }
    	
