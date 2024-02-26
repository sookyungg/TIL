import java.util.*;
import java.io.*;


class Main {
  
    
    static int n,h;
    public static void main(String[] args) throws IOException {
    	
    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		n=Integer.parseInt(st.nextToken());
    		h=Integer.parseInt(st.nextToken());
    		
    		int[] bot=new int[h+1];
    		int[] top=new int[h+1];
    		int[] result=new int[h+1];
    		
    		// 장애물 높이별로 count 배열 생성
    		for(int i=0;i<n;i++) {
    			st=new StringTokenizer(br.readLine());
    			int wall=Integer.parseInt(st.nextToken());
    			if (i%2==0) {
    				bot[wall]+=1;
    				
    			}
    			else {
    				top[wall]+=1;
    			}
    			
    		}
    		
    		//System.out.println(Arrays.toString(bot));
    		//System.out.println(Arrays.toString(top));
    		
    		// 누적 합 
    		for(int i=h-1;i>0;i--) {
    			bot[i]+=bot[i+1];
    			top[i]+=top[i+1];
    		}
    		for(int i=0;i<(h+1)/2;i++) {
    			int tmp=top[i];
    			top[i]=top[h-i];
    			top[h-i]=tmp;
    		}
    		
    		
    		//System.out.println(Arrays.toString(bot));
    		//System.out.println(Arrays.toString(top));
    		
    		for(int i=1;i<h+1;i++) {
    			result[i]=bot[i]+top[i-1];
    		}
    		//System.out.println(Arrays.toString(result));
    		int min=200000;
    		int cnt=0;
    		for(int i=1;i<h+1;i++) {
    			if (result[i]<min) {
    				min=result[i];
    				cnt=1;
    			}
    			else if(result[i]==min) {
    				cnt+=1;
    			}
    		}
    		System.out.print(min+" ");
    		System.out.print(cnt);
    		
    	}
    }
    
    

