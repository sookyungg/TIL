import java.util.*;
import java.io.*;



class Main {
  
    static int n,k;
    static HashSet<String> num=new HashSet<>();
    static int[] visited;
    static ArrayList<String> card=new ArrayList<>();
   
    public static void main(String[] args) throws IOException {
    	
    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		
    		n=Integer.parseInt(st.nextToken());
    		st=new StringTokenizer(br.readLine());
	    	k=Integer.parseInt(st.nextToken());
	    	visited=new int[n];
	    	
	    	
	    	for(int i=0;i<n;i++) {
	    		st=new StringTokenizer(br.readLine());
	    		card.add(st.nextToken());
	    	}

    		choose(k,"");
    		
    		System.out.print(num.size());
    	}
    
    
    static void choose(int cur,String k) {
    	if (cur==0) {
    		num.add(k);
    		return;
    	}
    	for(int i=0;i<n;i++) {
    		if(visited[i]!=1) {
    			visited[i]=1;
    			choose(cur-1,k+card.get(i));
    			visited[i]=0;
    		}
    	}
    	
    	
    }
    	
   
  }
    	
    
    
    

