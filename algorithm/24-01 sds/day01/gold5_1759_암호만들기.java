import java.util.*;
import java.io.*;


class Main {
  
    static String[] pwd,alpha;
    static int L,C;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str=br.readLine().split(" ");
        L = Integer.parseInt(str[0]);  //암호 길이
        C= Integer.parseInt(str[1]);  // 문자 개수
        
        
       pwd = new String[L];
       alpha = new String[C];
       
       alpha=br.readLine().split(" ");
       Arrays.sort(alpha);
       
       dfs(0,0);
               
    }
    
    static void dfs(int cnt, int idx) {
    	if(cnt==L) {
    		if(check(pwd)) {
    			for(String p: pwd) {
    				System.out.print(p);
    			}
    			System.out.print("\n");
    		}
    		return;
    	}
    	for (int i=idx;i<C;i++) {
    		pwd[cnt]=alpha[i];
    		dfs(cnt+1,i+1);
    	}
    }
    
    static boolean check(String[] pwd) {
    	int a=0;//모음
    	int b=0;//자음
    	
    	
    	for(int i=0;i<pwd.length;i++) {
    		if(pwd[i].equals("a")||pwd[i].equals("e")||pwd[i].equals("i")||pwd[i].equals("o")||pwd[i].equals("u"))
				a++;
			else
				b++;
    	}
    	if(a>=1&&b>=2) return true;
    	else return false;
    }
}