import java.util.*;
import java.io.*;


class Main {
  
    static int n,m;
    static int a,b,c;
    
    static int[][] cities;
    
    static ArrayList<ArrayList<ArrayList<Integer>>> arr=new ArrayList<>();
   
    public static void main(String[] args) throws IOException {
    	
    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st=new StringTokenizer(br.readLine());
  
    		//init
    		n=Integer.parseInt(st.nextToken());//도시의 개수
    		st=new StringTokenizer(br.readLine());
    		m=Integer.parseInt(st.nextToken());//버스의 개수
    		
    		cities=new int[n+1][n+1];
    		
    		for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(i==j) continue;
					cities[i][j]=Integer.MAX_VALUE;
				}
				
			}
    		
    		for(int i=0;i<m;i++) {
    			//a->b, 비용:c
    			st=new StringTokenizer(br.readLine());
    			a=Integer.parseInt(st.nextToken());
    			b=Integer.parseInt(st.nextToken());
    			c=Integer.parseInt(st.nextToken());
    			
    			//cities[a][b]=c;
    			
    			if(cities[a][b] > c) {
                    cities[a][b] = c;
                }
    		}
    		
    		//floyd
    		for(int k=1;k<=n;k++) {
    			for(int i=1;i<=n;i++) {
    				//if(cities[i][k]==Integer.MAX_VALUE) continue;
    				for(int j=1;j<=n;j++) {
    					if(cities[k][j]==Integer.MAX_VALUE||cities[i][k]==Integer.MAX_VALUE) 
    						continue;
    					
    					if(cities[i][k]+cities[k][j]<cities[i][j]) {
    						cities[i][j]=cities[i][k]+cities[k][j];
    					}
    				}
    			}
    		}
    		
    		for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(cities[i][j]==Integer.MAX_VALUE) System.out.print(0+" ");
					else System.out.print(cities[i][j]+" ");
				}
				System.out.println();
			}
    		
    }
    
    
    
  }
    	
    
    
    

