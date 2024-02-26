import java.util.*;
import java.io.*;



class Main {
  
    static int n,m;
    static int a,b;
   
    public static void main(String[] args) throws IOException {
    	
    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		
    		n=Integer.parseInt(st.nextToken());
	    	m=Integer.parseInt(st.nextToken());
	    	
	    	//[[],[],[]....]
	    	ArrayList<Integer>[] list=new ArrayList[n+1];
	    	
	    	for(int i=0;i<=n;i++) {
	    		list[i]=new ArrayList<Integer>();
	    	}
	    	
	    	// 그래프
	    	for(int i=0;i<m;i++) {
	    		st=new StringTokenizer(br.readLine());
	    		a=Integer.parseInt(st.nextToken());
	    		b=Integer.parseInt(st.nextToken());
	    		
	    		list[a].add(b);
	    	}
	    	
	    	//진입차수 
	    	int[] degree=new int[n+1];
	    	
	    	for(int i=1;i<=n;i++) {
	    		for(int j:list[i]) {
	    			degree[j]++;
	    		}
	    	}
	    	
	    	
	    	Deque<Integer> queue=new ArrayDeque<>();
	    	// 진입 차수가 0 이면 큐에 삽입
	    	for(int i=1;i<=n;i++) {
	    		if(degree[i]==0) {
	    			queue.add(i); 
	    		}
	    	}
	    	
	    	while(queue.size()!=0) {
	    		int vertex=queue.removeFirst();
	    		System.out.print(vertex + " ");
	    		
	    		
	    		for(int i:list[vertex]) {
	    			degree[i]--;
	    			if(degree[i]==0) queue.add(i);
	    		}
	    		
	    	}

	    	//System.out.print(Arrays.toString(list));
	    	
	    	
    		
    	}
    	
    	
    	
    
  }
    	
    
    
    

