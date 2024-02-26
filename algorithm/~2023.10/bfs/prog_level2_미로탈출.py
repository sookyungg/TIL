from collections import deque
def solution(maps):
    answer = 0
    # S: 시작 지점, E: 출구, L: 레버, O: 통로, X: 벽
    n, m = len(maps), len(maps[0])
    
    # 시작 지점, 출구, 레버 찾기
    for x in range(n):
        for y in range(m):
            if maps[x][y] == "S":
                sx, sy = x, y
            elif maps[x][y] == "E":
                ex, ey = x, y
            elif maps[x][y] == "L":
                lx, ly = x, y
     
    target = [(lx, ly), (ex, ey)]
    
    # 상하좌우 방향
    direction = [(-1, 0), (1, 0), (0, 1), (0, -1)]
    
    # BFS 2번 진행 (레버, 출구)
    for idx in range(2):
        tx, ty = target[idx]
        
        q = deque()
        q.append((sx, sy, 0))

        visited = [[False]*m for _ in range(n)]

        visited[sx][sy] = True

        while q:
            x, y, level = q.popleft()
            
            if x == tx and y == ty:
                answer += level
                break

            for dx, dy in direction:
                nx, ny = x+dx, y+dy
                if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == False and maps[nx][ny] != "X":
                    q.append((nx, ny, level+1))
                    visited[nx][ny] = True
                    
        else:
            answer = 0
        
        if not answer:
            break
        sx, sy = lx, ly
        
    
    if not answer:
        return -1
    
    return answer