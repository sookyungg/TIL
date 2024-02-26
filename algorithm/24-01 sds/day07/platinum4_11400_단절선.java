import java.util.*;
import java.io.*;

class Node{
	int x;
	int y;
	Node(int x,int y){
		this.x=x;
		this.y=y;
	}
}


class Main {
  
    static int v,e;
    static int a,b;
    static int[] order;
    static ArrayList<Node> ans;
   
    public static void main(String[] args) throws IOException {
    	
    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		
    		v=Integer.parseInt(st.nextToken());
    		e=Integer.parseInt(st.nextToken());
    		
    		ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
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
    		
    		order=new int[v+1];
    		ans=new ArrayList<>();
    		
    		for(int i=1;i<v;i++) {
    			if(order[i]==0) {
    				dfs(i,0,arr);
    			}
    		}
    		
    		Collections.sort(ans, (a1,a2)->(a1.x==a2.x)? a1.y-a2.y:a1.x-a2.x);
    		System.out.println(ans.size());
    		for(int i=0;i<ans.size();i++) {
    			System.out.println(ans.get(i).x+" "+ans.get(i).y);
    		}
    		
    }
    static int count=1;
    static int dfs(int vertax, int parent,ArrayList<ArrayList<Integer>> arr) {
    	order[vertax]=count++;
    	int ret = order[vertax];//초기 값음 방문 순서
    	
    	//자식 검사
    	for(int now:arr.get(vertax)) {
    		//내가 온길은 제외한다.
    		if(now==parent) {
    			continue;
    		}
    		if(order[now]==0) {//자식 정점이 방문되지 않았을 경우
    			//자식 정점 중 방문순서가 가장 빠른 값
    			// 이때, 특정 자식 정점이 여러 개의 정점을 타고 타고 올라가서 1번 정점까지
                // 갈 수도 있다는 점에 유의해야 함.
    			 int low = dfs(now, vertax, arr);
    			// 가장 작은 방문 순서가 vertax의 방문 순서보다 크거나 같을 경우
                 // 해당 edge는 단절선임.
                 // 다만 시작점은 더 작은 값이 오게 하기 위하여
                 // now와 vertax중 더 작은 값을 시작점으로 설정함.
    			 if(low>order[vertax]) {
    				 if(now>vertax) {
    					 ans.add(new Node(vertax,now));
    				 }else {
    					 ans.add(new Node(now,vertax));
    				 }
    			 }
    			 ret=Math.min(ret, low);
    		}else {// 자식 정점이 방문되었을 경우
    			ret=Math.min(ret, order[now]);
    		}
    	}
    	return ret;
    	
    }
    	
    
  }
    	
    
    
    

