'''
처음에 포문 두번 돌렸다가 시간 초과 실패!
sort 안해서 테스트 케이스 몇개 실패 했었음 ;-;
'''
def solution(phone_book):
    answer = True
    
    phone_book.sort()
    # 같은 문자(숫자) 기준으로 정렬 됐기 때문에, 앞 뒤만 비교하면 됨!
    for i in range(len(phone_book)-1):
        nl = len(phone_book[i])          
        if phone_book[i+1][0:nl] == phone_book[i]:
            answer=False
            break

    
    return answer



