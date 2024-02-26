def solution(n, computers):
    answer = 0
    visited = [0] * n
    
    def dfs(pc):
        visited[pc] = 1
        for idx, c in enumerate(computers[pc]):
            if c and visited[idx] == 0:
                dfs(idx)
                
    for pc in range(n):
        if visited[pc] == 0:
            dfs(pc)
            answer +=1
    
    return answer

from collections import deque
def solution(n, computers):
    answer = 0
    visited = [0]*n
    
    def bfs(start, visited, computers):
        visited[start] = 1
        queue = deque([start])
        while queue:
            v = queue.popleft()
            for i in range(n):
                if computers[v][i] == 1 and visited[i] == 0:
                    visited[i] = 1
                    queue.append(i)
    for i in range(n):
        if visited[i] == 0:
            bfs(i, visited, computers)
            answer += 1
        
        
    return answer