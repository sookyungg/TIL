def solution(sequence, k):
    max_sum = 0
    n = len(sequence)
    idx_min = n
    end = 0
    
    for start in range(n):
        while max_sum < k and end < n:
            max_sum += sequence[end]
            end += 1
        if max_sum == k and end - 1 -start < idx_min:
            answer = [start, end -1]
            idx_min = end - 1 - start
        max_sum -= sequence[start]
        
    return answer