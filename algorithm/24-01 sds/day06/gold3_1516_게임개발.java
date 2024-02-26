import java.util.*;
import java.io.*;



class Main {
  
    static int n;
    static int a,b,c;
   
    public static void main(String[] args) throws IOException {
    	
    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		
    		n=Integer.parseInt(st.nextToken());
    		
    		
    		//[[],[],[]....]
	    	ArrayList<Integer>[] list=new ArrayList[n+1];
	    	for(int i=0;i<=n;i++) {
	    		list[i]=new ArrayList<Integer>();
	    	}
	    	
	    	
	    	int[] time=new int[n+1];
	    	int[] degree=new int[n+1];
	    	
    		for(int i=1;i<n+1;i++) {
    			st=new StringTokenizer(br.readLine());
    			time[i]=Integer.parseInt(st.nextToken());
    			while(true) {
    				b=Integer.parseInt(st.nextToken());
    				if (b==-1) break;
    				list[b].add(i);
    				degree[i]++;
    				
    			}
	    	}
    		
    		
    		Deque<Integer> queue=new ArrayDeque<>();
    		for(int i=1;i<n+1;i++) { // 먼저 지어야할 건물이 없는 건물을 큐에 집어 넣음.
    			if(degree[i]==0) {
    				queue.add(i);
    			}
    		}
    		
    		int[] res=new int[n+1];
    		
    		while(queue.size()!=0) {
    			int now=queue.removeFirst();

    			for(int next:list[now]) {
	    			degree[next]--;
	    			
	    			// next 건물을 짓기 전까지 걸린 시간 계산.
	    			res[next]=Math.max(time[now]+res[now], res[next]);
	    			if(degree[next]==0) {
	    				queue.add(next);
	    				
	    			};
	    		}
    			
    		}
    		
    		//System.out.println(Arrays.toString(res));
    		//System.out.println(Arrays.toString(time));
    		
    		
    		for(int i=1;i<=n;i++) {
    			System.out.print(res[i]+time[i]+"\n");
    		}
    		
    	}
    	
    	
    
  }
    	
    
    
    

