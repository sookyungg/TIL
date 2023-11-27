def solution(numbers, target):
    answer = 0
    n=len(numbers)
    
    def dfs(idx,numbers):
        answer=0
        if n==idx:
            if sum(numbers)==target:
                return 1
            else:
                return 0
        
        answer+=dfs(idx+1, numbers)
        numbers[idx]*=-1
        answer+=dfs(idx+1,numbers)
        return answer
    
    answer=dfs(0,numbers)
    
    return answer