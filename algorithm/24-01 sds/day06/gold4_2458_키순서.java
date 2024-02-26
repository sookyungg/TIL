import java.util.*;
import java.io.*;



class Main {
  
    static int n,m;
    static int s1,s2;
    //DFS 두번하는 방법도 있음 간선 방향 바꿔서 
   
    public static void main(String[] args) throws IOException {
    	
    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		
    		n=Integer.parseInt(st.nextToken());
    		m=Integer.parseInt(st.nextToken());
    		int MAX=n*(n-1)/2;
    		int[][] student=new int[n][n];
    		for(int i=0;i<n;i++) {
    			for(int j=0;j<n;j++) {
    				student[i][j]=MAX;
    			}
    		}
    		
    		
    		for (int i=0;i<m;i++) {
    			st=new StringTokenizer(br.readLine());
    			s1=Integer.parseInt(st.nextToken());
    			s2=Integer.parseInt(st.nextToken());
    			
    			student[s1-1][s2-1]=1;
    		}
    		
    		for(int k=0; k<n;k++) {
    			for(int i=0;i<n;i++) {
    				for(int j=0;j<n;j++) {
    					if(student[i][j]>student[i][k]+student[k][j]) {
    						student[i][j] = student[i][k] + student[k][j];
    					}
    				}
    			}
    		}
    		
    		
    		int result = 0;
            for(int i = 0; i < n; i++) {
                int count = 0;
                for(int j = 0; j < n; j++) {
                    if(student[i][j] < MAX || student[j][i] < MAX) count++;
                }
                if(count == n - 1) result++;
            }
            
            System.out.println(result);
    		
    	}
    	
    	
    
  }
    	
    
    
    

