import java.io.*;
import java.util.*;

class Main {
	static class Node{
		int idx;
		int cost;
		public Node(int idx,int cost){
			this.idx=idx;
			this.cost=cost;
		}

	}

	static int[] visited;
	static int[] distance;
	static int v,e,k;
	static ArrayList<ArrayList<Node>> graph=new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		v=Integer.parseInt(st.nextToken());
		e=Integer.parseInt(st.nextToken());

		st=new StringTokenizer(br.readLine());
		k=Integer.parseInt(st.nextToken());

		visited=new int[v+1];
		distance=new int[v+1];
		Arrays.fill(distance,Integer.MAX_VALUE);

		for(int i=0;i<v+1;i++){
			graph.add(new ArrayList<>());
		}

		for(int i=0;i<e;i++){
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			graph.get(start).add(new Node(end,weight));
		}
		dijkstra();


		for(int i=1;i<=v;i++){
			if(distance[i]==Integer.MAX_VALUE){
				System.out.println("INF");
			}
			else{
				System.out.println(distance[i]);
			}
		}
	}

	static void dijkstra(){
		//cost가 낮은 것이 우선순위가 높다.
		PriorityQueue<Node> pq=new PriorityQueue<>((o1,o2)->o1.cost- o2.cost);
		distance[k]=0;
		pq.add(new Node(k,0));

		while(!pq.isEmpty()){
			Node currentNode=pq.poll();
			if(visited[currentNode.idx]==1){
				continue;
			}
			visited[currentNode.idx]=1;

			for(Node next: graph.get(currentNode.idx)){
				int nextidx= next.idx;
				int nextcost=next.cost;
				if(visited[nextidx]==0&&distance[nextidx]>nextcost+distance[currentNode.idx]){
					distance[nextidx]=nextcost+distance[currentNode.idx];
					pq.add(new Node(nextidx,distance[nextidx]));
				}
			}

		}

	}
}
