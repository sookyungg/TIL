def solution(n, words):
    answer = []
    right=[]
    
    for i in range(len(words)):
        if i == 0:
            right.append(words[i])
        elif right[-1][len(right[-1])-1]!=words[i][0]:
            break
        elif words[i] in right:
            break
        else:
            right.append(words[i])
    
    if len(right) == len(words):
        answer=[0,0]
    else:
        person=(len(right)+1)%n
        if person ==0:
            person = n
        turn = (len(right)+1)//n + 1        
        if (len(right)+1)%n ==0:
            turn = (len(right)+1)//n
        answer=[person, turn]
        
    return answer