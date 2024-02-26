import java.util.*;
import java.io.*;


public class Main {
    
	
	static String n,m;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        n=st.nextToken();
        st = new StringTokenizer(br.readLine());
        m=st.nextToken();
        
        
        
        int[][] dp=new int[n.length()+1][m.length()+1];
        int answer=0;
        
        for (int i = 1; i <= n.length(); i++) {
			for (int j = 1; j <= m.length(); j++) {
				if (n.charAt(i-1) == m.charAt(j-1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
        
//        for(int i=0;i<m.length();i++) {
//            System.out.println(Arrays.toString(dp[i]));
//            }
		
        
        int x=n.length();
        int y=m.length();
        
        String ans="";
        
        while(x!=0&&y!=0) {
        	
        	if (dp[x - 1][y] == dp[x][y]) { // 왼쪽값과 같다
				x -= 1;
			} else if (dp[x][y - 1] == dp[x][y]) { // 윗쪽값과 같다.
				y -= 1;
			}else {
				if(n.charAt(x-1)==m.charAt(y-1)) {
	        		ans+=n.charAt(x-1);
	        		
	        	}
				x-=1;
				y-=1;
			}
        }
        
        
        
        
        
        if(dp[n.length()][m.length()]!=0) {
        	System.out.println(dp[n.length()][m.length()]);
        	for(int i=ans.length()-1;i>=0;i--) {
        		System.out.print(ans.charAt(i));
        	}
        } 
        else System.out.println(0);
        
        //System.out.println(ans);
        
        }

    }

