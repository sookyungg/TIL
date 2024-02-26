'''복습'''
from collections import deque

def solution(maps):
    answer = 0
    dx=[-1,1,0,0]
    dy=[0,0,-1,1]
    q=deque()
    q.append((0,0))
    
    n = len(maps)
    m = len(maps[0])
    
    while q:
        x,y=q.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx<0 or ny<0 or nx>=n or ny>=m:
                continue
            if maps[nx][ny] == 1:
                maps[nx][ny]=maps[x][y]+1
                q.append((nx,ny))
                
    answer = maps[n-1][m-1]
            
    if answer == 1:
        answer = -1
    
    return answer