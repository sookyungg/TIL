def solution(N, number):
    answer = -1
    DP = []
    # 1. [ SET x 8 ] 초기화
    # 2. 각 set마다 기본 수 "N" * i 수 초기화
    # 3. n 일반화
    #   { 
    #       "n" * i U 
    #       1번 set 사칙연산 n-1번 set U
    #       2번 set 사칙연산 n-2번 set U
    #       ...
    #       n-1번 set 사칙연산 1번 set, 
    #    } 
    # number를 가장 최소로 만드는 수 구함.
    
    for i in range(1, 9):
        numbers = set()
        numbers.add( int(str(N) * i) )

        for j in range(0, i-1):
            for x in DP[j]:
                for y in DP[-j-1]:
                    numbers.add(x + y)
                    numbers.add(x - y)
                    numbers.add(x * y)
                    
                    if y != 0:
                        numbers.add(x // y)

        if number in numbers:
            answer = i
            break
        
        DP.append(numbers)

    return answer