import java.util.*;
import java.io.*;


class Main {
  
    static int n,k;
    
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
        
    	n=Integer.parseInt(st.nextToken());
    	k=Integer.parseInt(st.nextToken());
    	
    	int cnt=0;
    	ArrayList<Integer> arr=new ArrayList<Integer>();
    	for(int i=2;i<=n;i++) {
    		arr.add(i);
    	}
    	
    	//System.out.println(arr);
    	
    	int[] check=new int[n+1];
    	int tmp=0;
    	for (int i=0; i<arr.size();i++) {
    		if(check[i]!=1) {
    			check[i]=1;
    			tmp=arr.get(i);
    			cnt++;
    		}
    		if(cnt==k) {
				System.out.println(tmp);
				return;
			}
    		for(int j=i;j<arr.size();j++) {
    			if(check[j]!=1&&arr.get(j)%arr.get(i)==0) {
    				check[j]=1;
    				tmp=arr.get(j);
    				cnt++;
    			}
    			if(cnt==k) {
    				System.out.println(tmp);
    				return;
    			}
    		}
    	}
    	
    	
    }
    
}