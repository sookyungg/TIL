#DFS    
cnt = 0
def dfs(idx, numbers, target, value):
    global cnt
    length = len(numbers)
    
    if idx == length and target == value:
        cnt += 1
        return 
    
    elif idx == length:
        return
        
    dfs(idx+1, numbers, target, value+numbers[idx])
    dfs(idx+1, numbers, target, value-numbers[idx])
        
def solution(numbers, target):
    global cnt 
    dfs(0, numbers, target, 0)
    
    return cnt