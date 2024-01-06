def solution(n):
    answer = n
    bin_n = bin(n)[2:]
    n1=0
    for i in range(len(bin_n)):       
        if bin_n[i] =='1':
            n1+=1
    
    while True:
        answer+=1
        bin_ans = bin(answer)[2:]
        ans1=0
        for i in range(len(bin_ans)):       
            if bin_ans[i] =='1':
                ans1+=1
        if ans1==n1:
            break
        
    return answer