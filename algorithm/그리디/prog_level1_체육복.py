def solution(n, lost, reserve):
    answer = 0
    suit={i+1:1 for i in range(n)}
    
    for l in lost:
        suit[l]-=1
    for r in reserve:
        suit[r]+=1
        
    for s in suit:
        if suit[s] == 0: 
            if s-1>0 and suit[s-1]==2: # 앞에서 부터 빌려옴
                suit[s]+=1
                suit[s-1]-=1
            if s+1<=len(suit) and suit[s]==0 and suit[s+1]==2: # 그래도 못빌리면 뒤 확인
                suit[s]+=1
                suit[s+1]-=1
    
    cnt=0
    for s in suit:
        if suit[s]>0:
            cnt+=1
    answer=cnt
    return answer