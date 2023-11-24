def solution(bandage, health, attacks):
    answer = 0
    
    last=attacks[len(attacks)-1][0]
    j=0
    cnt=0
    full=health
    for i in range(1,last+1):
        if attacks[j][0]==i:
            health=health-attacks[j][1]
            j+=1
            cnt=0
        else:
            cnt+=1
            if cnt == bandage[0]:
                health+=bandage[1]
                health+=bandage[2]
                cnt=0
            else:                
                health+=bandage[1]
            
            if health > full:
                health = full
        
        if health <=0:
            return -1
            
    answer=health
    
    return answer
