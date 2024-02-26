import java.util.*;
import java.io.*;


class Main {
  
    static int r,c;
    static Character[][] map;
    
    static int[] dx= {-1,1,0,0};
    static int[] dy= {0,0,-1,1};

    
    static Queue<int[]> q = new LinkedList<>();
    static Queue<int[]> water = new LinkedList<>();
    static int answer=Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str=br.readLine().split(" ");
        r = Integer.parseInt(str[0]);  // 헹
        c= Integer.parseInt(str[1]);  // 열
        
        map = new Character[r][c];
        
        for(int i=0;i<r;i++) {
        	String s=br.readLine();
        	for(int j=0;j<c;j++) {
        		map[i][j]=s.charAt(j);
        		if(map[i][j]=='S') {//고슴도치
        			q.add(new int[] {i,j,0});
        		}else if(map[i][j]=='*') {
        			water.add(new int[] {i,j});
        		}
        	}
        }
        
        bfs();
        System.out.println(answer==Integer.MAX_VALUE?"KAKTUS":answer);


    }

    public static void bfs() {

        while (!q.isEmpty()) {
            // 물 퍼뜨림
            int len = water.size();
            for(int i=0;i<len;i++){
                int[] t = water.poll();
                int x = t[0];
                int y = t[1];
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny]=='.') {
                        map[nx][ny] = '*';
                        water.add(new int[]{nx,ny});
                    }
                }
            }

            // 고슴도치 이동
            len = q.size();
            for(int i=0;i<len;i++){
                int[] t = q.poll();
                int x = t[0];
                int y = t[1];
                int time = t[2];
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                        if(map[nx][ny]=='D'){
                            answer=Math.min(answer,time+1);
                            return;
                        }else if(map[nx][ny]=='.'){
                            map[nx][ny] = 'S';
                            q.add(new int[]{nx,ny,time+1});
                        }
                    }
                }
            }
        }
    }
}