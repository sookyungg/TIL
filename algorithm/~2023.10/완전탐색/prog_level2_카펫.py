
def solution(brown, yellow):
    answer = []
    xy_sum = (brown - 4)//2 
    
    for i in range(1,xy_sum):
        x,y = i, xy_sum-i
        if x * y == yellow:
            answer = [x+2,y+2]
    
    return answer

'''ver.이분탐색'''
def solution(brown, yellow):
    answer = []
    n = (brown -4)//2
    start =1
    end = int(n**1/2)+1
    
    while start<=end:
        mid = (start + end)//2
        target = mid*(n-mid)
        
        if target == yellow:
            return [n-mid+2, mid+2]
        elif target > yellow:
            end = mid-1
        else:
            start = mid+1