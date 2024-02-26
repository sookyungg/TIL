import java.util.*;
import java.io.*;



class Main {
  
    static int n,m;
    static int cmd,a,b;
    static int[] parent=new int[1000001];
   
    public static void main(String[] args) throws IOException {
    	
    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		
    		n=Integer.parseInt(st.nextToken());
	    	m=Integer.parseInt(st.nextToken());
	    	
	    	//배열 초기화
	    	for(int i=0;i<=n;i++) {
	    		parent[i]=i;
	    	}	    	
	    	
	    	for(int i=0;i<m;i++) {
	    		st=new StringTokenizer(br.readLine());
	    		cmd=Integer.parseInt(st.nextToken());
	    		a=Integer.parseInt(st.nextToken());
	    		b=Integer.parseInt(st.nextToken());
	    		
	    		if(cmd==0) {//합집합
	    			
	    			union(a,b);
	    			
	    			
	    		}
	    		else if(cmd==1) {//같은 집합인가요?
	    			
	    			if(isSameParent(a,b)) {
	    				System.out.println("YES");
	    			}else {
	    				System.out.println("NO");
	    			}
	    			
	    			
	    			
	    		}
	    		
	    	}
    		
    	}
    	
    	
    	static void union(int x, int y) {
    		x=find(x);
    		y=find(y);
    		
    		// 같은 부모 가지고 있지 않을때 연결 해줌
    		if(x!=y) {
    			if(x<y) {
    				parent[y]=x;
    			} else parent[x]=y;
    		}
    	}
    
    	static int find(int x) {
    		if(x==parent[x]) {
    			return x;
    		}
    		else 
    			return parent[x]=find(parent[x]);
    	}
    	
    	static boolean isSameParent(int x, int y) {
    		x=find(x);
    		y=find(y);
    		
    		if(x==y) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    
  }
    	
    
    
    

