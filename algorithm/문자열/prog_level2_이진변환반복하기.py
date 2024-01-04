def solution(s):
    answer = []
    cnt=0
    zero=0
    while s!='1':
        cnt+=1
        zero += s.count("0")
        s=s.replace('0','')
        s = bin(len(s))[2:]
        
    answer=[cnt, zero]
    
    return answer