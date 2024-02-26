from collections import deque

def solution(maps):
    answer = 0
    
    #상하좌우
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    def bfs(x,y):
        queue = deque()
        queue.append((x,y))
        
        while queue:
            x, y = queue.popleft()
            
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                
                #범위 벗어나면
                if nx < 0 or ny < 0 or nx >= len(maps) or ny >= len(maps[0]):
                    continue
                #벽이면 무시    
                if maps[nx][ny] == 0:
                    continue
                #방문했을 때 거리 계산
                if maps[nx][ny] == 1:
                    maps[nx][ny] = map[x][y] +1
                    queue.append((nx, ny))
        # 가장 끝점 까지 가는 길이            
        return maps[len(maps)-1][len(maps[0])-1]
    
    answer = bfs(0,0)
    if answer == 1:
        answer = -1
    return answer



