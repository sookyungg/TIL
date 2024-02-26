import java.util.*;
import java.io.*;


class Main {
  
    static int n;
    
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
        
    	n=Integer.parseInt(st.nextToken());
    	ArrayList<Integer> stack=new ArrayList<Integer>();
    	
    	for(int i=0;i<n;i++) {
    		st=new StringTokenizer(br.readLine());
    		String cmd=st.nextToken();
    		//System.out.print(cmd);
    		if(cmd.equals("push")) {
    			int e=Integer.parseInt(st.nextToken());
    			stack.add(e);
    		}
    		else if (cmd.equals("pop")) {
    			if(stack.size()>0) {
    			System.out.print(stack.get(stack.size()-1)+"\n");
    			stack.remove(stack.size()-1);
    			}
    			else {
    				System.out.print(-1+"\n");
    			}
    		}
    		else if(cmd.equals("size")) {
    			System.out.print(stack.size()+"\n");
    		}
    		else if(cmd.equals("empty")) {
    			if(stack.size()>0) {
    				System.out.print(0+"\n");
    			}
    			else {
    				System.out.print(1+"\n");
    			}
    		}
    		else if(cmd.equals("top")) {
    			if(stack.size()>0) {
    				System.out.print(stack.get(stack.size()-1)+"\n");
    			}
    			else {
    				System.out.print(-1+"\n");
    			}
    		}
    		
    		
    	}

    
    }
    
    
}
