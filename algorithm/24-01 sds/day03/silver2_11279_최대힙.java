import java.util.*;
import java.io.*;


class Main {
  
    static int n;
    
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
        
    	n=Integer.parseInt(st.nextToken());
    	PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    	
    	
    	for(int i=0;i<n;i++) {
    		st=new StringTokenizer(br.readLine());
    		int cmd=Integer.parseInt(st.nextToken());
    		
    		if(cmd==0) {
    			//가장 작은 값 출력
    			if(maxHeap.isEmpty()) {
    				System.out.println(0);
    			}
    			else {
    				System.out.println(maxHeap.poll());
    			}
    		}
    		else {
    			//값 추가
    			maxHeap.add(cmd);
    		}
    	}
    	
    }
    
    
}
