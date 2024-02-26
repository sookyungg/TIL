def solution(answers):
    answer = []
    l=len(answers)
    #  1번 수포자
    s1 = [1,2,3,4,5] * (l//5+1)
    #2번 수포자
    s2 = [2,1,2,3,2,4,2,5] *(l//8 + 1)
    #3번 수포자
    s3 = [3,3,1,1,2,2,4,4,5,5] *(l//10+1)
    
    c1,c2,c3=0,0,0
    
    for i in range(l):
        if s1[i] == answers[i]:
            c1+=1
        if s2[i] == answers[i]:
            c2+=1
        if s3[i] == answers[i]:
            c3+=1
            
    ans_arr=[0,c1,c2,c3]
    ans_max = max(ans_arr)

    if ans_max == 0:
        answer=[]
    else:
        for i in range(4):
            if ans_max == ans_arr[i]:
                answer.append(i)

    return answer