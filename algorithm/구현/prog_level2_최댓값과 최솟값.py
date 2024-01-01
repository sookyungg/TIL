def solution(s):
    answer = ''
    
    arr=list(map(int, s.split(" ")))
    
    max_num=max(arr)
    min_num=min(arr)
    
    answer=str(min_num)+' '+str(max_num)
    
    return answer