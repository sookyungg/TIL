def solution(n):
    ans = 0
    
    while n!=0:
        if n%2==1:
            ans+=1
            n-=1
        else:
            n=n//2
    
    return ans