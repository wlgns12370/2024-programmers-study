import heapq

def solution(scoville:list, K:int) -> int:
    heapq.heapify(scoville)
    answer = 0
    while scoville[0] < K and len(scoville) > 1:
        heapq.heappush(scoville, heapq.heappop(scoville)+heapq.heappop(scoville)*2)
        answer += 1
    
    if min(scoville) < K:
        answer = -1
    return answer