from itertools import permutations

def solution(k, dungeons):
    # 탐험 가능한 최대 던전 수를 저장하는 변수
    max_dungeons_explored = 0

    # 가능한 모든 던전 순서 조합에 대해 반복
    for perm in permutations(dungeons, len(dungeons)):
        # 현재 유저의 남은 피로도
        remaining_stamina = k

        # 현재 조합에서 탐험한 던전 수를 저장하는 변수
        dungeons_explored = 0

        # 각 던전에 대해 반복
        for dungeon in perm:
            # 해당 던전을 탐험할 수 있는지 확인 (최소 필요 피로도 이상인지)
            if dungeon[0] <= remaining_stamina:
                # 던전을 탐험하면 소모되는 피로도 차감
                remaining_stamina -= dungeon[1]
                
                # 만약 피로도가 0 미만이 되면 더 이상 탐험할 수 없으므로 반복 종료
                if remaining_stamina < 0:
                    break

                # 던전을 탐험했으므로 카운트 증가
                dungeons_explored += 1
            else:
                # 만약 현재 던전을 탐험할 수 없다면 더 이상 탐험할 수 없으므로 반복 종료
                break

        # 현재 조합에서 탐험한 던전 수와 이전 최대값을 비교하여 더 큰 값을 저장
        max_dungeons_explored = max(max_dungeons_explored, dungeons_explored)

    return max_dungeons_explored
