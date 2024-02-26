import java.util.*;
import java.io.*;


class Main {
  
    static int n;
    
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
        
    	n=Integer.parseInt(st.nextToken());
    	Queue<Integer> q=new LinkedList<Integer>();
    	
    	int last=0;
    	for(int i=0;i<n;i++) {
    		st=new StringTokenizer(br.readLine());
    		String cmd=st.nextToken();
    		//System.out.print(cmd);
    		if(cmd.equals("push")) {
    			last=Integer.parseInt(st.nextToken());
    			q.offer(last);
    		}
    		else if (cmd.equals("pop")) {
    			if(q.size()>0) {
    			int e=q.poll();
    			System.out.print(e+"\n");
    			}
    			else {
    				System.out.print(-1+"\n");
    			}
    		}
    		else if(cmd.equals("size")) {
    			System.out.print(q.size()+"\n");
    		}
    		else if(cmd.equals("empty")) {
    			if(q.size()>0) {
    				System.out.print(0+"\n");
    			}
    			else {
    				System.out.print(1+"\n");
    			}
    		}
    		else if(cmd.equals("front")) {
    			if(q.size()>0) {
    				System.out.print(q.peek()+"\n");
    			}
    			else {
    				System.out.print(-1+"\n");
    			}
    		}
    		else if(cmd.equals("back")) {
    			if(q.size()>0) {
    				System.out.print(last+"\n");
    			}
    			else {
    				System.out.print(-1+"\n");
    			}
    		}
    		
    		
    	}

    
    }
    
    
}
